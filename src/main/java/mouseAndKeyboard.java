import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class mouseAndKeyboard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://jqueryui.com/draggable/");
		driver.switchTo().frame(driver.findElementByClassName("demo-frame"));
		Actions builder = new Actions(driver);
		WebElement drag =  driver.findElementById("draggable");
		builder.dragAndDropBy(drag, 100,100).perform();
		
	}

}
