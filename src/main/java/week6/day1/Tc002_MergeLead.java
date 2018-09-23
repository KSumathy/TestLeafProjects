package week6.day1;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Tc002_MergeLead extends ProjectMethods
{
	@BeforeTest (groups = {"common"})
	public void setValues()
	{
		testCaseName =  "TC002";
		testCaseDesc = "Merge Lead";
		category = "Smoke";
		author = "Sumathy";
		inputFileName = "MergeLead";
	}
	
	@Test (groups = {"regression"},dataProvider="fetchData")
public void MergeLead(String fromLeadId, String toLeadId) throws InterruptedException
{
	/*click(locateElement("linktext","Leads"));
	click(locateElement("linktext","Merge Leads"));
	click(locateElement("xpath","//input[@id='partyIdFrom']/following-sibling::a/img"));
	Thread.sleep(7000);
	switchToWindow(1);
	type(locateElement("name", "id"), fromLeadId);
	click(locateElement("xpath","//button[text()='Find Leads']"));
	Thread.sleep(7000);
	String fromId = getText(locateElement("xpath","//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ']//a"));
	clickWithNoSnap(locateElement("xpath","//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ']//a"));
	
	switchToWindow(0);
	click(locateElement("xpath","//input[@id='partyIdTo']/following-sibling::a/img"));
	Thread.sleep(7000);
	switchToWindow(1);
	type(locateElement("name", "id"), toLeadId);
	click(locateElement("xpath","//button[text()='Find Leads']"));
	Thread.sleep(7000);
	clickWithNoSnap(locateElement("xpath","//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ']//a"));
	switchToWindow(0);
	clickWithNoSnap(locateElement("linktext","Merge"));
	acceptAlert();
	click(locateElement("linktext","Find Leads"));
	type(locateElement("name", "id"), fromId);
	click(locateElement("xpath","//button[text()='Find Leads']"));
	Thread.sleep(7000);
	verifyExactText(locateElement("xpath","//div[@class='x-paging-info']"), "No records to display");*/
	//closeBrowser();	
}
}
