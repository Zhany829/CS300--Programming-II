//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: ExceptionalBank
// Files: ExceptionalBankTester. java
// Course: CS300 2020 SP
//
// Author: ZHAN YU
// Email: zyu293@ wisc.edu
// Lecturer's Name: Gary
//
//////////// PAIR PROGRAMMING (MAY SKIP WHEN WORKING INDIVIDUALLY) ////////////
//
// Partner Name: NONE
// Partner Email: NONE
// Partner Lecturer's Name: NONE
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// ___ Write-up states that pair programming is allowed for this assignment.
// ___ We have both read and understood the course Pair Programming Policy.
// ___ We have registered our team prior to the team registration deadline.
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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.zip.DataFormatException;
import java.util.Scanner;
import java.util.NoSuchElementException;

/***
 * This class aims to test the methods in the ExceptionalBank.java
 * 
 * @author Zhan Yu
 *
 */
public class ExceptionalBankTester {
  /***
   * Calls the test methods implemented in this class and displays their output
   * 
   * @param args input arguments if any
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    System.out.println(testExceptionalBankConstructor());
    System.out.println(testAddCoin());
    System.out.println(testGoodExceptionalBankConstructor());
    System.out.println(testRemoveCoinEmptyBank());
    System.out.println(testAddCoins());
    System.out.println(testLoadCoinsNullReference());
    System.out.println(testLoadCoinsFileNotFound());
    System.out.println(testLoadCoinsFileFound());

  }

  /***
   * This method checks whether the ExceptionalBank constructor throws an IllegalArgumentException
   * with appropriate error message, when it is passed a zero or a negative capacity.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testExceptionalBankConstructor() {
    try {
      // create an exceptional bank with a negative capacity
      ExceptionalBank bank = new ExceptionalBank(-10);
      System.out.println("Problem detected. The constructor call of the ExceptionalBank "
          + "class did not throw an IllegalArgumentException when it "
          + "is passed a negative capacity.");
      return false; // return false if no exception has been thrown
    } catch (IllegalArgumentException e1) {
      // check that the caught IllegalArgumentException includes an
      // appropriate error message
      if (e1.getMessage() != null // to ensure that your test method returns false
          // if e1.getMessage is null. Otherwise, your test method will
          // return with a NullPointerException
          && e1.getMessage().toLowerCase().contains("must be a non-zero positive integer")) {
        return true;
      }
      System.out
          .println("Problem detected. The IllegalArgumentException thrown by the constructor call "
              + "of the ExceptionalBank class when it is passed a negative capacity "
              + "does not contain an appropriate error message.");
      return false;
    } catch (Exception e2) {
      // an exception other than IllegalArgumentException has been thrown
      System.out
          .println("Problem detected. An unexpected exception has been thrown when calling the "
              + "constructor of the ExceptionBank class with a negative argument. An "
              + "IllegalArgumentException was expected to be thrown. "
              + "But, it was NOT the case.");
      e2.printStackTrace(); // to help locate the error within a bad
      // ExceptionalBank constructor implementation.
      return false;
    }
  }

  /***
   * This method checks whether the ExceptionalBank addCoin() throws an IllegalArgumentException
   * with appropriate error message, when it adds a null into the bank.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAddCoin() {
    try {
      // create an exceptional bank
      ExceptionalBank bank = new ExceptionalBank(2);
      Coin c = null;
      bank.addCoin(c);
      System.out.println("Problem detected. The constructor call of the ExceptionalBank "
          + "class did not throw an IllegalArgumentException when it "
          + "adds a null reference to this bank.");
      return false; // return false if no exception has been thrown
    } catch (IllegalArgumentException e1) {
      // check that the caught IllegalArgumentException includes an
      // appropriate error message
      if (e1.getMessage() != null // to ensure that your test method returns false
          // if e1.getMessage is null. Otherwise, your test method will
          // return with a NullPointerException
          && e1.getMessage().toLowerCase().contains("cannot add a null reference to this bank")) {
        return true;
      }
      System.out.println("Problem detected. The constructor call of the ExceptionalBank "
          + "class did not throw an IllegalArgumentException when it "
          + "adds a null reference to this bank.");
      return false;
    } catch (Exception e2) {
      // an exception other than IllegalArgumentException has been thrown
      System.out.println("Problem detected. An unexpected exception has been thrown"
          + " when adding a null in the addCoin() method in ExceptionBank class. An "
          + "IllegalArgumentException was expected to be thrown. But, it was NOT the case.");
      e2.printStackTrace(); // to help locate the error within a bad
      // ExceptionalBank constructor implementation.
      return false;
    }

  }

  /***
   * This method checks whether the ExceptionalBank constructor throws an exception when the size of
   * the bank is not equal to the initial capacity passed to the constructor
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testGoodExceptionalBankConstructor() {
    try {
      // create an exceptional bank with a negative capacity
      ExceptionalBank bank = new ExceptionalBank(20);

    } catch (Exception e1) {
      System.out.println("Problem detected. The constructor call of the Exceptionbank, "
          + "but the size is not equal to initial capacity.");
      return false;
    }
    return true;

  }



  /***
   * This method checks whether the ExceptionalBank removeCoin() throws an NoSuchElementException
   * with appropriate error message, when it tries to remove a coin from a empty bank.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testRemoveCoinEmptyBank() {
    try {
      // create an exceptional bank
      ExceptionalBank bank = new ExceptionalBank(1);

      bank.removeCoin();

      System.out.println("Problem detected. The constructor call of the ExceptionalBank "
          + "class did not throw an NoSuchElementException when it "
          + "removes a coin from a empty bank.");
      return false; // return false if no exception has been thrown
    } catch (NoSuchElementException e1) {
      // check that the caught NoSuchElementException includes an
      // appropriate error message
      if (e1.getMessage() != null // to ensure that your test method returns false
          // if e1.getMessage is null. Otherwise, your test method will
          // return with a NullPointerException
          && e1.getMessage().toLowerCase().contains("bank is empty. unable to remove a coin.")) {
        return true;
      }
      System.out.println("Problem detected. The constructor call of the ExceptionalBank "
          + "class did not throw an NoSuchElementException "
          + "when it removes a coin from a empty bank.");
      return false;
    } catch (Exception e1) {
      // an exception other than NoSuchElementException has been thrown
      System.out.println("Problem detected. An unexpected exception has been thrown"
          + " when calls removeCoin() method to remove a coin from empty bank in "
          + "ExceptionBank class. An NoSuchElementException was expected to be thrown. "
          + "But, it was NOT the case.");
      e1.printStackTrace(); // to help locate the error within a bad
      // ExceptionalBank constructor implementation.
      return false;
    }

  }

  /***
   * This method checks whether the ExceptionalBank addCoins() method is correct by using four tests
   * to check.
   * 
   * @return true when methods for testing addCoins() in ExceptionalBank are correct.
   */
  public static boolean testAddCoins() {
    return testAddCoinsIllegalArgument() && testAddCoinsValidFormat() && testAddCoinsNoSuchElement()
        && testAddCoinsInvalidDataFormat();
  }

  /***
   * This method checks whether the ExceptionalBank addCoins() throws an IllegalArgumentException
   * with appropriate error message, when it adds a null into the bank.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAddCoinsIllegalArgument() {
    try {
      // create an exceptional bank
      ExceptionalBank bank = new ExceptionalBank(5);
      bank.addCoins(null);
      System.out.println("Problem detected. The constructor call of the ExceptionalBank "
          + "class did not throw an IllegalArgumentException when it "
          + "adds a null to the bank.");
      return false; // return false if no exception has been thrown
    } catch (IllegalArgumentException e1) {
      // check that the caught IllegalArgumentException includes an
      // appropriate error message
      if (e1.getMessage() != null // to ensure that your test method returns false
          // if e1.getMessage is null. Otherwise, your test method will
          // return with a NullPointerException
          && e1.getMessage().contains("does not accept a null reference as input.")) {
        return true;
      }
      System.out.println("Problem detected. The constructor call of the ExceptionalBank "
          + "class did not throw an NoSuchElementException when it " + "adds a null to the bank.");
      return false;
    } catch (Exception e2) {
      // an exception other than IllegalArgumentException has been thrown
      System.out.println("Problem detected. An unexpected exception has been thrown"
          + " when calls addCoins() method to add a coin into the bank in "
          + "ExceptionBank class. An IllegalArgumentException was expected to be thrown. "
          + "But, it was NOT the case.");
      e2.printStackTrace(); // to help locate the error within a bad
      // ExceptionalBank constructor implementation.
      return false;
    }



  }

  /***
   * This method checks whether the ExceptionalBank addCoins() throws an DataFormatException with
   * appropriate error message, when it adds a string without ':' into the bank.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAddCoinsValidFormat() {
    try {
      // create an exceptional bank
      ExceptionalBank bank = new ExceptionalBank(5);
      bank.addCoins("penny 1");
      System.out.println("Problem detected. The constructor call of the ExceptionalBank "
          + "class did not throw an DataFormatException when it "
          + "adds a string without ':' to the bank.");
      return false; // return false if no exception has been thrown
    } catch (DataFormatException e1) {
      // check that the caught DataFormatException includes an
      // appropriate error message
      if (e1.getMessage() != null // to ensure that your test method returns false
          // if e1.getMessage is null. Otherwise, your test method will
          // return with a NullPointerException
          && e1.getMessage().contains("format of the command line penny 1 is incorrect.")) {
        return true;
      }
      System.out.println("Problem detected. The constructor call of the ExceptionalBank "
          + "class did not throw an DataFormatException when it "
          + "adds a string without ':' to the bank.");
      return false;
    } catch (Exception e2) {
      // an exception other than DataFormatException has been thrown
      System.out.println("Problem detected. An unexpected exception has been thrown"
          + " when calls addCoins() method to add a coin into the bank in "
          + "ExceptionBank class. An DataFormatException was expected to be thrown. "
          + "But, it was NOT the case.");
      e2.printStackTrace(); // to help locate the error within a bad
      // ExceptionalBank constructor implementation.
      return false;
    }

  }

  /***
   * This method checks whether the ExceptionalBank addCoins() throws an NoSuchElementException with
   * appropriate error message, when it adds a coin with invalid name into the bank.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAddCoinsNoSuchElement() {
    try {
      // create an exceptional bank
      ExceptionalBank bank = new ExceptionalBank(5);
      bank.addCoins("enny:1");
      System.out.println("Problem detected. The constructor call of the ExceptionalBank "
          + "class did not throw an NoSuchElementException when it "
          + "adds a coin with invalid name to the bank.");
      return false; // return false if no exception has been thrown
    } catch (NoSuchElementException e1) {
      // check that the caught NoSuchElementException includes an
      // appropriate error message
      if (e1.getMessage() != null // to ensure that your test method returns false
          // if e1.getMessage is null. Otherwise, your test method will
          // return with a NullPointerException
          && e1.getMessage()
              .contains("coin name provided in the command line enny:1 is invalid.")) {
        return true;
      }
      System.out.println("Problem detected. The constructor call of the ExceptionalBank "
          + "class did not throw an NoSuchElementException when it "
          + "adds a coin with invalid name to the bank.");
      return false;
    } catch (Exception e2) {
      // an exception other than NoSuchElementException has been thrown
      System.out.println("Problem detected. An unexpected exception has been thrown"
          + " when calls addCoins() method to add a coin with invalid name into the bank in "
          + "ExceptionBank class. An NoSuchElementException was expected to be thrown. "
          + "But, it was NOT the case.");
      e2.printStackTrace(); // to help locate the error within a bad
      // ExceptionalBank constructor implementation.
      return false;
    }
  }

  /***
   * This method checks whether the ExceptionalBank addCoins() throws an DataFormatException with
   * appropriate error message, when it adds a string which does not contain a positive number into
   * the bank.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAddCoinsInvalidDataFormat() {
    try {
      // create an exceptional bank
      ExceptionalBank bank = new ExceptionalBank(5);
      bank.addCoins("dime:one");
      System.out.println("Problem detected. The constructor call of the ExceptionalBank "
          + "class did not throw an DataFormatException when it "
          + "adds a string which does not contain a positive number to the bank.");
      return false; // return false if no exception has been thrown
    } catch (DataFormatException e1) {
      // check that the caught DataFormatException includes an
      // appropriate error message
      if (e1.getMessage() != null // to ensure that your test method returns false
          // if e1.getMessage is null. Otherwise, your test method will
          // return with a NullPointerException
          && e1.getMessage().contains("format of the command line dime:one is incorrect.")) {
        return true;
      }
      System.out.println("Problem detected. The constructor call of the ExceptionalBank "
          + "class did not throw an DataFormatException when it "
          + "adds a string which does not contain a positive number to the bank.");
      return false;
    } catch (Exception e2) {
      // an exception other than DataFormatException has been thrown
      System.out.println("Problem detected. An unexpected exception has been thrown"
          + " when calls addCoins() method to add a coin into the bank in "
          + "ExceptionBank class. An DataFormatException was expected to be thrown. "
          + "But, it was NOT the case.");
      e2.printStackTrace(); // to help locate the error within a bad
      // ExceptionalBank constructor implementation.
      return false;
    }
  }

  /**
   * This method checks whether ExceptionalBank.loadCoins() method throws a NullPointerException
   * when it is passed a null reference.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testLoadCoinsNullReference() {

    try {
      File file = new File("hhhh.txt");
      ExceptionalBank bank = new ExceptionalBank(5);
      bank.loadCoins(null);
      System.out.println("Problem detected. The constructor call of the ExceptionalBank "
          + "class did not throw an NullPointerException when it is passed a null reference.");
      return false; // return false if no exception has been thrown
    } catch (NullPointerException e1) {
   // check that the caught NullPointerException includes an
      // appropriate error message
      if (e1.getMessage() != null // to ensure that your test method returns false
          // if e1.getMessage is null.
          && e1.getMessage().contains("passed thing is a null reference")) {
        return true;
      }
      System.out.println("Problem detected. The constructor call of the ExceptionalBank "
          + "class did not throw an NullPointerException when it "
          + "adds a string which does not contain a positive number to the bank.");
      return false;
    } catch (Exception e2) {
      // an exception other than NullPointerException has been thrown
      System.out.println("Problem detected. An unexpected exception has been thrown"
          + " when calls loadCoins() method to passe a null reference into the bank in "
          + "ExceptionBank class. An NullPointerException was expected to be thrown. "
          + "But, it was NOT the case.");
      e2.printStackTrace(); // to help locate the error within a bad
      // ExceptionalBank constructor implementation.
      return false;
    }
  }


  /**
   * This method checks whether ExceptionalBank.loadCoins() method throws a FileNotFoundException
   * when it is passed a non found file.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testLoadCoinsFileNotFound() {
    try {
      File file = new File("hhhh.txt");
      ExceptionalBank bank = new ExceptionalBank(5);
      bank.loadCoins(file);
      System.out.println("Problem detected. The constructor call of the ExceptionalBank "
          + "class did not throw an NullPointerException when it " + "is passed a non found file.");
      return false; // return false if no exception has been thrown
    } catch (FileNotFoundException e1) {

      return true;

    } catch (Exception e2) {
      // an exception other than FileNotFoundException has been thrown
      System.out.println("Problem detected. An unexpected exception has been thrown"
          + " when calls loadCoins() method to passe a non-exist file into the bank in "
          + "ExceptionBank class. An FileNotFoundException was expected to be thrown. "
          + "But, it was NOT the case.");
      e2.printStackTrace(); // to help locate the error within a bad
      // ExceptionalBank constructor implementation.
      return false;
    }


  }

  /**
   * This method checks whether ExceptionalBank.loadCoins() method loads appropriately without
   * throwing any exception when it is passed a found file.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testLoadCoinsFileFound() {
    try {
      File file = new File("sample4.txt");
      ExceptionalBank bank = new ExceptionalBank(5);
      bank.addCoins("penny:2");
      bank.saveBankSummary​(file);
      bank.loadCoins(file);

      // check if there is any exception being thrown
    } catch (Exception e1) {
      System.out.println("ExceptionalBank.loadCoins() method loads with"
          + " throwing exception when it is passed a found file.");
      return false;
    }
    // there is no exception thrown which is expected
    return true;
  }
}


