package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Calendar;

public class BasePage {
    public static final String BASE_URL = "https://log.finalsurge.com/";
    public static final String ADD_WORKOUT_URL = BASE_URL+"WorkoutAdd.cshtml";
    public static final String CALENDAR_URL = BASE_URL+"Calendar.cshtml?v=m&amp;y=2020&amp;m=9&amp;d=16";
    public WebDriverWait wait;
    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public WorkoutPage toWorkoutPage(){
        driver.get(ADD_WORKOUT_URL);
        return new WorkoutPage(driver);
    }
    public CalendarPage openCalendarPage(){
        driver.get(CALENDAR_URL);
        return new CalendarPage(driver);


    }

}
