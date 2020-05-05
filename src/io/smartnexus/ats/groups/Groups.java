package io.smartnexus.ats.groups;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.smartnexus.ats.utils.CommonUtils;
import io.smartnexus.ats.utils.ExtentManager;
import io.smartnexus.ats.utils.NorthBoundInterface;

public class Groups {
  private static final Logger log = Logger.getLogger(Groups.class.getName());
  ExtentTest logger;
  ExtentReports extent;
  private NorthBoundInterface nbi;
  static CommonUtils cu = new CommonUtils();
  private String groupId;

  @BeforeClass

  public void setUp() throws Exception {
    extent = ExtentManager.getInstance();
    nbi = new NorthBoundInterface();

  }

  @Test(priority = 1, enabled = true)
  public void addReportingGroup() throws Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    String reportingGrpName = "ReportingGrp_" + cu.randomName();
    groupId = nbi.addReportingGroup(reportingGrpName);
    Assert.assertEquals(nbi.getReportingGroup(groupId), reportingGrpName);
    logger.log(LogStatus.PASS, "addReportingGroup test Completed");
    log.debug("addReportingGroup test Completed");

  }

  @Test(priority = 2, enabled = true)
  public void updateReportingGroup() throws Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    int status = nbi.updateReportingGroup(groupId);
    Assert.assertTrue(200 <= status & status <= 205);
    logger.log(LogStatus.PASS, "addReportingGroup test Completed");
    log.debug("addReportingGroup test Completed");

  }

  @AfterMethod
  public void writeResult(ITestResult result) {
    String methodName = result.getMethod().getMethodName();
    try {
      if (result.getStatus() == ITestResult.SUCCESS) {
        nbi.changeJiraStatus(methodName, "Pass");
      } else if (result.getStatus() == ITestResult.FAILURE) {
        nbi.changeJiraStatus(methodName, "Fail");
      } else if (result.getStatus() == ITestResult.SKIP) {
        nbi.changeJiraStatus(methodName, "Unknown");
      }
    } catch (Exception e) {
      log.debug("Jira API status update failed ");
    }
    extent.endTest(logger);
  }

}
