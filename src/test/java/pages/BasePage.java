package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Log4j2
public class BasePage {
    public static final String BASE_URL = "https://log.finalsurge.com/";
    public static final String ADD_WORKOUT_URL = BASE_URL + "WorkoutAdd.cshtml";
    public static final String CALENDAR_URL = BASE_URL + "Calendar.cshtml?v=m&amp;y=2020&amp;m=9&amp;d=16";
    public static final String DAILY_VITALS_URL = BASE_URL + "DailyVitals";
    public static final String WORKOUT_REPORT_URL = BASE_URL + "WorkoutReport.cshtml";
    public static final String DEVICE_UPLOAD_URL = BASE_URL + "DeviceImport/Garmin/Default.cshtml";
    public static final By LOGOUT = By.cssSelector("[href ='logout.cshtml']");
    public static final By WORKOUTS_DROPDOWN = By.xpath("//a[@class='arrow_down'and text()='Workouts']");
    public static final By PRINT_WORKOUTS = By.cssSelector("[data-reveal-id='PrintWorkouts']");
    public static final String LOGOUT_MESSAGE = "You have been successfully logged out of the system.";

    public WebDriverWait wait;
    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    @Step("Open workout report page")
    public WorkoutReportPage toWorkoutReportPage() {
        log.info("Open workout report page");
        driver.get(WORKOUT_REPORT_URL);
        return new WorkoutReportPage(driver);
    }

    @Step("Open print frame")
    public PrintFrame openPrintFrame() {
        log.info("Open print frame");
        Actions actions = new Actions(driver);
        WebElement workoutsDropDown = driver.findElement(WORKOUTS_DROPDOWN);
        wait.until(ExpectedConditions.elementToBeClickable(workoutsDropDown));
        actions.moveToElement(workoutsDropDown).perform();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(PRINT_WORKOUTS)));
        driver.findElement(PRINT_WORKOUTS).click();
        return new PrintFrame(driver);
    }

    @Step("Open device upload page")
    public DeviceUploadPage toDeviceUploadPage() {
        log.info("Open device upload page");
        driver.get(DEVICE_UPLOAD_URL);
        return new DeviceUploadPage(driver);
    }

    @Step("Get current url")
    public String getCurrentUrl() {
        log.info("Get current url: "+driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    @Step("Open workout page")
    public WorkoutPage toWorkoutPage() {
        log.info("Open workout page");
        driver.get(ADD_WORKOUT_URL);
        return new WorkoutPage(driver);
    }

    @Step("Open calendar page")
    public CalendarPage openCalendarPage() {
        log.info("Open calendar page");
        driver.get(CALENDAR_URL);
        return new CalendarPage(driver);
    }

    @Step("Open daily vitals page")
    public DailyVitalsPage toDailyVitals() {
        log.info("Open daily virals page");
        driver.get(DAILY_VITALS_URL);
        return new DailyVitalsPage(driver);

    }

    @Step("Validate logOut")
    private void validateLogOut() {
        log.info("Validate logout");
        driver.findElement(By.xpath(String.format("//strong[contains(text(),'%s')]", LOGOUT_MESSAGE)));
    }

    @Step("Logout")
    public void logOut() {
        log.info("Logout");
        driver.findElement(LOGOUT).click();
        validateLogOut();
    }

}
