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
 * This class aims to create some moving badgers in the Winter Carnival
 * 
 * @author ZHAN YU & Hunter Zhang
 *
 */
public class DancingBadger extends StarshipRobot {


  DanceStep[] danceSteps; // the sequence of directions / dance steps for this badger to move
  int stepIndex; // the index of the next step within danceSteps for this badger to move through

  /**
   * A constructor for the dancing badgers
   * 
   * @param start      the initial position of badgers
   * @param danceSteps contains four kinds of dance steps
   */
  public DancingBadger(float[] start, DanceStep[] danceSteps) {
    super(new float[][] {{0, 0}, {600, 100}});
    imageName = "images" + File.separator + "dancingBadger.png";
    speed = 2;
    x = start[0];
    y = start[1];
    isFacingRight = true;
    this.danceSteps = danceSteps;
    stepIndex = 1;
    destination = danceSteps[stepIndex].getPositionAfter(start);


  }

  /**
   * This method updates this destination vector according to the next dance step (the one inside
   * danceSteps, at index stepIndex)
   */
  @Override
  public void updateDestination() {
    destination = danceSteps[stepIndex].getPositionAfter(new float[] {x, y});
    stepIndex = stepIndex + 1;
    // When the stepIndex gets larger than the largest valid array index, reset it to 0 so that it
    // restarts the sequence of steps from the beginning.
    if (stepIndex >= danceSteps.length) {
      stepIndex = 0;
    }

  }



}
