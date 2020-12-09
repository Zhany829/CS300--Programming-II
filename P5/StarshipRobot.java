//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: WinterCarnival
// Files: WinterCarnival.java, FrozenStatue.java, StarshipRobot.java, DancingBadger.java
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
import java.io.File;
import java.lang.Math;

/***
 * This class aims to create moving starship robots in the Winter Carnival
 * 
 * @author ZHAN YU & Hunter Zhang
 *
 */
public class StarshipRobot extends FrozenStatue {

  protected float[][] beginAndEnd; // array of two positions, that this robot moves back and forth
                                   // between the contents of this 2d array are organized as
                                   // follows: { { beginX, beginY}, { endX, endY }}
  protected float[] destination; // the position that this robot is currently moving towards
  protected float speed; // the speed in pixels that this robot moves durring each update

  /**
   * A constructor for the starship robots
   * 
   * @param beginAndEnd array of two positions, that this robot moves back and forth between the
   *                    contents of this 2d array are organized as follows: { { beginX, beginY}, {
   *                    endX, endY }}
   */
  public StarshipRobot(float[][] beginAndEnd) {
    super(beginAndEnd[1]);
    this.beginAndEnd = beginAndEnd;
    this.speed = 6;
    this.isFacingRight = true;
    this.imageName = "images" + File.separator + "starshipRobot.png";
    destination = beginAndEnd[1];
    x = beginAndEnd[0][0];
    y = beginAndEnd[0][1];
  }

  /**
   * This method aims to update the position of the object.
   * 
   * @return true when the object is close enough to its destination
   */
  protected boolean moveTowardDestination() {
    // calculate distance between destination and old, before moving
    double distance =
        Math.sqrt((Math.pow((destination[0] - x), 2)) + (Math.pow((destination[1] - y), 2)));
    x = (float) (x + ((speed * (destination[0] - x)) / (distance)));
    y = (float) (y + ((speed * (destination[1] - y)) / (distance)));

    // change the direction of the object face
    if (destination[0] > x) {
      this.isFacingRight = false;
    } else {
      this.isFacingRight = true;
    }

    if (distance < 2 * speed) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * This method should be called when the object is close enough to its destination that its
   * destination should be updated to the other position within beginAndEnd.
   */
  protected void updateDestination() {
    if (destination.equals(beginAndEnd[0])) {
      destination = this.beginAndEnd[1];
    } else {
      destination = this.beginAndEnd[0];
    }
  }

  /**
   * This method first check whether the object is close enough to its destination by calling
   * updateDestination() method. Otherwise, updating its location
   */
  @Override
  public void update(SimulationEngine engine) {
    if (moveTowardDestination()) {
      updateDestination();
    } else {
      super.update(engine);
    }
  }


}


