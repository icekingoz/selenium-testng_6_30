package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.Base;
import pages.BuildYourOwnComputer;

import static org.testng.Assert.*;

public class BYOCTest extends Base {

    @Test
    public void uiTest() {
        //Instantiate Page Object
        BuildYourOwnComputer byoc = new BuildYourOwnComputer(driver, wait);
        //Using the PO Methods
        byoc.goToPage();
//      Assert Product Name
        assertEquals(byoc.getProductName().getText(), "Build your own computer");
//        Assert Processor Dropdown
        assertTrue(byoc.getProcessor().isDisplayed(), "ERROR: Processor missing");
//        Assert RAM Dropdown
        assertTrue(byoc.getRam().isDisplayed(), "ERROR ITS NOT HERE MAAAAN!!!!");
//        Assert HDD Radios
        for (WebElement li: byoc.getHdd()) {
            assertTrue(li.isDisplayed(), "ERROR ITS NOT HERE MAAAAN!!!!");
        }
//        Assert OS Radio
        for (WebElement input: byoc.getOs()) {
            assertTrue(input.isDisplayed(), "ERROR ITS NOT HERE MAAAAN!!!!");
        }
//        Assert Software Checkboxes
        for (WebElement input: byoc.getSoftware()) {
            assertTrue(input.isDisplayed(), "ERROR ITS NOT HERE MAAAAN!!!!");
        }
//        Price, Add to Cart, Wishlist, Add to Comparare list, Email, Description, Product Tags, Customer who bought this item
    }

    @Test
    public void addToCartRequired() {
        BuildYourOwnComputer byoc = new BuildYourOwnComputer(driver,wait);
        byoc.goToPage();
        //click add to cart
        byoc.clickAddToCart();
        //assert Error Message
        assertEquals(byoc.getBarNotificationError().getText(), "Please select RAM" + "\n" + "Please select HDD");
        //Select RAM
        byoc.selectRam("4GB [+$20.00]");
        //Select HDD
        byoc.selectHDD("400 GB [+$100.00]");
        //Click add to cart
        byoc.clickAddToCart();
        //Verify success
        assertEquals(byoc.getBarNotificationSuccess().getText(), "The product has been added to your shopping cart");

    }

    @Test
    public void addToCartOptional() {
        BuildYourOwnComputer byoc = new BuildYourOwnComputer(driver,wait);

    }


//    Killroy was here

}
