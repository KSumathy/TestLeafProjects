package week4.day1;

import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteLead
{

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver =  new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.findElementById("username").sendKeys("DemoSalesManager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByXPath("//input[@type='submit']").click();
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Leads").click();
		driver.findElementByLinkText("Find Leads").click();
		driver.findElementByXPath("//span[text()='Phone']").click();
		driver.findElementByName("phoneCountryCode").clear();
		driver.findElementByName("phoneCountryCode").sendKeys("2");
		//driver.findElementByName("phoneAreaCode").sendKeys("gdhs897");
		driver.findElementByName("phoneNumber").sendKeys("9994085379");
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(7000);
		String leadId = driver.findElementByXPath("//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ']//a").getText();
		driver.findElementByXPath("//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ']//a").click();
		driver.findElementByLinkText("Delete").click();
		driver.findElementByLinkText("Find Leads").click();
		driver.findElementByName("id").sendKeys(leadId);
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(7000);
		if((driver.findElementByXPath("//div[@class='x-paging-info']").getText()).contains("No records to display"))
		{
			System.out.println("'No records to display' message is displayed. Hence Delete lead is sucessfully completed");
		}
		else
		{
			System.out.println("Delete Lead is not sucessfully completed");
		}
		driver.close();
	}

}
