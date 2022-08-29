package Test;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;
import pojo.LaunchBrawsor;
import pom.ForrgetPassword;
import pom.ZerodhaLoginPage;
import utility.Parametrisation;

public class ForgotPasswordTest {
	WebDriver driver;

	@BeforeMethod
		public void launchBrawsor() {
			driver=LaunchBrawsor.runBrawsor();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
		}
@Test(priority=3)
public void enterEmailId() throws EncryptedDocumentException, IOException {
	ForrgetPassword forgotpass=new ForrgetPassword(driver);
	forgotpass.clickOnRadioButtonNo3();
	String Email=Parametrisation.exelData(4,1);

	forgotpass.enterEmailID(Email);

	forgotpass.enterCaptcha("rtet634");
}
 @Test (enabled=false)
public void passRcoverByVallidUIdEmail() throws EncryptedDocumentException, IOException{
	 ForrgetPassword forgotpass=new ForrgetPassword(driver);
		forgotpass.KitePassForgotten();
		forgotpass.SwichToNextPage(driver);
	 forgotpass.clickOnRadioButtonNo1();
	 String userID=Parametrisation.exelData(0,1);
		forgotpass.enterUserId(userID);
		String PAN=Parametrisation.exelData(3,1);
		forgotpass.enterPAN(PAN);
		forgotpass.clickOnRadioButtonNo3();
		String Email=Parametrisation.exelData(4,1);

		forgotpass.enterEmailID(Email);
		forgotpass.enterCaptcha("weyw5");
		forgotpass.clickOnRestButton();
}
 @Test ()
public void passRcoverByWithPanSms() throws EncryptedDocumentException, IOException, InterruptedException{
	 ForrgetPassword forgotpass=new ForrgetPassword(driver);
		forgotpass.KitePassForgotten();
		forgotpass.SwichToNextPage(driver);
	WebElement A= driver.findElement(By.xpath("//label[contains(text(),'I forgot my user ID')]"));
	A.click();
    boolean result= A.isSelected();
	 Thread.sleep(1000);
System.out.print(result);
SoftAssert softassert= new SoftAssert();
softassert.assertTrue(result,"Click on radio button ");
		String PAN=Parametrisation.exelData(3,1);
		forgotpass.enterPAN(PAN);
		forgotpass.clickOnRadioButtonNo3();
		String Email=Parametrisation.exelData(4,1);
		forgotpass.enterEmailID(Email);
		forgotpass.enterCaptcha("weyw5");
		forgotpass.clickOnRestButton();
}
	
}


	


