package steps;

import modal.Account;
import org.openqa.selenium.WebDriver;

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
                .clickCreateAccount()
                .getCurrentUrl();
        return this;

    }

    public void validateRegistration() {
        registerPage
                .validateRegistration();
    }
}
