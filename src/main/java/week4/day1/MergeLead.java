package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MergeLead {

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
		driver.findElementByLinkText("Merge Leads").click();
		driver.findElementByXPath("//input[@id='partyIdFrom']/following-sibling::a/img").click();
		Set<String> mergeLeads = driver.getWindowHandles();
		List<String> mergeLeadList = new ArrayList<String>();
		mergeLeadList.addAll(mergeLeads);
		driver.switchTo().window(mergeLeadList.get(1));
		driver.manage().window().maximize();
		driver.findElementByName("id").sendKeys("10120");
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(7000);
		driver.findElementByXPath("//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ']//a").click();
		driver.switchTo().window(mergeLeadList.get(0));
		driver.findElementByXPath("//input[@id='partyIdTo']/following-sibling::a/img").click();
		mergeLeads = driver.getWindowHandles();
		mergeLeadList = new ArrayList<String>();
		mergeLeadList.addAll(mergeLeads);
		driver.switchTo().window(mergeLeadList.get(1));
		driver.manage().window().maximize();
		driver.findElementByName("id").sendKeys("10121");
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(7000);
		driver.findElementByXPath("//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ']//a").click();
		driver.switchTo().window(mergeLeadList.get(0));
		driver.findElementByLinkText("Merge").click();
		Alert mergeLeadAlert = driver.switchTo().alert();
		mergeLeadAlert.accept();
		driver.findElementByLinkText("Find Leads").click();
		driver.findElementByName("id").sendKeys("10120");
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(7000);
		if((driver.findElementByXPath("//div[@class='x-paging-info']").getText()).contains("No records to display"))
		{
			System.out.println("'No records to display' is displayed. Hence Merge lead is sucessfully completed");
		}
		else
		{
			System.out.println("Merge lead is not sucessfully completed");
		}
		driver.close();
		

	}

}
