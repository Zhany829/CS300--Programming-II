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
 * This class aims to keep track of a FoodRobot + Student pair that could be matched to fulfill a
 * delivery.
 * 
 * @author Zhan Yu
 *
 */
public class Delivery implements Comparable<Delivery> {
  private int studentId;
  private String robotName;
  private int distance;

  /**
   * Constructor of the class
   * 
   * @param student   object of student
   * @param foodRobot object of foodRobot
   */
  public Delivery(Student student, FoodRobot foodRobot) {
    studentId = student.getID();
    robotName = foodRobot.getName();
    this.distance =
        Math.abs(student.getX() - foodRobot.getX()) + Math.abs(foodRobot.getY() - student.getY());
  }
/**
 * Get the distance of student and food robot
 * @return the distance between them
 */
  public int getDistance() {
    return this.distance;
  }
/**
 * Get the student id
 * @return the student's id
 */
  public int getStudentId() {
    return this.studentId;
  }
/**
 * Get the name of the robot
 * @return the name of the robot
 */
  public String getRobotName() {
    return this.robotName;
  }

  /**
   * compare the value of two objects
   * 
   * @return return 0 if two objects have the same priority, negative number if the object that it
   *         is called on has a higher priority than the object passed as an argument. When the
   *         argument passed has a higher priority than the object that this method is called on,
   *         the return value should be any positive number.
   */
  public int compareTo(Delivery o) {
    if (this.distance < o.getDistance()) {
      return -1;
    } else if (this.distance > (o).distance) {
      return 1;
    } else if (this.distance == o.distance && (this.studentId < o.getStudentId()
        || this.robotName.charAt(0) < o.getRobotName().charAt(0))) {
      return -1;
    } else if (this.distance == o.distance && (this.studentId > o.getStudentId()
        || this.robotName.charAt(0) > o.getRobotName().charAt(0))) {
      return 1;
    } else {
      return 0;
    }
  }

  /**
   * check whether two object or their values are equal
   * 
   * @return true if two objects are equal
   */
  @Override
  public boolean equals(Object o) {
    if (o instanceof Delivery) {
      if (this.studentId == ((Delivery) o).getStudentId()
          || this.robotName.equals(((Delivery) o).getRobotName())) {
        return true;
      }
    } else if (o instanceof Student) {
      if (this.studentId == ((Student) o).getID()) {
        return true;
      }
    } else {
      if (this.robotName.equals(((FoodRobot) o).getName()))
        return true;
    }
    return false;

  }

  /**
   * Create a string contains some information.
   * 
   * @return String representation of the distance of student and robot
   */
  @Override
  public String toString() {
    return "The distance between " + studentId + " and " + robotName + " is " + distance;
  }



}
