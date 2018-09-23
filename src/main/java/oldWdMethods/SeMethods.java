package oldWdMethods;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class SeMethods implements WdMethods
{
	public RemoteWebDriver driver;
	public int i = 1;
	
	public void startApp(String browser, String url) 
	{
		try {
			if(browser.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver  = new ChromeDriver();
			} else if(browser.equalsIgnoreCase("firefox")) 
			{
				System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
				driver  = new FirefoxDriver();
			}
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			System.out.println("The Browser "+browser+" launched successfully");
		} catch (WebDriverException e) 
		{
			System.err.println("WebDriverException has occured");
			throw new RuntimeException("WebDriverException has occured");
		}catch (NullPointerException e) 
		{
			System.err.println("NullPointerException has occured for driver");
			throw new RuntimeException("NullPointerException has occured for driver");
		}catch (Exception e) 
		{
			System.err.println("Exception has occured");
			throw new RuntimeException("Exception has occured");
		}
		finally
		{
		takeSnap();
		}

	}

	
	

	@SuppressWarnings("finally")
	public WebElement locateElement(String locator, String locValue)
	{
		
		try {
			switch (locator.toLowerCase())
			{
			case "id": return driver.findElementById(locValue);
			case "class": return driver.findElementByClassName(locValue);
			case "xpath": return driver.findElementByXPath(locValue);
			case "linktext": return driver.findElementByLinkText(locValue);	
			case "name": return driver.findElementByName(locValue);
			case "partiallinktext": return driver.findElementByPartialLinkText(locValue);
			case "tagname" : return driver.findElementByTagName(locValue);
			case "cssselector" : return driver.findElementByCssSelector(locValue);
			
			}
		} catch (NoSuchElementException e)
		{
			System.err.println("NoSuchElement Exception has occured");
			throw new RuntimeException("NoSuchElement Exception has occured");
		}catch (ElementNotVisibleException e)
		{
			System.err.println("ElementNotVisibleException has occured");
			throw new RuntimeException("ElementNotVisibleException  has occured");
		}
		
		catch (Exception e)
		{
			System.err.println("Exception has occured");
			throw new RuntimeException("Exception has occured");
		}
		
	
		return null;
		
	}

	// Method Overloading
	public WebElement locateElement(String locValue)
	{		
		try {
			WebElement locatedElement= driver.findElementById(locValue);
			return locatedElement;
		} catch (NoSuchElementException e)
		{
			System.err.println("NoSuchElement Exception has occured");
			throw new RuntimeException("NoSuchElement Exception has occured");
		}catch (ElementNotVisibleException e)
		{
			System.err.println("ElementNotVisibleException has occured");
			throw new RuntimeException("ElementNotVisibleException  has occured");
		}
		
		catch (Exception e)
		{
			System.err.println("Exception has occured");
			throw new RuntimeException("Exception has occured");
		}		
	
		
	}

	public void type(WebElement ele, String data)
	{
		ele.sendKeys(data);
		System.out.println("The Data "+data+" is entered Successfully");
		takeSnap();
	}


	public void click(WebElement ele)
	{
		ele.click();
		System.out.println("The Element "+ele+" is clicked Successfully");
		takeSnap();
	}
	
	public void clickNoSnapShot(WebElement ele)
	{
		ele.click();
		System.out.println("The Element "+ele+" is clicked Successfully");
		
	}

	
	public String getText(WebElement ele)
	{
		System.out.println("The given element has the text "+ ele.getText());
		return ele.getText();
		
	}

	@Override
	public void selectDropDownUsingText(WebElement ele, String value) 
	{
		Select dropDown = new Select(ele);
		dropDown.selectByVisibleText(value);
		System.out.println("The Value "+value+" is selected in DropDown");
		takeSnap();

	}

	@Override
	public void selectDropDownUsingIndex(WebElement ele, int index)
	{
		Select dropDown = new Select(ele);
		dropDown.selectByIndex(index);
		System.out.println("The Value at index "+index+" is selected in DropDown");
		takeSnap();

	}

	@Override
	public boolean verifyTitle(String expectedTitle)
	{
		boolean isTitleCorrect = false;
	if(driver.getTitle().contains(expectedTitle))
	{	
		System.out.println("Current title is equal to the expected title " + expectedTitle);
		isTitleCorrect = true;
	}		
	
		return isTitleCorrect;	
	}
	
	@Override
	public void verifyExactText(WebElement ele, String expectedText)
	{
		if(ele.getText().equals(expectedText))
		{
			System.out.println("The text in Web element matches with the expected text : "+expectedText);
		}
		else
		{
			System.out.println("The text in Web element does not match with the expected text : "+expectedText);
		}

	}

	@Override
	public void verifyPartialText(WebElement ele, String expectedText)
	{
		if(ele.getText().contains(expectedText))
		{
			System.out.println("The text in Web element partially  matches with the expected text : "+expectedText);
		}
		else
		{
			System.out.println("The text in Web element does not match with the expected text : "+expectedText);
		}

	}

	@Override
	public void verifyExactAttribute(WebElement ele, String attribute, String value) 
	{
		if(ele.getAttribute(attribute).equals(value))
		{
			System.out.println("The attribute value matches with the given value");
		}
		else
		{
			System.out.println("The attribute value does not match with the given value");
		}

	}

	@Override
	public void verifyPartialAttribute(WebElement ele, String attribute, String value) 
	{
		if(ele.getAttribute(attribute).contains(value))
		{
			System.out.println("The attribute value partially matches with the given value");
		}
		else
		{
			System.out.println("The attribute value does not match with the given value");
		}

	}

	@Override
	public void verifySelected(WebElement ele)
	{
		if(ele.isSelected())
		{
			System.out.println("The webelement is selected already");
		}
		else
		{
			
			System.out.println("The webelement is not selected");
		}
		takeSnap();
	}

	@Override
	public void verifyDisplayed(WebElement ele)
	{
		if(ele.isDisplayed())
		{
			System.out.println("The element is displayed");
		}
		else
		{
			System.out.println("The element is not displayed");
		}
		takeSnap();
	}

	@Override
	public void switchToWindow(int index)
	{
		Set<String> allWindows = driver.getWindowHandles();
		List<String> allWindowsList = new ArrayList<String>();
		allWindowsList.addAll(allWindows);
		driver.switchTo().window(allWindowsList.get(index));
		System.out.println("The window is switched to the window at index : "+ index);
		takeSnap();

	}

	@Override
	public void switchToFrame(WebElement ele)
	{
		driver.switchTo().frame(ele);
		System.out.println("The control is switched to the frame");
		takeSnap();

	}

	@Override
	public void acceptAlert() 
	{
		Alert alert = driver.switchTo().alert();
		alert.accept();
		System.out.println("The Alert got accepted");
		takeSnap();

	}

	@Override
	public void dismissAlert() 
	{
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		System.out.println("The Alert got accepted");
		takeSnap();

	}

	@Override
	public String getAlertText() {
		Alert alert = driver.switchTo().alert();
		System.out.println("The Alert has the text : " + alert.getText());
		return alert.getText();
	}


	public void takeSnap() {
		try {
		File src = driver.getScreenshotAs(OutputType.FILE);
		File desc = new File("./snaps/img"+i+".png");		
		FileUtils.copyFile(src, desc);
		} catch (IOException e) {
			e.printStackTrace();
		}
		i++;
	}

	@Override
	public void closeBrowser()
	{
		driver.close();
		System.out.println("Current browser is closed");

	}

	@Override
	public void closeAllBrowsers()
	{
		driver.quit();
		System.out.println("All browsers are closed");
	}
	
	public ExtentReports createReportFile() throws IOException
	{
		ExtentHtmlReporter html = new ExtentHtmlReporter("./Reports/FirstReport.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(html);
		return extent;
//		ExtentTest test = extent.createTest("TC001_CreateLead", "Create Lead Test Case for Leaftaps");
//		test.assignCategory("Smoke Test");
//		test.assignAuthor("Sumathy");
//		test.pass("Browser Launched Sucessfully", MediaEntityBuilder.createScreenCaptureFromPath("./../snaps/img1.png").build());
//		test.fail("Login Details Failed", MediaEntityBuilder.createScreenCaptureFromPath("./../snaps/img2.png").build());
//		extent.flush();
	}
	
	public void generateReport() throws IOException
	{
		ExtentReports extent  = createReportFile();
		
	}

}
