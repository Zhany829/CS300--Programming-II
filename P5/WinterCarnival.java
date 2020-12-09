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
import java.util.ArrayList;

/***
 * This class aims to create object(some of them are moving) in the Winter Carnival
 * 
 * @author ZHAN YU & Hunter Zhang
 *
 */
public class WinterCarnival extends SimulationEngine {
  //initialize a ArrayList that contains objects in the Winter Carnival
  private ArrayList<FrozenStatue> objects = new ArrayList<FrozenStatue>();



  /**
   * This method is meant to be overloaded by any derived class, to describe how this simulation
   * should change and be updated over time. This method will automatically be called repeatedly,
   * until the program is terminated on any new SimulationEngine that is created.
   */
  @Override
  public void update() {
    for (int i = 0; i < objects.size(); i++) {
      objects.get(i).update(this);
    }
  }


  public static void main(String[] args) {
    WinterCarnival engine = new WinterCarnival();// create a engine to initialize following
                                                 // activities



  }

  /**
   * Constructor of WinterCarnival which aims to add three kinds of objects
   */
  public WinterCarnival() {
    float[] position1 = new float[] {600, 100};
    FrozenStatue object1 = new FrozenStatue(position1);
    objects.add(object1);
    float[] position2 = new float[] {200, 500};
    FrozenStatue object2 = new FrozenStatue(position2);
    objects.add(object2);
    float[][] position3 = new float[][] {{0, 0}, {600, 100}};
    StarshipRobot object3 = new StarshipRobot(position3);
    objects.add(object3);
    float[][] position4 = new float[][] {{800, 300}, {200, 500}};
    StarshipRobot object4 = new StarshipRobot(position4);
    objects.add(object4);
    DanceStep[] steps = new DanceStep[] {DanceStep.Left, DanceStep.Right, DanceStep.Right,
        DanceStep.Left, DanceStep.Down, DanceStep.Left, DanceStep.Right, DanceStep.Right,
        DanceStep.Left, DanceStep.Up};
    DancingBadger badger1 = new DancingBadger(new float[] {304, 268}, steps);
    DancingBadger badger2 = new DancingBadger(new float[] {368, 268}, steps);
    DancingBadger badger3 = new DancingBadger(new float[] {432, 268}, steps);
    DancingBadger badger4 = new DancingBadger(new float[] {496, 268}, steps);
    objects.add(badger1);
    objects.add(badger2);
    objects.add(badger3);
    objects.add(badger4);

  }



}


