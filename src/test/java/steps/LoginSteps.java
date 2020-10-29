package steps;

import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

public class LoginSteps extends BaseSteps {

    public LoginSteps(WebDriver driver) {
        super(driver);
    }

    public void validateLogin() {
        assertEquals(loginPage.getCurrentUrl(), BASE_URL + "Calendar.cshtml");
    }


    public LoginSteps login(String email, String password, boolean rememberMe) {
        loginPage
                .openPage()
                .fillLoginFields(email, password, rememberMe)
                .clickLogin();
        return this;
    }

    public LoginSteps openPage() {
        loginPage.openPage();
        return this;
    }

    public RegistrationSteps toRegistration() {
        loginPage.toRegisterPage();
        return new RegistrationSteps(driver);
    }


    public void errorMessageShouldBe(String error) {
        assertEquals(loginPage.getErrorMessage(), error);
    }

    public void checkThatMessageUnderInputAppear() {
        loginPage.checkThatMessageAppear();
    }
}
