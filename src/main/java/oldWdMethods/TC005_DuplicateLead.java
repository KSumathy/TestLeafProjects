package oldWdMethods;

import org.testng.annotations.Test;

public class TC005_DuplicateLead extends SeMethods
{
	@Test
	public void DuplicateLead() throws InterruptedException
	{
		startApp("chrome", "http://leaftaps.com/opentaps");
		type(locateElement("id", "username"), "DemoSalesManager");
		type(locateElement("Id","password"), "crmsfa");
		click(locateElement("class", "decorativeSubmit"));
		click(locateElement("linktext","CRM/SFA"));
		click(locateElement("linktext","Leads"));
		click(locateElement("linktext","Find Leads"));
		click(locateElement("xpath","//span[text()='Email']"));
		type(locateElement("name","emailAddress"), "rjhfja@gmail.com");
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
