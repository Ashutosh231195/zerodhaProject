package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class ZerodhaLoginPage {
	@FindBy (xpath="//*[@id=\"userid\"]") private WebElement KiteID;
	@FindBy (xpath="//input[@type='password']") private WebElement KitePass;
	@FindBy (xpath="//button[@type='submit']") private WebElement KiteLogin ;
	@FindBy (xpath="//a[@class='text-light forgot-link']") private WebElement KiteForgottPass;
	@FindBy (xpath="//*[@id=\"container\"]/div/div/div/form/div[3]/button") private WebElement KiteCONTINUE ;
	@FindBy (xpath="//input[@type='password']") private WebElement KitePIN  ;
	@FindBy (xpath="//*[@id=\"outer-base\"]/div[2]/div/a[1]/img") private WebElement PlaceStoreIcon  ;
	@FindBy (xpath="//*[@id=\"outer-base\"]/div[2]/div/a[2]/img") private WebElement AppleIcon  ;

	
	
	public ZerodhaLoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
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
		public void KitePassForgotten () {
			KiteForgottPass.click();
		}
		public void clickonContinue() {
			KiteCONTINUE.click();
		}
		public void EnterKitePIN(String Pin) {
			KitePIN.sendKeys(Pin);
		}
		public void clickOnPlceStoreIcon(){
			PlaceStoreIcon.click();
		}
		public void clickOnAppleIcon(){
			AppleIcon.click();
		}
}
