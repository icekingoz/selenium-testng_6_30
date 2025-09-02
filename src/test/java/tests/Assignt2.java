package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class Assignt2 {

    @Test
    public void headerLinksNavigateCorrectly() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoblaze.com/");

        // 1) Header items to test
        List<String> headers = Arrays.asList("Home", "tests.Contact", "About us", "Log in", "Sign up");

        for (String hdr : headers) {
            WebElement link = driver.findElement(By.xpath("//a[contains(.,'" + hdr + "')]"));
            driver.findElement(By.partialLinkText(hdr)).click();
            link.click();

//            if (hdr.equals("About us")) {
//                // 2a) Modal pops up
//                WebElement modalTitle = driver.findElement(By.className("modal-title"));
//                assertTrue(modalTitle.isDisplayed(), "About us modal missing");
//                driver.findElement(By.cssSelector(".modal-footer button")).click();
//            } else {
//                // 2b) Navigates to a new page
//                String url = driver.getCurrentUrl().toLowerCase();
//                assertTrue(url.contains(hdr.toLowerCase()),
//                        "URL should contain '" + hdr + "' but was " + url);
//                driver.navigate().back();
//            }
        }

        driver.quit();
    }
}
