package io.smartnexus.ats.configure.peripheral;

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

public class AddPeripheral {

  private static final Logger log = Logger.getLogger(AddPeripheral.class.getName());
  ExtentTest logger;
  ExtentReports extent;
  public static String peripheralName;
  public static String editedDEP;
  private NorthBoundInterface nbi;
  private String productMasterId;
  private String peripheralId;

  // LoginAs Administrator
  @BeforeClass

  public void setUp() throws Exception {
    extent = ExtentManager.getInstance();
    nbi = new NorthBoundInterface();
    productMasterId = AddProductMaster.productMasterId;
  }

  /*
   * Add Peripheral Ep
   */
  @Test(priority = 1, enabled = true)
  public void TEST_423_addPeripheral() {
    logger = extent.startTest(this.getClass().getSimpleName());
    String response = nbi.addPeripheral(productMasterId);
    String[] s1 = response.split(",");
    int status = Integer.parseInt(s1[0]);
    peripheralId = s1[1];
    Assert.assertTrue(200 <= status && status <= 205);
    logger.log(LogStatus.PASS, "addPeripheral test Completed");
    log.debug("addPeripheral test Completed");
  }

  /*
   * Edit Peripheral test
   */
  @Test(priority = 2, enabled = true)
  public void TEST_424_editPeripheral() {
    logger = extent.startTest(this.getClass().getSimpleName());
    int status = Integer.parseInt(nbi.updatePeripheral(productMasterId, peripheralId));
    Assert.assertTrue(200 <= status && status <= 205);
    logger.log(LogStatus.PASS, "editPeripheral to the Product Line");
    log.debug("editPeripheral test Completed");
  }

  /*
   * Verify Add Peripheral with Duplicate MFGID
   */
  @Test(priority = 3, enabled = true)
  public void TEST_46_addPeripheralWithDuplicateMFGID() {
    logger = extent.startTest(this.getClass().getSimpleName());
    String response = nbi.addPeripheral(productMasterId);
    String[] s1 = response.split(",");
    int status = Integer.parseInt(s1[0]);
    Assert.assertFalse(200 <= status && status <= 205);
    logger.log(LogStatus.PASS, "AddPeripheralWithDuplicateMFGID test Completed");
    log.debug("AddPeripheralWithDuplicateMFGID test Completed");
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
