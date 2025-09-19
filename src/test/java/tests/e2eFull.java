package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.*;

import static org.testng.Assert.*;


public class e2eFull extends Base {

    @Test(groups = {"smoke","e2e"})
    public void e2eCheckoutAsGuest() {
        HomePage homePage = new HomePage(driver, wait);
        homePage.open();
        homePage.clickCategory("Computers");
        homePage.clickSubCategory("Desktops");
        homePage.clickProduct("Build your own computer");

        BuildYourOwnComputer byoc = new BuildYourOwnComputer(driver,wait);
        byoc.addComputertoCart();

        //Cart
        CartPage cartPage = new CartPage(driver, wait);
        cartPage.clickCart();
        cartPage.acceptTos();
        cartPage.clickCheckout();


        //NotSignedIn
        NotSignedInCheckout nsc = new NotSignedInCheckout(driver, wait);
        nsc.clickCheckoutAsGuest();

        Checkout checkout = new Checkout(driver,wait);
        checkout.populateNewAddress();

        assertTrue(checkout.getOrderNumber().isDisplayed());



    }

}
