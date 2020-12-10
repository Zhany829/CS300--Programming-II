//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: PatientRecordTree
// Files: PatientRecordTree.java, PatientRecordTreeTester.java, PatientRecord.java, PatientRecordNode.java
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
 * This class models a patient record node in a binary search tree.
 *
 */
public class PatientRecordNode {
  private PatientRecord data; // data field which represents a patient within this PatientNode.
  private PatientRecordNode rightChild; // reference to the right child of this PatientNode.
  private PatientRecordNode leftChild; // reference to the left child of this PatientNode.
  
  /**
   * Creates a new PatientNode with given data and null for both left and right children
   * @param data reference to the data of this PatientNode
   */
  public PatientRecordNode(PatientRecord data) {
    this.data = data;
  }

  /**
   * Gets the right child of this PatientNode
   * @return the rightChild of this PatientNode
   */
  public PatientRecordNode getRightChild() {
    return rightChild;
  }

  /**
   * Sets the right child of this PatientNode
   * @param rightChild the rightChild to set
   */
  public void setRightChild(PatientRecordNode rightChild) {
    this.rightChild = rightChild;
  }

  /**
   * Gets the left child of this PatientNode
   * @return the leftChild of this PatientNode
   */
  public PatientRecordNode getLeftChild() {
    return leftChild;
  }

  /**
   * Sets the left child of this PatientNode
   * @param leftChild the leftChild to set
   */
  public void setLeftChild(PatientRecordNode leftChild) {
    this.leftChild = leftChild;
  }

  /**
   * Returns the patient record of this PatientNode
   * @return the data of this binary node.
   */
  public PatientRecord getPatientRecord() {
    return data;
  }
  
  

}