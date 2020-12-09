//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: ShallowFileIterator
// Files: ShallowFileIterator.java, P07Tester.java, DeepFileIterator.java, FilteredFileIterator.java
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
import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;

/***
 * This class aims to test the correctness of methods in ShallowFileIterator.java
 * 
 * @author Zhan Yu
 *
 */
public class P07Tester {
  /***
   * Calls the test methods implemented in this class and displays their output
   * 
   * @param args input arguments if any
   * @throws FileNotFoundException
   */
  public static void main(String[] args) throws FileNotFoundException {

    System.out.println(testShallowFileIterator(new File("fileSystem")));
    System.out.println(testDeepFileIterator(new File("fileSystem")));
    System.out.println(testFilteredFileIterator(new File("fileSystem")));
    
    
    
  }

  /**
   * Checks whether ShallowFileIterator works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   * @catch FileNotFoundException if the file cannot be found
   */
  public static boolean testShallowFileIterator(File file) throws FileNotFoundException {
    try {
      ShallowFileIterator fold = new ShallowFileIterator(file);
      String expectedResults =
          "assignments, exam preparation, lecture notes, " + "reading notes, todo.txt, ";
      String result = "";
      while (fold.hasNext()) {
        result += ((File) fold.next()).getName() + ", ";
      }
      if (result.equals(expectedResults))
        return true;
    } catch (FileNotFoundException e) {
      if (e.getMessage().contains("Cannot find file."))
        ;
      return true;
    }
    return false;
  }

  /**
   * Checks whether DeepFileIterator works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   * @catch NoSuchElementException if there is no object inside the directory
   */
  public static boolean testDeepFileIterator(File file) {
    file = new File(file.getPath() + File.separator + "assignments");
    String result = "";
    String expectedResults = "P01, PiggyBank.java, P02, CalendarPrinter.java, P03, "
        + "ElasticBank.java, P04, ExceptionalPiggyBank.java, P05, ExtendedVersion, "
        + "WinterCarnival.java, WinterCarnival.java, P06, AlphabetTrain.java, ";
    try {

      DeepFileIterator fold = new DeepFileIterator(file);

      while (fold.hasNext()) {

        result += ((File) fold.next()).getName() + ", ";
      }

      if (result.equals(expectedResults))
        return true;
    } catch (NoSuchElementException e) {
      if (e.getMessage().contains(("There is no other file object in the directory.")))
        ;
      return true;
    }
    return false;
  }

  /**
   * Checks whether FilteredFileIterator works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   * @throws FileNotFoundException if the input file can not be found
   * @catch NoSuchElementException if there is no object inside the directory
   */
  public static boolean testFilteredFileIterator(File file) throws FileNotFoundException {

    String result = "";
    String expectedResults = "PiggyBank.java, CalendarPrinter.java, ElasticBank.java, "
        + "ExceptionalPiggyBank.java, WinterCarnival.java, WinterCarnival.java, "
        + "AlphabetTrain.java, codeSamples.java, ";
    try {

      FilteredFileIterator fold = new FilteredFileIterator(file, ".java");
     
      while (fold.hasNext()) {
        result += ((File) fold.next()).getName() + ", ";
      }
     
      if (result.equals(expectedResults))
        return true;
    } catch (NoSuchElementException e) {
      if (e.getMessage().contains(("There is no other file object in the directory.")));
      return true;
    }
    return false;
  }



}

