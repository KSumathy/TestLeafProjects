package week4.day1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsAndFrames
{
public static void main(String[] args)
{
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
	driver.switchTo().frame("iframeResult");
	driver.findElementByXPath("//button[text()='Try it']").click();
	Alert promptAlert = driver.switchTo().alert();
	promptAlert.sendKeys("TestLeaf");
	promptAlert.accept();
	System.out.println(driver.findElementByTagName("p").getText());
}
}
