package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {


    public static final By EMAIL_INPUT = By.cssSelector("#login_name");
    public static final By PASSWORD_INPUT = By.cssSelector("#login_password");
    public static final By CHECKBOX_REMEMBER_ME = By.cssSelector("#login_remember");
    public static final By LOGIN_BUTTON = By.cssSelector(".btn");
    public static final By REGISTER_PAGE = By.xpath("//strong[contains(text(),'Not registered?')]");
    public static final By ERROR_MESSAGE = By.cssSelector(".alert");
    public static final By EMPTY_FIELD_MESSAGE = By.xpath("//label[@class='error']");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open login page")
    public LoginPage openPage() {
        driver.get(BASE_URL);
        return this;
    }

    @Step("Get error message")
    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }

    @Step("Check that message under empty fields appear")
    public void checkThatMessageAppear() {
        driver.findElement(EMPTY_FIELD_MESSAGE).isDisplayed();
    }

    @Step("Open register page")
    public void toRegisterPage() {

        driver.findElement(REGISTER_PAGE).click();

        new RegisterPage(driver);
    }

    @Step("Fill login fields: email:{email},password:{password}")
    public LoginPage fillLoginFields(String email, String password, boolean rememberMe) {
        driver.findElement(EMAIL_INPUT).sendKeys(email);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        if (rememberMe) {
            driver.findElement(CHECKBOX_REMEMBER_ME).click();
        }
        driver.findElement(LOGIN_BUTTON).click();
        return this;
    }
    @Step("Click login button")
    public void clickLogin() {
        driver.findElement(LOGIN_BUTTON).click();
    }

}