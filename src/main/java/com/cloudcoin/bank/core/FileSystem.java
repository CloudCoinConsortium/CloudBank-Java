package com.cloudcoin.bank.core;

import com.cloudcoin.bank.utils.CoinUtils;
import com.cloudcoin.bank.utils.FileUtils;
import com.cloudcoin.bank.utils.Utils;
import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;

public class FileSystem {


    /* Fields */

    public static String RootPath = "C:\\CloudBank\\";


    public static String DetectedPath = File.separator + Config.TAG_DETECTED + File.separator;
    public static String SuspectPath = File.separator + Config.TAG_SUSPECT + File.separator;
    public static String ExportPath = File.separator + Config.TAG_EXPORT + File.separator;

    public static String BankPath = File.separator + Config.TAG_BANK + File.separator;
    public static String FrackedPath = File.separator + Config.TAG_FRACKED + File.separator;
    public static String CounterfeitPath = File.separator + Config.TAG_COUNTERFEIT + File.separator;
    public static String LostPath = File.separator + Config.TAG_LOST + File.separator;

    public static String ReceiptsPath = File.separator + Config.TAG_RECEIPTS + File.separator;
    public static String TrashPath = File.separator + Config.TAG_TRASH + File.separator;

    public static String LogsPath = File.separator + Config.TAG_LOGS + File.separator;


    public static String AccountFolder = RootPath + "accounts" + File.separator;
    public static String ChangeFolder = AccountFolder + "change";
    public static String PasswordFolder = AccountFolder + "Passwords" + File.separator;
    public static String ChecksFolder = RootPath + "checks" + File.separator;
    public static String LogsFolder = RootPath + LogsPath;


    public static String DetectedFolder;
    public static String SuspectFolder;
    public static String ExportFolder;

    public static String CounterfeitFolder;
    public static String BankFolder;
    public static String FrackedFolder;
    public static String LostFolder;

    public String TemplateFolder;

    public static ArrayList<CloudCoin> importCoins;
    public static ArrayList<CloudCoin> predetectCoins;

    public static ArrayList<CloudCoin> bankCoins;
    public static ArrayList<CloudCoin> frackedCoins;


    /* Constructor */

    public FileSystem(String RootPath) {
        this.RootPath = RootPath;

        DetectedFolder = RootPath + File.separator + Config.TAG_DETECTED + File.separator;
        SuspectFolder = RootPath + File.separator + Config.TAG_SUSPECT + File.separator;

        BankFolder = RootPath + BankPath;
        CounterfeitFolder = RootPath + FrackedPath;
        FrackedFolder = RootPath + File.separator + Config.TAG_FRACKED + File.separator;

        LogsFolder = RootPath + File.separator + Config.TAG_LOGS + File.separator;

        LostFolder = RootPath + File.separator + Config.TAG_LOST + File.separator;
        ExportFolder = RootPath + File.separator + Config.TAG_EXPORT + File.separator;
    }


    /* Methods */

    /**
     * Creates directories in the location defined by RootPath.
     *
     * @return true if all folders were created or already exist, otherwise false.
     */
    public static boolean createDirectories() {
        try {
            Files.createDirectories(Paths.get(RootPath));

            Files.createDirectories(Paths.get(AccountFolder));
            Files.createDirectories(Paths.get(PasswordFolder));
            Files.createDirectories(Paths.get(ChecksFolder));
            Files.createDirectories(Paths.get(LogsFolder));

            Files.createDirectories(Paths.get(ChangeFolder));
            Files.createDirectories(Paths.get(ChangeFolder + BankPath));
            Files.createDirectories(Paths.get(ChangeFolder + FrackedPath));
            Files.createDirectories(Paths.get(ChangeFolder + ExportPath));
        } catch (Exception e) {
            System.out.println("FS#CD: " + e.getLocalizedMessage());
            e.printStackTrace();
            return false;
        }

        return true;
    }



    /**
     * Load all CloudCoins in a specific folder.
     *
     * @param folder the folder to search for CloudCoin files.
     * @return an ArrayList of all CloudCoins in the specified folder.
     */
    public static ArrayList<CloudCoin> loadFolderCoins(String folder) {
        ArrayList<CloudCoin> folderCoins = new ArrayList<>();

        String[] filenames = FileUtils.selectFileNamesInFolder(folder);
        String extension;
        for (int i = 0, length = filenames.length; i < length; i++) {
            int index = filenames[i].lastIndexOf('.');
            if (index == -1) continue;

            extension = filenames[i].substring(index + 1);
            String fullFilePath = folder + filenames[i];

            switch (extension) {
                case "celeb":
                case "celebrium":
                case "stack":
                    ArrayList<CloudCoin> coins = FileUtils.loadCloudCoinsFromStack(fullFilePath);
                    coins.get(0).setFolder(folder);
                    folderCoins.addAll(coins);
                    break;
            }
        }

        return folderCoins;
    }

    /**
     * Deletes a file from a folder.
     *
     * @param folder     the folder to delete from.
     * @param filename   the file to delete.
     */
    public static void removeFile(String folder, String filename) {
        try {
            Files.deleteIfExists(Paths.get(folder + filename));
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }

    /**
     * Deletes CloudCoins files from a specific folder.
     *
     * @param cloudCoins the ArrayList of CloudCoins to delete.
     * @param folder     the folder to delete from.
     */
    public static void removeCoins(CloudCoin[] cloudCoins, String folder) {
        for (CloudCoin coin : cloudCoins) {
            try {
                Files.deleteIfExists(Paths.get(folder + CoinUtils.generateFilename(coin) + ".stack"));
            } catch (IOException e) {
                System.out.println(e.getLocalizedMessage());
                e.printStackTrace();
            }
        }
    }
    public static void removeCoins(ArrayList<CloudCoin> cloudCoins, String folder) {
        for (CloudCoin coin : cloudCoins) {
            try {
                Files.deleteIfExists(Paths.get(coin.getFullFilePath()));
                Files.deleteIfExists(Paths.get(folder + CoinUtils.generateFilename(coin) + ".stack"));
            } catch (IOException e) {
                System.out.println(e.getLocalizedMessage());
                e.printStackTrace();
            }
        }
    }

    /**
     * Writes an array of CloudCoins to a single Stack file.
     *
     * @param coins    the ArrayList of CloudCoins.
     * @param filePath the absolute filepath of the CloudCoin file, without the extension.
     */
    public static String writeCoinsToSingleStack(ArrayList<CloudCoin> coins, String filePath) {
        return writeCoinsToSingleStack(coins.toArray(new CloudCoin[0]), filePath);
    }
    public static String writeCoinsToSingleStack(CloudCoin[] coins, String filePath) {
        Gson gson = Utils.createGson();
        try {
            Stack stack = new Stack(coins);
            String json = gson.toJson(stack);
            if (filePath != null) {
                Path path = Paths.get(filePath);
                Files.createDirectories(path.getParent());
                System.out.println("1. wrote " + filePath);
                Files.write(path, json.getBytes(), StandardOpenOption.CREATE_NEW);
            }
            return json;
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
            return null;
        }
    }
    public static void writeCoinsToIndividualStacks(ArrayList<CloudCoin> coins, String filePath) {
        writeCoinsToIndividualStacks(coins.toArray(new CloudCoin[0]), filePath);
    }
    public static void writeCoinsToIndividualStacks(CloudCoin[] coins, String filePath) {
        Gson gson = Utils.createGson();
        try {
            for (CloudCoin coin : coins) {
                String filename = CoinUtils.generateFilename(coin);
                filename = FileUtils.ensureFilepathUnique(filename, ".stack", filePath);
                Stack stack = new Stack(coin);
                String json = gson.toJson(stack);
                if (filename != null) {
                    Path path = Paths.get(filename);
                    Files.createDirectories(path.getParent());
                    System.out.println("1. wrote " + filename);
                    Files.write(path, json.getBytes(), StandardOpenOption.CREATE_NEW);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }

    /**
     * Writes a CloudCoins a Stack file.
     *
     * @param coin     the ArrayList of CloudCoins.
     * @param filePath the absolute filepath of the CloudCoin file, without the extension.
     */
    public void writeCoinToIndividualStacks(CloudCoin coin, String filePath) {
        Stack stack = new Stack(coin);
        try {
            Files.write(Paths.get(filePath), Utils.createGson().toJson(stack).getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }

    public CloudCoin loadCoin(String fileName) {
        ArrayList<CloudCoin> coins = FileUtils.loadCloudCoinsFromStack(fileName);

        if (coins != null)
            System.out.println("loaded coins: " + coins.size());
        else
            System.out.println("or not");
        if (coins != null && coins.size() > 0)
            return coins.get(0);
        return null;
    }

    public void overWrite(String folder, CloudCoin cc) {
        String json = Utils.createGson().toJson(cc);

        try {
            Files.write(Paths.get(cc.getFullFilePath() + ".stack"), json.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Loads to memory all of the CloudCoins in the Bank and Fracked folders.
     */
    public void loadFileSystem() {
        bankCoins = loadFolderCoins(BankFolder);
        frackedCoins = loadFolderCoins(FrackedFolder);
        //importCoins = loadFolderCoins(ImportFolder);
        //predetectCoins = loadFolderCoins(SuspectFolder);
    }

    public void detectPreProcessing() {
        for (CloudCoin coin : importCoins) {
            String fileName = coin.getFullFilePath();
            int coinExists = 0;
            for (CloudCoin folderCoin : predetectCoins)
                if (folderCoin.getSn() == coin.getSn())
                    coinExists++;
            //int coinExists = (int) Arrays.stream(predetectCoins.toArray(new CloudCoin[0])).filter(x -> x.getSn() == coin.getSn()).count();

            //if (coinExists > 0)
            //{
            //    String suffix = Utils.randomString(16);
            //    fileName += suffix.toLowerCase();
            //}

            Stack stack = new Stack(coin);
            try {
                Files.write(Paths.get(SuspectFolder + fileName + ".stack"), Utils.createGson().toJson(stack).getBytes(StandardCharsets.UTF_8));
            } catch (IOException e) {
                System.out.println("FS#DPP: " + e.getLocalizedMessage());
                e.printStackTrace();
            }
        }
    }

    public static File[] GetFilesArray(String path, String[] extensions) {
        final ArrayList<String> extensionsArray = new ArrayList<>(Arrays.asList(extensions));
        return new File(path).listFiles(pathname -> {
            String filename = pathname.getAbsolutePath();
            String extension = filename.substring(filename.lastIndexOf('.')).toLowerCase();
            return extensionsArray.contains(extension);
        });
    }

    public static void moveCoin(CloudCoin coin, String sourceFolder, String targetFolder, boolean replaceCoins) {
        ArrayList<CloudCoin> folderCoins = loadFolderCoins(targetFolder);

        String fileName = (CoinUtils.generateFilename(coin));
        int coinExists = 0;
        for (CloudCoin folderCoin : folderCoins)
            if (folderCoin.getSn() == coin.getSn())
                coinExists++;
        //int coinExists = (int) Arrays.stream(folderCoins.toArray(new CloudCoin[0])).filter(x -> x.getSn() == coin.getSn()).count();

        if (coinExists > 0 && !replaceCoins) {
            String suffix = FileUtils.randomString(16);
            fileName += suffix.toLowerCase();
        }
        try {
            Gson gson = Utils.createGson();
            Stack stack = new Stack(coin);
            Files.write(Paths.get(targetFolder + fileName + ".stack"), gson.toJson(stack).getBytes(StandardCharsets.UTF_8));
            Files.deleteIfExists(Paths.get(sourceFolder + CoinUtils.generateFilename(coin) + ".stack"));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }

    public static void moveFile(String fileName, String sourceFolder, String targetFolder, boolean replaceCoins) {
        String newFilename = fileName;
        if (!replaceCoins) {
            String[] suspectFileNames = FileUtils.selectFileNamesInFolder(targetFolder);
            for (String suspect : suspectFileNames)
                if (suspect.equals(fileName)) {
                    newFilename = FileUtils.ensureFilepathUnique(fileName, ".stack", targetFolder);
                    newFilename = newFilename.substring(newFilename.lastIndexOf(File.separatorChar) + 1).replace(".stack.stack", ".stack");
                    break;
                }
        }

        try {
            Files.move(Paths.get(sourceFolder + fileName), Paths.get(newFilename), StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }

    public static boolean MoveCoins(ArrayList<CloudCoin> coins, String sourceFolder, String targetFolder) {
        return MoveCoins(coins, sourceFolder, targetFolder, ".stack", false);
    }

    public static boolean MoveCoins(ArrayList<CloudCoin> coins, String sourceFolder, String targetFolder, String extension, boolean replaceCoins) {
        ArrayList<CloudCoin> folderCoins = loadFolderCoins(targetFolder);

        for (CloudCoin coin : coins) {
            String fileName = CoinUtils.generateFilename(coin);
            int coinExists = 0;
            for (CloudCoin folderCoin : folderCoins)
                if (folderCoin.getSn() == coin.getSn())
                    coinExists++;
            //int coinExists = (int) Arrays.stream(folderCoins.toArray(new CloudCoin[0])).filter(x -> x.getSn() == coin.getSn()).count();

            if (coinExists > 0 && !replaceCoins) {
                String suffix = FileUtils.randomString(16);
                fileName += suffix.toLowerCase();
            }
            try {
                Gson gson = Utils.createGson();
                Stack stack = new Stack(coin);
                Files.write(Paths.get(targetFolder + fileName + extension), gson.toJson(stack).getBytes(StandardCharsets.UTF_8));
                Files.deleteIfExists(Paths.get(sourceFolder + CoinUtils.generateFilename(coin) + extension));
                Files.deleteIfExists(Paths.get(coin.getFolder() + CoinUtils.generateFilename(coin) + extension));
                Files.deleteIfExists(Paths.get(coin.getFullFilePath()));
            } catch (Exception e) {
                System.out.println(e.getLocalizedMessage());
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    /**
     * Converts a byte array to a hexadecimal String.
     *
     * @param data the byte array.
     * @return a hexadecimal String.
     */
    public String bytesToHexString(byte[] data) {
        final String HexChart = "0123456789ABCDEF";
        final StringBuilder hex = new StringBuilder(data.length * 2);
        for (byte b : data)
            hex.append(HexChart.charAt((b & 0xF0) >> 4)).append(HexChart.charAt((b & 0x0F)));
        return hex.toString();
    }
}

