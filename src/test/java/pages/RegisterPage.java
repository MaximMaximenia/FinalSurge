package pages;

import models.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static java.lang.String.format;
import static org.testng.Assert.assertEquals;

public class RegisterPage extends BasePage {
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public static final String XPATH_FOR_INPUTS = "//*[contains(text(),'%s')]/following-sibling::input";
    public static final String GET_ERROR_UNDER_LOCATORS = "//label/following-sibling::label";
    public static final By SELECT_TIME_ZONE = By.cssSelector("#create_timezone");
    public static final By CREATE_NEW_ACCOUNT_BUTTON = By.cssSelector(".btn");
    public static final By ERROR_MESSAGE = By.cssSelector(".alert");
    public static final By PASSWORD_COMPLEXITY = By.cssSelector(".pwdText");
    public static final By VALIDATE = By.cssSelector(".user-info");

    public RegisterPage fillAccount(Account account) {

        Select select = new Select(driver.findElement(SELECT_TIME_ZONE));
        select.selectByVisibleText(account.getTimeZone());
        driver.findElement(By.xpath(format(XPATH_FOR_INPUTS, "First Name"))).sendKeys(account.getFirsName());
        driver.findElement(By.xpath(format(XPATH_FOR_INPUTS, "Last Name"))).sendKeys(account.getLastName());
        driver.findElement(By.xpath(format(XPATH_FOR_INPUTS, "Email Address"))).sendKeys(account.getEmail());
        driver.findElement(By.xpath(format(XPATH_FOR_INPUTS, "Password"))).sendKeys(account.getPassword());
        driver.findElement(By.xpath(format(XPATH_FOR_INPUTS, "Re-type password"))).sendKeys(account.getReTypePassword());
        return this;

    }

    public RegisterPage clickCreateAccount() {
        driver.findElement(CREATE_NEW_ACCOUNT_BUTTON).click();
        return this;
    }


    public String sendPasswordAndGetComplexity(String passsword) {
        driver.findElement(By.xpath(format(XPATH_FOR_INPUTS, "Password"))).sendKeys(passsword);

        return driver.findElement(PASSWORD_COMPLEXITY).getText();
    }

    public int getAmountEmptyInputs() {

        List<WebElement> allAppearedMessages = driver.findElements(By.xpath(GET_ERROR_UNDER_LOCATORS));
        return allAppearedMessages.size();
    }

    public void errorMessageShouldBe(String error) {
        assertEquals(driver.findElement(ERROR_MESSAGE).getText(), error);

    }

    public void validateRegistration() {
        driver.findElement(VALIDATE).isDisplayed();
    }
}
