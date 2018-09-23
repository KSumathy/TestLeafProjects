package week3.day1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LeafGroundPages {

	public static void main(String[] args) throws IOException 
	{
	System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
	ChromeDriver driver  = new ChromeDriver();
	LeafGroundPages obj = new LeafGroundPages();
	driver.manage().window().maximize();
	driver.get("http://leafground.com/pages/Dropdown.html");
	Select dropdown1 = new Select(driver.findElementByXPath("//section[@class='innerblock']//select"));
	dropdown1.selectByIndex(dropdown1.getOptions().size()-2);
	obj.getSnapshot(driver);
	//driver.close();
	driver.get("http://leafground.com/pages/checkbox.html");
	
	WebElement checkbox =  driver.findElementByXPath("//label[text()='Confirm Selenium is checked']/following-sibling::input");
	if(checkbox.isSelected())
	{
		System.out.println("The checkbox is checked");
	}else
	{
		System.out.println("The checkbox is not checked");
	}

	obj.getSnapshot(driver);
	driver.navigate().to("https://www.irctc.co.in/eticketing/userSignUp.jsf");
	Select countriesDropDown =  new Select(driver.findElementById("userRegistrationForm:countries"));
	
	List<WebElement> countriesNames = countriesDropDown.getOptions();
	
	List<String> countryNameE = new ArrayList<String>();
	for (WebElement webElement : countriesNames) 
	{
		//System.out.println(webElement.getText());
		if(webElement.getText().startsWith("E"))
		{
			countryNameE.add(webElement.getText());
		}
		
	}
	
	System.out.println("Second Country Name Stars with 'E' is : " +
	countryNameE.get(1));
	
	driver.navigate().to("http://testleaf.herokuapp.com/pages/checkbox.html");
	obj.getSnapshot(driver);
	List<WebElement> checkBoxesInPage = driver.findElementsByXPath("//input[@type='checkbox']");
	for (WebElement checkBox : checkBoxesInPage)
	{
		if(checkBox.isSelected())
		{
			checkBox.click();
		}
	}
	obj.getSnapshot(driver);
}
	public void getSnapshot (ChromeDriver driver) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./Output/"+System.currentTimeMillis()+".jpg"));
	}
}
