package steps;

import io.qameta.allure.Step;
import models.Account;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

public class RegistrationSteps extends BaseSteps {
    public RegistrationSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Registration ")
    public RegistrationSteps registration(Account account) {
        registerPage
                .fillAccount(account)
                .clickCreateAccount();
        return this;
    }

    @Step("Check amount appeared messages under fields(expected:{expectedAmountEmptyInputs})")
    public void amountAppearedMessagesShouldBe(int expectedAmountEmptyInputs) {
        assertEquals(registerPage.getAmountEmptyInputs(), expectedAmountEmptyInputs);
    }

    @Step("Validate registration")
    public void validateRegistration() {
        registerPage.validateRegistration();
    }

    @Step("Check error message")
    public void errorMessageShouldBe(String error) {
        registerPage.errorMessageShouldBe(error);
    }

    @Step("Check password complexity(expected:{complexity})")
    public void passwordComplexityShouldBe(String password, String complexity) {
        assertEquals(registerPage.sendPasswordAndGetComplexity(password), complexity);
    }
}
