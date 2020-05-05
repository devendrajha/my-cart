package io.smartnexus.ats.configure.peripheral;

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
import io.smartnexus.ats.utils.Constants;
import io.smartnexus.ats.utils.ExtentManager;
import io.smartnexus.ats.utils.NorthBoundInterface;

public class ConfigurePeripheralCommands {

	private static final Logger log = Logger.getLogger(ConfigurePeripheralCommands.class.getName());
	ExtentTest logger;
	ExtentReports extent;
	private String pmId;
	String token;
	private NorthBoundInterface nbi;

	// LoginAs Administrator
	@BeforeClass

	public void setUp() throws Exception {
		extent = ExtentManager.getInstance();
		nbi = new NorthBoundInterface();
		pmId = AddProductMaster.productMasterId;

	}

	/*
	 * ADD BOOLEAN COMMANDS FOR CHECKBOX TEST
	 */
	@Test(priority = 1, enabled = true)
	public void TEST_493_addCommandNA() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		String name = new Object() {}.getClass().getEnclosingMethod().getName();
		String id = nbi.addPeripheralCommands(name, pmId, Constants.NA, "Boolean");
		Assert.assertTrue(nbi.getCommandTemplateForPeriphal(pmId, id));
		logger.log(LogStatus.PASS, "addCommandNoparam test Completed");
		log.debug("addCommandNoparam test Completed");
	}

	/*
	 * ADD BOOLEAN COMMANDS FOR TEXTFIELD TEST
	 */
	@Test(priority = 2, enabled = true)
	public void TEST_494_addCommandTextFieldBoolean() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		String name = new Object() {}.getClass().getEnclosingMethod().getName();
		String id = nbi.addPeripheralCommands(name, pmId, Constants.TEXT, "Boolean");
		Assert.assertTrue(nbi.getCommandTemplateForPeriphal(pmId, id));
		logger.log(LogStatus.PASS, "addCommandTextFieldBoolean test Completed");
		log.debug("addCommandTextFieldBoolean test Completed");

	}

	/*
	 * ADD INT COMMANDS FOR TEXTFIELD TEST
	 */
	@Test(priority = 3, enabled = true)
	public void TEST_495_addCommandTextFieldInt() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		String name = new Object() {}.getClass().getEnclosingMethod().getName();
		String id = nbi.addPeripheralCommands(name, pmId, Constants.TEXT, "Int");
		Assert.assertTrue(nbi.getCommandTemplateForPeriphal(pmId, id));
		logger.log(LogStatus.PASS, "addCommandTextFieldInt test Completed");
		log.debug("addCommandTextInt test Completed");

	}

	/*
	 * ADD BYTE COMMANDS FOR TEXTFIELD TEST
	 */
	@Test(priority = 4, enabled = true)
	public void TEST_496_addCommandTextFieldByte() throws Exception {
		log.debug("Executing addCommandTextByte test");
		logger = extent.startTest(this.getClass().getSimpleName());
		String name = new Object() {}.getClass().getEnclosingMethod().getName();
		String id = nbi.addPeripheralCommands(name, pmId, Constants.TEXT, "Byte");
		Assert.assertTrue(nbi.getCommandTemplateForPeriphal(pmId, id));
		logger.log(LogStatus.PASS, "addCommandTextByte test Completed");
		log.debug("addCommandTextByte test Completed");

	}

	/*
	 * ADD DECIMAL COMMANDS FOR TEXTFIELD TEST
	 */
	@Test(priority = 5, enabled = true)
	public void TEST_497_addCommandTextFieldDecimal() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		String name = new Object() {}.getClass().getEnclosingMethod().getName();
		String id = nbi.addPeripheralCommands(name, pmId, Constants.TEXT, "Decimal");
		Assert.assertTrue(nbi.getCommandTemplateForPeriphal(pmId, id));
		logger.log(LogStatus.PASS, "addCommandTextDecimal test Completed");
		log.debug("addCommandTextDecimal test Completed");

	}

	/*
	 * ADD FLOAT COMMANDS FOR TEXTFIELD TEST
	 */
	@Test(priority = 6, enabled = true)
	public void TEST_498_addCommandTextFieldFloat() throws Exception {
		log.debug("Executing addCommandTextFloat test");
		logger = extent.startTest(this.getClass().getSimpleName());
		String name = new Object() {	}.getClass().getEnclosingMethod().getName();
		String id = nbi.addPeripheralCommands(name, pmId, Constants.TEXT, "Float");
		Assert.assertTrue(nbi.getCommandTemplateForPeriphal(pmId, id));
		logger.log(LogStatus.PASS, "addCommandTextFloat test Completed");
		log.debug("addCommandTextFloat test Completed");

	}

	/*
	 * ADD STRING COMMANDS FOR TEXTFIELD TEST
	 */
	@Test(priority = 7, enabled = true)
	public void TEST_499_addCommandTextFieldString() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		String name = new Object() {	}.getClass().getEnclosingMethod().getName();
		String id = nbi.addPeripheralCommands(name, pmId, Constants.TEXT, "String");
		Assert.assertTrue(nbi.getCommandTemplateForPeriphal(pmId, id));
		logger.log(LogStatus.PASS, "addCommandTextString test Completed");
		log.debug("addCommandTextString test Completed");

	}

	/*
	 * ADD DOUBLE COMMANDS FOR TEXTFIELD TEST
	 */
	@Test(priority = 8, enabled = true)
	public void TEST_500_addCommandTextFieldDouble() throws Exception {
		log.debug("Executing addCommandTextDouble test");
		logger = extent.startTest(this.getClass().getSimpleName());
		String name = new Object() {}.getClass().getEnclosingMethod().getName();
		String id = nbi.addPeripheralCommands(name, pmId, Constants.TEXT, "Double");
		Assert.assertTrue(nbi.getCommandTemplateForPeriphal(pmId, id));
		logger.log(LogStatus.PASS, "addCommandTextDouble test Completed");
		log.debug("addCommandTextDouble test Completed");

	}

	/*
	 * ADD LDOUBLE COMMANDS FOR TEXTFIELD TEST
	 */
	@Test(priority = 9, enabled = true)
	public void TEST_501_addCommandTextFieldLDouble() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		String name = new Object() {}.getClass().getEnclosingMethod().getName();
		String id = nbi.addPeripheralCommands(name, pmId, Constants.TEXT, "LDouble");
		Assert.assertTrue(nbi.getCommandTemplateForPeriphal(pmId, id));
		logger.log(LogStatus.PASS, "addCommandTextLDouble test Completed");
		log.debug("addCommandTextLDouble test Completed");

	}

	/*
	 * ADD Json COMMANDS FOR TEXTFIELD TEST
	 */
	@Test(priority = 10, enabled = true)
	public void TEST_957_addCommandTextFieldJson() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		String name = new Object() {}.getClass().getEnclosingMethod().getName();
		String id = nbi.addPeripheralCommands(name, pmId, Constants.TEXT, "JSON");
		Assert.assertTrue(nbi.getCommandTemplateForPeriphal(pmId, id));
		logger.log(LogStatus.PASS, "addCommandTextFieldJson test Completed");
		log.debug("addCommandTextFieldJson test Completed");

	}

	/*
	 * ADD BOOLEAN COMMANDS FOR CHECKBOX TEST
	 */
	@Test(priority = 11, enabled = true)
	public void TEST_502_addCommandCHECKBOXBoolean() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		String name = new Object() {}.getClass().getEnclosingMethod().getName();
		String id = nbi.addPeripheralCommands(name, pmId, Constants.CHECKBOX, "Boolean");
		Assert.assertTrue(nbi.getCommandTemplateForPeriphal(pmId, id));
		logger.log(LogStatus.PASS, "addCommandCHECKBOXBoolean test Completed");
		log.debug("addCommandCHECKBOXBoolean test Completed");

	}

	/*
	 * ADD BOOLEAN COMMANDS FOR DROPDOWN TEST
	 */
	@Test(priority = 12, enabled = true)
	public void TEST_504_addCommandDropdownBoolean() throws Exception {
		log.debug("Executing addCommandDropdownBoolean test");
		logger = extent.startTest(this.getClass().getSimpleName());
		String name = new Object() {}.getClass().getEnclosingMethod().getName();
		String id = nbi.addPeripheralCommandsDropdown(pmId, Constants.DROPDOWN, "Boolean");
		Assert.assertTrue(nbi.getCommandTemplateForPeriphal(pmId, id));
		logger.log(LogStatus.PASS, "addCommandDropdownBoolean test Completed");
		log.debug("addCommandDropdownBoolean test Completed");

	}

	/*
	 * ADD String COMMANDS FOR Sysdate TEST
	 */
	@Test(priority = 13, enabled = true)
	public void Test_513_addCommandSysdateInt() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		String name = new Object() {	}.getClass().getEnclosingMethod().getName();
		String id = nbi.addPeripheralCommands(name, pmId, Constants.SYSDATE, "Int");
		Assert.assertTrue(nbi.getCommandTemplateForPeriphal(pmId, id));
		logger.log(LogStatus.PASS, "addCommandSysdateInt test Completed");
		log.debug("addCommandSysdateInt test Completed");

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
