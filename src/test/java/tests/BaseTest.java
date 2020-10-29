package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.*;
import steps.CalendarSteps;
import steps.LoginSteps;
import steps.RegistrationSteps;
import utils.CapabilitiesGenerator;
import utils.TestListener;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public class BaseTest {
    WebDriver driver;
    LoginSteps loginSteps;
    RegistrationSteps registrationSteps;
    CalendarPage calendarPage;
    WorkoutPage workoutPage;
    CopyMoveDeleteFrame copyMoveDeleteFrame;
    CalendarSteps calendarSteps;
    DailyVitalsPage dailyVitalsPage;
    DeviceUploadPage deviceUploadPage;
    PrintFrame printFrame;

    @BeforeMethod
    public void setUp(ITestContext context) {

        driver = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //PAGES
        calendarPage = new CalendarPage(driver);
        workoutPage = new WorkoutPage(driver);
        dailyVitalsPage = new DailyVitalsPage(driver);
        deviceUploadPage = new DeviceUploadPage(driver);
        //STEPS
        calendarSteps = new CalendarSteps(driver);
        loginSteps = new LoginSteps(driver);
        registrationSteps = new RegistrationSteps(driver);
        //FRAMES
        copyMoveDeleteFrame = new CopyMoveDeleteFrame(driver);
        printFrame = new PrintFrame(driver);
        context.setAttribute("driver", driver);


    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {

        if (driver != null) {
            driver.quit();
        }


    }
}
