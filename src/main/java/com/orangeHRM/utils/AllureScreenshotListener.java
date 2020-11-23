package com.orangeHRM.utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import io.cucumber.java.Scenario;
import io.qameta.allure.Attachment;


public class AllureScreenshotListener extends TestListenerAdapter {
	
	WebDriver driver;	
	public AllureScreenshotListener(WebDriver driver){

        this.driver = driver;

    }
	
	
	public static void alluretakescreenshot(WebDriver driver, File FileName) throws IOException
	{
		File SrcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(SrcFile, FileName);
	}

	
	
	public void onTestStart(Scenario scenario) {
		System.out.println(scenario.getName() +" test case started - AllureListener");	
	}
	
	
	public void onTestSuccess(Scenario scenario) {
		System.out.println("The name of the testcase that passed is :"+scenario.getName()+ "- AllureListener ");
		
	}

	@Attachment(value ="Page Screenshot", type ="image/jpg")
	public void onTestFailure(Scenario scenario) {
		System.out.println("The name of the testcase that failed is :"+scenario.getName() + " - AllureListener");
		String screenshotDirectory = System.getProperty("screenshotDirectory", "target/allurescreenshots");
		String screenshotAbsolutePath = screenshotDirectory + File.separator + System.currentTimeMillis() + "_"
				+ scenario.getName() + ".png";
		File screenshot = new File(screenshotAbsolutePath);
		
		try {
			alluretakescreenshot(driver, screenshot);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(Scenario scenario) {
		System.out.println("The name of the testcase that Skipped is :"+scenario.getName() + " - AllureListener");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

}
