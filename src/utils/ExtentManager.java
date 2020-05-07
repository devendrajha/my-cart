package io.smartnexus.ats.utils;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
  private static ExtentReports extent;

  public static ExtentReports getInstance() {
    if (extent == null) {
      extent = new ExtentReports(System.getProperty("user.dir") + File.separator + "AdvanceReport.html", true);
   //   System.out.println(System.getProperty("user.dir") + File.separator + "AdvanceReport.html");
    }
    return extent;
  }

}
