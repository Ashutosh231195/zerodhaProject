package utility;

import java.io.IOException;
import java.time.Duration;


import org.testng.ITestListener;
import org.testng.ITestResult;

public class Liseners extends BaseTest implements ITestListener {
    public void onTestStart(ITestResult result) {
    	System.out.println("test Start"+ result.getName());
    }
    public void onTestSuccess(ITestResult result) {
    	System.out.println("test Successes"  + result.getName());
    }
    public void onTestFailure(ITestResult result) {
    	System.out.println("test Failure"+ result.getName());
    	try {
			ScreenShot.screenShot(driver);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public void onTestSkipped(ITestResult result) {
    	System.out.println("Test skiped"+result.getName());
    	
    }

}
