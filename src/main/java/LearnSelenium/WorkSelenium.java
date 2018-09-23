package LearnSelenium;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WorkSelenium {
	

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String PageURL = "http://toolsqa.com/iframe-practice-page/";
		driver.get(PageURL);
		driver.manage().window().maximize();
		List<WebElement> iframesInPage= driver.findElements(By.tagName("iframe"));
		System.out.println("No of Iframes : " +iframesInPage.size());
		
		JavascriptExecutor executor = (JavascriptExecutor) driver;
//		Integer noOfFrames = Integer.parseInt(executor.executeScript("returnwindow.length").toString());
//		System.out.println("No of Frames using script executor : "+noOfFrames);
		for (WebElement webElement : iframesInPage)
		{
			//System.out.println(webElement.getAttribute("name"));
			driver.switchTo().defaultContent();
			if(webElement.getAttribute("name").equals("iframe1"))
			{
				driver.switchTo().frame(webElement);
				driver.findElement(By.name("firstname")).sendKeys("Sumathy");
				driver.findElement(By.name("lastname")).sendKeys("Karuppasamy");
				continue;
			}
			if(webElement.getAttribute("name").equals("iframe2"))
			{
				driver.switchTo().frame(webElement);				
				driver.findElement(By.tagName("img")).click();
				continue;
			}
			
		}
		
	System.out.println("========End=========");
		
		
				//driver.close();

	}
	public void browserCommands(WebDriver driver)
	{
		String PageURL = "http://www.facebook.com";
		System.out.println("Page Title is : "+driver.getTitle());
		System.out.println("Page Title length is : "+driver.getTitle().length());
		if(driver.getCurrentUrl().equals(PageURL))
		{
			System.out.println("The page URL is correct");
		}
		else
		{
			System.out.println("The Page URL is not correct");
			System.out.println("Expected URL : "+PageURL);
			System.out.println("Actual URL : "+driver.getCurrentUrl());
		}
		System.out.println("Page source length is  : "+driver.getPageSource().length());

	}
	public void navigationCommands(WebDriver driver)
	{
		driver.findElement(By.xpath("//*[@id=\"wrap\"]/div[2]/div[1]/div/div/div[5]/div[1]/ul/li[7]/a")).click();		
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().back();
		driver.navigate().refresh();
	}
	public void findElementMethod(WebDriver driver)
	{
		driver.findElement(By.name("firstname")).sendKeys("Sumathy");
		driver.findElement(By.name("lastname")).sendKeys("Karuppasamy");
		driver.findElement(By.partialLinkText("Partial")).click();
		System.out.println("Submit Button : "+driver.findElement(By.tagName("button")).toString());
		driver.findElement(By.linkText("Link Test"));
		driver.findElement(By.id("submit")).click();
	}
	public void radioAndCheckBox (WebDriver driver)
	{
		List<WebElement> sexRadioButton =  driver.findElements(By.name("sex"));
		
		for (WebElement webElement : sexRadioButton) 
		{
			if(!webElement.isSelected())
			{
				webElement.click();
				break;
			}
		}
		
		driver.findElement(By.id("exp-2")).click();
		List<WebElement> professionCheckBox = driver.findElements(By.name("profession"));
		
		for (WebElement webElement : professionCheckBox) 
		{
		if(webElement.getAttribute("value").equals("Automation Tester"))			
		{
			webElement.click();
			break;
		}
		}
		driver.findElement(By.cssSelector("input[value='Selenium IDE']")).click();
		

	}
	public void dropDownSelect(WebDriver driver) throws InterruptedException
	{
	Select continentsDD = new Select(driver.findElement(By.id("continents")));
	continentsDD.selectByIndex(1);
	Thread.sleep(2000);
	continentsDD.selectByVisibleText("Africa");
	Thread.sleep(2000);
	List<WebElement> dropdownContinents =  continentsDD.getOptions();
	System.out.println("Elements in dropdown box : ");
	for (WebElement webElement : dropdownContinents)
	{
		System.out.println(webElement.getText());
		
	}
	

	}
	public void multipleSelectionDropDown(WebDriver driver) throws InterruptedException
	{
		Select multipleDropDown =  new Select(driver.findElement(By.name("selenium_commands")));
		if(multipleDropDown.isMultiple())
		{
			System.out.println("The dropdown is Multiple select drop down");
			System.out.println("Options in Drop Down box :");
		}
		for(int i=0;i<multipleDropDown.getOptions().size();i++)
		{
			System.out.println(multipleDropDown.getOptions().get(i).getText());
			if(multipleDropDown.getOptions().get(i).getText().equals("Browser Commands"))
			{
				multipleDropDown.selectByIndex(i);
				
				
			}
			if(multipleDropDown.getOptions().get(i).getText().equals("Navigation Commands"))
			{
				multipleDropDown.selectByIndex(i);
			}
		}
		Thread.sleep(9000);
		multipleDropDown.deselectByVisibleText("Navigation Commands");
		multipleDropDown.selectByVisibleText("WebElement Commands");
	}
	
	public void tableHandling(WebDriver driver)
	{
		System.out.println("Cell Value : ");
		System.out.println(driver.findElement(By.xpath(".//*[@id='content']/table/tbody/tr[1]/td[2]")).getText());
		driver.findElement(By.xpath(".//*[@id='content']/table/tbody/tr[1]/td[6]/a")).click();
		String givenRowValue = "Clock Tower Hotel";
		for (int i=1; i<6;i++)
		{
			if(driver.findElement(By.xpath(".//*[@id='content']/table/tbody/tr["+i+"]/th")).getText().equals("Clock Tower Hotel"))
			{
				for(int j=1;j<6;j++)
				{
					System.out.println(driver.findElement(By.xpath(".//*[@id='content']/table/tbody/tr["+i+"]/td["+j+"]")).getText());
				}
				break;
			}
		}
		
	}
	public void handleWindows(WebDriver driver)
	{
		String firstWindow = driver.getWindowHandle();
		System.out.println(firstWindow);
		driver.findElement(By.xpath("//*[@id=\"content\"]/p[3]/button")).click();
		Set<String> windowsOpened = driver.getWindowHandles();
		for (String window : windowsOpened) 
		{
			System.out.println(window);
			if(window.equals(firstWindow))
			{
			driver.switchTo().window(window);
			}
		}
	}
	public void handlingAlerts(WebDriver driver)
	{
		WebElement element = driver.findElement(By.xpath("//*[@id='content']/p[16]/button"));
//		 WebDriverWait wait = new WebDriverWait(driver, 2);
//		    wait.until(ExpectedConditions.alertIsPresent());
				JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println("Alert text is " + alertText);
		alert.sendKeys("Accepting");
		alert.accept();
	}
}
