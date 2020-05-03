package com.pizzaapi.utils;

import java.io.File;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class Listeners extends TestListenerAdapter implements ITestListener{

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	@BeforeTest(alwaysRun = true)
	public void onStart(ITestContext testContext) {
		File OutputFolder = new File("./Reports");
		 if (!OutputFolder.exists()) {
			 if(OutputFolder.mkdir()) {
		         System.out.println("Directory is created");
			 }
			 else  {   System.out.println("Failed to create Directory");
		      } 
		  }else {System.out.println("Directory already exists");
		  }
		 
		 
		 
		htmlReporter = new ExtentHtmlReporter(Constants.REPORT_FILEPATH);
		
		htmlReporter.config().setDocumentTitle("SQE Demo Challenge API Report");
		htmlReporter.config().setReportName("Rest API Functional Testing");
		htmlReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Project Name", "Pizza API");
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("User", "AK");
		
		
	}
	public void testSuccess(ITestResult result) {
		test = extent.createTest(result.getName());
		
		test.log(Status.PASS, "Test Case "+result.getName()+" PASSED");
		
	}
	public void testFailure(ITestResult result) {
		test = extent.createTest(result.getName());
		
		test.log(Status.FAIL, "Test Case "+result.getName()+" FAILED");
		test.log(Status.FAIL, "Test Case "+result.getThrowable()+" FAILED");
		
	}
	public void testSkipped(ITestResult result) {
		test = extent.createTest(result.getName());
		
		test.log(Status.SKIP, "Test Case "+result.getName()+" SKIPPED");
	}
	@AfterTest(alwaysRun=true)
	public void onCompletion(ITestContext testContext) {
		extent.flush();
		
	}
}


