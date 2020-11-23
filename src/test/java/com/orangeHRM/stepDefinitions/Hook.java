package com.orangeHRM.stepDefinitions;





import java.io.ByteArrayInputStream;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import com.orangeHRM.pages.Common;
import com.orangeHRM.pages.EmployeesPage;
import com.orangeHRM.pages.HomePage;
import com.orangeHRM.pages.LeavePage;
import com.orangeHRM.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;


public class Hook extends Common{
	
	private Common common;

	public Hook(Common comm)
	{
		this.common = comm;
	}

	
	
	
	@Before
	public void InitializeTest(Scenario scenario)
	{
		
		try
		{
			System.out.println("Initializing Browser");
			
			//Code to use Chrome drive to run the automation
			System.setProperty("webdriver.chrome.driver", "/Users/Shruti/Downloads/chromedriver 6");
			common.driver_Common = new ChromeDriver();
			common.lpg = new LoginPage(common.driver_Common);
			common.emp = new EmployeesPage(common.driver_Common);
			common.leapg = new LeavePage(common.driver_Common);
			common.hmpg = new HomePage(common.driver_Common);
		//	common.driver_Common.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
			System.out.println(scenario.getName() +" test case started");
		} 
		
		catch (Exception e) {
			System.out.println("Issue while launching Browser");
			e.printStackTrace();
		}
		
	}
	
	
	@After
	public void TearDown(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			System.out.println("The name of the testcase that failed is :"+scenario.getName() + " - AllureListener");
			takesnapshot(scenario);
			  
		}
		common.driver_Common.close();
		common.driver_Common.quit();
		
	}
	
	//@Attachment(type ="image/jpg")
	public void takesnapshot(Scenario scenario) 
	{
		
		Allure.addAttachment(scenario.getName(),new ByteArrayInputStream( ((TakesScreenshot)common.driver_Common).getScreenshotAs(OutputType.BYTES)));
	}
	
	
	
	
	
    
}
