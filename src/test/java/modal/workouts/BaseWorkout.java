package modal.workouts;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
    public static final By DISTANCE_TYPE = By.cssSelector("#DistType");
    public static final By SAVE_BUTTON = By.cssSelector("#saveButton");
    public static final String FEEL = "//span[contains(text(),'%s')]/..//input";
    public static final String SUBTYPE = "//*[@class='nav nav-list']//li[@class='subtypeselector']//a[contains(text(),'%s')]";

    String date;

    String timeOfDay;
    String workoutName;
    String description;
    String duration;
    String feel;
    int distance;
    String distanceType;


    public BaseWorkout(WebDriver driver, String date, String timeOfDay, String workoutName, String description, String duration, int distance,String distanceType, String feel) {
        super(driver);
        this.feel = feel;
        this.date = date;
        this.timeOfDay = timeOfDay;
        this.workoutName = workoutName;
        this.description = description;
        this.duration = duration;
        this.distance = distance;

    }

    public void fillDistanceType(BaseWorkout baseWorkout) {
        Select selectDistanceType = new Select(driver.findElement(DISTANCE_TYPE));
        selectDistanceType.selectByIndex(1);
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

    public void fillFeel(BaseWorkout baseWorkout) {
        driver.findElement(By.xpath(String.format(FEEL, baseWorkout.getFeel()))).click();
    }

    public void fillDefaults(BaseWorkout workout) {
        fillDate(workout);
        fillTimeOfDay(workout);
        fillWorkoutName(workout);
        fillDescription(workout);
        fillDuration(workout);
        fillDistance(workout);
        fillFeel(workout);
        fillDistanceType(workout);
    }

    public BaseWorkout selectSubType(String subtype) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(SUBTYPE, subtype))));
        driver.findElement(By.xpath(String.format(SUBTYPE, subtype))).click();

        return this;
    }

    public void clickAddWorkout() {
        driver.findElement(SAVE_BUTTON).click();
    }

    public abstract BaseWorkout fillAllFields(BaseWorkout workout, String subtype);

    public abstract BaseWorkout openDropDown();


}



