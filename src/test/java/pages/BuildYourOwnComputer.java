package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BuildYourOwnComputer {

    private final WebDriver driver;
    private final WebDriverWait wait;

    //  Attributes
    @FindBy(css = "div[class='product-name'] h1")
    private WebElement productName;
    @FindBy(css = "#product_attribute_1")
    private WebElement processor;
    @FindBy(css = "#product_attribute_2")
    private WebElement ram;
    @FindBy(xpath = "//dd[@id='product_attribute_input_3']//input")
    private List<WebElement> hdd;
    @FindBy(xpath = "//dd[@id='product_attribute_input_4']//input")
    private List<WebElement> os;
    @FindBy(xpath = "//dd[@id='product_attribute_input_5']//input")
    private List<WebElement> software;
    @FindBy(css = "#add-to-cart-button-1")
    private WebElement addToCart;
    @FindBy(css = ".bar-notification.error")
    private WebElement barNotificationError;
    @FindBy(css = ".bar-notification.success")
    private WebElement barNotificationSuccess;
    @FindBy(css = "span[title='Close']")
    private WebElement notificationClose;


    //Constructor
    public BuildYourOwnComputer(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        //PageFactory
        PageFactory.initElements(driver, this);
    }

    public void goToPage() {
        driver.get("https://nop-qa.portnov.com/build-your-own-computer");
        wait.until(ExpectedConditions.titleIs("Your store. Build your own computer"));
    }

    public void addComputertoCart() {
        selectRam("2 GB");
        selectHDD("320 GB");
        clickAddToCart();
        notificationClose.click();
        wait.until(ExpectedConditions.invisibilityOf(notificationClose));
    }

    public void addComputertoCart(String ram) {
        selectRam(ram);
        selectHDD("320 GB");
        clickAddToCart();
        notificationClose.click();
    }

    public void addComputertoCart(String ram, String hdd) {
        selectRam(ram);
        selectHDD(hdd);
        clickAddToCart();
        notificationClose.click();
    }


    public void clickAddToCart() {
        addToCart.click();
    }

    public void selectRam(String value) {
        Select select = new Select(ram);
        select.selectByVisibleText(value);
    }

    public void selectHDD(String size) {
        switch (size) {
            case "320 GB":
                hdd.get(0).click();
                break;
            case "400 GB [+$100.00]":
                hdd.get(1).click();
                break;
        }
    }


//--------Getters and Setters

    public WebElement getProductName() {
        return productName;
    }

    public WebElement getProcessor() {
        return processor;
    }


    public WebElement getRam() {
        return ram;
    }

    public List<WebElement> getHdd() {
        return hdd;
    }

    public List<WebElement> getOs() {
        return os;
    }

    public List<WebElement> getSoftware() {
        return software;
    }

    public WebElement getBarNotificationError() {
        return barNotificationError;
    }

    public WebElement getBarNotificationSuccess() {
        return barNotificationSuccess;
    }
}
