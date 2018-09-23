package week6.day1;


import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import utils.ReadExcel;

public class ProjectMethods extends SeMethods{
	@BeforeSuite(groups = {"common"})
	public void beforeSuite() {
		beginResult();
	}
	@BeforeClass(groups = {"common"})
	public void beforeClass() {
		startTestCase();
	}
	
	@Parameters({"url","username","password"})
	@BeforeMethod(groups = {"common"})
	public void login(String url, String username, String password) {
		startApp("chrome", url);
		WebElement eleUserName = locateElement("id", "username");
		type(eleUserName, username);
		WebElement elePassword = locateElement("id","password");
		type(elePassword,password );
		WebElement eleLogin = locateElement("class", "decorativeSubmit");
		click(eleLogin);
		WebElement eleCRM = locateElement("linktext","CRM/SFA");
		click(eleCRM);
	}
	@AfterMethod(groups = {"common"})
	public void closeApp() {
		closeAllBrowsers();
	}
	@AfterSuite(groups = {"common"})
	public void afterSuite()
	{
		endResult();
	}
	
	
	
	@DataProvider(name ="fetchData")
	public Object fetchData() throws IOException
	{
		String name = inputFileName;
		return ReadExcel.readExcelData(inputFileName);
	}
	
	
	
	
}
