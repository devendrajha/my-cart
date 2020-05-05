package io.smartnexus.ats.configure.peripheral;

import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.smartnexus.ats.configure.product.AddProductMaster;
import io.smartnexus.ats.tenant.AddTenant;
import io.smartnexus.ats.utils.Constants;
import io.smartnexus.ats.utils.ExtentManager;
import io.smartnexus.ats.utils.NorthBoundInterface;

public class ConfigurePeripheralNotifications {

  private static final Logger log = Logger.getLogger(ConfigurePeripheralNotifications.class.getName());
  ExtentTest logger;
  ExtentReports extent;
  private NorthBoundInterface nbi;
  public String SKUID, CUID, mfgId, outPutType, priority;

  // LoginAs Administrator
  @BeforeClass

  public void setUp() throws Exception {
    extent = ExtentManager.getInstance();
    nbi = new NorthBoundInterface();
    SKUID = AddProductMaster.productMasterSku;
    CUID = AddTenant.tenantCuid;
    mfgId = Constants.MFGID;
    outPutType = "1";
    priority = "Low";

  }

  /*
   * Add Change Setting value template
   */
  @Test(priority = 1, enabled = true)
  public void TEST_346_addTemplateChangeSettingValue() {
    logger = extent.startTest(this.getClass().getSimpleName());
    String temlateName = "Setting Value Update";
    nbi.addTemplate(CUID, SKUID, temlateName, 1, 1, 29, mfgId, priority, outPutType);
    nbi.subscribeTemplate(SKUID, CUID, 1);
    logger.log(LogStatus.PASS, "addTepmlateChangeSettingValue test Completed");
    log.debug("addTepmlateChangeSettingValue test Completed");

  }

  /*
   * Add Change Attribute value template
   */
  @Test(priority = 2, enabled = true)
  public void TEST_349_addTepmlateChangeAttributeValue() {
    logger = extent.startTest(this.getClass().getSimpleName());
    String temlateName = "Attribute Value Update";
    nbi.addTemplate(CUID, SKUID, temlateName, 1, 1, 28, mfgId, priority, outPutType);
    nbi.subscribeTemplate(SKUID, CUID, 1);
    logger.log(LogStatus.PASS, "addTepmlateChangeAttributeValue test Completed");
    log.debug("addTepmlateChangeAttributeValue test Completed");

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
