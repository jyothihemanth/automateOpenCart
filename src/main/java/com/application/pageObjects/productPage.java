/**  Name:ProductPage.java
 * Created by : Dikhit,Jyothi
 * Date: 19/04/2021
 * Description: This page class contains all the web elements and methods of verifying adding the product to cart,
     mandatatory data fill for check out,verify coupon code
 */
package com.application.pageObjects;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.application.actionDriver.ActionClass;
import com.application.basePackage.BaseClass;

public class productPage extends BaseClass {

	@FindBy(xpath = "//span[text()='Add to Cart']")
	WebElement OpenCart_MacAddToCart;

	@FindBy(xpath = "//input[@id='input-payment-firstname']")
	WebElement OpenCartBillingFirstName;

	@FindBy(xpath = "//input[@name='lastname']")
	WebElement OpenCartBillingLastName;
	
	@FindBy(xpath = "//input[@id='input-payment-email']")
	WebElement OpenCartBillingemail;
	
	@FindBy(xpath = "//input[@id='input-payment-telephone']")
	WebElement OpenCartBillingphone;

	@FindBy(xpath = "//input[@id='input-payment-address-1']")
	WebElement OpenCartBillingAdd1;

	@FindBy(xpath = "//input[@id='input-payment-city']")
	WebElement OpenCartBillingCity;

	@FindBy(xpath = "//input[@id='input-payment-postcode']")
	WebElement OpenCartBillingPostcode;

	@FindBy(xpath = "//input[@id='button-guest']")
	WebElement OpenCartBillingContinueBtnForGuestCheckout;
	
	@FindBy(xpath="//input[@id='button-shipping-method']")
	static
	WebElement OpenCartBillingContinueBtnForGuestLast;
	
	@FindBy(xpath="//input[@name='agree']")
	static
	WebElement OpenCartBillingContinueBtnForGuestCheckoutTermsConditions;
	
	@FindBy(xpath="//input[@id='button-confirm']")
	WebElement OpenCartBillingContinueBtnForGuestCheckoutConfirmOrdBtn;

	@FindBy(xpath = "//input[@id='button-shipping-address']")
	static
	WebElement OpenCartShippingContinueBtn;
	
	@FindBy(xpath = "//input[@class='btn btn-primary'and @ id ='button-shipping-address']")
	static
	WebElement OpenCartStep3ContinueBtn;

	@FindBy(xpath ="//i[@class='fa fa-shopping-cart']")
	static 	WebElement opencartShippingTab;

	@FindBy(xpath ="//*[@id=\"search\"]/input")
	static 	WebElement opencartSearchIphone;
	
	@FindBy(xpath ="//div[@id='content']/div[1]/div[2]/div[2]/div[1]/div/div[1]/fieldset[2]/div /following-sibling::div/preceding-sibling::div/label/following-sibling::input")
	 	WebElement OpenCartBillingRegisterCheckoutPassword;
	
	@FindBy(xpath ="//input[@id='input-payment-confirm']")
	 	WebElement OpenCartBillingRegisterCheckoutConfirmPassword;

	@FindBy(xpath ="//span[@id='cart-total']")
	static
	WebElement opencartOpenItemBasket1;

	@FindBy(xpath="//p[@class='text-right']/a/strong/i")
	static
	WebElement OpenCartViewCart;

	public productPage () 
	{
		PageFactory.initElements(driver, this);
	}

	public CheckOutPage clickOnAddCart() throws Exception {
		driver.findElement(By.id("add-to-cart")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'CHECKOUT')]")).click();
		return new CheckOutPage();
	}	

	/** 
	 * Created by : Jyothi
	 * Date: 19/04/2021
	 * Description: This method used to add the product to cart

	 */
	public CheckOutPage clickOnAddCarOpenCartt() throws Exception {
		driver.findElement(By.xpath("//span[text()='Add to Cart']")).click();
		return new CheckOutPage();

	}

	/** 
	 * Created by : Dikhit
	 * Date: 19/04/2021
	 * Description: This method used for verify successful adding of the product to cart

	 */
	public static void OpenCartverifyProductSuccessfullyAdded()
	{

		WebElement wb = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
		String Actsuccverfytxt = wb.getText();
		if(Actsuccverfytxt.contains("Success")) {
			System.out.println(Actsuccverfytxt);
		}
	}
	/** 
	 * Created by : Jyothi
	 * Date: 19/04/2021
	 * Description: This method used to identify and select HP product

	 */
	public static void clickOnHPPRODAddCarOpenCart()
	{
		driver.findElement(By.xpath("//button[text()='Add to Cart']")).click();


	}
	/** 
	 * Created by : Jyothi
	 * Date: 19/04/2021
	 * Description: This method used to select mandatory data from dropdown

	 */

	public static void opencartproductcheckoutmandatorydata() throws InterruptedException
	{

		driver.findElement(By.xpath("//div[@class='panel panel-default']/div/h4/a[text()='Estimate Shipping & Taxes ']")).click();
		Thread.sleep(5000);	
		WebElement	countryId =driver.findElement(By.xpath("//select[@name='country_id']"));
		Select countryIdSel = new Select(countryId);
		countryIdSel.selectByVisibleText("India");
		Thread.sleep(5000);
		WebElement	StateId =driver.findElement(By.xpath("//select[@id='input-zone']"));
		Select StateIdSel = new Select(StateId);
		StateIdSel.selectByVisibleText("Karnataka");
		driver.findElement(By.xpath("//input[@id='input-postcode']")).sendKeys("560098");

	}
	/** 
	 * Created by : Jyothi
	 * Date: 19/04/2021
	 * Description: This method used to apply coupon code

	 */
	public static void opencartapplycouponcode()
	{
		driver.findElement(By.xpath("//a[text()='Use Coupon Code ']")).click();
		driver.findElement(By.xpath("//input[@id='input-coupon']")).sendKeys("XYZA");
		driver.findElement(By.xpath("//input[@id='button-coupon']")).click();
		//	WebElement errormsg = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
		//	String Error = errormsg.getText();
		//	String errorMessage = "Warning";
		//	if(Error.contains(errorMessage)) {
		//		System.out.println("Wrong Coupon Code Entered");
	}

	/** 
	 * Created by : Jyothi
	 * Date: 19/04/2021
	 * Description: This method used print warning without applying coupon code
	 * @throws InterruptedException 

	 */
	public static void opencartcouponcodemissingwarning() throws InterruptedException
	{
		ActionClass.findelement(driver, opencartShippingTab) ;
		ActionClass.click (driver,opencartShippingTab);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Use Coupon Code ']")).click();
		Thread.sleep(1000);
		//	driver.findElement(By.xpath("//input[@id='input-coupon']")).sendKeys("XYZA");
		driver.findElement(By.xpath("//input[@id='button-coupon']")).click();
		Thread.sleep(1000);
		WebElement errormsg = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
		Thread.sleep(1000);
		String Error = errormsg.getText();
		String errorMessage = "Warning";
		if(Error.contains(errorMessage)) {
			System.out.println("Wrong Coupon Code Entered");
		}
	}
	/** 
	 * Created by : Jyothi
	 * Date: 19/04/2021
	 * Description: This method used Click on guest checkout option
	 * @return 

	 */
	public void OpenCartClickOnGuestCheckOut() throws InterruptedException
	{ 
		Thread.sleep(2000);
		//driver.findElement(By.className("accordion-toggle"));
		//driver.findElement(By.xpath("//a[@class='accordion-toggle']")).click();
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='radio'][2]/label/input")).click();
		driver.findElement(By.id("button-account")).click();
		//return new CheckOutPage();
	}
	
	/** 
	 * Created by : Jyothi
	 * Date: 19/04/2021
	 * Description: This method used Click on guest checkout option
	 * @return 

	 */
	public void OpenCartClickOnRegisterCheckOut() throws InterruptedException
	{ 
		Thread.sleep(2000);
		//driver.findElement(By.className("accordion-toggle"));
		//driver.findElement(By.xpath("//a[@class='accordion-toggle']")).click();
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='col-sm-6'][1]/div[1]/label/input")).click();
		driver.findElement(By.id("button-account")).click();
		//return new CheckOutPage();
	}

	/** 
	 * Created by : Jyothi
	 * Date: 19/04/2021
	 * Description: This method used to fill mandatory details in billing

	 */

	public void OpenCartFillBillingMandatoryDetails(String FName,String LName,String email,String phone,String Add1,String City,String PostCode) throws InterruptedException
	{ 

		ActionClass.type(OpenCartBillingFirstName, FName);
		ActionClass.type(OpenCartBillingLastName, LName);
		ActionClass.type(OpenCartBillingemail, email);
		ActionClass.type(OpenCartBillingphone, phone);
		ActionClass.type(OpenCartBillingAdd1, Add1);
		ActionClass.type(OpenCartBillingCity, City);
		ActionClass.type(OpenCartBillingPostcode, PostCode);

		WebElement	BillingcountryId =driver.findElement(By.xpath("//select[@id='input-payment-country']"));
		Select BillingcountryIdSel = new Select(BillingcountryId);
		BillingcountryIdSel.selectByVisibleText("India");
		Thread.sleep(5000);
		WebElement	BillingStateId =driver.findElement(By.xpath("//select[@id='input-payment-zone']"));
		Select BillingStateIdSel = new Select(BillingStateId);
		BillingStateIdSel.selectByVisibleText("Karnataka");
		ActionClass.click(driver,OpenCartBillingContinueBtnForGuestCheckout);
		
		driver.findElement(By.xpath("//textarea[@name='comment']")).sendKeys("Its Guest Checkout");
		ActionClass.click(driver,OpenCartBillingContinueBtnForGuestLast);
		driver.findElement(By.xpath("//input[@name='agree']")).click();
	//	ActionClass.click(driver,OpenCartBillingContinueBtnForGuestCheckoutTermsConditions);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='button-payment-method']")).click();
		Thread.sleep(3000);
		ActionClass.click(driver,OpenCartBillingContinueBtnForGuestCheckoutConfirmOrdBtn);
		
		
		//ActionClass.click(driver,OpenCartShippingContinueBtn);

		//return new CheckOutPage();



	}
	
	/** 
	 * Created by : Jyothi
	 * Date: 19/04/2021
	 * Description: This method used to fill mandatory details in billing

	 */

	public void OpenCartFillBillingMandatoryDetailsRegisterCheckout(String FName,String LName,String email,String phone,String password,String conPass,String Add1,String City,String PostCode) throws InterruptedException
	{ 

		ActionClass.type(OpenCartBillingFirstName, FName);		
		ActionClass.type(OpenCartBillingLastName, LName);
		ActionClass.type(OpenCartBillingemail, email);
		ActionClass.type(OpenCartBillingphone, phone);
	
		ActionClass.type(OpenCartBillingRegisterCheckoutPassword, password);
					
		ActionClass.type(OpenCartBillingRegisterCheckoutConfirmPassword, conPass);
		
		ActionClass.type(OpenCartBillingAdd1, Add1);
	
		ActionClass.type(OpenCartBillingCity, City);

		ActionClass.type(OpenCartBillingPostcode, PostCode);


		WebElement	BillingcountryId =driver.findElement(By.xpath("//select[@id='input-payment-country']"));
		Select BillingcountryIdSel = new Select(BillingcountryId);
		BillingcountryIdSel.selectByVisibleText("India");
		Thread.sleep(5000);
		WebElement	BillingStateId =driver.findElement(By.xpath("//select[@id='input-payment-zone']"));
		Select BillingStateIdSel = new Select(BillingStateId);
		BillingStateIdSel.selectByVisibleText("Karnataka");
		ActionClass.click(driver,OpenCartBillingContinueBtnForGuestCheckout);
		
		driver.findElement(By.xpath("//textarea[@name='comment']")).sendKeys("Its Guest Checkout");
		ActionClass.click(driver,OpenCartBillingContinueBtnForGuestLast);
		driver.findElement(By.xpath("//input[@name='agree']")).click();
	//	ActionClass.click(driver,OpenCartBillingContinueBtnForGuestCheckoutTermsConditions);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='button-payment-method']")).click();
		Thread.sleep(3000);
		ActionClass.click(driver,OpenCartBillingContinueBtnForGuestCheckoutConfirmOrdBtn);
		
		
		//ActionClass.click(driver,OpenCartShippingContinueBtn);

		//return new CheckOutPage();



	}


	/** 
	 * Created by : Jyothi
	 * Date: 19/04/2021
	 * Description: This method used search and add iphone
     need to check****self
	 * @throws InterruptedException ****
	 */
	public static void OpenCartSerachIphone() throws InterruptedException
	{
		Thread.sleep(1000);

		Actions act = new Actions(driver);
		act.moveToElement(opencartSearchIphone).click().build().perform();
		opencartSearchIphone.sendKeys("iphone");
		driver.findElement(By.xpath("//i[@class='fa fa-search']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div/div/div[1]/a/img ")).click();
		driver.findElement(By.xpath("//*[@id=\"input-quantity\"] ")).sendKeys("2");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg btn-block']")).click();
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[4]/a/i")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[2]/a ")).click();

	}

public static void OpenCartShippingandTaxes() throws InterruptedException, IOException
{
	ActionClass.click(driver,opencartOpenItemBasket1);
	ActionClass.click(driver,OpenCartViewCart);
	opencartproductcheckoutmandatorydata();
	driver.findElement(By.xpath("//button[@id='button-quote']")).click();
    driver.findElement(By.xpath("//input[@name='shipping_method']")).click();
    driver.findElement(By.xpath("//input[@id='button-shipping']")).click();
    takeScreenshot("Coupon code Verification done");
    
    Thread.sleep(1000);
    //Screenshotcheckout
    driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click(); 
    Thread.sleep(1000);
   //billing continue button
    driver.findElement(By.xpath("//input[@id='button-payment-address']")).click();
    Thread.sleep(2000);
    //delivery continue
//    ActionClass.click(driver,OpenCartStep3ContinueBtn);
    driver.findElement(By.xpath("//input[@class='btn btn-primary'and @ id ='button-shipping-address']")).click();
    Thread.sleep(1000);
    //Delivery method comments
    driver.findElement(By.xpath("//textarea[@name='comment']")).sendKeys("Its Shipping and taxes Checkout");
    Thread.sleep(1000);
    //terms and conditions
   // ActionClass.click(driver,OpenCartBillingContinueBtnForGuestCheckoutTermsConditions);
    driver.findElement(By.xpath("//input[@class='btn btn-primary'and @ id ='button-shipping-method']")).click();
    Thread.sleep(3000);
    //payment continue
	//ActionClass.click(driver,OpenCartBillingContinueBtnForGuestLast);
    //term and condition  check  box in payment
    driver.findElement(By.xpath("//input[@name='agree']")).click();
    Thread.sleep(4000);
    //payment continue btn
	driver.findElement(By.xpath("//input[@id='button-payment-method']")).click();
	Thread.sleep(4000);
	driver.findElement(By.xpath("//input[@id='button-confirm']")).click();
	Thread.sleep(4000);
	driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
}
	
	public void opencartproductreturnandhistory() throws IOException, InterruptedException
	{
		
		driver.findElement(By.xpath("//*[@id=\"column-right\"]/div/a[6]")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/table/tbody/tr[1]/td[7]/a")).click();
		takeScreenshot("View product");
		driver.findElement(By.xpath("//i[@class='fa fa-reply']")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[2]/div[4]/div/div[4]/label/input")).click();
		driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
		Thread.sleep(3000);
		takeScreenshot("Order History");
		
		
	}
	
}




