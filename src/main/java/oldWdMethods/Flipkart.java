package oldWdMethods;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Flipkart extends SeMethods
{
	@Test
public void flipkartApp() throws InterruptedException
{
	startApp("chrome", "https://www.flipkart.com/");
	click(locateElement("xpath","/html/body/div[2]/div/div/button"));
	Actions builder =  new Actions(driver);
	builder.moveToElement(locateElement("xpath","//span[text()='Electronics']")).perform();	
	Thread.sleep(7000);
	takeSnap();
	//builder.moveToElement(locateElement("linkedtext","Apple")).click().perform();
	builder.click(locateElement("linktext","Apple")).perform();
	Thread.sleep(7000);
	takeSnap();
	click(locateElement("xpath","(//a[contains(@href,'laptops')])[6]//img[2]"));
	takeSnap();
	builder.sendKeys(Keys.PAGE_DOWN).perform();
	//builder.
	takeSnap();
	
}
}
