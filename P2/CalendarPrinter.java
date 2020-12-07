//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: CalendarPrinter
// Files: CalendarPrinter. java
// Course: CS300 2020 SP
//
// Author: ZHAN YU
// Email: zyu293@ wisc.edu
// Lecturer's Name: Gary
//
//////////// PAIR PROGRAMMING (MAY SKIP WHEN WORKING INDIVIDUALLY) ////////////
//
// Partner Name: Hunter Zhang
// Partner Email: zzhang978@ wisc.edu
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

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Create a permanent calendar
 */
public class CalendarPrinter {

  /**
   * Driver for the CalendarPrinter Application. This program asks the user to enter an initial
   * month, an initial year, and the total number of months to create and display in calendar form.
   * 
   * @param args is not used by this program
   */
  public static void main(String[] args) {
    // print welcome message
    Scanner in = new Scanner(System.in);
    System.out.println("Welcome to the Calendar Printer.");
    System.out.println("~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~");
    // read input from the user
    System.out.print("Enter the month to begin calendar: ");
    String monthString = in.nextLine().trim();
    System.out.print("Enter the year to begin calendar: ");
    String yearString = in.nextLine().trim();
    System.out.print("Enter the number of months to include in this calendar: ");
    String countString = in.nextLine().trim();
    // convert user input into usable form
    monthString = monthString.substring(0, 3).toUpperCase();
    MonthOfYear month = null;
    for (int i = 0; i < MonthOfYear.values().length; i++)

      if (monthString.equals(MonthOfYear.values()[i].name().substring(0, 3).toUpperCase()))
        month = MonthOfYear.values()[i];
    Year year = new Year(Integer.parseInt(yearString.trim()));
    int count = Integer.parseInt(countString.trim());
    // create months and display them in calendar form
    System.out.println();
    createAndPrintMonths(month, year, count);
    // display thank you message
    System.out.println("~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~");
    System.out.println("Thanks, and have a nice day.");
    in.close();
  }

  /**
   * Calculates the number of centuries (rounded down) between year 0 and the specified year. For
   * example, the year 2034 has the century index of 20 (as do the other years 2000-2099).
   * 
   * @param year to compute the century offset for
   * @return number of centuries between year 0 and the specified year
   */
  public static int fullCenturiesContained(Year year) {
    int fullCenturies = year.intValue();
    return fullCenturies / 100;
  }

  /**
   * Calculates the number of years between the specified year and the first year of its century.
   * For example, the year 2034 has the offset within its century of 34 (as do 1234 and 9999934).
   * 
   * @param year to compute the offset within century for
   * @return number of years between the specified year and the first year of century
   */
  public static int yearOffsetWithinCentury(Year year) {
    int numYear = year.intValue();
    return numYear % 100;
  }

  /**
   * This method computes whether the specified year is a leap year or not.
   * 
   * @param year is the year is being checked for leap-year-ness
   * @return true when the specified year is a leap year, and false otherwise
   */
  public static boolean isLeapYear(Year year) {
    int checkYear = year.intValue(); // get the int value of year
    if (!(checkYear % 100 == 0) && (checkYear % 4 == 0) || (checkYear % 400 == 0)) {
      return true;
    } else {
      return false;
    }

  }

  /**
   * Calculates the number of days in the specified month, while taking into consideration whether
   * or not the specified month is in a leap year.
   * 
   * @param month to determine the number of days within (within its year)
   * @return the number of days in the specified month (between 28-31)
   */
  public static int numberOfDaysInMonth(Month month) {
    // case 1 - February in leap year
    if (isLeapYear(month.getYear()) && month.getMonthOfYear() == MonthOfYear.February) {
      return 29;
      // case 2 - February in non leap year
    } else if (!(isLeapYear(month.getYear())) && month.getMonthOfYear() == MonthOfYear.February) {
      return 28;
      // case 3 - months with 30 days
    } else if (month.getMonthOfYear() == MonthOfYear.April
        || month.getMonthOfYear() == MonthOfYear.June
        || month.getMonthOfYear() == MonthOfYear.September
        || month.getMonthOfYear() == MonthOfYear.November) {
      return 30;
    } else {
      // case 4 - months with 31 days
      return 31;
    }
  }

  /**
   * Calculates which day of the week the first day of the specified month falls on. Note: that this
   * is calculated based on the month's monthOfYear and year, and is NOT retrieved from the month's
   * getDayByDate(1) day. This is because this method is used to generate the day objects that are
   * stored within each month.
   * 
   * @param month within which we are calculate the day of week for the first day
   * @return DayOfWeek corresponding to the first day within the specified month
   */
  public static DayOfWeek calcFirstDayOfWeekInMonth(Month month) {
    int h = 0; // the day of the week (0 = Saturday, 1 = Sunday, 2 = Monday, ..., 6 = Friday)
    int q = 1; // the day of the month
    int m = 0;// m is the month (3 = March, 4 = April, 5 = May, ..., 14 = February)
    int K; // K is the year of the century (year mod 100).
    int J;
    // J is the zero-based century (the integer part of year/100)For example, the
    // zero-based centuries for 1995 and 2000 are 19 and 20 respectively (to not be confused
    // with the common ordinal century enumeration which indicates 20th for both cases).
    MonthOfYear[] months = MonthOfYear.values();
    DayOfWeek[] days = DayOfWeek.values();
    if (month.getMonthOfYear() == MonthOfYear.January) {
      m = 13;
      int yearNum = month.getYear().intValue();
      K = yearOffsetWithinCentury(new Year(yearNum - 1));
      J = fullCenturiesContained(new Year(yearNum - 1));

    } else if (month.getMonthOfYear() == MonthOfYear.February) {
      m = 14;
      int yearNum = month.getYear().intValue();
      K = yearOffsetWithinCentury(new Year(yearNum - 1));
      J = fullCenturiesContained(new Year(yearNum - 1));
    } else {
      for (int i = months.length - 1; i > 1; i--) {
        if (months[i] == month.getMonthOfYear()) {
          m = i + 1;
        }
      }
      int yearNum = month.getYear().intValue();
      K = yearOffsetWithinCentury(new Year(yearNum));
      J = fullCenturiesContained(new Year(yearNum));
    }
    h = (q + (13 * (m + 1) / 5) + K + (K / 4) + (J / 4) + 5 * J) % 7;
    if (h == 0 || h == 1) {
      return days[h + 5];
    } else {

      return days[h - 2];
    }

  }

  /**
   * Calculates the day of the week that follows the specified day of week. For example, Thursday
   * comes after Wednesday, and Monday comes after Sunday.
   * 
   * @param dayBefore is the day of week that comes before the day of week returned
   * @return day of week that comes after dayBefore
   */
  public static DayOfWeek dayOfWeekAfter(DayOfWeek dayBefore) {
    DayOfWeek[] days = DayOfWeek.values(); // retrieve array of all values
    DayOfWeek dayAfter;
    // case 1 - dayBefore is Sunday
    if (dayBefore.ordinal() == days.length - 1) {
      dayAfter = days[0];
    } else {
      // case 2 - dayBefore is between Monday and Saturday
      dayAfter = days[dayBefore.ordinal() + 1];
    }
    return dayAfter;
  }

  /**
   * Calculates the month of the year that follows the specified month. For example, July comes
   * after June, and January comes after December.
   * 
   * @param monthBefore is the month that comes before the month that is returned
   * @return month of year that comes after monthBefore
   */
  public static MonthOfYear monthOfYearAfter(MonthOfYear monthBefore) {
    MonthOfYear[] months = MonthOfYear.values(); // retrieve array of all values
    MonthOfYear monthAfter;
    // case 1 - monthBefore is December
    if (monthBefore.ordinal() == months.length - 1) {
      monthAfter = months[0];
    } else {
      // case 2 - monthBefore is between January and November
      monthAfter = months[monthBefore.ordinal() + 1];
    }
    return monthAfter;
  }

  /**
   * Creates a new month object and fully initializes with its corresponding days.
   * 
   * @param monthOfYear which month of the year this new month represents
   * @param year        in which this month is a part
   * @return reference to the newly created month object
   */
  public static Month createNewMonth(MonthOfYear monthOfYear, Year year) {
    Month month = new Month(monthOfYear, year);
    int numOfDays = numberOfDaysInMonth(month);
    DayOfWeek newDay = calcFirstDayOfWeekInMonth(month);
    Day firstDay = new Day(newDay, 1, month);
    month.addDay(firstDay); // add the first day of the month
    for (int i = 2; i <= numOfDays; i++) {
      // add the rest of the days in the month
      DayOfWeek nextDay = dayOfWeekAfter(newDay);
      newDay = nextDay;
      Day days = new Day(newDay, i, month);
      month.addDay(days);
    }

    return month;
  }

  /**
   * Prints the contents of the specified month object in calendar form. This printout should begin
   * with the Month an year of the month. The next line should contain the three letter
   * abbreviations for the seven days of the week. And then the dates of each day of that month
   * should follow: one week per line, with periods in positions of days that are a part of the
   * month before or after. For example, January 2020 should be printed as follows:
   * 
   * January 2020 MON TUE WED THU FRI SAT SUN . . 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20
   * 21 22 23 24 25 26 27 28 29 30 31 . .
   * 
   * @param month which is to be printed by this method
   */
  public static void printMonth(Month month) {
    System.out.println(month.getMonthOfYear() + " " + month.getYear());
    System.out.println("MON TUE WED THU FRI SAT SUN");
    int numOfDays = numberOfDaysInMonth(month);
    DayOfWeek FirstDay = calcFirstDayOfWeekInMonth(month);
    int numOfDots = 0;
    // get the number of dots corresponding to number of days
    if (numOfDays > 28) {
      numOfDots = 35;
    } else {
      numOfDots = 28;
    }
    int numOfRows = numOfDots / 7;
    String[][] calendar = new String[numOfRows][7];
    // fill the calendar with dots first
    for (int i = 0; i < calendar.length; ++i) {
      for (int j = 0; j < calendar[i].length; ++j) {
        calendar[i][j] = ".";
      }
    }
    // fill the first line of the dates in calendar
    int firstDayIndex = FirstDay.ordinal();// get the index of the first day
    int count = 0;
    for (int i = 1; i <= (7 - firstDayIndex); i++) {

      calendar[0][firstDayIndex + count] = String.valueOf(month.getDayByDate(i).getDate());
      count++;
    }
    // fill the rest lines of the calendar
    for (int i = 1; i < calendar.length; ++i) {
      for (int j = 0; j < calendar[i].length; ++j) {
        if (count < month.getDayCount()) {
          count += 1;
          calendar[i][j] = String.valueOf(month.getDayByDate(count).getDate());
        } else {
          calendar[i][j] = ".";
        }
      }
    }

    int rowCount = 0;
    String outPut = "";
    for (int i = 0; i < numOfRows; ++i) {
      rowCount = 0;
      while (rowCount < 7) {
        if (calendar[i][rowCount].length() == 2) {
          // if the dates is larger than 9, the space between dates is 1 whitespace
          outPut = outPut + " " + calendar[i][rowCount] + " ";
        } else {
          // if the dates is smaller than 10, the space between dates is 2 whitespace
          outPut = outPut + " " + calendar[i][rowCount] + "  ";
        }

        rowCount++;
      }
      outPut = outPut + "\n";

    }
    System.out.println(outPut);
  }


  /**
   * Creates an array list of months that are initialized with their full complement of days. Prints
   * out each of these months in calendar form, and then returns the resulting ArrayList.
   * 
   * @param month of the year for the first month that is created and printed
   * @param year  that the first month created and printed is a part of
   * @param count is the total number of sequential months created and printed
   */
  public static ArrayList<Month> createAndPrintMonths(MonthOfYear month, Year year, int count) {
    Month newMonth = createNewMonth(month, year);
    ArrayList<Month> months = new ArrayList<Month>();
    months.add(newMonth);
    MonthOfYear nextMonth = monthOfYearAfter(month);
    Year newYear = new Year(year.intValue());
    // Increase year by 1, if months needed to print exist in next year
    if ((nextMonth) == MonthOfYear.January) {
      newYear = new Year(year.intValue() + 1);
    }
    //add the month object into arrayList months
    for (int i = 1; i < count; i++) {
      Month afterMonths = createNewMonth(nextMonth, newYear);
      nextMonth = monthOfYearAfter(afterMonths.getMonthOfYear());
      months.add(afterMonths);

    }
    //print the demanded months
    for (int i = 0; i < count; i++) {
      printMonth(months.get(i));
    }

    return months;
  }

}

