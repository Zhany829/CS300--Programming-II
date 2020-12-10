//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Badger Coaster
// Files: BoardingGroup.java, RideQueue.java, BGNode.java, QueueADT.java, ThemeParkApp.java
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
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.NoSuchElementException;

/**Driver for RideQueue. Reads commands from a text files and executes
* them accordingly.
* @author Michelle Jensen
*/
public class ThemeParkApp {
  public static void main(String []args) throws IOException {
    List<String> fileLines = Files.readAllLines(Paths.get("sample.txt"));
    String command = "";
    String[] commandParts;
    
    //Default queue capacity and ride capacity. Can change values if desired.
    RideQueue coaster = new RideQueue(50);
    int trainCapacity = 24; 
    
    //Process each line in the text file.
    for (int i = 0; i < fileLines.size(); i++) {
      commandParts = fileLines.get(i).split(" ");
      command = commandParts[0].toUpperCase();
      
      // ENTER Command
      if (command.equals("E")){ 
	    enter(coaster, commandParts);
	  }
      
	  // BREAKDOWN Command
      if (command.equals("B")) {
        breakdown(coaster);
      }
      
	  // PREVIEW Command
      if (command.equals("P")) {
        preview(coaster);
      }
      
	  // RIDE Command
      if (command.equals("R")) {
        ride(coaster, trainCapacity);
      }
      
	  //STATUS Command
      if (command.equals("S")) {
        status(coaster);
      }
    }
  }

/**
 * Print the status of the queue
 * @param coaster the queue for stating its status
 */
  private static void status(RideQueue coaster) {
    System.out.println("Retrieving Status...");
    System.out.println(coaster.toString());
    System.out.println("------------------------------------");
  } 
  /**
   * This method is to express how many groups enter the line for Badger Coaster
   * @param coaster The queue for entering
   * @param commandParts name and number of group members that enter
   */
  private static void enter(RideQueue coaster, String [] commandParts) {
    System.out.println("Entering into ride line...");
    String groupName = commandParts[1];
    int groupSize = Integer.parseInt(commandParts[2]);

    BoardingGroup newGroup= new BoardingGroup(groupName,groupSize);
	/*newGroup = CALL YOUR BoardingGroup CONSTRUCTOR HERE. NOTE: var groupName is the
	name of the group from the file and var groupsize is the number of people*/

    if (commandParts.length == 4) {
      if (commandParts[3].toUpperCase().equals("V")) {
        newGroup.setVIP(true);
		//Only do this once you have completed section 7.
        /*CALL YOUR VIP STATUS MUTATOR HERE ON newGroup*/
      }
    }

    try {
      coaster.enqueue(newGroup);
      System.out.println(groupName + "'s group of " + groupSize
          + " has entered the line for Badger Coaster.");
    } catch (IllegalStateException e) {
      System.out.println("Cannot fit group of that size into queue.");
    }
	
    System.out.println("------------------------------------");
  }
  /**
   * This method is for removing all the groups in the line
   * @param coaster the queue for being removed
   */
  private static void breakdown(RideQueue coaster) { 
    System.out.println("Ride Breakdown...");
    System.out.println("The ride has broken down. All " + coaster.size()
        + " group(s) have been removed from the line.");
    coaster.clear();
    System.out.println("------------------------------------");
  }
  /**
   * This method is to print the number of group members of the front group
   * @param coaster  The queue line of groups of people 
   */
  private static void preview(RideQueue coaster) {
    System.out.println("Previewing the front of the line...");
	
    try {
      BoardingGroup peeked = coaster.peek();
      int peekedSize=peeked.getNum();
	  /* peekedSize = CALL YOUR NUMBER OF PEOPLE IN GROUP ACCESSOR HERE ON peeked*/ 
      String peekedName=peeked.getName();
	  /*peekedName = CALL YOUR NAME ACCESSOR HERE ON peeked*/
      System.out.println(peekedName + "'s group of " + peekedSize 
		  + " is at the front of the line.");
    } catch (NoSuchElementException e) {
      System.out.println("Cannot look at a group from an empty queue.");
	}
	
    System.out.println("------------------------------------");   
  }
  /**
   * This method is for boarding some groups as many as possible
   * @param coaster the queue line for boarding or removing
   * @param trainCapacity the max number of people can fit in the train
   */
  private static void ride(RideQueue coaster, int trainCapacity) {
    System.out.println("Boarding and Running the Ride...");
    int ridingTrain = 0;
	
    while (!coaster.isEmpty()) {
      BoardingGroup peeked = coaster.peek();
      int peekedSize=peeked.getNum(); 
	  /*peekedSize = CALL YOUR NUMBER OF PEOPLE IN GROUP ACCESSOR HERE ON peeked*/

      if (ridingTrain + peekedSize > trainCapacity) {
        break;
      }

      try {
        BoardingGroup removed = coaster.dequeue();
        String removedName=removed.getName();
		/*removedName = CALL YOUR NAME ACCESSOR HERE ON removed*/
        int removedSize = removed.getNum();
		/*removedSize = CALL YOUR NUMBER OF PEOPLE IN GROUP ACCESSOR HERE ON removed*/ 

        System.out.println(removedName + "'s group of " + removedSize
            + " has boarded the Badger Coaster train.");

        ridingTrain += removedSize;
      } catch (NoSuchElementException e) {
        System.out.println("Cannot remove a group from an empty queue.");
      }
    }

    if (ridingTrain == 0) {
      System.out.println("There is no one on the train to ride.");
    } else {
      System.out.println("Train of " + ridingTrain + " people has left the ride station.");
    }
	
    System.out.println("------------------------------------");
  }  
}

