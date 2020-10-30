package steps;

import org.openqa.selenium.WebDriver;
import pages.*;
import pages.gearAndRoutesPage.BikesPage;
import pages.gearAndRoutesPage.RoutesPage;
import pages.gearAndRoutesPage.ShoesPage;

public class BaseSteps extends BasePage {
    LoginPage loginPage = new LoginPage(driver);
    RegisterPage registerPage = new RegisterPage(driver);
    WorkoutPage workoutPage = new WorkoutPage(driver);
    CopyMoveDeleteFrame copyMoveDeleteFrame = new CopyMoveDeleteFrame(driver);
    CalendarPage calendarPage = new CalendarPage(driver);
    BikesPage bikesPages = new BikesPage(driver);
    RoutesPage routesPage = new RoutesPage(driver);
    ShoesPage shoesPage = new ShoesPage(driver);

    public BaseSteps(WebDriver driver) {
        super(driver);
    }
}
