package LearnSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class TestFBRegister {
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDrivers\\chromedriver.exe");
		

	ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-extensions");
	WebDriver driver = new ChromeDriver(options);
	
	driver.get("http://www.facebook.com");
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//*[@id=\"u_0_j\"]")).sendKeys("Bindu");
	driver.findElement(By.xpath("//*[@id=\"u_0_l\"]")).sendKeys("Krishna");
	Select dobDay = new Select(driver.findElement(By.xpath("//*[@id=\"day\"]")));
	Select dobMonth =  new Select(driver.findElement(By.xpath("//*[@id=\"month\"]")));
	Select dobYear = new Select(driver.findElement(By.xpath("//*[@id=\"year\"]")));
	dobDay.selectByIndex(0);
	dobMonth.selectByVisibleText("Jun");
	dobYear.selectByValue("1990");
	driver.findElement(By.xpath("//*[@id=\"u_0_z\"]/span[1]/label")).click();
	driver.findElement(By.xpath("//*[@id=\"u_0_11\"]")).click();
	driver.findElement(By.xpath("//*[@id=\"reg_pages_msg\"]/a")).click();
	driver.navigate().back();
	driver.close();
	
	

}
}
