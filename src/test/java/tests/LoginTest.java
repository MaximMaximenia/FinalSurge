package tests;

import org.testng.annotations.Test;
import utils.Retry;

public class LoginTest extends BaseTest {

    @Test//(retryAnalyzer = Retry.class)
    public void login() {

        loginSteps
                .openPage()
                .login("masya@mail.ru", "1234321MAks__", false)
                .validateLogin();

    }

    @Test//(retryAnalyzer = Retry.class)
    public void checkEmptyEmailMessage() {

        loginSteps
                .login("", "1234321MAks__", false)
                .checkThatMessageUnderInputAppear();
    }

    @Test//(retryAnalyzer = Retry.class)
    public void checkEmptyPasswordMessage() {

        loginSteps
                .login("masya@mail.ru", "", false)
                .checkThatMessageUnderInputAppear();

    }

    @Test//(retryAnalyzer = Retry.class)
    public void nonExistentUserError() {

        loginSteps
                .login("masya@mail.rus", "1234321MAks__", false)
                .errorMessageShouldBe("Invalid login credentials. Please try again.");

    }
}