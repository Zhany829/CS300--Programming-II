//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: CalendarPrinter
// Files: CalendarTester
// Course: CS300 2020 SP
//
// Author: ZHAN YU
// Email: zyu293@wisc.edu
// Lecturer's Name: Gary
//
//////////// PAIR PROGRAMMING (MAY SKIP WHEN WORKING INDIVIDUALLY) ////////////
//
// Partner Name: Hunter Zhang
// Partner Email: zzhang978@wisc.edu
// Partner Lecturer's Name: Mourna
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// __X_ Write-up states that pair programming is allowed for this assignment.
// _X__ We have both read and understood the course Pair Programming Policy.
// __X_ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Students who get help from sources other than their partner and the course
// staff must fully acknowledge and credit those sources here. If you did not
// receive any help of any kind from outside sources, explicitly indicate NONE
// next to each of the labels below.
//
// Persons: (identify each person and describe their help in detail)
// Online Sources: (identify each URL and describe their assistance in detail)
//
///////////////////////////////////////////////////////////////////////////////
import java.util.Random;

public class PiggyBank {

    public final static int[] COINS_VALUES = { 1, 5, 10, 25 }; // coins values in cents
    // coins names
    public final static String[] COINS_NAMES = { "PENNY", "NICKEL", "DIME", "QUARTER" };
    public final static String NO_SUCH_COIN = "N/A"; // N/A string
    private final static Random RAND_GEN = new Random(100); // generator of random integers

    /***
     * Returns the name of a specified coin value
     * 
     * @param coin represents a coin value in cents.
     * @return the String name of a specified coin value if it is valid and N/A if
     *         the coin value is not valid
     */
    public static String getCoinName(int coin) {
        for (int i = 0; i < COINS_VALUES.length; i++) {
            if (COINS_VALUES[i] == coin) {
                return COINS_NAMES[i];
            }
        }

        return NO_SUCH_COIN;
    }

    /***
     * Returns the balance of a piggy bank in cents
     * 
     * @param coins an oversize array which contains all the coins held in a piggy
     *              bank
     * @param size  the total number of coins stored in coins array
     * @return the total value of the coins held in a piggy bank in cents
     */
    public static int getBalance(int[] coins, int size) {
        int balance = 0;
        for (int i = 0; i < size; i++) {
            balance += coins[i];
        }

        return balance;
    }

    /***
     * Returns the total number of coins of a specific coin value held in a piggy
     * bank
     ** 
     * @param coinValue the value of a specific coin
     * @param coins     an oversize array which contains all the coins held in a
     *                  piggy bank
     * @param size      the total number of coins stored in coins array
     * @return the number of coins of value coinValue stored in the array coins
     */
    public static int getSpecificCoinCount(int coinValue, int[] coins, int size) {
        int numOfCoins = 0;
        for (int i = 0; i < size; i++) {
            if (coins[i] == coinValue) {
                numOfCoins++;
            }
        }
        return numOfCoins;
    }

    /***
     * Displays information about the content of a piggy bank
     ** 
     * @param coins an oversize array storing the coins held in a piggy bank
     * @param size  number of coin held array coins
     */
    public static void printPiggyBank(int[] coins, int size) {
        System.out.println("QUARTERS: " + getSpecificCoinCount(25, coins, size));
        System.out.println("DIMES: " + getSpecificCoinCount(10, coins, size));
        System.out.println("NICKELS: " + getSpecificCoinCount(5, coins, size));
        System.out.println("PENNIES: " + getSpecificCoinCount(1, coins, size));
        System.out.println("Balance: $" + getBalance(coins, size) * 0.01);
    }

    /***
     * Adds a given coin to a piggy bank. This operation can terminate successfully
     * or unsuccessfully. For either cases, this method displays a descriptive
     * message for either cases.
     ** 
     * the coin value in cents to be added to the array coins
     * 
     * @param coin  : the value of the coin.
     * @param coins an oversize array storing the coins held in a piggy bank
     * @param size  the total number of coins contained in the array coins before
     *              this addCoin method is called. *
     * @return the new size of the coins array after trying to add coin.
     */
    public static int addCoin(int coin, int[] coins, int size) {
        if (getCoinName(coin).equals(NO_SUCH_COIN)) {
            System.out.println(coin + " cents is not a valid US currency coin.");
            return size;
        } else if (coins.length <= size) {
            System.out.println("Tried to add a " + coin + ", but could not because the piggy bank is full.");
            return size;
        } else {
            coins[size] = coin;
            size++;
            System.out.println("Added a " + getCoinName(coin) + ".");
        }

        return size;
    }

    /***
     * Removes an arbitrary coin from a piggy bank. This method may terminate
     * successfully or unsuccessfully. In either cases, a descriptive message is
     * displayed. **
     * 
     * @param coins an oversize array which contains the coins held in a piggy bank
     * 
     * @param size  the number of coins held in the coins array before this method
     *              is called
     * @return the size of coins array after this method returns successfully
     */
    public static int removeCoin(int[] coins, int size) {
        if (coins.length == 0) {
            System.out.println("Tried to remove a coin, but could not because the piggy bank is empty.");
            return size;
        } else {
            int RandomIndex = RAND_GEN.nextInt(size);
            boolean targetFound;

            targetFound = false;

            // Step through the array one element at a time
            for (int i = 0; i < coins.length; ++i) {
                // If matching element found, move each element to the previous index
                if (targetFound) {
                    coins[i - 1] = coins[i];
                }

                // Check if matching element found
                if (coins[i] == coins[RandomIndex]) {
                    targetFound = true;
                }
            }

            // If matching element found, array size is one element smaller
            // otherwise array size hasn't changed
            if (targetFound) {
                size = size - 1;
            }

            System.out.println("Removed a " + getCoinName(coins[RandomIndex]) + ".");
        }
        return size;
    }

    /***
     * Removes all the coins in a piggy bank. It also displays the total value of
     * the removed coins
     ** 
     * @param coins an oversize array storing the coins held in a piggy bank
     *              application
     * @param size  number of coins held in coins array before this method is called
     * @return the new size of the piggy bank after removing all its coins.
     */
    public static int emptyPiggyBank(int[] coins, int size) {
        if (coins.length == 0 || size == 0) {
            System.out.println("Zero coin removed. The piggy bank is already empty.");
            return size;
        } else {
            int num = getBalance(coins, size);
            for (int i = 0; i < coins.length; i++) {
                coins[i] = 0;
            }
            size = 0;
            System.out.println("All done. " + num + " cents removed.");
        }
        return size;
    }

    /***
     * Removes the least number of coins needed to fulfill a withdrawal request
     ** 
     * @param amount amount to withdraw given in cents
     * @param coins  an oversize array storing the coins held in a piggy bank
     * @param size   number of coins stored in coins array before this method is
     *               called
     * @return perfect size array of 5 elements, index 0 stores the new size of the
     *         piggy bank after this method returns. Indexes 1, 2, 3, and 4 * store
     *         respectively the number of removed quarters, dimes, * nickels, and
     *         pennies.
     */
    public static int[] withdraw(int amount, int[] coins, int size) {
        int temp = 0;
        int newAmount = 0;
        int[] newCoins = new int[100];
        int newCoinsSize = 0;
        int[] resultCoins = new int[5];
        int total = 0;
        if (amount > getBalance(coins, size)) {
            System.out.println("Unable to withdraw " + amount + " cent. NOT enough money in the piggy bank");
            return resultCoins;
        } else {
            for (int i = 0; i < (size - 1); i++) {
                for (int j = 0; j < size - i - 1; j++) {
                    if (coins[j] < coins[j + 1]) {
                        temp = coins[j];
                        coins[j] = coins[j + 1];
                        coins[j + 1] = temp;
                    }
                }
            }
            newAmount = amount;
            for (int i = 0; i < size; i++) {
                if (coins[i] <= newAmount) {

                    newCoins[newCoinsSize] = coins[i];
                    newCoinsSize += 1;

                    newAmount = newAmount - coins[i];
                }
            }
            if (newAmount > 0) {

                int i = 0, j = size, mid = 0;
                while (i < j) {
                    mid = (i + j) / 2;

                    if (coins[mid] == newAmount) {

                        newCoins[newCoinsSize] = coins[mid];
                        newCoinsSize += 1;
                    }

                    if (newAmount > coins[mid]) {

                        // If target is greater than previous
                        // to mid, return closest of two
                        if (mid > 0 && newAmount > coins[mid - 1]) {

                            newCoins[newCoinsSize] = getClosest(coins[mid - 1], coins[mid], newAmount);
                            newCoinsSize += 1;
                        }

                        /* Repeat for left half */
                        j = mid;
                    }

                    // If target is greater than mid
                    else {
                        if (mid < size - 1 && newAmount < coins[mid + 1]) {

                            newCoins[newCoinsSize] = getClosest(coins[mid], coins[mid + 1], newAmount);
                            newCoinsSize += 1;
                        }

                        i = mid + 1; // update i
                    }
                }

            }

        }

        for (int i = 0; i < newCoinsSize; i++) {
            if (newCoins[i] == 25) {
                resultCoins[1] += 1;
                boolean targetFound = false;
                for (int index = 0; index < size; ++index) {
                    // If matching element found, move each element to the previous index
                    if (targetFound) {
                        coins[index - 1] = coins[index];
                    }

                    // Check if matching element found
                    if (coins[index] == newCoins[i]) {
                        targetFound = true;
                    }
                }
            } else if (newCoins[i] == 10) {
                resultCoins[2] += 1;
                boolean targetFound = false;
                for (int index = 0; index < size; ++index) {
                    // If matching element found, move each element to the previous index
                    if (targetFound) {
                        coins[index - 1] = coins[index];
                    }

                    // Check if matching element found
                    if (coins[index] == newCoins[i]) {
                        targetFound = true;
                    }
                }
            } else if (newCoins[i] == 5) {
                resultCoins[3] += 1;
                boolean targetFound = false;
                for (int index = 0; index < size; ++index) {
                    // If matching element found, move each element to the previous index
                    if (targetFound) {
                        coins[index - 1] = coins[index];
                    }

                    // Check if matching element found
                    if (coins[index] == newCoins[i]) {
                        targetFound = true;
                    }
                }
            } else if (newCoins[i] == 5) {
                resultCoins[4] += 1;
                boolean targetFound = false;
                for (int index = 0; index < size; ++index) {
                    // If matching element found, move each element to the previous index
                    if (targetFound) {
                        coins[index - 1] = coins[index];
                    }

                    // Check if matching element found
                    if (coins[index] == newCoins[i]) {
                        targetFound = true;
                    }
                }
            }
        }
        for (int i = 1; i < resultCoins.length; i++) {
            total += resultCoins[i];
        }

        resultCoins[0] = size - total;

        return resultCoins;
    }

    /**
     * helper method for withdrawal that determines which value is greater.
     * 
     * @param val1:   first value
     * @param val2:   second value
     * @param target: the target value
     * @return
     */
    private static int getClosest(int val1, int val2, int target) {
        if (target - val1 >= val2 - target)
            return val2;
        else
            return val1;
    }

}
