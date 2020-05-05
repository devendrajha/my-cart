package io.smartnexus.ats.product;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.json.simple.parser.ParseException;
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
import io.smartnexus.ats.thrift.AgentClient;
import io.smartnexus.ats.thrift.AgentService;
import io.smartnexus.ats.utils.CommonUtils;
import io.smartnexus.ats.utils.ExtentManager;
import io.smartnexus.ats.utils.NorthBoundInterface;

public class ProductUpdateAttributesValue {
	private static final Logger log = Logger.getLogger(ProductUpdateAttributesValue.class.getName());
	ExtentTest logger;
	ExtentReports extent;
	public static String cUid, deviceId, serialNumber, cuid, sku,  virtualProdId, productMasterId = null;
	static String agent_host = "127.0.0.1";
	static int agent_port = 9999;
	public static int productEpLocalId;
	public TTransport transport;
	public TProtocol protocol;
	public static AgentService.Client client;
	AgentClient agentClient = new AgentClient();
	String mfgId = "mfg0E31";
	private NorthBoundInterface nbi;
	static CommonUtils cu = new CommonUtils();

	// LoginAs Administrator
	@BeforeClass

	public void setUp() {
		extent = ExtentManager.getInstance();
		deviceId = serialNumber = "ID" + System.currentTimeMillis();
		transport = new TSocket(agent_host, agent_port);
		try {
			transport.open();
		} catch (TTransportException  e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		cuid = AddTenant.tenantCuid;
		sku = AddProductMaster.productMasterSku;
		protocol = new TBinaryProtocol(transport);
		client = new AgentService.Client(protocol);
		productEpLocalId = 0;
		cUid = AddTenant.tenantCuid;
		productMasterId = AddProductMaster.productMasterId;
		nbi = new NorthBoundInterface();

	}

	@Test(priority = 1, enabled = true)
	public void TEST_580_addProduct() {
		logger = extent.startTest(this.getClass().getSimpleName());
		int status = nbi.addProduct(cuid, sku, deviceId, serialNumber);
		Assert.assertTrue(200 <= status & status <= 205);
		logger.log(LogStatus.PASS, "addProduct test Completed");
		log.debug("addProduct test Completed");

	}

	/*
	 * 
	 * @Step Pickup added Product from previous test
	 * 
	 * @Step Use HTTS end point URL to activate Product from Back-end
	 */

	@Test(priority = 2, enabled = true)
	public void TEST_581_activateProduct() {
		logger = extent.startTest(this.getClass().getSimpleName());
		String reponse = agentClient.activateProduct(client, serialNumber, deviceId);
		Assert.assertEquals("OK", reponse);
		logger.log(LogStatus.PASS, "TEST_581_activateProduct Completed");
		log.debug("TEST_581_activateProductCompleted");

	}

	/*
	 * Connect PRODUCT TEST
	 * @Step Pickup added Product from previous test
	 * @Step Use HTTS end point URL to Connect Activated Product from Back-end
	 */
	@Test(priority = 3, enabled = true)
	public void TEST_582_connectProduct(){
		logger = extent.startTest(this.getClass().getSimpleName());
		String reponse = agentClient.productConnect(client);
		//agentClient.Disconnect(client);reponse = agentClient.productConnect(client);
		Assert.assertEquals("OK", reponse);
		logger.log(LogStatus.PASS, "TEST_582_connectProduct Completed");
		log.debug("TEST_582_connectProduct Completed");

	}

	@Test(priority = 4, enabled = true)
	public void TEST_630_getVirtualProductId() {
		logger = extent.startTest(this.getClass().getSimpleName());
		virtualProdId = nbi.getvirtualProductID(productMasterId, deviceId);
		logger.log(LogStatus.PASS, "addVirtualProduct test Completed");
		log.debug("addVirtualProduct test Completed");

	}

	/*
	 * ADD DYNAMIC END POINT TEST
	 * 
	 * @Step Using Agent to add and activate Dynamic end point from device
	 * 
	 * @Step Verify Dynamic end point shows added and Active on portal UI
	 */
	@Test(priority = 5, enabled = false)
	public void TEST_584_addPeripheral() throws ParseException, IllegalStateException, IOException, TException {
		logger = extent.startTest(this.getClass().getSimpleName());
		int epId = agentClient.addDynamicEndpoint(client, mfgId);
		Assert.assertTrue(100 < epId);
		logger.log(LogStatus.PASS, "TEST_584_addPeripheral Completed");
		log.debug("TEST_584_addPeripheral Completed");
	}

	/*
	 * GET RESPONSE AFTER SYNC OF PRODUCT TEST
	 */
	@Test(priority = 6, enabled = true)
	public void TEST_585_productFullSync() throws InterruptedException, TException {
		logger = extent.startTest(this.getClass().getSimpleName());
		String sync = agentClient.productSync(client, 0);
		Assert.assertEquals(sync, "OK");
		logger.log(LogStatus.PASS, "TEST_585_productFullSync Completed");
		log.debug("FullSync Completed");

	}

	/*
	 * SEND BOOLEAN ATTRIBUTE VALUES FOR PRODUCT USING AGENT
	 * 
	 * @verify the search result
	 */
	@Test(priority = 7, enabled = true)
	public void TEST_588_sendBooleanAttrValueToProduct() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		int value = 1;
		agentClient.sendAttrValueForBooleanDataType(client, productEpLocalId, 1, value);
		Assert.assertEquals(value + "", nbi.getProductAttributeValue(virtualProdId, 1));
		logger.log(LogStatus.PASS, "TEST_588_sendBooleanAttrValueToProduct Completed");
		log.debug("TEST_588_sendBooleanAttrValueToProduct Completed");
	}

	/*
	 * SEND INT ATTRIBUTE VALUES FOR PRODUCT USING AGENT
	 * 
	 * @verify the search result
	 */
	@Test(priority = 8, enabled = true)
	public void TEST_589_sendIntAttrValueToProduct() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		int value = 6655;
		agentClient.sendAttrValueForIntegerDataType(client, productEpLocalId, 2, value);
		Assert.assertEquals(value + "", nbi.getProductAttributeValue(virtualProdId, 2));
		logger.log(LogStatus.PASS, "TEST_589_sendIntAttrValueToProduct Completed");
		log.debug("TEST_589_sendIntAttrValueToProduct Completed");
	}

	/*
	 * SEND BYTE ATTRIBUTE VALUES FOR PRODUCT USING AGENT
	 * 
	 * @verify the search result
	 */
	@Test(priority = 9, enabled = false)
	public void TEST_590_sendByteAttrValueToProduct() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		byte value = (byte) 45;
		agentClient.sendAttrValueForByteDataType(client, productEpLocalId, 3, value);
		Assert.assertEquals(value + "", nbi.getProductAttributeValue(virtualProdId, 3));
		logger.log(LogStatus.PASS, "sendByteAttrValueToProduct test Completed");
		log.debug("sendByteAttrValueToProduct test Completed");
	}

	/*
	 * SEND DECIMAL ATTRIBUTE VALUES FOR PRODUCT USING AGENT
	 * 
	 * @verify the search result
	 */
	@Test(priority = 10, enabled = false)
	public void TEST_591_sendDecimalAttrValueToProduct() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		double value = 10.62;
		agentClient.sendAttrValueForDecimalDataType(client, productEpLocalId, 4, value);
		Assert.assertTrue(nbi.getProductAttributeValue(virtualProdId, 4).contains(value + ""));
		logger.log(LogStatus.PASS, "sendDecimalAttrValueToProduct test Completed");
		log.debug("sendDecimalAttrValueToProduct test Completed");
	}

	/*
	 * SEND BIGINT ATTRIBUTE VALUES FOR PRODUCT USING AGENT
	 * 
	 * @verify the search result
	 */
	@Test(priority = 11, enabled = false)
	public void TEST_592_sendBigIntAttrValueToProduct() throws Exception {
		log.debug("Executing sendBigIntAttrValueToProduct test");
		logger = extent.startTest(this.getClass().getSimpleName());
		long value = 99854;
		agentClient.sendAttrValueForBigIntDataType(client, productEpLocalId, 5, value);
		Assert.assertEquals(value + "", nbi.getProductAttributeValue(virtualProdId, 5));
		logger.log(LogStatus.PASS, "sendBigIntAttrValueToProduct test Completed");
		log.debug("sendBigIntAttrValueToProduct test Completed");
	}

	/*
	 * SEND STRING ATTRIBUTE VALUES FOR PRODUCT USING AGENT
	 * 
	 * @verify the search result
	 */
	@Test(priority = 12, enabled = true)
	public void TEST_593_sendStringAttrValueToProduct() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		agentClient.sendAttrValueForStringDataType(client, productEpLocalId, 6, "Value",0);
		Assert.assertEquals("VmFsdWU=", nbi.getProductAttributeValue(virtualProdId, 6));
		logger.log(LogStatus.PASS, "TEST_593_sendStringAttrValueToProduct Completed");
		log.debug("TEST_593_sendStringAttrValueToProduct Completed");
	}

	/*
	 * SEND FLOAT ATTRIBUTE VALUES FOR PRODUCT USING AGENT
	 * 
	 * @verify the search result
	 */
	@Test(priority = 13, enabled = false)
	public void TEST_594_sendFloatAttrValueToProduct() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		float value = 10.41f;
		agentClient.sendAttrValueFloatDataType(client, productEpLocalId, 7, value);
		Assert.assertTrue(nbi.getProductAttributeValue(virtualProdId, 7).contains(value + ""));
		logger.log(LogStatus.PASS, "TEST_594_sendFloatAttrValueToProduct Completed");
		log.debug("TEST_594_sendFloatAttrValueToProduct Completed");
	}

	/*
	 * SEND DOUBLE ATTRIBUTE VALUES FOR PRODUCT USING AGENT
	 * 
	 * @verify the search result
	 */
	@Test(priority = 14, enabled = false)
	public void TEST_595_sendDoubleAttrValueToProduct() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		double value = 127776;
		agentClient.sendAttrValueForDoubleDataType(client, productEpLocalId, 8, value);
		Assert.assertTrue(nbi.getProductAttributeValue(virtualProdId, 8).contains(value + ""));
		logger.log(LogStatus.PASS, "TEST_595_sendDoubleAttrValueToProduct Completed");
		log.debug("TEST_595_sendDoubleAttrValueToProduct Completed");
	}

	/*
	 * SEND LDOUBLE ATTRIBUTE VALUES FOR PRODUCT USING AGENT
	 * 
	 * @verify the search result
	 */
	@Test(priority = 15, enabled = false)
	public void TEST_596_sendLDoubleAttrValueToProduct() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		double value = 89565;
		agentClient.sendAttrValueForLdoubleDataType(client, productEpLocalId, 9, value);
		Assert.assertTrue(nbi.getProductAttributeValue(virtualProdId, 9).contains(value + ""));
		logger.log(LogStatus.PASS, "TEST_596_sendLDoubleAttrValueToProduct Completed");
		log.debug("TEST_596_sendLDoubleAttrValueToProduct Completed");
	}

	/*
	 * Update Boolean ATTRIBUTE VALUES FOR PRODUCT USING AGENT
	 * 
	 * @verify the search result
	 */
	@Test(priority = 16, enabled = true)
	public void TEST_597_updateBooleanAttrValueToProduct() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		int value = 0;
		agentClient.updateAttrValueForBooleanDataType(client, productEpLocalId, 1, value);
		Assert.assertEquals(value + "", nbi.getProductAttributeValue(virtualProdId, 1));
		logger.log(LogStatus.PASS, "TEST_597_updateBooleanAttrValueToProduct Completed");
		log.debug("TEST_597_updateBooleanAttrValueToProduct Completed");
	}

	/*
	 * Update INT ATTRIBUTE VALUES FOR PRODUCT USING AGENT
	 * 
	 * @verify the search result
	 */
	@Test(priority = 17, enabled = true)
	public void TEST_598_updateIntAttrValueToProduct() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		int value = 22;
		agentClient.updateAttrValueForIntDataType(client, productEpLocalId, 2, value);
		//Assert.assertEquals(value + "", nbi.getProductAttributeValue(virtualProdId, 2));
		Assert.assertTrue(nbi.getProductAttributeValue(virtualProdId, 2).contains(value + ""));
		logger.log(LogStatus.PASS, "TEST_598_updateIntAttrValueToProduct Completed");
		log.debug("TEST_598_updateIntAttrValueToProduct Completed");
	}

	/*
	 * UPDATE BYTE ATTRIBUTE VALUES FOR PRODUCT USING AGENT
	 * 
	 * @verify the search result
	 */
	@Test(priority = 18, enabled = false)
	public void TEST_599_updateByteAttrValueToProduct() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		byte value = (byte) 90;
		agentClient.updateAttrValueForByteDataType(client, productEpLocalId, 3, value);
		Assert.assertEquals(value + "", nbi.getProductAttributeValue(virtualProdId, 3));
		logger.log(LogStatus.PASS, "TEST_599_updateByteAttrValueToProduct Completed");
		log.debug("TEST_599_updateByteAttrValueToProduct Completed");
	}

	/*
	 * UPDATE DECIMAL ATTRIBUTE VALUES FOR PRODUCT USING AGENT
	 * 
	 * @verify the search result
	 */
	@Test(priority = 19, enabled = false)
	public void TEST_600_updateDecimalAttrValueToProduct() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		double value = 90.68;
		agentClient.updateAttrValueForDecimalDataType(client, productEpLocalId, 4, value);
		Assert.assertTrue(nbi.getProductAttributeValue(virtualProdId, 4).contains(value + ""));
		logger.log(LogStatus.PASS, "TEST_600_updateDecimalAttrValueToProduct Completed");
		log.debug("TEST_600_updateDecimalAttrValueToProduct Completed");
	}

	/*
	 * UPDATE BIGINT ATTRIBUTE VALUES FOR PRODUCT USING AGENT
	 * 
	 * @verify the search result
	 */
	@Test(priority = 20, enabled = false)
	public void TEST_601_updateBigIntAttrValueToProduct() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		long value = 7788;
		agentClient.updateAttrValueForBigIntDataType(client, productEpLocalId, 5, value);
		Assert.assertEquals(value + "", nbi.getProductAttributeValue(virtualProdId, 5));
		logger.log(LogStatus.PASS, "TEST_601_updateBigIntAttrValueToProduct Completed");
		log.debug("TEST_601_updateBigIntAttrValueToProduct Completed");
	}

	/*
	 * UPDATE STRING ATTRIBUTE VALUES FOR PRODUCT USING AGENT
	 * 
	 * @verify the search result
	 */
	@Test(priority = 21, enabled = true)
	public void TEST_602_updateStringAttrValueToProduct() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		String value = "Value sent from Agent";
		agentClient.updateAttrValueForStringDataType(client, productEpLocalId, 6, value);
		Assert.assertEquals("VmFsdWUgc2VudCBmcm9tIEFnZW50", nbi.getProductAttributeValue(virtualProdId, 6));
		logger.log(LogStatus.PASS, "TEST_602_updateStringAttrValueToProduct Completed");
		log.debug("TEST_602_updateStringAttrValueToProduct Completed");
	}

	/*
	 * UPDATE FLOAT ATTRIBUTE VALUES FOR PRODUCT USING AGENT
	 * 
	 * @verify the search result
	 */
	@Test(priority = 22, enabled = false)
	public void TEST_603_updateFloatAttrValueToProduct() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		float value = 66.40f;
		agentClient.updateAttrValueForFloatDataType(client, productEpLocalId, 7, value);
		Assert.assertTrue(nbi.getProductAttributeValue(virtualProdId, 7).contains(value + ""));
		logger.log(LogStatus.PASS, "TEST_603_updateFloatAttrValueToProduct Completed");
		log.debug("TEST_603_updateFloatAttrValueToProduct Completed");
	}

	/*
	 * UPDATE DOUBLE ATTRIBUTE VALUES FOR PRODUCT USING AGENT
	 * 
	 * @verify the search result
	 */
	@Test(priority = 23, enabled = false)
	public void TEST_604_updateDoubleAttrValueToProduct() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		double value = 6666;
		agentClient.updateAttrValueForDoubleDataType(client, productEpLocalId, 8, value);
		Assert.assertTrue(nbi.getProductAttributeValue(virtualProdId, 8).contains(value + ""));
		logger.log(LogStatus.PASS, "TEST_604_updateDoubleAttrValueToProduct Completed");
		log.debug("TEST_604_updateDoubleAttrValueToProduct Completed");
	}

	/*
	 * UPDATE LDOUBLE ATTRIBUTE VALUES FOR PRODUCT USING AGENT
	 * 
	 * @verify the search result
	 */
	@Test(priority = 24, enabled = false)
	public void TEST_605_updateLDoubleAttrValueToProduct() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		double value = 97765.81;
		agentClient.updateAttrValueForLDoubleDataType(client, productEpLocalId, 9, value);
		Assert.assertTrue(nbi.getProductAttributeValue(virtualProdId, 9).contains(value + ""));
		logger.log(LogStatus.PASS, "TEST_605_updateLDoubleAttrValueToProductt Completed");
		log.debug("TEST_605_updateLDoubleAttrValueToProduct Completed");
	}

	/*
	 * UPDATE LDOUBLE ATTRIBUTE VALUES FOR PRODUCT USING AGENT
	 * 
	 * @verify the search result
	 */
	@Test(priority = 25, enabled = true)
	public void TEST_948_sendJsonAttrValueToProduct() throws Exception {
		log.debug("Executing sendJsonAttrValueToProduct test");
		logger = extent.startTest(this.getClass().getSimpleName());
		String value = "{\"cuId\":\"GEOTAB\",\"data\":{\"deviceId\":\"IAT030\",\"localId\":1,\"mfgId\":null,\"name\":\"LocationData\",\"peripheralId\":null,\"serialNum\":\"ABCD12345678901234567890\",\"sku\":\"None\",\"value\":{\"event\":[{\"type\":\"moving\"}],\"location\":{\"accuracy\":18.371,\"altitude\":116.937,\"bearing\":347.22994,\"floor\":0,\"latitude\":40.4071672,\"longitude\":-77.0102154,\"source\":\"gps\",\"speed\":1817},\"sensors\":{\"battery\":{\"charging\":false,\"current\":-41,\"extpower\":false,\"percent\":100,\"solarma\":12,\"solarmv\":13,\"temp\":21.2,\"voltage\":4020}}}},\"message\":null,\"messageType\":0,\"priority\":0,\"timeStamp\":\"2019-09-18T01:45:31+00:00\"}";
		String response = agentClient.sendAttrValueForJsonDataType(client, productEpLocalId, 10, value,0);
		Assert.assertEquals("OK", response);
		// Assert.assertEquals(value+"",nbi.getProductAttributeValue(virtualProdId,10));
		logger.log(LogStatus.PASS, "sendJsonAttrValueToProduct test Completed");
		log.debug("sendJsonAttrValueToProduct test Completed");
	}

	/*
	 * uploadDeviceLogFile
	 */
	@Test(priority = 26, enabled = false)
	public void TEST_1050_uploadDeviceLogFile() {
		logger = extent.startTest(this.getClass().getSimpleName());
		int status = nbi.uploadDeviceLogfile(cUid, deviceId);
		Assert.assertTrue(200 <= status & status <= 205);
		logger.log(LogStatus.PASS, "uploadDeviceLogFile test Completed");
		log.debug("uploadDeviceLogFile test Completed");

	}
	

	/*
	 * uploadDeviceLogFile
	 */
	@Test(priority = 27, enabled = false)
	public void TEST_00_getDeviceLogList() {
		logger = extent.startTest(this.getClass().getSimpleName());
		int count = nbi.getDeviceLogfile(virtualProdId);
		Assert.assertTrue(1 <= count);
		logger.log(LogStatus.PASS, "_getDeviceLogList test Completed");
		log.debug("_getDeviceLogList test Completed");

	}


	/*
	 * uploadDeviceLogFile
	 */
	@Test(priority = 28, enabled = false)
	public void TEST_00_downloadDeviceLogFile() {
		logger = extent.startTest(this.getClass().getSimpleName());
		int status = nbi.downloadLogfile(virtualProdId);
		Assert.assertTrue(200 <= status & status <= 205);
		logger.log(LogStatus.PASS, "downloadDeviceLogFile test Completed");
		log.debug("downloadDeviceLogFile test Completed");

	}


	/*
	 * uploadDeviceLogFile
	 */
	@Test(priority = 29, enabled = false)
	public void TEST_00_deleteDeviceLogFile() {
		logger = extent.startTest(this.getClass().getSimpleName());
		int status = nbi.deleteLogfile(virtualProdId);
		Assert.assertTrue(200 <= status & status <= 205);
		logger.log(LogStatus.PASS, "deleteDeviceLogFile test Completed");
		log.debug("deleteDeviceLogFile test Completed");

	}


	/*
	 * GET RESPONSE AFTER SYNC OF PRODUCT TEST
	 */
	@Test(priority = 30, enabled = true)
	public void TEST_585_productSkinnySync() throws InterruptedException, TException {
		logger = extent.startTest(this.getClass().getSimpleName());
		String sync = agentClient.productSync(client, 2);
		Assert.assertEquals(sync, "OK");
		logger.log(LogStatus.PASS, "SkinnySync Completed");
		log.debug("SkinnySync Completed");

	}

	/*
	 * GET RESPONSE AFTER sendAttrValueInQue OF PRODUCT TEST
	 */
	@Test(priority = 31, enabled = true)
	public void TEST_1058_sendAttrValueInQue() throws InterruptedException, TException {
		logger = extent.startTest(this.getClass().getSimpleName());
		String res = agentClient.sendAttrValueInQue(client, productEpLocalId, 10);
		Assert.assertEquals(res, "OK");
		logger.log(LogStatus.PASS, "sendAttrValueInQue Completed");
		log.debug("sendAttrValueInQue Completed");

	}
	
	
	
 @Test(priority = 32, enabled = true)
 public void TEST_00_disConnectProduct() throws Exception {
   logger = extent.startTest(this.getClass().getSimpleName());
   String reponse = agentClient.Disconnect(client);
   Assert.assertEquals("OK", reponse);
   logger.log(LogStatus.PASS, "disConnectProduct Completed");
   log.debug("disConnectProduct Completed");

 }
 

 @Test(priority = 32, enabled = true)
 public void TEST_00_reConnectProduct() throws Exception {
   logger = extent.startTest(this.getClass().getSimpleName());
   String reponse = agentClient.productConnect(client);
   Assert.assertEquals("OK", reponse);
   logger.log(LogStatus.PASS, "reConnectProduc Completed");
   log.debug("reConnectProduc Completed");

 }

 @Test(priority = 35, enabled = true)
 public void TEST_1076_addMultipleProduct() {
	logger = extent.startTest(this.getClass().getSimpleName());
	int status = nbi.addMultipleProduct(cuid, sku, deviceId, serialNumber);
	Assert.assertTrue(200 <= status & status <= 205);
	logger.log(LogStatus.PASS, "addProduct test Completed");
	log.debug("addProduct test Completed");

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
