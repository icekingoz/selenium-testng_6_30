package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Checkout {

    @FindBy(css = "#BillingNewAddress_FirstName")
    private WebElement firstName;

    @FindBy(css = "#BillingNewAddress_LastName")
    private WebElement lastName;

    @FindBy(css = "#BillingNewAddress_Email")
    private WebElement email;

    @FindBy(css = "#BillingNewAddress_CountryId")
    private WebElement country;

    @FindBy(css = "#BillingNewAddress_StateProvinceId")
    private WebElement state;

    @FindBy(css = "#BillingNewAddress_City")
    private WebElement city;

    @FindBy(css = "#BillingNewAddress_Address1")
    private WebElement address1;

    @FindBy(css = "#BillingNewAddress_ZipPostalCode")
    private WebElement zip;

    @FindBy(css = "#BillingNewAddress_PhoneNumber")
    private WebElement phoneNumber;

    @FindBy(css = "#billingaddress-next-button")
    private WebElement nextButton;

    @FindBy(css = "button[name='nextstep']")
    private WebElement nextButtonGeneric;

    @FindBy(css = ".order-number")
    private WebElement orderNumber;


    private final WebDriver driver;
    private final WebDriverWait wait;

    public Checkout(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void populateNewAddress() {
        firstName.sendKeys("First");
        lastName.sendKeys("Last");
        email.sendKeys("test@test.com");
        //County
        Select countrySelect = new Select(country);
        countrySelect.selectByVisibleText("United States of America");
        //State
        Select stateSelect = new Select(state);
        stateSelect.selectByVisibleText("Hawaii");

        city.sendKeys("Townsville");
        address1.sendKeys("123 Paper Street");
        zip.sendKeys("91234");
        phoneNumber.sendKeys("3231231234");
        //Click Next
        nextButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space()='Select shipping method']")));
        //Shipping
        nextButtonGeneric.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space()='Select payment method']")));
        //Payment
        nextButtonGeneric.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space()='Payment information']")));
        //Payment Info
        nextButtonGeneric.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space()='Confirm your order']")));
        //Confirm
        nextButtonGeneric.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space()='Thank you']")));

    }

    public WebElement getOrderNumber() {
        return orderNumber;
    }



}
