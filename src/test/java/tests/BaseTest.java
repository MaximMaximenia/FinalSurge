package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.CalendarPage;
import pages.createWorkout.*;
import steps.LoginSteps;
import steps.RegistrationSteps;
import steps.WorkoutSteps;
import utils.CapabilitiesGenerator;
import utils.TestListener;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public class BaseTest {
    WebDriver driver;
    LoginSteps loginSteps;
    WorkoutSteps workoutSteps;
    RegistrationSteps registrationSteps;
    CalendarPage calendarPage;
    CreateBikeWorkout createBikeWorkout;
    CreateCrossTraining createCrossTraining;
    CreateOtherWorkout createOtherWorkout;
    CreateRecoveryRehab createRecoveryRehab;
    CreateRestDay createRestDay;
    CreateRunWorkout createRunWorkout;
    CreateStrengthTraining createStrengthTraining;
    CreateSwimWorkout createSwimWorkout;
    CreateTransitionWorkout createTransitionWorkout;
    CreateWalkWorkout createWalkWorkout;


    @BeforeMethod
    public void setUp(ITestContext context) {

        driver = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        loginSteps = new LoginSteps(driver);
        workoutSteps = new WorkoutSteps(driver);
        registrationSteps = new RegistrationSteps(driver);
        context.setAttribute("driver", driver);
        calendarPage = new CalendarPage(driver);
        loginSteps.openPage();

        createBikeWorkout = new CreateBikeWorkout(driver);
        createCrossTraining = new CreateCrossTraining(driver);
        createOtherWorkout = new CreateOtherWorkout(driver);
        createRecoveryRehab = new CreateRecoveryRehab(driver);
        createRestDay = new CreateRestDay(driver);
        createRunWorkout = new CreateRunWorkout(driver);
        createStrengthTraining = new CreateStrengthTraining(driver);
        createSwimWorkout = new CreateSwimWorkout(driver);
        createTransitionWorkout = new CreateTransitionWorkout(driver);
        createWalkWorkout = new CreateWalkWorkout(driver);

    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }


    }
}
