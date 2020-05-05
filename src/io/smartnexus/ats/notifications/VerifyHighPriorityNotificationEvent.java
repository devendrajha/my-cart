package io.smartnexus.ats.notifications;

import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
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
import io.smartnexus.ats.utils.ExtentManager;
import io.smartnexus.ats.utils.NorthBoundInterface;
import junit.framework.Assert;

public class VerifyHighPriorityNotificationEvent {

	private static final Logger log = Logger.getLogger(VerifyHighPriorityNotificationEvent.class.getName());
	ExtentTest logger;
	ExtentReports extent;
	public NorthBoundInterface nbi;
	public static AgentService.Client client;
	AgentClient agentClient = new AgentClient();
	public int localId, staticEpLocalId, settingFid, attributeId;
	public String skuId, cUid, productMasterID;
	static CommonUtils cu = new CommonUtils();

	@BeforeClass
	public void setUp() throws Exception {
		extent = ExtentManager.getInstance();
		nbi = new NorthBoundInterface();
		client = ProductUpdateAttributesValue.client;
		staticEpLocalId = 0;
		productMasterID = AddProductMaster.productMasterId;
		attributeId = settingFid = cu.generateRandomID() + cu.generateRandomID();
		cUid = AddTenant.tenantCuid;
		skuId = AddProductMaster.productMasterSku;
	}

	/*
	 * Activate Product Notification generation
	 */
	@Test(priority = 1, enabled = false)
	public void TEST_953_changeAttributeValueNotificationWithHighPriority() throws Exception {
		logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
		agentClient.sendAttrValueForJsonDataType(client, staticEpLocalId, 10, "{\"priority\":\"High\"}", 1);
		String message = nbi.getWHNotificationForAttrValue(skuId,1);
		Assert.assertTrue(message.contains("Json"));
		logger.log(LogStatus.PASS, "changeAttributeValueNotificationWithHighPriority test Completed");
		log.debug("changeAttributeValueNotificationWithHighPriority test Completed");

	}

	/*
	 * Activate Product Notification generation
	 */
	@Test(priority = 2, enabled = true)
	public void TEST_954_changesSettingValueNotificationWithHighPriority() throws Exception {
		logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
		agentClient.sendSettValueForJsonDataType(client, staticEpLocalId, 10, "{\"B\":\"1\"}", 1);
		List<Object> message = nbi.getWebhookNotificationWithHighPriority(cUid);
		Assert.assertTrue(message.contains("Setting Value Update With High Priority"));
		logger.log(LogStatus.PASS, "changesSettingValueNotificationWithHighPriority test Completed");
		log.debug("changesSettingValueNotificationWithHighPriority test Completed");

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
