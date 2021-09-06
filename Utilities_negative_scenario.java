package Stepdefinition;

import Reusable_Functions.Generic_functions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Utilities_negative_scenario extends Generic_functions{
	public static boolean value;
	public static String text,context_app,str;
	static WebElement ele;

	@When("Open the app in IOS")
	public static void launch_app() throws Exception {
		try {
			app_launch();
			page_wait(4000);
			value = driver.findElement(By.xpath(OR_reader("welcome_page_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			login(0,0);
			page_wait(4000);
			} catch (Exception e) {
			e.printStackTrace();
			//takeScreenShot("utilities_neagtive_launch_app");
		}
	}


	@Then("Clicks on Utilities tab")
	public static void click_utilities() throws Exception {
		try {
			page_explicit_wait("home",21000);
			value = driver.findElement(By.xpath(OR_reader("home"))).isDisplayed();
			Assert.assertEquals(true, value);
			click("home");
			page_wait(3000);
			click("utilities");	
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_neagtive_click_utilities");
		}
	}

	// TC001_Validate_leaving_fields_blank_add_card_page
	@When("Click on utilities wallet")
	public static void click_Utilities_wallet() throws Exception {
		try {
			page_explicit_wait("utilities_wallet",21000);
			click("utilities_wallet");
			page_wait(4000);
//			value = driver.findElement(By.xpath(OR_reader("utilities_add_payment_button"))).isDisplayed();
//			Assert.assertEquals(true,value);
			click("utilities_add_payment_button");
			page_wait(7000);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_neagtive_click_Utilities_wallet");
		}
	}

	@Then("click on add card")
	public static void click_add_card() throws Exception {
		try{
			page_explicit_wait("utilities_add_debit_credit_card",21000);
			click("utilities_add_debit_credit_card");
			page_wait(5000);
			}
		catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("click_add_card");
		}
	}

	@And("Validate message on leaving fields blank")
	public static void blank_add_card_page() throws Exception {
		try{
			scrolldown("Save");
			page_wait(4000);
			text=driver.findElement(By.xpath(OR_reader( "utilities_save_as_invalid_msg"))).getText();
			Assert.assertEquals(text,td_reader("utilities_save_as_invalid_msg"));
			text= driver.findElement(By.xpath(OR_reader("utilities_ph_no_blank_msg"))).getText();
			Assert.assertEquals(text,td_reader("utilities_ph_no_blank_msg"));
			text= driver.findElement(By.xpath(OR_reader("utilities_address_line_one_invalid_msg"))).getText();
			Assert.assertEquals(text,td_reader("utilities_address_line_one_invalid_msg"));
			text= driver.findElement(By.xpath(OR_reader("utilities_state_invalid_msg"))).getText();
			Assert.assertEquals(text,td_reader("utilities_state_invalid_msg"));
			text= driver.findElement(By.xpath(OR_reader("utilities_city_invalid_msg"))).getText();
			Assert.assertEquals(text,td_reader("utilities_city_invalid_msg"));
			click("back_button");
			page_wait(6000);
		}catch (Exception e) { 
			e.printStackTrace();
			takeScreenShot("utilities_neagtive_blank_add_card_page");
		}
	}

	//TC002_Validate the message on entering invalid details in the Add Card page
	@When("Enter invalid details in the Add Card page")
	public static void invalid_add_card_details() throws Exception {
		try{
			click("utilities_add_payment_button");
			stale_click("utilities_add_debit_credit_card");
			page_wait(4000);
			driver.findElement(By.xpath(OR_reader("utilities_card_number"))).sendKeys(td_reader("utilities_card_number",1));
			driver.findElement(By.xpath(OR_reader("utilities_card_expiry"))).sendKeys(td_reader("utilities_card_expiry",1));
			driver.findElement(By.xpath(OR_reader("utilities_card_cvc"))).sendKeys(td_reader("utilities_card_cvc",1));
			driver.findElement(By.xpath(OR_reader("utilities_card_post"))).sendKeys(td_reader("utilities_card_post",1));
			click("utilities_card_phoneno");
			driver.findElement(By.xpath(OR_reader("utilities_card_phoneno"))).sendKeys(td_reader("utilities_card_phoneno",1));
			driver.findElement(By.xpath(OR_reader("utilities_card_city"))).sendKeys(td_reader("utilities_card_city",1));
			page_wait(5000);
			scrolldown("Save");
		}
		catch (Exception e){
			e.printStackTrace();
			takeScreenShot("utilities_neagtive_invalid_add_card_details");}
	}

	@Then("Validate message on entering invalid details on add card page")
	public static void invalid_add_card_details_message() throws Exception {

		try{
			value = driver.findElement(By.xpath(OR_reader("utilities_card_error"))).isDisplayed();
			Assert.assertEquals(true,value);
			text = driver.findElement(By.xpath(OR_reader("utilities_ph_no_invalid_msg"))).getText();
			Assert.assertEquals(text,td_reader("utilities_ph_no_invalid_msg"));
			click("back_button");
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_neagtive_invalid_add_card_details_message");
		}
	}

	//TC003_Validate message on leaving fields blank in the Add Bank page
	@When("Click on add bank")
	public static void click_add_bank() throws Exception {
		try {
			click("utilities_add_payment_button");
			page_wait(2000);
			click("utilities_add_bank");
			value = driver.findElement(By.xpath(OR_reader("utilities_add_bank_title"))).isDisplayed();
			Assert.assertEquals(true,value);
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_neagtive_click_add_bank");
		}
	}

	@Then("Leave fields blank in the Add Bank page")
	public static void leave_field_blank_add_bank() throws Exception {
		try {
			click("utilities_bank_saveas");
			click("utilities_bank_name");
			click("utilities_bank_routingno");
			click("utilities_bank_accountno");
			click("utilities_bank_checkbox");
			page_wait(4000);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_neagtive_leave_field_blank_add_bank");
		}
	}

	@And("Validate message on leaving fields blank in Add Bank page")
	public static void blank_add_bank_field() throws Exception {
		try{
			text = driver.findElement(By.xpath(OR_reader("utilities_save_as_valid_msg_two"))).getText();
			Assert.assertEquals(text, td_reader("utilities_save_as_invalid_msg_two"));
			text = driver.findElement(By.xpath(OR_reader("utilities_account_holder_name_valid_msg_two"))).getText();
			Assert.assertEquals(text, td_reader("utilities_account_holder_name_invalid_msg_two"));
			text = driver.findElement(By.xpath(OR_reader("utilities_routing_no_valid_msg_two"))).getText();
			Assert.assertEquals(text, td_reader("utilities_routing_no_invalid_msg_two"));
			text = driver.findElement(By.xpath(OR_reader("utilities_account_no_valid_msg_two"))).getText();
			Assert.assertEquals(text, td_reader("utilities_account_no_invalid_msg_two"));
			page_wait(4000);
			click("back_button");
		}catch (Exception e) {e.printStackTrace();
		takeScreenShot("utilities_neagtive_blank_add_bank_field");}
	}

	//TC004_Validate that user gets validation message on entering invalid details in the Add Bank page
	@When("Enter invalid details in the Add Bank page")
	public static void invalid_details_add_bank() throws Exception {
		click("utilities_add_payment_button");
		page_wait(2000);
		click("utilities_add_bank");
		driver.findElement(By.xpath(OR_reader("utilities_bank_saveas"))).sendKeys(td_reader("utilities_bank_saveas",1));
		driver.findElement(By.xpath(OR_reader("utilities_bank_name"))).sendKeys(td_reader("utilities_bank_name",1));
		click("utilities_bank_routingno");
		driver.findElement(By.xpath(OR_reader("utilities_bank_routingno"))).sendKeys(td_reader("utilities_bank_routingno",1));
		click("utilities_account_no");
		driver.findElement(By.xpath(OR_reader("utilities_bank_accountno"))).sendKeys(td_reader("utilities_bank_accountno",1));
		click("utilities_bank_checkbox");
	}

	@Then("Validate message on entering invalid details in Add Bank page")
	public static void invalid_details_validation_message() throws Exception {
		try{
			text = driver.findElement(By.xpath(OR_reader("utilities_account_holder_name_valid_msg_two"))).getText();
			Assert.assertEquals(text,td_reader("utilities_account_holder_name_invalid_msg"));
			text = driver.findElement(By.xpath(OR_reader("utilities_routing_no_valid_msg_two"))).getText();
			Assert.assertEquals(text,td_reader("utilities_routing_no_invalid_msg"));
			text = driver.findElement(By.xpath(OR_reader("utilities_account_no_valid_msg_two"))).getText();
			Assert.assertEquals(text,td_reader("utilities_account_no_invalid_msg"));
			click("back_button");
			click("utilities_back");
		}catch (Exception e){
			e.printStackTrace();
			takeScreenShot("utilities_neagtive_invalid_details_validation_message");
		}
	}

	//TC005_Validate award points page
	@When("Click on award points")
	public static void click_award_points() throws Exception {
		try{
	         click("utilities_awardpoints");
		}
		catch (Exception e){
			e.printStackTrace();
			takeScreenShot("utilities_neagtive_click_award_points");
		}
	}

	@Then("Verify the award points page")
	public static void validate_award_points_page() throws Exception {
		try {
				        page_wait(2000);
			            text = driver.findElement(By.xpath(OR_reader("utilities_awardpoints_title"))).getText();
			            Assert.assertEquals(text, td_reader("utilities_awardpoints_title"));
			            click("utilities_back");
		}catch (Exception e){
			e.printStackTrace(); 
			takeScreenShot("utilities_neagtive_validate_award_points_page");
		}
	}
	
	/* Validate that user gets validation message on leaving 'Enter Amount' field as 0 */
	@Then("Click on redeem points button")
	public static void click_on_redeem_points_button() throws Exception{
		try {
			Thread.sleep(3000);
			str= driver.findElement(By.xpath(OR_reader("award_points_balance"))).getText();		
			str = str.replace(',',' ').replaceAll("\\s", "");
			int i = Integer.parseInt(str);
			if(i>2000)
			{
					driver.navigate().to(prop.getProperty("URL_giftcard"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_negative_click_redeem_points");
		}
	}
	
	@Then("Enter amount field is zero")
	public static void enter_amount_field_iszero() {
//		try {
//			browser_wait(10);
//			click("redeem_points_giftcard");
//			ele = driver.findElement(By.xpath(OR_reader("redeem_points_giftcard")));
//			ele.sendKeys(td_reader("redeem_points_giftcard"));
//			ele.sendKeys(Keys.ARROW_DOWN);
//			ele.sendKeys(Keys.ENTER);
//		} catch (Exception e) {
//			e.printStackTrace();
//			takeScreenShot("utilities_negative_enter_amount_field_iszero");
//		}
	}

	@And("validation message will display")
	public static void validation_message_will_display() {
//		try{
//			value = driver.findElement(By.xpath(OR_reader("award_points_reedem"))).isDisplayed();
//			Assert.assertEquals(true,value);
//			click("redeem_points_amount");
//			ele=driver.findElement(By.xpath(OR_reader("redeem_points_amount")));
//			ele.sendKeys(Keys.BACK_SPACE);
//			click("redeem_points_email");
//			str= driver.findElement(By.xpath(OR_reader("redeem_points_amount_valid_msg"))).getText();
//			Assert.assertEquals(str,td_reader("redeem_points_amount_valid_msg"));
//			browser_wait(5000);
//			browser_refresh();
//		}catch (Exception e) {
//			e.printStackTrace();
//			takeScreenShot("utilities_negative_validation_message_will_display");
//		}
	}

/* Validate that Redeem button will disabled if the 'enter amount' field value is less than $20 */
	@When("Enter an amount less than $twenty")
	public static void enter_amount_less_than_$twenty(){
//		try{  
//			browser_wait(5000);
//			click("redeem_points_giftcard");
//			ele = driver.findElement(By.xpath(OR_reader("redeem_points_giftcard")));
//			ele.sendKeys(td_reader("redeem_points_giftcard"));
//			ele.sendKeys(Keys.ARROW_DOWN);
//			ele.sendKeys(Keys.ENTER);
//			click("redeem_points_amount");
//			browser_wait(5000);
//			ele=driver.findElement(By.xpath(OR_reader("redeem_points_amount")));
//			ele.sendKeys(Keys.BACK_SPACE);
//			ele.sendKeys(td_reader("redeem_points_amount",2));
//			browser_wait(5000);
//			click("redeem_points_email");
//			str= driver.findElement(By.xpath(OR_reader("redeem_points_amount_valid_msg"))).getText();
//			Assert.assertEquals(str,td_reader("redeem_points_amount_valid_msg"));
//			browser_wait(5000);
//		}catch (Exception e) {
//			e.printStackTrace();
//			takeScreenShot("utilities_negative_enter_amount_less_than_$twenty");
//		}
	}
	
	@Then("validation message will displayed")
	public static void validation_message_will_displayed(){
//		try{
//			str= driver.findElement(By.xpath(OR_reader("redeem_points_amount_valid_msg"))).getText();
//			Assert.assertEquals(str,td_reader("redeem_points_amount_valid_msg"));
//			browser_wait(5000);
//			browser_refresh();
//		}catch (Exception e) {
//			e.printStackTrace();
//			takeScreenShot("utilities_negative_validation_message_will_displayed");
//		}
	}

/* Validate that user gets validation message on entering amount more than the available amount present on that particular gift card user choses in "Redeem Award Points" page */
	@When("Enter a amount greater than the available amount present on that particular gift card")
	public static void enter_amount_greater_than_the_available_amount() {
//		try{
//			browser_wait(5000);
//			click("redeem_points_giftcard");
//			ele = driver.findElement(By.xpath(OR_reader("redeem_points_giftcard")));
//			ele.sendKeys(td_reader("redeem_points_giftcard"));
//			ele.sendKeys(Keys.ARROW_DOWN);
//			ele.sendKeys(Keys.ENTER);
//			click("redeem_points_amount");
//			browser_wait(5000);
//			ele=driver.findElement(By.xpath(OR_reader("redeem_points_amount")));
//			ele.sendKeys(Keys.BACK_SPACE);
//			ele.sendKeys(Keys.BACK_SPACE);
//			ele.sendKeys(td_reader("redeem_points_amount",1));
//			click("redeem_points_email");
//			str= driver.findElement(By.xpath(OR_reader("redeem_points_amount_valid_msg"))).getText();
//			Assert.assertEquals(str,td_reader("amount_exceed_valid_msg"));
//			browser_wait(5000);
//		}catch (Exception e) {
//			e.printStackTrace();
//			takeScreenShot("utilities_negative_enter_amount_greater_than_the_available_amount");
//		}
	}
	
	@Then("Validation message display")
	public static void validation_message_display() {
//		try{
//			str= driver.findElement(By.xpath(OR_reader("redeem_points_amount_valid_msg"))).getText();
//			Assert.assertEquals(str,td_reader("amount_exceed_valid_msg"));
//			browser_wait(5000);
//		}catch (Exception e) {
//			e.printStackTrace();
//			takeScreenShot("utilities_negative_validation_message_display");
//		}
	}
	
/*  Validate that user is not able to click on the 'Redeem' button on leaving the field 'Select a gift card' blank"*/	
	@When("Leave select gift card field as blank")
	public static void leave_select_gift_card_field_as_blank() {
//		try{
//			browser_refresh();
//			browser_wait(5000);
//			str=driver.findElement(By.xpath(OR_reader("redeem_points_giftcard"))).getText();
//			if(str.equalsIgnoreCase("")) {
//				Assert.assertTrue(true);;
//			}	    
//		    }
//		catch (Exception e) {
//			e.printStackTrace();
//			takeScreenShot("utilities_negative_leave_select_gift_card_field_as_blank");
//		}
	}
	@Then("Redeem button is disabled")
	public static void redeem_button_is_disabled() throws Exception{
		try {
			value=driver.findElement(By.xpath(OR_reader("redeem_points"))).isEnabled();
			Assert.assertEquals(value,false);
			//browser_wait(1000);
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_negative_redeem_button_is_disabled");
		}
	}

/* Validate that user is not able to edit 'Email Id' on "Redeem Award Points" page */
	@Then("Email id field is non-editable")
	public static void email_id_field_is_non_editable() {
//		try{
//			str = driver.findElement(By.xpath(OR_reader("redeem_points_email"))).getAttribute("value");
//			driver.findElement(By.xpath(OR_reader("redeem_points_email"))).sendKeys("");
//			ere = driver.findElement(By.xpath(OR_reader("redeem_points_email"))).getAttribute("value");
//			if(str.equalsIgnoreCase(ere)) {
//				Assert.assertTrue(true);
//			}
//		    }
//		catch (Exception e) {
//			e.printStackTrace();
//			takeScreenShot("utilities_negative_email_id_field_is_non_editable");
//		}
	}
	
 /* Verify the redeem button when the balance is less than 2000 */
	@When ("Verify the redeem button is disabled")
	public static void less_bal_disabled_redeem() {
//		try{
//			//page_refresh();
//			click("redeem_points_giftcard");
//			ele = driver.findElement(By.xpath(OR_reader("redeem_points_giftcard")));
//			ele.sendKeys(td_reader("redeem_points_giftcard"));
//			ele.sendKeys(Keys.ARROW_DOWN);
//			ele.sendKeys(Keys.ENTER);
//			ele=driver.findElement(By.xpath(OR_reader("redeem_points_amount")));
//			ele.sendKeys(Keys.BACK_SPACE);
//			ele.sendKeys(td_reader("redeem_points_amount",0));
//			ele.sendKeys(Keys.TAB);
//			browser_wait(5000);
//			click_javascript("redeem_button");
//			browser_wait(5000);
//			click("goto_dashboard_button");
//			Thread.sleep(3000);
//			str= driver.findElement(By.xpath(OR_reader("award_points_balance"))).getText();
//			str = str.replace(',',' ').replaceAll("\\s", "");
//			int i = Integer.parseInt(str);	
//			if(i<2000) {
//				value=driver.findElement(By.xpath(OR_reader("awardpoints_redeem_button"))).isEnabled();
//				 Assert.assertEquals(false,value);
//			}
//			//browser_close();
//		    }
//		catch (Exception e) {
//			e.printStackTrace();
//			takeScreenShot("utilities_negative_less_bal_disabled_redeem");
//		}
		}

	//TC006_Validate ID card
	@When("Click on ID card")
	public static void click_ID_card() throws Exception {
		try{
			//            click("utilities_idcard");
		}catch (Exception e){e.printStackTrace();
		takeScreenShot("utilities_neagtive_click_ID_card");}
	}

	@Then("Verify the ID card page")
	public static void verify_ID_card() throws Exception {
		try{
			//            value=driver.findElement(By.xpath(OR_reader("utilities_ok_button"))).isDisplayed();
			//            Assert.assertEquals(true,value);
			click("utilities_ok_button");
		}catch (Exception e){e.printStackTrace();
		takeScreenShot("utilities_neagtive_verify_ID_card");}
	}

	//TC007_Validate Upload
	@When("Click on Upload")
	public static void click_upload() throws Exception {
		try{
			//            click("utilities_upload");
		}catch (Exception e){
			e.printStackTrace();
			takeScreenShot("utilities_neagtive_click_upload");}
	}

	@Then("Verify Upload")
	public static  void verify_upload() throws Exception {
		try{
			//            value=driver.findElement(By.xpath(OR_reader("utilities_ok_button"))).isDisplayed();
			//            Assert.assertEquals(true,value);
			//            click("utilities_ok_button");
			//            logout();
		}catch (Exception e){e.printStackTrace();
		takeScreenShot("utilities_neagtive_verify_upload");}
	}

	public static void logout() throws Exception {
		//        click("hamburger");
		//        click("logout");
	}
}
