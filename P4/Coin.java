//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: ExceptionalBank
// Files: Coin. java
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


/**
 * This enum represents an enumeration of the US Currency Coin constants
 * 
 * @author Mouna
 *
 */
public enum Coin {
  PENNY(1), NICKLE(5), DIME(10), QUARTER(25);

  private final int value; // value of this coins
 

  /**
   * The constructor for an enum type must be package-private or private access. This private
   * constructor is only used to create the constants that are defined at the beginning of this
   * enumeration's body.
   * 
   * @param value value in cents of this coin
   */
  private Coin(int value) {
    this.value = value;
  }
  

  /**
   * Returns the value in cents of this coin
   * 
   * @return the value of this coin
   */
  public int value() {
    return value;
  }

}
