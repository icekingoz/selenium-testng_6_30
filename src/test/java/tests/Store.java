package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static org.testng.Assert.*;


public class Store {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }


    @Test
    public void categories() {
        driver.get("https://store-qa.portnov.com/");
        String[] categories = {"Mac", "iPhone", "Watch", "Accessories"};
        //Click Category
        //Verify Title/Header
        //Click the Back Button
        //Repeat

        for (String cat: categories) {
//            switch (cat) {
//                case "Mac": driver.findElement(By.id("menu-item-15")).click();
//                    break;
//                case "iPhone": driver.findElement(By.id("menu-item-13")).click();
//                    break;
//                case "Watch": driver.findElement(By.id("menu-item-16")).click();
//                    break;
//                case "Accessories": driver.findElement(By.id("menu-item-12")).click();
//                    break;
//                default: fail("Wrong Category");
//            }
//            wait.until(ExpectedConditions.titleContains(cat));
            clickCategory(cat);
            assertTrue(driver.getTitle().contains(cat));
            driver.navigate().back();
        }
    }


//    1. Navigate to Page
//    2. Select a Category
//    3. Add Product to Cart
//    4. Click on View Cart (button or cart)
//    5. Update the quantity
//    6. Proceed to Checkout
//    7. Fill out info and click Place Order
//    8. Proceed to Checkout
//    9. Verify Order is Received
//    Optional verify order has the correct Product.
//    Legendary Quest: Make it all loopable.








    @Test
    public void products() {
        driver.get("https://store-qa.portnov.com/");
        List<WebElement> products = driver.findElements(By.xpath("//ul[@class='products columns-3']//img"));
        String title = driver.getTitle();

        for (WebElement product: products) {
            product.click();
            assertNotEquals(driver.getTitle(), title);
            driver.navigate().back();
        }
//       clickProduct("AirPods Pro");
    }

    public void clickProduct(String product) {
        driver.findElement(By.xpath("//img[@alt='" + product +  "']")).click();
        wait.until(ExpectedConditions.titleContains(product));
    }

    public void clickCategory(String cat) {
        switch (cat) {
            case "Mac": driver.findElement(By.id("menu-item-15")).click();
                break;
            case "iPhone": driver.findElement(By.id("menu-item-13")).click();
                break;
            case "Watch": driver.findElement(By.id("menu-item-16")).click();
                break;
            case "Accessories": driver.findElement(By.id("menu-item-12")).click();
                break;
            default: fail("Wrong Category");
        }
        wait.until(ExpectedConditions.titleContains(cat));
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }


}
