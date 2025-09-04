package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import pages.Base;
import pages.CartPage;
import pages.ElegantGemstoneNecklace;
import pages.HomePage;

import static org.testng.Assert.*;


public class rentCartTest extends Base {

//    Start on HomePage > Go to Jewelry > Elegant Gemstone Rental > Create PO *EG
//    Add it to cart > Go to cart and verify: The dates, the price

    @Test
    public void rentalTest(){
        HomePage hpLovecraft = new HomePage(driver, wait);
        hpLovecraft.open();

        hpLovecraft.clickCategory("Jewelry");
        hpLovecraft.clickProduct("Elegant Gemstone Necklace (rental)");
        System.out.println("dfdfdf");

        ElegantGemstoneNecklace egn = new ElegantGemstoneNecklace(driver,wait);

        egn.setStartDate("4");
        egn.setEndDate("5");
        egn.getRentButton().click();
        egn.getCloseNotification().click();
        wait.until(ExpectedConditions.invisibilityOf(egn.getCloseNotification()));

        CartPage ct = new CartPage(driver,wait);

        ct.clickCart();

        assertTrue(ct.getProductInfo().contains("Start date: 9/4/2025"));
        assertTrue(ct.getProductInfo().contains("End date: 9/5/2025."));

        WebElement total = ct.getTable().findElement(By.cssSelector("td[class='subtotal']"));
        assertTrue(total.getText().contains("30.00"));

    }

}
