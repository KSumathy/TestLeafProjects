package oldWdMethods;

import org.testng.annotations.Test;

public class TC003_EditLead extends SeMethods {
	@Test
	public void EditLead() throws InterruptedException 
	{
		startApp("chrome", "http://leaftaps.com/opentaps");
		type(locateElement("id", "username"), "DemoSalesManager");
		type(locateElement("Id","password"), "crmsfa");
		click(locateElement("class", "decorativeSubmit"));
		click(locateElement("linktext","CRM/SFA"));
		click(locateElement("linktext","Leads"));
		click(locateElement("linktext","Find Leads"));
		type(locateElement("xpath", "(//input[@name='firstName'])[3]"), "Babu");
		click(locateElement("xpath","//button[text()='Find Leads']"));
		Thread.sleep(7000);
		click(locateElement("xpath","//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ']//a"));
		verifyTitle("View Leads");
		click(locateElement("linktext","Edit"));
		locateElement("id", "updateLeadForm_companyName").clear();
		type(locateElement("id", "updateLeadForm_companyName"),"FreshWork");
		click(locateElement("xpath","//input[@type='submit']"));
		verifyExactText(locateElement("id", "viewLead_companyName_sp"), "FreshWork");
		closeBrowser();		
		
	}

}
