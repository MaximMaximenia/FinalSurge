package steps;

import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage;

public class BaseSteps extends BasePage {
    LoginPage loginPage = new LoginPage(driver);
    MainPage mainPage = new MainPage(driver);
    RegisterPage registerPage;

    public BaseSteps(WebDriver driver) {
        super(driver);
    }
}
