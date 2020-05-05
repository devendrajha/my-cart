package io.smartnexus.ats.packagemanager;

import org.apache.log4j.Logger;
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
import junit.framework.Assert;

public class AddFullBundle {

	private static final Logger log = Logger.getLogger(AddFullBundle.class.getName());
	ExtentTest logger;
	ExtentReports extent;
	public String pmId;
	private NorthBoundInterface nbi;
	private String imageId;
	private String typeId;
	public static String packageGroupId = null;
	public static String packageId = null;

	// LoginAs Administrator
	@BeforeClass

	public void setUp() throws Exception {
		extent = ExtentManager.getInstance();
		nbi = new NorthBoundInterface();
		pmId = AddProductMaster.productMasterId;
	}

	/*
	 * ADD PACKAGE GROUP API test
	 */

	@Test(priority = 1, enabled = true)
	public void TEST_152_addPackageGroup() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		String response = nbi.addPackageGroups(pmId,"Full Bundle", "app","4.8.9");
		String[] s1 = response.split(",");
		int status = Integer.parseInt(s1[0]);
		packageGroupId = s1[1];
		Assert.assertTrue(status >= 200 && status < 205);
		logger.log(LogStatus.PASS, "add addPackageGroup test Completed");
		log.debug("add addPackageGroup test Completed");

	}

	@Test(priority = 2, enabled = true)
	public void TEST_00_getPackageTypeIdAPI() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		Assert.assertTrue(nbi.getPackageTypeId("Firmware").equals("17f7187b-51ff-4ddb-af18-31d8a007f256"));
		logger.log(LogStatus.PASS, "add getPackageTypeIdAPI test Completed");
		log.debug("add getPackageTypeIdAPI test Completed");

	}

	@Test(priority = 3, enabled = true)
	public void TEST_00_addPackageFirmwareImage() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		imageId = nbi.addPackageImage(nbi.getPackageTypeId("Firmware"));
		Assert.assertTrue(!imageId.equals(null));
		logger.log(LogStatus.PASS, "add addPackageGroup test Completed");
		log.debug("add addPackageGroup test Completed");

	}

	@Test(priority = 4, enabled = true)
	public void TEST_406_addFirmwarePackage() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		String response = nbi.addPackage(pmId, packageGroupId, nbi.getPackageTypeId("Firmware"), imageId);
		String[] s1 = response.split(",");
		int status = Integer.parseInt(s1[0]);
		packageId = s1[1];
		Assert.assertTrue(status >= 200 && status < 205);
		logger.log(LogStatus.PASS, "add addPackage test Completed");
		log.debug("add addPackage test Completed");

	}

	@Test(priority = 5, enabled = true)
	public void TEST_00_addPackageConnectionConfigImage() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		imageId = nbi.addPackageImage(nbi.getPackageTypeId("Connection Config"));
		Assert.assertTrue(!imageId.equals(null));
		logger.log(LogStatus.PASS, "add addPackageGroup test Completed");
		log.debug("add addPackageGroup test Completed");

	}

	@Test(priority = 6, enabled = true)
	public void TEST_406_addConnectionConfigPackage() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		String response = nbi.addPackage(pmId, packageGroupId, nbi.getPackageTypeId("Connection Config"), imageId);
		String[] s1 = response.split(",");
		int status = Integer.parseInt(s1[0]);
		packageId = s1[1];
		Assert.assertTrue(status >= 200 && status < 205);
		logger.log(LogStatus.PASS, "add addPackage test Completed");
		log.debug("add addPackage test Completed");

	}

	@Test(priority = 7, enabled = false)
	public void TEST_1087_getPackageBundle() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		String response = nbi.getPackageGroups(pmId);
		nbi.downloadMenifestFile(response);
		Assert.assertTrue(response.contains("https://itest.fs.smartnexus.io/"));
		logger.log(LogStatus.PASS, " getBuindle test Completed");
		log.debug("getBuindle test Completed");

	}

	@Test(priority = 8, enabled = true)
	public void TEST_406_approveManifest() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		Assert.assertTrue(nbi.approveManifes(pmId, packageGroupId));
		logger.log(LogStatus.PASS, "add addPackage test Completed");
		log.debug("add addPackage test Completed");

	}

	@Test(priority = 5, enabled = true)
	public void TEST_405_updatePackage() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		// String response =nbi.updatePackage("", packageGroupId, packageId, imageId);

		logger.log(LogStatus.PASS, "add updatePackage test Completed");
		log.debug("add updatePackage test Completed");

	}

	@Test(priority = 17, enabled = false)
	public void TEST_00_GetManifestPublicKey() throws Exception {
		logger = extent.startTest(this.getClass().getSimpleName());
		String response = nbi.signedMenifestFileAndUpload("");
		String[] s1 = response.split(",");
		int status = Integer.parseInt(s1[0]);
		String publicKey = s1[1];
		// Assert.assertEquals(Constants.PUBLIC_KEY, publicKey);
		logger.log(LogStatus.PASS, "GetManifestPublicKey test Completed");
		log.debug("GetManifestPublicKey test Completed");

	}
	/*
	 * @Test(priority = 8, enabled = true) public void signManifestFile() throws
	 * Exception { log.debug("Executing signManifestFile test"); logger =
	 * extent.startTest(this.getClass().getSimpleName()); int status =
	 * nbi.signManifestFile(cUid, packageGroupId); Assert.assertTrue(status >= 200 &
	 * status < 205); logger.log(LogStatus.PASS,
	 * " signManifestFile test Completed");
	 * log.debug("signManifestFile test Completed");
	 * 
	 * }
	 */

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
