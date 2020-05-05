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
import io.smartnexus.ats.utils.Constants;
import io.smartnexus.ats.utils.ExtentManager;
import io.smartnexus.ats.utils.NorthBoundInterface;

public class ConfigurePeripheralSettings {
  private static final Logger log = Logger.getLogger(ConfigurePeripheralSettings.class.getName());
  ExtentTest logger;
  ExtentReports extent;
  private NorthBoundInterface nbi;
  private String productMasterID;

  // LoginAs Administrator
  @BeforeClass
  public void setUp() throws Exception {
    extent = ExtentManager.getInstance();
    nbi = new NorthBoundInterface();
    productMasterID = AddProductMaster.productMasterId;
  }

  /*
   * ADD BOOLEAN SETTINGS FOR DROPDOWN API TEST
   */
  @Test(priority = 1, enabled = true)
  public void TEST_458_addPeripheralSettingDropDownBoolean() throws Exception {
    logger = extent.startTest(this.getClass().getSimpleName());
    nbi.addPeripheralSetting(productMasterID, 1, "Boolean", Constants.DROPDOWN);
    Assert.assertTrue(nbi.verifyPeripheralSettings(productMasterID, 1));
    logger.log(LogStatus.PASS, "addPeripheralSettingDropDownBoolean test Completed");
    log.debug("addPeripheralSettingDropDownBoolean test Completed");

  }

  /*
   * ADD INT SETTINGS FOR DROPDOWN API TEST
   */
  @Test(priority = 2, enabled = true)
  public void TEST_459_addPeripheralSettingDropDownInt() {
    logger = extent.startTest(this.getClass().getSimpleName());
    nbi.addPeripheralSetting(productMasterID, 2, "Int", Constants.DROPDOWN);
    Assert.assertTrue(nbi.verifyPeripheralSettings(productMasterID, 2));
    logger.log(LogStatus.PASS, "addIntSettingDropDownCfgInt test Completed");
    log.debug("addIntSettingDropDownCfgInt test Completed");

  }
  

  /*
   * ADD BYTE SETTINGS FOR DROPDOWN API TEST
   */
  @Test(priority = 3, enabled = true)
  public void TEST_462_addPeripheralSettingDropDownByte() {
    logger = extent.startTest(this.getClass().getSimpleName());
    nbi.addPeripheralSetting(productMasterID, 3, "Byte", Constants.DROPDOWN);
    Assert.assertTrue(nbi.verifyPeripheralSettings(productMasterID, 3));
    logger.log(LogStatus.PASS, "addPeripheralSettingDropDownByte test Completed");
    log.debug("addPeripheralSettingDropDownByte test Completed");

  }


  /*
   * ADD DECIMAL SETTINGS FOR DROPDOWN API TEST
   */
  @Test(priority = 4, enabled = true)
  public void TEST_460_addPeripheralSettingDropDownDecimal() {
    logger = extent.startTest(this.getClass().getSimpleName());
    nbi.addPeripheralSetting(productMasterID, 4, "Decimal", Constants.DROPDOWN);
    Assert.assertTrue(nbi.verifyPeripheralSettings(productMasterID, 4));
    logger.log(LogStatus.PASS, "addPeripheralSettingDropDownDecimal test Completed");
    log.debug("addPeripheralSettingDropDownDecimal test Completed");

  }

 
  /*
   * ADD BIGINT SETTINGS FOR DROPDOWN API TEST
   */
  @Test(priority = 5, enabled = true)
  public void TEST_463_addPeripheralSettingDropDownBigInt() {
    logger = extent.startTest(this.getClass().getSimpleName());
    nbi.addPeripheralSetting(productMasterID, 5, "BigInt", Constants.DROPDOWN);
    Assert.assertTrue(nbi.verifyPeripheralSettings(productMasterID, 5));
    logger.log(LogStatus.PASS, "addPeripheralSettingDropDownBigInt test Completed");
    log.debug("addPeripheralSettingDropDownBigInt test Completed");

  }

  /*
   * ADD STRING SETTINGS FOR DROPDOWN API Test
   */
  @Test(priority = 6, enabled = true)
  public void TEST_465_addPeripheralSettingDropDownString() {
    logger = extent.startTest(this.getClass().getSimpleName());
    nbi.addPeripheralSetting(productMasterID, 6, "String", Constants.DROPDOWN);
    Assert.assertTrue(nbi.verifyPeripheralSettings(productMasterID, 6));
    logger.log(LogStatus.PASS, "addSettingDropDownString test Completed");
    log.debug("addSettingDropDownString test Completed");

  }
  
  /*
   * ADD FLOAT SETTINGS FOR DROPDOWN API TEST
   */
  @Test(priority = 7, enabled = true)
  public void TEST_464_addPeripheralSettingDropDownFloat() {
    logger = extent.startTest(this.getClass().getSimpleName());
    nbi.addPeripheralSetting(productMasterID, 7, "Float", Constants.DROPDOWN);
    Assert.assertTrue(nbi.verifyPeripheralSettings(productMasterID, 7));
    logger.log(LogStatus.PASS, "addSettingDropDown test Completed");
    log.debug("addSettingDropDown test Completed");

  }

 

  /*
   * ADD DOUBLE SETTINGS FOR DROPDOWN API TEST
   */
  @Test(priority = 8, enabled = true)
  public void TEST_461_addPeripheralSettingDropDownDouble() {
    logger = extent.startTest(this.getClass().getSimpleName());
    nbi.addPeripheralSetting(productMasterID, 8, "Double", Constants.DROPDOWN);
    Assert.assertTrue(nbi.verifyPeripheralSettings(productMasterID, 8));
    logger.log(LogStatus.PASS, "addPeripheralSettingDropDownDouble test Completed");
    log.debug("addPeripheralSettingDropDownDouble test Completed");

  }

  
  /*
   * ADD LDOUBLE SETTINGS FOR DROPDOWN API TEST
   */
  @Test(priority = 9, enabled = true)
  public void TEST_466_addPeripheralSettingLdoubleJson() {
    logger = extent.startTest(this.getClass().getSimpleName());
    nbi.addPeripheralSetting(productMasterID, 9, "LDouble", Constants.DROPDOWN);
    Assert.assertTrue(nbi.verifyPeripheralSettings(productMasterID, 9));
    logger.log(LogStatus.PASS, "addPeripheralSettingDropDownJson test Completed");
    log.debug("addPeripheralSettingDropDownJson test Completed");

  }

  /*
   * ADD Json SETTINGS FOR DROPDOWN API TEST
   */
  @Test(priority = 10, enabled = true)
  public void TEST_956_addPeripheralSettingDropDownJson() {
    logger = extent.startTest(this.getClass().getSimpleName());
    nbi.addPeripheralSetting(productMasterID, 10, "Json", Constants.DROPDOWN);
    Assert.assertTrue(nbi.verifyPeripheralSettings(productMasterID, 10));
    logger.log(LogStatus.PASS, "addPeripheralSettingDropDownJson test Completed");
    log.debug("addPeripheralSettingDropDownJson test Completed");

  }

  /*
   * ADD String SETTINGS FOR Text API TEST
   */
  @Test(priority = 11, enabled = true)
  public void TEST_482_addPeripheralSettingTextString() {
    logger = extent.startTest(this.getClass().getSimpleName());
    String response = nbi.addPeripheralSetting(productMasterID, 11, "String", Constants.TEXT);
    String[] s1 = response.split(",");
    int status = Integer.parseInt(s1[0]);
    Assert.assertTrue(200 <= status & status <= 205);
    logger.log(LogStatus.PASS, "addPeripheralSettingTextString test Completed");
    log.debug("addPeripheralSettingTextString test Completed");

  }

  /*
   * ADD String SETTINGS FOR Text API TEST
   */
  @Test(priority = 12, enabled = true)
  public void TEST_484_addPeripheralSettingCheckBox() {
    logger = extent.startTest(this.getClass().getSimpleName());
    String response = nbi.addPeripheralSetting(productMasterID, 12, "Boolean", Constants.CHECKBOX);
    String[] s1 = response.split(",");
    int status = Integer.parseInt(s1[0]);
    Assert.assertTrue(200 <= status & status <= 205);
    logger.log(LogStatus.PASS, "addPeripheralSettingCheckBox test Completed");
    log.debug("addPeripheralSettingCheckBox test Completed");

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
