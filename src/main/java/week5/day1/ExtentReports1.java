package week5.day1;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReports1 {

	public static void main(String[] args) throws IOException 
	{
		ExtentHtmlReporter html = new ExtentHtmlReporter("./Reports/FirstReport.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(html);
		ExtentTest test = extent.createTest("TC001_CreateLead", "Create Lead Test Case for Leaftaps");
		test.assignCategory("Smoke Test");
		test.assignAuthor("Sumathy");
		test.pass("Browser Launched Sucessfully", MediaEntityBuilder.createScreenCaptureFromPath("./../snaps/img1.png").build());
		test.fail("Login Details Failed", MediaEntityBuilder.createScreenCaptureFromPath("./../snaps/img2.png").build());
		extent.flush();
	}

}
