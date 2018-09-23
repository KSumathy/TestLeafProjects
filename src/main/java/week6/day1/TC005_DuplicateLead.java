package week6.day1;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC005_DuplicateLead extends ProjectMethods
{
	@BeforeTest(groups = {"common"})
	public void setValuesDuplicateLead()
	{
		testCaseName = "TC005";
		testCaseDesc = "Duplicate Lead";
		author ="Sumathy";
		category = "Smoke";
		inputFileName = "DuplicateLead";
	}
	
	@Test(groups = {"regression"},dataProvider="fetchData")
	public void DuplicateLead(String leadEmail) throws InterruptedException
	{
		click(locateElement("linktext","Leads"));
		click(locateElement("linktext","Find Leads"));
		click(locateElement("xpath","//span[text()='Email']"));
		type(locateElement("name","emailAddress"), leadEmail);
		click(locateElement("xpath","//button[text()='Find Leads']"));
		Thread.sleep(7000);
		String leadName = getText(locateElement("xpath","//td[@class='x-grid3-col x-grid3-cell x-grid3-td-firstName ']//a"));
		click(locateElement("xpath","//td[@class='x-grid3-col x-grid3-cell x-grid3-td-firstName ']//a"));
		click(locateElement("linktext","Duplicate Lead"));
		verifyTitle("Duplicate Lead");
		click(locateElement("xpath","//input[@type='submit']"));
		verifyExactText(locateElement("id","viewLead_firstName_sp"), leadName);
		//closeBrowser();	
		
		
	}
}
