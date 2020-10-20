package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public static final String BASE_URL = "https://log.finalsurge.com/";
    public static final String WORKOUT_URL = BASE_URL+"WorkoutAdd.cshtml";
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
        driver.get(WORKOUT_URL);
        return new WorkoutPage(driver);
    }

}
