package io.smartnexus.ats.dts;

import java.io.IOException;
import java.util.Set;

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
import io.smartnexus.ats.product.ProductUpdateAttributesValue;
import io.smartnexus.ats.tenant.AddTenant;
import io.smartnexus.ats.thrift.AgentClient;
import io.smartnexus.ats.thrift.AgentService;
import io.smartnexus.ats.utils.ExtentManager;
import io.smartnexus.ats.utils.NorthBoundInterface;

public class UnitConversionDTS {

  private static final Logger log = Logger.getLogger(UnitConversionDTS.class.getName());
  ExtentTest logger;
  ExtentReports extent;
  private RestTemplateDTS restTemplateDTS;
  public String cuid, skuid, deviceId, transformationId;
  public static AgentService.Client client;
  AgentClient agentClient = new AgentClient();
  public int attrLocalId, staticEpLocalId;
  public NorthBoundInterface nbi;

  @BeforeClass

  public void setUp() throws Exception {
    extent = ExtentManager.getInstance();
    restTemplateDTS = new RestTemplateDTS();
    cuid = AddTenant.tenantCuid;
    cuid = AddTenant.tenantCuid;
    skuid = AddProductMaster.productMasterSku;
    client = ProductUpdateAttributesValue.client;
    nbi = new NorthBoundInterface();
    deviceId = ProductUpdateAttributesValue.deviceId;
    attrLocalId = 10;
    staticEpLocalId = 0;
  }

  // ADD String addUnitConversionTransformation

  @Test(priority = 1, enabled = true)
  public void TEST_965_A_addMetersToFeetUnitConversion() throws IOException, InterruptedException, Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    String response = restTemplateDTS.addUnitConversionTransformation(cuid, skuid, "MetersToFeet", attrLocalId, "1");
    String[] s1 = response.split(",");
    int status = Integer.parseInt(s1[0]);
    transformationId = s1[1];
    Assert.assertTrue(200 <= status & status <= 205);
    logger.log(LogStatus.PASS, "addUnitConversionTransformation test Completed");
    log.debug("addUnitConversionTransformation test Completed");

  }

  @Test(priority = 2, enabled = true)
  public void TEST_965_verifyMetersToFeetUnitConversion() throws Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    String value = "{\"MetersToFeet\": 1}";
    String response = agentClient.sendAttrValueForJsonDataType(client, staticEpLocalId, attrLocalId, value,0);
    Set<Object> notificationResponse = nbi.getDTSWebhookNotification(cuid);
    Assert.assertTrue(notificationResponse.toString().contains("{MetersToFeet=3.280839895013123}"));
    logger.log(LogStatus.PASS, "Executing verifyMetersToFeetUnitConversion test Completed");
    log.debug("Executing verifyMetersToFeetUnitConversion");

  }

  @Test(priority = 3, enabled = true)
  public void TEST_973_deleteMetersToFeetUnitConversion() throws IOException, InterruptedException, Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    int status = restTemplateDTS.deletePropertyTransformation(cuid, transformationId);
    Assert.assertTrue(200 <= status & status <= 205);
    logger.log(LogStatus.PASS, "deleteMetersToFeetUnitConversion test Completed");
    log.debug("deleteMetersToFeetUnitConversion test Completed");

  }

  /* ADD String addUnitConversionTransformation */

  @Test(priority = 4, enabled = true)
  public void TEST_965_B_addFeetToMeterUnitConversion() throws IOException, InterruptedException, Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    String response = restTemplateDTS.addUnitConversionTransformation(cuid, skuid, "FeetToMeters", attrLocalId, "2");
    String[] s1 = response.split(",");
    int status = Integer.parseInt(s1[0]);
    transformationId = s1[1];
    Assert.assertTrue(200 <= status & status <= 205);
    logger.log(LogStatus.PASS, "addFeetToMeterUnitConversion test Completed");
    log.debug("addFeetToMeterUnitConversion test Completed");

  }

  @Test(priority = 5, enabled = true)
  public void TEST_965_verifyFeetToMeterUnitConversion() throws Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    String value = "{\"FeetToMeters\": 11}";
    String response = agentClient.sendAttrValueForJsonDataType(client, staticEpLocalId, attrLocalId, value,0);
    Set<Object> notificationResponse = nbi.getDTSWebhookNotification(cuid);
    Assert.assertTrue(notificationResponse.toString().contains("{FeetToMeters=3.3528000000000002}"));
    logger.log(LogStatus.PASS, "Executing verifyFeetToMeterUnitConversiontest Completed");
    log.debug("Executing verifyFeetToMeterUnitConversion");

  }

  @Test(priority = 6, enabled = true)
  public void TEST_973_deleteFeetToMeterUnitConversion() throws IOException, InterruptedException, Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    int status = restTemplateDTS.deletePropertyTransformation(cuid, transformationId);
    Assert.assertTrue(200 <= status & status <= 205);
    logger.log(LogStatus.PASS, "deleteFeetToMeterUnitConversion test Completed");
    log.debug("deleteFeetToMeterUnitConversion test Completed");

  }

  /* ADD String addUnitConversionTransformation */

  @Test(priority = 7, enabled = true)
  public void TEST_965_C_addCentimeterToInchSpeedUnitConversion() throws IOException, InterruptedException, Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    String response = restTemplateDTS.addUnitConversionTransformation(cuid, skuid, "CentimetersPerSecondToInchesPerSecond", attrLocalId, "3");
    String[] s1 = response.split(",");
    int status = Integer.parseInt(s1[0]);
    transformationId = s1[1];
    Assert.assertTrue(200 <= status & status <= 205);
    logger.log(LogStatus.PASS, "addCentimeterToInchSpeedUnitConversion test Completed");
    log.debug("add CentimeterToInchSpeedUnitConversiontest Completed");

  }

  @Test(priority = 8, enabled = true)
  public void TEST_965_verifyCentimeterToInchSpeedUnitConversion() throws Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    String value = "{\"CentimetersPerSecondToInchesPerSecond\": 111}";
    String response = agentClient.sendAttrValueForJsonDataType(client, staticEpLocalId, attrLocalId, value,0);
    Set<Object> notificationResponse = nbi.getDTSWebhookNotification(cuid);
    Assert.assertTrue(notificationResponse.toString().contains("{CentimetersPerSecondToInchesPerSecond=43.70078740157481}"));
    logger.log(LogStatus.PASS, "Executing verifyCentimeterToInchSpeedUnitConversion Completed");
    log.debug("Executing verifyCentimeterToInchSpeedUnitConversion");

  }

  @Test(priority = 9, enabled = true)
  public void TEST_973_deleteCentimeterToInchSpeedUnitConversion() throws IOException, InterruptedException, Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    int status = restTemplateDTS.deletePropertyTransformation(cuid, transformationId);
    Assert.assertTrue(200 <= status & status <= 205);
    logger.log(LogStatus.PASS, "deleteCentimeterToInchSpeedUnitConversion( test Completed");
    log.debug("deleteCentimeterToInchSpeedUnitConversion( test Completed");

  }

  @Test(priority = 10, enabled = true)
  public void TEST_965_D_addCentimeterToFeetSpeedUnitConversion() throws IOException, InterruptedException, Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    String response = restTemplateDTS.addUnitConversionTransformation(cuid, skuid, "CentimetersPerSecondToFeetPerSecond", attrLocalId, "4");
    String[] s1 = response.split(",");
    int status = Integer.parseInt(s1[0]);
    transformationId = s1[1];
    Assert.assertTrue(200 <= status & status <= 205);
    logger.log(LogStatus.PASS, "addCentimeterToFeetSpeedUnitConversion test Completed");
    log.debug("add addCentimeterToFeetSpeedUnitConversion Completed");

  }

  @Test(priority = 11, enabled = true)
  public void TEST_965_verifyCentimeterToFeetSpeedUnitConversion() throws Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    String value = "{\"CentimetersPerSecondToFeetPerSecond\": 1111}";
    String response = agentClient.sendAttrValueForJsonDataType(client, staticEpLocalId, attrLocalId, value,0);
    Set<Object> notificationResponse = nbi.getDTSWebhookNotification(cuid);
    Assert.assertTrue(notificationResponse.toString().contains("{CentimetersPerSecondToFeetPerSecond=36.4501312335958}"));
    logger.log(LogStatus.PASS, "Executing verifyCentimeterToFeetSpeedUnitConversion Completed");
    log.debug("Executing verifyCentimeterToFeetSpeedUnitConversion");

  }

  @Test(priority = 12, enabled = true)
  public void TEST_973_deleteCentimeterToFeetSpeedUnitConversion() throws IOException, InterruptedException, Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    int status = restTemplateDTS.deletePropertyTransformation(cuid, transformationId);
    Assert.assertTrue(200 <= status & status <= 205);
    logger.log(LogStatus.PASS, "deleteCentimeterToFeetSpeedUnitConversion test Completed");
    log.debug("deleteCentimeterToFeetSpeedUnitConversion Completed");

  }

  @Test(priority = 13, enabled = true)
  public void TEST_965_E_addFahrenheitToCelsiusSpeedUnitConversion() throws IOException, InterruptedException, Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    String response = restTemplateDTS.addUnitConversionTransformation(cuid, skuid, "FahrenheitToCelsius", attrLocalId, "10");
    String[] s1 = response.split(",");
    int status = Integer.parseInt(s1[0]);
    transformationId = s1[1];
    Assert.assertTrue(200 <= status & status <= 205);
    logger.log(LogStatus.PASS, "addFahrenheitToCelsiusSpeedUnitConversiontest Completed");
    log.debug("add addFahrenheitToCelsiusSpeedUnitConversion Completed");

  }

  @Test(priority = 14, enabled = true)
  public void TEST_965_verifyFahrenheitToCelsiusSpeedUnitConversion() throws Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    String value = "{\"FahrenheitToCelsius\": 1111}";
    String response = agentClient.sendAttrValueForJsonDataType(client, staticEpLocalId, attrLocalId, value,0);
    Set<Object> notificationResponse = nbi.getDTSWebhookNotification(cuid);
    Assert.assertTrue(notificationResponse.toString().contains("{FahrenheitToCelsius=599.4444444444445}"));
    logger.log(LogStatus.PASS, "Executing verifyFahrenheitToCelsiusSpeedUnitConversion Completed");
    log.debug("Executing verifyFahrenheitToCelsiusSpeedUnitConversion");

  }

  @Test(priority = 15, enabled = true)
  public void TEST_973_deleteFahrenheitToCelsiusSpeedUnitConversion() throws IOException, InterruptedException, Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    int status = restTemplateDTS.deletePropertyTransformation(cuid, transformationId);
    Assert.assertTrue(200 <= status & status <= 205);
    logger.log(LogStatus.PASS, "deleteFahrenheitToCelsiusSpeedUnitConversion test Completed");
    log.debug("deleteFahrenheitToCelsiusSpeedUnitConversion Completed");

  }

  @Test(priority = 16, enabled = true)
  public void TEST_965_F_addCentiMetersToMilesSpeedUnitConversion() throws IOException, InterruptedException, Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    String response = restTemplateDTS.addUnitConversionTransformation(cuid, skuid, "CentimetersPerSecondToMilesPerHour", attrLocalId, "7");
    String[] s1 = response.split(",");
    int status = Integer.parseInt(s1[0]);
    transformationId = s1[1];
    Assert.assertTrue(200 <= status & status <= 205);
    logger.log(LogStatus.PASS, "addCentiMetersToMilesSpeedUnitConversion Completed");
    log.debug("addCentiMetersToMilesSpeedUnitConversion Completed");

  }

  @Test(priority = 17, enabled = true)
  public void TEST_965_verifyCentiMetersToMilesSpeedUnitConversion() throws Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    String value = "{\"CentimetersPerSecondToMilesPerHour\": 123}";
    String response = agentClient.sendAttrValueForJsonDataType(client, staticEpLocalId, attrLocalId, value,0);
    Set<Object> notificationResponse = nbi.getDTSWebhookNotification(cuid);
    Assert.assertTrue(notificationResponse.toString().contains("{CentimetersPerSecondToMilesPerHour=2.7514316392269147}"));
    logger.log(LogStatus.PASS, "verifyCentiMetersToMilesSpeedUnitConversion Completed");
    log.debug("Executing verifyCentiMetersToMilesSpeedUnitConversion");

  }

  @Test(priority = 18, enabled = true)
  public void TEST_973_deleteCentiMetersToMilesSpeedUnitConversion() throws IOException, InterruptedException, Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    int status = restTemplateDTS.deletePropertyTransformation(cuid, transformationId);
    Assert.assertTrue(200 <= status & status <= 205);
    logger.log(LogStatus.PASS, "deleteCentiMetersToMilesSpeedUnitConversion test Completed");
    log.debug("deleteCentiMetersToMilesSpeedUnitConversion Completed");

  }

  @Test(priority = 19, enabled = true)
  public void TEST_965_F_addCentiMetersToKiloMeterSpeedUnitConversion() throws IOException, InterruptedException, Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    String response = restTemplateDTS.addUnitConversionTransformation(cuid, skuid, "CentimetersPerSecondToKilometersPerHour", attrLocalId, "8");
    String[] s1 = response.split(",");
    int status = Integer.parseInt(s1[0]);
    transformationId = s1[1];
    Assert.assertTrue(200 <= status & status <= 205);
    logger.log(LogStatus.PASS, "addCentiMetersToKiloMeterSpeedUnitConversion Completed");
    log.debug("addCentiMetersToKiloMeterSpeedUnitConversion Completed");

  }

  @Test(priority = 20, enabled = true)
  public void TEST_965_verifyCentiMetersToKiloMeterSpeedUnitConversion() throws Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    String value = "{\"CentimetersPerSecondToKilometersPerHour\": 1111}";
    String response = agentClient.sendAttrValueForJsonDataType(client, staticEpLocalId, attrLocalId, value,0);
    Set<Object> notificationResponse = nbi.getDTSWebhookNotification(cuid);
    Assert.assertTrue(notificationResponse.toString().contains("{CentimetersPerSecondToKilometersPerHour=39.996}"));
    logger.log(LogStatus.PASS, "verifyCentiMetersToMilesSpeedUnitConversion Completed");
    log.debug("Executing verifyCentiMetersToMilesSpeedUnitConversion");

  }

  @Test(priority = 21, enabled = true)
  public void TEST_973_deleteCentiMetersToKiloMeterSpeedUnitConversion() throws IOException, InterruptedException, Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    int status = restTemplateDTS.deletePropertyTransformation(cuid, transformationId);
    Assert.assertTrue(200 <= status & status <= 205);
    logger.log(LogStatus.PASS, "deleteCentiMetersToMilesSpeedUnitConversion test Completed");
    log.debug("deleteCentiMetersToMilesSpeedUnitConversion Completed");

  }

  @Test(priority = 22, enabled = true)
  public void TEST_965_F_addCelsiusToFahrenheitUnitConversion() throws IOException, InterruptedException, Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    String response = restTemplateDTS.addUnitConversionTransformation(cuid, skuid, "CelsiusToFahrenheit", attrLocalId, "9");
    String[] s1 = response.split(",");
    int status = Integer.parseInt(s1[0]);
    transformationId = s1[1];
    Assert.assertTrue(200 <= status & status <= 205);
    logger.log(LogStatus.PASS, "addCelsiusToFahrenheitUnitConversion Completed");
    log.debug("addCelsiusToFahrenheitUnitConversion Completed");

  }

  @Test(priority = 23, enabled = true)
  public void TEST_965_verifyCelsiusToFahrenheitUnitConversion() throws Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    String value = "{\"CelsiusToFahrenheit\": 1111}";
    String response = agentClient.sendAttrValueForJsonDataType(client, staticEpLocalId, attrLocalId, value,0);
    Set<Object> notificationResponse = nbi.getDTSWebhookNotification(cuid);
    Assert.assertTrue(notificationResponse.toString().contains("{CelsiusToFahrenheit=2031.8}"));
    logger.log(LogStatus.PASS, "verifyCelsiusToFahrenheitUnitConversion Completed");
    log.debug("Executing verifyCelsiusToFahrenheitUnitConversion");

  }

  @Test(priority = 24, enabled = true)
  public void TEST_973_deleteCelsiusToFahrenheitUnitConversion() throws IOException, InterruptedException, Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    int status = restTemplateDTS.deletePropertyTransformation(cuid, transformationId);
    Assert.assertTrue(200 <= status & status <= 205);
    logger.log(LogStatus.PASS, "deleteCelsiusToFahrenheitUnitConversion test Completed");
    log.debug("deleteCelsiusToFahrenheitUnitConversion Completed");

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