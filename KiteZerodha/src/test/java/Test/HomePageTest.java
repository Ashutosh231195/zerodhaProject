package Test;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.LaunchBrawsor;
import pom.ZerodhaHomepagePom;
import pom.ZerodhaLoginPage;
import utility.BaseTest;
import utility.Reports;
@Listeners(utility.Liseners.class)
public class HomePageTest extends BaseTest {
	ExtentReports reports;
	ExtentTest test;
	ZerodhaLoginPage webEl= new ZerodhaLoginPage(driver);
		
	@BeforeMethod
	public void logintoHomePage() throws EncryptedDocumentException, IOException, InterruptedException {
		
		driver=LaunchBrawsor.runBrawsor();
		ZerodhaHomepagePom obj= new ZerodhaHomepagePom(driver);
		obj.loginZerodhTest(driver);
		obj.switchToHomePage(driver,"Dashboard / Kite");
		
	}
	
	@Test
	public void buySerchedStock() throws InterruptedException {
		 test=reports.createTest("buySerchedStock");
		ZerodhaHomepagePom obj= new ZerodhaHomepagePom(driver);
          obj.searchShearForBuy(driver);
         obj.cliclOnSearchBuyButton(driver);
	  Assert.assertTrue(true);
	}
	@Test
	public void sellSerchedStock() throws InterruptedException {
		ZerodhaHomepagePom obj= new ZerodhaHomepagePom(driver);
          obj.searchShearForBuy(driver);
         obj.clickOnSechedStockTOSell();
         test=reports.createTest("sellSerchedStock");
	}
	@Test
	public void addSerchedStockToWishlist() throws InterruptedException {
		ZerodhaHomepagePom obj= new ZerodhaHomepagePom(driver);
          obj.searchShearForBuy(driver);
         obj.clickOnSechedStockTOAddTowWchlist(driver);
         test=reports.createTest("addSerchedStockToWishlist");

	}
	@BeforeTest
	public void getReport() {
	reports=Reports.reportGenrate();
		
	}
	  @AfterMethod
	  public void getResults(ITestResult result) {
		  if (result.getStatus()==ITestResult.FAILURE) {
			 test.log(Status.FAIL, result.getName());
		  }
		  else if(result.getStatus()==ITestResult.SUCCESS) {
			  test.log((Status.PASS),result.getName()); 
			  
		  }
		  else  {
			  test.log(Status.SKIP, result.getTestName());
		  }
	  }
		  @AfterTest
		  public void flushReport(){
			  reports.flush();
		  }
		  
		  
	
	  
}


    

