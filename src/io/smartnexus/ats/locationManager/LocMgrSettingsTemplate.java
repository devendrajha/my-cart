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
import io.smartnexus.ats.utils.Constants;
import io.smartnexus.ats.utils.ExtentManager;
import io.smartnexus.ats.utils.NorthBoundInterface;
import io.smartnexus.ats.utils.TestNgParameters;

public class LocMgrSettingsTemplate {

  private static final Logger log = Logger.getLogger(LocMgrSettingsTemplate.class.getName());
  ExtentTest logger;
  ExtentReports extent;
  private TestNgParameters testNg = new TestNgParameters();
  private String productLineID;
  public String SKUID;
  public static String staticSettingNameInt = null;
  private NorthBoundInterface nbi;
  public static final String ephemerisDataEnabled = "EphemerisDataEnabled";
  public static final String ephemerisDataDeliveryInterval = "EphemerisDataDeliveryInterval";
  public static final String ephemerisOnlineURL = "EphemerisOnlineURL";
  public static final String ephemerisOfflineURL = "EphemerisOfflineURL ";
  public static final String indoorLocationEnabled = "IndoorLocationEnabled";
  public static final String isGroupEphemeris = "Ephemeris";
  public static final String isGroupLocation = "Location";
  private String webHookURL;

  // LoginAs Administrator
  @BeforeClass

  public void setUp() throws Exception {
    extent = ExtentManager.getInstance();
    nbi = new NorthBoundInterface();
    SKUID = AddProductMaster.productMasterSku;
    productLineID = AddProductMaster.productMasterId;
    webHookURL = testNg.getWebhookEndPoint();
  }

  /*
   * ADD Boolean SETTINGS FOR EphemerisDataEnabled
   */
  @Test(priority = 1, enabled = true)
  public void TEST_919_addSettingsEphemerisDataEnabled() throws IOException, InterruptedException, Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    int status = nbi.addLocationManagersetting(productLineID, ephemerisDataEnabled, isGroupEphemeris, Constants.dataEnabled, "Boolean", Constants.CHECKBOX, "1");
    Assert.assertTrue(200 <= status & status <= 205);
    logger.log(LogStatus.PASS, "addSettingsEphemerisDataEnabled test Completed");
    log.debug("addSettingsEphemerisDataEnabled test Completed");

  }

  /*
   * ADD Boolean SETTINGS FOR IndoorLocationEnabled
   */
  @Test(priority = 2, enabled = true)
  public void TEST_919_addSettingsIndoorLocationEnabled() throws IOException, InterruptedException, Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    int status = nbi.addLocationManagersetting(productLineID, indoorLocationEnabled, isGroupLocation, Constants.indoorLocation, "Boolean", Constants.CHECKBOX, "1");
    Assert.assertTrue(200 <= status & status <= 205);
    logger.log(LogStatus.PASS, "addSettingsIndoorLocationEnabled test Completed");
    log.debug("addSettingsIndoorLocationEnabled test Completed");

  }

  /*
   * ADD Boolean SETTINGS FOR EphemerisDataDeliveryInterval
   */
  @Test(priority = 3, enabled = true)
  public void TEST_919_addSettingsEphemerisDataDeliveryInterval() throws IOException, InterruptedException, Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    int status = nbi.addLocationManagersetting(productLineID, ephemerisDataDeliveryInterval, isGroupEphemeris, Constants.dataDeliveryInterval, "Int", Constants.TEXT, "1");
    Assert.assertTrue(200 <= status & status <= 205);
    logger.log(LogStatus.PASS, "addSettingsEphemerisDataDeliveryInterval test Completed");
    log.debug("addSettingsEphemerisDataDeliveryInterval test Completed");

  }

  /*
   * ADD Boolean SETTINGS FOR EphemerisOnlineURL
   */
  @Test(priority = 4, enabled = true)
  public void TEST_919_addSettingsEphemerisOnlineURL() throws IOException, InterruptedException, Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    int status = nbi.addLocationManagersetting(productLineID, ephemerisOnlineURL, isGroupLocation, Constants.isOnline, "String", Constants.TEXT, "");
    Assert.assertTrue(200 <= status & status <= 205);
    logger.log(LogStatus.PASS, "addSettingsEphemerisOnlineURL test Completed");
    log.debug("addSettingsEphemerisOnlineURL test Completed");

  }

  /*
   * ADD Boolean SETTINGS FOR EphemerisOnlineURL
   */
  @Test(priority = 5, enabled = true)
  public void TEST_919_addSettingsEphemerisOfflineURL() throws IOException, InterruptedException, Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    int status = nbi.addLocationManagersetting(productLineID, ephemerisOfflineURL, isGroupLocation, Constants.isOffline, "String", Constants.TEXT, "");
    Assert.assertTrue(200 <= status & status <= 205);
    logger.log(LogStatus.PASS, "addSettingsEphemerisOfflineURL test Completed");
    log.debug("addSettingsEphemerisOfflineURL test Completed");

  }

  /*
   * ADD Boolean SETTINGS FOR EphemerisOnlineURL
   */
  @Test(priority = 6, enabled = true)
  public void TEST_288_addSettingForWebHook() throws IOException, InterruptedException, Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    int status = nbi.addLocationManagersetting(productLineID, "WebhookUrl", "WebHook", Constants.webHookUrl, "String", Constants.TEXT, webHookURL);
    Assert.assertTrue(200 <= status & status <= 205);
    logger.log(LogStatus.PASS, "addSettingsEphemerisOfflineURL test Completed");
    log.debug("addSettingsEphemerisOfflineURL test Completed");

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
