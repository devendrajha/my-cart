package io.smartnexus.ats.configure.product;

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

public class ConfigureProductUserFields {

  private static final Logger log = Logger.getLogger(ConfigureProductUserFields.class.getName());
  private NorthBoundInterface nbi;
  ExtentTest logger;
  ExtentReports extent;
  private String pmId;
  static CommonUtils cu = new CommonUtils();

  // LoginAs Administrator
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
  public void TEST_385_addUserDetailBoolean() throws Exception, InterruptedException {
    logger = extent.startTest(this.getClass().getSimpleName());
    String name = "Boolean";
    nbi.addProductUserfield(pmId, name, "1", "Boolean");
    Assert.assertTrue(nbi.getUserFieldTemplate(pmId, name));
    log.debug("add User Detail for Boolean Data type test Completed");
  }

  /*
   * EDIT USER CONFIGURATION DETAILS TEST
   */

  @Test(priority = 2, enabled = true)
  public void TEST_386_editProductLineUserConfigDetail() throws Exception {
    logger = extent.startTest(this.getClass().getSimpleName());
    int status = nbi.updateProductCustomField("1", pmId);
    Assert.assertTrue(200 <= status & status <= 205);
    logger.log(LogStatus.PASS, "editProductLineUserConfigDetail is completed");
    log.debug("editProductLineUserConfigDetail test Completed");

  }

  /*
   * ADD USER DETAILS FOR PRODUCT LINE WITH INT TEST
   */
  @Test(priority = 3, enabled = true)
  public void TEST_387_addUserDetailInt() throws Exception {
    logger = extent.startTest(this.getClass().getSimpleName());
    String name = "Int";
    nbi.addProductUserfield(pmId, name, "2", "Int");
    Assert.assertTrue(nbi.getUserFieldTemplate(pmId, name));
    logger.log(LogStatus.PASS, "add User Detail int is completed");
    log.debug("add User Detail for Int Data type test Completed");

  }

  /*
   * ADD USER DETAILS FOR PRODUCT LINE WITH STRING TEST
   */
  @Test(priority = 4, enabled = true)
  public void TEST_388_addUserDetailString() throws Exception {
    logger = extent.startTest(this.getClass().getSimpleName());
    String name = "String";
    nbi.addProductUserfield(pmId, name, "3", "String");
    Assert.assertTrue(nbi.getUserFieldTemplate(pmId, name));
    logger.log(LogStatus.PASS, "add User Detail String is completed");
    log.debug("add User Detail for String Data type test Completed");

  }

  /*
   * ADD USER DETAILS FOR PRODUCT LINE WITH BYTE TEST
   */
  @Test(priority = 5, enabled = true)
  public void TEST_389_addUserDetailByte() throws Exception {
    logger = extent.startTest(this.getClass().getSimpleName());
    String name = "Byte";
    nbi.addProductUserfield(pmId, name, "4", "Byte");
    Assert.assertTrue(nbi.getUserFieldTemplate(pmId, name));
    logger.log(LogStatus.PASS, "add User Detail Byte is completed");
    log.debug("add User Detail for Byte Data type test Completed");
  }

  /*
   * ADD USER DETAILS FOR PRODUCT LINE WITH BIGINT TEST
   */
  @Test(priority = 6, enabled = true)
  public void TEST_390_addUserDetailBigInt() throws Exception {
    logger = extent.startTest(this.getClass().getSimpleName());
    String name = "BigInt";//"UF" + cu.randomName();
    nbi.addProductUserfield(pmId, name, "5", "BigInt");
    Assert.assertTrue(nbi.getUserFieldTemplate(pmId, name));
    logger.log(LogStatus.PASS, "add User Detail BigInt is completed");
    log.debug("add User Detail for BigInt Data type test Completed");
  }

  /*
   * ADD USER DETAILS FOR PRODUCT LINE WITH DOUBLE TEST
   */
  @Test(priority = 7, enabled = true)
  public void TEST_391_addUserDetailDouble() throws Exception {
    logger = extent.startTest(this.getClass().getSimpleName());
    String name = "Double";
    nbi.addProductUserfield(pmId, name, "6", "Double");
    Assert.assertTrue(nbi.getUserFieldTemplate(pmId, name));
    logger.log(LogStatus.PASS, "add User Detail Double is completed");
    log.debug("add User Detail For Double Data type test Completed");

  }

  /*
   * ADD USER DETAILS FOR PRODUCT LINE WITH FLOAT TEST
   */
  @Test(priority = 8, enabled = true)
  public void TEST_392_addUserDetailFloat() throws Exception {
    logger = extent.startTest(this.getClass().getSimpleName());
    String name = "Float";
    nbi.addProductUserfield(pmId, name, "7", "Float");
    Assert.assertTrue(nbi.getUserFieldTemplate(pmId, name));
    logger.log(LogStatus.PASS, "add User Detail Float is completed");
    log.debug("add User Detail for Float  Data type test Completed");

  }

  /*
   * ADD USER DETAILS FOR PRODUCT LINE WITH LDOUBLE TEST
   */
  @Test(priority = 9, enabled = true)
  public void TEST_393_addUserDetailLDouble() throws Exception {
    logger = extent.startTest(this.getClass().getSimpleName());
    String name = "Double";
    nbi.addProductUserfield(pmId, name, "8", "Double");
    Assert.assertTrue(nbi.getUserFieldTemplate(pmId, name));
    logger.log(LogStatus.PASS, "add User Detail LDouble is completed");
    log.debug("dd User Detail for LDouble  Data type test Completed");
  }

  /*
   * ADD USER DETAILS FOR PRODUCT LINE WITH DECIMAL TEST
   */
  @Test(priority = 10, enabled = true)
  public void TEST_394_addUserDetailDecimal() throws Exception {
    logger = extent.startTest(this.getClass().getSimpleName());
    String name = "LDouble";
    nbi.addProductUserfield(pmId, name, "9", "LDouble");
    Assert.assertTrue(nbi.getUserFieldTemplate(pmId, name));
    logger.log(LogStatus.PASS, "add User Detail Decimal is completed");
    log.debug("add User Detail for Decimal  Data type test Completed");
  }

  /*
   * ADD Json UserFields
   */
  @Test(priority = 11, enabled = true)
  public void TEST_211_addJsonUserField() throws Exception {
    logger = extent.startTest(this.getClass().getSimpleName());
    String name = "Json";
    nbi.addProductUserfield(pmId, name, "10", "Json");
    Assert.assertTrue(nbi.getUserFieldTemplate(pmId, name));
    logger.log(LogStatus.PASS, "addJsonUserField test Completed");
    log.debug("addJsonUserField test Completed");

  }

  @Test(priority = 12, enabled = true)
  public void TEST_557_deleteProductUserfield() throws IllegalStateException, Exception {
    logger = extent.startTest(this.getClass().getSimpleName());
    int status = nbi.deleteProductCustomField(pmId, "9");
    Assert.assertTrue(200 <= status & status <= 205);
    logger.log(LogStatus.PASS, "deleteProductUserfield is completed");
    log.debug("deleteProductUserfield test Completed");
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
