package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class NotSignedInCheckout {

    //Field
    private final WebDriver driver ;
    private final WebDriverWait wait;

    @FindBy(css = ".button-1.checkout-as-guest-button")
    private WebElement checkoutAsGuest;


    public NotSignedInCheckout(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void clickCheckoutAsGuest() {
        checkoutAsGuest.click();
        wait.until(ExpectedConditions.titleIs("Your store. Checkout"));
    }






}
