package models.workouts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;

import static java.lang.String.format;
import static java.lang.String.valueOf;
import static org.testng.Assert.assertEquals;

public class CreateAndValidateBaseWorkout extends BasePage {

    private static final String FEEL = "//span[contains(text(),'%s')]/..//input";
    private static final String SUBTYPE = "//*[@class='nav nav-list']//li[@class='subtypeselector']//a[contains(text(),'%s')]";
    private static final By DATE = By.cssSelector("#WorkoutDate");
    private static final By TIME_OF_DAY = By.cssSelector("#WorkoutTime");
    private static final By WORKOUT_NAME = By.cssSelector("#Name");
    private static final By DESCRIPTION = By.cssSelector("#Desc");
    private static final By DURATION = By.cssSelector("#Duration");
    private static final By DISTANCE = By.cssSelector("#Distance");
    private static final By DISTANCE_TYPE = By.cssSelector("#DistType");
    private static final By PACE = By.cssSelector("#Pace");
    private static final By PACE_TYPE = By.cssSelector("#PaceType");
    private static final String SELECT_OPTION = "//select[@id='%s']//option[text()='%s']";
    private static final By PERCEIVED_EFFORT = By.cssSelector("#PerEffort");
    private static final By MIN_HR = By.cssSelector("#MinHR");
    private static final By AVG_HR = By.cssSelector("#AvgHR");
    private static final By MAX_HR = By.cssSelector("#MaxHR");
    private static final String VALIDATE_SELECT = "//select[@id='%s']//option[@selected]";
    private static final By CALORIES_BURNED = By.cssSelector("#kCal");
    private static final By AVG_POWER = By.cssSelector("#PowAvg");
    private static final By MAX_POWER = By.cssSelector("#PowMax");
    private static final By AVG_CADENCE = By.cssSelector("#CadAvg");
    private static final By MAX_CADENCE = By.cssSelector("#CadMax");
    private static final By POST_WORKOUT = By.cssSelector("#PostDesc");
    private static final By ELEVATION_GAIN = By.cssSelector("#EGain");
    private static final By ELEVATION_GAIN_TYPE = By.cssSelector("#EGainDistType");
    private static final By ELEVATION_LOSS = By.cssSelector("#ELoss");
    private static final By VALIDATE_SUBTYPE = By.cssSelector(".subtypeselector.active");
    private static final By ELEVATION_LOSS_TYPE = By.cssSelector("#ELossDistType");
    private static final By ACTIVITY_TYPE = By.cssSelector("#ActivityType");
    private static final By HOW_I_FELT = By.cssSelector("#HowFeel");
    private static final String DROP_DOWN = "[data-code='%s']";
    //Cross and Strength Training Locators
    private static final By DISTANCE_TYPE_NO_INT = By.cssSelector("#DistTypeNoInt");
    private static final By DISTANCE_NO_INT = By.cssSelector("#DistanceNoInt");
    private static final By DURATION_NO_INT = By.cssSelector("#DurationNoInt");

    public CreateAndValidateBaseWorkout(WebDriver driver) {
        super(driver);
    }

    protected void createCrossTraining(BaseWorkout workout) {
        fillDefaults(workout);
        fillTimeOfDay(workout);
        driver.findElement(DISTANCE_TYPE_NO_INT).click();
        driver.findElement(By.xpath(format(SELECT_OPTION, "DistTypeNoInt", workout.getDistanceType()))).click();
        driver.findElement(DISTANCE_NO_INT).sendKeys(valueOf(workout.getDistance()));
        driver.findElement(By.xpath(format(SELECT_OPTION, "PaceTypeNoInt", workout.getPaceType()))).click();
        driver.findElement(DURATION_NO_INT).sendKeys(workout.getDuration());
        fillFeel(workout);
        fillMinHR(workout);
        fillMaxHR(workout);
        fillAvgHR(workout);
        fillPerceivedEffort(workout);
        fillCaloriesBurned(workout);

    }

    protected void createStrengthTraining(BaseWorkout workout) {
        fillDefaults(workout);
        fillTimeOfDay(workout);
        driver.findElement(DURATION_NO_INT).sendKeys(workout.getDuration());
        fillFeel(workout);
        fillPerceivedEffort(workout);

    }

    protected void validateCrossTraining(BaseWorkout workout) {
        validateDefaults(workout);
        validateTimeOfDay(workout);
        assertEquals(driver.findElement(DURATION_NO_INT).getAttribute("value"), workout.getDuration());
        assertEquals(driver.findElement(DISTANCE_NO_INT).getAttribute("value"), valueOf(workout.getDistance()));
        assertEquals(getSelectedOption("DistTypeNoInt"), workout.getDistanceType());
        assertEquals(getSelectedOption("PaceTypeNoInt"), workout.getPaceType());
        validateFeel(workout);
        validatePerceivedEffort(workout);
        validateMinHR(workout);
        validateMaxHR(workout);
        validateAvgHR(workout);
        validateCaloriesBurned(workout);
    }

    protected void validateStrengthTraining(BaseWorkout workout) {
        validateDefaults(workout);
        validateTimeOfDay(workout);
        assertEquals(driver.findElement(DURATION_NO_INT).getAttribute("value"), workout.getDuration());
        validateFeel(workout);
        validatePerceivedEffort(workout);
    }

    protected void validateDefaults(BaseWorkout workout) {
        validateDate(workout);
        validateWorkoutDescription(workout);
        validateWorkoutName(workout);
    }

    protected String getSelectedOption(String selectID) {
        return driver.findElement(By.xpath(format(VALIDATE_SELECT, selectID))).getText();
    }

    protected void openDropdown(String workoutName) {
        driver.findElement(By.cssSelector(format(DROP_DOWN, workoutName))).click();
    }

    protected void validateSubType(BaseWorkout workout) {
        assertEquals(driver.findElement(VALIDATE_SUBTYPE).getText(), workout.getSubType());
    }

    protected void validateDate(BaseWorkout workout) {
        assertEquals(driver.findElement(DATE).getAttribute("value"), workout.getDate());
    }

    protected void validateTimeOfDay(BaseWorkout workout) {
        assertEquals(driver.findElement(TIME_OF_DAY).getAttribute("value"), workout.getTimeOfDay());
    }

    protected void validateWorkoutName(BaseWorkout workout) {
        assertEquals(driver.findElement(WORKOUT_NAME).getAttribute("value"), workout.getWorkoutName());
    }

    protected void validateWorkoutDescription(BaseWorkout workout) {
        assertEquals(driver.findElement(DESCRIPTION).getAttribute("value"), workout.getDescription());
    }

    protected void validateDistanceType(BaseWorkout workout) {
        assertEquals(getSelectedOption("DistType"), workout.getDistanceType());
    }

    protected void validateDistance(BaseWorkout workout) {
        assertEquals(driver.findElement(DISTANCE).getAttribute("value"), String.valueOf(workout.getDistance()));
    }

    protected void validatePaceType(BaseWorkout workout) {
        assertEquals(getSelectedOption("PaceType"), workout.getPaceType());
    }

    protected void validatePace(BaseWorkout workout) {
        assertEquals(driver.findElement(PACE).getAttribute("value"), workout.getPace());
    }

    protected void validateDuration(BaseWorkout workout) {
        assertEquals(driver.findElement(DURATION).getAttribute("value"), workout.getDuration());
    }

    protected void validateFeel(BaseWorkout workout) {
        driver.findElement(By.xpath(format(FEEL, workout.getFeel()))).isSelected();
    }

    protected void validatePerceivedEffort(BaseWorkout workout) {
        assertEquals(getSelectedOption("PerEffort"), workout.getPerceivedEffort());
    }

    protected void validateMinHR(BaseWorkout workout) {
        assertEquals(driver.findElement(MIN_HR).getAttribute("value"), String.valueOf(workout.getMinHR()));
    }

    protected void validateAvgHR(BaseWorkout workout) {
        assertEquals(driver.findElement(AVG_HR).getAttribute("value"), String.valueOf(workout.getAvgHR()));
    }

    protected void validateMaxHR(BaseWorkout workout) {
        assertEquals(driver.findElement(MAX_HR).getAttribute("value"), String.valueOf(workout.getMaxHR()));
    }

    protected void validateCaloriesBurned(BaseWorkout workout) {
        assertEquals(driver.findElement(CALORIES_BURNED).getAttribute("value"), String.valueOf(workout.getCaloriesBurned()));
    }

    protected void validateAvgPower(BaseWorkout workout) {
        assertEquals(driver.findElement(AVG_POWER).getAttribute("value"), String.valueOf(workout.getAvgPower()));
    }

    protected void validateMaxPower(BaseWorkout workout) {
        assertEquals(driver.findElement(MAX_POWER).getAttribute("value"), String.valueOf(workout.getMaxPower()));
    }

    protected void validateAvgCadence(BaseWorkout workout) {
        assertEquals(driver.findElement(AVG_CADENCE).getAttribute("value"), String.valueOf(workout.getAvgCadence()));
    }

    protected void validateMaxCadence(BaseWorkout workout) {
        assertEquals(driver.findElement(MAX_CADENCE).getAttribute("value"), String.valueOf(workout.getMaxCadence()));
    }

    protected void validateElevationGainType(BaseWorkout workout) {
        assertEquals(getSelectedOption("EGainDistType"), workout.getElevationGainType());
    }

    protected void validateElevationGain(BaseWorkout workout) {
        String elevationGain = driver.findElement(ELEVATION_GAIN).getAttribute("value");
        assertEquals(elevationGain.substring(0, elevationGain.indexOf(".")), valueOf(workout.getElevationGain()));
    }

    protected void validateElevationLossType(BaseWorkout workout) {
        assertEquals(getSelectedOption("ELossDistType"), workout.getElevationLossType());
    }

    protected void validateElevationLoss(BaseWorkout workout) {
        String elevationLoss = driver.findElement(ELEVATION_LOSS).getAttribute("value");
        assertEquals(elevationLoss.substring(0, elevationLoss.indexOf(".")), valueOf(workout.getElevationLoss()));
    }

    protected void selectSubType(BaseWorkout workout) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(format(SUBTYPE, workout.getSubType()))));
        driver.findElement(By.xpath(format(SUBTYPE, workout.getSubType()))).click();

    }

    protected void fillAvgPower(BaseWorkout workout) {
        driver.findElement(AVG_POWER).clear();
        driver.findElement(AVG_POWER).sendKeys(valueOf(workout.getAvgPower()));

    }

    protected void fillMaxPower(BaseWorkout workout) {
        driver.findElement(MAX_POWER).clear();
        driver.findElement(MAX_POWER).sendKeys(valueOf(workout.getMaxPower()));
    }

    protected void fillAvgCadence(BaseWorkout workout) {
        driver.findElement(AVG_CADENCE).clear();
        driver.findElement(AVG_CADENCE).sendKeys(valueOf(workout.getAvgCadence()));
    }

    protected void fillDefaults(BaseWorkout workout) {
        fillDate(workout);
        fillWorkoutName(workout);
        fillDescription(workout);
    }

    protected void fillActivityTypeByIndex(BaseWorkout workout) {
        Select select = new Select(driver.findElement(ACTIVITY_TYPE));
        select.selectByIndex(workout.getActivityType());

    }

    public void selectOption(WebElement element, String option) {
        Select select = new Select(element);
        select.selectByVisibleText(option);
    }

    protected void fillMaxCadence(BaseWorkout workout) {
        driver.findElement(MAX_CADENCE).clear();
        driver.findElement(MAX_CADENCE).sendKeys(valueOf(workout.getMaxCadence()));
    }

    protected void fillElevationGain(BaseWorkout workout) {
        driver.findElement(ELEVATION_GAIN).clear();
        driver.findElement(ELEVATION_GAIN).sendKeys(valueOf(workout.getElevationGain()));
    }

    protected void fillElevationGainType(BaseWorkout workout) {
        selectOption(driver.findElement(ELEVATION_GAIN_TYPE), workout.getElevationGainType());

    }

    protected void fillElevationLoss(BaseWorkout workout) {
        driver.findElement(ELEVATION_LOSS).clear();
        driver.findElement(ELEVATION_LOSS).sendKeys(valueOf(workout.getElevationLoss()));
    }

    protected void fillElevationLossType(BaseWorkout baseWorkout) {
        selectOption(driver.findElement(ELEVATION_LOSS_TYPE), baseWorkout.getElevationLossType());
    }

    protected void fillDate(BaseWorkout workout) {
        driver.findElement(DATE).clear();
        driver.findElement(DATE).sendKeys(workout.getDate());

    }

    protected void fillTimeOfDay(BaseWorkout workout) {
        driver.findElement(TIME_OF_DAY).clear();
        driver.findElement(TIME_OF_DAY).sendKeys(workout.getTimeOfDay());
    }

    protected void fillWorkoutName(BaseWorkout workout) {
        driver.findElement(WORKOUT_NAME).clear();
        driver.findElement(WORKOUT_NAME).sendKeys(workout.getWorkoutName());
    }

    protected void fillDescription(BaseWorkout workout) {
        driver.findElement(DESCRIPTION).clear();
        driver.findElement(DESCRIPTION).sendKeys(workout.getDescription());
    }

    protected void fillDuration(BaseWorkout workout) {
        driver.findElement(DURATION).clear();
        driver.findElement(DURATION).sendKeys(workout.getDuration());
    }

    protected void fillDistance(BaseWorkout workout) {
        driver.findElement(DISTANCE).clear();
        driver.findElement(DISTANCE).sendKeys(workout.getDistance() + "");
    }

    protected void fillDistanceType(BaseWorkout workout) {
        selectOption(driver.findElement(DISTANCE_TYPE), workout.getDistanceType());
    }

    protected void fillPaceType(BaseWorkout workout) {
        selectOption(driver.findElement(PACE_TYPE), workout.getPaceType());
    }

    protected void fillHowIFelt(BaseWorkout workout) {
        selectOption(driver.findElement(HOW_I_FELT), workout.getFeel());
    }

    protected void fillPace(BaseWorkout workout) {
        driver.findElement(PACE).clear();
        driver.findElement(PACE).sendKeys(workout.getPace());
    }

    protected void fillPostWorkout(BaseWorkout workout) {
        driver.findElement(POST_WORKOUT).clear();
        driver.findElement(POST_WORKOUT).sendKeys(workout.getPostWorkout());
    }

    protected void fillFeel(BaseWorkout workout) {
        driver.findElement(By.xpath(format(FEEL, workout.getFeel()))).click();
    }

    protected void fillPerceivedEffort(BaseWorkout workout) {
        selectOption(driver.findElement(PERCEIVED_EFFORT), workout.getPerceivedEffort());
    }

    protected void fillMinHR(BaseWorkout workout) {
        driver.findElement(MIN_HR).clear();
        driver.findElement(MIN_HR).sendKeys(String.valueOf(workout.getMinHR()));
    }

    protected void fillAvgHR(BaseWorkout workout) {
        driver.findElement(AVG_HR).clear();
        driver.findElement(AVG_HR).sendKeys(String.valueOf(workout.getAvgHR()));
    }

    protected void fillMaxHR(BaseWorkout workout) {
        driver.findElement(MAX_HR).clear();
        driver.findElement(MAX_HR).sendKeys(String.valueOf(workout.getMaxHR()));
    }

    protected void fillCaloriesBurned(BaseWorkout workout) {
        driver.findElement(CALORIES_BURNED).clear();
        driver.findElement(CALORIES_BURNED).sendKeys(String.valueOf(workout.getCaloriesBurned()));
    }


}

