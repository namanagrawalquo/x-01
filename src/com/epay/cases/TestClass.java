package com.epay.cases;

import java.io.File;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.epay.core.CreateDriver;
import com.epay.pom.Contactpage_methods;
import com.epay.pom.Homepage_methods;

public class TestClass extends CreateDriver {


	ResourceBundle rb = ResourceBundle.getBundle("Elements"); // Get elements of web page from property file
	Logger log = Logger.getLogger("devpinoyLogger"); // To generate the log file
	boolean checkbutton;
	String dir = System.getProperty("user.dir");
	String file_path = dir+"\\datafile\\Form.xls";
	String ScreenShot_path = dir+"\\ScreenShot\\";
	// ------------------------------1st Test Case---------------------

	@Test(priority = 2)
	public void getTitleofContactPage() {
		log.debug("getTitleofContactPage started.");
		fd.get(rb.getString("url"));
		Contactpage_methods cm=new Contactpage_methods(fd);
		cm.clickonmenu();
		fd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		cm.clickoncontact();
		String sTitle=cm.gettitle();
		System.out.println("Contact Page Title is: "+sTitle);
		log.debug("getTitleofContactPage completed.");
	}
	
	@Test(priority=1)
	public void getTitleofHomePage()
	{
		log.debug("getTitleofHomePage started.");
		fd.get(rb.getString("url"));
		Homepage_methods hm=new Homepage_methods(fd);
		String sTitlehome=hm.gettitleofhome();
		System.out.println("Home Page title is: "+sTitlehome);
		log.debug("getTitleofHomePage completed.");
	}
		
		
		
		
	// ---------------------Method to take screen shot of web page--------------------------------------

	public void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception {

		// Convert web driver object to TakeScreenshot

		TakesScreenshot scrShot = ((TakesScreenshot) webdriver);

		// Call getScreenshotAs method to create image file

		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		// Move image file to new destination

		File DestFile = new File(fileWithPath);

		// Copy file at destination

		FileUtils.copyFile(SrcFile, DestFile);

	}
}
