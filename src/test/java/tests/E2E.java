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

public class E2E {

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
    public void e2e() throws InterruptedException {
        //Logged Out State
        driver.get("https://demoblaze.com/index.html");
        //Click on the Monitors Category
        driver.findElement(By.linkText("Monitors")).click();

        Thread.sleep(1000);
        //Click on th ASUS Full HD
        driver.findElement(By.linkText("ASUS Full HD")).click();
        //Wait for page to load > Add to Cart
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[normalize-space()='Add to cart']")));
        driver.findElement(By.xpath("//a[normalize-space()='Add to cart']")).click();
//        WebElement addToCart = driver.findElement(By.xpath("//a[normalize-space()='Add to cart']"));
        //Accept the Alert
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();

        //click Cart, and assert you are there
        driver.findElement(By.id("cartur")).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h2[normalize-space()='Products']")));

        List<WebElement> list = driver.findElements(By.linkText("Delete"));
        list.getLast().click();

        driver.findElement(By.xpath("//tbody//td[text()='Samsung galaxy s6']/..//a")).click();

        //Place order > wait > fill out info
        driver.findElement(By.xpath("//button[normalize-space()='Place Order']")).click();
        //Purchase and assert the info
        WebElement label = driver.findElement(By.id("totalm"));
        wait.until(ExpectedConditions.visibilityOf(label));
        // Amount, Card Name, Name, Date
        String[] amountArr =  label.getText().strip().split(":");
        String amount = amountArr[1];
        String name = "Ozzy GMan";
        String cardNumber = "123";

        driver.findElement(By.id("name")).sendKeys(name);
        driver.findElement(By.id("card")).sendKeys(cardNumber);
        driver.findElement(By.xpath("//button[normalize-space()='Purchase']")).click();

        WebElement pText = driver.findElement(By.xpath("//p[@class='lead text-muted ']"));

        assertTrue(pText.getText().contains(name));
        assertTrue(pText.getText().contains(cardNumber));
        assertTrue(pText.getText().contains(amount));
        //OK > verify we back
        driver.findElement(By.xpath("//button[normalize-space()='OK']")).click();
        assertEquals(driver.getTitle(),"STORE");

        List<WebElement> deletes = driver.findElements(By.xpath("//a[text()='Delete']"));
        deletes.getLast().click();


    }

//    Logging in first
//    You are two Items.
//    Delete one from Cart
//    Assert Different total
//    Place order and do the rest as we did





    @AfterClass
    public void tearDown() {
        driver.quit();
    }


}
