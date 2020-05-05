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
import io.smartnexus.ats.utils.CommonUtils;
import io.smartnexus.ats.utils.ExtentManager;
import io.smartnexus.ats.utils.NorthBoundInterface;
import junit.framework.Assert;

public class ConfigureProductNotificationWithHighPriority {
	private static final Logger log = Logger.getLogger(ConfigureProductNotificationWithHighPriority.class.getName());
	ExtentTest logger;
	ExtentReports extent;
	private NorthBoundInterface nbi;
	public String SKUID, webHookURL, authUri, CUID, outPutType, priority;
	static CommonUtils cu = new CommonUtils();

	@BeforeClass
	public void setUp() throws Exception {
		extent = ExtentManager.getInstance();
		nbi = new NorthBoundInterface();
		SKUID = AddProductMaster.productMasterSku;
		CUID = AddTenant.tenantCuid;
		outPutType = "1";
		priority = "High";
	}

	// Add template for Change Attribute Value
	@Test(priority = 1, enabled = true)
	public void TEST_349_addTemplateChangeAttributeValueHighPriority() {
		logger = extent.startTest(this.getClass().getSimpleName());
		nbi.addTemplate(CUID, SKUID, "Attribute Value Update With High Priority", 5, 10, 28, "", priority, outPutType);
		int status = nbi.subscribeTemplate(SKUID, CUID, 5);
		Assert.assertTrue(200 <= status & status <= 205);
		int statusNew = nbi.subscribeTemplate(SKUID, CUID, 1);
		Assert.assertTrue(200 <= statusNew & statusNew <= 205);
		logger.log(LogStatus.PASS, "addTemplateChangeAttributeValueHighPriority test Completed");
		log.debug("addTemplateChangeAttributeValueHighPriority test Completed");

	}

	// Add template for Setting Value Update With High Priority
	@Test(priority = 2, enabled = true)
	public void TEST_346_addTemplateChangeSettingValueHighPriority() {
		logger = extent.startTest(this.getClass().getSimpleName());
		nbi.addTemplate(CUID, SKUID, "Setting Value Update With High Priority", 5, 10, 29, "", priority, outPutType);
		int status = nbi.subscribeTemplate(SKUID, CUID, 5);
		Assert.assertTrue(200 <= status & status <= 205);
		int statusNew = nbi.subscribeTemplate(SKUID, CUID, 1);
		Assert.assertTrue(200 <= statusNew & statusNew <= 205);
		logger.log(LogStatus.PASS, "addTemplateChangeSettingValueHighPriority test Completed");
		log.debug("addTemplateChangeSettingValueHighPriority test Completed");

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
