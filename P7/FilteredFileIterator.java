import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.NoSuchElementException;

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
/***
 * This class aims to print some files by filtering
 * 
 * @author ZHAN YU
 *
 */
public class FilteredFileIterator implements Iterator {

  private DeepFileIterator fileIterator;// a DeepFileIterator that steps through all files within
                                        // the initial directory (and all contained sub
                                        // directories).
  private String searchPattern; // a String that must be part of a file’s name in order for that
                                // file to be returned from this iterator’s next method
  private File nextMatchingFile;// a File reference to the next file that this iterator will return
                                // (or null, if there are no more files containing this string in
                                // their file name left to be returned). Note that
  // this iterator must look ahead for such files, in order for it’s hasNext() method to reliably
  // indicate whether another matching file can be returned or not.

  /**
   * Constructor of the class
   * 
   * @param file  a java.io.File reference to the directory that it iterates through
   * @param searchPattern a string used to filter the results that are returned from this iterator.
   * @throws FileNotFoundException if the specified file does not exist within the local filesystem
   */
  public FilteredFileIterator(File file, String searchPattern) throws FileNotFoundException {
    if (!file.exists())
      throw new FileNotFoundException("The file does not exist.");
    this.searchPattern = searchPattern;
    fileIterator = new DeepFileIterator(file);
      
    nextMatchingFile = callNext();
  }
  /**
   * A private helper method aims to get next file 
   * @return  next file that matched
   */
  private  File callNext() {
   
    while(fileIterator.hasNext()) {
      File temp = ((File) fileIterator.next());
    if(temp.getName().contains(searchPattern)) {
     
      return temp;
    }
    }
    return null;
    
  }
  /**
   * This method is used to check whether this file directory has other file(s)
   * 
   * @return True if this directory has other file(s), false otherwise
   */
  @Override
  public boolean hasNext() {
    if(nextMatchingFile != null) 
       return true;
      return false;

  }

  /**
   * This method used to iterate and find the next file object inside the given directory
   * 
   * @return a reference to a different File that is contained within the provided directory
   * @throws NoSuchElementException if there is no next file inside the given directory
   */
  @Override
  public Object next() {
    if (this.hasNext()) {
      Object temp = this.nextMatchingFile;
      this.nextMatchingFile = this.callNext();
      return temp;
    } else {
      throw new NoSuchElementException("There is no other file object in the directory.");
    }
}
}
