package com.epay.pom;

import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class Homepage_methods {
	
	ResourceBundle rb= ResourceBundle.getBundle("Elements");
	Logger log = Logger.getLogger("devpinoyLogger");
		WebDriver wdr;
		
		public Homepage_methods(WebDriver any_wdr)
		{
			wdr=any_wdr;
		}
		
		public String gettitleofhome()
		{
			String title= wdr.getTitle();
			log.debug("title is: "+title);
			return title;
		}

}
