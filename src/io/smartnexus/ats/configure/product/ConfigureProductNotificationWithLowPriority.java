package io.smartnexus.ats.configure.product;

import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.google.gson.JsonSyntaxException;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.smartnexus.ats.tenant.AddTenant;
import io.smartnexus.ats.utils.CommonUtils;
import io.smartnexus.ats.utils.Constants;
import io.smartnexus.ats.utils.ExtentManager;
import io.smartnexus.ats.utils.NorthBoundInterface;
import io.smartnexus.ats.utils.TestNgParameters;
import junit.framework.Assert;

public class ConfigureProductNotificationWithLowPriority {
  private TestNgParameters testNg = new TestNgParameters();
  private static final Logger log = Logger.getLogger(ConfigureProductNotificationWithLowPriority.class.getName());
  ExtentTest logger;
  ExtentReports extent;
  private NorthBoundInterface nbi;
  public String SKUID, webHookURL, authUri, CUID, outPutType, priority, productMasterID;
  static CommonUtils cu = new CommonUtils();

  @BeforeClass
  public void setUp() throws Exception {
    extent = ExtentManager.getInstance();
    nbi = new NorthBoundInterface();
    SKUID = AddProductMaster.productMasterSku;
    CUID = AddTenant.tenantCuid;
    productMasterID = AddProductMaster.productMasterId;
    webHookURL = Constants.WEBHOOK_SERVER;
    outPutType = "1";
    priority = "Low";
  }

  /**
   * Add Preference/
   * 
   * @throws Exception
   * @throws JsonSyntaxException
   */

  @Test(priority = 1, enabled = true)
  public void TEST_753_addUserPreference() {
    logger = extent.startTest(this.getClass().getSimpleName());
    int status = nbi.setUserPreference(CUID, testNg.getUserName(), webHookURL, "0", authUri);
    Assert.assertTrue(200 <= status & status <= 205);
    logger.log(LogStatus.PASS, "addUserPreference test Completed");
    log.debug("addUserPreference test Completed");

  }

  // Add template for Change Attribute Definition
  @Test(priority = 2, enabled = false)
  public void TEST_77_addTemplateChangeAttributeDefinition() {
    logger = extent.startTest(this.getClass().getSimpleName());
    nbi.addTemplate(CUID, SKUID, "Change Attribute Definition", 5, 10, 20, "", priority, outPutType);
    int status = nbi.subscribeTemplate(SKUID, CUID, 5);
    Assert.assertTrue(200 <= status & status <= 205);
    int statusNew = nbi.subscribeTemplate(SKUID, CUID, 1);
    Assert.assertTrue(200 <= statusNew & statusNew <= 205);
    logger.log(LogStatus.PASS, "addTemplateChangeAttributeDefinition test Completed");
    log.debug("addTemplateChangeAttributeDefinition test Completed");

  }

  // Add template for Change Setting Definition
  @Test(priority = 3, enabled = false)
  public void TEST_351_addTemplateChangeSettingDefinition() {
    logger = extent.startTest(this.getClass().getSimpleName());
    nbi.addTemplate(CUID, SKUID, "Change Setting Definition", 5, 1, 21, "", priority, outPutType);
    int status = nbi.subscribeTemplate(SKUID, CUID, 5);
    Assert.assertTrue(200 <= status & status <= 205);
    int statusNew = nbi.subscribeTemplate(SKUID, CUID, 1);
    Assert.assertTrue(200 <= statusNew & statusNew <= 205);
    logger.log(LogStatus.PASS, "addTemplateChangeSettingDefinition test Completed");
    log.debug("addTemplateChangeSettingDefinition test Completed");

  }

  // Add template for Change Command Definition
  @Test(priority = 4, enabled = false)
  public void TEST_347_addTemplateChangeCommandDefinition() {
    logger = extent.startTest(this.getClass().getSimpleName());
    nbi.addTemplate(CUID, SKUID, "Change Command Definition", 5, 1, 19, "", priority, outPutType);
    int status = nbi.subscribeTemplate(SKUID, CUID, 5);
    Assert.assertTrue(200 <= status & status <= 205);
    int statusNew = nbi.subscribeTemplate(SKUID, CUID, 1);
    Assert.assertTrue(200 <= statusNew & statusNew <= 205);
    logger.log(LogStatus.PASS, "addTemplateChangeCommandDefinition test Completed");
    log.debug("addTemplateChangeCommandDefinition test Completed");

  }

  // Add template for Change Command Definition
  @Test(priority = 5, enabled = false)
  public void TEST_348_addTemplateChangeCustomFieldDefinition() {
    logger = extent.startTest(this.getClass().getSimpleName());
    nbi.addTemplate(CUID, SKUID, "Change Cuctom Field Definition", 5, 1, 23, "", priority, outPutType);
    int status = nbi.subscribeTemplate(SKUID, CUID, 5);
    Assert.assertTrue(200 <= status & status <= 205);
    int statusNew = nbi.subscribeTemplate(SKUID, CUID, 1);
    Assert.assertTrue(200 <= statusNew & statusNew <= 205);
    logger.log(LogStatus.PASS, "addTemplateChangeCustomFieldDefinition test Completed");
    log.debug("addTemplateChangeCustomFieldDefinition test Completed");

  }

  // Add template for Activate Product
  @Test(priority = 6, enabled = true)
  public void TEST_339_addTemplateActivateProduct() {
    logger = extent.startTest(this.getClass().getSimpleName());
    nbi.addTemplate(CUID, SKUID, "Device Activated", 5, 1, 7, "", priority, outPutType);
    int status = nbi.subscribeTemplate(SKUID, CUID, 5);
    Assert.assertTrue(200 <= status & status <= 205);
    int statusNew = nbi.subscribeTemplate(SKUID, CUID, 1);
    Assert.assertTrue(200 <= statusNew & statusNew <= 205);
    logger.log(LogStatus.PASS, "addTemplateActivateProduct test Completed");
    log.debug("addTemplateActivateProduct test Completed");

  }

  // Add template for Activate Dy
  @Test(priority = 7, enabled = false)
  public void TEST_338_addTemplateActivatePeripheral() {
    logger = extent.startTest(this.getClass().getSimpleName());
    nbi.addTemplate(CUID, SKUID, "Activate Peripheral", 5, 1, 12, "", priority, outPutType);
    int status = nbi.subscribeTemplate(SKUID, CUID, 5);
    Assert.assertTrue(200 <= status & status <= 205);
    int statusNew = nbi.subscribeTemplate(SKUID, CUID, 1);
    Assert.assertTrue(200 <= statusNew & statusNew <= 205);
    logger.log(LogStatus.PASS, "addTemplateActivatePeripheral test Completed");
    log.debug("addTemplateActivatePeripheral test Completed");

  }

  // Add template for Deactivate Product
  @Test(priority = 8, enabled = false)
  public void TEST_340_addTemplateDeactivateProduct() {
    logger = extent.startTest(this.getClass().getSimpleName());
    nbi.addTemplate(CUID, SKUID, "Deactivate Product", 5, 1, 13, "", priority, outPutType);
    int status = nbi.subscribeTemplate(SKUID, CUID, 5);
    Assert.assertTrue(200 <= status & status <= 205);
    int statusNew = nbi.subscribeTemplate(SKUID, CUID, 1);
    Assert.assertTrue(200 <= statusNew & statusNew <= 205);
    logger.log(LogStatus.PASS, "addTemplateDeactivateProduct test Completed");
    log.debug("addTemplateDeactivateProduct test Completed");

  }

  @Test(priority = 9, enabled = false)
  public void TEST_345_addTemplateSendCommand() {
    logger = extent.startTest(this.getClass().getSimpleName());
    nbi.addTemplate(CUID, SKUID, "Send Command", 5, 1, 22, "", priority, outPutType);
    int status = nbi.subscribeTemplate(SKUID, CUID, 5);
    Assert.assertTrue(200 <= status & status <= 205);
    int statusNew = nbi.subscribeTemplate(SKUID, CUID, 1);
    Assert.assertTrue(200 <= statusNew & statusNew <= 205);
    logger.log(LogStatus.PASS, "addTemplateSendCommand test Completed");
    log.debug("addTemplateSendCommand test Completed");

  }

  // Add template for Delete Peripheral
  @Test(priority = 10, enabled = false)
  public void TEST_337_addTemplateDeletePeripheral() {
    logger = extent.startTest(this.getClass().getSimpleName());
    nbi.addTemplate(CUID, SKUID, "Delete Peripheral", 5, 1, 14, "", priority, outPutType);
    int status = nbi.subscribeTemplate(SKUID, CUID, 5);
    Assert.assertTrue(200 <= status & status <= 205);
    int statusNew = nbi.subscribeTemplate(SKUID, CUID, 1);
    Assert.assertTrue(200 <= statusNew & statusNew <= 205);
    logger.log(LogStatus.PASS, "addTemplateDeletePeripheral test Completed");
    log.debug("addTemplateDeletePeripheral test Completed");

  }

  // Add template for Change Attribute Value
  @Test(priority = 11, enabled = true)
  public void TEST_349_addTemplateChangeAttributeValue() {
    logger = extent.startTest(this.getClass().getSimpleName());
    nbi.addTemplate(CUID, SKUID, "Attribute Value Update", 5, 10, 28, "", priority, outPutType);
    int status = nbi.subscribeTemplate(SKUID, CUID, 5);
    Assert.assertTrue(200 <= status & status <= 205);
    int statusNew = nbi.subscribeTemplate(SKUID, CUID, 1);
    Assert.assertTrue(200 <= statusNew & statusNew <= 205);
    logger.log(LogStatus.PASS, "addTemplateChangeAttributeValue test Completed");
    log.debug("addTemplateChangeAttributeValue test Completed");

  }

  // Add template for ChangeSettingValue
  @Test(priority = 12, enabled = true)
  public void TEST_346_addTemplateChangeSettingValue() {
    logger = extent.startTest(this.getClass().getSimpleName());
    nbi.addTemplate(CUID, SKUID, "Setting Value Update", 5, 6, 29, "", priority, outPutType);
    int status = nbi.subscribeTemplate(SKUID, CUID, 5);
    Assert.assertTrue(200 <= status & status <= 205);
    int statusNew = nbi.subscribeTemplate(SKUID, CUID, 1);
    Assert.assertTrue(200 <= statusNew & statusNew <= 205);
    logger.log(LogStatus.PASS, "addTemplateChangeSettingValue test Completed");
    log.debug("addTemplateChangeSettingValue test Completed");

  }

  // Add template for Update Peripheral
  @Test(priority = 13, enabled = false)
  public void TEST_350_addTemplateUpdatePeripheral() {
    logger = extent.startTest(this.getClass().getSimpleName());
    nbi.addTemplate(CUID, SKUID, "Update Peripheral", 5, 1, 12, "", priority, outPutType);
    int status = nbi.subscribeTemplate(SKUID, CUID, 5);
    Assert.assertTrue(200 <= status & status <= 205);
    int statusNew = nbi.subscribeTemplate(SKUID, CUID, 1);
    Assert.assertTrue(200 <= statusNew & statusNew <= 205);
    logger.log(LogStatus.PASS, "addTemplateUpdatePeripheral test Completed");
    log.debug("addTemplateUpdatePeripheral test Completed");

  }

  // add Template for Update Peripheral Custom Field Value
  @Test(priority = 14, enabled = false)
  public void TEST_354_addTemplateUpdatePeripheralCustomFieldValue() {
    logger = extent.startTest(this.getClass().getSimpleName());
    nbi.addTemplate(CUID, SKUID, "Update Peripheral Custom Field Value", 5, 1, 27, "", priority, outPutType);
    int status = nbi.subscribeTemplate(SKUID, CUID, 5);
    Assert.assertTrue(200 <= status & status <= 205);
    int statusNew = nbi.subscribeTemplate(SKUID, CUID, 1);
    Assert.assertTrue(200 <= statusNew & statusNew <= 205);
    logger.log(LogStatus.PASS, "addTemplateUpdatePeripheralCustomFieldValue test Completed");
    log.debug("addTemplateUpdatePeripheralCustomFieldValue test Completed");

  }

  // add Template for Update Group Custom Field Value
  @Test(priority = 15, enabled = false)
  public void TEST_356_addTemplateUpdateGroupCustomFieldValue() {
    logger = extent.startTest(this.getClass().getSimpleName());
    nbi.addTemplate(CUID, SKUID, "Update Group Custom Field Value", 5, 1, 24, "", priority, outPutType);
    int status = nbi.subscribeTemplate(SKUID, CUID, 5);
    Assert.assertTrue(200 <= status & status <= 205);
    int statusNew = nbi.subscribeTemplate(SKUID, CUID, 1);
    Assert.assertTrue(200 <= statusNew & statusNew <= 205);
    logger.log(LogStatus.PASS, "addTemplateUpdateGroupCustomFieldValue test Completed");
    log.debug("addTemplateUpdateGroupCustomFieldValue test Completed");

  }

  // add Template for Update Group Data
  @Test(priority = 16, enabled = false)
  public void TEST_355_addTemplateUpdateGroupData() {
    logger = extent.startTest(this.getClass().getSimpleName());
    nbi.addTemplate(CUID, SKUID, "Update Group Data", 5, 1, 32, "", priority, outPutType);
    int status = nbi.subscribeTemplate(SKUID, CUID, 5);
    Assert.assertTrue(200 <= status & status <= 205);
    int statusNew = nbi.subscribeTemplate(SKUID, CUID, 1);
    Assert.assertTrue(200 <= statusNew & statusNew <= 205);
    logger.log(LogStatus.PASS, "addTemplateUpdateGroupData test Completed");
    log.debug("addTemplateUpdateGroupData test Completed");

  }

  // Add Template for Update Product Custom Field Value

  @Test(priority = 17, enabled = false)
  public void TEST_352_addTemplateUpdateProductCustomFieldValue() {
    logger = extent.startTest(this.getClass().getSimpleName());
    nbi.addTemplate(CUID, SKUID, "Update Product Custom Field Value", 5, 1, 26, "", priority, outPutType);
    int status = nbi.subscribeTemplate(SKUID, CUID, 5);
    Assert.assertTrue(200 <= status & status <= 205);
    int statusNew = nbi.subscribeTemplate(SKUID, CUID, 1);
    Assert.assertTrue(200 <= statusNew & statusNew <= 205);
    logger.log(LogStatus.PASS, "addTemplateUpdateProductCustomFieldValue test Completed");
    log.debug("addTemplateUpdateProductCustomFieldValue test Completed");

  }

  // Add Template for Update Productline Custom Field Value

  @Test(priority = 18, enabled = false)
  public void TEST_353_addTemplateUpdateProductlineCustomFieldValue() {
    logger = extent.startTest(this.getClass().getSimpleName());
    nbi.addTemplate(CUID, SKUID, "Update Productline Custom Field Value", 5, 1, 25, "", priority, outPutType);
    int status = nbi.subscribeTemplate(SKUID, CUID, 5);
    Assert.assertTrue(200 <= status & status <= 205);
    int statusNew = nbi.subscribeTemplate(SKUID, CUID, 1);
    Assert.assertTrue(200 <= statusNew & statusNew <= 205);
    logger.log(LogStatus.PASS, "addTemplateUpdateProductlineCustomFieldValue test Completed");
    log.debug("addTemplateUpdateProductlineCustomFieldValue test Completed");

  }

  // Add Template for User Activity

  @Test(priority = 19, enabled = false)
  public void TEST_341_addTemplateUserActivity() {
    logger = extent.startTest(this.getClass().getSimpleName());
    nbi.addTemplate(CUID, SKUID, "User Activity", 5, 1, 30, "", priority, outPutType);
    int status = nbi.subscribeTemplate(SKUID, CUID, 5);
    Assert.assertTrue(200 <= status & status <= 205);
    int statusNew = nbi.subscribeTemplate(SKUID, CUID, 1);
    Assert.assertTrue(200 <= statusNew & statusNew <= 205);
    logger.log(LogStatus.PASS, "addTemplateUserActivity test Completed");
    log.debug("addTemplateUserActivity test Completed");

  }

  // Add Template for Geofence

  @Test(priority = 20, enabled = false)
  public void TEST_940_addGeofenceBoundaryViolation() {
    logger = extent.startTest(this.getClass().getSimpleName());
    nbi.addTemplate(CUID, SKUID, "Geofence Boundary Violation", 5, 1, 35, "", priority, outPutType);
    int status = nbi.subscribeTemplate(SKUID, CUID, 5);
    Assert.assertTrue(200 <= status & status <= 205);
    int statusNew = nbi.subscribeTemplate(SKUID, CUID, 1);
    Assert.assertTrue(200 <= statusNew & statusNew <= 205);
    logger.log(LogStatus.PASS, "addGeofenceBoundaryViolation test Completed");
    log.debug("addGeofenceBoundaryViolation test Completed");
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
