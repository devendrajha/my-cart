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
import io.smartnexus.ats.utils.CommonUtils;
import io.smartnexus.ats.utils.ExtentManager;
import io.smartnexus.ats.utils.NorthBoundInterface;

public class ConfigurePeripheralUserFields {

  private static final Logger log = Logger.getLogger(ConfigurePeripheralUserFields.class.getName());
  private String pmId;
  ExtentTest logger;
  ExtentReports extent;
  private NorthBoundInterface nbi;
  static CommonUtils cu = new CommonUtils();

  @BeforeClass
  public void setUp() throws Exception {
    extent = ExtentManager.getInstance();
    nbi = new NorthBoundInterface();
    pmId = AddProductMaster.productMasterId;
  }

  /*
   * ADD USER DETAILS FOR PRODUCT LINE WITH BOOLEAN TEST
   */
  @Test(priority = 1, enabled = true)
  public void TEST_522_addUserDetailBoolean() {
    logger = extent.startTest(this.getClass().getSimpleName());
    String name = "UF" + cu.randomName();
    nbi.addPeripheralUserfield(pmId, name, "1", "Boolean");
    Assert.assertTrue(nbi.getPeriphalUserFieldTemplate(pmId, name));
    logger.log(LogStatus.PASS, "add User Detail Boolean is completed");
    log.debug("add User Detail for Boolean Data type test Completed");
  }

  /*
   * ADD USER DETAILS FOR PRODUCT LINE WITH INT TEST
   */
  @Test(priority = 2, enabled = true)
  public void TEST_523_addUserDetailInt() {
    logger = extent.startTest(this.getClass().getSimpleName());
    String name = "UF" + cu.randomName();
    nbi.addPeripheralUserfield(pmId, name, "2", "Int");
    Assert.assertTrue(nbi.getPeriphalUserFieldTemplate(pmId, name));
    logger.log(LogStatus.PASS, "add User Detail INT is completed");
    log.debug("add User Detail for Int Data type test Completed");
  }

  /*
   * ADD USER DETAILS FOR PRODUCT LINE WITH STRING TEST
   */
  @Test(priority = 3, enabled = true)
  public void TEST_524_addUserDetailString() {
    logger = extent.startTest(this.getClass().getSimpleName());
    String name = "UF" + cu.randomName();
    nbi.addPeripheralUserfield(pmId, name, "3", "String");
    Assert.assertTrue(nbi.getPeriphalUserFieldTemplate(pmId, name));
    logger.log(LogStatus.PASS, "add User Detail String is completed");
    log.debug("add User Detail for String Data type test Completed");
  }

  /*
   * ADD USER DETAILS FOR PRODUCT LINE WITH BYTE TEST
   */
  @Test(priority = 4, enabled = true)
  public void TEST_525_addUserDetailByte() {
    logger = extent.startTest(this.getClass().getSimpleName());
    String name = "UF" + cu.randomName();
    nbi.addPeripheralUserfield(pmId, name, "4", "Byte");
    Assert.assertTrue(nbi.getPeriphalUserFieldTemplate(pmId, name));
    logger.log(LogStatus.PASS, "add User Detail Byte is completed");
    log.debug("add User Detail for Byte Data type test Completed");
  }

  /*
   * ADD USER DETAILS FOR PRODUCT LINE WITH BIGINT TEST
   */
  @Test(priority = 5, enabled = true)
  public void TEST_526_addUserDetailBigInt() {
    logger = extent.startTest(this.getClass().getSimpleName());
    String name = "UF" + cu.randomName();
    nbi.addPeripheralUserfield(pmId, name, "5", "BigInt");
    Assert.assertTrue(nbi.getPeriphalUserFieldTemplate(pmId, name));
    logger.log(LogStatus.PASS, "add User Detail BigInt is completed");
    log.debug("add User Detail for BigInt Data type test Completed");
  }

  /*
   * ADD USER DETAILS FOR PRODUCT LINE WITH DOUBLE TEST
   */
  @Test(priority = 6, enabled = true)
  public void TEST_527_addUserDetailDouble() {
    logger = extent.startTest(this.getClass().getSimpleName());
    String name = "UF" + cu.randomName();
    nbi.addPeripheralUserfield(pmId, name, "6", "Double");
    Assert.assertTrue(nbi.getPeriphalUserFieldTemplate(pmId, name));
    logger.log(LogStatus.PASS, "add User Detail Double is completed");
    log.debug("add User Detail For Double Data type test Completed");
  }

  /*
   * ADD USER DETAILS FOR PRODUCT LINE WITH FLOAT TEST
   */
  @Test(priority = 7, enabled = true)
  public void TEST_528_addUserDetailFloat() {
    logger = extent.startTest(this.getClass().getSimpleName());
    String name = "UF" + cu.randomName();
    nbi.addPeripheralUserfield(pmId, name, "7", "Float");
    Assert.assertTrue(nbi.getPeriphalUserFieldTemplate(pmId, name));
    logger.log(LogStatus.PASS, "add User Detail Float is completed");
    log.debug("add User Detail for Float  Data type test Completed");
  }

  /*
   * ADD USER DETAILS FOR PRODUCT LINE WITH LDOUBLE TEST
   */
  @Test(priority = 8, enabled = true)
  public void TEST_529_addUserDetailLDouble() {
    logger = extent.startTest(this.getClass().getSimpleName());
    String name = "UF" + cu.randomName();
    nbi.addPeripheralUserfield(pmId, name, "8", "LDouble");
    Assert.assertTrue(nbi.getPeriphalUserFieldTemplate(pmId, name));
    logger.log(LogStatus.PASS, "add User Detail LDouble is completed");
    log.debug("add User Detail for LDouble  Data type test Completed");
  }

  /*
   * ADD USER DETAILS FOR PRODUCT LINE WITH DECIMAL TEST
   */
  @Test(priority = 9, enabled = true)
  public void TEST_530_addUserDetailDecimal() {
    logger = extent.startTest(this.getClass().getSimpleName());
    String name = "UF" + cu.randomName();
    nbi.addPeripheralUserfield(pmId, name, "9", "Decimal");
    Assert.assertTrue(nbi.getPeriphalUserFieldTemplate(pmId, name));
    logger.log(LogStatus.PASS, "add User Detail Decimal is completed");
    log.debug("add User Detail for Decimal  Data type test Completed");
  }

  /*
   * ADD USER DETAILS FOR PRODUCT LINE WITH json data type TEST
   */
  @Test(priority = 10, enabled = true)
  public void TEST_955_addUserDetailJson() {
    logger = extent.startTest(this.getClass().getSimpleName());
    String name = "UF" + cu.randomName();
    nbi.addPeripheralUserfield(pmId, name, "10", "JSON");
    Assert.assertTrue(nbi.getPeriphalUserFieldTemplate(pmId, name));
    logger.log(LogStatus.PASS, "addUserDetailJson is completed");
    log.debug("addUserDetailJson Data type test Completed");
  }

  /*
   * Update Peripheral User field test
   */
  @Test(priority = 11, enabled = true)
  public void TEST_531_updateUserFieldDEP() {
    logger = extent.startTest(this.getClass().getSimpleName());
    int status = nbi.updatePeripheralCustomField("9", pmId);
    Assert.assertTrue(200 <= status & status <= 205);
    logger.log(LogStatus.PASS, "updateUserFieldDEP is completed");
    log.debug("aupdateUserFieldDEP Completed");
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
