package io.smartnexus.ats.groups;

import org.apache.log4j.Logger;
import org.apache.thrift.TException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.smartnexus.ats.configure.product.AddProductMaster;
import io.smartnexus.ats.packagemanager.AddFullBundle;
import io.smartnexus.ats.tenant.AddTenant;
import io.smartnexus.ats.utils.ExtentManager;
import io.smartnexus.ats.utils.NorthBoundInterface;
import junit.framework.Assert;

public class AddOTAgroup {
	private static final Logger log = Logger.getLogger(AddOTAgroup.class.getName());
	ExtentTest logger;
	ExtentReports extent;
	public static String skuId,deviceId,serialNumber,otaGroupIdwithSchedule,otaGroupIdwithoutSchedule;
	private String cUid, packageGroupId;
	private NorthBoundInterface nbi;

	@BeforeClass

	public void setUp() throws Exception {
		extent = ExtentManager.getInstance();
		nbi = new NorthBoundInterface();
		skuId = AddProductMaster.productMasterSku;
		cUid = AddTenant.tenantCuid;
		packageGroupId = AddFullBundle.packageGroupId;
		deviceId = serialNumber = "ID" + System.currentTimeMillis();
	}

	/*
	 * ADD OTA GROUP API test
	 */

	@Test(priority = 1, enabled = true)
	public void TEST_1038_addOTAGroupWithoutSchedule() throws Exception {
		logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
		String response = nbi.addOTAGroup(packageGroupId, false);
		String[] s1 = response.split(",");
		int status = Integer.parseInt(s1[0]);
		otaGroupIdwithoutSchedule = s1[1];
		Assert.assertTrue(status >= 200 && status < 205);
		logger.log(LogStatus.PASS, " addOTAGroup test Completed");
		log.debug("addOTAGroup test Completed");

	}

	/*
	 * ADD OTA GROUP API test
	 */

	@Test(priority = 2, enabled = true)
	public void TEST_1039_addOTAGroupWithSchedule() throws Exception {
		logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
		String response = nbi.addOTAGroup(packageGroupId, true);
		String[] s1 = response.split(",");
		int status = Integer.parseInt(s1[0]);
		otaGroupIdwithSchedule = s1[1];
		Assert.assertTrue(status >= 200 && status < 205);
		logger.log(LogStatus.PASS, " addOTAGroup test Completed");
		log.debug("addOTAGroup test Completed");

	}

	@Test(priority = 3, enabled = true)
	public void TEST_580_addProduct() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		int status = nbi.addProduct(cUid, skuId, deviceId, serialNumber);
		Assert.assertTrue(200 <= status && status <= 205);
		logger.log(LogStatus.PASS, "addProduct test Completed");
		log.debug("addProduct test Completed");

	}

	/*
	 * ADD device GROUP API test
	 */

	@Test(priority = 4, enabled = true)
	public void TEST_1039_adddevice() throws Exception {
		logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
		int status = nbi.addProductToOTAGroup(otaGroupIdwithSchedule, deviceId);
		Assert.assertTrue(status >= 200 && status < 205);
		logger.log(LogStatus.PASS, " TEST_1039_adddevice test Completed");
		log.debug("TEST_1039_adddevice test Completed");

	}

	/*
	 * update OTA GROUP API test
	 */

	@Test(priority = 2, enabled = false)
	public void TEST_00_updateOTAGroup() throws Exception {
		logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
		String response = nbi.updateOTAGroup(cUid, packageGroupId, otaGroupIdwithSchedule);
		String[] s1 = response.split(",");
		int status = Integer.parseInt(s1[0]);
		Assert.assertTrue(status >= 200 && status < 205);
		logger.log(LogStatus.PASS, "add updatePackageGroup test Completed");
		log.debug("add updatePackageGroup test Completed");

	}

	/*
	 * ACTIVATE PRODUCT TEST
	 * @Step Pickup added Product from previous test
	 * @Step Use HTTS end point URL to activate Product from Back-end
	 * @Step Verify Product shows Active on portal UI
	 */

	@Test(priority = 5, enabled = true)
	public void TEST_581_activateProduct() throws Exception {
		logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
		int status = nbi.activateDeviceUsingAPI(cUid, deviceId, serialNumber);
		Assert.assertTrue(200 <= status && status <= 205);
		logger.log(LogStatus.PASS, "activateProduct test Completed");
		log.debug("activateProduct test Completed");

	}

	/*
	 * GET RESPONSE AFTER SYNC OF PRODUCT TEST
	 */
	@Test(priority = 6, enabled = true)
	public void TEST_585_deviceSyncUsingApi() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		int status = nbi.deviceSyncUsingApi(cUid, deviceId, serialNumber);
		Assert.assertTrue(200 <= status && status <= 205);
		logger.log(LogStatus.PASS, "TEST_585_productFullSync Completed");
		log.debug("FullSync Completed");

	}

	/*
	 * ADD OTA GROUP API test
	 */

	@Test(priority = 3, enabled = false)
	public void TEST_00_addProductToOTA() throws Exception {
		logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
		String response = nbi.addProductsToOTAGroup(cUid, "970f1a9d-9786-4ae9-ad0d-bf2d934b5663", "40");
		String[] s1 = response.split(",");
		int status = Integer.parseInt(s1[0]);
		Assert.assertTrue(status >= 200 && status < 205);
		logger.log(LogStatus.PASS, "add addProductToOTA test Completed");
		log.debug("add addProductToOTA test Completed");

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
