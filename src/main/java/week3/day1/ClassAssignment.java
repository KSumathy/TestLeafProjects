package week3.day1;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.junit.internal.runners.model.EachTestNotifier;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClassAssignment {

	public static void main(String[] args) throws IOException 
	{	
		ClassAssignment obj = new ClassAssignment();
	System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");	
	ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://leafground.com/pages/table.html");
	List<WebElement> checkboxes= driver.findElementsByXPath("//input[@type='checkbox']");
	System.out.println("No of Checkboxes in the Page : "+ checkboxes.size());
	checkboxes.get(checkboxes.size()-1).click();
	obj.takeScreenshot(driver);
	WebElement table = driver.findElementByXPath("//table[@cellspacing='0']");
	List<WebElement> tableRows = table.findElements(By.tagName("tr"));
	boolean isCellFound = false;
	
	for (WebElement eachRow : tableRows) 
	{
		
	List<WebElement> rowColumns = eachRow.findElements(By.tagName("td"));
		
	 for (WebElement eachColumn : rowColumns)
	 {
		if(eachColumn.getText().equals("80%"))
		{
			isCellFound = true;			
			break;
		}
	 }
	 
	 if(isCellFound)
	 {
		
		//eachRow.findElement(By.xpath("//input[@type ='checkbox']")).click();		
		eachRow.findElement(By.tagName("input")).click();
		
		break;
	 }
			
	}

	}




public void takeScreenshot(ChromeDriver driver) throws IOException
{
	File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src, new File("./Output/"+System.currentTimeMillis()+".jpg"));
}
}

/*for (int i=0;i<rowColumns.size();i++)
{
	if(rowColumns.get(i).getText().equals("80%"))
	{
		rowColumns.get(i+1).click();
		break;			
	}
}


if(eachRow.getText().contains("80%"))
{
	eachRow.findElement(By.tagName("input")).click();
}


}
*/