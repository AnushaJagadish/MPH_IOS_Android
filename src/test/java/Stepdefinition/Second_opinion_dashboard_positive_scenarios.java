package Stepdefinition;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import Reusable_Functions.Generic_functions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;


public class Second_opinion_dashboard_positive_scenarios extends Generic_functions {
    static boolean value;
    static String text;
    /* Browser opens and enter URL*/
    @Given("browser is open")
    public void launch_app() throws Exception {
        try {
            app_launch();
            page_wait(1000);
            value = driver.findElement(By.xpath(OR_reader("welcome_page_title"))).isDisplayed();
            Assert.assertEquals(true,value);
            page_wait(4000);
            click("welcome_login");
            page_explicit_wait("continue",9000);
            click("continue");
            page_wait(9000);
        } catch (Exception e) {
            e.printStackTrace();
            takeScreenShot("Second_opinion_launch_app");
        }
    }

    @When("clicks on the 'login' button")
    public void login() throws Exception {
        try {
            click("login_phone_number");
            driver.findElement(By.xpath(OR_reader("login_phone_number"))).sendKeys(td_reader("login_phone_number",0));
            driver.findElement(By.xpath(OR_reader("login_password"))).sendKeys(td_reader("login_password",0));
            page_wait(1000);
            click("login");
        } catch (Exception e) {
            e.printStackTrace();
            takeScreenShot("Second_opinion_login");
        }
    }
    @And("navigated to the login page")
    public void login_page_validation() throws Exception {
        try {
            page_wait(3000);
            value = driver.findElement(By.xpath(OR_reader("login_page_title"))).isDisplayed();
            Assert.assertEquals(true,value);
        }  catch (Exception e) {
            e.printStackTrace();
            takeScreenShot("Second_opinion_login_page_validation");
        }
    }

    /*  TC_001-Validate that the user is able to click on the Second Opinion tab*/
    @When("clicks on the second opinion tab")
    public void second_opinion_tc_001() throws Exception {
        try {
            page_explicit_wait("services",8000);
            click("services");
            click("second_opinions");

        }
        catch (Exception e) {
            e.printStackTrace();
            takeScreenShot("second_opinion_tc_001");
        }
    }

    @Then("navigated to second opinion page")
    public void navigate_second_opinion_page() throws Exception {
        try {
            page_wait(5000);
            text=driver.findElement(By.xpath(OR_reader("second_opinions_title"))).getText();
            Assert.assertEquals(text,td_reader("second_opinions_title"));
        } catch (Exception e) {
            e.printStackTrace();
            takeScreenShot("second_opinion_navigate_second_opinion_page");
        }
    }

    /* TC_002-Validate that the user is able to click on Resume Cases and is navigated to uplaod scans page */
    @When ("clicks on Resume Cases")
    public void second_opinion_tc_002() throws Exception, InterruptedException{
        try{
            page_explicit_wait("so_resume_case",6000);
            click("so_resume_case");
            page_wait(3000);
        }
        catch (Exception e) {
            e.printStackTrace();
            takeScreenShot("second_opinion_tc_002");
        }
    }
    
    @Then("navigated to switch to web alert")
    public void navigate_SwitchToWeb() throws Exception {
        try{
            text = driver.findElement(By.xpath(OR_reader("so_resume_case_title"))).getText();
            Assert.assertEquals(text,td_reader("so_resume_case_title"));
            text = driver.findElement(By.xpath(OR_reader("so_switch_web_text"))).getText();
            Assert.assertEquals(text,td_reader("so_switch_web_text"));
            click("so_switch_ok_button");
        } catch (IOException e) {
            e.printStackTrace();
            takeScreenShot("second_opinion_navigate_SwitchToWeb");
        }
    }

    /* TC_003 - Validate that User is able to click on Requested tab */
    @When ("clicks on the Requested tab")
    public static void second_opinion_positive_dashboard_tc_003() throws Exception, InterruptedException
    {
        try {
            click("so_requested_tab");
        }catch (Exception e) {
            e.printStackTrace();
            takeScreenShot("second_opinion_positive_dashboard_tc_003");
        }
    }
    
    @Then("navigated to Requested page")
    public void requested_page() throws Exception {
        try {
            if(platformName.equals("Android")){
                page_wait(3000);
                value = driver.findElement(By.xpath(OR_reader("so_requested_icon"))).isDisplayed();
                Assert.assertEquals(true,value);
            }
            text = driver.findElement(By.xpath(OR_reader("so_requested_msg"))).getText();
            Assert.assertEquals(text,td_reader("so_requested_msg"));
        } catch (Exception e) {
            e.printStackTrace();
            takeScreenShot("second_opinion_requested_page");
        }
    }
    
    /* TC_004 - Validate that User is able to click on Reviewed tag */
    @When ("clicks on the Reviewed tab")
    public static void second_opinion_tc_004() throws Exception
    {
        try {
            click("so_reviewed_tab");
        }
        catch (Exception e) {
            e.printStackTrace();
            takeScreenShot("second_opinion_tc_004");
        }
    }
    
    @Then("navigated to Reviewed  page")
    public void reviewed_page() throws Exception {
        try {
            Actions builder=new Actions(driver);
            page_wait(2000);
            if(platformName.equals("Android")){
                page_wait(3000);
                value = driver.findElement(By.xpath(OR_reader("so_requested_icon"))).isDisplayed();
                Assert.assertEquals(true,value);
            }
            text = driver.findElement(By.xpath(OR_reader("so_reviewed_msg"))).getText();
            Assert.assertEquals(text,td_reader("so_reviewed_msg"));
            page_explicit_wait("ServiceDashboardActivity_back",3000);
            builder.moveToElement(driver.findElement(By.xpath(OR_reader("ServiceDashboardActivity_back")))).click().build().perform();
            click("hamburger");
            click("logout");
        } catch (Exception e) {
            e.printStackTrace();
            takeScreenShot("second_opinion_reviewed_page");
        }
    }
}
