//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: CalendarPrinter
// Files: CalendarTester. java
// Course: CS300 2020 SP
//
// Author: ZHAN YU
// Email: zyu293@ wisc.edu
// Lecturer's Name: Gary
//
//////////// PAIR PROGRAMMING (MAY SKIP WHEN WORKING INDIVIDUALLY) ////////////
//
// Partner Name: Hunter Zhang
// Partner Email: zzhang978@wisc.edu
// Partner Lecturer's Name: Mourna
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
// Persons: (identify each person and describe their help in detail)
// Online Sources: (identify each URL and describe their assistance in detail)
//
///////////////////////////////////////////////////////////////////////////////
import java.util.ArrayList;
import java.util.Scanner;

public class CalendarTester {

  /***
   * Calls the test methods implemented in this class and displays their output
   * 
   * @param args input arguments if any
   */
  public static void main(String[] args) {
    System.out.println(testFullCenturiesContained());
    System.out.println(testYearOffsetWithinCentury());
    System.out.println(testIsLeapYear());
    System.out.println(testNumberOfDaysInMonth());
    System.out.println(testCalcFirstDayOfWeekInMonth());
    System.out.println(testDayOfWeekAfter());
    System.out.println(testMonthOfYearAfter());
    System.out.println(testCreateNewMonth());

    // TODO Auto-generated method stub

  }

  /***
   * Checks whether CalendarPrinter.fullCenturiesContained() method works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testFullCenturiesContained() {
    if (CalendarPrinter.fullCenturiesContained(new Year(2)) != 0)
      return false;
    if (CalendarPrinter.fullCenturiesContained(new Year(2020)) != 20)
      return false;
    if (CalendarPrinter.fullCenturiesContained(new Year(44444)) != 444)
      return false;
    return true;
  }


  /***
   * Checks whether CalendarPrinter.yearOffsetWithinCentury() method works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testYearOffsetWithinCentury() {
    if (CalendarPrinter.yearOffsetWithinCentury(new Year(1)) != 1)
      return false;
    if (CalendarPrinter.yearOffsetWithinCentury(new Year(2019)) != 19)
      return false;
    if (CalendarPrinter.yearOffsetWithinCentury(new Year(12344)) != 44)
      return false;
    return true;
  }

  /***
   * Checks whether CalendarPrinter.isLeapYear() method works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testIsLeapYear() {
    if (CalendarPrinter.isLeapYear(new Year(2012)) != true)
      return false;
    if (CalendarPrinter.isLeapYear(new Year(2019)) != false)
      return false;
    if (CalendarPrinter.isLeapYear(new Year(123)) != false)
      return false;
    return true;
  }

  /***
   * Checks whether CalendarPrinter.numberOfDaysInMonth() method works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testNumberOfDaysInMonth() {
    if (CalendarPrinter.numberOfDaysInMonth(new Month(MonthOfYear.February, new Year(2012))) != 29)
      return false;
    if (CalendarPrinter.numberOfDaysInMonth(new Month(MonthOfYear.February, new Year(1013))) != 28)
      return false;
    if (CalendarPrinter.numberOfDaysInMonth(new Month(MonthOfYear.April, new Year(2020))) != 30)
      return false;
    if (CalendarPrinter.numberOfDaysInMonth(new Month(MonthOfYear.November, new Year(1234))) != 30)
      return false;
    if (CalendarPrinter.numberOfDaysInMonth(new Month(MonthOfYear.January, new Year(4321))) != 31)
      return false;
    return true;
  }

  /***
   * Checks whether CalendarPrinter.calcFirstDayOfWeekInMonth() method works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testCalcFirstDayOfWeekInMonth() {
    if (CalendarPrinter.calcFirstDayOfWeekInMonth(
        new Month(MonthOfYear.January, new Year(2020))) != DayOfWeek.Wednesday)
      return false;
    if (CalendarPrinter.calcFirstDayOfWeekInMonth(
        new Month(MonthOfYear.February, new Year(2020))) != DayOfWeek.Saturday)
      return false;
    if (CalendarPrinter.calcFirstDayOfWeekInMonth(
        new Month(MonthOfYear.April, new Year(2020))) != DayOfWeek.Wednesday)
      return false;
    return true;
  }

  /***
   * Checks whether CalendarPrinter.dayOfWeekAfter() method works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testDayOfWeekAfter() {
    if (CalendarPrinter.dayOfWeekAfter(DayOfWeek.Monday) != DayOfWeek.Tuesday)
      return false;
    if (CalendarPrinter.dayOfWeekAfter(DayOfWeek.Friday) != DayOfWeek.Saturday)
      return false;
    if (CalendarPrinter.dayOfWeekAfter(DayOfWeek.Saturday) != DayOfWeek.Sunday)
      return false;
    return true;
  }

  /***
   * Checks whether CalendarPrinter.monthOfYearAfter() method works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testMonthOfYearAfter() {
    if (CalendarPrinter.monthOfYearAfter(MonthOfYear.January) != MonthOfYear.February)
      return false;
    if (CalendarPrinter.monthOfYearAfter(MonthOfYear.March) != MonthOfYear.April)
      return false;
    if (CalendarPrinter.monthOfYearAfter(MonthOfYear.November) != MonthOfYear.December)
      return false;
    return true;
  }

  /***
   * Checks whether CalendarPrinter.createNewMonth() method works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testCreateNewMonth() {
    Month month = CalendarPrinter.createNewMonth(MonthOfYear.January,new Year(2020));
    if (month.getDayByDate(1).getDayOfWeek()!=DayOfWeek.Wednesday) {
      return false;
    }
    if (month.getDayByDate(31).getDayOfWeek()!=DayOfWeek.Friday) {
      return false;
    }
    if (month.getDayByDate(20).getDayOfWeek()!=DayOfWeek.Monday) {
      return false;
    }
   
    return true;
  }
}
