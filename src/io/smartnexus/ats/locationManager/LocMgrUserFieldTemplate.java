package io.smartnexus.ats.locationManager;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.smartnexus.ats.configure.product.AddProductMaster;
import io.smartnexus.ats.utils.ExtentManager;
import io.smartnexus.ats.utils.NorthBoundInterface;

public class LocMgrUserFieldTemplate {

  private static final Logger log = Logger.getLogger(LocMgrUserFieldTemplate.class.getName());
  ExtentTest logger;
  ExtentReports extent;
  private String productLineID;
  public String SKUID;
  private NorthBoundInterface nbi;

  @BeforeClass

  public void setUp() throws Exception {
    extent = ExtentManager.getInstance();
    nbi = new NorthBoundInterface();
    SKUID = AddProductMaster.productMasterSku;
    productLineID = AddProductMaster.productMasterId;
  }

  /*
   * ADD String CellOEMUserfileds
   */
  @Test(priority = 1, enabled = true)
  public void TEST_921_addCellOEMUserfileds() throws IOException, InterruptedException, Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    int status = nbi.addLocationManagerUserfield(productLineID, "cellOEM", "cellOEM", "Quectel BG96", "21", "String");
    Assert.assertTrue(200 <= status & status <= 205);
    logger.log(LogStatus.PASS, "addCellOEMUserfileds test Completed");
    log.debug("addCellOEMUserfileds test Completed");

  }

  /*
   * ADD String addGpsOEMUserfileds
   */
  @Test(priority = 2, enabled = true)
  public void TEST_921_addGpsOEMUserfileds() throws IOException, InterruptedException, Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    int status = nbi.addLocationManagerUserfield(productLineID, "gpsOEM", "gpsOEM", "Ublox M8", "22", "String");
    Assert.assertTrue(200 <= status & status <= 205);
    logger.log(LogStatus.PASS, "addGpsOEMUserfileds test Completed");
    log.debug("addGpsOEMUserfileds test Completed");

  }

  /*
   * ADD addWifiOEMUserfileds
   */
  @Test(priority = 3, enabled = true)
  public void TEST_921_addWifiOEMUserfileds() throws IOException, InterruptedException, Exception {
    log.debug("Executing addWifiOEMUserfileds test");
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    int status = nbi.addLocationManagerUserfield(productLineID, "wifiOEM", "wifiOEM", "Atheros 5", "23", "String");
    Assert.assertTrue(200 <= status & status <= 205);
    logger.log(LogStatus.PASS, "addWifiOEMUserfileds test Completed");
    log.debug("addWifiOEMUserfileds test Completed");

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
      e.printStackTrace();
    }
    extent.endTest(logger);
  }

}
