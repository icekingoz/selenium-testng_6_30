package tests;

import org.openqa.selenium.Alert;
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
import java.util.ArrayList;

import static org.testng.Assert.*;


public class Contact {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
    public void contactUs() {
        driver.get("https://demoblaze.com/index.html");

        driver.findElement(By.linkText("tests.Contact")).click();

        WebElement sendMessage = driver.findElement(By.cssSelector("button[onclick='send()']"));

        wait.until(ExpectedConditions.visibilityOf(sendMessage));

        driver.findElement(By.cssSelector("#recipient-email")).sendKeys("test@test.com");
        driver.findElement(By.cssSelector("#recipient-name")).sendKeys("Tester Testington the third");
        driver.findElement(By.cssSelector("#message-text")).sendKeys("test more");

        sendMessage.click();

        Alert al = driver.switchTo().alert();

        String actual = al.getText();
        String expected = "Thanks for the message!!";

        //Step 1 Verify text
        assertEquals( actual, expected);
        //assertEquals( al.getText(), "Thanks for the message!!");

        //Step 2 Click
        al.accept();

    }

    @Test
    public void categories() throws InterruptedException {
        driver.get("https://demoblaze.com/index.html");

        ArrayList<String> categories = new ArrayList<>();
        categories.add("Phones");
        categories.add("Laptops");
        categories.add("Monitors");
        //As one line:
        //List<String> cats = Arrays.asList("Phones", "Laptops", "Monitors");

        WebElement tbody = driver.findElement(By.id("tbodyid"));

        for (String cat : categories) {
            //Click on each catetory
            driver.findElement(By.linkText(cat)).click();
            Thread.sleep(1000);
            //Assert that the correct category is present, and the incorrect is NOT present
            switch (cat) {
                case "Phones":
                    assertTrue(tbody.getText().contains("Samsung galaxy s6"));
                    break;
                case "Laptops":
                    assertTrue(tbody.getText().contains("Sony vaio i5"));
                    break;
                case "Monitors":
                    assertTrue(tbody.getText().contains("Apple monitor 24"));
                    break;
                default:
                    fail("Check the category " + cat);
            }
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
