package io.smartnexus.ats.groups;

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
import io.smartnexus.ats.utils.CommonUtils;
import io.smartnexus.ats.utils.Constants;
import io.smartnexus.ats.utils.ExtentManager;
import io.smartnexus.ats.utils.NorthBoundInterface;
import junit.framework.Assert;

public class SiteConfig {
  private static final Logger log = Logger.getLogger(SiteConfig.class);
  ExtentTest logger;
  ExtentReports extent;
  private NorthBoundInterface nbi;
  static CommonUtils cu = new CommonUtils();
  public static String cuid;
  private String reporting_group, sku, deviceId, mfgId;

  @BeforeClass

  public void setUp() throws Exception {
    extent = ExtentManager.getInstance();
    nbi = new NorthBoundInterface();
    reporting_group = "Group_" + cu.randomName();
    mfgId = Constants.MFGID;
    deviceId = "" + System.currentTimeMillis();
    cuid = AddTenant.tenantCuid;
    sku = AddProductMaster.productMasterSku;
  }

  /*
   * ADD PRODUCTLINE API test
   */

  @Test(priority = 1, enabled = true)
  public void addSiteConfig() throws Exception  {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    nbi.addProduct(cuid, sku, deviceId, deviceId);
    int status = nbi.addSiteConfig(deviceId, deviceId, reporting_group, mfgId);
    Assert.assertTrue(status >= 200 & status < 205);
    logger.log(LogStatus.PASS, "add ProductMaster test Completed");
    log.debug("add productMaster test Completed");

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
