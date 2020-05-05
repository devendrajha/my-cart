package io.smartnexus.ats.configure.product;

import java.io.IOException;
import java.net.URISyntaxException;
import org.apache.log4j.Logger;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.smartnexus.ats.utils.CommonUtils;
import io.smartnexus.ats.utils.ExtentManager;
import io.smartnexus.ats.utils.NorthBoundInterface;

public class ConfigureProductAttributes {
	private static final Logger log = Logger.getLogger(ConfigureProductAttributes.class.getName());
	private NorthBoundInterface nbi;
	ExtentTest logger;
	ExtentReports extent;
	public static String productMasterName;
	static CommonUtils cu = new CommonUtils();
	private String productMasterID;
	public String SKUID;

	// LoginAs Administrator
	@BeforeClass

	public void setUp() throws Exception {
		extent = ExtentManager.getInstance();
		nbi = new NorthBoundInterface();
		productMasterName = AddProductMaster.productLine;
		SKUID = AddProductMaster.productMasterSku;
		productMasterID = AddProductMaster.productMasterId;
	}

	/*
	 * ADD BOOLEAN ATTRIBUTE TEST
	 */
	@Test(priority = 1, enabled = true)
	public void TEST_259_addBooleanAttribute() throws ParseException, Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		nbi.addProductAttribute(productMasterID, 1, "Boolean");
		Assert.assertTrue(nbi.verifyAddedAttribute(productMasterID, 1));
		logger.log(LogStatus.PASS, "addBooleanAttribute test Completed");
		log.debug("addBooleanAttribute test Completed");

	}

	/*
	 * ADD INT ATTRIBUTE TEST
	 */
	@Test(priority = 2, enabled = true)
	public void TEST_260_addIntAttribute() throws IOException, InterruptedException, Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		nbi.addProductAttribute(productMasterID, 2, "Int");
		Assert.assertTrue(nbi.verifyAddedAttribute(productMasterID, 2));
		logger.log(LogStatus.PASS, "addIntAttribute test Completed");
		log.debug("addIntAttribute test Completed");

	}

	/*
	 * ADD BYTE ATTRIBUTE TEST
	 */
	@Test(priority = 3, enabled = true)
	public void TEST_261_addByteAttribute() throws IOException, InterruptedException, Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		nbi.addProductAttribute(productMasterID, 3, "Byte");
		Assert.assertTrue(nbi.verifyAddedAttribute(productMasterID, 3));
		logger.log(LogStatus.PASS, "addByteAttribute test Completed");
		log.debug("addByteAttribute test Completed");

	}

	/*
	 * ADD DECIMAL ATTRIBUTE TEST
	 */
	@Test(priority = 4, enabled = true)
	public void TEST_262_addDecimalAttribute() throws IOException, InterruptedException, Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		nbi.addProductAttribute(productMasterID, 4, "Decimal");
		Assert.assertTrue(nbi.verifyAddedAttribute(productMasterID, 4));
		logger.log(LogStatus.PASS, "addDecimalAttribute test Completed");
		log.debug("addDecimalAttribute test Completed");

	}

	/*
	 * ADD BIGINT ATTRIBUTE TEST
	 */
	@Test(priority = 5, enabled = true)
	public void TEST_263_addBigIntAttribute() throws IOException, InterruptedException, Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		nbi.addProductAttribute(productMasterID, 5, "BigInt");
		Assert.assertTrue(nbi.verifyAddedAttribute(productMasterID, 5));
		logger.log(LogStatus.PASS, "addBigIntAttribute test Completed");
		log.debug("addBigIntAttribute test Completed");

	}

	/*
	 * ADD STRING ATTRIBUTE TEST
	 */
	@Test(priority = 6, enabled = true)
	public void TEST_264_addStringAttribute() throws IOException, InterruptedException, Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		nbi.addProductAttribute(productMasterID, 6, "String");
		Assert.assertTrue(nbi.verifyAddedAttribute(productMasterID, 6));
		logger.log(LogStatus.PASS, "addStringAttribute test Completed");
		log.debug("addStringAttribute test Completed");

	}

	/*
	 * ADD FLOAT ATTRIBUTE TEST
	 */
	@Test(priority = 7, enabled = true)
	public void TEST_265_addFloatAttribute() throws IOException, InterruptedException, Exception {
		log.debug("Executing addFloatAttribute test");
		logger = extent.startTest(this.getClass().getSimpleName());
		nbi.addProductAttribute(productMasterID, 7, "Float");
		Assert.assertTrue(nbi.verifyAddedAttribute(productMasterID, 7));
		logger.log(LogStatus.PASS, "addFloatAttribute test Completed");
		log.debug("addFloatAttribute test Completed");

	}

	/*
	 * ADD DOUBLE ATTRIBUTE TEST
	 */
	@Test(priority = 8, enabled = true)
	public void TEST_266_addDoubleAttribute() throws IOException, InterruptedException, Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		nbi.addProductAttribute(productMasterID, 8, "Double");
		Assert.assertTrue(nbi.verifyAddedAttribute(productMasterID, 8));
		logger.log(LogStatus.PASS, "addDoubleAttribute test Completed");
		log.debug("addDoubleAttribute test Completed");

	}

	/*
	 * ADD LDOUBLE ATTRIBUTE TEST
	 */
	@Test(priority = 9, enabled = true)
	public void TEST_267_addLDoubleAttribute() throws IOException, InterruptedException, Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		nbi.addProductAttribute(productMasterID, 9, "LDouble");
		Assert.assertTrue(nbi.verifyAddedAttribute(productMasterID, 9));
		logger.log(LogStatus.PASS, "addLDoubleAttribute test Completed");
		log.debug("addLDoubleAttribute test Completed");

	}

	/*
	 * ADD Json Attribute TEST
	 */
	@Test(priority = 10, enabled = true)
	public void TEST_946_addJsonAttribute() throws IOException, InterruptedException, Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		nbi.addProductAttribute(productMasterID, 10, "Json");
		Assert.assertTrue(nbi.verifyAddedAttribute(productMasterID, 10));
		logger.log(LogStatus.PASS, "addJsonAttribute test Completed");
		log.debug("addJsonAttribute test Completed");

	}

	/*
	 * ADD INT ATTRIBUTE TEST
	 */
	@Test(priority = 11, enabled = true)
	public void TEST_268_addIntAttributeWithMinMax() throws IOException, InterruptedException, IllegalStateException, ParseException, URISyntaxException {
		log.debug("Executing addIntAttributeWithMinMax test");
		logger = extent.startTest(this.getClass().getSimpleName());
		int status = nbi.addAttributeWithConstarintsProduct(productMasterID, 11, "Int");
		Assert.assertTrue(200 <= status & status <= 205);
		logger.log(LogStatus.PASS, "addIntAttributeWithMinMax test Completed");
		log.debug("addIntAttributeWithMinMax test Completed");

	}

	/*
	 * EDIT ATTRIBUTES TEST
	 */
	@Test(priority = 12, enabled = true)
	public void TEST_269_editProductAttributes() throws IOException, InterruptedException, IllegalStateException, ParseException, URISyntaxException {
		logger = extent.startTest(this.getClass().getSimpleName());
		int status = nbi.updateProductAttribute(productMasterID, 3, "Byte");
		Assert.assertTrue(200 <= status & status <= 205);
		logger.log(LogStatus.PASS, "editProductAttributes test Completed");
		log.debug("editProductAttributes test Completed");

	}

	/*
	 * VERIFY ADD ATTRIBUTE WITH DULICATE LOCAL ID TEST
	 */
	@Test(priority = 13, enabled = true)
	public void TEST_947_verifyAddAttributeWithDulicateLocalId() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		String response = nbi.addProductAttribute(productMasterID, 6, "String");
		String[] s1 = response.split(",");
		Assert.assertTrue(s1[2].contains("Local id already exists."));
		logger.log(LogStatus.PASS, "verifyAddAttributeWithDulicateLocalId test Completed");
		log.debug("verifyAddAttributeWithDulicateLocalId test Completed");

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
