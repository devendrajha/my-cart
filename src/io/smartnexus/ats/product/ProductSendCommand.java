package io.smartnexus.ats.product;

import java.util.List;

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
import io.smartnexus.ats.utils.ExtentManager;
import io.smartnexus.ats.utils.NorthBoundInterface;
import io.smartnexus.ats.utils.TestNgParameters;

public class ProductSendCommand {
	private static final Logger log = Logger.getLogger(ProductSendCommand.class.getName());
	ExtentTest logger;
	ExtentReports extent;
	public static String vpId, pmId = null;
	private NorthBoundInterface nbi;
	TestNgParameters tng = new TestNgParameters();

	// LoginAs Administrator
	@BeforeClass

	public void setUp() throws Exception {
		extent = ExtentManager.getInstance();
		pmId = AddProductMaster.productMasterId;
		nbi = new NorthBoundInterface();
		vpId = ProductUpdateAttributesValue.virtualProdId;
	}

	@Test(priority = 1, enabled = true)
	public void TEST_00_sendCommandNA() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		nbi.sendCommands(vpId, pmId, "TEST_00_addCommandNA", "Static", "1");
		List<String> list = nbi.getCommandHistory(pmId, vpId, "TEST_00_addCommandNA");
		Assert.assertTrue(list.contains("Pending") && list.contains("TEST_00_addCommandNA"));
		logger.log(LogStatus.PASS, "addCommandNA test Completed");
		log.debug("addCommandNA test Completed");

	}

	@Test(priority = 2, enabled = true)
	public void TEST_303_sendCommandCheckboxBoolean() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		nbi.sendCommands(vpId, pmId, "TEST_303_addCommandCheckboxBoolean", "Static", "1");
		List<String> list = nbi.getCommandHistory(pmId, vpId, "TEST_303_addCommandCheckboxBoolean");
		Assert.assertTrue(list.contains("Pending") && list.contains("1"));
		logger.log(LogStatus.PASS, "sendCommandCheckboxBoolean test Completed");
		log.debug("sendCommandCheckboxBoolean test Completed");

	}

	@Test(priority = 3, enabled = true)
	public void TEST_322_sendSysDateCommandForBoolean() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		nbi.sendCommands(vpId, pmId, "TEST_322_addSysDateCommandForBoolean", "Static", "1");
		List<String> list = nbi.getCommandHistory(pmId, vpId, "TEST_322_addSysDateCommandForBoolean");
		Assert.assertTrue(list.contains("Pending") && list.contains("TEST_322_addSysDateCommandForBoolean"));
		logger.log(LogStatus.PASS, "addSysDateCommandForBoolean test Completed");
		log.debug("addSysDateCommandForBoolean test Completed");

	}

	@Test(priority = 4, enabled = true)
	public void TEST_323_sendSysDateCommandForInt() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		nbi.sendCommands(vpId, pmId, "TEST_323_addSysDateCommandForInt", "Static", "8");
		List<String> list = nbi.getCommandHistory(pmId, vpId, "TEST_323_addSysDateCommandForInt");
		Assert.assertTrue(list.contains("Pending") && list.contains("TEST_323_addSysDateCommandForInt"));
		logger.log(LogStatus.PASS, "addSysDateCommandForInt test Completed");
		log.debug("addSysDateCommandForInt test Completed");

	}

	@Test(priority = 5, enabled = true)
	public void TEST_327_sendSysDateCommandForString() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		nbi.sendCommands(vpId, pmId, "TEST_327_addSysDateCommandForString", "Static",
				"TEST_327_addSysDateCommandForString");
		List<String> list = nbi.getCommandHistory(pmId, vpId, "TEST_327_addSysDateCommandForString");
		Assert.assertTrue(list.contains("Pending") && list.contains("TEST_327_addSysDateCommandForString"));
		logger.log(LogStatus.PASS, "addSysDateCommandForString test Completed");
		log.debug("addSysDateCommandForString test Completed");

	}

	@Test(priority = 6, enabled = true)
	public void TEST_327_sendSysDateCommandForJson() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		int status = nbi.sendCommands(vpId, pmId, "TEST_327_addSysDateCommandForJson", "Static", "{}");
		Assert.assertTrue(200 <= status & status <= 205);
		logger.log(LogStatus.PASS, "addSysDateCommandForJson test Completed");
		log.debug("addSysDateCommandForJson test Completed");

	}

	@Test(priority = 7, enabled = true)
	public void TEST_313_sendCommandTextBoolean() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		nbi.sendCommands(vpId, pmId, "TEST_313_addCommandTextBoolean", "Static", "1");
		List<String> list = nbi.getCommandHistory(pmId, vpId, "TEST_313_addCommandTextBoolean");
		Assert.assertTrue(list.contains("Pending") && list.contains("1"));
		logger.log(LogStatus.PASS, "addCommandTextBoolean test Completed");
		log.debug("addCommandTextBoolean test Completed");

	}

	@Test(priority = 8, enabled = true)
	public void TEST_314_sendCommandTextInt() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		nbi.sendCommands(vpId, pmId, "TEST_314_addCommandTextInt", "Static", "16");
		List<String> list = nbi.getCommandHistory(pmId, vpId, "TEST_314_addCommandTextInt");
		Assert.assertTrue(list.contains("Pending") && list.contains("16"));
		logger.log(LogStatus.PASS, "addCommandTextInt test Completed");
		log.debug("addCommandTextInt test Completed");

	}

	@Test(priority = 9, enabled = true)
	public void TEST_318_sendCommandTextString() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		nbi.sendCommands(vpId, pmId, "TEST_318_addCommandTextString", "Static", "TEST_318_addCommandTextString");
		List<String> list = nbi.getCommandHistory(pmId, vpId, "TEST_318_addCommandTextString");
		Assert.assertTrue(list.contains("Pending") && list.contains("TEST_318_addCommandTextString"));
		logger.log(LogStatus.PASS, "addCommandTextString test Completed");
		log.debug("addCommandTextString test Completed");

	}

	@Test(priority = 10, enabled = true)
	public void TEST_321_sendCommandTextJson() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		int status = nbi.sendCommands(vpId, pmId, "TEST_321_addCommandTextJson", "Static", "{}");
		Assert.assertTrue(200 <= status & status <= 205);
		logger.log(LogStatus.PASS, "addCommandTextJson test Completed");
		log.debug("addCommandTextJson test Completed");

	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test(priority = 11, enabled = true)
	public void TEST_313_sendCommandDropDownBoolean() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		nbi.sendCommands(vpId, pmId, "TEST_322_addDropDownCommandForBoolean", "Static", "1");
		List<String> list = nbi.getCommandHistory(pmId, vpId, "TEST_322_addDropDownCommandForBoolean");
		Assert.assertTrue(list.contains("Pending") && list.contains("1"));
		logger.log(LogStatus.PASS, "sendCommandDropDownBoolean test Completed");
		log.debug("sendCommandDropDownBoolean test Completed");

	}

	@Test(priority = 12, enabled = true)
	public void TEST_314_sendCommandDropDownInt() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		nbi.sendCommands(vpId, pmId, "TEST_323_addDropDownCommandForInt", "Static", "16");
		List<String> list = nbi.getCommandHistory(pmId, vpId, "TEST_323_addDropDownCommandForInt");
		Assert.assertTrue(list.contains("Pending") && list.contains("16"));
		logger.log(LogStatus.PASS, "sendCommandDropDownInt test Completed");
		log.debug("sendCommandDropDownInt test Completed");

	}

	@Test(priority = 13, enabled = true)
	public void TEST_318_sendCommandDropDownString() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		nbi.sendCommands(vpId, pmId, "TEST_327_addDropDownCommandForString", "Static", "TEST_327_addDropDownCommandForString");
		List<String> list = nbi.getCommandHistory(pmId, vpId, "TEST_327_addDropDownCommandForString");
		Assert.assertTrue(list.contains("Pending") && list.contains("TEST_327_addDropDownCommandForString"));
		logger.log(LogStatus.PASS, "sendCommandDropDownString test Completed");
		log.debug("sendCommandDropDownString test Completed");

	}

	@Test(priority = 14, enabled = true)
	public void TEST_1097_sendCommandDropDownJson() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		int status = nbi.sendCommands(vpId, pmId, "TEST_00_addDropDownCommandForJson", "Static", "{}");
		Assert.assertTrue(200 <= status & status <= 205);
		logger.log(LogStatus.PASS, "sendCommandDropDownJson test Completed");
		log.debug("sendCommandDropDownJson test Completed");

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
