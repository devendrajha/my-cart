package io.smartnexus.ats.tenant;

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

import io.smartnexus.ats.pojo.CompanyDetails;
import io.smartnexus.ats.pojo.Options;
import io.smartnexus.ats.utils.CommonUtils;
import io.smartnexus.ats.utils.Constants;
import io.smartnexus.ats.utils.ExtentManager;
import io.smartnexus.ats.utils.NorthBoundInterface;
import io.smartnexus.ats.utils.TestNgParameters;

public class AddTenant {
	private static final Logger log = Logger.getLogger(AddTenant.class.getName());
	ExtentTest logger;
	ExtentReports extent;
	private String authenticationType;
	public static String tenantId, tenantName, tenantCuid;
	private NorthBoundInterface nbi;
	static TestNgParameters testNg = new TestNgParameters();
	static CommonUtils cu = new CommonUtils();
	static String environment = testNg.getEnvironment();

	// LoginAs 
	@BeforeClass
	public void setUp() throws Exception {
		extent = ExtentManager.getInstance();
		tenantName = Constants.TENANT_NAME;
		authenticationType = "KeyCloak";
		nbi = new NorthBoundInterface();
		if (environment.equals("dev")) {
			tenantCuid ="INTEL";// Constants.TENANT_CUID;
			NorthBoundInterface.tenantId = tenantId ="ef3aa1f3-b291-4960-a244-d9b16bc19db8"; 
		}else if (environment.equals("prodiat")) {
			NorthBoundInterface.tenantId = tenantId ="d1a00415-95a5-4070-a474-99fbfa78acbf";
			tenantCuid ="qa";// Constants.TENANT_CUID;
		} 

	}
	/*
	 * ADD TENANT TEST by using Add tenant API
	 * After adding tenant verify tenant 
	 * Make Get Tenant api call and iterate response and verify recently added company Id is there
	 * 
	 */

	@Test(priority = 1, enabled = false)
	public void TEST_86_addTenant() throws IOException, InterruptedException {
		logger = extent.startTest(this.getClass().getSimpleName());

		String response = nbi.addTenant(tenantCuid, tenantName, authenticationType);
		String[] s1 = response.split(",");
		NorthBoundInterface.tenantId = tenantId = s1[1];
		Assert.assertEquals(nbi.getTenantDetails(tenantCuid).getCompanyId(), tenantId);
		logger.log(LogStatus.PASS, "TEST_86_addTenant Completed");
		log.debug("TEST_86_addTenant Completed");
	}

	@Test(priority = 2, enabled = false)
	public void TEST_942_getTenantDetails() throws IOException, InterruptedException {
		logger = extent.startTest(this.getClass().getSimpleName());
		CompanyDetails companyDetails = nbi.getTenantDetails(tenantCuid);
		Assert.assertTrue(
				companyDetails.getName().contentEquals(tenantName) && companyDetails.getCUID().contentEquals(tenantCuid)
						&& companyDetails.getEnvironmentUrl().contentEquals(Constants.CORE_SERVICE));
		logger.log(LogStatus.PASS, "TEST_942_getTenantDetails Completed");
		log.debug("TEST_942_getTenantDetails Completed");
	}

	/*
	 * UPDATE TENANT TEST
	 */
	@Test(priority = 3, enabled = false)
	public void TEST_87_updateTenant() throws IOException, InterruptedException {
		logger = extent.startTest(this.getClass().getSimpleName());
		nbi.updateTenant(tenantId, tenantName + "-new");
		Assert.assertEquals(nbi.getTenantDetails(tenantCuid).getName(), tenantName + "-new");
		logger.log(LogStatus.PASS, "TEST_87_UpdateTenantCompleted");
		log.debug("TEST_87_UpdateTenant Completed");
	}

	/*
	 * UPDATE TENANT TEST
	 */

	@Test(priority = 4, enabled = false)
	public void TEST_85_updateTenantOptions() throws IOException, InterruptedException {
		logger = extent.startTest(this.getClass().getSimpleName());
		String key = "AllowTransformation";
		nbi.updateTenantOptions(tenantId, key, "Yes");
		Options[] option = nbi.getTenantOptionsDetails(tenantId);
		String value = null;
		for (Options obj : option) {
			if (obj.getKey().equals(key)) {
				value = obj.getValue();
			}
		}
		Assert.assertEquals(value, "Yes");
		logger.log(LogStatus.PASS, "TEST_85_UpdateTenantOptions Completed");
		log.debug("TEST_85_UpdateTenantOptions Completed");
	}

	@Test(priority = 5, enabled = true)
	public void TEST_1088_getAllTenant() throws IOException, InterruptedException {
		logger = extent.startTest(this.getClass().getSimpleName());
		int status = nbi.getAllTenantList();
		Assert.assertTrue(200 <= status & status <= 205);
		logger.log(LogStatus.PASS, "TEST_1088_getAllTenant Completed");
		log.debug("TEST_1088_getAllTenant Completed");
	}

	@Test(priority = 6, enabled = false)
	public void TEST_00_getUserProfile() throws IOException, InterruptedException {
		logger = extent.startTest(this.getClass().getSimpleName());
		int status = nbi.getUserProfile();
		Assert.assertTrue(200 <= status & status <= 205);
		logger.log(LogStatus.PASS, "getUserProfile Completed");
		log.debug("getUserProfile Completed");
	}

	@Test(priority = 7, enabled = false)
	public void TEST_00_isAdmin() throws IOException, InterruptedException {
		logger = extent.startTest(this.getClass().getSimpleName());
		int status = nbi.isAdmin();
		Assert.assertTrue(200 <= status & status <= 205);
		logger.log(LogStatus.PASS, "isAdmin Completed");
		log.debug("isAdmin Completed");
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
