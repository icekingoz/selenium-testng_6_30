package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import pages.*;

import java.util.HashMap;
import java.util.Set;

import static org.testng.Assert.*;

public class addToCartTests extends Base {

    @Test
    public void addBYOCtoCart() {
        HomePage hp = new HomePage(driver, wait);
        hp.open();
        hp.clickCategory("Computers");
        hp.clickSubCategory("Desktops");
        hp.clickProduct("Build your own computer");

        BuildYourOwnComputer byoc = new BuildYourOwnComputer(driver, wait);
        byoc.addComputertoCart();

        CartPage cart =  new CartPage(driver, wait);
        cart.clickCart();

        assertTrue(cart.getProductInfo().contains("Build your own computer"));


    }






}
