package tests;

import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {
    @Test
    public void registrationTest() {
        loginSteps
                .openPage()
                .toRegistration();
        registrationSteps
                .registration("Max", "Olejov", "132sss@mailinator.com",
                        "(GMT-07:00) Chihuahua, La Paz, Mazatlan"
                        , "121212112MAs_", "121212112MAs_")
                .validateRegistration();
    }
    @Test
    public void checkingThatMessagesAppearUnderEmptyInputs() {
        loginSteps
                .openPage()
                .toRegistration();
        registrationSteps
                .registration("asda", "asdd", "",
                        "Select..."
                        , "", "")
                .amountAppearedMessagesShouldBe(6);
    }
    @Test
    public void checkRegisteredUserError() {
        loginSteps
                .openPage()
                .toRegistration();
        registrationSteps
                .registration("Max", "Olejov", "132sss@mailinator.com",
                        "(GMT-07:00) Chihuahua, La Paz, Mazatlan"
                        , "121212112MAs_", "121212112MAs_")
                .errorMessageShouldBe("Error: There is already a user account associated with this Email Address." +
                        " Please retrieve your password or create an account with a different address.");
    }
    @Test
    public void checkPasswordDidNotMatchError() {
        loginSteps
                .openPage()
                .toRegistration();
        registrationSteps
                .registration("Max", "Olejov", "132sss@mailinator.com",
                        "(GMT-07:00) Chihuahua, La Paz, Mazatlan"
                        , "121212112MAs", "121212112MAs_")
                .errorMessageShouldBe("Error: The passwords you entered did not match.");
    }
    @Test
    public void checkShortPasswordError() {
        loginSteps
                .openPage()
                .toRegistration();
        registrationSteps
                .registration("Max", "Olejov", "132sss@mailinator.com",
                        "(GMT-07:00) Chihuahua, La Paz, Mazatlan"
                        , "12", "12")
                .errorMessageShouldBe("Error: *Please enter a Password value with at least one number," +
                        " lower-case letter, and upper-case letter between 7 and 15 characters in length.");
    }
}
