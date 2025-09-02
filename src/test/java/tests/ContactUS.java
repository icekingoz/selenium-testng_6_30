package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ContactUS {


    @Test
    public void contactUsSendsMessage() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoblaze.com/");

        // 1) Open tests.Contact Us modal
        driver.findElement(By.linkText("tests.Contact")).click();

        // 2) Fill fields
        driver.findElement(By.id("recipient-name")).sendKeys("Ozzy Gman");
        driver.findElement(By.id("recipient-email")).sendKeys("ozzy@example.com");
        driver.findElement(By.id("message-text")).sendKeys("Hello from Selenium!");

        // 3) Send and handle alert
        driver.findElement(By.xpath("//button[text()='Send message']")).click();
        Alert alert = driver.switchTo().alert();

        // 4) Verify and accept
        String alertText = alert.getText();
        assertTrue(alertText.contains("Thanks"), "Unexpected alert: " + alertText);
        alert.accept();

        driver.quit();
    }


}
