package steps;

import modal.Account;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

public class RegistrationSteps extends BaseSteps {
    public RegistrationSteps(WebDriver driver) {
        super(driver);
    }

    public RegistrationSteps registration(String firstName, String lasName, String email, String timeZone, String password, String reTypePassword) {

        Account account = Account.builder()

                .firsName(firstName)
                .lastName(lasName)
                .email(email)
                .timeZone(timeZone)
                .password(password)
                .reTypePassword(reTypePassword)

                .build();


        registerPage
                .fillAccount(account)
                .clickCreateAccount();
        return this;

    }

    public void amountAppearedMessagesShouldBe(int amountEmptyInputs) {
        assertEquals(registerPage.getAmountEmptyInputs(),amountEmptyInputs);
    }

    public void validateRegistration() {
        registerPage
                .validateRegistration();
    }
    public void errorMessageShouldBe(String error){
        registerPage.
                errorMessageShouldBe(error);
    }
}
