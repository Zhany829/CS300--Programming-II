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
/**
 * This class implements unit test methods to check the correctness of LinkedCart and AlphabetList
 * classes defined in the CS300 Spring 2020 - P06 Alphabet Train programming assignment.
 *
 *@author ZHAN YU & Hunter Zhang
 */
public class AlphabetListTester {

  /**
   * This method should test and make use of at least the LinkedCart constructor, an accessor
   * (getter) method, and a mutator (setter) method defined in the LinkedCart class.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testLinkedCart() {
    LinkedCart list = new LinkedCart(new Cart("A"));
    if (list.getCart().toString() != "A")
      return false;
    if (list.getNext() != null)
      return false;
    if (list.getPrevious() != null)
      return false;
    LinkedCart list2 = new LinkedCart(new Cart("B"));
    list2.setPrevious​(list);
    if (list2.getPrevious() != list)
      return false;
    return true;
  }

  /**
   * This method checks for the correctness of both AlphabetList constructors and the instance
   * method isEmpty() when called on an empty alphabet list object.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAlphabetListConstructorIsEmpty() {
    AlphabetList list1 = new AlphabetList();
    AlphabetList list2 = new AlphabetList(2);
    if (list1.isEmpty() == false || list2.isEmpty() == false)
      return false;
    list1.add(new Cart("A"));
    if (list1.isEmpty() == true || list2.isEmpty() == false)
      return false;
    return true;
  }

  /**
   * This method checks for the correctness of the AlphabetList(int) constructor when passed a
   * negative int value.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAlphabetListConstructorBadInput() {
    try {
      AlphabetList list1 = new AlphabetList(-2);
    } catch (IllegalArgumentException e) {
      if (e.getMessage() != null && e.getMessage()
          .contains("capacity of this list must be a non-zero a positive integer."))

        return true;
    }
    return false;
  }


  /**
   * This method checks for the correctness of the AlphabetList.add() method when it is passed bad
   * inputs. This method must consider at least the test scenarios provided in the detailed
   * description of these javadocs. (1) Try adding a null to the list; (2) Try adding a cart which
   * carries a non upper-case alphabet letter, for instance "Hello" or "1" or "a". (3) Try adding a
   * duplicate cart to the list.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAlphabetListAddBadInput1() {
    AlphabetList list1 = new AlphabetList(4);
    try {
      list1.add(null);
    } catch (NullPointerException e) {
      return true;
    }
    return false;
  }
  
  public static boolean testAlphabetListAddBadInput2() {
    AlphabetList list1 = new AlphabetList(4);
    try {
      list1.add(new Cart("a"));
     
    } catch (IllegalArgumentException e) {
      if (e.getMessage().contains(
          "Can only add carts carrying one upper-case alphabetic letter in the range A .. Z."))
        return true;
    } 


    return false;
  }
  
  public static boolean testAlphabetListAddBadInput3 () {
    AlphabetList list1 = new AlphabetList(4);
    try {
    
      list1.add(new Cart("A"));
      list1.add(new Cart("A"));
    } catch (IllegalArgumentException e) {
      if (e.getMessage().contains(
          "Can only add carts carrying one upper-case alphabetic letter in the range A .. Z."))
        return true;
    } 


    return false;
  }

  /**
   * This method checks for the correctness of the AlphabetList.add() considering at least the test
   * scenarios provided in the detailed description of these javadocs. (1) Try adding a cart to an
   * empty list; (2) Try adding a cart which is expected to be added at the head of a non-empty
   * alphabet list; (3) Try adding a cart which is expected to be added at the end of a non-empty
   * alphabet list; (4) Try adding a cart which is expected to be added at the middle of a non-empty
   * alphabet list. For each of those scenarios, make sure that the size of the list is
   * appropriately updated after a call without errors of the add() method, and that the contents of
   * the list is as expected whatever if list is read in the forward or backward directions. You can
   * also check the correctness of AlphabetList.get(int), AlphabetList.indexOf(Cart), and
   * AlphabetList.size() in this test method.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAlphabetListAdd() {
    AlphabetList list1 = new AlphabetList();
    list1.add(new Cart("D"));
    if (list1.size() != 1)
      return false;
    list1.add(new Cart("A"));
    if (list1.size() != 2)
      return false;
    list1.add(new Cart("Z"));
    if (list1.size() != 3)
      return false;
    list1.add(new Cart("C"));
    if (list1.size() != 4)
      return false;
    if (list1.get(2).getCargo().toString() != "D")
      return false;
    if (list1.indexOf(new Cart("C")) != 1)
      return false;
    if (!list1.readForward().equals("ACDZ"))
      return false;
    if (!list1.readBackward().equals("ZDCA"))
      return false;
    return true;
  }

  /**
   * This method checks for the correctness of the AlphabetList.remove() considering at least the
   * test scenarios provided in the detailed description of these javadocs. (1) Try removing a cart
   * from an empty list or pass a negative index to AlphabetList.remove() method; (2) Try removing a
   * cart (at position index 0) from a list which contains only one cart; (3) Try to remove a cart
   * (position index 0) from a list which contains at least 2 carts; (4) Try to remove a cart from
   * the middle of a non-empty list containing at least 3 carts; (5) Try to remove the cart at the
   * end of a list containing at least two carts. (6) Try to remove a cart from a list containing
   * only one cart. For each of those scenarios, make sure that the size of the list is
   * appropriately updated after a call without errors of the add() method, and that the contents of
   * the list is as expected whatever if list is read in the forward or backward directions.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAlphabetListRemove() {
    AlphabetList list1 = new AlphabetList();
    AlphabetList list2 = new AlphabetList();
    AlphabetList list3 = new AlphabetList();
    AlphabetList list4 = new AlphabetList();
    AlphabetList list5 = new AlphabetList();
    
    // Try removing a cart (at position index 0) from a list which contains only one cart;
    list1.add(new Cart("D"));
    if (list1.size() != 1)
      return false;
    list1.remove(0);
    if (!list1.readForward().equals(""))
      return false;
    if (!list1.readBackward().equals(""))
      return false;
    try {
       //Try to remove a cart (position index 0) from a list which contains at least 2 carts;
      list2.add(new Cart("A"));
      if (list2.size() != 1)
        return false;
      list2.add(new Cart("Z"));
      if (list2.size() != 2)
        return false;
      list2.remove(0);
      if (!list2.readForward().equals("Z"))
        return false;
      if (!list2.readBackward().equals("Z"))
        return false;
      // Try to remove a cart from the middle of a non-empty list containing at least 3 carts;
      list3.add(new Cart("C"));
      if (list3.size() != 1)
        return false;
      list3.add(new Cart("F"));
      if (list3.size() != 2)
        return false;
      list3.add(new Cart("G"));
      if (list3.size() != 3)
        return false;
      list3.remove(1);
      if (!list3.readForward().equals("CG"))
        return false;
      if (!list3.readBackward().equals("GC"))
        return false;
      // Try to remove the cart at the end of a list containing at least two carts.
      list4.add(new Cart("C"));
      if (list4.size() != 1)
        return false;
      list4.add(new Cart("F"));
      if (list4.size() != 2)
        return false;
      list4.remove(list4.size() - 1);
      if (!list4.readForward().equals("C"))
        return false;
      if (!list4.readBackward().equals("C"))
        return false;
     //  Try to remove a cart from a list containing only one cart.
      list5.add(new Cart("C"));
      if (list5.size() != 1)
        return false;
      list5.remove(list5.size() - 1);
      if (!list5.readForward().equals(""))
        return false;
      if (!list5.readBackward().equals(""))
        return false;
    
      // Try removing a cart from an empty list or pass a negative index to AlphabetList.remove()
      // method;
      list1.remove(-1);
    } catch (IndexOutOfBoundsException e) {
      if (e.getMessage() == "Invalid index.")
        return true;
    } catch (NullPointerException e) {
      return true;
    }

    return true;
  }


  /**
   * This method calls all the test methods defined and implemented in your AlphabetListTester
   * class.
   * 
   * @return true if all the test methods defined in this class pass, and false otherwise.
   */
  public static boolean runAllTests() {

    return testLinkedCart() && testAlphabetListConstructorIsEmpty()
        && testAlphabetListConstructorBadInput() && testAlphabetListAddBadInput1()&&
        testAlphabetListAddBadInput2()&&testAlphabetListAddBadInput2()&&
        testAlphabetListAdd() && testAlphabetListRemove();
  }

  /**
   * Driver method defined in this AlphabetListTester class
   * 
   * @param args input arguments if any.
   */
  public static void main(String[] args) {
    System.out.println(runAllTests());
  }
}
