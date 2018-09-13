package com.cloudcoin.bank.core;

import com.cloudcoin.bank.utils.CoinUtils;
import com.cloudcoin.bank.utils.FileUtils;

import java.util.ArrayList;

/**
 * Banker can return a detailed balance of all the coins.
 *
 * @author Sean H. Worthington
 * @version 1/14/2017
 */
public class Banker {

    /**
     * Method countCoins counts how many coins of a given extension are in a given directory
     *
     * @param folderPath A folder path.
     * @return An array of the different denominations of coins. The first index is the total amount of all coins added together.
     */
    public static int[] countCoins(String folderPath) {
        int[] returnCounts = new int[6]; // 0. Total, 1.1s, 2,5s, 3.25s 4.100s, 5.250s

        String[] fileNames = FileUtils.selectFileNamesInFolder(folderPath);
        for (int i = 0; i < fileNames.length; i++) {
            String[] nameParts = fileNames[i].split("\\.");
            String denomination = nameParts[0];
            switch (denomination) {
                case "1": returnCounts[0] += 1; returnCounts[1]++; break;
                case "5": returnCounts[0] += 5; returnCounts[2]++; break;
                case "25": returnCounts[0] += 25; returnCounts[3]++; break;
                case "100": returnCounts[0] += 100; returnCounts[4]++; break;
                case "250": returnCounts[0] += 250; returnCounts[5]++; break;
            }
        }
        return returnCounts;
    }

    public static int countCoins(ArrayList<CloudCoin> coins) {
        return countCoins(coins.toArray(new CloudCoin[0]));
    }
    public static int countCoins(CloudCoin[] coins) {
        int total = 0;
        for (CloudCoin coin : coins) {
            total += CoinUtils.getDenomination(coin);
        }
        return total;
    }
}
