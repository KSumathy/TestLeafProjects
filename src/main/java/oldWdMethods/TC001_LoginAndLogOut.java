package oldWdMethods;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import oldWdMethods.SeMethods;

public class TC001_LoginAndLogOut extends SeMethods{
	
	@Test(invocationCount=2)
	public void login() 
	{
		startApp("chrome", "http://leaftaps.com/opentaps");
		WebElement eleUserName = locateElement("id", "username");
		type(eleUserName, "DemoSalesManager");
		WebElement elePassword = locateElement("Id","password");
		type(elePassword, "crmsfa");
		WebElement eleLogin = locateElement("class", "decorativeSubmit");
		click(eleLogin);
//		WebElement eleLogout = locateElement("class", "decorativeSubmit");
//		click(eleLogout);
		
		WebElement crmSfaLink = locateElement("linktext","CRM/SFA");
		click(crmSfaLink);
		WebElement createLead = locateElement("linktext","Create Lead");
		click(createLead);
		type(locateElement("id","createLeadForm_companyName"),"TCS");
		type(locateElement("id","createLeadForm_firstName"),"Mani");
		type(locateElement("id","createLeadForm_lastName"),"Preethi");
		type(locateElement("id","createLeadForm_firstNameLocal"),"Mani");
		type(locateElement("id","createLeadForm_lastNameLocal"),"Preethi");
		type(locateElement("id","createLeadForm_personalTitle"),"Ms");
//		WebElement crmSfaLink1 = locateElement("linktext","CRM/SFA");
//		selectDropDownUsingText(crmSfaLink1, "Employee");
		selectDropDownUsingText(locateElement("id","createLeadForm_dataSourceId"), "Employee");
		type(locateElement("id","createLeadForm_generalProfTitle"),"DR");
		type(locateElement("id","createLeadForm_annualRevenue"),"700000000");
		selectDropDownUsingText(locateElement("id","createLeadForm_industryEnumId"), "Telecommunications");
		selectDropDownUsingText(locateElement("id","createLeadForm_ownershipEnumId"), "S-Corporation");		
		type(locateElement("id","createLeadForm_sicCode"),"ASRT7665");
		type(locateElement("id","createLeadForm_description"),"Team Lead of the major account");
		type(locateElement("id","createLeadForm_importantNote"),"Awarded");
		locateElement("id","createLeadForm_primaryPhoneCountryCode").clear();
		type(locateElement("id","createLeadForm_primaryPhoneCountryCode"),"2");
		type(locateElement("id","createLeadForm_primaryPhoneAreaCode"),"456");
		type(locateElement("id","createLeadForm_primaryPhoneExtension"),"637647383753");
		type(locateElement("id","createLeadForm_departmentName"),"Information");		
		selectDropDownUsingIndex(locateElement("id","createLeadForm_currencyUomId"), 4);		
		type(locateElement("id","createLeadForm_numberEmployees"),"2241");
		type(locateElement("id","createLeadForm_tickerSymbol"),"flag");
		type(locateElement("id","createLeadForm_primaryPhoneAskForName"),"Pre");
		type(locateElement("id","createLeadForm_primaryWebUrl"),"linked/in");
		type(locateElement("id","createLeadForm_generalToName"),"Bamesh");
		type(locateElement("id","createLeadForm_generalAddress1"),"water tank road station");
		type(locateElement("id","createLeadForm_generalAddress2"),"Streetname");
		type(locateElement("id","createLeadForm_generalCity"),"Tvm");		
		selectDropDownUsingIndex(locateElement("id","createLeadForm_generalStateProvinceGeoId"), 4);
		selectDropDownUsingText(locateElement("id","createLeadForm_generalCountryGeoId"), "India");	
		type(locateElement("id","createLeadForm_generalPostalCode"),"12244");
		type(locateElement("id","createLeadForm_generalPostalCodeExt"),"345");
		selectDropDownUsingIndex(locateElement("id","createLeadForm_marketingCampaignId"), 2);
		type(locateElement("id","createLeadForm_primaryPhoneNumber"),"9994085379");
		type(locateElement("id","createLeadForm_primaryEmail"),"preethimanik@gmail.com");
		click(locateElement("name","submitButton"));
		verifyExactText(locateElement("id","viewLead_firstName_sp"),"Mani");
		
		closeAllBrowsers();
		
	}
	
}







