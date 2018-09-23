package wdMethods;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC005_DuplicateLead extends ProjectMethods
{
	@BeforeTest
	public void setValuesDuplicateLead()
	{
		testCaseName = "TC005";
		testCaseDesc = "Duplicate Lead";
		author ="Sumathy";
		category = "Smoke";
	}
	
	@Test
	public void DuplicateLead() throws InterruptedException
	{
		click(locateElement("linktext","Leads"));
		click(locateElement("linktext","Find Leads"));
		click(locateElement("xpath","//span[text()='Email']"));
		type(locateElement("name","emailAddress"), "preethimanik@gmail.com");
		click(locateElement("xpath","//button[text()='Find Leads']"));
		Thread.sleep(7000);
		String leadName = getText(locateElement("xpath","//td[@class='x-grid3-col x-grid3-cell x-grid3-td-firstName ']//a"));
		click(locateElement("xpath","//td[@class='x-grid3-col x-grid3-cell x-grid3-td-firstName ']//a"));
		click(locateElement("linktext","Duplicate Lead"));
		verifyTitle("Duplicate Lead");
		click(locateElement("xpath","//input[@type='submit']"));
		verifyExactText(locateElement("id","viewLead_firstName_sp"), leadName);
		closeBrowser();	
		
		
	}
}
