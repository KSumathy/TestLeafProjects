package week6.day1;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Tc004_DeleteLead extends ProjectMethods
{
	@BeforeTest(groups = {"common"})
	public void setValuesDeleteLead()
	{
		testCaseName = "TC004";
		testCaseDesc = "Delete Lead";
		category = "Smoke";
		author =  "Sumathy";
		inputFileName = "DeleteLead";
		
	}
	
	
	@Test(groups = {"sanity"},/*dependsOnGroups= {"smoke"},*/dataProvider="fetchData")
public void DeleteLead(String countryCode, String phoneNumber) throws InterruptedException
{
	click(locateElement("linktext","Leads"));
	click(locateElement("linktext","Find Leads"));
	click(locateElement("xpath","//span[text()='Phone']"));
	locateElement("name","phoneCountryCode").clear();;
	type(locateElement("name","phoneCountryCode"), countryCode);
	type(locateElement("name","phoneNumber"), phoneNumber);
	click(locateElement("xpath","//button[text()='Find Leads']"));
	Thread.sleep(7000);
	String leadId = getText(locateElement("xpath","//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ']//a"));
	click(locateElement("xpath","//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ']//a"));
	click(locateElement("linktext","Delete"));
	click(locateElement("linktext","Find Leads"));
	type(locateElement("name", "id"), leadId);
	click(locateElement("xpath","//button[text()='Find Leads']"));
	Thread.sleep(7000);
	verifyExactText(locateElement("xpath","//div[@class='x-paging-info']"), "No records to display");
	//closeBrowser();	
	
}
}
