package modal.workouts;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

@Setter
@Getter
@ToString
public abstract class BaseWorkout extends BasePage {
    public static final By DATE = By.cssSelector("#WorkoutDate");
    public static final By TIME_OF_DAY = By.cssSelector("#WorkoutTime");
    public static final By WORKOUT_NAME = By.cssSelector("#Name");
    public static final By DESCRIPTION = By.cssSelector("#Desc");
    public static final By DURATION = By.cssSelector("#Duration");
    public static final By DISTANCE = By.cssSelector("#Distance");
    public static final By SAVE_BUTTON = By.cssSelector("#saveButton");
    public static final String FEEL = "//span[contains(text(),'%s')]/..//input";

    String date;
    String timeOfDay;
    String workoutName;
    String description;
    String duration;
    String feel;
    int distance;


    public BaseWorkout(WebDriver driver, String date, String timeOfDay, String workoutName, String description, String duration, int distance, String feel) {
        super(driver);
        this.feel = feel;
        this.date = date;
        this.timeOfDay = timeOfDay;
        this.workoutName = workoutName;
        this.description = description;
        this.duration = duration;
        this.distance = distance;

    }

    public void fillDate(BaseWorkout baseWorkout) {
        driver.findElement(DATE).clear();
        driver.findElement(DATE).sendKeys(baseWorkout.getDate());

    }

    public void fillTimeOfDay(BaseWorkout baseWorkout) {
        driver.findElement(TIME_OF_DAY).sendKeys(baseWorkout.getTimeOfDay());
    }

    public void fillWorkoutName(BaseWorkout baseWorkout) {
        driver.findElement(WORKOUT_NAME).sendKeys(baseWorkout.getWorkoutName());
    }

    public void fillDescription(BaseWorkout baseWorkout) {
        driver.findElement(DESCRIPTION).sendKeys(baseWorkout.getDescription());
    }

    public void fillDuration(BaseWorkout baseWorkout) {
        driver.findElement(DURATION).sendKeys(baseWorkout.getDuration());
    }

    public void fillDistance(BaseWorkout baseWorkout) {
        driver.findElement(DISTANCE).sendKeys(baseWorkout.getDistance() + "");
    }

    public void fillFell(BaseWorkout baseWorkout) {
        driver.findElement(By.xpath(String.format(FEEL, baseWorkout.getFeel()))).click();
    }
    public void fillDefaults(BaseWorkout workout){
        fillDate(workout);
        fillTimeOfDay(workout);
        fillWorkoutName(workout);
        fillDescription(workout);
        fillDuration(workout);
        fillDistance(workout);
        fillFell(workout);
    }
    public void clickAddWorkout(){
        driver.findElement(SAVE_BUTTON).click();
    }

    public abstract BaseWorkout fillAllFields(BaseWorkout workout);

    public abstract BaseWorkout openDropDown();
}



