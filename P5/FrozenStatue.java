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

/***
 * This class aims to create frozen statues in the Winter Carnival
 * 
 * @author ZHAN YU & Hunter Zhang
 *
 */
public class FrozenStatue {
  protected float x; // the horizontal position of this object in pixels from 0-left to 800-right
  protected float y; // the vertical position of this object in pixels from 0-top to 600-bottom
  protected boolean isFacingRight;
  // used to mirror image (flip left to right) only when this field is false
  protected String imageName = "";// the relative path to the image file (from the working
                                  // directory)

  /**
   * A constructor for the frozen statue
   * 
   * @param position an array of two floats. The first of these floats (index 0) holds the initial x
   *                 position, and the second (index 1) holds the initial y position for the object
   *                 being constructed.
   */
  public FrozenStatue(float[] position) {
    x = position[0];
    y = position[1];
    isFacingRight = true;
    imageName = "images" + File.separator + "frozenStatue.png";
  }

  /**
   * This method should call the draw() method on the SimulationEngine that is passed to it, and it
   * should send this object’s imageName, x, y, and isFacingRight fields as arguments.
   * 
   * @param an new Simulation Engine with its own graphical window.
   */
  public void update(SimulationEngine engine) {

    engine.draw(imageName, x, y, isFacingRight);


  }

}

