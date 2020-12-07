//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: ElasticBank
// Files: ElasticBank. java
// Course: CS300 2020 SP
//
// Author: ZHAN YU
// Email: zyu293@ wisc.edu
// Lecturer's Name: Gary
//
//////////// PAIR PROGRAMMING (MAY SKIP WHEN WORKING INDIVIDUALLY) ////////////
//
// Partner Name: Hunter Zhang
// Partner Email: zzhang978@ wisc.edu
// Partner Lecturer's Name: Hobbes
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
// Persons: NONE
// Online Sources: NONE
//
///////////////////////////////////////////////////////////////////////////////
import java.util.Random;

/***
 * This class aims to create a abstract bank which can store things like money by using the array of
 * Coin.
 * @author Zhan Yu & Hunter Zhang
 *
 */
public class ElasticBank {
  private Coin coins[] = new Coin[0];
  private int size;
  private int expansiansLeft = 2;
  private static Random rand = new Random(100);

  /**
   * If no argument is provided, just create a array of Coin with the default initial capacity to be
   * 10
   */
  public ElasticBank() {
    this.coins = new Coin[10];

  }

  /**
   * If there is a capacity for initialization, create the array and its capacity should be the
   * argument.
   * 
   * @param initialCapacity number for length of the created array.
   */
  public ElasticBank(int initialCapacity) {
    this.coins = new Coin[initialCapacity];

  }

  /**
   * This method provides the current length of coins.
   * 
   * @return the current capacity of the coins array (that is, how many total coins COULD fit in it
   *         right now, not including any future expansions)
   */
  public int capacity() {
    return this.coins.length;
  }

  /**
   * This method provides the expansions left which can be changed
   * 
   * @return the number of expansions left
   */
  public int getExpansions() {
    return this.expansiansLeft;
  }

  /**
   * This method provides the current amount of Coins in the bank.
   * 
   * @return the current number of Coins in the ElasticBank
   */
  public int getSize() {
    return size;
  }

  /**
   * This method provides the value of Coins contained in the bank
   * 
   * @return the current total value of coins in the ElasticBank
   */
  public int getBalance() {
    int coinValue = 0;
    for (int k = 0; k < capacity(); k++) {
      if (!(this.coins[k] == (null))) {
        coinValue += this.coins[k].getValue();
      }
    }
    return coinValue;
  }

  /**
   * This method is utilized to present the Coins in the bank with a string representation
   * 
   * @return a String representation of the Coins in the bank
   */
  public String getCoins() {
    String stringRepresentation = "";

    for (int k = 0; k < capacity(); k++) {
      if (!(this.coins[k] == (null))) {
        stringRepresentation +=
            "(" + this.coins[k].getName() + ", " + this.coins[k].getValue() + ") ";
      }
    }
    // check if there is a blank inside the Coin array
    if (stringRepresentation.equals("")) {
      stringRepresentation = "No coins in the ElasticBank";
    } else {
      stringRepresentation = stringRepresentation.substring(0, stringRepresentation.length() - 1);
    }


    return stringRepresentation;
  }

  /**
   * This method aims to remove a Coin from coins at random and returns it, replacing it with a null
   * reference in the coins array.
   * 
   * @return the Coin which needs to remove
   */
  public Coin removeCoin() {
    int randomIndex = rand.nextInt(size + 1); // get the random index for removing
    Coin coinForRemove = this.coins[randomIndex];// get the random Coin that will be removed
    // if the index of the array coins is null, choose other Coin to remove util the chosen one is
    // not null
    while (coinForRemove == null) {
      randomIndex = rand.nextInt(size + 1);
      coinForRemove = this.coins[randomIndex];
    }
    // set the Coin needed to be removed to null
    this.coins[randomIndex] = null;
    // decrease the size by one since one Coin is removed
    this.size -= 1;
    return coinForRemove;

  }

  /**
   * This method aims to empty the bank and set the size to be 0.
   */
  public void empty() {
    for (int k = 0; k < capacity(); k++) {
      this.coins[k] = null; // every index of coins array is set to be null
      this.size = 0;
    }
  }

  /**
   * This method aims to add a Coin into the bank and will expand the size of the bank if necessary
   * 
   * @param singleCoin The Coin need to be add
   */
  public void addCoin(Coin coinForAdd) {
    //case 1 - when the bank is full, expand the size of bank by 10 within two times
    if ((this.coins.length == this.size) && (this.expansiansLeft != 0)) {
      Coin newCoins[] = new Coin[10 + this.coins.length];
      for (int k = 0; k < size; k++) {
        newCoins[k] = coins[k];
      }
      newCoins[size] = coinForAdd;
      this.expansiansLeft -= 1;
      this.size += 1;
      this.coins = new Coin[10 + this.coins.length];
      for (int k = 0; k < size; k++) {
        coins[k] = newCoins[k];
      }
    }
    //case 2 - when expand the size by two and the bank is full again, add the Coin into a new and empty bank
    else if ((this.coins.length == this.size) && (this.expansiansLeft == 0)) {
      empty();//empty the bank
      this.size = 0;
   
      this.coins[size] = coinForAdd; //add the Coin into the new and empty bank

      this.size += 1;
    }
    //case 3 - when the bank is not full, just add the Coin to the bank
    else {
      this.coins[size] = coinForAdd;
      this.size += 1;
    }


  }

}
