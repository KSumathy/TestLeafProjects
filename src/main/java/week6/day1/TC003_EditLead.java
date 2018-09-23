package week6.day1;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC003_EditLead extends ProjectMethods {
	
	@BeforeTest(groups = {"common"})
	public void setValuesEditLead()
	{
		testCaseName =  "TC003";
		testCaseDesc =  "Edit Lead";
		author = "Sumathy";
		category = "Smoke";
		inputFileName = "EditLead";
	}
		
	@Test(groups = {"sanity"}, /*dependsOnGroups= {"smoke"},*/dataProvider="fetchData")
	public void EditLead(String leadName, String companyName) throws InterruptedException 
	{
		click(locateElement("linktext","Leads"));
		click(locateElement("linktext","Find Leads"));
		type(locateElement("xpath", "(//input[@name='firstName'])[3]"), leadName);
		click(locateElement("xpath","//button[text()='Find Leads']"));
		Thread.sleep(7000);
		click(locateElement("xpath","//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ']//a"));
		verifyTitle("View Leads");
		click(locateElement("linktext","Edit"));
		locateElement("id", "updateLeadForm_companyName").clear();
		type(locateElement("id", "updateLeadForm_companyName"),companyName);
		click(locateElement("xpath","//input[@type='submit']"));
		verifyExactText(locateElement("id", "viewLead_companyName_sp"), companyName);
		//closeBrowser();		
		
	}

}
