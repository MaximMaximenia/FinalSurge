package tests;

import io.qameta.allure.Description;
import models.Account;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Random;

public class RegisterTest extends BaseTest {
    Random r = new Random();
    Account defaultUser = Account.builder().firsName("Agent").lastName("AsdaAs").email(r.nextInt(1000) + "ls@mailinator.com").timeZone("(GMT-07:00) Chihuahua, La Paz, Mazatlan").password("121212112MAs_").reTypePassword("121212112MAs_").build();
    Account emptyUser = Account.builder().firsName("").lastName("").email("").timeZone("").password("").reTypePassword("").build();
    Account registered = Account.builder().firsName("Agent").lastName("AsdaAs").email("132sss@mailinator.com").timeZone("(GMT-07:00) Chihuahua, La Paz, Mazatlan").password("121212112MAs_").reTypePassword("121212112MAs_").build();
    Account notCorrectPassword = Account.builder().firsName("Agent").lastName("AsdaAs").email(r.nextInt(1000) + "ls@mailinator.com").timeZone("(GMT-07:00) Chihuahua, La Paz, Mazatlan").password("121").reTypePassword("121").build();
    Account passwordDidNotMatch = Account.builder().firsName("Agent").lastName("AsdaAs").email(r.nextInt(1000) + "ls@mailinator.com").timeZone("(GMT-07:00) Chihuahua, La Paz, Mazatlan").password("1111111Sa").reTypePassword("2222222As").build();

    @DataProvider(name = "Errors")
    public Object[][] errors() {
        return new Object[][]{
                {registered, "Error: There is already a user account associated with this Email Address." +
                        " Please retrieve your password or create an account with a different address."},
                {notCorrectPassword, "Error: *Please enter a Password value with at least one number," +
                        " lower-case letter, and upper-case letter between 7 and 15 characters in length."},
                {passwordDidNotMatch, "Error: The passwords you entered did not match."}};
    }

    @DataProvider(name = "Password Complexity")
    public Object[][] complexity() {
        return new Object[][]{
                {"1234321", "WEAK"},
                {"1234321LAsa", "MEDIUM"},
                {"1234321LAsa_", "STRONG"},
                {"1234321LAsa_-", "VERY STRONG"},
        };
    }
    @Description("Check register errors")
    @Test(dataProvider = "Errors")
    public void checkErrors(Account account, String error) {
        loginSteps
                .openPage()
                .toRegistration();
        registrationSteps
                .registration(account)
                .errorMessageShouldBe(error);
    }
    @Description("Check password complexity field ")
    @Test(dataProvider = "Password Complexity")
    public void checkPasswordComplexity(String password, String complexity) {
        loginSteps
                .openPage()
                .toRegistration();
        registrationSteps
                .passwordComplexityShouldBe(password, complexity);

    }
    @Description("Registration test")
    @Test
    public void registrationTest() {


        loginSteps
                .openPage()
                .toRegistration();
        registrationSteps
                .registration(defaultUser)
                .validateRegistration();
    }
    @Description("Check messages under empty fields")
    @Test
    public void checkingThatMessagesAppearUnderEmptyInputs() {
        loginSteps
                .openPage()
                .toRegistration();
        registerPage
                .clickCreateAccount();
        registrationSteps
                .amountAppearedMessagesShouldBe(5);
    }

}
