package pages.createWorkout;

import models.workouts.BaseWorkout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

import static java.lang.String.format;

public class CreateBaseWorkout extends BasePage {
    public static final String FEEL = "//span[contains(text(),'%s')]/..//input";
    public static final String SUBTYPE = "//*[@class='nav nav-list']//li[@class='subtypeselector']//a[contains(text(),'%s')]";
    public static final By DATE = By.cssSelector("#WorkoutDate");
    public static final By TIME_OF_DAY = By.cssSelector("#WorkoutTime");
    public static final By WORKOUT_NAME = By.cssSelector("#Name");
    public static final By DESCRIPTION = By.cssSelector("#Desc");
    public static final By DURATION = By.cssSelector("#Duration");
    public static final By DISTANCE = By.cssSelector("#Distance");
    public static final By DISTANCE_TYPE = By.cssSelector("#DistType");
    public static final By SAVE_BUTTON = By.cssSelector("#saveButton");
    public static final By PACE = By.cssSelector("#Pace");
    public static final By PACE_TYPE = By.cssSelector("#PaceType");
    public static final String SELECT_OPTION = "//select[@id='%s']//option[text()='%s']";

    public static final By PERCEIVED_EFFORT = By.cssSelector("#PerEffort");
    public static final By MIN_HR = By.cssSelector("#MinHR");
    public static final By AVG_HR = By.cssSelector("#AvgHR");
    public static final By MAX_HR = By.cssSelector("#MaxHR");
    public static final By CALORIES_BURNED = By.cssSelector("#kCal");
    public static final By AVG_POWER = By.cssSelector("#PowAvg");
    public static final By MAX_POWER = By.cssSelector("#PowMax");
    public static final By AVG_CADENCE = By.cssSelector("#CadAvg");
    public static final By MAX_CADENCE = By.cssSelector("#CadMax");
    public static final By ELEVATION_GAIN = By.cssSelector("#EGain");
    public static final By ELEVATION_GAIN_TYPE = By.cssSelector("#EGainDistType");
    public static final By ELEVATION_LOSS = By.cssSelector("#ELoss");
    public static final By ELEVATION_LOSS_TYPE = By.cssSelector("#ELossDistType");
    public static final String DROP_DOWN = "[data-code='%s']";


    public CreateBaseWorkout(WebDriver driver) {
        super(driver);
    }

    public void openDropdown(String workoutName) {
        driver.findElement(By.cssSelector(format(DROP_DOWN, workoutName))).click();
    }

    public void selectSubType(BaseWorkout workout) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(format(SUBTYPE, workout.getSubType()))));
        driver.findElement(By.xpath(format(SUBTYPE, workout.getSubType()))).click();

    }

    public void fillAvgPower(BaseWorkout baseWorkout) {
        driver.findElement(AVG_POWER).sendKeys(String.valueOf(baseWorkout.getAvgPower()));

    }

    public void fillMaxPower(BaseWorkout baseWorkout) {
        driver.findElement(MAX_POWER).sendKeys(String.valueOf(baseWorkout.getMaxPower()));
    }

    public void fillAvgCadence(BaseWorkout baseWorkout) {
        driver.findElement(AVG_CADENCE).sendKeys(String.valueOf(baseWorkout.getAvgCadence()));
    }

    public void fillMaxCadence(BaseWorkout baseWorkout) {
        driver.findElement(MAX_CADENCE).sendKeys(String.valueOf(baseWorkout.getMaxCadence()));
    }

    public void fillElevationGain(BaseWorkout baseWorkout) {
        driver.findElement(ELEVATION_GAIN).sendKeys(String.valueOf(baseWorkout.getElevationGain()));
    }

    public void fillElevationGainType(BaseWorkout baseWorkout) {
        driver.findElement(ELEVATION_GAIN_TYPE).click();
        driver.findElement(By.xpath(format(SELECT_OPTION, "EGainDistType", baseWorkout.getElevationGainType()))).click();
    }

    public void fillElevationLoss(BaseWorkout baseWorkout) {
        driver.findElement(ELEVATION_LOSS).sendKeys(String.valueOf(baseWorkout.getElevationLoss()));
    }

    public void fillElevationLossType(BaseWorkout baseWorkout) {
        driver.findElement(ELEVATION_LOSS_TYPE).click();
        driver.findElement(By.xpath(format(SELECT_OPTION, "ELossDistType", baseWorkout.getElevationLossType()))).click();
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

    public void fillDistanceType(BaseWorkout baseWorkout) {
        driver.findElement(DISTANCE_TYPE).click();
        driver.findElement(By.xpath(format(SELECT_OPTION, "DistType", baseWorkout.getDistanceType()))).click();
    }

    public void fillPaceType(BaseWorkout baseWorkout) {
        driver.findElement(PACE_TYPE).click();
        driver.findElement(By.xpath(format(SELECT_OPTION, "PaceType", baseWorkout.getPaceType()))).click();
    }

    public void fillPace(BaseWorkout baseWorkout) {

        driver.findElement(PACE).clear();
        driver.findElement(PACE).sendKeys(baseWorkout.getPace());
    }

    public void fillFeel(BaseWorkout baseWorkout) {
        driver.findElement(By.xpath(format(FEEL, baseWorkout.getFeel()))).click();
    }

    public void fillPerceivedEffort(BaseWorkout baseWorkout) {
        driver.findElement(PERCEIVED_EFFORT).click();
        driver.findElement(By.xpath(format(SELECT_OPTION, "PerEffort", baseWorkout.getPerceivedEffort())));
    }

    public void fillMinHR(BaseWorkout baseWorkout) {
        String minHR = String.valueOf(baseWorkout.getMinHR());
        driver.findElement(MIN_HR).sendKeys(minHR);
    }

    public void fillAvgHR(BaseWorkout baseWorkout) {
        String avgHR = String.valueOf(baseWorkout.getAvgHR());
        driver.findElement(AVG_HR).sendKeys(avgHR);
    }

    public void fillMaxHR(BaseWorkout baseWorkout) {
        String maxHR = String.valueOf(baseWorkout.getMaxHR());
        driver.findElement(MAX_HR).sendKeys(maxHR);
    }

    public void fillCaloriesBurned(BaseWorkout baseWorkout) {
        String caloriesBurned = String.valueOf(baseWorkout.getCaloriesBurned());
        driver.findElement(CALORIES_BURNED).sendKeys(caloriesBurned);
    }


    public void clickAddWorkout() {
        driver.findElement(SAVE_BUTTON).click();
    }


}

