package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class Categories {

    @Test
    public void categoriesHighlightOnClick() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoblaze.com/");

        // 1) List of side-panel categories
        List<String> cats = Arrays.asList("Phones", "Laptops", "Monitors");

        for (String cat : cats) {
            // 2) Click category link
            WebElement link = driver.findElement(By.linkText(cat));
            link.click();

            // 3) Verify it’s marked active
            String classes = link.getAttribute("class");
            assertTrue(classes.contains("active"),
                    cat + " should be active but has: " + classes);
        }

        driver.quit();
    }




}
