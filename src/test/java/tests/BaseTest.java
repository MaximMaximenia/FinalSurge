package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
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

    @BeforeMethod
    public void setUp(ITestContext context) {
        driver = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        loginSteps = new LoginSteps(driver);
        workoutSteps = new WorkoutSteps(driver);
        registrationSteps = new RegistrationSteps(driver);
        context.setAttribute("driver", driver);
        loginSteps.openPage();

    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        if(driver != null) {
            driver.quit();
        }
    }
}
