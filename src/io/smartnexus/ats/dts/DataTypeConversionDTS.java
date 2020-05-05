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

public class DataTypeConversionDTS {

  private static final Logger log = Logger.getLogger(DataTypeConversionDTS.class.getName());
  ExtentTest logger;
  ExtentReports extent;
  private RestTemplateDTS restTemplateDTS;
  public NorthBoundInterface nbi;
  int localId = 10;
  public String cuid, skuid, deviceId, transformationId;
  public static AgentService.Client client;
  AgentClient agentClient = new AgentClient();
  public int attrLocalId, staticEpLocalId;

  @BeforeClass
  public void setUp() throws Exception {
    extent = ExtentManager.getInstance();
    restTemplateDTS = new RestTemplateDTS();
    nbi = new NorthBoundInterface();
    cuid = AddTenant.tenantCuid;
    skuid = AddProductMaster.productMasterSku;
    client = ProductUpdateAttributesValue.client;
    attrLocalId = 10;
    staticEpLocalId = 0;
    deviceId = ProductUpdateAttributesValue.deviceId;

  }

  /*
   * ADD String addUnitConversionTransformation
   */
  @Test(priority = 1, enabled = true)
  public void TEST_967_A_addStringToIntegerDataType() throws IOException, InterruptedException, Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    String response = restTemplateDTS.addDataTypeTransformation(cuid, skuid, "stringToInt", localId, 1);
    String[] s1 = response.split(",");
    int status = Integer.parseInt(s1[0]);
    transformationId = s1[1];
    Assert.assertTrue(200 <= status & status <= 205);
    logger.log(LogStatus.PASS, "addDataTypeTransformation test Completed");
    log.debug("addDataTypeTransformation test Completed");

  }

  @Test(priority = 2, enabled = true)
  public void TEST_967_verifyStringToIntegerNotification() throws Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    String value = "{ \"stringToInt\": 33.934022}";
    agentClient.sendAttrValueForJsonDataType(client, staticEpLocalId, attrLocalId, value,0);
    Set<Object> notificationResponse = nbi.getDTSWebhookNotification(cuid);
    Assert.assertTrue(notificationResponse.toString().contains("{stringToInt=34.0}"));
    logger.log(LogStatus.PASS, "verifyRenamePropertyNotification test Completed");
    log.debug("verifyRenamePropertyNotification test Completed");

  }

  /*
   * ADD String addUnitConversionTransformation
   */
  @Test(priority = 3, enabled = true)
  public void TEST_973_deleteStringToIntegerTransformation() throws IOException, InterruptedException, Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    int status = restTemplateDTS.deletePropertyTransformation(cuid, transformationId);
    Assert.assertTrue(200 <= status & status <= 205);
    logger.log(LogStatus.PASS, "addUnitConversionTransformation test Completed");
    log.debug("addUnitConversionTransformation test Completed");

  }

  /*
   * ADD String addUnitConversionTransformation
   */
  @Test(priority = 5, enabled = true)
  public void TEST_967_B_addIntegerToStringDataType() throws IOException, InterruptedException, Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    String response = restTemplateDTS.addDataTypeTransformation(cuid, skuid, "IntToString", localId, 2);
    String[] s1 = response.split(",");
    int status = Integer.parseInt(s1[0]);
    transformationId = s1[1];
    Assert.assertTrue(200 <= status & status <= 205);
    logger.log(LogStatus.PASS, "addDataTypeTransformation test Completed");
    log.debug("addDataTypeTransformation test Completed");

  }

  @Test(priority = 6, enabled = true)
  public void TEST_967_verifyIntegerToStringDataType() throws Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    String value = "{ \"IntToString\": \"33.934022\" }";
    agentClient.sendAttrValueForJsonDataType(client, staticEpLocalId, attrLocalId, value,0);
    Set<Object> notificationResponse = nbi.getDTSWebhookNotification(cuid);
    Assert.assertTrue(notificationResponse.toString().contains("{IntToString=33.934022}"));
    logger.log(LogStatus.PASS, "verifyIntegerToStringDataType test Completed");
    log.debug("verifyIntegerToStringDataType test Completed");

  }

  /*
   * ADD String addUnitConversionTransformation
   */
  @Test(priority = 7, enabled = true)
  public void TEST_973_deleteIntegerToStringTransformation() throws IOException, InterruptedException, Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    int status = restTemplateDTS.deletePropertyTransformation(cuid, transformationId);
    Assert.assertTrue(200 <= status & status <= 205);
    logger.log(LogStatus.PASS, "addUnitConversionTransformation test Completed");
    log.debug("addUnitConversionTransformation test Completed");

  }

  /*
   * ADD String addUnitConversionTransformation
   */
  @Test(priority = 8, enabled = true)
  public void TEST_968_A_addJsonToXMLDataType() throws IOException, InterruptedException, Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    String response = restTemplateDTS.addDataTypeTransformation(cuid, skuid, "JsonToXML", localId, 3);
    String[] s1 = response.split(",");
    int status = Integer.parseInt(s1[0]);
    transformationId = s1[1];
    Assert.assertTrue(200 <= status & status <= 205);
    logger.log(LogStatus.PASS, "addDataTypeTransformation test Completed");
    log.debug("addDataTypeTransformation test Completed");

  }

  @Test(priority = 9, enabled = true)
  public void TEST_968_verifyJsonToXMLDataType() throws Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    String value = "{\r\n  \"JsonToXML\": {\r\n\"wifi\": {\r\n\"x\": 129,\r\n\"y\": -987,\r\n\"z\": 47\r\n},\r\n\"battery\": {\r\n\"percent\": 86,\r\n\"voltage\": 4036.1,\r\n\"temp\": 3.3,\r\n\"charging\": false\r\n }\r\n}\r\n}";
    agentClient.sendAttrValueForJsonDataType(client, staticEpLocalId, attrLocalId, value,0);
    Set<Object> notificationResponse = nbi.getDTSWebhookNotification(cuid);
    Assert.assertTrue(notificationResponse.toString().contains(
        "JsonToXML=<Data><wifi><x>129</x><y>-987</y><z>47</z></wifi><battery><percent>86</percent><voltage>4036.1</voltage><temp>3.3</temp><charging>false</charging></battery></Data>"));
    logger.log(LogStatus.PASS, "verifyJsonToXMLDataType test Completed");
    log.debug("verifyJsonToXMLDataType test Completed");

  }

  /*
   * ADD String addUnitConversionTransformation
   */
  @Test(priority = 10, enabled = true)
  public void TEST_973_deleteJsonToXMLTransformation() throws IOException, InterruptedException, Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    int status = restTemplateDTS.deletePropertyTransformation(cuid, transformationId);
    Assert.assertTrue(200 <= status & status <= 205);
    logger.log(LogStatus.PASS, "addUnitConversionTransformation test Completed");
    log.debug("addUnitConversionTransformation test Completed");

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
