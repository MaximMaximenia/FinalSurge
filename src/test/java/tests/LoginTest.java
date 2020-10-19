package tests;

import org.testng.annotations.Test;
import utils.Retry;

public class LoginTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class)
    public void login() {

        loginPage
                .fillLoginFields("masya@mail.ru", "1234321MAks__", false)
                .clickLogin()
                .validateLogin();

    }

    @Test
    public void checkEmptyEmailMessage() {

        loginPage
                .fillLoginFields("", "1234321MAks__", false)
                .clickLogin()
                .checkThatMessageAppear("Please enter your e-mail address.");
    }

    @Test
    public void checkEmptyPasswordMessage() {

        loginPage
                .fillLoginFields("masya@mail.ru", "", false)
                .clickLogin()
                .checkThatMessageAppear("Please enter a password.");
    }
    @Test
    public void nonExistentUserError() {

        loginPage
                .fillLoginFields("masya@mail.ru", "123123123", false)
                .clickLogin()
                .errorMessageShouldBe("Invalid login credentials. Please try again.");
    }
}
