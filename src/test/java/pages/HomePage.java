package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait   = wait;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get("https://nop-qa.portnov.com/");
        wait.until(ExpectedConditions.titleIs("Your store. Home page title"));
    }

    //Create 3 methods: Click on a Category, click on Sub Category, Click on Product
    public void clickCategory(String category) {
        driver.findElement(By.linkText(category)).click();
        wait.until(ExpectedConditions.titleContains(category));
    }

    public void clickSubCategory(String subCategory) {
        driver.findElement(By.linkText(subCategory)).click();
        wait.until(ExpectedConditions.titleContains(subCategory));
    }

    public void clickProduct(String product) {
//        if (product.equalsIgnoreCase("BYOC")) {
//            driver.findElement(By.linkText("Build your own computer")).click();
//        } else {
//            driver.findElement(By.linkText(product)).click();
//        }
        driver.findElement(By.linkText(product)).click();
        wait.until(ExpectedConditions.titleContains(product));
    }



}
