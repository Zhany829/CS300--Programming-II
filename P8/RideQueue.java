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
/***
 *  This class is for creating a queue of boarding groups
 *  @author ZHAN YU 
 */
import java.util.NoSuchElementException;

public class RideQueue implements QueueADT<BoardingGroup> {

  private BGNode front;
  private BGNode back;
  private int capacity;// max number of people that can fit into the queue
  private int numOfPeople;
  private int numOfGroups;

  /**
   * Constructs an empty queue with the designated capacity.
   * 
   * @param capacity The number of people this queue can fit.
   */
  public RideQueue(int capacity) {
    this.capacity = capacity;
  }

  /**
   * Determines whether or not this queue is empty.
   * 
   * @return true when queue is empty, false otherwise.
   */
  @Override
  public boolean isEmpty() {
    if (size() == 0)
      return true;
    return false;
  }

  /**
   * Gives the number of BoardingGroup nodes in this queue.
   * 
   * @return the current number of nodes in the queue.
   */
  @Override
  public int size() {
    // TODO Auto-generated method stub
    return this.numOfGroups;
  }

  /**
   * Returns a string representation of this RideQueue.
   * 
   * @return a string representation of this RideQueue.
   */
  public String toString() {
    String s = "Number of People in Queue: " + this.numOfPeople + "\n";
    s += "Number of Groups in Queue: " + this.numOfGroups + "\n";
    s += "Group Names in Queue: ";
    BGNode current = front;
    while (current != null) {
      String groupName = current.getGroup().getName();
      s += groupName + " ";
      current = current.getNext();
    }
    return s;
  }

  /**
   * Adds the newGroup to the queue. newGroup - The BoardingGroup to be added to the queue.
   * @param newObject the group for adding to the queue
   * @throws java.lang.IllegalStateException - If the newGroup cannot fit into the queue. The
   *                                         exception should have a meaningful message.
   */
  @Override
  public void enqueue(BoardingGroup newObject)throws java.lang.IllegalStateException {
    if(this.numOfPeople+newObject.getNum() > capacity) { 
    throw new IllegalStateException("The size is full, so the new obeject cannot fit in.");
    }else {
      this.numOfPeople += newObject.getNum();
    }
    if (this.numOfPeople >= capacity) {
      throw new IllegalStateException("The size is full, so the new obeject cannot fit in.");
    }
    if(newObject.getVIP()) {
        BGNode newFront = new BGNode(newObject);
        BGNode temp=front;
        front = newFront;
        front.setNext(temp);
    }
    if (isEmpty()) {
      this.front = this.back = new BGNode(newObject);

    } else {
      BGNode temp = new BGNode(newObject);
      this.back.setNext(temp);
      back = temp;

    }

    this.numOfGroups += 1;
  }

  /**
   * Removes all groups from this queue. This queue will become empty.
   */
  @Override
  public void clear() {
    this.front = null;
    this.back = null;
    this.numOfPeople = 0;
    this.numOfGroups = 0;

  }

  /**
   * Returns the BoardingGroup at the front of this queue without removing it.
   * 
   * @return The Group at the front of the line.
   * @throws java.util.NoSuchElementException - If this queue is empty. The exception should have a
   *                                          meaningful message.
   */
  @Override
  public BoardingGroup peek() throws NoSuchElementException {
    if (isEmpty()) {
      throw new NoSuchElementException("There is no element in the queue.");
    }
    return front.getGroup();
  }

  /**
   * Returns the BoardingGroup at the front of this queue and removes it.
   * 
   * @return The BoardingGroup that was removed from this queue.
   * @throws java.util.NoSuchElementException - If this queue is empty. The exception should have a
   *                                          meaningful message.
   */
  @Override
  public BoardingGroup dequeue() throws java.util.NoSuchElementException {
    if(isEmpty()) {
      throw new NoSuchElementException("There is no element in the queue");
    }
    BoardingGroup temp = front.getGroup();
    this.front = front.getNext();
    this.numOfGroups-=1;
    this.numOfPeople -= temp.getNum();
    return temp;
  }


}
