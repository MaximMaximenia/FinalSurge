package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

public class LoginSteps extends BaseSteps {

    public LoginSteps(WebDriver driver) {
        super(driver);
    }
    @Step("Validate login")
    public void validateLogin() {
        assertEquals(loginPage.getCurrentUrl(), BASE_URL + "Calendar.cshtml");
    }

    @Step("Login")
    public LoginSteps login(String email, String password, boolean rememberMe) {
        loginPage
                .openPage()
                .fillLoginFields(email, password, rememberMe)
                .clickLogin();
        return this;
    }

    @Step("Open login page")
    public LoginSteps openPage() {
        loginPage.openPage();
        return this;
    }

    public RegistrationSteps toRegistration() {
        loginPage.toRegisterPage();
        return new RegistrationSteps(driver);
    }

    @Step("Check error message")
    public void errorMessageShouldBe(String error) {
        assertEquals(loginPage.getErrorMessage(), error);
    }

    @Step("Check messages under fields")
    public void checkThatMessageUnderInputAppear() {
        loginPage.checkThatMessageAppear();
    }
}
