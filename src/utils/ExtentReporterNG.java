package io.smartnexus.ats.utils;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReporterNG implements IReporter {
  private ExtentReports extent;

  private ExtentTest test;

  @Override
  public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
    extent = new ExtentReports(outputDirectory + File.separator + "ATSExtent.html", true);
    for (ISuite suite : suites) {
      Map<String, ISuiteResult> result = suite.getResults();
      for (ISuiteResult r : result.values()) {
        ITestContext context = r.getTestContext();
        buildTestNodes(context.getPassedTests(), LogStatus.PASS);
        buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
        buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
      }
    }
    extent.flush();
    extent.close();
  }

  private void buildTestNodes(IResultMap tests, LogStatus status) {

    if (tests.size() > 0) {
      for (ITestResult result : tests.getAllResults()) {
        test = extent.startTest(result.getMethod().getMethodName());
        String str = result.getMethod().getMethodName().toString().split("_")[1];
        String link = "<a href=\"https://flexci.atlassian.net/browse/TEST-" + str + "\" target=\"https://flexci.atlassian.net/browse/TEST-" + str
            + "\">https://flexci.atlassian.net/browse/TEST-" + str + "</a>";
        test.assignAuthor(link);
        test.getTest().setStartedTime(getTime(result.getStartMillis()));
        test.getTest().setEndedTime(getTime(result.getEndMillis()));

        for (String group : result.getMethod().getGroups())
          test.assignCategory(group);

        String message = "Test " + status.toString().toLowerCase() + "ed";

        if (result.getThrowable() != null) {
          result.getThrowable().printStackTrace();
          test.log(status, result.getThrowable().getMessage());
          String img = test.addScreenCapture((System.getProperty("user.dir") + "test.png"));
          test.log(LogStatus.INFO, "Image", "Image example: " + img);
        } else {

          test.log(status, message);
        }
        extent.endTest(test);
      }
    }
  }

  private Date getTime(long millis) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTimeInMillis(millis);
    return calendar.getTime();
  }
}