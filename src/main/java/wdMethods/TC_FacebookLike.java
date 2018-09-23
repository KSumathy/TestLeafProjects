package wdMethods;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC_FacebookLike extends ProjectMethods
{
	@BeforeTest
	public void setValues()
	{
		testCaseName="TC_FacebookLike";
		testCaseDesc="Facebook Page Likes";
		author="Sumathy";
		category ="smoke";
	}
	
	@Test
	public void testFBLike() throws InterruptedException
	{
	startApp("chrome","https://www.facebook.com/");
	locateElement("id","email").clear();
	type((locateElement("id","email")),"sumathy1991@gmail.com");
	type((locateElement("id","pass")),"sumathyjasminefacebook");
	click(locateElement("xpath","//input[@type='submit']"));
	Thread.sleep(7000);
	type(locateElement("xpath","//input[@data-testid='search_input']"),"TestLeaf");
	click(locateElement("xpath","//button[@data-testid='facebar_search_button']"));	
	Thread.sleep(7000);
	//String searchResult  = getText();
	verifyExactText(locateElement("xpath","(//span[text()='Places']/following::div[1]//a)[2]/div"), "TestLeaf");
	String likeButtonValue = getText(locateElement("xpath","((//div[text()='TestLeaf']//following::div)[1]//button)[1]"));
	if(likeButtonValue.equals("Like"))
			{
		reportStep("Button value is : "+likeButtonValue+".Hence clicking the like Button","Info");
		//click(locateElement("xpath","((//div[text()='TestLeaf']//following::div)[1]//button)[1]"));
			}else if(likeButtonValue.equals("Liked"))
			{				
				reportStep("Button is : "+likeButtonValue+" already","Info");
			}
		click(locateElement("xpath","(//div[text()='TestLeaf'])[1]"));
		
		Thread.sleep(7000);
		verifyTitle("TestLeaf");
		String noOfLikes = getText(locateElement("xpath","(//div[@id='pages_side_column']//div)[29]")).replaceAll("\\D", "");
		reportStep("No of Likes: "+noOfLikes,"Info");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*@Test
	public void testFBLike() throws InterruptedException
	{
	System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
	//ChromeDriver driver = new ChromeDriver();
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-notifications");
	ChromeDriver driver = new ChromeDriver(options);
	driver.manage().window().maximize();
	driver.get("https://www.facebook.com/");
	driver.findElementById("email").clear();
	driver.findElementById("email").sendKeys("sumathy1991@gmail.com");
	driver.findElementById("pass").sendKeys("sumathyjasminefacebook");
	driver.findElementByXPath("//input[@type='submit']").click();
	Thread.sleep(7000);
	driver.findElementByXPath("//input[@data-testid='search_input']").sendKeys("TestLeaf");
	driver.findElementByXPath("//button[@data-testid='facebar_search_button']").click();
	Thread.sleep(7000);
	String searchResult = driver.findElementByXPath("(//span[text()='Places']/following::div[1]//a)[2]/div").getText();
	if(searchResult.contains("TestLeaf"))
	{
		System.out.println("Search Result is : "+ searchResult);
	}
	String likeButtonValue = driver.findElementByXPath("((//div[text()
	='TestLeaf']//following::div)[1]//button)[1]").getText();
	if(likeButtonValue.equals("Like"))
			{
		System.out.println("Button is : "+likeButtonValue);
		//driver.findElementByXPath("((//div[text()='TestLeaf']//following::div)[1]//button)[1]").click();
			}else if(likeButtonValue.equals("Liked"))
			{				
				System.out.println("Button is : "+likeButtonValue+" already");
			}
					
		driver.findElementByXPath("(//div[text()='TestLeaf'])[1]").click();
		if(driver.getTitle().contains("TestLeaf"))
		{
			System.out.println("The title has TestLeaf");
		}
		else
		{
			System.out.println("The title does not have TestLeaf");
		}
		Thread.sleep(7000);
		String noOfLikes = driver.findElementByXPath("(//div[@id='pages_side_column']//div)[29]").getText().replaceAll("\\D", "");
		System.out.println("No of Likes: "+noOfLikes);
		
	}
*/	
}
