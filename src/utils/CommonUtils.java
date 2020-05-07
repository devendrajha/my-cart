package io.smartnexus.ats.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.testng.Assert;

import au.com.bytecode.opencsv.CSVWriter;

public class CommonUtils {

  private static final Logger log = Logger.getLogger(CommonUtils.class.getName());

  /**
   * This method used to Generate random OUI no
   *
   * @return oui
   */
  public int generateRandomOui() {
    log.debug("generateRandomOui Started");
    int oui = 0;
    try {
      Random rnd = new Random();
      oui = 100000 + rnd.nextInt(900000);
      return oui;
    } catch (Exception e) {
      e.printStackTrace();
    }
    log.debug("generateRandomOui completed");
    return oui;
  }

  /**
   * This method method used to split value and return the index location
   *
   * @param inputValue  - Input String to be checked
   * @param splitFormat - comma or backspace
   * @param index       - position of the string after splitting
   * @return splitValue - returns the string value for the index given
   * @throws InterruptedException
   */
  public String splitValue(String inputValue, String splitFormat, int index) {
    log.debug("splitValue started");
    String[] splitValue;
    splitValue = inputValue.split(splitFormat);
    log.debug(splitValue[index] + "Actual Value");
    log.debug("splitValue completed");
    return splitValue[index];
  }

  /**
   * This method used to Create Random Text with length 5
   *
   * @return random name with length of 5
   */
  public StringBuffer randomName() {
    String chars = "abcdefghijklmnopqrstuvwxyz";
    StringBuffer buf = null;
    try {
      Random r = new Random();
      int limit = Constants.IN_RANDOM_NUMBER_LENGTH;
      buf = new StringBuffer();
      buf.append(chars.charAt(r.nextInt(26)));
      for (int i = 0; i < limit; i++) {
        buf.append(chars.charAt(r.nextInt(chars.length())));
      }
    } catch (Exception e) {
      log.error("Fail - not able to generate random text for", e);
    }
    return buf;
  }

  /**
   * This method is used to generate Calendar Instance
   *
   * @return random date in dd/mm/yyyy format
   */

  public String randomDate() {
    String DATE_FORMAT_NOW = "dd/MM/yyyy";
    Calendar cal = null;
    SimpleDateFormat sdf = null;
    try {
      cal = Calendar.getInstance();
      sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
    } catch (Exception e) {
      log.error("Fail - not able to generate  generate Calendar Instance", e);
    }
    return sdf.format(cal.getTime());
  }

  /**
   * This method is used to generate 3 digit random number
   *
   * @return - three digit random number
   */

  public int generateRandomNumber() {
    double a = Math.random();
    int threeDigit = (int) (a * 1000);
    return threeDigit;
  }

  public int generateRandomID() {
    double a = Math.random();
    int twoDigit = (int) (a * 100);
    return twoDigit;
  }

  /**
   * Function to get a standard date and time library for Java using Joda-Time calenderFormattedDate method returns formatted date in [Thu Feb 11th 2015] format
   *
   * @return current date in the corresponding format Eg.Thu Feb 11th 2015
   */
  public String getCalenderDate() {
    String dayOfWeek = "E";
    String monthOfYear = " MMM";
    String dayOfMonth = " d";
    String year = " yyyy";
    String suffixOfDay = "";
    DateTime dateTime = new DateTime();
    if (dayOfMonth.endsWith("1") || dayOfMonth.endsWith("21") || dayOfMonth.endsWith("31"))
      suffixOfDay += "st";
    if (dayOfMonth.endsWith("2") || dayOfMonth.endsWith("22"))
      suffixOfDay += "nd";
    if (dayOfMonth.endsWith("3") || dayOfMonth.endsWith("23"))
      suffixOfDay += "rd";
    else
      suffixOfDay += "th";
    String value1 = dateTime.toString(dayOfWeek + monthOfYear + dayOfMonth);
    String value2 = suffixOfDay;
    String value3 = dateTime.toString(year);
    String calenderFormattedDate = value1 + value2 + value3;
    log.debug(calenderFormattedDate);
    return calenderFormattedDate;
  }

  /**
   * Get the current Calendar Time using Joda Time
   *
   * @return current date in the HH:MM:SS format Eg.11:14:04
   */
  public String currentCalenderTime() throws InterruptedException {
    // Creates a new instance of DateTime object.
    String pattern = "HH:mm:ss";
    DateTime dateTime = new DateTime();
    log.debug(dateTime.toString(pattern));
    return dateTime.toString(pattern);
  }

  /**
   * Get the current Calendar Time using Joda-Time and calculate the time difference
   *
   * @return time in seconds Eg.10
   */
  public boolean getTimeDifference(String time1, String time2) throws InterruptedException, ParseException {
    DateTimeFormatter format = DateTimeFormat.forPattern("HH:mm:ss");
    DateTime timeOne = format.parseDateTime(time1);
    DateTime timeTwo = format.parseDateTime(time2);
    log.debug(timeOne + " timeOne");
    log.debug(timeTwo + " timeTwo");
    long difference = timeTwo.getSecondOfMinute() - timeOne.getSecondOfMinute();
    log.debug(difference + " Difference in Seconds");
    boolean timeDifference = false;
    if (difference <= 50) {
      log.debug("User Login Time Verified successfully");
      timeDifference = true;
    }
    log.debug(timeDifference);
    return timeDifference;
  }

  /**
   * Get the Current Calendar Date in (MM-dd-yyyy) format using Joda-Time
   *
   * @return current date in MM/dd/yyy format Eg.02/11/2015
   */
  public String getCurrentCalenderDate() {
    String pattern = "MM/dd/yyyy";
    DateTime dateTime = new DateTime();
    log.debug(dateTime.toString(pattern));
    return pattern;
  }

  /**
   * Function to Get the User Directory and create folder to save CSV File
   *
   * @return file - return the file name
   */
  public File createDirectory() {
    String strWorkSpacePath = System.getProperty("user.home");
    log.debug(strWorkSpacePath + "strWorkSpacePath");
    String strSourceFolderName = strWorkSpacePath + "/AutoCSVReports";
    File file = new File(strSourceFolderName);
    try {
      if (file.exists() == false) {
        // Make Directory
        file.mkdir();
        log.debug("Directory Created");
      } else {
        log.debug("Directory is not created/Already Exists");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return file;
  }

  /**
   * Function to delete file directory using its location.
   *
   * @param dir - Location of file
   */
  public boolean deleteDir(File dir) {
    if (dir.isDirectory()) {
      String[] children = dir.list();
      for (int i = 0; i < children.length; i++) {
        boolean success = deleteDir(new File(dir, children[i]));
        if (!success) {
          return false;
        }
      }
    }
    log.debug(dir.exists());
    return dir.delete();
  }

  /**
   * readCsvFile - Function to Read CSV file which needs to be parsed Using file reader
   *
   * @param reportsName - Name of Report as String
   * @param phoneNumber - Subscriber Phone number as String
   * @throws IOException
   */
  public void readCsvFile(String reportsName, String phoneNumber) throws IOException {
    String strWorkSpacePath = System.getProperty("user.home");
    String strSourceFolderName = strWorkSpacePath + "/CSVReports/";
    // Input file which needs to be parsed
    String line;
    String actualValue = "";
    try (BufferedReader br = new BufferedReader(new FileReader(strSourceFolderName + reportsName + ".csv"))) {
      while ((line = br.readLine()) != null) {
        // Get all tokens available in line
        String[] tokens = line.split(",");
        for (String token : tokens) {
          if (token.contains(phoneNumber)) {
            actualValue = token.replaceAll("\"", "");
            break;
          }
        }
      }
      Assert.assertEquals(actualValue, phoneNumber);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * WriteCsvFile - Function Write the record to file using WriteCsvFile
   *
   * @param headers - Name of Report as String
   * @param values  - Subscriber Phone number as String
   * @return csv - return the CSV file name
   * @throws IOException
   * @throws ParseException
   * @throws IllegalStateException
   */
  public String WriteCsvFile(String[] headers, String[] values) throws IOException, IllegalStateException, ParseException {
    String csv = System.getProperty("user.dir") + "data.csv";
    log.debug("csv location" + csv);
    CSVWriter writer = new CSVWriter(new FileWriter(csv));
    // Write the record to file
    writer.writeNext(headers);
    writer.writeNext(values);
    // close the writer
    writer.close();
    return csv;
  }

  /**
   * Function to delete a File using its location.
   *
   * @param fileLoc - Location of file
   */
  public void deleteFile(String fileLoc) {
    // Delete CSV File Created
    File file = new File(fileLoc);
    boolean status = file.delete();
    if (status)
      log.debug("File deleted successfully!!");
    else
      log.debug("File name does not exists");
  }
}
