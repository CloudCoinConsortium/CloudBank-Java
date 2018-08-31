package com.cloudcoin.bank;

import com.cloudcoin.bank.core.CloudCoin;
import com.cloudcoin.bank.core.FileSystem;
import com.cloudcoin.bank.utils.Utils;

import java.util.ArrayList;

public class Grader {

    /**
     * Categorizes coins into folders based on their pown results.
     */
    public static void gradeAllInFolder(String folderPath) {
        ArrayList<CloudCoin> detectedCoins = FileSystem.loadFolderCoins(folderPath);

        // Apply Grading to all detected coins at once.
        detectedCoins.forEach(detectedCoin -> GradeSimple(detectedCoin, folderPath));

        ArrayList<CloudCoin> coinsBank = new ArrayList<>();
        ArrayList<CloudCoin> coinsFracked = new ArrayList<>();
        ArrayList<CloudCoin> coinsCounterfeit = new ArrayList<>();
        ArrayList<CloudCoin> coinsLost = new ArrayList<>();

        for (CloudCoin coin : detectedCoins) {
            if (coin.getFolder().equals(folderPath + FileSystem.BankPath)) coinsBank.add(coin);
            else if (coin.getFolder().equals(folderPath + FileSystem.FrackedPath)) coinsFracked.add(coin);
            else if (coin.getFolder().equals(folderPath + FileSystem.CounterfeitPath)) coinsCounterfeit.add(coin);
            else if (coin.getFolder().equals(folderPath + FileSystem.LostPath)) coinsLost.add(coin);
        }

        updateLog("Coin Detection finished.");
        updateLog("Total Passed Coins - " + (coinsBank.size() + coinsFracked.size()) + "");
        updateLog("Total Failed Coins - " + coinsCounterfeit.size() + "");
        updateLog("Total Lost Coins - " + coinsLost.size() + "");

        // Move Coins to their respective folders after sort
        FileSystem.MoveCoins(coinsBank, folderPath + FileSystem.DetectedPath, folderPath + FileSystem.BankPath);
        FileSystem.MoveCoins(coinsFracked, folderPath + FileSystem.DetectedPath, folderPath + FileSystem.FrackedPath);
        FileSystem.MoveCoins(coinsCounterfeit, folderPath + FileSystem.DetectedPath, folderPath + FileSystem.CounterfeitFolder);
        FileSystem.MoveCoins(coinsLost, folderPath + FileSystem.DetectedPath, folderPath + FileSystem.LostPath);
    }

    /**
     * Determines the coin's folder based on a simple grading schematic.
     */
    public static void GradeSimple(CloudCoin coin, String folderPath) {
        if (isPassingSimple(coin.getPown())) {
            if (isFrackedSimple(coin.getPown()))
                coin.setFolder(folderPath + FileSystem.FrackedPath);
            else
                coin.setFolder(folderPath + FileSystem.BankPath);
        }
        else {
            if (isHealthySimple(coin.getPown()))
                coin.setFolder(folderPath + FileSystem.CounterfeitFolder);
            else
                coin.setFolder(folderPath + FileSystem.LostPath);
        }
    }

    /**
     * Checks to see if the pown result is a passing grade.
     *
     * @return true if the pown result contains more than 20 passing grades.
     */
    public static boolean isPassingSimple(String pown) {
        return (Utils.charCount(pown, 'p') >= 20);
    }

    /**
     * Checks to see if the pown result is fracked.
     *
     * @return true if the pown result contains more than 5 fracked grades.
     */
    public static boolean isFrackedSimple(String pown) {
        return (pown.indexOf('f') != -1);
    }

    /**
     * Checks to see if the pown result is in good health. Unhealthy grades are errors and no-responses.
     *
     * @return true if the pown result contains more than 20 passing or failing grades.
     */
    public static boolean isHealthySimple(String pown) {
        return (Utils.charCount(pown, 'p') + Utils.charCount(pown, 'f') >= 20);
    }

    public static void updateLog(String message) {
        System.out.println(message);
        //logger.Info(message);
    }
}
