//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: PatientRecordTree
// Files: PatientRecordTree.java, PatientRecordTreeTester.java, PatientRecord.java, PatientRecordNode.java
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
import java.util.Calendar;
import java.util.Date;

/**
 * This class models a Patient
 *
 */
public class PatientRecord implements Comparable<PatientRecord> {

  private String name; // name of the patient
  private final Date DATE_OF_BIRTH; // date of birth of the patient
  
  /**
   * Creates a new PatientRecord with given name and date of birth
   * 
   * @param dateOfBirth String representation of the date of birth of the patient in format mm/dd/yyyy.
   * @throws IllegalArgumentException if the format of the date is incorrect.
   * @throws NumberFormatException if the format of the provided date is not valid
   */
  public PatientRecord(String name, String dateOfBirth) {
    // split the provided date with respect to "/"
    String[] parts = dateOfBirth.split("/");
    // get the month, day, and year of date
    if (parts.length != 3)
      throw new IllegalArgumentException("Incorrect format of date.");
    int month = Integer.parseInt(parts[0]);
    int day = Integer.parseInt(parts[1]);
    int year = Integer.parseInt(parts[2]);
    this.name = name;
    Calendar calendar = Calendar.getInstance();
    calendar.set(year, month - 1, day);
    calendar.set(Calendar.HOUR_OF_DAY, 0);
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.SECOND, 0);
    calendar.set(Calendar.MILLISECOND, 0);
    DATE_OF_BIRTH = calendar.getTime();
  }

  /**
   * Gets the name of the patient
   * 
   * @return the name of the patient
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the date of birth of the patient
   * 
   * @return the date of birth of the patient as a java.util.Date object
   */
  public Date getDateOfBirth() {
    return DATE_OF_BIRTH;
  }

  /**
   * Gets a String representation of the date of birth of the patient
   * 
   * @return the date of birth of this PatientRecord as a String in the format month/day/year.
   */
  public String getStringDateOfBirth() {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(DATE_OF_BIRTH);
    int day = calendar.get(Calendar.DAY_OF_MONTH);
    int month = calendar.get(Calendar.MONTH) + 1;
    int year = calendar.get(Calendar.YEAR);
    return month + "/" + day + "/" + year;
  }

  /**
   * Returns a String representation of this patient's record in the following format:
   * "name(date_of_birth)". For instance "George(12/3/2000)"
   * 
   * @return a String representation of this patient record
   * 
   */
  @Override
  public String toString() {
    return name + "(" + getStringDateOfBirth() + ")";
  }

  /**
   * Compares two PatientRecords for ordering with respect to the dates of birth of the patients.
   * 
   * @returns the value 0 if the argument otherPatientRecord has the same date of birth as this
   *          PatientRecord; a value less than 0 if this patient is older than the otherPatient with
   *          otherPatientRecord; and a value greater than 0 if this patient is younger than
   *          other patient.
   * @throws NullPointerException if otherPatientRecord is null
   */
  @Override
  public int compareTo(PatientRecord otherPatientRecord) {
    return this.DATE_OF_BIRTH.compareTo(otherPatientRecord.DATE_OF_BIRTH);
  }

  /**
   * Checks whether this PatientRecord equals some other object
   * @return true if this PatientRecord equals the input argument o and false otherwise
   */
  @Override
  public boolean equals(Object o) {
    return (o != null && o instanceof PatientRecord && compareTo((PatientRecord)o)== 0);
  }
}
