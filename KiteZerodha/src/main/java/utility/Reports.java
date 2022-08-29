package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {
	public static ExtentReports reportGenrate() {
		ExtentSparkReporter htmlreport= new ExtentSparkReporter("ProjectReport.html");
      ExtentReports report= new ExtentReports();
      report.attachReporter(htmlreport);
      report.setSystemInfo("suite","Regression");
      report.setSystemInfo("Tested By", "Ashutosh");
	return report;
      
	}

}
