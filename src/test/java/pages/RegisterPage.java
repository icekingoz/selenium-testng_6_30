package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;

public class RegisterPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public RegisterPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public HashMap<String, String> registerUser() {
        HashMap<String, String> map =  new HashMap<>();
        map.put("test@test.com", "test1234");

        driver.findElement(By.linkText("Register")).click();
        wait.until(ExpectedConditions.titleContains("Register"));

        driver.findElement(By.cssSelector("#FirstName")).sendKeys("John");
        driver.findElement(By.cssSelector("#LastName")).sendKeys("Wick");
        driver.findElement(By.cssSelector("#Email")).sendKeys("test@test.com");

        driver.findElement(By.cssSelector("#Password")).sendKeys("test1234");
        driver.findElement(By.cssSelector("#ConfirmPassword")).sendKeys("test1234");

        driver.findElement(By.cssSelector("#register-button")).click();

        return map;
    }





}
