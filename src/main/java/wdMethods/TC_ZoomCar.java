package wdMethods;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC_ZoomCar extends ProjectMethods
{
	@BeforeTest
	public void setValues()
	{
		testCaseName =  "TC002";
		testCaseDesc = "Zoom Car";
		category = "Smoke";
		author = "Sumathy/Janaki";
	}
	@Test
public void testZoomCar()
{
	startApp("chrome","https://www.zoomcar.com/chennai");
	click(locateElement("linktext","Start your wonderful journey"));
	click(locateElement("xpath","//div[@class='component-popular-locations']/div[2]"));
	click(locateElement("xpath","//button[text()='Next']"));
	int tomoDate = dateTomorrow();
	click(locateElement("xpath","//div[text()[contains(.,'"+tomoDate+"')]]"));
	click(locateElement("xpath","//button[text()='Next']"));	
	verifyPartialText(locateElement("xpath","//div[@class='day picked ']"), Integer.toString(tomoDate));
	click(locateElement("xpath","//button[text()='Done']"));
	List<WebElement> carsAvailable = locateElements("xpath","//div[@class='car-listing']");
	reportStep("No of cars returned : "+carsAvailable.size(), "Info");
	List<WebElement> carPrice = locateElements("xpath","//div[@class='price']");
	List<String> carPriceValue = new ArrayList<String>();
	
	for (WebElement webElement : carPrice) 
	{
		carPriceValue.add(webElement.getText());
	}
	reportStep("Maximum Price : "+Collections.max(carPriceValue),"Info");
	
	int index = carPriceValue.indexOf(Collections.max(carPriceValue));
	WebElement car = carsAvailable.get(index);	
	String maxBrandValue = car.findElement(By.tagName("h3")).getText();	
	reportStep("Brand value of car with maximum price : "+ maxBrandValue,"Info");
	click(locateElement("xpath","//h3[text()='"+maxBrandValue+"']/parent::div/following::div//button"));
	
}
	public int dateTomorrow()
	{
		// Get the current date
		Date date = new Date();
// Get only the date (and not month, year, time etc)
		DateFormat sdf = new SimpleDateFormat("dd"); 
// Get today's date
		String today = sdf.format(date);
// Convert to integer and add 1 to it
		int tomorrow = Integer.parseInt(today)+1;
// Print tomorrow's date
		
		//System.out.println(tomorrow);
		return tomorrow;
	}

}
