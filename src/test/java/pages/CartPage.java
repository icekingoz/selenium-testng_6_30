package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CartPage {

    @FindBy(css = ".cart-label")
    private WebElement cartLabel;

    @FindBy(css = ".cart")
    private WebElement table;

    private final WebDriver driver;
    private final WebDriverWait wait;

    public CartPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait   = wait;
        PageFactory.initElements(driver, this);
    }

    public void clickCart() {
        cartLabel.click();
        wait.until(ExpectedConditions.titleIs("Your store. Shopping Cart"));
    }

    public String getProductInfo() {
        WebElement row = table.findElement(By.cssSelector("tbody > tr"));
        String tdData = row.findElement(By.className("product")).getText();
        return tdData;
    }

    public String getProductInfo(String product) {
        List<WebElement> rows = table.findElements(By.cssSelector("tbody > tr"));
        WebElement correctRow = null;

        for (WebElement row : rows) {
            String tdData = row.findElement(By.className("product")).getText();
            if (tdData.contains(product)) {
                correctRow = row;
                break;
            }
        }

        String tdData = correctRow.findElement(By.className("product")).getText();
        return tdData;
    }

    public void removeItem() {
        WebElement row = table.findElement(By.cssSelector("tbody > tr"));
        WebElement td = row.findElement(By.className("remove-from-cart"));
        td.findElement(By.className("remove-btn")).click();
    }

    public WebElement getTable() {
        return table;
    }

}
