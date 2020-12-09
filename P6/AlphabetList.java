//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: LinkedCart
// Files: LinkedCart.java, AlphabetList.java, AlphabetListTester.java, Cart.java,
//////////////// SortedListADT.java, ListADT.java
// Course: CS300 2020 SP
//
// Author: ZHAN YU
// Email: zyu293@wisc.edu
// Lecturer's Name: Gary
//
//////////// PAIR PROGRAMMING (MAY SKIP WHEN WORKING INDIVIDUALLY) ////////////
//
// Partner Name: Hunter Zhang
// Partner Email: zzhang978@wisc.edu
// Partner Lecturer's Name: Hobbes
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
 * This class models a sorted doubly linked list of carts. Each cart carries one upper case alphabet
 * letter. Duplicate letters are not allowed in this list.
 * 
 * @author ZHAN YU && Hunter Zhang
 *
 */
public class AlphabetList implements SortedListADT<Cart> {

  private static final Cart MIN_CART = new Cart("A"); // The smallest cart that
  // can be added to this sorted list
  private static final Cart MAX_CART = new Cart("Z"); // The largest cart that
  // can be added to this sorted list
  private LinkedCart head; // head of this doubly linked list
  private LinkedCart tail; // tail of this doubly linked list
  private int size; // size of this list
  private int capacity; // maximum number of carts which can be stored in this list

  /**
   * Creates an empty doubly linked list of carts with a given capacity
   * 
   * @param capacity - maximum number of carts to be connected in this list of carts
   * @throws IllegalArgumentException if the passed capacity is zero or a negative integer
   */
  public AlphabetList(int capacity) throws IllegalArgumentException {
    try {

      this.capacity = capacity;
      if (capacity() <= 0) {
        throw new IllegalArgumentException(
            "The capacity of this list must be a non-zero a positive integer.");
      }
    } catch (Exception e) {
      e.getMessage();
      throw new IllegalArgumentException(
          "The capacity of this list must be a non-zero a positive integer.");
    }
  }

  /**
   * Creates an empty doubly linked list of carts with a capacity equals to 26
   */
  public AlphabetList() {
    this.capacity = 26;

  }

  /**
   * Returns a String representation of this list. Note that the implementation details of this
   * method is provided in the assignment's specification.
   * 
   * @return a String representation of this list
   */
  @Override
  public String toString() {
    String string = "This list contains " + size + " cart(s)";
    if (size == 0) {
      return string;
    }
    string += ": [ ";
    LinkedCart currentCart = head;
    while (currentCart != null) {
      string += currentCart.getCart().toString() + " ";
      currentCart = currentCart.getNext();
    }
    string += "]";
    return string;
  }

  /**
   * Reads the contents of this list in the forward direction starting from its head.
   * 
   * @return a String representation of the contents of this list read in the forward direction or
   *         an empty string if this list is empty.
   */
  public String readForward() {
    LinkedCart visit = head;
    if(size() == 1) {
      return head.getCart().getCargo();
    }
    String stringRepresentation = "";
    while (visit != null) {
      stringRepresentation += visit.getCart().getCargo();
      visit = visit.getNext();
    }
    return stringRepresentation;
  }

  /**
   * Reads the contents of this list in the backward direction starting from its tail
   * 
   * @return a String representation of the contents of this list read in the backward direction or
   *         an empty string if this list is empty.
   */
  public String readBackward() {
    LinkedCart visit = tail;
    String stringRepresentation = "";
    while (visit != null) {
      stringRepresentation += visit.getCart().getCargo();
      visit = visit.getPrevious();
    }
    return stringRepresentation;
  }

  /**
   * isEmpty() Checks whether this list is empty.
   * 
   * @return true if the list is empty, false otherwise
   */
  @Override
  public boolean isEmpty() {
    if (size == 0)
      return true;
    return false;
  }

  /**
   * Adds a new cart to this sorted list.
   * 
   * @param newObject to add
   * @throws IllegalArgumentException if newCart does not carry one upper-case letter in the range
   *                                  "A" .. "Z" 
   * @throws IllegalArgumentException if this list contains already a cart carrying
   *                                  the same letter.
   * @throws IllegalStateException    if this list reached its capacity or if this list is full
   */
  @Override
  public void add(Cart newObject) throws IllegalArgumentException, IllegalStateException {

    LinkedCart newNode = new LinkedCart(newObject);
    boolean flag = false;
    try {
      //check whether the list has the same cart
      if (head != null && head.getCart().toString().equals(newObject.toString())) {
        flag = true;
      }
      for (LinkedCart visit = head; visit != null; visit = visit.getNext()) {
        if (visit.getCart().toString().equals(newObject.toString())) {
          flag = true;
          break;
        }
      }
      if (head != null && head.getCart().equals(newObject)) {
        flag = true;
      }

      if (flag) {
        throw new IllegalArgumentException(
            "Can only add carts carrying one upper-case alphabetic letter in the range A .. Z.");
      }
      //check the passed cart is valid
      if (newObject.compareTo(MIN_CART) < 0 || newObject.compareTo(MAX_CART) > 0) {
        throw new IllegalArgumentException(
            "Can only add carts carrying one upper-case alphabetic letter in the range A .. Z.");
      }
      //check whether the list is full
      if (size() == capacity) {
        throw new IllegalStateException("This list is full. Cannot add another cart.");
      }

    } catch (IllegalArgumentException e) {
      e.getMessage();
      throw new IllegalArgumentException(
          "Can only add carts carrying one upper-case alphabetic letter in the range A .. Z.");
    } catch (IllegalStateException e) {
      e.getMessage();
      throw new IllegalStateException("This list is full. Cannot add another cart.");
    }

    // If list is empty
    if (head == null) {
      // Both head and tail will point to newNode
      head = tail = newNode;

      // head's previous will point to null
      newNode.setPrevious​(null);
      // tail's next will point to null, as it is the last node of the list
      newNode.setNext​(null);

      this.size += 1;

    } else {
      // insert at index 0 of the
      if (newObject.compareTo(this.head.getCart()) < 0) {
        this.head.setPrevious​(newNode);
        newNode.setPrevious​(null);
        newNode.setNext​(this.head);
        this.head = newNode;
        this.size += 1;
      }
      // insert at the end of the list
      else if (newObject.compareTo(this.tail.getCart()) > 0) {
        this.tail.setNext​(newNode);
        newNode.setPrevious​(this.tail);
        this.tail = newNode;
        this.size += 1;
      }
      // insert node in the middle of the list
      else {
        LinkedCart visit = head;

        while (visit.getNext() != null && (visit.getNext().getCart().compareTo(newObject) < 0)) {
          visit = visit.getNext();
          if (visit.getNext() != null)
            visit.setNext​(visit.getNext());
        }
        LinkedCart sucNode = visit.getNext();

        visit.setNext​(newNode);
        sucNode.setPrevious​(newNode);
        newNode.setPrevious​(visit);
        newNode.setNext​(sucNode);

        this.size += 1;
      }
    }

  }



  /**
   * Returns the size of this list
   * 
   * @return the number of carts linked in this list
   */
  @Override
  public int size() {

    return this.size;
  }

  /**
   * Returns the capacity of this list in terms of maximum number of carts which can be stored in
   * it.
   * 
   * @return the capacity of this list
   */
  public int capacity() {
    return this.capacity;
  }

  /**
   * Removes all the elements stored in this list. This list must be empty after this method returns
   */
  @Override
  public void clear() {
    head = null;
    tail = null;
    size = 0;
  }

  /**
   * Returns the cart at position index of this list without removing it
   * 
   * @param index - of the cart to return
   * @return the cart of this sorted list at the given index
   */
  @Override
  public Cart get(int index) {
    LinkedCart visit = head;
    for (int i = 0; i < index; i++) {
      visit = visit.getNext();
    }

    return visit.getCart();
  }

  /**
   * Returns the index of the cart carrying data within this list
   * 
   * @param findCart - cart to find in this list
   * @return the index of findCart within this list or -1 if this list does not contain that cart.
   */
  @Override
  public int indexOf(Cart findObject) {

    int index = 0;
    LinkedCart visit = head;
    if (visit == null) {
      return -1;
    }
    while (visit.getCart().toString() != findObject.toString()) {
      visit = visit.getNext();
      index += 1;
      if (index == size) {
        return -1;
      }
    }
    return index;
  }

  /**
   * Returns and removes the cart from this sorted list at the given index position
   * 
   * @param index - of the cart to be removed
   * @return the removed cart
   * @throws java.lang.IndexOutOfBoundsException - with the following error message "Invalid index."
   *                                             if index is less than 0 or index is larger or equal
   *                                             to size()
   */
  @Override
  public Cart remove(int index) throws java.lang.IndexOutOfBoundsException {

    LinkedCart curNode = new LinkedCart(get(index));
    LinkedCart sucNode = curNode.getNext();
    LinkedCart preNode = curNode.getPrevious();

    if (index < 0 || index >= size()) {
      throw new IndexOutOfBoundsException("Invalid index.");
    }
    if (head != null && tail != null) {
      // remove the head node of the list
      if (size()==1) {
        Cart removedone = curNode.getCart();
        clear();
        return removedone;
        // remove the node at the end of the list
      } 
      else if(index==0) {
        curNode = this.head;
        sucNode = curNode.getNext();
        sucNode.setPrevious​(null);
        this.head = sucNode;
        this.size--;
        return curNode.getCart();
      }
      else if (index == size() - 1) {
        curNode = tail;
        preNode = tail.getPrevious();
        preNode.setNext​(null);
        tail = preNode;
        this.size -= 1;
        return curNode.getCart();
      }
      // remove the node in the middle of the list
      else {
        LinkedCart visit = head;
        while (visit.getNext() != null && !(visit.getNext().getCart().equals(curNode.getCart()))) {
          visit = visit.getNext();
          if (visit.getNext() != null)
            visit.setNext​(visit.getNext());

        }
        visit.setNext​(visit.getNext().getNext());
        visit.getNext().setPrevious​(visit);
     
      }
    }
    this.size -= 1;
    return head.getNext().getCart();

  }


}


