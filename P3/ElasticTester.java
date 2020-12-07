//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: ElasticTester
// Files: ElasticTester. java
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

public class ElasticTester {
  public static void main(String[] args) {
     System.out.println(testCoinInstantiableClass());
     System.out.println(testCapacity());
     System.out.println(testGetExpansions());
     System.out.println(testGetSize());
     System.out.println(testBalanceAccessors());
    System.out.println(testGetCoins());
    System.out.println(testEmpty());
    System.out.println(testRemoveCoin());
  }

  public static boolean testCoinInstantiableClass() {
    Coin penny = new Coin("PENNY", 1);
    Coin quarter = new Coin("QUARTER", 25);
    if (!penny.getName().equals("PENNY"))
      return false;
    if (penny.getValue() != 1)
      return false;
    if (!quarter.getName().equals("QUARTER"))
      return false;
    if (quarter.getValue() != 25)
      return false;
    return true;
  }

  public static boolean testCapacity() {
    ElasticBank one = new ElasticBank(5);
    ElasticBank two = new ElasticBank(7);
    if (one.capacity() != 5)
      return false;
    if (two.capacity() != 7)
      return false;
    return true;
  }

  public static boolean testGetExpansions() {
    ElasticBank one = new ElasticBank();
    one.addCoin(new Coin("PENNY", 1));
    one.addCoin(new Coin("QUARTER", 25));
    one.addCoin(new Coin("PENNY", 1));
    one.addCoin(new Coin("DIME", 10));
    one.addCoin(new Coin("NICKEL", 5));
    if (one.getExpansions() != 2) {
      return false;
    }  
    ElasticBank two = new ElasticBank(1);
    two.addCoin(new Coin("DIME", 10));
    two.addCoin(new Coin("NICKEL", 5));
    two.addCoin(new Coin("DIME", 10));
    two.addCoin(new Coin("NICKEL", 5));
     System.out.println(two.getExpansions());

    if (two.getExpansions() != 1) {
      return false;
    }
    ElasticBank three = new ElasticBank(1);
    three.addCoin(new Coin("DIME", 10));
    three.addCoin(new Coin("NICKEL", 5));
    three.addCoin(new Coin("DIME", 10));
    three.addCoin(new Coin("NICKEL", 5));
    three.addCoin(new Coin("DIME", 10));
    three.addCoin(new Coin("NICKEL", 5));
    three.addCoin(new Coin("DIME", 10));
    three.addCoin(new Coin("NICKEL", 5));
    three.addCoin(new Coin("DIME", 10));
    three.addCoin(new Coin("NICKEL", 5));
    three.addCoin(new Coin("DIME", 10));
    three.addCoin(new Coin("NICKEL", 5));
    three.addCoin(new Coin("NICKEL", 5));
    three.addCoin(new Coin("DIME", 10));
    three.addCoin(new Coin("NICKEL", 5));
    if (three.getExpansions() != 0) {
       return false;
     }

    return true;
  }

  public static boolean testGetSize() {
    ElasticBank one = new ElasticBank(2);
    one.addCoin(new Coin("PENNY", 1));
    if (one.getSize() != 1) {
      return false;
    }
    ElasticBank two = new ElasticBank(5);
    two.addCoin(new Coin("PENNY", 1));
    two.addCoin(new Coin("PENNY", 1));
    two.addCoin(new Coin("NICKLE", 5));
    two.addCoin(new Coin("NICKLE", 5));
    two.addCoin(new Coin("NICKLE", 5));
    if (two.getSize() != 5) {
      return false;
    }
    ElasticBank three = new ElasticBank(5);
    three.addCoin(new Coin("PENNY", 1));
    three.addCoin(new Coin("PENNY", 1));
    three.addCoin(new Coin("NICKLE", 5));
    three.addCoin(new Coin("NICKLE", 5));
    three.addCoin(new Coin("NICKLE", 5));
    three.addCoin(new Coin("PENNY", 1));
    if (three.getSize() != 6) {
      return false;
    }
    return true;
  }

  public static boolean testBalanceAccessors() {
    ElasticBank one = new ElasticBank(5);
    ElasticBank two = new ElasticBank(7);
    one.addCoin(new Coin("PENNY", 1));
    two.addCoin(new Coin("NICKEL", 5));
    if (one.getBalance() != 1)
      return false;
    if (two.getBalance() != 5)
      return false;
    return true;
  }

  public static boolean testGetCoins() {
    ElasticBank one = new ElasticBank(5);
    one.addCoin(new Coin("PENNY", 1));
    one.addCoin(new Coin("PENNY", 1));

    if (!(one.getCoins()).equals("(PENNY,1)(PENNY,1)")) {
      return false;
    }
    ElasticBank two = new ElasticBank(5);
    two.addCoin(new Coin("NICKEL", 5));
    two.addCoin(new Coin("NICKEL", 5));
    two.addCoin(new Coin("NICKEL", 5));
    two.addCoin(new Coin("PENNY", 1));
    two.addCoin(new Coin("PENNY", 1));
    if (!(two.getCoins()).equals("(NICKEL,5)(NICKEL,5)(NICKEL,5)(PENNY,1)(PENNY,1)")) {
      return false;

    }
    return true;
  }

  public static boolean testRemoveCoin() {

    ElasticBank one = new ElasticBank();
    one.addCoin(new Coin("NICKLE", 5));
    one.addCoin(new Coin("NICKLE", 5));
    one.addCoin(new Coin("NICKLE", 5));
    one.removeCoin();
    if ((one.getBalance() != 10)) {
      return false;
    }
    ElasticBank two = new ElasticBank(5);
    two.addCoin(new Coin("NICKEL", 5));
    two.addCoin(new Coin("NICKEL", 5));
    two.addCoin(new Coin("NICKEL", 5));
    two.addCoin(new Coin("PENNY", 1));
    two.addCoin(new Coin("PENNY", 1));
    two.removeCoin();

    if (!(two.getCoins()).equals("(NICKEL,5)(NICKEL,5)(PENNY,1)(PENNY,1)")) {
      return false;
    }
    return true;
  }
  
  public static boolean testEmpty() {
    ElasticBank one = new ElasticBank();
    one.addCoin(new Coin("NICKLE", 5));
    one.addCoin(new Coin("NICKLE", 5));
    one.addCoin(new Coin("NICKLE", 5));
    one.empty();
    if(one.getBalance()!=0) {
      return false;
    }
    System.out.println(one.getCoins());
    if(one.getCoins() != "") {
      return false;
    }
    if(one.getSize() != 0) {
      return false;
    }
    
    return true;
  }
}
