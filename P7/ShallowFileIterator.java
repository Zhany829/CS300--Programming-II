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
import java.util.Iterator;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Arrays;// (only to call Arrays.sort)

/***
 * This class aims to print all files in shallow degree
 * 
 * @author ZHAN YU
 *
 */
public class ShallowFileIterator implements java.util.Iterator {

  private File[] folderContents; // a sorted array of File references which this
  // iterator steps through: containing references to
  // all files in the specified directory (see Appendix
  // for File.listFiles() reference, and for the
  // Arrays.sort() method that can be used to sort them)
  private int nextIndex; // – the int index specifying the next File within
                         // folderContents that this iterator’s next() method will
                         // return

  /**
   * A constructor of the class
   * 
   * @param file refers to a directory that exists within your file system
   * @throws FileNotFoundException When the argument passed to your ShallowFileIterator’s
   *                               constructor does not exist within the local file system
   */
  public ShallowFileIterator(File file)throws  FileNotFoundException {
   
  
      if (file.exists() == true) {
        
        folderContents = file.listFiles();
        Arrays.sort(folderContents);
      }else
        throw new FileNotFoundException("Cannot find file.");
    } 
   
   
  /**
   * Returns true if the iteration has more elements. (In other words, returns true if next() would
   * return an element rather than throwing an exception.)
   * 
   * @return false if all contained files have been returned in this way
   */
  @Override
  public boolean hasNext() {
    
    return nextIndex < folderContents.length;
  }

  /**
   * Returns the next element in the iteration.
   * 
   * @return a reference to a different java.io.File that is contained within the provided
   *         directory.
   * @throw a NoSuchElementException if the iteration has no more elements
   */
  @Override
  public Object next() {
    if(!hasNext()) {
      throw new NoSuchElementException("The iterator has no more elements");
    }
    this.nextIndex += 1;
    return folderContents[nextIndex-1];
  }

}
