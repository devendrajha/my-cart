package io.smartnexus.ats.configure.product;

import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.smartnexus.ats.tenant.AddTenant;
import io.smartnexus.ats.utils.Constants;
import io.smartnexus.ats.utils.ExtentManager;
import io.smartnexus.ats.utils.NorthBoundInterface;
import io.smartnexus.ats.utils.TestNgParameters;
import junit.framework.Assert;

public class AddProductMaster {

  private static final Logger log = Logger.getLogger(AddProductMaster.class.getName());
  ExtentTest logger;
  ExtentReports extent;
  private String productMasterName;
  private String newProductMasterName;
  public static String productMasterSku ="ATSSKU";// Constants.PRODUCTMASTER_SKU;
  public static String productLine = null;
  private NorthBoundInterface nbi;
  public static String productMasterId ="";
  static TestNgParameters testNg = new TestNgParameters();
  static String environment = testNg.getEnvironment();

  // LoginAs Administrator
  @BeforeClass

  public void setUp() throws Exception {
    extent = ExtentManager.getInstance();
    nbi = new NorthBoundInterface();
    productMasterName = Constants.PRODUCTMASTER_NAME;
    newProductMasterName = Constants.PRODUCTMASTER_NAME;
    
    if (environment.equals("dev")) {
    	productMasterId =  "95faf465-8c12-4541-9b12-bca6eeecf4ee"; 
	} 

  }

  /*
   * ADD PRODUCTLINE API test
   */

  @Test(priority = 1, enabled = false)
  public void TEST_254_addProductMaster() {
    logger = extent.startTest(this.getClass().getSimpleName());
    productMasterId = nbi.addProductMaster(productMasterName, productMasterSku);
    Assert.assertEquals(productMasterId, nbi.getProductMasterId(productMasterName));
    logger.log(LogStatus.PASS, "add ProductMaster test Completed");
    log.debug("add productMaster test Completed");
  }

  /*
   * UPDATE PRODUCTLINE API TEST
   */

  @Test(priority = 2, enabled = true)
  public void TEST_255_updateProductMaster() {
    logger = extent.startTest(this.getClass().getSimpleName());
    String desc = "ATS framework is using this Product Master" + System.currentTimeMillis();
    int status=nbi.updateProductMaster(productMasterId, desc);
    Assert.assertTrue(200 <= status & status <= 205);
    //Assert.assertEquals(productMasterId, nbi.getProductMasterId(name));
    logger.log(LogStatus.PASS, "updateProductMaster test Completed");
    log.debug("updateProductMaster test Completed");
  }

  /*
   * VERIFY ADD PRODUCTLINE WITH DUPLICATE SKU
   */
  @Test(priority = 3, enabled = false)
  public void TEST_29_addProductMasterWithDuplicateSKU() {
    logger = extent.startTest(this.getClass().getSimpleName());
    String response = nbi.addProductMaster(newProductMasterName, productMasterSku);
    Assert.assertTrue(response.equals("{code:-1,msg:Sku already exists.}"));
    logger.log(LogStatus.PASS, "addProductMasterWithDuplicateSKU test Completed");
    log.debug("addProductMasterWithDuplicateSKU test Completed");
  }

  /*
   * VERIFY exportProductMaster
   */
  @Test(priority = 4, enabled = false)
  public void TEST_777_exportProductMaster() {
    logger = extent.startTest(this.getClass().getSimpleName());
    String response = nbi.exportProductMaster(productMasterId);
    Assert.assertTrue(response.contains("https://") && response.contains(".json"));
    logger.log(LogStatus.PASS, "exportProductMaster test Completed");
    log.debug("exportProductMaster test Completed");
  }

  /*
   * VERIFY importProductMaster
   */
  @Test(priority = 5, enabled = false)
  public void TEST_778_importProductMaster() {
    logger = extent.startTest(this.getClass().getSimpleName());
    String response = nbi.importProductMaster();
    String[] s = response.split(",");
    int status = Integer.parseInt(s[0]);
    Assert.assertTrue(200 <= status & status <= 205);
    nbi.deleteProductMaster(s[1]);
    logger.log(LogStatus.PASS, "exportProductMaster test Completed");
    log.debug("exportProductMaster test Completed");
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
