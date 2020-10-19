package tests;

import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void login() {

        loginSteps
                .openPage()
                .login("masya@mail.ru", "1234321MAks__", false)
                .validateLogin();

    }

    @Test
    public void checkEmptyEmailMessage() {

        loginSteps
                .login("", "1234321MAks__", false)
                .checkThatMessageUnderInputAppear();
    }

    @Test
    public void checkEmptyPasswordMessage() {

        loginSteps
                .login("masya@mail.ru", "", false)
                .checkThatMessageUnderInputAppear();

    }

    @Test
    public void nonExistentUserError() {

        loginSteps
                .login("masya@mail.rus", "1234321MAks__", false)
                .errorMessageShouldBe("Invalid login credentials. Please try again.");

    }
}