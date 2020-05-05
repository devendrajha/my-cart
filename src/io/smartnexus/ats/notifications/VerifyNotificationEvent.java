package io.smartnexus.ats.notifications;

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
import io.smartnexus.ats.configure.product.ConfigureProductNotificationWithLowPriority;
import io.smartnexus.ats.product.ProductUpdateAttributesValue;
import io.smartnexus.ats.tenant.AddTenant;
import io.smartnexus.ats.thrift.AgentClient;
import io.smartnexus.ats.thrift.AgentService;
import io.smartnexus.ats.utils.CommonUtils;
import io.smartnexus.ats.utils.Constants;
import io.smartnexus.ats.utils.ExtentManager;
import io.smartnexus.ats.utils.NorthBoundInterface;
import junit.framework.Assert;

public class VerifyNotificationEvent {

	private static final Logger log = Logger.getLogger(VerifyNotificationEvent.class.getName());
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
	 * Generate Add/edit Attribute definition Action for Notification generation
	 */
	@Test(priority = 1, enabled = false)
	public void TEST_264_addProductStringAttribute() throws Exception {
		logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
		nbi.addProductAttribute(productMasterID, attributeId, "String");
		Set<String> message = nbi.getWebhookNotification(skuId);
		Assert.assertTrue(message.contains("Change Attribute Definition"));
		logger.log(LogStatus.PASS, "addProductStringAttribute test Completed");
		log.debug("addProductStringAttribute test Completed");
	}

	/*
	 * Generate Add/edit Settings definition Action for Notification generation
	 */
	@Test(priority = 2, enabled = false)
	public void TEST_288_changeSettingDefinitionTemplate() throws Exception {
		logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
		nbi.addProductsetting(productMasterID, settingFid, "String", Constants.TEXT);
		Set<String> message = nbi.getWebhookNotification(skuId);
		Assert.assertTrue(message.contains("Change Setting Definition"));
		logger.log(LogStatus.PASS, "ChangeSettingDefinitionTemplate test Completed");
		log.debug("ChangeSettingDefinitionTemplate test Completed");

	}

	@Test(priority = 3, enabled = false)
	public void TEST_305_changeCommandDefinitionTemplate() throws Exception {
		logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
		nbi.addProductCommands("changeCommandDefinitionTemplate",productMasterID, 1, Constants.INT);
		Set<String> message = nbi.getWebhookNotification(skuId);
		Assert.assertTrue(message.contains("Change Command Definition"));
		logger.log(LogStatus.PASS, "changeCommandDefinitionTemplate test Completed");
		log.debug("changeCommandDefinitionTemplate test Completed");
	}

	/*
	 * Activate Product Notification generation
	 */
	@Test(priority = 4, enabled = true)
	public void TEST_952_activateProductNotification() throws Exception {
		logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
		Set<String> message = nbi.getWebhookNotification(skuId);
		Assert.assertTrue(message.contains("Device Activated"));
		logger.log(LogStatus.PASS, "activateProductNotification test Completed");
		log.debug("activateProductNotification test Completed");

	}

	/*
	 * Activate Product Notification generation
	 */
	@Test(priority = 5, enabled = false)
	public void TEST_953_changeAttributeValueNotification() throws Exception {
		logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
		agentClient.sendAttrValueForStringDataType(client, staticEpLocalId, 6, "value",0);
		String message = nbi.getWHNotificationForAttrValue(skuId,0);
		Assert.assertTrue(message.contains("Json"));
		logger.log(LogStatus.PASS, "ChangeAttributeValueNotification test Completed");
		log.debug("ChangeAttributeValueNotification test Completed");

	}

	/*
	 * Activate Product Notification generation
	 */
	@Test(priority = 6, enabled = true)
	public void TEST_954_updateSettingValueNotificationwithNormalPriority() throws Exception {
		logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
		agentClient.sendSettValueForStringDataType(client, staticEpLocalId, 6, "value send from Agent",0);
		Set<String> message = nbi.getWebhookNotification(skuId);
		Assert.assertTrue(message.contains("Setting Value Update"));
		logger.log(LogStatus.PASS, "ChangesSettingValueNotification test Completed");
		log.debug("ChangesSettingValueNotification test Completed");

	}

	/*
	 * De Activate Product Notification generation
	 */
	@Test(priority = 7, enabled = false)
	public void TEST_1012_deActivateDevice() throws Exception {
		logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
		String response = agentClient.deactivate(client);
		Assert.assertEquals("OK", response);
		logger.log(LogStatus.PASS, "De Activate Product Notification test Completed");
		log.debug("De Activate Product Notification test Completed");

	}

	/*
	 * De Activate Product Notification generation
	 */
	@Test(priority = 8, enabled = false)
	public void TEST_340_deActivateDeviceNotificatio() throws Exception {
		logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
		Thread.sleep(18000);
		Set<String> message = nbi.getWebhookNotification(skuId);
		Assert.assertTrue(message.contains("Deactivate Product"));
		logger.log(LogStatus.PASS, "DeActivate Device Notificatio test Completed");
		log.debug("De Activate Product Notification test Completed");

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
