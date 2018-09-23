package oldWdMethods;

import org.testng.annotations.Test;

public class TC002_MergeLead extends SeMethods
{
	@Test
public void MergeLead() throws InterruptedException
{
	startApp("chrome", "http://leaftaps.com/opentaps");
	type(locateElement("id", "username"), "DemoSalesManager");
	type(locateElement("Id","password"), "crmsfa");
	click(locateElement("class", "decorativeSubmit"));
	click(locateElement("linktext","CRM/SFA"));
	click(locateElement("linktext","Leads"));
	click(locateElement("linktext","Merge Leads"));
	click(locateElement("xpath","//input[@id='partyIdFrom']/following-sibling::a/img"));
	Thread.sleep(7000);
	switchToWindow(1);
	type(locateElement("name", "id"), "10");
	click(locateElement("xpath","//button[text()='Find Leads']"));
	Thread.sleep(7000);
	String fromId = getText(locateElement("xpath","//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ']//a"));
	clickNoSnapShot(locateElement("xpath","//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ']//a"));
	
	switchToWindow(0);
	click(locateElement("xpath","//input[@id='partyIdTo']/following-sibling::a/img"));
	Thread.sleep(7000);
	switchToWindow(1);
	type(locateElement("name", "id"), "11");
	click(locateElement("xpath","//button[text()='Find Leads']"));
	Thread.sleep(7000);
	clickNoSnapShot(locateElement("xpath","//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ']//a"));
	switchToWindow(0);
	clickNoSnapShot(locateElement("linktext","Merge"));
	acceptAlert();
	click(locateElement("linktext","Find Leads"));
	type(locateElement("name", "id"), fromId);
	click(locateElement("xpath","//button[text()='Find Leads']"));
	Thread.sleep(7000);
	verifyExactText(locateElement("xpath","//div[@class='x-paging-info']"), "No records to display");
	closeBrowser();	
}
}
