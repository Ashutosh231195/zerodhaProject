package Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pojo.LaunchBrawsor;
import pom.BuyStockDivPom;
import pom.ZerodhaHomepagePom;
@Listeners(utility.Liseners.class)
public class BuySearchStock {
	WebDriver driver;

	  @BeforeMethod
	  public void logInHomepage() throws EncryptedDocumentException, IOException, InterruptedException {
		  driver=LaunchBrawsor.runBrawsor();
			ZerodhaHomepagePom obj= new ZerodhaHomepagePom(driver);
			Thread.sleep(1000);
			obj.loginZerodhTest(driver);
		
			obj.switchToHomePage(driver,"Dashboard / Kite");
		
		  }
	  
	   @Test 
public void buyStocksfromList() throws InterruptedException {
		   BuyStockDivPom obj=new BuyStockDivPom(driver);
	obj.searchShearForBuy(driver);
	obj.cliclOnSearchBuyButton(driver);

}
	   @Test
	   public void selectBombayStockMarket() throws InterruptedException {
		   BuyStockDivPom obj=new BuyStockDivPom(driver);

	   this.buyStocksfromList();
		obj.selectBombayStockExchange(driver);
	   }
	   
	   @Test
	   public void selectNationalStockMarket() throws InterruptedException {
		   BuyStockDivPom obj=new BuyStockDivPom(driver);

	   this.buyStocksfromList();
		obj.selectNationalStockExchange(driver);
		
	   }
	   
	   
	   
	   
}