package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ElegantGemstoneNecklace {

    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(css = "#rental_start_date_40")
    private WebElement startDate;

    @FindBy(css = ".ui-datepicker-calendar")
    private WebElement datePickerTable;

    @FindBy(css = "#rental_end_date_40")
    private WebElement endDate;

    @FindBy(css = "#add-to-cart-button-40")
    private WebElement rentButton;

    @FindBy(css = "span[title='Close']")
    private WebElement closeNotification;


    public ElegantGemstoneNecklace(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);

    }


//    setStartDate
    public void setStartDate(String number) {
        startDate.click();
        wait.until(ExpectedConditions.visibilityOf(datePickerTable));
        WebElement date = datePickerTable.findElement(By.xpath("//td//a[text()='" + number +"']"));
        date.click();
        wait.until(ExpectedConditions.invisibilityOf(datePickerTable));
    }

//    setEndDate
public void setEndDate(String number) {
    endDate.click();
    wait.until(ExpectedConditions.visibilityOf(datePickerTable));
    WebElement date = datePickerTable.findElement(By.xpath("//td//a[text()='" + number +"']"));
    date.click();
    wait.until(ExpectedConditions.invisibilityOf(datePickerTable));
}

//    clickRentButton

    public WebElement getRentButton() {
        return rentButton;
    }

    public WebElement getCloseNotification() {
        return closeNotification;
    }


}
