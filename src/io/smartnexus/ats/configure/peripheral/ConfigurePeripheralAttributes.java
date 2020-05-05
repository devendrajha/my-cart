package io.smartnexus.ats.configure.peripheral;

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
import io.smartnexus.ats.utils.ExtentManager;
import io.smartnexus.ats.utils.NorthBoundInterface;

public class ConfigurePeripheralAttributes {

  private static final Logger log = Logger.getLogger(ConfigurePeripheralAttributes.class.getName());
  ExtentTest logger;
  ExtentReports extent;
  private NorthBoundInterface nbi;
  private String pmId;

  // LoginAs Administrator
  @BeforeClass
  public void setUp() throws Exception {
    extent = ExtentManager.getInstance();
    nbi = new NorthBoundInterface();
    pmId = AddProductMaster.productMasterId;
  }

  /*
   * Add boolean Attribute test
   */
  @Test(priority = 1, enabled = true)
  public void TEST_430_addBooleanPeripheralAttribute() throws IOException, InterruptedException, Exception {
    logger = extent.startTest(this.getClass().getSimpleName());
    nbi.addPeripheralAttribute(pmId, 1, "Boolean");
    Assert.assertTrue(nbi.verifyAddedPeripheralAttribute(pmId, 1));
    logger.log(LogStatus.PASS, "addBooleanPeripheralAttribute test Completed");
    log.debug("addBooleanPeripheralAttribute test Completed");
  }

  /*
   * Add INT Attribute test
   */
  @Test(priority = 2, enabled = true)
  public void TEST_431_addIntPeripheralAttribute() throws IOException, InterruptedException, Exception {
    logger = extent.startTest(this.getClass().getSimpleName());
    nbi.addPeripheralAttribute(pmId, 2, "Int");
    Assert.assertTrue(nbi.verifyAddedPeripheralAttribute(pmId, 2));
    logger.log(LogStatus.PASS, "addIntPeripheralAttribute test Completed");
    log.debug("addIntPeripheralAttribute test Completed");
  }
  
  /*
   * Add Byte Attribute test
   */
  @Test(priority = 3, enabled = true)
  public void TEST_432_addBytePeripheralAttribute() throws IOException, InterruptedException, Exception {
    logger = extent.startTest(this.getClass().getSimpleName());
    nbi.addPeripheralAttribute(pmId, 3, "Byte");
    Assert.assertTrue(nbi.verifyAddedPeripheralAttribute(pmId, 3));
    logger.log(LogStatus.PASS, "TEST_432_addBytePeripheralAttribute test Completed");
    log.debug("TEST_432_addBytePeripheralAttribute test Completed");
  }

  /*
   * Add Decimal Attribute test
   */
  @Test(priority = 4, enabled = true)
  public void TEST_433_addDecimalPeripheralAttribute() throws IOException, InterruptedException, Exception {
    logger = extent.startTest(this.getClass().getSimpleName());
    nbi.addPeripheralAttribute(pmId, 4, "Decimal");
    Assert.assertTrue(nbi.verifyAddedPeripheralAttribute(pmId, 4));
    logger.log(LogStatus.PASS, "TEST_433_addDecimalPeripheralAttribute test Completed");
    log.debug("TEST_433_addDecimalPeripheralAttribute test Completed");
  }

  
  /*
   * Add Decimal Attribute test
   */
  @Test(priority = 5, enabled = true)
  public void TEST_434_addBigIntPeripheralAttribute() throws IOException, InterruptedException, Exception {
    logger = extent.startTest(this.getClass().getSimpleName());
    nbi.addPeripheralAttribute(pmId, 5, "BigInt");
    Assert.assertTrue(nbi.verifyAddedPeripheralAttribute(pmId, 5));
    logger.log(LogStatus.PASS, "TEST_434_addBigIntPeripheralAttribute test Completed");
    log.debug("TEST_434_addBigIntPeripheralAttribute test Completed");
  }
  
  /*
   * ADD STRING ATTRIBUTE TEST
   */
  @Test(priority = 6, enabled = true)
  public void TEST_435_addStringPeripheralAttribute() throws IOException, InterruptedException, Exception {
    logger = extent.startTest(this.getClass().getSimpleName());
    nbi.addPeripheralAttribute(pmId, 6, "String");
    Assert.assertTrue(nbi.verifyAddedPeripheralAttribute(pmId, 6));
    logger.log(LogStatus.PASS, "addStringPeripheralAttribute test Completed");
    log.debug("addStringPeripheralAttribute test Completed");
  }
  
  /*
   * ADD Float ATTRIBUTE TEST
   */
  @Test(priority = 7, enabled = true)
  public void TEST_436_addStringPeripheralAttribute() throws IOException, InterruptedException, Exception {
    logger = extent.startTest(this.getClass().getSimpleName());
    nbi.addPeripheralAttribute(pmId, 7, "Float");
    Assert.assertTrue(nbi.verifyAddedPeripheralAttribute(pmId, 7));
    logger.log(LogStatus.PASS, "TEST_436_addStringPeripheralAttribute test Completed");
    log.debug("TEST_436_addStringPeripheralAttribute test Completed");
  }
  /*
   * ADD Float ATTRIBUTE TEST
   */
  @Test(priority = 8, enabled = true)
  public void TEST_437_addDoublePeripheralAttribute() throws IOException, InterruptedException, Exception {
    logger = extent.startTest(this.getClass().getSimpleName());
    nbi.addPeripheralAttribute(pmId, 8, "Double");
    Assert.assertTrue(nbi.verifyAddedPeripheralAttribute(pmId, 8));
    logger.log(LogStatus.PASS, "TEST_437_addDoublePeripheralAttribute test Completed");
    log.debug("TEST_437_addDoublePeripheralAttribute test Completed");
  }
  /*
   * ADD Float ATTRIBUTE TEST
   */
  @Test(priority = 7, enabled = true)
  public void TEST_438_addLDoublePeripheralAttribute() throws IOException, InterruptedException, Exception {
    logger = extent.startTest(this.getClass().getSimpleName());
    nbi.addPeripheralAttribute(pmId, 9, "LDouble");
    Assert.assertTrue(nbi.verifyAddedPeripheralAttribute(pmId, 9));
    logger.log(LogStatus.PASS, "TEST_438_addLDoublePeripheralAttribute test Completed");
    log.debug("TEST_438_addLDoublePeripheralAttribute test Completed");
  }

  /*
   * ADD LDOUBLE ATTRIBUTE API TEST
   */
  @Test(priority = 4, enabled = true)
  public void TEST_212_addJsonPeripheralAttribute() throws ParseException, Exception {
    logger = extent.startTest(this.getClass().getSimpleName());
    nbi.addPeripheralAttribute(pmId, 10, "Json");
    Assert.assertTrue(nbi.verifyAddedPeripheralAttribute(pmId, 10));
    logger.log(LogStatus.PASS, "addJsonPeripheralAttribute test Completed");
    log.debug("addJsonPeripheralAttribute test Completed");
  }

  /*
   * ADD LDOUBLE ATTRIBUTE API TEST
   */
  @Test(priority = 5, enabled = true)
  public void TEST_943_verifyAddDuplicatePeripheralAttribute() throws ParseException, Exception {
    logger = extent.startTest(this.getClass().getSimpleName());
    String response = nbi.addPeripheralAttribute(pmId, 10, "Json");
    String[] s1 = response.split(",");
    String errorResponse = s1[2];
    Assert.assertTrue(errorResponse.contains("Local id already exists."));
    logger.log(LogStatus.PASS, "verifyAddDuplicatePeripheralAttribute test Completed");
    log.debug("verifyAddDuplicatePeripheralAttribute test Completed");
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
