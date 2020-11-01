package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
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
        log.info("Open login page");
        driver.get(BASE_URL);
        return this;
    }

    @Step("Get error message")
    public String getErrorMessage() {

        log.info("Get error message for assert");
        return driver.findElement(ERROR_MESSAGE).getText();
    }

    @Step("Check that message under empty fields appear")
    public void checkThatMessageAppear() {
        log.info("Check empty field messages");
        driver.findElement(EMPTY_FIELD_MESSAGE).isDisplayed();
    }

    @Step("Open register page")
    public void toRegisterPage() {
        log.info("Open register page ");
        driver.findElement(REGISTER_PAGE).click();

        new RegisterPage(driver);
    }

    @Step("Fill login fields: email:{email},password:{password}")
    public LoginPage fillLoginFields(String email, String password, boolean rememberMe) {
        log.info("Fill login fields \nlogin: " + email + "\npassword: " + password);
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

        log.info("Click login button");
        driver.findElement(LOGIN_BUTTON).click();
    }

}