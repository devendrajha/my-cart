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

public class ConfigureDTS {

  private static final Logger log = Logger.getLogger(ConfigureDTS.class.getName());
  ExtentTest logger;
  ExtentReports extent;
  private RestTemplateDTS restTemplateDTS;
  public NorthBoundInterface nbi;
  public static AgentService.Client client;
  AgentClient agentClient = new AgentClient();
  public int attrLocalId, staticEpLocalId;
  public String cuid, skuid, transformationId;

  @BeforeClass

  public void setUp() throws Exception {
    extent = ExtentManager.getInstance();
    nbi = new NorthBoundInterface();
    restTemplateDTS = new RestTemplateDTS();
    client = ProductUpdateAttributesValue.client;
    attrLocalId = 10;
    cuid = AddTenant.tenantCuid;
    skuid = AddProductMaster.productMasterSku;
    staticEpLocalId = 0;
  }

  /*
   * ADD String getTransformationTypeList
   */
  @Test(priority = 1, enabled = true)
  public void TEST_959_A_renamePropertyTransformation() throws Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    restTemplateDTS.deletePropertyTransformation(cuid, transformationId);
    String response = restTemplateDTS.renameProperty(cuid, skuid, attrLocalId, "autotest", "rename");
    String[] s1 = response.split(",");
    int status = Integer.parseInt(s1[0]);
    transformationId = s1[1];
    Assert.assertTrue(200 <= status & status <= 205);
    Thread.sleep(60000);
    logger.log(LogStatus.PASS, "renamePropertyTransformation test Completed");
    log.debug("renamePropertyTransformation test Completed");

  }

  @Test(priority = 2, enabled = true)
  public void TEST_959_verifyRenamePropertyNotification() throws Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    String value = "{\"autotest\": \"jsonval\",\"dts1\": \"testng\"}";
    agentClient.sendAttrValueForJsonDataType(client, staticEpLocalId, attrLocalId, value,0);
    Set<Object> notificationResponse = nbi.getDTSWebhookNotification(cuid);
    Assert.assertTrue(notificationResponse.toString().contains("{rename=jsonval, dts1=testng}"));
    logger.log(LogStatus.PASS, "verifyRenamePropertyNotification test Completed");
    log.debug("verifyRenamePropertyNotification test Completed");

  }

  @Test(priority = 3, enabled = true)
  public void TEST_973_deleteRenameTransformation() throws IOException, InterruptedException, Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    int status = restTemplateDTS.deletePropertyTransformation(cuid, transformationId);
    Assert.assertTrue(200 <= status & status <= 205);
    logger.log(LogStatus.PASS, "deleteRenameTransformation test Completed");
    log.debug("deleteRenameTransformation test Completed");

  }

  // ADD String getTransformationTypeList

  @Test(priority = 4, enabled = true)
  public void TEST_960_A_removePropertyTransformation() throws IOException, InterruptedException, Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    String response = restTemplateDTS.removeProperty(cuid, skuid, attrLocalId, "reporting");
    String[] s1 = response.split(",");
    int status = Integer.parseInt(s1[0]);
    transformationId = s1[1];
    Assert.assertTrue(200 <= status & status <= 205);
    logger.log(LogStatus.PASS, "removePropertyTransformation test Completed");
    log.debug("removePropertyTransformation test Completed");

  }

  // ADD String getTransformationTypeList

  @Test(priority = 5, enabled = true)
  public void TEST_960_verifyRemovePropertyTransformation() throws IOException, InterruptedException, Exception {
    String value = "{\"remove\": \"attribute\",\"reporting\": \"testng\"}";
    agentClient.sendAttrValueForJsonDataType(client, staticEpLocalId, attrLocalId, value,0);
    Set<Object> notificationResponse = nbi.getDTSWebhookNotification(cuid);
    Assert.assertTrue(notificationResponse.toString().contains("{remove=attribute}"));
    logger.log(LogStatus.PASS, "verfyRemovePropertyTransformation test Completed");
    log.debug("verfyRemovePropertyTransformation test Completed");

  }

  @Test(priority = 6, enabled = true)
  public void TEST_973_deleteRemoveTransformation() throws IOException, InterruptedException, Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    int status = restTemplateDTS.deletePropertyTransformation(cuid, transformationId);
    Assert.assertTrue(200 <= status & status <= 205);
    logger.log(LogStatus.PASS, "deleteRemoveTransformation test Completed");
    log.debug("deleteRemoveTransformation test Completed");

  }

  // ADD String addExternalApiTransformation

  @Test(priority = 7, enabled = true)
  public void TEST_961_addPOSTExternalApiTransformation() throws IOException, InterruptedException, Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    String response = restTemplateDTS.addExternalApi(cuid, skuid, attrLocalId, restTemplateDTS.getMethodType("POST"), "https://putsreq.com/dtsPost");
    String[] s1 = response.split(",");
    int status = Integer.parseInt(s1[0]);
    transformationId = s1[1];
    Assert.assertTrue(200 <= status & status <= 205);
    logger.log(LogStatus.PASS, "addPOSTExternalApiTransformation test Completed");
    log.debug("addPOSTExternalApiTransformation test Completed");

  }

  @Test(priority = 8, enabled = true)
  public void TEST_973_deletePOSTExternalTransformation() throws IOException, InterruptedException, Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    int status = restTemplateDTS.deletePropertyTransformation(cuid, transformationId);
    Assert.assertTrue(200 <= status & status <= 205);
    logger.log(LogStatus.PASS, "deletePOSTExternalTransformation test Completed");
    log.debug("deletePOSTExternalTransformation test Completed");

  }

  // ADD String addExternalApiTransformation

  @Test(priority = 9, enabled = true)
  public void TEST_962_addPUTExternalApiTransformation() throws IOException, InterruptedException, Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    String response = restTemplateDTS.addExternalApi(cuid, skuid, attrLocalId, restTemplateDTS.getMethodType("PUT"), "https://putsreq.com/dtsPost");
    String[] s1 = response.split(",");
    int status = Integer.parseInt(s1[0]);
    transformationId = s1[1];
    Assert.assertTrue(200 <= status & status <= 205);
    logger.log(LogStatus.PASS, "addPUTExternalApiTransformation test Completed");
    log.debug("addPUTExternalApiTransformation test Completed");

  }

  @Test(priority = 10, enabled = true)
  public void TEST_973_deletePUTExternalTransformation() throws IOException, InterruptedException, Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    int status = restTemplateDTS.deletePropertyTransformation(cuid, transformationId);
    Assert.assertTrue(200 <= status & status <= 205);
    logger.log(LogStatus.PASS, "deletePUTExternalTransformation test Completed");
    log.debug("deletePUTExternalTransformation test Completed");

  }

  // ADD String addCustomDataTransformation

  @Test(priority = 11, enabled = true)
  public void TEST_963_addCustomDataTransformation() throws IOException, InterruptedException, Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    String response = restTemplateDTS.addCustomDataTransformation(cuid, skuid, attrLocalId);
    String[] s1 = response.split(",");
    int status = Integer.parseInt(s1[0]);
    transformationId = s1[1];
    Assert.assertTrue(200 <= status & status <= 205);
    logger.log(LogStatus.PASS, "addCustomDataTransformation test Completed");
    log.debug("addCustomDataTransformation test Completed");

  }

  @Test(priority = 12, enabled = true)
  public void TEST_973_deleteCustomDataTransformation() throws IOException, InterruptedException, Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    int status = restTemplateDTS.deletePropertyTransformation(cuid, transformationId);
    Assert.assertTrue(200 <= status & status <= 205);
    logger.log(LogStatus.PASS, "deleteCustomDataTransformation test Completed");
    log.debug("deleteCustomDataTransformation test Completed");

  }

  /*
   * ADD String addStripDiagnosticTransformation
   */
  @Test(priority = 13, enabled = true)
  public void TEST_964_A_addStripDiagnosticTransformation() throws IOException, InterruptedException, Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    String response = restTemplateDTS.addStripDiagnosticTransformation(cuid, skuid, "dtstest", attrLocalId);
    String[] s1 = response.split(",");
    int status = Integer.parseInt(s1[0]);
    transformationId = s1[1];
    Assert.assertTrue(200 <= status & status <= 205);
    logger.log(LogStatus.PASS, "addStripDiagnosticTransformation test Completed");
    log.debug("addStripDiagnosticTransformation test Completed");

  }

  @Test(priority = 14, enabled = true)
  public void TEST_964_verifyStripDiagnosticNotification() throws Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    String value = "{\"dtstest\": \"tenant\",\"report\": \"testng\"}";
    agentClient.sendAttrValueForJsonDataType(client, staticEpLocalId, attrLocalId, value,0);
    Set<Object> notificationResponse = nbi.getDTSWebhookNotification(cuid);
    Assert.assertTrue(!notificationResponse.toString().contains("dtstest"));
    logger.log(LogStatus.PASS, "verifyStripDiagnosticNotification test Completed");
    log.debug("verifyStripDiagnosticNotification test Completed");

  }

  @Test(priority = 15, enabled = true)
  public void TEST_973_deleteStripDiagnosticTransformation() throws IOException, InterruptedException, Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    int status = restTemplateDTS.deletePropertyTransformation(cuid, transformationId);
    Assert.assertTrue(200 <= status & status <= 205);
    logger.log(LogStatus.PASS, "deleteStripDiagnosticTransformation test Completed");
    log.debug("deleteStripDiagnosticTransformation test Completed");

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
