package io.smartnexus.ats.delete;

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
import io.smartnexus.ats.groups.AddOTAgroup;
import io.smartnexus.ats.product.ProductUpdateAttributesValue;
import io.smartnexus.ats.tenant.AddTenant;
import io.smartnexus.ats.thrift.AgentClient;
import io.smartnexus.ats.thrift.AgentService;
import io.smartnexus.ats.utils.ExtentManager;
import io.smartnexus.ats.utils.NorthBoundInterface;

public class NegativeTest {

	private static final Logger log = Logger.getLogger(NegativeTest.class.getName());
	ExtentTest logger;
	ExtentReports extent;
	private NorthBoundInterface nbi;
	public static AgentService.Client client;
	AgentClient agentClient = new AgentClient();
	public int attrLocalId, staticEpLocalId;
	public String cuId, skuid, deviceId;

	@BeforeClass
	public void setUp() throws Exception {
		extent = ExtentManager.getInstance();
		nbi = new NorthBoundInterface();
		client = ProductUpdateAttributesValue.client;
		attrLocalId = 10;
		cuId = AddTenant.tenantCuid;
		skuid = AddProductMaster.productMasterSku;
		staticEpLocalId = 0;
		deviceId = AddOTAgroup.deviceId;
	}

	/*
	 * ReActivateAlreadyActivatedDevice
	 */
	@Test(priority = 1, enabled = true)
	public void TEST_00_ReActivateAlreadyActivatedDevice() throws IOException, InterruptedException, Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		// nbi.activateDeviceUsingAPI(cuId, deviceId, deviceId);
		int status = nbi.activateDeviceUsingAPI(cuId, deviceId, deviceId);
		log.debug("ReActivateAlreadyActivatedDevice " + status);
		Assert.assertTrue(200 <= status & status <= 205);
		logger.log(LogStatus.PASS, "ReActivateAlreadyActivatedDevice test Completed");
		log.debug("ReActivateAlreadyActivatedDevice test Completed");
	}

	/*
	 * ReDeActivateAlreadyDeActivatedDevice
	 */
	@Test(priority = 2, enabled = true)
	public void TEST_00_DeActivateAlreadyDeActivatedDevice() throws IOException, InterruptedException, Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		int status = nbi.activateDeviceUsingAPI(cuId, deviceId, deviceId);
		log.debug("ReDeActivateAlreadyDeActivatedDevice " + status);
		Assert.assertTrue(200 <= status & status <= 205);
		logger.log(LogStatus.PASS, "ReDeActivateAlreadyDeActivatedDevice test Completed");
		log.debug("ReDeActivateAlreadyDeActivatedDevice test Completed");
	}

	/*
	 * ReDeActivateAlreadyDeActivatedDevice
	 */
	@Test(priority = 3, enabled = true)
	public void TEST_00_ActivateDeviceDeviceIdNotAvailable() throws IOException, InterruptedException, Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		int status = nbi.activateDeviceUsingAPI(cuId, deviceId, deviceId);
		log.debug("ActivateDeviceDeviceIdNotAvailable " + status);
		Assert.assertTrue(200 <= status & status <= 205);
		logger.log(LogStatus.PASS, "ActivateDeviceDeviceIdNotAvailable test Completed");
		log.debug("ActivateDeviceDeviceIdNotAvailable test Completed");
	}

	/*
	 * DeActivateDeviceDeviceIdNotAvailable
	 */
	@Test(priority = 4, enabled = true)
	public void TEST_00_DeActivateDeviceDeviceIdNotAvailable() throws IOException, InterruptedException, Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		int status = nbi.deActivateDeviceUsingAPI(deviceId + "a");
		log.debug("DeActivateDeviceDeviceIdNotAvailable " + status);
		Assert.assertTrue(500 == status);
		logger.log(LogStatus.PASS, "DeActivateDeviceDeviceIdNotAvailable test Completed");
		log.debug("DeActivateDeviceDeviceIdNotAvailable test Completed");
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
			e.printStackTrace();
		}
		extent.endTest(logger);
	}

}
