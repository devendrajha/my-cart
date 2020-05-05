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

import io.smartnexus.ats.utils.Constants;
import io.smartnexus.ats.utils.ExtentManager;
import io.smartnexus.ats.utils.NorthBoundInterface;

public class ConfigureProductSettings {
  private static final Logger log = Logger.getLogger(ConfigureProductSettings.class.getName());
  ExtentTest logger;
  ExtentReports extent;
  private String productMasterID;
  public String SKUID;
  public static String staticSettingNameInt = null;
  private NorthBoundInterface nbi;

  // LoginAs Administrator
  @BeforeClass

  public void setUp() throws Exception {
    extent = ExtentManager.getInstance();
    nbi = new NorthBoundInterface();
    SKUID = AddProductMaster.productMasterSku;
    productMasterID = AddProductMaster.productMasterId;
  }

  
  /*
   * ADD BOOLEAN SETTINGS FOR DROPDOWN TEST
   */
  @Test(priority = 2, enabled = true)
  public void TEST_280_addProductSettingBoolean() throws Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    nbi.addProductsetting(productMasterID, 1, "Boolean", Constants.TEXT);
    Assert.assertTrue(nbi.verifyAddedSettings(productMasterID, 2));
    logger.log(LogStatus.PASS, "addProductSettingBoolean test Completed");
    log.debug("addProductSettingBoolean test Completed");

  }
  /*
   * ADD INT SETTINGS FOR DROPDOWN TEST FOR POSITIVE
   */
  @Test(priority = 1, enabled = true)
  public void TEST_282_addProductSettingIntType() throws Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    nbi.addProductsetting(productMasterID, 2, "Int", Constants.TEXT);
    Assert.assertTrue(nbi.verifyAddedSettings(productMasterID, 2));
    logger.log(LogStatus.PASS, "addProductSettingIntType test Completed");
    log.debug("addProductSettingIntType test Completed");

  }

  
  /*
   * ADD Byte SETTINGS FOR DROPDOWN TEST
   */
  @Test(priority = 3, enabled = true)
  public void TEST_281_addProductSettingByte() throws Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    nbi.addProductsetting(productMasterID, 3, "Byte", Constants.TEXT);
    Assert.assertTrue(nbi.verifyAddedSettings(productMasterID, 3));
    logger.log(LogStatus.PASS, "addProductSettingByte test Completed");
    log.debug("addProductSettingByte test Completed");

  }

  /*
   * ADD Decimal SETTINGS FOR DROPDOWN TEST
   */
  @Test(priority = 4, enabled = true)
  public void TEST_282_addProductSettingDecimal() throws Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    nbi.addProductsetting(productMasterID, 4, "Decimal", Constants.TEXT);
    Assert.assertTrue(nbi.verifyAddedSettings(productMasterID, 4));
    logger.log(LogStatus.PASS, "addProductSettingDecimal test Completed");
    log.debug("addProductSettingDecimal test Completed");

  }

  /*
   * ADD BigInt SETTINGS FOR DROPDOWN TEST
   */
  @Test(priority = 5, enabled = true)
  public void TEST_283_addProductSettingBigInt() throws Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    nbi.addProductsetting(productMasterID, 5, "BigInt", Constants.TEXT);
    Assert.assertTrue(nbi.verifyAddedSettings(productMasterID, 5));
    logger.log(LogStatus.PASS, "addProductSettingBigInt test Completed");
    log.debug("addProductSettingBigInt test Completed");

  }

  /*
   * ADD STRING SETTINGS FOR DROPDOWN TEST
   */
  @Test(priority = 6, enabled = true)
  public void TEST_288_addSettingString() throws Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    nbi.addProductsetting(productMasterID, 6, "String", Constants.TEXT);
    Assert.assertTrue(nbi.verifyAddedSettings(productMasterID, 6));
    logger.log(LogStatus.PASS, "addSettingDropDownString test Completed");
    log.debug("addSettingDropDownString test Completed");

  }

  /*
   * ADD Float SETTINGS FOR DROPDOWN TEST FOR POSITIVE
   */
  @Test(priority = 7, enabled = true)
  public void TEST_285_addFloatSetting() throws Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    nbi.addProductsetting(productMasterID, 7, "Float", Constants.TEXT);
    Assert.assertTrue(nbi.verifyAddedSettings(productMasterID, 7));
    logger.log(LogStatus.PASS, "addFloatSetting test Completed");
    log.debug("addFloatSetting test Completed");

  } 

  /*
   * ADD DOUBLE SETTINGS FOR TEXT TEST FOR POSITIVE
   */
  @Test(priority = 8, enabled = true)
  public void TEST_310_addProductSettingDouble() throws Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    nbi.addProductsetting(productMasterID, 8, "Double", Constants.TEXT);
    Assert.assertTrue(nbi.verifyAddedSettings(productMasterID, 8));
    logger.log(LogStatus.PASS, "addProductSettingDouble test Completed");
    log.debug("addProductSettingDouble test Completed");

  }

  /*
   * ADD LDOUBLE SETTINGS FOR TEXT TEST FOR POSITIVE
   */
  @Test(priority = 9, enabled = true)
  public void TEST_311_addSettingLdouble() throws Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    nbi.addProductsetting(productMasterID, 9, "LDouble", Constants.TEXT);
    Assert.assertTrue(nbi.verifyAddedSettings(productMasterID, 9));
    logger.log(LogStatus.PASS, "addSettingLdouble test Completed");
    log.debug("addSettingLdouble test Completed");

  }

  /*
   * ADD Json SETTINGS FOR TEST
   */
  @Test(priority = 10, enabled = true)
  public void TEST_207_addJsonSettng() throws Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    nbi.addProductsetting(productMasterID, 10, "Json", Constants.TEXT);
    Assert.assertTrue(nbi.verifyAddedSettings(productMasterID, 10));
    logger.log(LogStatus.PASS, "addJsonSettng test Completed");
    log.debug("addJsonSettng test Completed");

  }
  
  /*
   * ADD Boolean SETTINGS FOR TEXT FIELD TEST FOR POSITIVE
   */
  @Test(priority = 11, enabled = true)
  public void TEST_00_addSettingDropDownBoolean() throws Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    String response = nbi.addProductsetting(productMasterID, 11, "Boolean", Constants.DROPDOWN);
    String[] s1 = response.split(",");
    int status = Integer.parseInt(s1[0]);
    Assert.assertTrue(200 <= status & status <= 205);
    logger.log(LogStatus.PASS, "addSettingDropDownBoolean test Completed");
    log.debug("addSettingDropDownBoolean test Completed");

  }

  /*
   * ADD INT SETTINGS FOR DROPDOWN FIELD TEST FOR POSITIVE
   */
  @Test(priority = 12, enabled = true)
  public void TEST_284_addSettingDropDownInt() throws Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    String response = nbi.addProductsetting(productMasterID, 12, "Int", Constants.DROPDOWN);
    String[] s1 = response.split(",");
    int status = Integer.parseInt(s1[0]);
    Assert.assertTrue(200 <= status & status <= 205);
    logger.log(LogStatus.PASS, "addSettingDropDownInt test Completed");
    log.debug("addSettingDropDownInt test Completed");

  }
  
  /*
   * ADD String SETTINGS FOR DROPDOWN FIELD TEST FOR POSITIVE
   */
  @Test(priority = 13, enabled = true)
  public void TEST_00_addSettingDropDownString() throws Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    String response = nbi.addProductsetting(productMasterID, 13, "String", Constants.DROPDOWN);
    String[] s1 = response.split(",");
    int status = Integer.parseInt(s1[0]);
    Assert.assertTrue(200 <= status & status <= 205);
    logger.log(LogStatus.PASS, "addSettingDropDownString test Completed");
    log.debug("addSettingDropDownString test Completed");

  }
  
  /*
   * ADD Json SETTINGS FOR DROPDOWN FIELD TEST FOR POSITIVE
   */
  @Test(priority = 14, enabled = true)
  public void TEST_00_addSettingDropDownJson() throws Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    String response = nbi.addProductsetting(productMasterID, 14, "Json", Constants.DROPDOWN);
    String[] s1 = response.split(",");
    int status = Integer.parseInt(s1[0]);
    Assert.assertTrue(200 <= status & status <= 205);
    logger.log(LogStatus.PASS, "addSettingDropDownJson test Completed");
    log.debug("addSettingDropDownJson test Completed");

  }

  /*
   * VERIFY ADD SETTING WITH DUPLICATE DEVICEID
   */
  @Test(priority = 15, enabled = true)
  public void TEST_293_verifyaddSettingWithDuplicateID() throws Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    String response = nbi.addProductsetting(productMasterID, 2, "Int", Constants.TEXT);
    String[] s1 = response.split(",");
    String errorResponse = s1[2];
    Assert.assertTrue(errorResponse.contains("(localId) already exists"));
    logger.log(LogStatus.PASS, "verifyaddSettingWithDuplicateID test Completed");
    log.debug("verifyaddSettingWithDuplicateID test Completed");

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
