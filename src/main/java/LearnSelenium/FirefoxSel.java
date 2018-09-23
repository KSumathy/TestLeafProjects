package LearnSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxSel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		System.setProperty("webdriver.gecko.driver", "C:\\SeleniumDrivers\\geckodriver.exe");
		WebDriver  driver = new FirefoxDriver();
		driver.get("https://www.jio.com/Jio/portal/myAccount");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		

	}

}
