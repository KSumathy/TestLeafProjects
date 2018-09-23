package week4.day1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle {

	public static void main(String[] args) throws WebDriverException, IOException 
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.findElementByXPath("//span[text()='AGENT LOGIN']").click();
		driver.findElementByLinkText("Contact Us").click();
		Set<String> allWindows =  driver.getWindowHandles();
		List<String> windowList =  new ArrayList<String>();
		windowList.addAll(allWindows);
		driver.switchTo().window(windowList.get(1));
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE), new File("./Output/Screenshot.jpg"));
		driver.switchTo().window(windowList.get(0));
		driver.close();

	}

}
