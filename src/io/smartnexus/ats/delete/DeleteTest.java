package io.smartnexus.ats.delete;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.smartnexus.ats.configure.product.AddProductMaster;
import io.smartnexus.ats.groups.AddOTAgroup;
import io.smartnexus.ats.packagemanager.AddFullBundle;
import io.smartnexus.ats.tenant.AddTenant;
import io.smartnexus.ats.utils.ExtentManager;
import io.smartnexus.ats.utils.NorthBoundInterface;

public class DeleteTest {

  private static final Logger log = Logger.getLogger(DeleteTest.class.getName());
  ExtentTest logger;
  ExtentReports extent;
  private NorthBoundInterface nbi;
  public static String  productMasterId,deviceId,otaGroupIdwithSchedule,otaGroupIdwithoutSchedule,packageGroupId;

  @BeforeClass
  public void setUp() throws Exception {
    extent = ExtentManager.getInstance();
    nbi = new NorthBoundInterface();
    productMasterId = AddProductMaster.productMasterId;
    otaGroupIdwithSchedule=AddOTAgroup.otaGroupIdwithSchedule;
    otaGroupIdwithoutSchedule=AddOTAgroup.otaGroupIdwithoutSchedule;
    packageGroupId=AddFullBundle.packageGroupId;
    deviceId=AddOTAgroup.deviceId;
  }

  /*
   * removeProductFromOTAGroup
   */
  @Test(priority = 1, enabled = false)
  public void TEST_256_removeProductFromOTAGroup() throws IOException, InterruptedException, Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    int status = nbi.removeProductFromOTAGroup(otaGroupIdwithSchedule, deviceId);
    Assert.assertTrue(200 <= status & status <= 205);
    logger.log(LogStatus.PASS, "removeProductFromOTAGroup test Completed");
    log.debug("removeProductFromOTAGroup test Completed");
  }

  /*
   * deleteOTAGroupWithScheduler
   */
  @Test(priority = 2, enabled = false)
  public void TEST_256_deleteOTAGroupWithScheduler() throws IOException, InterruptedException, Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    int status = nbi.deleteOTA(otaGroupIdwithSchedule);
    Assert.assertTrue(200 <= status & status <= 205);
    logger.log(LogStatus.PASS, "deleteOTAGroupWithScheduler test Completed");
    log.debug("deleteOTAGroupWithScheduler test Completed");
  }

  /*
   * deleteOTAGroupWithoutScheduler
   */
  @Test(priority = 3, enabled = false)
  public void TEST_256_deleteOTAGroupWithoutScheduler() throws IOException, InterruptedException, Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    int status = nbi.deleteOTA(otaGroupIdwithoutSchedule);
    Assert.assertTrue(200 <= status & status <= 205);
    logger.log(LogStatus.PASS, "deleteOTAGroupWithoutScheduler test Completed");
    log.debug("deleteOTAGroupWithoutScheduler test Completed");
  }

  
  /*
   * deleteFullBundle
   */
  @Test(priority = 4, enabled = false)
  public void TEST_256_deleteFullBundle() throws IOException, InterruptedException, Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    int status = nbi.deleteFullBundle(productMasterId,packageGroupId);
    Assert.assertTrue(200 <= status & status <= 205);
    logger.log(LogStatus.PASS, "deleteFullBundle test Completed");
    log.debug("deleteFullBundle test Completed");
  }

  /*
   * TEST_256_deleteMultiple device
   */
  @Test(priority = 9, enabled = true)
  public void TEST_190_deleteMultipleDevice() throws IOException, InterruptedException, Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    Thread.sleep(6000);
    int status = nbi.deleteDevice( productMasterId);
    Assert.assertTrue(200 <= status & status <= 205);
    logger.log(LogStatus.PASS, "deleteProductMaster test Completed");
    log.debug("deleteProductMaster test Completed");
  }

  
  /*
   * TEST_256_deleteMultiple device
   */
  @Test(priority = 10, enabled = true)
  public void bulkDeleteDevice() throws IOException, InterruptedException, Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    int status = nbi.bulkDevice( productMasterId);
    Assert.assertTrue(202 == status);
    logger.log(LogStatus.PASS, "deleteProductMaster test Completed");
    log.debug("deleteProductMaster test Completed");
  }

  
  /*
   * TEST_256_deleteCasecadeProductMaster
   */
  @Test(priority = 11, enabled = false)
  public void TEST_256_deleteCasecadeProductMaster() throws IOException, InterruptedException, Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    Thread.sleep(6000);
    int status = nbi.deleteProductMaster( productMasterId);
    Assert.assertTrue(200 <= status & status <= 205);
    logger.log(LogStatus.PASS, "deleteProductMaster test Completed");
    log.debug("deleteProductMaster test Completed");
  }

  
  
  
  /*
   * TEST_89_deleteTenant
   */
  @Test(priority = 12, enabled = false)
  public void TEST_89_deleteTenant() throws IOException, InterruptedException, Exception, ParseException {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    int status = nbi.deleteCompany();
    Assert.assertTrue(200 <= status & status <= 205);
    logger.log(LogStatus.PASS, "deleteTenant test Completed");
    log.debug("deleteTenant test Completed");
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
