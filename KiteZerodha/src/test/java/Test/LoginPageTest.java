package Test;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.LaunchBrawsor;
import pom.ZerodhaLoginPage;
import utility.Parametrisation;
import utility.ScreenShot;

public class LoginPageTest {
	WebDriver driver;
	@BeforeMethod
	public void launchBrawsor() {
		driver=LaunchBrawsor.runBrawsor();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
	}
@Test(priority=-1)
public void loginZerodhTest() throws EncryptedDocumentException, IOException, InterruptedException {
	ZerodhaLoginPage zerodhalogin= new ZerodhaLoginPage(driver);
	Thread.sleep(2000);

	String userID=Parametrisation.exelData(0, 1);
	String password=Parametrisation.exelData(1, 1);
	String PIN=Parametrisation.exelData(2, 1);
Thread.sleep(2000);
	zerodhalogin.KiteIdEnter(userID);
	zerodhalogin.KiteEnterPass(password);
	zerodhalogin.KiteLodinclick();
	Thread.sleep(2000);
	zerodhalogin.EnterKitePIN(PIN);
	zerodhalogin.clickonContinue();
}
@Test()
public void clickForgottenpass() {
	ZerodhaLoginPage zerodhalogin= new ZerodhaLoginPage(driver);
	zerodhalogin.KitePassForgotten();
}
@Test(priority=1)
public void clickOnAppleIcon() {
	ZerodhaLoginPage zerodhalogin= new ZerodhaLoginPage(driver);
	zerodhalogin.clickOnAppleIcon();
}



@Test(priority=2)
public void clickOnPlacestoreIcon() {
	ZerodhaLoginPage zerodhalogin= new ZerodhaLoginPage(driver);
	zerodhalogin.clickOnPlceStoreIcon();
}
@AfterMethod
@Test
public void closeBrawsor() throws IOException, InterruptedException {
	Thread.sleep(2000);
	ScreenShot.screenShot(driver);
	
}


}
