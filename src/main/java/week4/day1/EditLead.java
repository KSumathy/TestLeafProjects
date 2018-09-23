package week4.day1;

import org.openqa.selenium.chrome.ChromeDriver;

public class EditLead {

	public static void main(String[] args) throws InterruptedException
	{
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://leaftaps.com/opentaps/control/main");
	driver.findElementById("username").sendKeys("DemoSalesManager");
	driver.findElementById("password").sendKeys("crmsfa");
	driver.findElementByXPath("//input[@type='submit']").click();
	driver.findElementByLinkText("CRM/SFA").click();
	driver.findElementByLinkText("Leads").click();
	driver.findElementByLinkText("Find Leads").click();
	driver.findElementByName("firstName").sendKeys("Babu");
	driver.findElementByXPath("//button[text()='Find Leads']").click();
	Thread.sleep(7000);
	driver.findElementByXPath("//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ']//a").click();;
	if(driver.getTitle().equals("View Leads | opentaps CRM"))
	{
		System.out.println("Title Matches");
	}
	driver.findElementByLinkText("Edit").click();
	driver.findElementById("updateLeadForm_companyName").clear();
	driver.findElementById("updateLeadForm_companyName").sendKeys("FreshDesk");
	driver.findElementByXPath("//input[@type='submit']").click();
	if((driver.findElementById("viewLead_companyName_sp").getText()).contains("FreshDesk"))
	{
		System.out.println("Company Name is updated");
	}
	else
	{
		System.out.println("Company Name is not updated");
	}
	driver.close();
	
}
	
			

			
			

	}


