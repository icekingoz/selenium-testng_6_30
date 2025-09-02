package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import java.time.Duration;

public class MyFirstTest {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @Test
    public void login() throws InterruptedException {

        driver.get("https://demoblaze.com/");


        //Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


        driver.findElement(By.xpath("//a[@id='login2']")).click();

        //Creating a Wait Object
        WebDriverWait wait = new WebDriverWait( driver, Duration.ofSeconds(10) );

        //Storing WebElement for use of wait and sendkeys
        WebElement userName = driver.findElement(By.id("loginusername"));

        //Explicit Wait
        wait.until(ExpectedConditions.visibilityOf(userName));
        userName.sendKeys("User!1");

    }



    @Ignore
    @Test
    public void textBoxTest() {
        driver.get("https://demoqa.com/text-box");

        driver.findElement(By.cssSelector("#userName")).sendKeys("Ozzy Gman");
        driver.findElement(By.cssSelector("#userEmail")).sendKeys("test@test.com");
        driver.findElement(By.xpath("//textarea[@id='currentAddress']")).sendKeys("123 Main Street");
        driver.findElement(By.xpath("//textarea[@id='permanentAddress']")).sendKeys("321 Paper Street");

        driver.findElement(By.cssSelector("#submit")).click();

        WebElement actual = driver.findElement(By.cssSelector("#output"));
        Assert.assertTrue(actual.isDisplayed(), "Output window is not displayed");
        Assert.assertTrue((actual.getText().contains("Troy Harding")), "Output window does NOT contain the right word");

    }

    @Ignore
    @Test(
            priority = 2
    )
    public void myTest() {
        driver.get("https://www.google.com/");
    }

    @Ignore
    @Test(
            priority = 1
    )
    public void test2() {
        driver.get("https://duckduckgo.com/");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
