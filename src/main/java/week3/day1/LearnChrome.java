package week3.day1;




import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.touch.ScrollAction;
import org.openqa.selenium.support.ui.Select;

import net.bytebuddy.implementation.bytecode.Throw;

public class LearnChrome {

	public static void main(String[] args) throws InterruptedException, IOException 
	{
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	LearnChrome obj = new LearnChrome();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	

		driver.manage().timeouts().implicitlyWait(250, TimeUnit.SECONDS);
		driver.get("https://www.irctc.co.in/eticketing/userSignUp.jsf");
		driver.findElementById("userRegistrationForm:userName").sendKeys("abc123def");
		driver.findElementById("userRegistrationForm:password").sendKeys("NewPwd001@");
		driver.findElementById("userRegistrationForm:confpasword").sendKeys("NewPwd001@");
		Select secQues = new Select(driver.findElementById("userRegistrationForm:securityQ"));
		secQues.selectByIndex(4);
		Thread.sleep(8000);
		js.executeScript("scroll(0,500)");
		Thread.sleep(8000);
		js.executeScript("scroll(0,300)");
		Thread.sleep(8000);
		js.executeScript("scroll(0,-500)");
		Thread.sleep(8000);
			
		driver.close();
		driver.findElementById("userRegistrationForm:securityAnswer").sendKeys("football");
		Select prefLang = new Select(driver.findElementById("userRegistrationForm:prelan"));
		prefLang.selectByVisibleText("English");
		driver.findElementByName("userRegistrationForm:firstName").sendKeys("Bindu");
		driver.findElementByName("userRegistrationForm:middleName").sendKeys("Krishna");
		driver.findElementByName("userRegistrationForm:lastName").sendKeys("Prasad");
		driver.findElementById("userRegistrationForm:gender:1").click();
		driver.findElementById("userRegistrationForm:maritalStatus:1").click();
		Select dobDay = new Select(driver.findElementByName("userRegistrationForm:dobDay"));
		dobDay.selectByValue("24");
		Select dobMonth = new Select(driver.findElementByName("userRegistrationForm:dobMonth"));
		dobMonth.selectByVisibleText("JUN");
		Select dobYear = new Select(driver.findElementByName("userRegistrationForm:dateOfBirth"));
		dobYear.selectByIndex(9);
		obj.takeScreenshot(driver);
		Select occupation = new Select(driver.findElementById("userRegistrationForm:occupation"));
		occupation.selectByValue("2");
		driver.findElementById("userRegistrationForm:uidno").sendKeys("6473673264");
		driver.findElementById("userRegistrationForm:idno").sendKeys("JKHKJ766");
		Select country = new Select(driver.findElementById("userRegistrationForm:countries"));
		country.selectByVisibleText("India");
		driver.findElementById("userRegistrationForm:email").sendKeys("bindukrishna@gmail.com");
		driver.findElementById("userRegistrationForm:mobile").sendKeys("9876556785");
		Select nationality = new Select(driver.findElementById("userRegistrationForm:nationalityId"));
		nationality.selectByValue("94");
		driver.findElementById("userRegistrationForm:address").sendKeys("15 PREETHI");
		driver.findElementById("userRegistrationForm:street").sendKeys("Water Tank Road");
		driver.findElementById("userRegistrationForm:area").sendKeys("Nagercoil");
		driver.findElementByName("userRegistrationForm:pincode").sendKeys("629001",Keys.TAB);
		Thread.sleep(7000);
		Select city = new Select(driver.findElementById("userRegistrationForm:cityName"));
		city.selectByIndex(1);
		Thread.sleep(6000);
		try {
		Select postOffice = new Select(driver.findElementById("userRegistrationForm:postofficeName"));
		postOffice.selectByIndex(1);
		}
		catch(NoSuchElementException e)
		{
			System.out.println("No Such Element exception");
		}
		driver.findElementById("userRegistrationForm:landline").sendKeys("04517658082");
		obj.takeScreenshot(driver);
		System.out.println("Continue");
		//Thread.sleep(4000);
	 
	
	driver.close();
	}
	public void takeScreenshot(ChromeDriver driver) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./Output/"+System.currentTimeMillis()+".jpg"));
	}

}
