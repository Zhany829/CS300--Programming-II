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
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
/***
 * This class aims to print all files in deep degree
 * 
 * @author ZHAN YU
 *
 */
public class DeepFileIterator implements Iterator {


  private File[] folderContents; // a sorted array of File references which this
  // iterator steps through: containing references to
  // all files in the specified directory (see Appendix
  // for File.listFiles() reference, and for the
  // Arrays.sort() method that can be used to sort them)
  private int nextIndex; // – the int index specifying the next File within
                         // folderContents that this iterator’s next() method will
                         // return

  private DeepFileIterator contentsIterator;

  /**
   * A constructor of the class
   * 
   * @param file refers to a directory that exists within your file system
   * 
   */
 
    public DeepFileIterator(File file) {
      this.folderContents = file.listFiles();
      if (this.folderContents != null)
        Arrays.sort(this.folderContents);
      this.nextIndex = 0;
    }

    /**
     * This method is used to check whether this file directory has other file(s)
     * 
     * @return True if this directory has other file(s), false otherwise
     */
    @Override
    public boolean hasNext() {
      if (this.folderContents != null)
        if (this.folderContents.length > this.nextIndex)
          return true;
        else if (this.contentsIterator != null)
          return this.contentsIterator.hasNext();
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
        if (this.contentsIterator != null && this.contentsIterator.hasNext()) {
          // if there are still some file inside the contentsIterator
          return this.contentsIterator.next();
        } else {
          if (this.folderContents[this.nextIndex].isDirectory()
              && this.folderContents[this.nextIndex].listFiles().length > 0) {
            // if the contentsIterator is a directory which contain file
            this.contentsIterator = new DeepFileIterator(this.folderContents[this.nextIndex]);
            return this.folderContents[this.nextIndex++];
          } else {
            // if the contentsIterator is an empty directory or a file
            return this.folderContents[this.nextIndex++];
          }
        }
      } else
        throw new NoSuchElementException("There is no other file object in the directory.");
    }
  }
