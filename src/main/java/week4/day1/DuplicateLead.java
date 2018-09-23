package week4.day1;

import org.openqa.selenium.chrome.ChromeDriver;

public class DuplicateLead {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.findElementById("username").sendKeys("DemoSalesManager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByXPath("//input[@type='submit']").click();
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Leads").click();
		driver.findElementByLinkText("Find Leads").click();
		driver.findElementByXPath("//span[text()='Email']").click();
		driver.findElementByName("emailAddress").sendKeys("rjhfja@gmail.com");
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(7000);
		String leadName = driver.findElementByXPath("//td[@class='x-grid3-col x-grid3-cell x-grid3-td-firstName ']//a").getText();
		driver.findElementByXPath("//td[@class='x-grid3-col x-grid3-cell x-grid3-td-firstName ']//a").click();
		driver.findElementByLinkText("Duplicate Lead").click();
		if(driver.getTitle().contains("Duplicate Lead"))
		{
			System.out.println("The title contains Duplicate Lead");
		}
		else
		{
			System.out.println("The Title does not contain Duplicate Lead");
		}
		driver.findElementByXPath("//input[@type='submit']").click();
		if((driver.findElementById("viewLead_firstName_sp").getText()).contains(leadName))
		{
			System.out.println("Duplicate lead is created");
		}
		else
		{
			System.out.println("Duplicate lead is not created");
		}
		
		driver.close();

	}

}
