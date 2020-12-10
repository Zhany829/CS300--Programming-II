//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Badger Coaster
// Files: BoardingGroup.java, RideQueue.java, BGNode.java, QueueADT.java, ThemeParkApp.java
// Course: CS300 2020 SP
//
// Author: ZHAN YU
// Email: zyu293@wisc.edu
// Lecturer's Name: Gary
//
//////////// PAIR PROGRAMMING (MAY SKIP WHEN WORKING INDIVIDUALLY) ////////////
//
// Partner Name: NONE
// Partner Email: NONE
// Partner Lecturer's Name: NONE
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

/**
 * An instantiable class that will be used to represent groups entering the ride line.
 * @author Zhan Yu
 *
 */
public class BoardingGroup {

  String name = "";
  int num = 0;
  private boolean vip = false;
  /**
   * A constructor of the class
   * @param name name of the group
   * @param num number of the group members
   */
  public BoardingGroup(String name,int num) {
    this.name = name;
    this.num = num;
    
  }
  /**
   * A accessor for setting the group to be a VIP
   * @return true since the group is signed to be VIP 
   */
  public boolean getVIP() {
        return this.vip;
  }
  /**
   * A mutator for setting the group to be a VIP
   * @param flag indicates whether the group is VIP or not
   * @return true since the group is signed to be VIP 
   */
  public boolean setVIP(boolean flag) {
    this.vip = true;
    return flag;
  }
  /**
   * A accessor for getting the name
   * @return the name of the group
   */
  public String getName() {
    return this.name;
  }
  /**
   *A accessor for getting the number of the group
   * @return the number of the group members 
   */
  public int getNum() {
    return this.num;
  }
}
