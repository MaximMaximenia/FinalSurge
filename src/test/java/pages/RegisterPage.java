package pages;

import modal.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import static org.testng.Assert.assertEquals;

public class RegisterPage extends BasePage {
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public static final String XPATH_FOR_INPUTS = "//*[contains(text(),'%s')]/following-sibling::input";
    public static final String GET_ERROR_UNDER_LOCATOR = "//label[contains(text(),'%s')]/following-sibling::label";
    public static final By SELECT_TIME_ZONE = By.cssSelector("#create_timezone");
    public static final By CREATE_NEW_ACCOUNT_BUTTON = By.cssSelector(".btn");
    public static final By ERROR_MESSAGE = By.cssSelector(".alert");
    public static final By PASSWORD_COMPLEXITY = By.cssSelector(".pwdText");
    public static final String URN = "register.cshtml?page_redirect=%2f";

    public String isPageOpened() {
        return driver.getCurrentUrl();
    }


    public void fillAccount(Account account) {

        Select select = new Select(driver.findElement(SELECT_TIME_ZONE));
        select.selectByVisibleText(account.getTimeZone());
        driver.findElement(By.xpath(String.format(XPATH_FOR_INPUTS, "First Name"))).sendKeys(account.getFirsName());
        driver.findElement(By.xpath(String.format(XPATH_FOR_INPUTS, "Last Name"))).sendKeys(account.getLastName());
        driver.findElement(By.xpath(String.format(XPATH_FOR_INPUTS, "Email Address"))).sendKeys(account.getEmail());
        driver.findElement(By.xpath(String.format(XPATH_FOR_INPUTS, "Password"))).sendKeys(account.getPassword());
        driver.findElement(By.xpath(String.format(XPATH_FOR_INPUTS, "Re-type password"))).sendKeys(account.getReTypePassword());

    }

    public void clickCreateAccount() {
        driver.findElement(CREATE_NEW_ACCOUNT_BUTTON).click();
    }

    public void passwordComplexityShouldBe(String expectedComplexity) {
        assertEquals(driver.findElement(PASSWORD_COMPLEXITY).getText(), expectedComplexity);
    }

    public void checkThatErrorAppearedUnderLocator(String locator) {
        driver.findElement(By.xpath(String.format(GET_ERROR_UNDER_LOCATOR, locator))).isDisplayed();
    }

    public void errorMessageShouldBe(String error) {
        assertEquals(driver.findElement(ERROR_MESSAGE).getText(), error);

    }
}
