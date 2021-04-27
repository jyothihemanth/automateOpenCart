/**
 * 
 */
package com.application.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.application.actionDriver.ActionClass;
import com.application.basePackage.BaseClass;
import com.application.pageObjects.CheckOutPage;
import com.application.pageObjects.HomePage;
import com.application.pageObjects.IndexPage;
import com.application.pageObjects.LoginPage;
import com.application.pageObjects.productPage;

/**Test Case Name : TC09_OpenCart_FileUpload_Test
 * Author: Dikhit, Jyothi
 * Date of Creation: 19/04/2021
 * Description: This test case will add HP product to cart , estimate shipping and taxes
 */

public class TC09_OpenCart_FileUpload_Test extends BaseClass {
	public static Logger logger = LogManager.getLogger(TC09_OpenCart_FileUpload_Test.class);

	IndexPage index;
	LoginPage login;
	HomePage home;
	ActionClass action;
	productPage product;
	CheckOutPage checkOut;

	@BeforeMethod ()
	public void setup() { //launching chrome browser
		launchApp();    //will launch chrome and go to opencart
		if (index== null) {
			index= new IndexPage();
		}

		if (login == null) {
			login = new LoginPage();
		}

		if (home == null) {
			home = new HomePage();
		}


		if (product == null) {
			product = new productPage();
		}

		if (checkOut == null) {
			checkOut = new CheckOutPage();
		}
	}

	@AfterMethod
	public void tearDown() 
	{
				driver.quit();
	}
	@Test (priority = -1, enabled = true) 
	public void Login() throws Exception 
	{
		extent.createTest("OpenCartTest");


		//OpenCart Login Module
			
		home.Opencartverifyfileupload();
		home.opencartfileuploadfillupdetails( );
		takeScreenshot("File upload error");
		
		

	}


}
