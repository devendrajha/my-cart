package io.smartnexus.ats.geofence;

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

public class Geofence {
  private static final Logger log = Logger.getLogger(Geofence.class.getName());
  ExtentTest logger;
  ExtentReports extent;
  GeofenceApiTemplate restTemplate;
  public NorthBoundInterface nbi;
  public static AgentService.Client client;
  AgentClient agentClient = new AgentClient();
  public static String cuid, skuid;
  public int attrLocalId, staticEpLocalId;

  // LoginAs Administrator
  @BeforeClass

  public void setUp() {
    extent = ExtentManager.getInstance();
    restTemplate = new GeofenceApiTemplate();
    nbi = new NorthBoundInterface();
    client = ProductUpdateAttributesValue.client;
    cuid = AddTenant.tenantCuid;
    skuid = AddProductMaster.productMasterSku;
    attrLocalId = 10;
    staticEpLocalId = 0;
  }
  /*
   * create inside Boundary TEST
   */

  @Test(priority = 1, enabled = true)
  public void TEST_934_createInsideCircleBoundary() {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    String name = "InsideCircleBoundary_A10";
    int status = restTemplate.addInsideCircleBoundary(cuid, name);
    Assert.assertEquals(name, restTemplate.getBoundaryById(cuid, status));
    logger.log(LogStatus.PASS, "createInsideCircleBoundary test Completed");
    log.debug("createInsideCircleBoundary test Completed");

  }
  /*
   * create Outside Boundary TEST
   */

  @Test(priority = 2, enabled = true)
  public void TEST_935_createOutsideCircleBoundary() {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    String name = "OutsideCircleBoundary_A20";
    int status = restTemplate.addOutsideCircleBoundary(cuid, name);
    Assert.assertEquals(name, restTemplate.getBoundaryById(cuid, status));
    logger.log(LogStatus.PASS, "createOutsideCircleBoundary test Completed");
    log.debug("createOutsideCircleBoundary test Completed");

  }
  
  /*
   * create inside polygon Boundary TEST
   */
  @Test(priority = 3, enabled = true)
  public void TEST_936_createInsidePolygonBoundary() {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    String name = "InsidePolygonBoundary_B10";
    int status = restTemplate.addInsidePolygonBoundary(cuid, name);
    Assert.assertEquals(name, restTemplate.getBoundaryById(cuid, status));
    logger.log(LogStatus.PASS, "createInsidePolygonBoundary test Completed");
    log.debug("createInsidePolygonBoundary test Completed");

  }

  /*
   * create Outside polygon Boundary TEST
   */
  @Test(priority = 4, enabled = true)
  public void TEST_937_createOutsidePolygonBoundary() {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    String name = "OutsidePolygonBoundary_B20";
    int status = restTemplate.addOutsidePolygonBoundary(cuid, name);
    Assert.assertEquals(name, restTemplate.getBoundaryById(cuid, status));
    logger.log(LogStatus.PASS, "createOutsidePolygonBoundary test Completed");
    log.debug("createOutsidePolygonBoundary test Completed");

  }

  /*
   * Create Outside Boundary violation TEST
   */
  @Test(priority = 5, enabled = true)
  public void TEST_941_verifyOutsideGeofenceBoundaryViolation() {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    String value = "{\"location\":{ \"latitude\": 33.934022,\"longitude\":-83.536007}}";
    agentClient.sendAttrValueForJsonDataType(client, staticEpLocalId, attrLocalId, value,0);
    Set<String> notificationResponse = nbi.getGeofenceNotification(cuid);
    Assert.assertTrue(notificationResponse.toString().contains("Outside"));
    logger.log(LogStatus.PASS, "TEST_941_verifyOutsideGeofenceBoundaryViolation test Completed");
    log.debug("TEST_941_verifyOutsideGeofenceBoundaryViolation test Completed");

  }
  
  /*
   * Create Inside Boundary violation TEST
   */
  @Test(priority = 6, enabled = true)
  public void TEST_941_verifyInsideGeofenceBoundaryViolation() {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    String value = "{\"location\":{ \"latitude\": 33.934022,\"longitude\":-83.536007}}";
    agentClient.sendAttrValueForJsonDataType(client, staticEpLocalId, attrLocalId, value,0);
    Set<String> notificationResponse = nbi.getGeofenceNotification(cuid);
    Assert.assertTrue(notificationResponse.toString().contains("Inside"));
    logger.log(LogStatus.PASS, "TEST_941_verifyInsideGeofenceBoundaryViolation test Completed");
    log.debug("TEST_941_verifyInsideGeofenceBoundaryViolation test Completed");

  }

  /*
   * Update Boundary TEST
   */

  @Test(priority = 7, enabled = true)
  public void TEST_975_updateBoundary() {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    String name = "Boundary_A44";
    Assert.assertEquals(name, restTemplate.updateBoundary(cuid, name));
    logger.log(LogStatus.PASS, "updateBoundary test Completed");
    log.debug("updateBoundary test Completed");

  }

  /*
   * Get  Boundary TEST
   */
  @Test(priority = 8, enabled = false)
  public void TEST_00_getBoundary() {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    int status = restTemplate.getBoundary(cuid);
    Assert.assertTrue(200 <= status & status <= 205);
    logger.log(LogStatus.PASS, "getBoundary test Completed");
    log.debug("getBoundary test Completed");

  }
  /*
   * Delete Boundary TEST
   */
  @Test(priority = 9, enabled = true)
  public void TEST_974_deleteBoundary() {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    int status = restTemplate.deleteBoundary(cuid);
    Assert.assertTrue(200 <= status & status <= 205);
    logger.log(LogStatus.PASS, "deleteBoundary test Completed");
    log.debug("deleteBoundary test Completed");

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