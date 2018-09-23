package wdMethods;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Tc004_DeleteLead extends ProjectMethods
{
	@BeforeTest
	public void setValuesDeleteLead()
	{
		testCaseName = "TC004";
		testCaseDesc = "Delete Lead";
		category = "Smoke";
		author =  "Sumathy";
		
	}
	
	@Test(dependsOnMethods= {"wdMethods.TC001_LoginAndLogOut.TestCase"})
public void DeleteLead() throws InterruptedException
{
	click(locateElement("linktext","Leads"));
	click(locateElement("linktext","Find Leads"));
	click(locateElement("xpath","//span[text()='Phone']"));
	locateElement("name","phoneCountryCode").clear();;
	type(locateElement("name","phoneCountryCode"), "2");
	type(locateElement("name","phoneNumber"), "9994085379");
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
