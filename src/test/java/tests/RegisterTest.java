package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import pages.Base;
import pages.RegisterPage;

import java.util.HashMap;
import java.util.Set;

import static org.testng.Assert.*;

public class RegisterTest extends Base {


    @Test
    public void registerTest() {
        driver.get("https://nop-qa.portnov.com/");

        RegisterPage registerPage = new RegisterPage(driver, wait);

        HashMap<String,String> userCreds = registerPage.registerUser();
        String email = userCreds.keySet().toArray()[0].toString();
        String password = userCreds.get(email);

        //Login with newly registed user
//        LoginPage pageObject =  new LoginPage(driver, wait);
//        pageObject.login("test@test.com", "test1234")

    }

    @Test
    public void clickThroughCategories() {
        driver.get("https://nop-qa.portnov.com/");

//        Create Page Object for HomePage
//        Create a method called clickCategory(String pLink) (make the method accept a Partial Link)
//        Make a loop in the test, to click through each of the Categories
//        inside the loop, do assertions every time
//        assertTrue();
    }

    @Test
    public void loginIn() {
        driver.get("https://nop-qa.portnov.com/");
//        loginInWithDefaultUser();
    }

    @Test
    public void somethingElse() {
        driver.get("https://nop-qa.portnov.com/");
//        loginInWithDefaultUser();
    }

}
