package io.smartnexus.ats.product;

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
import io.smartnexus.ats.utils.CommonUtils;
import io.smartnexus.ats.utils.Constants;
import io.smartnexus.ats.utils.ExtentManager;
import io.smartnexus.ats.utils.NorthBoundInterface;

public class ProductMasterUserFields {

  private static final Logger log = Logger.getLogger(ProductMasterUserFields.class.getName());
  private NorthBoundInterface nbi;
  ExtentTest logger;
  ExtentReports extent;
  String UserFieldName;
  static CommonUtils cu = new CommonUtils();
  private String userFieldName;
  private String userFieldNameInt;
  private String productLineId;
  private String userfieldId;
  private String userfieldId1;

  // LoginAs Administrator
  @BeforeClass

  public void setUp() throws Exception {
    extent = ExtentManager.getInstance();
    nbi = new NorthBoundInterface();
    productLineId = AddProductMaster.productMasterId;
    userfieldId = cu.generateRandomID() + "";
    userfieldId1 = cu.generateRandomID() + "" + 1;
    userFieldNameInt = cu.randomName().toString();
    userFieldName = "name" + cu.randomName();
  }

  /*
   * Add USERFIELDS IN Settings
   * 
   * @Step Click on Settings Icon
   * 
   * @Step Click on add button for UserFields
   * 
   * @Step Enter the UserFields details and save
   * 
   * @Step Verify Search result
   */
  @Test(priority = 1, enabled = false)
  public void TEST_545_addSettingUserFieldsString() throws IOException, InterruptedException {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    int status = nbi.addProductMasterCustomField(userFieldName, userfieldId1, Constants.STRING);
    Assert.assertTrue(200 <= status & status <= 205);
    logger.log(LogStatus.PASS, "addSettingUserFields test Completed");
    log.debug("addSettingUserFields test Completed");

  }

  /*
   * Add USERFIELDS IN Settings
   * 
   * @Step Click on Settings Icon
   * 
   * @Step Click on add button for UserFields
   * 
   * @Step Enter the UserFields details and save
   * 
   * @Step Verify Search result
   */
  @Test(priority = 2, enabled = true)
  public void TEST_545_addSettingUserFieldsInt() throws IOException, InterruptedException {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    int status = nbi.addProductMasterCustomField(userFieldNameInt, userfieldId, Constants.INT);
    Assert.assertTrue(200 <= status & status <= 205);
    logger.log(LogStatus.PASS, "TEST_545_addSettingUserFieldsInt Completed");
    log.debug("TEST_545_addSettingUserFieldsInt Completed");

  }

  /*
   * Edit USERFIELDS IN Settings
   * 
   * @Step Click on Settings Icon
   * 
   * @Step Click on Edit button for UserFields
   * 
   * @Step Edit the UserFields details and save
   * 
   * @verify the search result
   */
  @Test(priority = 3, enabled = false)
  public void TEST_546_editSettingUserFields() throws Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    int status = nbi.updateProductMasterCustomField(userfieldId1, productLineId);
    System.out.println("TEST_546_editSettingUserFields " + status);
    Assert.assertTrue(200 <= status & status <= 205);
    logger.log(LogStatus.PASS, "TEST_546_editSettingUserField Completed");
    log.debug("TEST_546_editSettingUserField Completed");

  }

  /*
   * add USERFIELDS VALUE IN PRODUCT LINE PAGE
   * 
   * @Step Select the product Line
   * 
   * @Step Search UserFields In Product Line Page
   * 
   * @Step Enter the UserFields name and click go
   * 
   * @Step click on Edit and set the UserField Value
   * 
   * @step click on save
   */

  @Test(priority = 4, enabled = false)
  public void TEST_548_addUserFieldsValue() throws Exception, Exception {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    int status = nbi.setProductMasterCustomFieldValue(userFieldNameInt, productLineId);
    System.out.println("status " + status);
    Assert.assertTrue(200 <= status & status <= 205);
    logger.log(LogStatus.PASS, "TEST_548_addUserFieldsValue Completed");
    log.debug("TEST_548_addUserFieldsValue Completed");
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
