package week4.day1;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateLead {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver =  new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.findElementById("username").sendKeys("DemoSalesManager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByXPath("//input[@type='submit']").click();
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Create Lead").click();
		driver.findElementById("createLeadForm_companyName").sendKeys("TCS");
		driver.findElementById("createLeadForm_firstName").sendKeys("Ravindra");
		driver.findElementById("createLeadForm_lastName").sendKeys("Jadeja");
		driver.findElementById("createLeadForm_firstNameLocal").sendKeys("Ravindra");
		driver.findElementById("createLeadForm_lastNameLocal").sendKeys("Jadeja");
		driver.findElementById("createLeadForm_personalTitle").sendKeys("Mr");
		Select source = new Select(driver.findElementById("createLeadForm_dataSourceId"));
		source.selectByVisibleText("Employee");
		driver.findElementById("createLeadForm_generalProfTitle").sendKeys("Prof");
		driver.findElementById("createLeadForm_annualRevenue").sendKeys("1100000");
		Select industry =  new Select(driver.findElementById("createLeadForm_industryEnumId"));
		industry.selectByVisibleText("Telecommunications");
		Select ownership=  new Select(driver.findElementById("createLeadForm_ownershipEnumId"));
		ownership.selectByVisibleText("S-Corporation");
		driver.findElementById("createLeadForm_sicCode").sendKeys("ASRT7665");
		driver.findElementById("createLeadForm_description").sendKeys("Team Lead of the major account");
		driver.findElementById("createLeadForm_importantNote").sendKeys("Winner of the alaska");
		driver.findElementById("createLeadForm_primaryPhoneCountryCode").clear();
		driver.findElementById("createLeadForm_primaryPhoneCountryCode").sendKeys("2");
		driver.findElementById("createLeadForm_primaryPhoneAreaCode").sendKeys("gdhs897");
		driver.findElementById("createLeadForm_primaryPhoneExtension").sendKeys("637647383753");
		driver.findElementById("createLeadForm_departmentName").sendKeys("Information");
		Select prefferedCurrency =  new Select(driver.findElementById("createLeadForm_currencyUomId"));
		prefferedCurrency.selectByIndex(4);
		driver.findElementById("createLeadForm_numberEmployees").sendKeys("234");
		driver.findElementById("createLeadForm_tickerSymbol").sendKeys("gunpowder");
		driver.findElementById("createLeadForm_primaryPhoneAskForName").sendKeys("Veer");
		driver.findElementById("createLeadForm_primaryWebUrl").sendKeys("linked/in");
		driver.findElementById("createLeadForm_generalToName").sendKeys("Bamesh");
		driver.findElementById("createLeadForm_generalAddress1").sendKeys("water tank road station");
		driver.findElementById("createLeadForm_generalAddress2").sendKeys("Streetname");
		driver.findElementById("createLeadForm_generalCity").sendKeys("GangaiNagar");
		Select state = new Select(driver.findElementById("createLeadForm_generalStateProvinceGeoId"));
		state.selectByIndex(19);
		Select country =  new Select(driver.findElementById("createLeadForm_generalCountryGeoId"));
		country.selectByVisibleText("India");
		driver.findElementById("createLeadForm_generalPostalCode").sendKeys("1324214");
		driver.findElementById("createLeadForm_generalPostalCodeExt").sendKeys("234");
		Select marketingCampaign = new Select(driver.findElementById("createLeadForm_marketingCampaignId"));
		marketingCampaign.selectByIndex(2);
		driver.findElementById("createLeadForm_primaryPhoneNumber").sendKeys("9994085379");
		driver.findElementById("createLeadForm_primaryEmail").sendKeys("rjhfja@gmail.com");
		driver.findElementByName("submitButton").click();
		if(driver.findElementById("viewLead_firstName_sp").getText().equals("Ravindra"))
		{
			System.out.println("Create Lead is sucessfully completed");
		}
		else
		{
			System.out.println("Create Lead not sucessfully completed");
		}
		
		//driver.close();

	}

}
