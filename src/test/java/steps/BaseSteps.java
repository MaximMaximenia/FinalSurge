package steps;

import org.openqa.selenium.WebDriver;
import pages.*;

public class BaseSteps extends BasePage {
    LoginPage loginPage = new LoginPage(driver);
    MainPage mainPage = new MainPage(driver);
    RegisterPage registerPage = new RegisterPage(driver);
    WorkoutPage workoutPage = new WorkoutPage(driver);

    public BaseSteps(WebDriver driver) {
        super(driver);
    }
}
