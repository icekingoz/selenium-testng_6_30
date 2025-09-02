package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public abstract class Base {

    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

//    public void loginInWithDefaultUser() {
//        driver.findElement(By.cssSelector(".ico-login")).click();
//        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#Email")));
//        driver.findElement(By.cssSelector("#Email")).click();
//        driver.findElement(By.cssSelector("#Password")).click();
//        driver.findElement(By.cssSelector("button[class='button-1 login-button']")).click();
//    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
