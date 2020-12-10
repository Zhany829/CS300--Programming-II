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
 * This class aims to create the object of FoodRobot and to provide some information of them.
 * @author Zhan Yu
 *
 */
public class FoodRobot {
  private int x;
  private int y; 
   private String id;
   
   /**
    * Constructor of the class
    * @param x x position of food robot
    * @param y y position of food robot
    * @param id  name of the food robot
    */
   public FoodRobot(int x,int y,String id) {
     this.x=x;
     this.y=y;
     this.id=id;
   }
   /**
    * Accessor for getting the x position of the food robot.
    * @return x position
    */
   public  int getX() {
     return this.x;
   }
   /**
    * Accessor for getting the y position of the food robot.
    * @return y position
    */
   public  int getY() {
     return this.y;
   }
   /**
    * Accessor for getting the name of the food robot.
    * @return the name of the food robot
    */
   public String getName() {
     return this.id;
   }
   /**
    * Create a string contains some information.
    * @return String representation of the information of the class object
    */
   @Override
   public String toString() {
     return this.id+"("+this.x+","+this.y+")";
   }
}
