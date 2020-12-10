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

public class BGNode {

  private BoardingGroup group;
  private BGNode next;

  public BGNode(BoardingGroup group) {
    this.group = group;
    this.next = null;
  }

  public BGNode(BoardingGroup group, BGNode next) {
    this.group = group;
    this.next = next;
  }

  public BoardingGroup getGroup() {
    return group;
  }

  public BGNode getNext() {
    return next;
  }

  public void setNext(BGNode next) {
    this.next = next;
  }

}
