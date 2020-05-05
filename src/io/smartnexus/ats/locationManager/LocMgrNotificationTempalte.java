package io.smartnexus.ats.locationManager;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.gson.JsonSyntaxException;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.smartnexus.ats.configure.product.AddProductMaster;
import io.smartnexus.ats.tenant.AddTenant;
import io.smartnexus.ats.utils.Constants;
import io.smartnexus.ats.utils.ExtentManager;
import io.smartnexus.ats.utils.NorthBoundInterface;
import io.smartnexus.ats.utils.TestNgParameters;

public class LocMgrNotificationTempalte {

  private static final Logger log = Logger.getLogger(LocMgrNotificationTempalte.class.getName());
  private TestNgParameters testNg = new TestNgParameters();
  ExtentTest logger;
  ExtentReports extent;
  private NorthBoundInterface nbi;
  private String outPutType;
  private String priority;
  public String SKUID;
  public String CUID;
  public String ephemerisDataEnabled;
  public String ephemerisDataDeliveryInterval;
  public String ephemerisOnlineURL;
  public String ephemerisOfflineURL;
  public String indoorLocationEnabled;
  private static String mqttTopic;

  // LoginAs Administrator
  @BeforeClass

  public void setUp() throws Exception {
    extent = ExtentManager.getInstance();
    nbi = new NorthBoundInterface();
    SKUID = AddProductMaster.productMasterSku;
    ephemerisDataEnabled = LocMgrSettingsTemplate.ephemerisDataEnabled;
    ephemerisDataDeliveryInterval = LocMgrSettingsTemplate.ephemerisDataDeliveryInterval;
    ephemerisOnlineURL = LocMgrSettingsTemplate.ephemerisOnlineURL;
    ephemerisOfflineURL = LocMgrSettingsTemplate.ephemerisOfflineURL;
    indoorLocationEnabled = LocMgrSettingsTemplate.indoorLocationEnabled;
    CUID = AddTenant.tenantCuid;
    // mqttTopic = testNg.getMqttTopic();
    outPutType = "1";
    priority = "Low";
  }

  @Test(priority = 1, enabled = true)
  public void TEST_753_addUserPreference() throws JsonSyntaxException, Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    int status = nbi.setUserPreference(CUID, testNg.getUserName(), testNg.getLocmger(), "0", mqttTopic);
    Assert.assertTrue(200 <= status & status <= 205);
    logger.log(LogStatus.PASS, "addUserPreference test Completed");
    log.debug("addUserPreference test Completed");

  }

  @Test(priority = 2, enabled = true)
  public void TEST_920_A_addEphemerisDataEnabledNotificationTemplate() throws Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
    nbi.addTemplate(CUID, SKUID, ephemerisDataEnabled, 5, Constants.dataEnabled, 29, "", priority, outPutType);
    int status = nbi.subscribeTemplate(SKUID, CUID, 5);
    Assert.assertTrue(200 <= status & status <= 205);
    logger.log(LogStatus.PASS, "add NotificationTemplate Alert is Completed");
    log.debug("add NotificationTemplate alert test is Completed");

  }

  @Test(priority = 3, enabled = true)
  public void TEST_920_B_addEphemerisDataDeliveryIntervalNotificationTemplate() throws Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
    nbi.addTemplate(CUID, SKUID, ephemerisDataDeliveryInterval, 5, Constants.dataDeliveryInterval, 29, "", priority, outPutType);
    int status = nbi.subscribeTemplate(SKUID, CUID, 5);
    Assert.assertTrue(200 <= status & status <= 205);
    logger.log(LogStatus.PASS, "add NotificationTemplate Alert is Completed");
    log.debug("add NotificationTemplate alert test is Completed");

  }

  @Test(priority = 3, enabled = false)
  public void TEST_920_D_addEphemerisOfflineURLNotificationTemplate() throws Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
    nbi.addTemplate(CUID, SKUID, ephemerisOfflineURL, 5, Constants.isOffline, 29, "", priority, outPutType);
    int status = nbi.subscribeTemplate(SKUID, CUID, 5);
    Assert.assertTrue(200 <= status & status <= 205);
    logger.log(LogStatus.PASS, "add NotificationTemplate Alert is Completed");
    log.debug("add NotificationTemplate alert test is Completed");

  }

  @Test(priority = 4, enabled = false)
  public void TEST_920_C_addEphemerisOnlineURLNotificationTemplate() throws Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
    nbi.addTemplate(CUID, SKUID, ephemerisOnlineURL, 5, Constants.isOnline, 29, "", priority, outPutType);
    int status = nbi.subscribeTemplate(SKUID, CUID, 5);
    Assert.assertTrue(200 <= status & status <= 205);
    logger.log(LogStatus.PASS, "add NotificationTemplate Alert is Completed");
    log.debug("add NotificationTemplate alert test is Completed");

  }

  @Test(priority = 5, enabled = true)
  public void TEST_920_E_addIndoorLocationEnabledNotificationTemplate() throws Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
    nbi.addTemplate(CUID, SKUID, indoorLocationEnabled, 5, Constants.indoorLocation, 29, "", priority, outPutType);
    int status = nbi.subscribeTemplate(SKUID, CUID, 5);
    Assert.assertTrue(200 <= status & status <= 205);
    logger.log(LogStatus.PASS, "add NotificationTemplate Alert is Completed");
    log.debug("add NotificationTemplate alert test is Completed");

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