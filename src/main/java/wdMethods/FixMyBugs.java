package wdMethods;
	import java.util.ArrayList;
	import java.util.Collections;
	import java.util.List;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.testng.annotations.Test;

	public class FixMyBugs {

		@Test
		public void bugFix() throws InterruptedException {

			// launch the browser
			System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
			ChromeDriver driver = new ChromeDriver();
			driver.get("https://www.myntra.com/");

			// Mouse Over on Men
			Actions builder = new Actions(driver);
			builder.moveToElement(driver.findElementByLinkText("Men")).perform();

			// Click on Jackets
			driver.findElementByXPath("//a[@href='/men-jackets']").click();


			// Find the count of Jackets
			String leftCount = 
					driver.findElementByXPath("//input[@value='Jackets']/following-sibling::span")
					.getText()
					.replaceAll("\\(|\\)", "");			
			System.out.println(leftCount);


			// Click on Jackets and confirm the count is same
			driver.findElementByXPath("//label[text()='Jackets']").click();

			// Wait for some time
			Thread.sleep(5000);

			// Check the count
			String rightCount = 
					driver.findElementByXPath("//h1[text()='Mens Jackets']/following-sibling::span")
					.getText()
					.replaceAll("\\D", "");
			rightCount = rightCount.replaceAll("-", "");
			System.out.println(rightCount);

			// If both count matches, say success
			if(leftCount.equals(rightCount)) {
				System.out.println("The count matches on either case");
			}else {
				System.err.println("The count does not match");
			}

			// Click on Offers
			//driver.findElementByXPath("//h3[text()='Offers']").click();

			// Find the costliest Jacket
			List<WebElement> productsPrice = driver.findElementsByXPath("//span[@class='product-discountedPrice']");
			List<Integer> onlyPrice = new ArrayList<Integer>();

			for (WebElement productPrice : productsPrice) {
				onlyPrice.add(Integer.parseInt(productPrice.getText().replaceAll("[^0-9]", "")));
				//System.out.println(productPrice.getText().replaceAll("[^0-9]", ""));
			}

			// Sort them 
			int max = Collections.max(onlyPrice);

			// Find the top one
			System.out.println(max);
			
			//driver.close();

			// Print Only Allen Solly Brand Minimum Price
			
			driver.findElementByXPath("//div[@class='brand-more']").click();
			driver.findElementByXPath("//input[@value='Allen Solly']/following-sibling::div").click();
			driver.findElementByXPath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']").click();
			// Find the costliest Jacket
			Thread.sleep(7000);
			List<WebElement> allenSollyPrices = driver.findElementsByXPath("//span[@class='product-discountedPrice']");

			onlyPrice = new ArrayList<Integer>();

			for (WebElement productPrice : allenSollyPrices) {
				//onlyPrice.add(productPrice.getText().replaceAll("//D", ""));
				onlyPrice.add(Integer.parseInt(productPrice.getText().replaceAll("[^0-9]", "")));
			}

			// Get the minimum Price 
			int min = Collections.min(onlyPrice);

			// Find the lowest priced Allen Solly
			System.out.println(min);


		}

	}


