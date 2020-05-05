package io.smartnexus.ats.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class WebInterfaceWrapper {
	private WebDriver driver;
	private static WebInterfaceWrapper webInterfaceWrapper;
	static ExtentTest logger;

	/**
	 * This method is used to get the driver instance
	 *
	 * @return - driver instance
	 */
	public WebDriver getDriver() {
		return driver;
	}

	/**
	 * Constructor encapsulation
	 */
	private WebInterfaceWrapper() {

	}

	/**
	 * Constructor with driver argument
	 *
	 * @param driver
	 */
	public WebInterfaceWrapper(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Singleton WebInterface wrapper instance
	 *
	 * @return
	 */
	public static WebInterfaceWrapper getWebInterfaceWrapperInstance() {
		if (webInterfaceWrapper == null) {
			webInterfaceWrapper = new WebInterfaceWrapper();
			BasicConfigurator.configure();
		}
		return webInterfaceWrapper;
	}

	private static final Logger log = Logger.getLogger(WebInterfaceWrapper.class.getName());

	/**
	 * This method used to get text by using xpath key
	 *
	 * @param cssKey WebElement xpath identifier
	 * @return the text for the particular element
	 */
	public String getText(String cssKey) {
		log.debug("Executing getText...");
		String text = null;
		try {
			waitUntilElementVisible(cssKey);
			text = driver.findElement(By.cssSelector(cssKey)).getText();
			System.out.println("WELCOME TO TEXT1:" + text);
		} catch (Exception e) {
			throw e;
		}
		return text;
	}

	/**
	 * THIS METHOD WILL BE DEPRECATED
	 */
	public void waitUntilCSSElementInvisiblity(String cssKey) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT);
			log.debug("Sync up for the next element..." + cssKey);
			wait.until(ExpectedConditions.invisibilityOfElementLocated((By.cssSelector(cssKey))));
		} catch (Exception e) {
			log.error("Element is not visible on the page", e);
		}

	}

	/**
	 * This method used to Check web element is enabled by using xpath key
	 *
	 * @param cssKey WebElement xpath identifier
	 * @return true if the web element is enabled on a web page
	 */
	public boolean isEnabled(String cssKey) {
		log.debug("Executing isEnabled...");
		waitUntilElementVisible(cssKey);
		int count = driver.findElements(By.cssSelector(cssKey)).size();
		if (count != 0) {
			return true;
		} else
			return false;
	}

	/**
	 * This method used to Wait until given element appears on page
	 */
	public void waitUntilSaveComplete(String cssKey) {
		log.debug("Executing waitUntilSaveComplete...");
		try {
			WebDriverWait wait = new WebDriverWait(driver, 120);
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssKey)));
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * This method used to Open browser using browser type constant
	 *
	 * @param cssKey WebElement xpath identifier
	 * @return true if the radio button is selected on a web page
	 */
	public boolean isSelected(String cssKey) {
		log.debug("Executing isSelected...");
		boolean status = false;
		try {
			waitUntilElementVisible(cssKey);
			status = driver.findElement(By.cssSelector(cssKey)).isSelected();
		} catch (Exception e) {
			e.getMessage();

		}
		return status;
	}

	/**
	 * This method used to navigate to the specific url
	 */
	public void navigate(String urlKey) {
		log.debug("Executing navigate...");
		try {
			driver.get(urlKey);
			driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * This method used to get the title on current web page
	 *
	 * @return title of the current web page
	 */
	public String getTitle() {
		String title;
		log.debug("Executing get title...");
		title = driver.getTitle();
		return title;
	}

	/**
	 * This method is used to accept the alert
	 */

	public void handleAlertAccept() {
		try {
			Alert alert = driver.switchTo().alert();
			log.debug("Alert: " + alert.toString());
			log.debug("Alert: " + alert.getText());
			alert.accept();
		} catch (NoAlertPresentException e) {
			throw e;
		}

	}

	/**
	 * This method is used to dismiss the alert
	 */

	public void handleAlertDismiss() {
		try {
			Alert alert = driver.switchTo().alert();
			log.debug("Alert: " + alert.toString());
			log.debug("Alert: " + alert.getText());
			alert.dismiss();
		} catch (NoAlertPresentException e) {

		}

	}

	/**
	 * This method is used to get the list of values as an array from the drop
	 *
	 * @param cssKey the xpath to find the drop down in the UI whose values are
	 *               returned
	 * @return an array of Strings for the possible selections in the drop down
	 */
	public String[] getDropDownValues(String cssKey) {
		String[] values = null;
		try {
			waitUntilElementVisible(cssKey);
			WebElement element = driver.findElement(By.cssSelector(cssKey));
			Select dropDown = new Select(element);
			values = new String[dropDown.getOptions().size()];
			int i = 0;
			for (WebElement option : dropDown.getOptions()) {
				values[i] = option.getText();
				i++;
			}
		} catch (Exception e) {
			throw e;
		}
		return values;
	}

	/**
	 * This method is used to wait for the element to be visible on a web page
	 *
	 * @param cssKey WebElement xpath identifier
	 */
	public void waitUntilElementVisible(String cssKey) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT);
			log.debug("Sync up for the next element..." + cssKey);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssKey)));
		} catch (Exception e) {
			log.error("Element is not visible on the page", e);
		}
	}

	/**
	 * This method is used to switch to the new window
	 *
	 * @param mainWindow - Parent window
	 */
	public void switchWindow(String mainWindow) {
		try {
			log.debug("Switching to a new window");
			Set<String> handlers = driver.getWindowHandles();
			for (String handler : handlers) {
				if (!handler.equals(mainWindow)) {
					driver.switchTo().window(handler);
					break;
				}
			}
		} catch (Exception e) {
			throw e;
			// log.error("Not able to switch to a window", e);
		}
	}

	/**
	 * This method is used to verify whether an element is displayed on a web page
	 *
	 * @param cssKey WebElement xpath identifier
	 * @return true if the WebElement is displayed on a web page
	 */

	public boolean isDisplayed(String cssKey) {
		boolean status = false;
		try {
			waitUntilElementVisible(cssKey);
			status = driver.findElement(By.cssSelector(cssKey)).isDisplayed();
			log.debug("Verifying element displayed: " + status);
		} catch (Exception e) {
		}
		return status;

	}

	/*
	 * SendKeys : Method used to enter the values in the text box
	 * 
	 * @param cssKey WebElement xpath identifier
	 * 
	 * @param strValue - input string to be passed
	 */

	public void sendKeys(String cssKey, String strValue) {
		try {
			waitUntilElementVisible(cssKey);
			driver.findElement(By.cssSelector(cssKey)).sendKeys(strValue);
			log.debug("Entered " + strValue + " value in " + cssKey + " text box");
		} catch (Exception e) {
			throw e;
		}
	}

	/*
	 * This method used to perform the click operation button
	 * 
	 * @param cssKey WebElement xpath identifier
	 */

	public void click(String cssKey) {
		try {
			waitUntilElementVisible(cssKey);
			waitForElementToBeClickable(cssKey);
			driver.findElement(By.cssSelector(cssKey)).click();
			log.debug("Clicked " + cssKey + " button");
		} catch (Exception e) {
			throw e;
		}
	}

	/*
	 * This method used to clear the value from the text box
	 * 
	 * @param cssKey WebElement xpath identifier
	 */

	public void clear(String cssKey) {
		try {
			waitUntilElementVisible(cssKey);
			driver.findElement(By.cssSelector(cssKey)).clear();
			log.debug("Cleared " + cssKey + " text box");
		} catch (Exception e) {
			throw e;
			// log.error(cssKey + "Unable to clear Value in " + cssKey + "
			// text box", e);
		}
	}

	/*
	 * This method used to select the value from dropdown using visible text
	 * 
	 * @param cssKey WebElement xpath identifier
	 * 
	 * @param strValue Input text to be selected on drop down
	 */

	public void selectValue(String cssKey, String strValue) {
		WebElement element = driver.findElement(By.cssSelector(cssKey));
		try {
			waitUntilElementVisible(cssKey);
			Select select = new Select(element);
			select.selectByVisibleText(strValue);
			log.debug(strValue + " item is selected in " + cssKey + " dropdown");

		} catch (Exception e) {
			throw e;
			// log.error("Unable to select the item " + strValue + " in " +
			// cssKey + " dropdown", e);
		}
	}

	/*
	 * This method used to change the position of object
	 * 
	 * @param cssKey WebElement xpath identifier
	 * 
	 * @param strValue source object
	 * 
	 * @param strValue1 destination object
	 */

	public void Slider(String cssKey, int strValue, int strValue1) {
		try {
			waitUntilElementVisible(cssKey);
			WebElement element = driver.findElement(By.cssSelector(cssKey));
			Actions builder = new Actions(driver);
			builder.clickAndHold(element).moveByOffset(strValue, strValue1).release().build().perform();
			log.debug(cssKey + "Slider Action performed ");
		} catch (Exception e) {
			throw e;
			// log.error(cssKey + "Unable to Perform slider action ", e);

		}

	}

	/*
	 * This method used to perform drag and drop the objects
	 * 
	 * @param sourceKey source WebElement xpath identifier
	 * 
	 * @param destinationKey destination WebElement xpath identifier
	 */

	public void dragDrop(String sourceKey, String destinationKey) {
		try {
			waitUntilElementVisible(sourceKey);
			WebElement dragElement = driver.findElement(By.cssSelector(sourceKey));
			waitUntilElementVisible(destinationKey);
			WebElement dropElement = driver.findElement(By.cssSelector(destinationKey));
			Actions builder = new Actions(driver);
			Action dragAndDrop = builder.clickAndHold(dragElement).moveToElement(dropElement).release(dropElement).build();
			dragAndDrop.perform();
			log.debug(sourceKey + "," + destinationKey + "Drag and drop and action performed ");
		} catch (Exception e) {
			throw e;
			// log.error(sourceKey + "," + destinationKey + "Unable to perform
			// drag and drop action ", e);
		}
	}

	/**
	 * This method is used to wait for title to be present on a web page
	 *
	 * @param title - Web page title
	 */

	public void waitForTitle(String title) {
		log.debug("Executing waitForTitle...");
		try {
			WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT);
			wait.until(ExpectedConditions.titleIs(title));
		} catch (Exception e) {
			throw e;
			// log.error("Fail - Title not visible during wait until", e);
		}
	}

	/**
	 * This method is used to send the keyboard event enter
	 *
	 * @param cssKey WebElement xpath identifier
	 */

	public void pressEnter(String cssKey) {
		waitUntilElementVisible(cssKey);
		driver.findElement(By.cssSelector(cssKey)).sendKeys(Keys.ENTER);
	}

	/**
	 * This method is used to switch to the new window
	 *
	 * @param window ; 0 - Parent window, 1- NewWindow
	 */
	public void switchWindow(int window) {
		try {
			Set<String> handles = driver.getWindowHandles();
			String[] individualHandle = new String[handles.size()];
			Iterator<String> it = handles.iterator();
			int i = 0;
			while (it.hasNext()) {
				individualHandle[i] = (String) it.next();
				i++;
			}
			driver.switchTo().window(individualHandle[window]);
			log.debug(window + "window value");
			log.debug("Current URL:" + driver.getCurrentUrl());
		} catch (Exception e) {
			throw e;
			// log.error("Unable to switch to a new window", e);
		}
	}

	/**
	 * THIS METHOD WILL BE DEPRECATED
	 */

	public int generateRandomNumber() {
		double a = Math.random();
		int threeDigit = (int) (a * 1000);
		return threeDigit;
	}

	/**
	 * This method is used to verify whether an element is displayed on a web page
	 * without wait factor
	 *
	 * @param cssKey WebElement xpath identifier
	 */

	public boolean isDisplayedWithoutWait(String cssKey) {
		boolean status = false;
		try {
			status = driver.findElement(By.cssSelector(cssKey)).isDisplayed();
			log.debug("Verifying element displayed: " + status);
		} catch (Exception e) {

			log.error("Element is not displayed", e);
		}
		return status;

	}

	/**
	 * This method used to perform the click operation on Link
	 *
	 * @param text - Link text to be clicked
	 */

	public void clickOnLink(String text) {
		try {
			WebElement element = driver.findElement(By.linkText(text));
			element.click();
			log.debug("Clicked " + text + " button");
		} catch (Exception e) {
			throw e;
			// log.error("Unable to click the" + text + " button ", e);
		}
	}

	/**
	 * This method used to perform the click operation on partial matches of link
	 *
	 * @param text - partial link text to be clicked
	 */

	public void clickOnPartialTextLink(String text) {
		try {
			WebElement element = driver.findElement(By.partialLinkText(text));
			element.click();
			log.debug("Clicked " + text + " button");
		} catch (Exception e) {
			throw e;
			// log.error("Unable to click the" + text + " button ", e);
		}

	}

	/**
	 * This method used to perform the right click operation on element
	 *
	 * @param cssKey WebElement xpath identifier
	 */
	public void rightClickOnElement(String cssKey) {
		try {
			Actions actions = new Actions(driver);
			Action action = actions.contextClick(driver.findElement(By.cssSelector(cssKey))).build();
			action.perform();
			log.debug("Clicked " + cssKey + " button");
		} catch (Exception e) {
			throw e;

			// log.error("Unable to right click the" + cssKey + " button ",
			// e);
		}
	}

	/**
	 * This method used to perform the Mouse-over operation on element
	 *
	 * @param cssKey WebElement xpath identifier
	 */
	public void mouseOverOnElement(String cssKey) {
		try {
			Actions actions = new Actions(driver);
			Action action = actions.moveToElement(driver.findElement(By.cssSelector(cssKey))).build();
			action.perform();
			log.debug("Mouse-over " + cssKey);
		} catch (Exception e) {
			throw e;

			// log.error("Unable to right click the" + cssKey + " button ",
			// e);
		}
	}

	/**
	 * This method is used to wait for the element until it is clickable
	 *
	 * @param cssKey WebElement xpath identifier
	 * @throws Exception
	 */
	public void waitForElementToBeClickable(String cssKey) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssKey)));
			Thread.sleep(2000);
		} catch (Exception e) {

			// log.error("Element is not displayed", e);
		}
	}

	/**
	 * This method is used to wait for certain text to appear on Web Element
	 *
	 * @param cssKey       WebElement xpath identifier
	 * @param textToAppear expected text to be appeared on a web page
	 */
	public void waitUntilTextAppears(String cssKey, String textToAppear) {
		int timeOut = 20;
		int count = 1;
		while (!driver.findElement(By.cssSelector(cssKey)).getText().contains(textToAppear)) {
			waitFor(1);
			if (count > timeOut) {
				log.error("Element is not displayed Until 20 seconds");
				break;
			}
			count++;
		}
	}

	/**
	 * This method is used to wait for certain seconds
	 *
	 * @param x in seconds
	 */
	public static void waitFor(int x) {
		try {
			log.debug("Sleeping for " + x + " seconds..");
			Thread.sleep(x * 1000);
		} catch (InterruptedException e) {
			// log.error("Error occurred", e);
		}
	}

	/**
	 * This method is used to Send text to input field
	 *
	 * @param cssKey WebElement xpath identifier
	 * @key Keyboard actions object to be passed
	 */

	public void sendKeys(String cssKey, Keys key) {
		try {
			waitUntilElementVisible(cssKey);
			driver.findElement(By.cssSelector(cssKey)).sendKeys(key);
			log.debug("Entered " + key + " value in " + cssKey + " text box");
		} catch (Exception e) {
			throw e;
			// log.error("Unable to enter value in " + cssKey + " text box",
			// e);
		}

	}

	/**
	 * This Method used to find dynamic xpath for a web element
	 *
	 * @param cssKey WebElement xpath identifier
	 * @return elements in a list
	 */
	public List<WebElement> getWebElements(String cssKey) {
		List<WebElement> elements = null;
		try {
			elements = driver.findElements(By.cssSelector(cssKey));
		} catch (Exception e) {
			throw e;
			// log.debug("Fail - not able find the elements", e);
		}
		return elements;
	}

	/**
	 * THIS METHOD WILL BE DEPRECATED
	 */
	public StringBuffer randomName() {
		String chars = "abcdefghijklmnopqrstuvwxyz";
		StringBuffer buf = null;
		try {
			Random r = new Random();
			int limit = Constants.IN_RANDOM_NUMBER_LENGTH;
			buf = new StringBuffer();
			buf.append(chars.charAt(r.nextInt(26)));
			for (int i = 0; i < limit; i++) {
				buf.append(chars.charAt(r.nextInt(chars.length())));
			}
		} catch (Exception e) {
			throw e;

			// log.error("Fail - not able to generate random text for", e);
		}
		return buf;
	}

	/**
	 * This method is used to verify element not displayed
	 *
	 * @param cssKey WebElement xpath identifier
	 * @return true if the WebElement is not displayed on a web page
	 */
	public List<WebElement> isNotDisplayed(String cssKey) {
		List<WebElement> status = null;
		try {
			status = driver.findElements(By.cssSelector(cssKey));
			Assert.assertTrue(status.isEmpty());
			log.debug("Verifying element not displayed:true");
		} catch (Exception e) {
			throw e;
			// log.error("Fail - not able to generate random text for", e);
		}
		return status;
	}

	/**
	 * This method is used to generate random Firmware Versions
	 *
	 * @return firmware version
	 */

	public String randomFirmwareVersion() {
		String firmwareVersion = null;
		try {
			double a = Math.random();
			int firstDigit = (int) (a * 100);
			int secondDigit = (int) (a * 100);
			int thirdDigit = (int) (a * 1000);
			firmwareVersion = "V1" + "." + firstDigit + "." + secondDigit + "." + thirdDigit;
		} catch (Exception e) {
			throw e;
			// log.error("Fail - not able to generate random Firmware Versions",
			// e);
		}
		return firmwareVersion;
	}

	/**
	 * THIS METHOD WILL BE DEPRECATED
	 */

	public String randomFirwmareVersion() {
		String firmwareVersion = null;
		try {
			double a = Math.random();
			int firstDigit = (int) (a * 100);
			int secondDigit = (int) (a * 100);
			int thirdDigit = (int) (a * 1000);
			firmwareVersion = "V1" + "." + firstDigit + "." + secondDigit + "." + thirdDigit;
		} catch (Exception e) {
			throw e;
			// log.error("Fail - not able to generate random Firmware Versions",
			// e);
		}
		return firmwareVersion;
	}

	/**
	 * THIS METHOD WILL BE DEPRECATED
	 */

	public String randomDate() {
		String DATE_FORMAT_NOW = "dd/MM/yyyy";
		Calendar cal = null;
		SimpleDateFormat sdf = null;
		try {
			cal = Calendar.getInstance();
			sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
		} catch (Exception e) {
			throw e;
			// log.error("Fail - not able to generate generate Calendar
			// Instance", e);
		}
		return sdf.format(cal.getTime());
	}

	/**
	 * THIS METHOD WILL BE DEPRECATED
	 */
	public int generateRandomOui() {
		int oui = 0;
		try {
			Random rnd = new Random();
			oui = 100000 + rnd.nextInt(900000);
			return oui;
		} catch (Exception e) {
			// log.error("Error while generating Random oui", e);
		}
		return oui;
	}

	/**
	 * This method is used to select random value in dropdown
	 *
	 * @param cssKey WebElement xpath identifier
	 * @return random value from the expected drop down locator
	 */
	public void randomSelectValue(String cssKey) {
		WebElement options = driver.findElement(By.cssSelector(cssKey));
		try {
			String text = options.getText();
			String[] ddlCount = text.split("\n");
			int idx = new Random().nextInt(ddlCount.length);
			String random = (ddlCount[idx]);
			Select s1 = new Select(options);
			s1.selectByVisibleText(random);
			log.debug(random);
			log.debug("Selected random value from dropdown" + "" + random);
		} catch (Exception e) {
			throw e;
			// log.error("Unable to select the item in " + cssKey + "
			// dropdown", e);
		}
	}

	/**
	 * This Method used to select the value from dropdown using index
	 *
	 * @param cssKey WebElement xpath identifier
	 * @index location of the dropdown value Eg. 0 - first drop down value, 1 -
	 *        second drop down value
	 */
	public void selectValueByIndex(String cssKey, int index) {
		WebElement element = driver.findElement(By.cssSelector(cssKey));
		try {
			waitUntilElementVisible(cssKey);
			Select select = new Select(element);
			select.selectByIndex(index);

			log.debug(index + " item is selected in " + cssKey + " dropdown");
		} catch (Exception e) {
			throw e;
			// log.error("Unable to select the item " + index + " in " +
			// cssKey + " dropdown", e);
		}
	}

	/**
	 * dynamicXPATH : Method used to find dynamic xpath THIS METHOD WILL BE
	 * DEPRECATED
	 *
	 * @return
	 */
	public List<WebElement> administrationTableRow(String cssKey) {
		List<WebElement> result = null;
		try {
			result = driver.findElements(By.cssSelector(cssKey));
		} catch (Exception e) {
			throw e;
			// log.error("Fail - not able find the elements", e);
		}
		return result;
	}

	/*
	 * This Method used to find dynamic xpath THIS METHOD WILL BE DEPRECATED
	 * 
	 * @param cssKey WebElement xpath identifier
	 */

	public WebElement dynamicXPATH(String cssKey) {
		WebElement element = null;
		try {
			element = driver.findElement(By.cssSelector(cssKey));
		} catch (Exception e) {
			throw e;
			// log.error("Fail - not able to get the find elements", e);
		}
		return element;
	}

	/**
	 * This Method used to switch the driver to window or default content
	 */

	public void switchDefaultContent() {
		try {
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			throw e;
			// log.error("Fail - Unable to switch to default window", e);
		}
	}

	/**
	 * This Method used to switch the driver to frames
	 *
	 * @param cssKey WebElement xpath identifier
	 * @return
	 */

	public void switchToFrame(String cssKey) {
		try {
			driver.switchTo().frame(driver.findElement(By.cssSelector(cssKey)));
		} catch (Exception e) {
			throw e;
			// log.error("Fail - Unable to switch to frame window", e);
		}
	}

	/**
	 * This Method used to get the size of rows present in the table
	 *
	 * @param cssKey WebElement xpath identifier
	 * @return rows size of a table
	 */

	public int getRowSize(String cssKey) {
		int result = 0;
		try {
			result = driver.findElements(By.cssSelector(cssKey)).size();
		} catch (Exception e) {
			throw e;
			// log.error("Fail - Unable to get the row size", e);
		}
		return result;
	}

	/**
	 * getAttributeValue : Method used to locate element using its attribute
	 *
	 * @param cssKey WebElement xpath identifier
	 * @return the attribute value for the WebElement
	 */
	public String getAttributeValue(String cssKey) {
		String text = null;
		try {
			waitUntilElementVisible(cssKey);
			text = driver.findElement(By.cssSelector(cssKey)).getAttribute("value");
		} catch (Exception e) {
			throw e;
			// log.error("Fail - not able to get attribute value for", e);
		}
		return text;
	}

	/**
	 * This Method used to locate element using CSS Selector
	 *
	 * @param cssKey css identifier for the WebElement
	 * @return the text for the WebElement
	 */
	public WebElement getSvgElementCSSSelector(String cssKey) {
		WebElement text = null;
		try {
			text = driver.findElement(By.cssSelector(cssKey));
		} catch (Exception e) {
			throw e;
			// log.error("Fail - not able to find element using CSS Selector",
			// e);
		}
		return text;
	}

	/**
	 * This method is used toGet the Elements with which we want to interact in a
	 * list value
	 *
	 * @param svgElement
	 * @param cssKey     css identifier for the WebElement
	 * @return the list of WebElements
	 */
	public List<WebElement> svgElementsCSSSelector(WebElement svgElement, String cssKey) {
		List<WebElement> result = null;
		try {
			result = ((svgElement).findElements(By.cssSelector(cssKey)));
		} catch (Exception e) {
			throw e;
			// log.error("Fail - not able to find elements using CSS Selector",
			// e);
		}
		return result;
	}

	/**
	 * This method is used to wait for the user creation
	 *
	 * @throws InterruptedException
	 */

	public void waitForUserCreation() throws InterruptedException {
		log.debug("User created. Please wait for few seconds.....");
		Thread.sleep(30000);
	}

	/**
	 * This method is used to wait for the login session to be expired
	 *
	 * @throws InterruptedException
	 */

	public void waitForLoginSessionExpire() throws InterruptedException {
		log.debug("Waiting for Login Session Expire. It will take few seconds.....");
		Thread.sleep(80000);
	}

	/**
	 * This Method Used to close the window
	 *
	 * @return
	 */
	public void closeWindow() {
		try {
			driver.close();
		} catch (Exception e) {
			log.error("Fail - Unable to close window", e);
		}
	}

	/*
	 * This Method Used to click hidden element using javascript
	 * 
	 * @param webElement- WebElement
	 */
	public Object javaScriptClick(WebElement webElement) {
		Object jsElement = null;
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			jsElement = js.executeScript("arguments[0].click();", webElement);
		} catch (Exception e) {
			throw e;
			// log.error("Fail - Unable to find hidden elements", e);
		}
		return jsElement;
	}

	/**
	 * This Locator used to find element using partial link text
	 *
	 * @param linkTextKey
	 * @return WebElement
	 */

	public WebElement getPartialLinkText(String linkTextKey) {
		log.debug("Executing find element using Partial Link Text Selector...");
		WebElement element = null;
		try {
			element = driver.findElement(By.partialLinkText(linkTextKey));
		} catch (Exception e) {
			throw e;
			// log.error("Fail - not able to find element using Partial Link
			// Text Selector", e);
		}
		return element;
	}

	/**
	 * This Locator used to find element using partial link text
	 *
	 * @param linkTextKey
	 * @return WebElement
	 */

	public boolean elementExistByText(String textKey) {
		log.debug("Executing find element using Partial Text Selector...");
		WebElement element = null;
		try {

			element = driver.findElement(By.xpath("//table/tbody//td[contains(text(),'" + textKey + "')]"));
			// log.debug(element.getText() + " elementText");
			// log.debug(textKey + " Key");
			if (element.getText().equals(textKey)) {
				log.debug("elementText MATCH FOUND");
				return true;
			} else {
				log.debug("NO MATCH FOUND");
				return false;
			}
		} catch (Exception e) {
			throw e;
		}

	}

	/**
	 * This Locator used to find element in whole page
	 *
	 * @param linkTextKey
	 * @return WebElement
	 */
	public boolean isTextPresent(String textKey) {
		log.debug("Executing find element using pagesource");
		try {
			if (driver.getPageSource().contains(textKey)) {
				log.debug("elementText MATCH FOUND");
				return true;
			} else {
				log.debug("NO MATCH FOUND");
				return false;
			}

		} catch (Exception e) {
			log.debug("NO MATCH FOUND");
			return false;
		}
	}

	/**
	 * This Method used to right click on the element
	 *
	 * @param element
	 */
	public void actionsContextClick(WebElement element) {
		Actions actions = new Actions(driver);
		try {
			actions.contextClick(element).build().perform();
		} catch (Exception e) {
			throw e;
			// log.error("Fail - not able to right click on element", e);
		}
	}

	/**
	 * This Method used to send keys using keyboard actions
	 *
	 * @param element
	 */
	public void actionsSendKeys(String element) {
		log.debug("Executing SendKeys Action...");
		Actions actions = new Actions(driver);
		try {
			actions.sendKeys(element);
		} catch (Exception e) {
			throw e;
			// log.error("Fail - not able to send action keys", e);
		}
	}

	/**
	 * This Method used to perform keyboard actions
	 *
	 * @param keys
	 */

	public void keyActions(Keys keys) {
		log.debug("Executing Keyboard Action...");
		Actions actions = new Actions(driver);
		try {
			actions.sendKeys(keys).perform();
		} catch (Exception e) {
			throw e;
			// log.error("Fail - not able to perform keyboard action", e);
		}
	}

	/**
	 * This Method used to perform On Click action
	 *
	 * @param onElement
	 */

	public void actionsClick(WebElement onElement) {
		log.debug("Executing Click Action...");
		Actions actions = new Actions(driver);
		try {
			actions.click(onElement);
		} catch (Exception e) {
			throw e;
			// log.error("Fail - not able to perform Click action", e);
		}
	}

	/**
	 * This Method used to perform Continuous Backspace Action
	 *
	 * @param newNode - jsonObject
	 * @param count   no of times backspace needs to be pressed
	 */

	public void keyContinuousBackspaceActions(String newNode, int count) {
		Actions actions = new Actions(driver);
		try {
			for (int i = 0; i < count; i++) {
				actions.sendKeys(Keys.BACK_SPACE);
			}
			actions.sendKeys(newNode).perform();
		} catch (Exception e) {
			throw e;
			// log.error("Fail - not able to perform continuous Backspace
			// keyboard action", e);
		}
	}

	/**
	 * This Method used to perform Continuous Tab
	 *
	 * @param newNode - - jsonObject
	 */

	public void keyContinuousTabActions(String newNode) {
		Actions actions = new Actions(driver);
		try {
			actions.sendKeys(Keys.TAB).sendKeys(newNode).sendKeys(Keys.TAB).perform();
		} catch (Exception e) {
			throw e;
			// log.error("Fail - not able to perform continuous Backspace
			// keyboard action", e);
		}
	}

	/**
	 * This method is used to wait for the element to be visible on a web page
	 *
	 * @param cssKey - css identifier for the WebElement
	 */
	public void waitUntilCssElementVisible(String cssKey) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT);
			log.debug("Sync up for the next element..." + cssKey);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssKey)));
		} catch (Exception e) {
			log.error("Element is not visible on the page", e);
		}

	}

	/**
	 * THIS METHOD WILL BE DEPRECATED
	 */
	public void waitUntilCSSElementVisible(String cssKey) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT);
			log.debug("Sync up for the next element..." + cssKey);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssKey)));
		} catch (Exception e) {
			log.error("Element is not visible on the page", e);
		}

	}

	/**
	 * This method is used to wait for certain text to appear on web element
	 *
	 * @param cssKey       css identifier for the WebElement
	 * @param textToAppear - expected text to be appeared on a WebElement
	 */

	public void waitUntilCSSTextAppears(String cssKey, String textToAppear) {
		try {
			int timeOut = 20;
			int count = 1;
			while (!driver.findElement(By.cssSelector(cssKey)).getText().contains(textToAppear)) {
				Thread.sleep(1);
				if (count > timeOut) {
					break;
				}
				count++;
			}
		} catch (Exception e) {
			log.error("Element is not displayed", e);
		}
	}

	/**
	 * This Method used to get the selected dropdown value
	 *
	 * @param cssKey WebElement xpath identifier
	 * @return get the selected value in the drop down
	 */
	public String getSelectedValue(String cssKey) {
		WebElement element = driver.findElement(By.cssSelector(cssKey));
		String getSelectedValue = "";
		try {
			waitUntilElementVisible(cssKey);
			Select select = new Select(element);
			WebElement selectedValue = select.getFirstSelectedOption();
			getSelectedValue = selectedValue.getText();
			log.debug(getSelectedValue + "item is retrieved from dropdown");
		} catch (Exception e) {
			throw e;
			// log.error("Unable to retrieve the item " + " in " + cssKey + "
			// dropdown", e);
		}
		return getSelectedValue;
	}

	/**
	 * This method is used to get the text displayed on the alert box
	 *
	 * @return the text from the alert
	 */
	public String getAlertText() {
		String text = "";
		try {
			Alert alert = driver.switchTo().alert();
			text = alert.getText();
			log.debug("Alert: " + alert.getText());
		} catch (NoAlertPresentException e) {
		}
		return text;
	}


}
