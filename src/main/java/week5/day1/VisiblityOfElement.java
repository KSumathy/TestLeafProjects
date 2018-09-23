package week5.day1;

import org.openqa.selenium.chrome.ChromeDriver;

public class VisiblityOfElement {
	public static ChromeDriver driver;
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
		VisiblityOfElement obj = new VisiblityOfElement();
		obj.verifyDisplayElement();
		driver.findElementByName("q").sendKeys("Apple");
		//obj.verifyDisplayElement();
		System.out.println("Element Displayed : " + driver.findElementByXPath("//input[@type='submit']").isDisplayed());
		System.out.println("Element Enabled : "+ driver.findElementByXPath("//input[@type='submit']").isEnabled());
		
	}
	
	public  void verifyDisplayElement() 
	{
		if(driver.findElementByXPath("//input[@type='submit']").isDisplayed())
		{
			System.out.println("The button is displayed");
		}
		else
		{
			System.out.println("The button is not displayed ");	
		}
	}

}
