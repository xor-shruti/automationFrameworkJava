package com.orangeHRM.testRunner;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



@CucumberOptions(
				 features = {"Features"},
				 glue = {"com.orangeHRM.stepDefinitions"},
				 tags = {"@all"},
				 dryRun = false
				)


@Test
public class TestRunner extends AbstractTestNGCucumberTests{
	
	@Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
       
    }
	
	
	
	

}
