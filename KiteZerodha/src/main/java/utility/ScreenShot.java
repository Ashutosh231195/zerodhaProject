package utility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import pojo.LaunchBrawsor;

public class ScreenShot {
public static TakesScreenshot screenShot(WebDriver driver) throws IOException {
	DateTimeFormatter aa= DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
	LocalDateTime time=LocalDateTime.now(); 
String currnttime=	aa.format(time);
	 String file="ashutosh";
	     TakesScreenshot shot=((TakesScreenshot)driver);
	    File save= shot.getScreenshotAs(OutputType.FILE);
	    File path= new File("C:\\Users\\Aashuu\\eclipse-workspace\\KiteZerodha\\ZerodhaScreenshot"+file+currnttime+".PNG");
	FileHandler.copy(save, path);
	return shot;
}
public static void main(String[] args) {}
}
