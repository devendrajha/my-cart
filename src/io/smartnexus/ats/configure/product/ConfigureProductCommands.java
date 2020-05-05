package io.smartnexus.ats.configure.product;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.smartnexus.ats.utils.Constants;
import io.smartnexus.ats.utils.ExtentManager;
import io.smartnexus.ats.utils.NorthBoundInterface;

public class ConfigureProductCommands {

	private static final Logger log = Logger.getLogger(ConfigureProductCommands.class.getName());
	private NorthBoundInterface nbi;
	public static String commandNameInt;
	public static String commandSysDate;
	ExtentTest logger;
	private String productMasterId;
	ExtentReports extent;

	// LoginAs Administrator
	@BeforeClass

	public void setUp() throws Exception {
		extent = ExtentManager.getInstance();
		nbi = new NorthBoundInterface();
		productMasterId = AddProductMaster.productMasterId;
	}
	
	@Test(priority = 1, enabled = true)
	public void TEST_00_addCommandNA() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		String name = new Object() {}.getClass().getEnclosingMethod().getName();
		String id = nbi.addProductCommands(name, productMasterId, Constants.NA, "Boolean");
		Assert.assertTrue(nbi.getCommandTemplate(productMasterId, id));
		logger.log(LogStatus.PASS, "addCommandNA test Completed");
		log.debug("addCommandNA test Completed");

	}

	/*
	 * ADD BOOLEAN COMMANDS FOR CHECKBOX TEST
	 */
	@Test(priority = 2, enabled = true)
	public void TEST_303_addCommandCheckboxBoolean() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		String name = new Object() {}.getClass().getEnclosingMethod().getName();
		String id = nbi.addProductCommands(name, productMasterId, Constants.CHECKBOX, "Boolean");
		Assert.assertTrue(nbi.getCommandTemplate(productMasterId, id));
		logger.log(LogStatus.PASS, "addCommandCheckboxBoolean test Completed");
		log.debug("addCommandCheckboxBoolean test Completed");

	}

	/*
	 * ADD BOOLEAN COMMANDS FOR Text TEST
	 */
	@Test(priority = 3, enabled = true)
	public void TEST_313_addCommandTextBoolean() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		String name = new Object() {}.getClass().getEnclosingMethod().getName();
		String id = nbi.addProductCommands(name, productMasterId, Constants.TEXT, "Boolean");
		Assert.assertTrue(nbi.getCommandTemplate(productMasterId, id));
		logger.log(LogStatus.PASS, "addCommandTextBoolean test Completed");
		log.debug("addCommandTextBoolean test Completed");

	}

	/*
	 * ADD INT COMMANDS FOR Text TEST
	 */
	@Test(priority = 4, enabled = true)
	public void TEST_314_addCommandTextInt() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		String name = new Object() {}.getClass().getEnclosingMethod().getName();
		String id = nbi.addProductCommands(name, productMasterId, Constants.TEXT, "Int");
		Assert.assertTrue(nbi.getCommandTemplate(productMasterId, id));
		logger.log(LogStatus.PASS, "addCommandTextInt test Completed");
		log.debug("addCommandTextInt test Completed");

	}
	/*
	 * ADD Json COMMANDS FOR Text TEST
	 */
	@Test(priority = 5, enabled = true)
	public void TEST_318_addCommandTextString() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		String name = new Object() {}.getClass().getEnclosingMethod().getName();
		String id = nbi.addProductCommands(name, productMasterId, Constants.TEXT, "String");
		Assert.assertTrue(nbi.getCommandTemplate(productMasterId, id));
		logger.log(LogStatus.PASS, "addCommandTextString test Completed");
		log.debug("addCommandTextString test Completed");

	}

	/*
	 * ADD Json COMMANDS FOR Text TEST
	 */
	@Test(priority = 6, enabled = true)
	public void TEST_321_addCommandTextJson() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		String name = new Object() {}.getClass().getEnclosingMethod().getName();
		String id = nbi.addProductCommands(name, productMasterId, Constants.TEXT, "Json");
		Assert.assertTrue(nbi.getCommandTemplate(productMasterId, id));
		logger.log(LogStatus.PASS, "addCommandTextJson test Completed");
		log.debug("addCommandTextJson test Completed");

	}

	

	/*
	 * ADD BOOLEAN COMMANDS FOR TEXTFIELD TEST
	 */
	@Test(priority = 7, enabled = true)
	public void TEST_322_addSysDateCommandForBoolean() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		String name = new Object() {}.getClass().getEnclosingMethod().getName();
		String id = nbi.addProductCommands(name, productMasterId, Constants.SYSDATE, "Boolean");
		Assert.assertTrue(nbi.getCommandTemplate(productMasterId, id));
		logger.log(LogStatus.PASS, "addCommandTextFieldBoolean test Completed");
		log.debug("addCommandTextFieldBoolean test Completed");

	}

	/*
	 * ADD BOOLEAN COMMANDS FOR TEXTFIELD TEST
	 */
	@Test(priority = 8, enabled = true)
	public void TEST_323_addSysDateCommandForInt() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		String name = new Object() {}.getClass().getEnclosingMethod().getName();
		String id = nbi.addProductCommands(name, productMasterId, Constants.SYSDATE, "Int");
		Assert.assertTrue(nbi.getCommandTemplate(productMasterId, id));
		logger.log(LogStatus.PASS, "addCommandTextFieldBoolean test Completed");
		log.debug("addCommandTextFieldBoolean test Completed");

	}

	@Test(priority = 9, enabled = true)
	public void TEST_327_addSysDateCommandForString() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		String name = new Object() {}.getClass().getEnclosingMethod().getName();
		String id = nbi.addProductCommands(name, productMasterId, Constants.SYSDATE, "String");
		Assert.assertTrue(nbi.getCommandTemplate(productMasterId, id));
		logger.log(LogStatus.PASS, "addSysDateCommandForString test Completed");
		log.debug("addSysDateCommandForString test Completed");

	}

	@Test(priority = 10, enabled = true)
	public void TEST_00_addSysDateCommandForJson() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		String name = new Object() {}.getClass().getEnclosingMethod().getName();
		String id = nbi.addProductCommands(name, productMasterId, Constants.SYSDATE, "Json");
		Assert.assertTrue(nbi.getCommandTemplate(productMasterId, id));
		logger.log(LogStatus.PASS, "addSysDateCommandForString test Completed");
		log.debug("addSysDateCommandForString test Completed");

	}

	/*
	 * ADD BOOLEAN COMMANDS FOR TEXTFIELD TEST
	 */
	@Test(priority = 11, enabled = true)
	public void TEST_322_addDropDownCommandForBoolean() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		String name = new Object() {}.getClass().getEnclosingMethod().getName();
		String id = nbi.addProductCommands(name, productMasterId, Constants.DROPDOWN, "Boolean");
		Assert.assertTrue(nbi.getCommandTemplate(productMasterId, id));
		logger.log(LogStatus.PASS, "addCommandTextFieldBoolean test Completed");
		log.debug("addCommandTextFieldBoolean test Completed");

	}

	/*
	 * ADD BOOLEAN COMMANDS FOR TEXTFIELD TEST
	 */
	@Test(priority = 12, enabled = true)
	public void TEST_323_addDropDownCommandForInt() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		String name = new Object() {}.getClass().getEnclosingMethod().getName();
		String id = nbi.addProductCommands(name, productMasterId, Constants.DROPDOWN, "Int");
		Assert.assertTrue(nbi.getCommandTemplate(productMasterId, id));
		logger.log(LogStatus.PASS, "addDropDownCommandForInt test Completed");
		log.debug("addDropDownCommandForInt test Completed");

	}

	@Test(priority = 13, enabled = true)
	public void TEST_327_addDropDownCommandForString() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		String name = new Object() {}.getClass().getEnclosingMethod().getName();
		String id = nbi.addProductCommands(name, productMasterId, Constants.DROPDOWN, "String");
		Assert.assertTrue(nbi.getCommandTemplate(productMasterId, id));
		logger.log(LogStatus.PASS, "addDropDownCommandForString test Completed");
		log.debug("addDropDownCommandForString test Completed");

	}

	@Test(priority = 14, enabled = true)
	public void TEST_00_addDropDownCommandForJson() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		String name = new Object() {}.getClass().getEnclosingMethod().getName();
		String id = nbi.addProductCommands(name, productMasterId, Constants.DROPDOWN, "Json");
		Assert.assertTrue(nbi.getCommandTemplate(productMasterId, id));
		logger.log(LogStatus.PASS, "addDropDownCommandForJson test Completed");
		log.debug("addDropDownCommandForJson test Completed");

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
