package io.smartnexus.ats.peripheral;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.thrift.TException;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.smartnexus.ats.product.ProductUpdateAttributesValue;
import io.smartnexus.ats.thrift.AgentClient;
import io.smartnexus.ats.thrift.AgentService;
import io.smartnexus.ats.utils.Constants;
import io.smartnexus.ats.utils.ExtentManager;
import io.smartnexus.ats.utils.NorthBoundInterface;

public class PeripheralUpdateAttributesValue {

  private static final Logger log = Logger.getLogger(PeripheralUpdateAttributesValue.class.getName());
  ExtentTest logger;
  ExtentReports extent;
  public static String deviceId = null;
  String UserFieldName;
  private String virtualProdId;
  public static String serialNumber = null;
  public static int localId;
  private NorthBoundInterface nbi;
  AgentService.Client client;
  AgentClient agentClient = new AgentClient();
  String mfgId = Constants.MFGID;

  // LoginAs Administrator
  @BeforeClass
  public void setUp() throws Exception {
    // BasicConfigurator.configure();
    extent = ExtentManager.getInstance();
    deviceId = ProductUpdateAttributesValue.deviceId;
    client = ProductUpdateAttributesValue.client;
    nbi = new NorthBoundInterface();
    virtualProdId = ProductUpdateAttributesValue.virtualProdId;
  }

  /*
   * ADD DYNAMIC END POINT TEST
   * @Step Using Agent to add and activate Dynamic end point from device
   * @Step Verify Dynamic end point shows added and Active
   */
  @Test(priority = 1, enabled = true)
  public void TEST_584_addPeripheral() throws ParseException, IllegalStateException, IOException, TException {
    log.debug("Executing TEST_584_addPeripheral test----");
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    localId = agentClient.addDynamicEndpoint(client, Constants.MFGID);
    Assert.assertNotEquals(localId, null);
    logger.log(LogStatus.PASS, "TEST_584_addPeripheral test Completed");
    log.debug("TEST_584_addPeripheral test Completed");
  }

  /*
   * Send Boolean Attribute value for Dynamic EP from Agent
   * @Step Using Agent send the Boolean value to Boolean Attribute
   * @Step Verify the Boolean value from UI
   */
  @Test(priority = 2, enabled = true)
  public void TEST_642_sendBooleanAttrValuePeripheral() throws IOException, InterruptedException, TException {
    log.debug("Executing sendBooleanAttrValuePeripheral test");
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    int value = 0;
    String response = agentClient.sendAttrValueForBooleanDataType(client, localId, 1, value);
   Assert.assertEquals(value+"",nbi.getEndpointAttributeValue(virtualProdId,localId,1));
    logger.log(LogStatus.PASS, "sendBooleanAttrValuePeripheral test Completed");
    log.debug("sendBooleanAttrValuePeripheral test Completed");
  }

  /*
   * Send Int Attribute value for Dynamic EP from Agent
   * @Step Using Agent send the Int value to Int Attribute
   * @Step Verify the Int value from UI
   */
  @Test(priority = 3, enabled = true)
  public void TEST_643_sendIntAttrValueuePeripheral() throws IOException, InterruptedException, TException {
    log.debug("Executing sendIntAttrValuePeripheral test");
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    int value = 66767;
    String response = agentClient.sendAttrValueForIntegerDataType(client, localId, 2, value);
   // Assert.assertEquals("OK", response);
    Assert.assertEquals(value+"",nbi.getEndpointAttributeValue(virtualProdId,localId,2));
    logger.log(LogStatus.PASS, "sendIntAttrValueuePeripheral test Completed");
    log.debug("sendIntAttrValueuePeripheral test Completed");
  }

  /*
   * Send Byte Attribute value for Dynamic EP from Agent
   * @Step Using Agent send the Byte value to Byte Attribute
   * @Step Verify the Byte value from UI
   */
  @Test(priority = 4, enabled =  true)
  public void TEST_644_sendByteAttrValueuePeripheral() throws IOException, InterruptedException, TException {
    log.debug("Executing sendByteAttrValuePeripheral test");
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    byte value = (byte) 56;
    agentClient.sendAttrValueForByteDataType(client, localId, 3, value);
    Assert.assertEquals(value+"",nbi.getEndpointAttributeValue(virtualProdId,localId,3));
    logger.log(LogStatus.PASS, "sendByteAttrValueuePeripheral test Completed");
    log.debug("sendByteAttrValueuePeripheral test Completed");
  }

  /*
   * Send Decimal Attribute value for Dynamic EP from Agent
   * 
   * @Step Using Agent send the Decimal value to Decimal Attribute
   * 
   * @Step Verify the Decimal value from UI
   */
  @Test(priority = 5, enabled =  true)
  public void TEST_645_sendDecimalAttrValueuePeripheral() throws IOException, InterruptedException, TException {
    log.debug("Executing sendDecimalAttrValuePeripheral test");
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    double value = 222.11;
    agentClient.sendAttrValueForDecimalDataType(client, localId, 4, value);
    Assert.assertTrue(nbi.getEndpointAttributeValue(virtualProdId,localId,4).contains(value + ""));
    logger.log(LogStatus.PASS, "sendDecimalAttrValueuePeripheral test Completed");
    log.debug("sendDecimalAttrValueuePeripheral test Completed");
  }

  /*
   * Send BigInt Attribute value for Dynamic EP from Agent
   * @Step Using Agent send the BigInt value to BigInt Attribute
   * @Step Verify the BigInt value from UI
   */
  @Test(priority = 6, enabled =  true)
  public void TEST_646_sendBigIntAttrValueuePeripheral() throws IOException, InterruptedException, TException {
    log.debug("Executing sendBigIntAttrValuePeripheral test");
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    long value = 998724;
    agentClient.sendAttrValueForBigIntDataType(client, localId, 5, value);
     Assert.assertEquals(value+"",nbi.getEndpointAttributeValue(virtualProdId,localId,5));
    logger.log(LogStatus.PASS, "sendBigIntAttrValueuePeripheral test Completed");
    log.debug("sendBigIntAttrValueuePeripheral test Completed");
  }

  /*
   * Send String Attribute value for Dynamic EP from Agent
   * @Step Using Agent send the String value to String Attribute
   * @Step Verify the String value from UI
   */
  @Test(priority = 7, enabled =  true)
  public void TEST_647_sendStringAttrValueuePeripheral() throws IOException, InterruptedException, TException {
    log.debug("Executing sendStringAttrValuePeripheral test");
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
     agentClient.sendAttrValueForStringDataType(client, localId, 6,  "Settings",0);
    Assert.assertEquals("U2V0dGluZ3M=",nbi.getEndpointAttributeValue(virtualProdId,localId,6));
    logger.log(LogStatus.PASS, "sendStringAttrValueuePeripheral test Completed");
    log.debug("sendStringAttrValueuePeripheral test Completed");
  }

  /*
   * Send Float Attribute value for Dynamic EP from Agent
   * 
   * @Step Using Agent send the Float value to Float Attribute
   * 
   * @Step Verify the Float value from UI
   */
  @Test(priority = 8, enabled =  true)
  public void TEST_648_sendFloatAttrValueuePeripheral() throws IOException, InterruptedException, TException {
    log.debug("Executing sendFloatAttrValuePeripheral test");
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    float value = (float) 10.41;
    agentClient.sendAttrValueFloatDataType(client, localId, 7, value);
    Assert.assertTrue(nbi.getEndpointAttributeValue(virtualProdId,localId,7).contains(value + ""));
    logger.log(LogStatus.PASS, "sendFloatAttrValueuePeripheral test Completed");
    log.debug("sendFloatAttrValueuePeripheral test Completed");
  }

  /*
   * Send Double Attribute value for Dynamic EP from Agent
   * 
   * @Step Using Agent send the Double value to Double Attribute
   * 
   * @Step Verify the Double value from UI
   */
  @Test(priority = 9, enabled =  true)
  public void TEST_649_sendDoubleAttrValueuePeripheral() throws IOException, InterruptedException, TException {
    log.debug("Executing sendDoubleAttrValuePeripheral test");
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    double value = 1234567;
    agentClient.sendAttrValueForDoubleDataType(client, localId, 8, value);
    Assert.assertTrue(nbi.getEndpointAttributeValue(virtualProdId,localId,8).contains(value + ""));
    logger.log(LogStatus.PASS, "sendDoubleAttrValueuePeripheral test Completed");
    log.debug("sendDoubleAttrValueuePeripheral test Completed");
  }

  /*
   * Send LDouble Attribute value for Dynamic EP from Agent
   * @Step Using Agent send the LDouble value to LDouble Attribute
   * @Step Verify the LDouble value from UI
   */
  @Test(priority = 10, enabled =  true)
  public void TEST_650_sendLdoubleAttrValueuePeripheral() throws IOException, InterruptedException, TException {
    log.debug("Executing sendLdoubleAttrValuePeripheral test");
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    double value = 89568;
    agentClient.sendAttrValueForLdoubleDataType(client, localId, 9, value);
    Assert.assertTrue(nbi.getEndpointAttributeValue(virtualProdId,localId,9).contains(value + ""));
    logger.log(LogStatus.PASS, "sendLdoubleAttrValuePeripheral test Completed");
    log.debug("sendLdoubleAttrValueuePeripheral test Completed");
  }

  /*
   * UPDATE BOOLEAN ATTRIBUTE VALUES FOR PRODUCT USING AGENT
   * 
   * @verify the search result
   */
  @Test(priority = 11, enabled =  true)
  public void TEST_651_updateBooleanAttrValueForPeripheral() throws Exception {
    log.debug("Executing updateBooleanAttrValueForPeripheral test");
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    int value = 0;
    String response = agentClient.updateAttrValueForBooleanDataType(client, localId, 1, value);
    Assert.assertEquals(value+"",nbi.getEndpointAttributeValue(virtualProdId,localId,1));
    logger.log(LogStatus.PASS, "updateBooleanAttrValueForPeripheral test Completed");
    log.debug("updateBooleanAttrValueForPeripheral test Completed");
  }

  /*
   * UPDATE INT ATTRIBUTE VALUES FOR PRODUCT USING AGENT
   * 
   * @verify the search result
   */
  @Test(priority = 12, enabled =  true)
  public void TEST_652_updateIntAttrValueForPeripheral() throws Exception {
    log.debug("Executing updateIntAttrValueForPeripheral test");
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    int value = 44477;
    agentClient.updateAttrValueForIntDataType(client, localId, 2, value);
    Assert.assertEquals(value+"",nbi.getEndpointAttributeValue(virtualProdId,localId,2));
    logger.log(LogStatus.PASS, "updateIntAttrValueForPeripheral test Completed");
    log.debug("updateIntAttrValueForPeripheral test Completed");
  }

  /*
   * UPDATE BYTE ATTRIBUTE VALUES FOR PRODUCT USING AGENT
   * 
   * @verify the search result
   */
  @Test(priority = 13, enabled =  true)
  public void TEST_653_updateByteAttrValueForPeripheral() throws Exception {
    log.debug("Executing updateByteAttrValueForPeripheral test");
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    byte value = (byte) 56;
    agentClient.updateAttrValueForByteDataType(client, localId, 3, value);
    Assert.assertEquals(value+"",nbi.getEndpointAttributeValue(virtualProdId,localId,3));
    logger.log(LogStatus.PASS, "updateByteAttrValueForPeripheral test Completed");
    log.debug("updateByteAttrValueForPeripheral test Completed");
  }

  /*
   * UPDATE DECIMAL ATTRIBUTE VALUES FOR PRODUCT USING AGENT
   * 
   * @verify the search result
   */
  @Test(priority = 14, enabled =  true)
  public void TEST_654_updateDecimalAttrValueForPeripheral() throws Exception {
    log.debug("Executing updateDecimalAttrValueForPeripheral test");
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    double value = 222.61;
    agentClient.updateAttrValueForDecimalDataType(client, localId, 4, value);
    Assert.assertTrue(nbi.getEndpointAttributeValue(virtualProdId,localId,4).contains(value + ""));
    logger.log(LogStatus.PASS, "updateDecimalAttrValueForPeripheral test Completed");
    log.debug("updateDecimalAttrValueForPeripheral test Completed");
  }

  /*
   * UPDATE BIGINT ATTRIBUTE VALUES FOR PRODUCT USING AGENT
   * 
   * @verify the search result
   */
  @Test(priority = 15, enabled =  true)
  public void TEST_655_updateBigIntAttrValueForPeripheral() throws Exception {
    log.debug("Executing updateBigIntAttrValueForPeripheral test");
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    long value = 66767;
     agentClient.updateAttrValueForBigIntDataType(client, localId, 5, value);
    Assert.assertEquals(value+"",nbi.getEndpointAttributeValue(virtualProdId,localId,5));
    logger.log(LogStatus.PASS, "updateBigIntAttrValueForPeripheral test Completed");
    log.debug("updateBigIntAttrValueForPeripheral test Completed");
  }

  /*
   * UPDATE STRING ATTRIBUTE VALUES FOR PRODUCT USING AGENT
   * 
   * @verify the search result
   */
  @Test(priority = 16, enabled =  true)
  public void TEST_656_updateStringAttrValueForPeripheral() throws Exception {
    log.debug("Executing updateStringAttrValueForPeripheral test");
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    agentClient.updateAttrValueForStringDataType(client, localId, 6, "update");
    Assert.assertEquals("dXBkYXRl",nbi.getEndpointAttributeValue(virtualProdId,localId,6));
    logger.log(LogStatus.PASS, "updateStringAttrValueForPeripheral test Completed");
    log.debug("updateStringAttrValueForPeripheral test Completed");
  }

  /*
   * UPDATE FLOAT ATTRIBUTE VALUES FOR PRODUCT USING AGENT
   * 
   * @verify the search result
   */
  @Test(priority = 17, enabled =  true)
  public void TEST_657_updateFloatAttrValueForPeripheral() throws Exception {
    log.debug("Executing updateFloatAttrValueForPeripheral test");
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    float value = (float) 88.22;
    agentClient.updateAttrValueForFloatDataType(client, localId, 7, value);
    Assert.assertTrue(nbi.getEndpointAttributeValue(virtualProdId,localId,7).contains(value + ""));
    logger.log(LogStatus.PASS, "updateFloatAttrValueForPeripheral test Completed");
    log.debug("updateFloatAttrValueForPeripheral test Completed");
  }

  /*
   * UPDATE DOUBLE ATTRIBUTE VALUES FOR PRODUCT USING AGENT
   * 
   * @verify the search result
   */
  @Test(priority = 18, enabled =  true)
  public void TEST_658_updateDoubleAttrValueForPeripheral() throws Exception {
    log.debug("Executing updateDoubleAttrValueForPeripheral test");
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    double value = 6666;
    agentClient.updateAttrValueForDoubleDataType(client, localId, 8, value);
    Assert.assertTrue(nbi.getEndpointAttributeValue(virtualProdId,localId,8).contains(value + ""));
    logger.log(LogStatus.PASS, "updateDoubleAttrValueForPeripheral test Completed");
    log.debug("updateDoubleAttrValueForPeripheral test Completed");
  }

  /*
   * UPDATE LDOUBLE ATTRIBUTE VALUES FOR PRODUCT USING AGENT
   * 
   * @verify the search result
   */
  @Test(priority = 19, enabled =  true)
  public void TEST_659_updateLDoubleAttrValueForPeripheral() throws Exception {
    log.debug("Executing updateLDoubleAttrValueForPeripheral test");
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    double value = 98712.21;
    agentClient.updateAttrValueForLDoubleDataType(client, localId, 9, value);
    Assert.assertTrue(nbi.getEndpointAttributeValue(virtualProdId,localId,9).contains(value + ""));
    logger.log(LogStatus.PASS, "updateLDoubleAttrValueForPeripheral test Completed");
    log.debug("updateLDoubleAttrValueForPeripheral test Completed");
  }

  @Test(priority = 20, enabled =  true)
  public void TEST_1051_sendJsonAttrValueForPeripheral() throws Exception {
    log.debug("Executing updateLDoubleAttrValueForPeripheral test");
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    String value = "{\r\n  \"mac\": \"string\",\r\n  \"os\": \"string\",\r\n  \"osVersion\": \"string\",\r\n  \"apiVersion\": \"string\",\r\n  \"batch\": \"string\",\r\n  \"rma\": \"string\",\r\n  \"rmaDate\": \"2017-12-18T06:17:42.545Z\",\r\n  \"hwVersion\": \"string\",\r\n  \"builddate\": \"2017-12-18T06:17:42.545Z\",\r\n  \"sn\": \"string\",\r\n  \"swVersion\": \"string\",\r\n  \"swName\": \"string\",\r\n  \"hwName\": \"string\",\r\n  \"agentVersion\": \"string\",\r\n  \"platformArch\": \"string\",\r\n  \"agentType\": \"string\"\r\n}";
    String response = agentClient.updateAttrValueForJsonDataType(client, localId, 10, value);
    Assert.assertEquals("OK", response);
    // Assert.assertEquals(value+"",nbi.getEndpointAttributeValue(virtualProdId,localId,10));
    logger.log(LogStatus.PASS, "updateLDoubleAttrValueForPeripheral test Completed");
    log.debug("updateLDoubleAttrValueForPeripheral test Completed");
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
