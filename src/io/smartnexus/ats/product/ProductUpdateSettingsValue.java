package io.smartnexus.ats.product;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.smartnexus.ats.thrift.AgentClient;
import io.smartnexus.ats.thrift.AgentService;
import io.smartnexus.ats.utils.ExtentManager;
import io.smartnexus.ats.utils.NorthBoundInterface;

public class ProductUpdateSettingsValue {

	private static final Logger log = Logger.getLogger(ProductUpdateSettingsValue.class.getName());
	ExtentTest logger;
	ExtentReports extent;
	String UserFieldName;
	AgentService.Client client;
	AgentClient agentClient = new AgentClient();
	private int productEpLocalId;
	private NorthBoundInterface nbi;
	private int intValue;
	private String virtualId;

	// LoginAs Administrator
	@BeforeClass
	public void setUp(){
		extent = ExtentManager.getInstance();
		client = ProductUpdateAttributesValue.client;
		productEpLocalId = 0;
		nbi = new NorthBoundInterface();
		virtualId = ProductUpdateAttributesValue.virtualProdId;
	}

	/*
	 * SEND BOOLEAN SETTING VALUES FOR PRODUCT
	 * 
	 * @verify the search result
	 */
	@Test(priority = 1, enabled = true)
	public void TEST_610_sendBooleanTypeValueforProduct(){
		logger = extent.startTest(this.getClass().getSimpleName());
		int value = 1;
		agentClient.sendSettValueForBooleanDataType(client, productEpLocalId, 1, value);
		Assert.assertTrue(nbi.getProductSettingValue(virtualId, 1).contains(value + ""));
		logger.log(LogStatus.PASS, "sendSettValueForBooleanDataType test Completed");
		log.debug("sendSettValueForBooleanDataType test Completed");
	}

	/*
	 * SEND INT SETTING VALUES FOR PRODUCT USING AGENT
	 * 
	 * @verify the search result
	 */
	@Test(priority = 2, enabled = true)
	public void TEST_611_sendIntTypeValueforProduct() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		intValue = 23352;
		agentClient.sendSettValueForIntegerDataType(client, productEpLocalId, 2, intValue);
		Assert.assertTrue(nbi.getProductSettingValue(virtualId, 2).contains(intValue + ""));
		logger.log(LogStatus.PASS, "sendSettValueForIntegerDataType Completed");
		log.debug("sendSettValueForIntegerDataType Completed");
	}

	@Test(priority = 3, enabled = true)
	public void TEST_649_verifySettingHistoryStatus() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		String response = nbi.settingHistory(virtualId, 2);
		String[] s1 = response.split(",");
		String fieldValue = s1[0];
		String createdBy = s1[1];
		String status = s1[2];
		Assert.assertTrue(Integer.parseInt(fieldValue) == intValue & status.contains("Success") & createdBy.contains("Agent"));
		logger.log(LogStatus.PASS, "verifySettingHistoryStatus test Completed");
		log.debug("verifySettingHistoryStatus test Completed");
	}

	/*
	 * SEND BOOLEAN SETTING VALUES FOR PRODUCT
	 * 
	 * @verify the search result
	 */
	@Test(priority = 4, enabled = true)
	public void TEST_00_sendSettingValueFromPortal() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		String value = "12345";
		nbi.sendSettingValues(virtualId, "2", value);
		String response = nbi.settingHistory(virtualId, 2);
		String[] s1 = response.split(",");
		String fieldValue = s1[0];
		String createdBy = s1[1];
		String status = s1[2];
		Assert.assertTrue(fieldValue.contains(value) & status.contains("Pending") & createdBy.contains("Flex Agent"));
		logger.log(LogStatus.PASS, "sendSettingValueFromPortal test Completed");
		log.debug("sendSettingValueFromPortal test Completed");
	}

	/*
	 * SEND BYTE SETTING VALUES FOR PRODUCT USING AGENT
	 * 
	 * @verify the search result
	 */
	@Test(priority = 5, enabled = false)
	public void TEST_612_sendByteTypeValueforProduct() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		byte value = (byte) 45;
		String response = agentClient.sendSettValueForByteDataType(client, productEpLocalId, 3, value);
		Assert.assertEquals("OK", response);
		logger.log(LogStatus.PASS, "sendSettValueForByteDataType test Completed");
		log.debug("sendSettValueForByteDataType test Completed");
	}

	/*
	 * SEND DECIMAL SETTING VALUES FOR PRODUCT USING AGENT
	 * 
	 * @verify the search result
	 */
	@Test(priority = 6, enabled = false)
	public void TEST_613_sendDecimalTypeValueforProduct() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		double value = 10.42;
		String response = agentClient.sendSettValueForDecimalDataType(client, productEpLocalId, 4, value);
		Assert.assertEquals("OK", response);
		logger.log(LogStatus.PASS, "sendSettValueForDecimalDataType test Completed");
		log.debug("sendSettValueForDecimalDataType test Completed");
	}

	/*
	 * SEND BIGINT SETTING VALUES FOR PRODUCT USING AGENT
	 * 
	 * @verify the search result
	 */
	@Test(priority = 7, enabled = false)
	public void TEST_614_sendBigIntTypeValueforProduct() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		long value = 9985694;
		String response = agentClient.sendSettValueForBigIntDataType(client, productEpLocalId, 5, value);
		Assert.assertEquals("OK", response);
		logger.log(LogStatus.PASS, "sendSettValueForBigIntDataType test Completed");
		log.debug("sendSettValueForBigIntDataType test Completed");
	}

	/*
	 * SEND STRING SETTING VALUES FOR PRODUCT USING AGENT
	 * 
	 * @verify the search result
	 */
	@Test(priority = 8, enabled = true)
	public void TEST_615_sendStringTypeValueforProduct() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		String value = "test1";
		String response = agentClient.sendSettValueForStringDataType(client, productEpLocalId, 6, value,0);
		Assert.assertEquals("OK", response);
		logger.log(LogStatus.PASS, "sendSettValueForStringDataType test Completed");
		log.debug("sendSettValueForStringDataType test Completed");
	}

	/*
	 * SEND FLOAT SETTING VALUES FOR PRODUCT USING AGENT
	 * 
	 * @verify the search result
	 */
	@Test(priority = 9, enabled = false)
	public void TEST_616_sendFloatTypeValueforProduct() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		float value = (float) 10.456;
		String response = agentClient.sendSettValueFloatDataType(client, productEpLocalId, 7, value);
		Assert.assertEquals("OK", response);
		logger.log(LogStatus.PASS, "sendSettValueFloatDataType test Completed");
		log.debug("sendSettValueFloatDataType test Completed");
	}

	/*
	 * SEND DOUBLE SETTING VALUES FOR PRODUCT USING AGENT
	 * 
	 * @verify the search result
	 */
	@Test(priority = 10, enabled = false)
	public void TEST_617_sendDoubleTypeValueforProduct() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		double value = 1234567776;
		String response = agentClient.sendSettingValForDoubleDataType(client, productEpLocalId, 8, value);
		Assert.assertEquals("OK", response);
		logger.log(LogStatus.PASS, "sendSettingValForDoubleDataType test Completed");
		log.debug("sendSettingValForDoubleDataType test Completed");
	}

	/*
	 * SEND LDOUBLE SETTING VALUES FOR PRODUCT USING AGENT
	 * 
	 * @verify the search result
	 */
	@Test(priority = 11, enabled = false)
	public void TEST_618_sendLDoubleTypeValueforProduct() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		double value = 81165;
		String response = agentClient.sendSettingValForLdoubleDataType(client, productEpLocalId, 9, value);
		Assert.assertEquals("OK", response);
		logger.log(LogStatus.PASS, "sendLDoubleTypeValueforProduct test Completed");
		log.debug("sendLDoubleTypeValueforProduct test Completed");
	}
	
	/*
	 * SEND LDOUBLE SETTING VALUES FOR PRODUCT USING AGENT
	 * 
	 * @verify the search result
	 */
	@Test(priority = 12, enabled = true)
	public void TEST_618_sendJsonTypeValueforProduct() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		String value  = "{\"cuId\":\"GEOTAB\",\"data\":{\"deviceId\":\"IAT030\",\"localId\":1,\"mfgId\":null,\"name\":\"LocationData\",\"peripheralId\":null,\"serialNum\":\"ABCD12345678901234567890\",\"sku\":\"None\",\"value\":{\"event\":[{\"type\":\"moving\"}],\"location\":{\"accuracy\":18.371,\"altitude\":116.937,\"bearing\":347.22994,\"floor\":0,\"latitude\":40.4071672,\"longitude\":-77.0102154,\"source\":\"gps\",\"speed\":1817},\"sensors\":{\"battery\":{\"charging\":false,\"current\":-41,\"extpower\":false,\"percent\":100,\"solarma\":12,\"solarmv\":13,\"temp\":21.2,\"voltage\":4020}}}},\"message\":null,\"messageType\":0,\"priority\":0,\"timeStamp\":\"2019-09-18T01:45:31+00:00\"}";
		
		String response = agentClient.sendSettValueForJsonDataType(client, productEpLocalId, 10, value,0);
		Thread.sleep(1000);
		Assert.assertEquals("OK", response);
		logger.log(LogStatus.PASS, "sendSettValueForJsonDataType test Completed");
		log.debug("sendSettValueForJsonDataType test Completed");
	}

	/*
	 * SEND BOOLEAN SETTING VALUES FOR PRODUCT
	 * 
	 * @verify the search result
	 */
	@Test(priority = 13, enabled = true)
	public void TEST_00_sendSettingIntValueFromPortal() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		String value = "1";
		nbi.sendSettingValues(virtualId, "1", value);
		String response = nbi.settingHistory(virtualId, 1);
		String[] s1 = response.split(",");
		String fieldValue = s1[0];
		String createdBy = s1[1];
		String status = s1[2];
		Assert.assertTrue(fieldValue.contains(value) & status.contains("Pending") & createdBy.contains("Flex Agent"));
		logger.log(LogStatus.PASS, "sendSettingValueFromAPI test Completed");
		log.debug("sendSettingValueFromAPI test Completed");
	}

	/*
	 * SEND BOOLEAN SETTING VALUES FOR PRODUCT
	 * 
	 * @verify the search result
	 */
	@Test(priority = 14, enabled = false)
	public void TEST_00_sendSettingStringValueFromPortal() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		String value = "{\"cuId\":\"GEOTAB\",\"data\":{\"deviceId\":\"IAT030\",\"localId\":1,\"mfgId\":null,\"name\":\"LocationData\",\"peripheralId\":null,\"serialNum\":\"ABCD12345678901234567890\",\"sku\":\"None\",\"value\":{\"event\":[{\"type\":\"moving\"}],\"location\":{\"accuracy\":18.371,\"altitude\":116.937,\"bearing\":347.22994,\"floor\":0,\"latitude\":40.4071672,\"longitude\":-77.0102154,\"source\":\"gps\",\"speed\":1817},\"sensors\":{\"battery\":{\"charging\":false,\"current\":-41,\"extpower\":false,\"percent\":100,\"solarma\":12,\"solarmv\":13,\"temp\":21.2,\"voltage\":4020}}}},\"message\":null,\"messageType\":0,\"priority\":0,\"timeStamp\":\"2019-09-18T01:45:31+00:00\"}";
		nbi.sendSettingValues(virtualId, "10", value);
		String response = nbi.settingHistory(virtualId, 10);
		String[] s1 = response.split(",");
		String fieldValue = s1[0];
		String createdBy = s1[1];
		String status = s1[2];
		Assert.assertTrue( status.contains("Pending") & createdBy.contains("Flex Agent"));
		logger.log(LogStatus.PASS, "sendSettingStringValueFromPortal test Completed");
		log.debug("sendSettingStringValueFromPortal test Completed");
	}

	/*
	 * SEND BOOLEAN SETTING VALUES FOR PRODUCT
	 * 
	 * @verify the search result
	 */
	@Test(priority = 15, enabled = false)
	public void TEST_00_sendSettingJsonValueFromPortal() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		String value = "Value";
		nbi.sendSettingValues(virtualId, "6", value);
		String response = nbi.settingHistory(virtualId, 6);
		String[] s1 = response.split(",");
		String fieldValue = s1[0];
		String createdBy = s1[1];
		String status = s1[2];
		Assert.assertTrue(fieldValue.contains("Value") & status.contains("Pending") & createdBy.contains("Flex Agent"));
		logger.log(LogStatus.PASS, "sendSettingStringValueFromPortal test Completed");
		log.debug("sendSettingStringValueFromPortal test Completed");
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
