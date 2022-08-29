package pom;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utility.Parametrisation;

public class ZerodhaHomepagePom {
	@FindBy (xpath="(//input[@type='text'])") private WebElement SearchShear;
	@FindBy (xpath="//*[@id=\"userid\"]") private WebElement KiteID;
	@FindBy (xpath="//input[@type='password']") private WebElement KitePass;
	@FindBy (xpath="//button[@type='submit']") private WebElement KiteLogin ;
	@FindBy (xpath="//*[@id=\"container\"]/div/div/div/form/div[3]/button") private WebElement KiteCONTINUE ;
	@FindBy (xpath="//input[@type='password']") private WebElement KitePIN  ;
@FindBy(xpath="//span[@class='tradingsymbol']") private List<WebElement> listWebElement;
@FindBy(xpath="(//button[@class='button-blue'])[1]") private WebElement searchStockBuyClick;
@FindBy(xpath="//button[@class='button-orange']") private WebElement searchStockSellClick;
@FindBy(xpath="//span[@class='icon icon-plus']") private WebElement searchStockAddToClick;
@FindBy(xpath="(//label[@class='su-radio-label'])[1]") private WebElement BombayStockClick;
@FindBy(xpath="(//label[@class='su-radio-label'])[2]") private WebElement NationalStockClick;



	public ZerodhaHomepagePom(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public  int webelementListSize() {
		int size=listWebElement.size();
		return size;
	}
	public WebElement listOFWebelementsearch(int elementAt) {
		WebElement Stock=listWebElement.get(elementAt);
		return Stock;
	}
	
	public void loginZerodhTest(WebDriver driver) throws EncryptedDocumentException, IOException, InterruptedException {
		ZerodhaLoginPage zerodhalogin= new ZerodhaLoginPage(driver);

		String userID=Parametrisation.exelData(0, 1);
		String password=Parametrisation.exelData(1, 1);
		String PIN=Parametrisation.exelData(2, 1);
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofMillis(1000));
		wait.until(ExpectedConditions.visibilityOf(KiteID));
		wait.pollingEvery(Duration.ofMillis(100));
		zerodhalogin.KiteIdEnter(userID);
		zerodhalogin.KiteEnterPass(password);
		
		zerodhalogin.KiteLodinclick();
		Thread.sleep(1000);
		zerodhalogin.EnterKitePIN(PIN);
		wait.until(ExpectedConditions.visibilityOf(KitePIN));
		wait.pollingEvery(Duration.ofMillis(100));
		zerodhalogin.clickonContinue();
		WebDriverWait wait1=new WebDriverWait(driver, Duration.ofMillis(1000));

		wait1.until(ExpectedConditions.visibilityOf(KiteCONTINUE));

	}
	public void searchForShear(String Shear) {
		SearchShear.sendKeys(Shear);
	}

	public void KiteIdEnter(String ID) {
		KiteID.sendKeys(ID);
	}
	public void KiteEnterPass(String pass) {
		KitePass.sendKeys(pass);
		}
	public void KiteLodinclick() {
		KiteLogin.click();
	}
	public void clickonContinue() {
		KiteCONTINUE.click();
	}
	public void EnterKitePIN(String Pin) {
		KitePIN.sendKeys(Pin);
	}
	public void buySearchedStock() {
		
		searchStockBuyClick.click();
	}
	
	public void  searchShearForBuy(WebDriver driver) throws InterruptedException {
		Thread.sleep(1000);
		Thread.sleep(1000);
		Assert.assertEquals(driver.getTitle(),"Dashboard / Kite");
        this.searchForShear("TATA");
		Thread.sleep(1000);

             int A= this.webelementListSize();
             Assert.assertTrue(A>0);
           System.out.println(A);
         for(int a=0; a<A;a++) {
	WebElement Z=this.listOFWebelementsearch(a);
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(1000));
	wait.until(ExpectedConditions.visibilityOf(Z));
	wait.pollingEvery(Duration.ofMillis(100));
	  String Shrarname= Z.getText();
	  if(Shrarname.equalsIgnoreCase("TATASTEEL")){

		  Actions act=new Actions(driver);
		  act.moveToElement(Z);
		  act.perform();
			WebDriverWait wait1=new WebDriverWait(driver,Duration.ofMillis(1000));
			wait1.until(ExpectedConditions.visibilityOf(Z));
		  break;
	  }
      }
WebElement Buybtn=driver.findElement(By.xpath("(//button[@class='button-blue'])[1]"));
	WebDriverWait wait1=new WebDriverWait(driver,Duration.ofMillis(1000));
	wait1.until(ExpectedConditions.visibilityOf(Buybtn));
	Buybtn.click();
 }
	
	public void switchToHomePage(WebDriver driver,String pagetitle) 
 {
	Set <String> handle=driver.getWindowHandles();
	Iterator<String> A=handle.iterator();
	while(A.hasNext())
	 {
		String Nextpage=A.next();
	
		driver.switchTo().window(Nextpage);
		String title=driver.getTitle();
		if(title.equals(pagetitle)) 
		       {
		    break;
		       }
	 }}

    public void cliclOnSearchBuyButton(WebDriver driver) {
    	searchStockBuyClick.click();
    	 WebDriverWait wait1=new WebDriverWait(driver,Duration.ofMillis(1000));
 	    wait1.until(ExpectedConditions.visibilityOf(searchStockBuyClick));
    }
    public void clickOnSechedStockTOSell() {
    	searchStockSellClick.click();
    }
    public void clickOnSechedStockTOAddTowWchlist(WebDriver driver) {
    	searchStockAddToClick.click();
    	 WebDriverWait wait1=new WebDriverWait(driver,Duration.ofMillis(1000));
  	    wait1.until(ExpectedConditions.visibilityOf(searchStockAddToClick));
    }
    }


