package io.smartnexus.ats.settingsprofile;

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
import io.smartnexus.ats.tenant.AddTenant;
import io.smartnexus.ats.utils.ExtentManager;
import io.smartnexus.ats.utils.NorthBoundInterface;

public class SettingsProfile {
	private static final Logger log = Logger.getLogger(SettingsProfile.class.getName());
	ExtentTest logger;
	ExtentReports extent;
	public static String cUid, deviceId, pmId = "";
	private NorthBoundInterface nbi;

	// LoginAs Administrator
	@BeforeClass

	public void setUp() throws Exception {
		extent = ExtentManager.getInstance();
		pmId = AddProductMaster.productMasterId;
		nbi = new NorthBoundInterface();

	}

	@Test(priority = 1, enabled = true)
	public void TEST_00_sendiENBLMessage() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		int status = nbi.addSettingsProfile(pmId, "A");
		Assert.assertTrue(200 <= status & status <= 205);
		logger.log(LogStatus.PASS, "sendiENBLMessage test Completed");
		log.debug("sendiENBLMessage test Completed");

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
