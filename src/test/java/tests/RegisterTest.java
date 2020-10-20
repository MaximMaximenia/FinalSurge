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
}
