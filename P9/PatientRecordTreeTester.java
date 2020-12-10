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
import java.util.NoSuchElementException;

/**
 * This class checks the correctness of the implementation of the methods defined in the class
 * PatientRecordTree.
 *
 *@author Zhan Yu
 */

public class PatientRecordTreeTester {

  /**
   * Checks the correctness of the implementation of both addPatientRecord() and toString() methods
   * implemented in the PatientRecordTree class. This unit test considers at least the following
   * scenarios. (1) Create a new empty PatientRecordTree, and check that its size is 0, it is empty,
   * and that its string representation is an empty string "". (2) try adding one patient record and
   * then check that the addPatientRecord() method call returns true, the tree is not empty, its
   * size is 1, and the .toString() called on the tree returns the expected output. (3) Try adding
   * another patientRecord which is older that the one at the root, (4) Try adding a third patient
   * Record which is younger than the one at the root, (5) Try adding at least two further patient
   * records such that one must be added at the left subtree, and the other at the right subtree.
   * For all the above scenarios, and more, double check each time that size() method returns the
   * expected value, the add method call returns true, and that the .toString() method returns the
   * expected string representation of the contents of the binary search tree in an ascendant order
   * from the oldest patient to the youngest one. (6) Try adding a patient whose date of birth was
   * used as a key for a patient record already stored in the tree. Make sure that the
   * addPatientRecord() method call returned false, and that the size of the tree did not change.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAddPatientRecordToStringSize() {
    boolean flag1, flag2, flag3, flag4, flag5 = true;
    boolean scenarioA, scenarioB, scenarioC, scenarioD, scenarioE, scenarioF = true;
    PatientRecordTree emptyOne = new PatientRecordTree();
    // scenario 1
    scenarioA = (emptyOne.size() == 0 && emptyOne.toString().equals("") && emptyOne.isEmpty());
    // scenario 2
    PatientRecordTree second = new PatientRecordTree();
    flag1 = second.addPatientRecord(new PatientRecord("Mark", "1/1/1999"));
    scenarioB = flag1 && !second.isEmpty() && second.size() == 1
        && second.toString().equals("Mark(1/1/1999)" + "\n");
    // scenario 3
    PatientRecordTree third = new PatientRecordTree();
    flag1 = third.addPatientRecord(new PatientRecord("Mar", "1/1/1998"));
    flag2 = third.addPatientRecord(new PatientRecord("Mark", "1/1/1999"));
    scenarioC = flag1 && flag2 && !third.isEmpty() && third.size() == 2
        && third.toString().equals("Mar(1/1/1998)" + "\n" + "Mark(1/1/1999)" + "\n");
    // scenario 4
    PatientRecordTree fourth = new PatientRecordTree();
    flag1 = fourth.addPatientRecord(new PatientRecord("Mar", "1/1/1998"));
    flag2 = fourth.addPatientRecord(new PatientRecord("Mrk", "1/1/1999"));
    flag3 = fourth.addPatientRecord(new PatientRecord("Mark", "2/1/1999"));
    scenarioD =
        (flag1 && flag2 && flag3 && !fourth.isEmpty() && fourth.size() == 3 && fourth.toString()
            .equals("Mar(1/1/1998)" + "\n" + "Mrk(1/1/1999)" + "\n" + "Mark(2/1/1999)" + "\n"));
    // scenario 5
    PatientRecordTree fifth = new PatientRecordTree();
    flag1 = fifth.addPatientRecord(new PatientRecord("Mar", "1/1/1998"));
    flag2 = fifth.addPatientRecord(new PatientRecord("Mrk", "1/1/1999"));
    flag3 = fifth.addPatientRecord(new PatientRecord("Mark", "2/1/1999"));
    flag4 = fifth.addPatientRecord(new PatientRecord("Jack", "2/1/2000"));
    flag5 = fifth.addPatientRecord(new PatientRecord("Jac", "2/1/1978"));
    scenarioE = (flag1 && flag2 && flag3 && flag4 && flag5 && !fifth.isEmpty() && fifth.size() == 5
        && fifth.toString().equals("Jac(2/1/1978)" + "\n" + "Mar(1/1/1998)" + "\n" + "Mrk(1/1/1999)"
            + "\n" + "Mark(2/1/1999)" + "\n" + "Jack(2/1/2000)" + "\n"));
    // scenario 6
    flag1 = fifth.addPatientRecord(new PatientRecord("Mar", "1/1/1998"));
    scenarioF = (!flag1 && !fifth.isEmpty() && fifth.size() == 5
        && fifth.toString().equals("Jac(2/1/1978)" + "\n" + "Mar(1/1/1998)" + "\n" + "Mrk(1/1/1999)"
            + "\n" + "Mark(2/1/1999)" + "\n" + "Jack(2/1/2000)" + "\n"));
    if (scenarioA && scenarioB && scenarioC && scenarioD && scenarioE && scenarioF)
      return true;
    return false;
  }

  /**
   * This method checks mainly for the correctness of the PatientRecordTree.lookup() method. It must
   * consider at least the following test scenarios. (1) Create a new PatientRecordTree. Then, check
   * that calling the lookup() method with any valid date must throw a NoSuchElementException. (2)
   * Consider a PatientRecordTree of height 3 which consists of at least 5 PatientRecordNodes. Then,
   * try to call lookup() method to search for the patient record at the root of the tree, then a
   * patient records at the right and left subtrees at different levels. Make sure that the lookup()
   * method returns the expected output for every method call. (3) Consider calling .lookup() method
   * on a non-empty PatientRecordTree with a date of birth not stored in the tree, and ensure that
   * the method call throws a NoSuchElementException.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAddPatientRecordAndLookup() {
    PatientRecordTree test = new PatientRecordTree();
    boolean flag1 = false;
    boolean flag2, flag3, flag4, flag5 = false;
    // scenario 1
    try {
      test.lookup("1/1/2011");
    } catch (NoSuchElementException e) {
      if (e.getMessage().contains("No search results."))
        ;
      flag1 = true;
    }
    // scenario 2
    test.addPatientRecord(new PatientRecord("Ma", "3/1/1997"));
    test.addPatientRecord(new PatientRecord("Mrk", "4/1/1996"));
    test.addPatientRecord(new PatientRecord("Mark", "5/1/1995"));
    test.addPatientRecord(new PatientRecord("Jack", "4/1/1999"));
    test.addPatientRecord(new PatientRecord("Jac", "12/1/2000"));
    flag2 = test.lookup("3/1/1997").toString().equals("Ma(3/1/1997)");
    flag3 = test.lookup("4/1/1996").toString().equals("Mrk(4/1/1996)");
    flag4 = test.lookup("12/1/2000").toString().equals("Jac(12/1/2000)");
    // scenario 3
    try {
      test.lookup("1/1/2012");
    } catch (NoSuchElementException e) {
      if (e.getMessage().contains("No search results."))
        ;
      flag5 = true;
    }
    if (flag1 && flag2 && flag3 && flag4 && flag5)
      return true;
    return false;
  }

  /**
   * Checks for the correctness of PatientRecordTree.height() method. This test must consider
   * several scenarios such as, (1) ensures that the height of an empty patient record tree is zero.
   * (2) ensures that the height of a tree which consists of only one node is 1. (3) ensures that
   * the height of a PatientRecordTree with the following structure for instance, is 4. (*) / \ (*)
   * (*) \ / \ (*) (*) (*) / (*)
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testHeight() {
    PatientRecordTree test = new PatientRecordTree();
    boolean scenarioA, scenarioB, scenarioC = true;
    // scenario 1
    scenarioA = test.height() == 0;
    // scenario 2
    test.addPatientRecord(new PatientRecord("Mar", "1/1/1998"));
    scenarioB = test.height() == 1;
    // scenario 3
    test.addPatientRecord(new PatientRecord("Ma", "3/1/1997"));
    test.addPatientRecord(new PatientRecord("Mrk", "4/1/1997"));
    test.addPatientRecord(new PatientRecord("Mark", "5/1/1999"));
    test.addPatientRecord(new PatientRecord("Jack", "4/1/1999"));
    test.addPatientRecord(new PatientRecord("Jac", "12/1/1999"));
    test.addPatientRecord(new PatientRecord("Ja", "3/1/1999"));
    scenarioC = test.height() == 4;
    if (scenarioA && scenarioB && scenarioC)
      return true;
    return false;
  }

  /**
   * Checks for the correctness of PatientRecordTree.getRecordOfYoungestPatient() method.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testGetRecordOfYoungestPatient() {
    PatientRecordTree test = new PatientRecordTree();
    test.addPatientRecord(new PatientRecord("Mar", "1/1/1998"));
    test.addPatientRecord(new PatientRecord("Mrk", "1/1/1999"));
    test.addPatientRecord(new PatientRecord("Mark", "2/1/1999"));
    test.addPatientRecord(new PatientRecord("Jack", "2/1/2000"));
    test.addPatientRecord(new PatientRecord("Jac", "2/1/1978"));
    if (test.getRecordOfYoungestPatient().toString().equals("Jack(2/1/2000)"))
      return true;
    return false;
  }

  /**
   * Checks for the correctness of PatientRecordTree.getRecordOfOldestPatient() method.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testGetRecordOfOldestPatient() {
    PatientRecordTree test = new PatientRecordTree();
    test.addPatientRecord(new PatientRecord("Mar", "1/1/1998"));
    test.addPatientRecord(new PatientRecord("Mrk", "1/1/1999"));
    test.addPatientRecord(new PatientRecord("Mark", "2/1/1999"));
    test.addPatientRecord(new PatientRecord("Jack", "2/1/2000"));
    test.addPatientRecord(new PatientRecord("Jac", "2/1/1978"));
    if (test.getRecordOfOldestPatient().toString().equals("Jac(2/1/1978)"))
      return true;
    return false;
  }

  /**
   * Calls the test methods
   * 
   * @param args input arguments if any
   */
  public static void main(String[] args) {
    System.out.println(testAddPatientRecordToStringSize());
    System.out.println(testGetRecordOfYoungestPatient());
    System.out.println(testGetRecordOfOldestPatient());
    System.out.println(testHeight());
    System.out.println(testAddPatientRecordAndLookup());
  }
}
