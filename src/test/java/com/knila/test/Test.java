package com.knila.test;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.knila.pages.AdminPage;
import com.knila.pages.LoginPage;
import com.knila.pages.RegisterPage;
import com.knila.utility.SeleniumCommands;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Test extends SeleniumCommands {
	static ExtentTest test;
	static ExtentReports report;
	@BeforeTest
	public static void startTest()
	{
		report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReport\\ExtentReportResults.html");
		test = report.startTest("Knila");
	}
	@BeforeClass
	public void beforeClass() throws Throwable {

		launchBrowser("Chrome");
		test.log(LogStatus.PASS,"Chrome Browser", "Browser lauched successfully");

	}

	@org.testng.annotations.Test
	public void purchaseTest() throws Throwable, Throwable {

		openApp(getProperty("url", "System"));
		test.log(LogStatus.PASS, "Application Launch","Navigated to the specified URL");

		LoginPage l=new LoginPage();
		enterText(l.getTxtUserName(), getProperty("username", "System"));
		test.log(LogStatus.PASS, "Name","Name entered Successfully");
		enterText(l.getTxtUserPass(), getProperty("password", "System"));
		test.log(LogStatus.PASS, "Password","Password entered Successfully");
		clickButton(l.getBtnLocation());
		test.log(LogStatus.PASS, "Location","Location selected Successfully");
		clickButton(l.getBtnLogin());
		test.log(LogStatus.PASS, "Login","Login clicked Successfully");
		AdminPage a = new AdminPage();
		clickButton(a.getListbox());
		test.log(LogStatus.PASS, "Login","Login clicked Successfully");
		
		RegisterPage r = new RegisterPage();
		
		enterText(r.getGivenName(), getProperty("Given", "Data"));
		test.log(LogStatus.PASS, "Login","Login clicked Successfully");
		
		enterText(r.getLastName(), getProperty("Last", "Data"));
		test.log(LogStatus.PASS, "Login","Login clicked Successfully");
		clickButton(r.getBtnGender());
		test.log(LogStatus.PASS, "Login","Login clicked Successfully");
		clickButton(r.getBtnMale());
		test.log(LogStatus.PASS, "Login","Login clicked Successfully");
		clickButton(r.getBtnBirthDate());
		test.log(LogStatus.PASS, "Login","Login clicked Successfully");
		enterText(r.getTxtDate(), getProperty("Date", "Data"));
		test.log(LogStatus.PASS, "Login","Login clicked Successfully");
		enterText(r.getTxtDate(), getProperty("Date", "Data"));
		test.log(LogStatus.PASS, "Login","Login clicked Successfully");
		dropdownSelect(r.getDrpdwnMonth(), getProperty("Month", "Data"));
		test.log(LogStatus.PASS, "Login","Login clicked Successfully");
		enterText(r.getTxtYear(), getProperty("Year", "Data"));
		test.log(LogStatus.PASS, "Login","Login clicked Successfully");
		clickButton(r.getBtnAddr());
		test.log(LogStatus.PASS, "Login","Login clicked Successfully");
		enterText(r.getTxtAddr1(), getProperty("Address", "Data"));
		test.log(LogStatus.PASS, "Login","Login clicked Successfully");
		enterText(r.getBtnAddr2(), getProperty("Address1", "Data"));
		test.log(LogStatus.PASS, "Login","Login clicked Successfully");
		clickButton(r.getBtnPhoneNum());
		enterText(r.getTxtPhoneNum(), getProperty("Phone", "Data"));
		clickButton(r.getBtnRelatives());
		clickButton(r.getBtnConfirm());
		
	}
	
	@AfterMethod
	public void after(ITestResult r) throws Throwable {

		if(r.getStartMillis()==ITestResult.FAILURE) {
			screenShot();
		}
	}

	@AfterClass
	public void afterClass() throws Throwable {
		driver.quit();
		report.endTest(test);
		report.flush();

	}
	
	

}
