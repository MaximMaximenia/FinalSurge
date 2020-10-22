package steps;

import models.Account;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

public class RegistrationSteps extends BaseSteps {
    public RegistrationSteps(WebDriver driver) {
        super(driver);
    }

    public RegistrationSteps registration(Account account) {
        registerPage
                .fillAccount(account)
                .clickCreateAccount();
        return this;

    }

    public void amountAppearedMessagesShouldBe(int amountEmptyInputs) {
        assertEquals(registerPage.getAmountEmptyInputs(), amountEmptyInputs);
    }

    public void validateRegistration() {
        registerPage
                .validateRegistration();
    }

    public void errorMessageShouldBe(String error) {
        registerPage.
                errorMessageShouldBe(error);
    }

    public void passwordComplexityShouldBe(String password, String complexity) {
        assertEquals(registerPage.sendPasswordAndGetComplexity(password), complexity);
    }
}
