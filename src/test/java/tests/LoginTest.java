package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import utils.Retry;

public class LoginTest extends BaseTest {
    @Description("Login test")
    @Test(retryAnalyzer = Retry.class)
    public void login() {

        loginSteps
                .login("masya@mail.ru", "1234321MAks__", false)
                .validateLogin();

    }

    @Description("Check messages under empty email field ")
    @Test(retryAnalyzer = Retry.class)
    public void checkEmptyEmailMessage() {

        loginSteps
                .login("", "1234321MAks__", false)
                .checkThatMessageUnderInputAppear();
    }

    @Description("Check messages under empty password field ")
    @Test(retryAnalyzer = Retry.class)
    public void checkEmptyPasswordMessage() {

        loginSteps
                .login("masya@mail.ru", "", false)
                .checkThatMessageUnderInputAppear();

    }

    @Description("Check non existent user error ")
    @Test(retryAnalyzer = Retry.class)
    public void nonExistentUserError() {

        loginSteps
                .login("masya@mail.rus", "1234321MAks__", false)
                .errorMessageShouldBe("Invalid login credentials. Please try again.");

    }

    @Description("Logout test")
    @Test
    public void logoutTest() {
        loginSteps
                .login("masya@mail.ru", "1234321MAks__", false)
                .logOut();

    }
}