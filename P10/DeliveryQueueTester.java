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
// Online Sources: NONE
//
///////////////////////////////////////////////////////////////////////////////
public class DeliveryQueueTester {
  public static void main(String[]args) {
    System.out.print(testOfferDelivery());
  }
  public static boolean testOfferDelivery() {
    // create a new DeliveryQueue
    DeliveryQueue minHeap = new DeliveryQueue();
    // create some Student and FoodRobot objects
    Student one = new Student(1,1,1);
    Student two = new Student(3,2,2);
    FoodRobot a = new FoodRobot(2,3,"A");
    FoodRobot b = new FoodRobot(5,4,"B");
    // create some Delivery objects and add them to the DeliveryQueue
    minHeap.offerDelivery( new Delivery(one,a) );
    minHeap.offerDelivery( new Delivery(one,b) );
    minHeap.offerDelivery( new Delivery(two,a) );
    minHeap.offerDelivery( new Delivery(two,b) );
    
    // check if the size is correct (2 students * 2 foodRobots = 4 deliveries)
    if(minHeap.getSize() != 4) return false;
    // check first (highest priority delivery to be returned)
    String bestDelivery = minHeap.pollBestDelivery().toString();
    if(!(bestDelivery.equals("The distance between 2 and A is 2"))) return false;
    // check if the size is correct (only delivery w/student 1 + robot B left)
    if(minHeap.getSize() != 1) return false;
   
    // check last (lowest priority delivery to be returned)
    String worstDelivery = minHeap.peek().toString();
    if(!worstDelivery.equals("The distance between 1 and B is 7")) return false;
    
    // only return true after all previous tests pass
    return true; }
}
