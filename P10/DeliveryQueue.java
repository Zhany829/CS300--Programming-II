import java.util.NoSuchElementException;

//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: FoodDelivery
// Files: Student.java, FoodRobot.java, Delivery.java, DeliveryQueue.java, DeliveryQueueTester.java,
//////////////// DeliverySchedulingApp.java,
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
// Online Sources: www.techiedelight.com
//
///////////////////////////////////////////////////////////////////////////////
/***
 * This class aims to implement heap-based Priority Queue. This heap stores elements of type
 * Delivery in a zero-index based array that represents a min heap (where the shortest distance,
 * which has the highest priority is always stored at the root)
 * 
 * @author Zhan Yu
 *
 */
public class DeliveryQueue {
  private static final int INITIAL_CAPACITY = 20;
  private Delivery[] heap;
  private int size;

  /**
   * Constructor of the class which initializes instance fields.
   */
  public DeliveryQueue() {
    this.size = 0;
    heap = new Delivery[INITIAL_CAPACITY];
  }

  /**
   * Create a string contains information of the delivery queue.
   * 
   * @return string representation of the queue
   */
  @Override
  public String toString() {
    String string = "This DeliveryQueue contains " + size + " elements";
    if (size == 0) {
      return string;
    }
    string += ": [ ";
    for (int i = 0; i < size; i++)
      string += "\n" + heap[i].toString();
    string += " ]\n";
    return string;
  }

  /**
   * This method adds a new delivery to this priority queue.
   * 
   * @param newDelivery new delivery for adding to the heap
   */
  public void offerDelivery(Delivery newDelivery) {
    if (this.size ==heap.length) {
      Delivery[] temp = heap;
      heap = new Delivery[temp.length * 2];
      for (int i = 0; i < temp.length; i++) {
        heap[i] = temp[i];
      }
      heap[temp.length] = newDelivery;
      this.size++;
      percolateUp(temp.length);
    } else {
      this.size++;
      heap[size-1] = newDelivery;
      percolateUp(size-1);
  
    }
  }

  /**
   * This method removes and returns the highest priority delivery object from this priority queue,
   * and also removes all other delivery objects that “equals” (with matching studentIds or
   * robotNames) that highest priority one. After removing these deliveries, be sure to heapify your
   * array to maintain its heap structure.
   * 
   * @return the highest priority delivery object from this priority queue
   * @throws NoSuchElementException if the heap is empty
   */
  public Delivery pollBestDelivery() {
    if (isEmpty()) {
      throw new NoSuchElementException("Warning: Empty Heap!");
    }
    Delivery same = heap[0];
    size-=1;
    heap[0]=heap[size];
    
  percolateDown(0);
  int index=0;
    while(index<size) {
      if(heap[index].equals(same)) {
  for(int i =index; i<size-1;i++) {
      heap[i]=heap[i+1];
    }
  heap[size-1]=null;
  this.size-=1;
  }
      else {
        index+=1;
      }
    }
  heapify();
    return same;
  
  }
    
  /**
   * This method aims to return the highest priority delivery
   * 
   * @return the highest priority delivery.
   * @throws a NoSuchElementException with the message “Warning: Empty Heap!”
   */
  public Delivery peek() {
    if (this.size == 0) {
      throw new NoSuchElementException("Warning: Empty Heap!");
    }
    return heap[0];
  }

  /**
   * This method returns the number of Delivery objects currently in this priority queue
   * 
   * @return the size of the queue
   */
  public int getSize() {
    return this.size;
  }

  /**
   * This method returns true when this priority queue is empty, and false otherwise
   * 
   * @return true when this priority queue is empty, and false otherwise
   */
  public boolean isEmpty() {
    if (size == 0)
      return true;
    return false;
  }

  /**
   * This method recursively propagates heap order violations up
   * 
   * @param index the start index for bubble up
   */
  private  void percolateUp(int index) {
    if(index!=0) {
 // check whether the node and its parent violates the heap property
    if (index > 0 && heap[getParentIndex(index)].compareTo(heap[index])>0){
        // swap the two if heap property is violated
        swap( getParentIndex(index), index);
        // call percolateUp on the parent
        percolateUp(getParentIndex(index));
      }
    }
  }

  /**
   * This method recursively propagates heap order violations down
   * 
   * @param index the start index for bubble down
   */
  private void percolateDown(int index) {
    int leftChild = getLeftChildIndex(index);
    int rightChild = getRightChildIndex(index);
    int min = index;
    //compare node at the given index and its children to find the maximum value
      if (leftChild<this.size&&heap[leftChild].compareTo(heap[min]) < 0) { // compare current node with left child
        min=leftChild;
      } 
      if (rightChild<this.size&&heap[rightChild].compareTo(heap[min]) <0) { // compare current node with right child
        min=rightChild;
      } 
      if(min!=index) {
     // swap with child having greater value
        swap(index, min);

        // call percolateDown on the child
        percolateDown(min);
     
    }
  }

  /**
   * This method eliminates all heap order violations from the heap array
   */
  private void heapify() {
    for(int i = size/2;i>=1;i--) {
      percolateUp(i);
      }
    }
  
  /**
   * get the index of parent node
   * @param child index of child
   * @return  index of parent
   */
  public int getParentIndex(int child) {
    return (int)Math.floor((child-1)/2);
  }
  /**
   * get the index of left child
   * @param parent  index of parent node
   * @return index of left child 
   */
  public int getLeftChildIndex(int parent) {
    return parent*2+1;
  }
  /**
   * get the index of right child
   * @param parent  index of parent node
   * @return index of right child 
   */
  public int getRightChildIndex(int parent) {
    return parent*2+2;
  }
  /**
   * swap two elements in two indexes
   * @param first  index of first element
   * @param second second index of second element
   */
  public void swap(int first, int second) {
    Delivery temp = heap[first];
    heap[first] = heap[second];
    heap[second] = temp;
    
  }
}
