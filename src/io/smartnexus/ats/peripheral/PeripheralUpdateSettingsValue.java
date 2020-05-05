package io.smartnexus.ats.peripheral;

import java.io.IOException;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.thrift.TException;
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
import io.smartnexus.ats.utils.ExtentManager;
import io.smartnexus.ats.utils.NorthBoundInterface;

public class PeripheralUpdateSettingsValue {
  private static final Logger log = Logger.getLogger(PeripheralUpdateSettingsValue.class.getName());
  ExtentTest logger;
  ExtentReports extent;
  AgentService.Client client;
  AgentClient agentClient = new AgentClient();
  int localId;
  private NorthBoundInterface nbi;

  // LoginAs Administrator
  @BeforeClass
  public void setUp() throws Exception {
    BasicConfigurator.configure();
    extent = ExtentManager.getInstance();
    localId = PeripheralUpdateAttributesValue.localId;
    client = ProductUpdateAttributesValue.client;
    nbi = new NorthBoundInterface();
  }

  /*
   * Send Boolean Setting value for Dynamic EP from Agent
   * 
   * @Step Using Agent send the Boolean value to Boolean Settings
   * 
   * @Step Verify the Boolean value from UI
   */
  @Test(priority = 1, enabled = true)
  public void TEST_674_sendBooleanSettingValueForPeripheral() throws IOException, InterruptedException, TException {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    int value = 1;
    String response = agentClient.sendSettValueForBooleanDataType(client, localId, 1, value);
    Assert.assertEquals("OK", response);
    logger.log(LogStatus.PASS, "sendBooleanSettingValueForPeripheral test Completed");
    log.debug("sendBooleanSettingValueForPeripheral test Completed");
  }

  /*
   * Send Int Setting value for Dynamic EP from Agent
   * 
   * @Step Using Agent send the Int value to Int Settings
   * 
   * @Step Verify the Int value from UI
   */
  @Test(priority = 2, enabled = true)
  public void TEST_675_sendIntSettingValueForPeripheral() throws IOException, InterruptedException, TException {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    int value = 4564;
    String response = agentClient.sendSettValueForIntegerDataType(client, localId, 2, value);
    Assert.assertEquals("OK", response);
    logger.log(LogStatus.PASS, "sendIntSettingValueForPeripheral test Completed");
    log.debug("sendIntSettingValueForPeripheral test Completed");
  }

  /*
   * Send Byte Setting value for Dynamic EP from Agent
   * @Step Using Agent send the Byte value to Byte Settings
   * @Step Verify the Byte value from UI
   */
  @Test(priority = 3, enabled =  true)
  public void TEST_678_sendByteSettingValueForPeripheral() throws IOException, InterruptedException, TException {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    byte value = (byte) 45;
    String response = agentClient.sendSettValueForByteDataType(client, localId, 3, value);
    Assert.assertEquals("OK", response);
    logger.log(LogStatus.PASS, "sendByteSettingValueForPeripheral test Completed");
    log.debug("sendByteSettingValueForPeripheral test Completed");
  }

  /*
   * Send Decimal Setting value for Dynamic EP from Agent
   * @Step Using Agent send the Decimal value to Decimal Settings
   * @Step Verify the Decimal value from UI
   */
  @Test(priority = 4, enabled =  true)
  public void TEST_676_sendDecimalSettingValueForPeripheral() throws IOException, InterruptedException, TException {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    double value = 123.00;
    String response = agentClient.sendSettValueForDecimalDataType(client, localId, 4, value);
    Assert.assertEquals("OK", response);
    logger.log(LogStatus.PASS, "sendDecimalSettingValueForPeripheral test Completed");
    log.debug("sendDecimalSettingValueForPeripheral test Completed");
  }

  /*
   * Send BigInt Setting value for Dynamic EP from Agent
   * @Step Using Agent send the BigInt value to BigInt Settings
   * @Step Verify the BigInt value from UI
   */
  @Test(priority = 5, enabled =  true)
  public void TEST_679_sendBigIntSettingValueForPeripheral() throws IOException, InterruptedException, TException {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    long value = 98894;
    String response = agentClient.sendSettValueForBigIntDataType(client, localId, 5, value);
    Assert.assertEquals("OK", response);
    logger.log(LogStatus.PASS, "sendBigIntSettingValueForPeripheral test Completed");
    log.debug("sendBigIntSettingValueForPeripheral test Completed");
  }

 
  /*
   * Send String Setting value for Dynamic EP from Agent
   * @Step Using Agent send the String value to String Settings
   * @Step Verify the String value from UI
   */
  @Test(priority = 6, enabled =  true)
  public void TEST_681_sendStringSettingValueForPeripheral() throws IOException, InterruptedException, TException {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    String value = "SettingVal";
    String response = agentClient.sendSettValueForStringDataType(client, localId, 6, value,0);
    Assert.assertEquals("OK", response);
    logger.log(LogStatus.PASS, "sendStringSettingValueForPeripheral test Completed");
    log.debug("sendLDoubleSettingValueForPeripheral test Completed");
  }

  /*
   * Send Float Setting value for Dynamic EP from Agent
   * @Step Using Agent send the Float value to Float Settings
   * @Step Verify the Float value from UI
   */
  @Test(priority = 7, enabled =  true)
  public void TEST_680_sendFloatSettingValueForPeripheral() throws IOException, InterruptedException, TException {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    float value = (float) 78.90;
    String response = agentClient.sendSettValueFloatDataType(client, localId, 7, value);
    Assert.assertEquals("OK", response);
    logger.log(LogStatus.PASS, "sendFloatSettingValueForPeripheral test Completed");
    log.debug("sendFloatSettingValueForPeripheral test Completed");
  }

  /*
   * Send Double Setting value for Dynamic EP from Agent
   * @Step Using Agent send the Double value to Double Settings
   * @Step Verify the Double value from UI
   */
  @Test(priority = 8, enabled =  true)
  public void TEST_677_sendDoubleSettingValueForPeripheral() throws IOException, InterruptedException, TException {
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    double value = 17894;
    String response = agentClient.sendSettingValForDoubleDataType(client, localId, 8, value);
    Assert.assertEquals("OK", response);
    logger.log(LogStatus.PASS, "sendDoubleSettingValueForPeripheral test Completed");
    log.debug("sendDoubleSettingValueForPeripheral test Completed");
  }

  
 
  
  /*
   * Send LDouble Setting value for Dynamic EP from Agent
   * @Step Using Agent send the LDouble value to LDouble Settings
   * @Step Verify the LDouble value from UI
   */
  @Test(priority = 9, enabled =  true)
  public void TEST_682_sendLDoubleSettingValueForPeripheral() throws IOException, InterruptedException, TException {
    log.debug("Executing sendLDoubleSettingValueForPeripheral test");
    logger = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory(this.getClass().getSimpleName());
    double value = 18810;
    String response = agentClient.sendSettingValForLdoubleDataType(client, localId, 9, value);
    Assert.assertEquals("OK", response);
    logger.log(LogStatus.PASS, "sendLDoubleSettingValueForPeripheral test Completed");
    log.debug("sendLDoubleSettingValueForPeripheral test Completed");
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
