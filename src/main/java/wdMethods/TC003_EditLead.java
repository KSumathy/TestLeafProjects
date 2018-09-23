package wdMethods;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC003_EditLead extends ProjectMethods {
	
	@BeforeTest
	public void setValuesEditLead()
	{
		testCaseName =  "TC003";
		testCaseDesc =  "Edit Lead";
		author = "Sumathy";
		category = "Smoke";
	}
	
	@Test(enabled= false)
	public void EditLead() throws InterruptedException 
	{
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
		//closeBrowser();		
		
	}

}
