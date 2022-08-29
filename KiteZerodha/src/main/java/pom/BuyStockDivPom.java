package pom;

import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class BuyStockDivPom extends ZerodhaHomepagePom {
	public BuyStockDivPom(WebDriver driver) {
		super(driver);
	
	}
	@FindBy(xpath="(//label[@class='su-radio-label'])[1]") private WebElement BombayStockClick;
	@FindBy(xpath="(//label[@class='su-radio-label'])[2]") private WebElement NationalStockClick;

	
public void selectBombayStockExchange (WebDriver driver) throws InterruptedException {
	BombayStockClick.click();
	WebDriverWait wait1=new WebDriverWait(driver, Duration.ofMillis(1000));

	wait1.until(ExpectedConditions.visibilityOf(BombayStockClick));
	boolean Z=BombayStockClick.isEnabled();
	Assert.assertTrue(Z);
	RemoteWebDriver a= (( RemoteWebDriver)driver);
}
public void selectNationalStockExchange (WebDriver driver) {
	NationalStockClick.click();
	WebDriverWait wait1=new WebDriverWait(driver, Duration.ofMillis(1000));

	wait1.until(ExpectedConditions.visibilityOf(NationalStockClick));
	boolean Z=NationalStockClick.isEnabled();
Assert.assertTrue(Z);
}

public static void main(String[] args) {
	



}
}