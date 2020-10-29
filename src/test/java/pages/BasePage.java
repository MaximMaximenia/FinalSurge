package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.String.format;

public class BasePage {
    public static final String BASE_URL = "https://log.finalsurge.com/";
    public static final String ADD_WORKOUT_URL = BASE_URL + "WorkoutAdd.cshtml";
    public static final String CALENDAR_URL = BASE_URL + "Calendar.cshtml?v=m&amp;y=2020&amp;m=9&amp;d=16";
    public static final String DAILY_VITALS_URL = BASE_URL + "DailyVitals";
    public static final String DEVICE_UPLOAD_URL = BASE_URL + "DeviceImport/Garmin/Default.cshtml";
    public static final By LOGOUT = By.cssSelector("[href ='logout.cshtml']");
    public static final By WORKOUTS_DROPDOWN = By.xpath("//a[@class='arrow_down'and text()='Workouts']");
    public static final By PRINT_WORKOUTS = By.cssSelector("[data-reveal-id='PrintWorkouts']");
    public static final String LOGOUT_MESSAGE = "You have been successfully logged out of the system.";

    public WebDriverWait wait;
    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
    }
    public PrintFrame openPrintFrame(){
        Actions actions = new Actions(driver);
        WebElement workoutsDropDown = driver.findElement(WORKOUTS_DROPDOWN);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(WORKOUTS_DROPDOWN)));
        actions.moveToElement(workoutsDropDown).perform();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(PRINT_WORKOUTS)));
        driver.findElement(PRINT_WORKOUTS).click();
        return new PrintFrame(driver);
    }

    public DeviceUploadPage toDeviceUploadPage() {
        driver.get(DEVICE_UPLOAD_URL);
        return new DeviceUploadPage(driver);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public WorkoutPage toWorkoutPage() {
        driver.get(ADD_WORKOUT_URL);
        return new WorkoutPage(driver);
    }

    public CalendarPage openCalendarPage() {
        driver.get(CALENDAR_URL);
        return new CalendarPage(driver);
    }

    public DailyVitalsPage toDailyVitals() {
        driver.get(DAILY_VITALS_URL);
        return new DailyVitalsPage(driver);

    }

    private void validateLogOut() {
        driver.findElement(By.xpath(String.format("//strong[contains(text(),'%s')]", LOGOUT_MESSAGE)));
    }

    public void logOut() {
        driver.findElement(LOGOUT).click();
        validateLogOut();
    }

}
