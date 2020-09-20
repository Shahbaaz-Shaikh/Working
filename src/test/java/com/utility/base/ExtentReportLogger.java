package com.utility.base;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportLogger {
	ExtentReports extent;
	ExtentHtmlReporter reporter;
	ExtentTest logger;
	public WebDriver driver;

	public ExtentReportLogger(String testCaseName,String bname, WebDriver driver) {

		reporter = new ExtentHtmlReporter("./Reports/" + testCaseName + ".html");
		extent = new ExtentReports(); // Create object of ExtentReports class- This is main class which will create //
										// report
		extent.attachReporter(reporter); // attach the reporter which we created in Step 1
		 // call createTest method and pass the name of TestCase- Based on your
		logger = extent.createTest(testCaseName);											// // requirement
		this.driver = driver;
		reporter.config().setDocumentTitle("My Framework"); // Tile of report
		reporter.config().setReportName("Regression Test Automation Suite Report"); // name of the report
		reporter.config().setTestViewChartLocation(ChartLocation.TOP); // location of the chart
		reporter.config().setTheme(Theme.STANDARD);
		
		
		 extent.setSystemInfo("Host name","localhost");
		 extent.setSystemInfo("Environemnt","QA");
		 extent.setSystemInfo("User","Shahbaaz");
		 extent.setSystemInfo("Browser",bname);
		 
		 }
	

	public void reportLog(String logMessage, String status) {
		if (status.equalsIgnoreCase("pass"))
			logger.log(Status.PASS, logMessage);
		else if (status.equalsIgnoreCase("fail"))
			logger.log(Status.FAIL, logMessage);
		else
			logger.log(Status.INFO, logMessage);
	}

	public void reportFlush() {
		extent.flush();
	}

	public String getScreenshot() {
		TakesScreenshot ts = (TakesScreenshot) driver;

		File src = ts.getScreenshotAs(OutputType.FILE);

		String path = System.getProperty("user.dir") + "/Screenshot/" + System.currentTimeMillis() + ".png";

		File destination = new File(path);

		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			System.out.println("Capture Failed " + e.getMessage());
		}

		return path;
	}

}
