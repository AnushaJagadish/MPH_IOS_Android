package Stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import Reusable_Functions.Generic_functions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Landing_positive_scenario extends Generic_functions{
	static String text;
	static boolean value;

	/*TC_001 Validate that the user is navigated to Welcome page */
	@Given("launch the URL")
	public static void launch_app() throws Exception {
		try {
			app_launch();
			page_wait(6000);			
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("landing_positive_launch_app");
		}
	}
	@Then("navigated to Welcome page")
	public static void navigate_welcome_page() throws Exception {
		try {
			value= driver.findElement(By.xpath(OR_reader("mph_logo"))).isDisplayed();
			Assert.assertEquals(value,true);
			text= driver.findElement(By.xpath(OR_reader("welcome_page_title"))).getText();
			Assert.assertEquals(text,td_reader("welcome_page_title"));		
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("landing_positive_navigate_welcome_page");
		}		
	}

	/*TC_002 Validate that the user is able to click on 'Sign Up' button and navigate to 'Sign Up' page */
	@When("clicks on  'Sign Up' button")
	public static void click_signup() throws Exception  {
		try {
			click("welcome_signup");
			page_wait(1000);
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("landing_positive_click_signup");
		}
	}
	@Then("navigate to Sign up page")
	public static void navigate_signup_page() throws Exception {
		try {
			text= driver.findElement(By.xpath(OR_reader("signup_page_title"))).getText();
			Assert.assertEquals(text,td_reader("signup_page_title"));
			page_wait(5000);
			click("signup_page_back");
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("landing_positive_navigate_signup_page");
		}		
	}

	/*TC_003 -Validate user is able to click on 'Login' button and navigate to Login page */
	@When("clicks on the 'Login' button")
	public static void click_login() throws Exception {
		try {
			click("welcome_login");		
			if (platformName.equals("iOS")) {
				page_wait(2000);						
				click("continue");
				page_wait(3000);
			}
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("landing_positive_clicks_login");
		}
	}
	@Then("navigate to Login page")
	public static void navigate_login_page() throws Exception {
		try {
			text= driver.findElement(By.xpath(OR_reader("login_page_title"))).getText();
			Assert.assertEquals(text,td_reader("login_page_title"));
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("landing_positive_navigate_login_page");
		}	
	}	
}