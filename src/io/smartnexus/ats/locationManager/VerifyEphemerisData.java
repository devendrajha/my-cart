package io.smartnexus.ats.locationManager;

import org.apache.log4j.Logger;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
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
import io.smartnexus.ats.utils.CommonUtils;
import io.smartnexus.ats.utils.Constants;
import io.smartnexus.ats.utils.ExtentManager;
import io.smartnexus.ats.utils.NorthBoundInterface;

public class VerifyEphemerisData {

	private static final Logger log = Logger.getLogger(VerifyEphemerisData.class.getName());
	ExtentTest logger;
	ExtentReports extent;
	private NorthBoundInterface nbi;
	private String productLineID, SKUID, cuId, deviceId, serialNumber, vpId;
	static String agent_host = "127.0.0.1";
	static int agent_port = 9999;
	public static int localId, staticEpLocalId;
	public String path;
	public static AgentService.Client client;
	AgentClient agentClient = new AgentClient();
	static CommonUtils cu = new CommonUtils();

	// LoginAs Administrator
	@BeforeClass

	public void setUp() {
		extent = ExtentManager.getInstance();
		client = ProductUpdateAttributesValue.client;
		nbi = new NorthBoundInterface();
		SKUID = AddProductMaster.productMasterSku;
		productLineID = AddProductMaster.productMasterId;
		cuId = AddTenant.tenantCuid;
		serialNumber = deviceId = "DN" + System.currentTimeMillis();
		path = System.getProperty("user.dir");
		staticEpLocalId = 0;
	}

	@Test(priority = 1, enabled = true)
	public void TEST_580_addProduct() throws Exception {
		logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
		int status = nbi.addProduct(cuId, SKUID, deviceId, serialNumber);
		Assert.assertTrue(200 <= status & status <= 205);
		logger.log(LogStatus.PASS, "addProduct test Completed");
		log.debug("addProduct test Completed");

	}

	/*
	 * ACTIVATE PRODUCT TEST
	 * 
	 * @Step Pickup added Product from previous test
	 * 
	 * @Step Use HTTS end point URL to activate Product from Back-end
	 * 
	 * @Step Verify Product shows Active on portal UI
	 */

	@Test(priority = 2, enabled = true)
	public void TEST_581_activateProduct() throws Exception {
		logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
		int status = nbi.activateDeviceUsingAPI(cuId, deviceId, serialNumber);
		Assert.assertTrue(200 <= status & status <= 205);
		// String reponse = agentClient.activateProduct(client, serialNumber, deviceId);
		// Assert.assertEquals("OK", reponse);
		logger.log(LogStatus.PASS, "activateProduct test Completed");
		log.debug("activateProduct test Completed");

	}

	@Test(priority = 3, enabled = true)
	public void TEST_922_VerifyEphemerisURLonActivate() throws Exception {
		logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
		vpId = nbi.getvirtualProductID(productLineID, deviceId);
		Thread.sleep(900000);
		String settingsValue = nbi.getSettingValueEphemerisData(vpId, Constants.isOnline);
		Assert.assertEquals("Pending", settingsValue);
		logger.log(LogStatus.PASS, "TEST_922_VerifyEphemerisURLonActivation test Completed");
		log.debug("TEST_922_VerifyEphemerisURLonActivation test Completed");

	}

	@Test(priority = 4, enabled = false)
	public void TEST_582_connectProduct() {
		logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
		String reponse = agentClient.productConnect(client);
		Assert.assertEquals("OK", reponse);
		logger.log(LogStatus.PASS, "connectProduct test Completed");
		log.debug("connectProduct test Completed");

	}

	@Test(priority = 5, enabled = false)
	public void TEST_922A_VerifyEphemerisURLStatusOnConnect() throws Exception {
		logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
		Thread.sleep(1100000);
		String settingsValue = nbi.getSettingValueEphemerisData(vpId, Constants.isOnline);
		String value, status = null;
		if (settingsValue != null && !settingsValue.isEmpty()) {
			String[] s1 = settingsValue.split(",");
			value = s1[0];
			status = s1[1];
		}
		Assert.assertEquals("Success", status);
		logger.log(LogStatus.PASS, "verifyEphemerisOfflineURL test Completed");
		log.debug("verifyEphemerisOfflineURL test Completed");
	}

	@Test(priority = 6, enabled = false)
	public void TEST_922B_verifyEphemerisOnlineURL() throws Exception {
		logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
		String currentVal = nbi.getSettingValueEphemerisData(vpId, Constants.isOnline);
		Assert.assertTrue(currentVal.contains("efs.smartnexus.io/ublox-online/"));
		logger.log(LogStatus.PASS, "verifyEphemerisOnlineURL test Completed");
		log.debug("verifyEphemerisOnlineURL test Completed");
	}

	@Test(priority = 7, enabled = false)
	public void TEST_922B_verifyEphemerisOfflineURL() throws Exception {
		logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
		String currentVal = nbi.getSettingValueEphemerisData(vpId, Constants.isOffline);
		Assert.assertTrue(currentVal.contains("efs.smartnexus.io/ublox-online/"));
		logger.log(LogStatus.PASS, "verifyEphemerisOnlineURL test Completed");
		log.debug("verifyEphemerisOnlineURL test Completed");
	}

	@Test(priority = 8, enabled = false)
	public void TEST_941_updateOfflineUrlusingAgent() throws TException {
		logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
		String value = "https://itest.efs.smartnexus.io/ublox-online/ublox-20180807145421.ubx";
		String reponse = agentClient.sendSettValueForStringDataType(client, staticEpLocalId, Constants.isOffline, value,0);
		Assert.assertEquals("OK", reponse);
		logger.log(LogStatus.PASS, "TEST_941_updateOfflineUrlusingAgent test Completed");
		log.debug("TEST_941_updateOfflineUrlusingAgent test Completed");

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
