package models.workouts;

import io.qameta.allure.Step;
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

    @Step("Create Сross Training ")
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

    @Step("Create Strength Training ")
    protected void createStrengthTraining(BaseWorkout workout) {
        fillDefaults(workout);
        fillTimeOfDay(workout);
        driver.findElement(DURATION_NO_INT).sendKeys(workout.getDuration());
        fillFeel(workout);
        fillPerceivedEffort(workout);

    }

    @Step("Validate CrossTraining")
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

    @Step("Validate StranghtTraining")
    protected void validateStrengthTraining(BaseWorkout workout) {
        validateDefaults(workout);
        validateTimeOfDay(workout);
        assertEquals(driver.findElement(DURATION_NO_INT).getAttribute("value"), workout.getDuration());
        validateFeel(workout);
        validatePerceivedEffort(workout);
    }

    @Step("Validate Default Fields")
    protected void validateDefaults(BaseWorkout workout) {
        validateDate(workout);
        validateWorkoutDescription(workout);
        validateWorkoutName(workout);
    }

    protected String getSelectedOption(String selectID) {
        return driver.findElement(By.xpath(format(VALIDATE_SELECT, selectID))).getText();
    }

    @Step("Open Workout Drop Down")
    protected void openDropdown(String workoutName) {
        driver.findElement(By.cssSelector(format(DROP_DOWN, workoutName))).click();
    }

    @Step("Validate SubType")
    protected void validateSubType(BaseWorkout workout) {
        assertEquals(driver.findElement(VALIDATE_SUBTYPE).getText(), workout.getSubType());
    }

    @Step("Validate Date")
    protected void validateDate(BaseWorkout workout) {
        assertEquals(driver.findElement(DATE).getAttribute("value"), workout.getDate());
    }

    @Step("Validate TimeOfDay")
    protected void validateTimeOfDay(BaseWorkout workout) {
        assertEquals(driver.findElement(TIME_OF_DAY).getAttribute("value"), workout.getTimeOfDay());
    }

    @Step("Validate Workout Name")
    protected void validateWorkoutName(BaseWorkout workout) {
        assertEquals(driver.findElement(WORKOUT_NAME).getAttribute("value"), workout.getWorkoutName());
    }

    @Step("Validate Description")
    protected void validateWorkoutDescription(BaseWorkout workout) {
        assertEquals(driver.findElement(DESCRIPTION).getAttribute("value"), workout.getDescription());
    }

    @Step("Validate Distance Type")
    protected void validateDistanceType(BaseWorkout workout) {
        assertEquals(getSelectedOption("DistType"), workout.getDistanceType());
    }

    @Step("Validate Distance")
    protected void validateDistance(BaseWorkout workout) {
        assertEquals(driver.findElement(DISTANCE).getAttribute("value"), String.valueOf(workout.getDistance()));
    }

    @Step("Validate Pace Type")
    protected void validatePaceType(BaseWorkout workout) {
        assertEquals(getSelectedOption("PaceType"), workout.getPaceType());
    }

    @Step("Validate Pace")
    protected void validatePace(BaseWorkout workout) {
        assertEquals(driver.findElement(PACE).getAttribute("value"), workout.getPace());
    }

    @Step("Validate Duration")
    protected void validateDuration(BaseWorkout workout) {
        assertEquals(driver.findElement(DURATION).getAttribute("value"), workout.getDuration());
    }

    @Step("Validate Feel")
    protected void validateFeel(BaseWorkout workout) {
        driver.findElement(By.xpath(format(FEEL, workout.getFeel()))).isSelected();
    }

    @Step("Validate Perceived Effort")
    protected void validatePerceivedEffort(BaseWorkout workout) {
        assertEquals(getSelectedOption("PerEffort"), workout.getPerceivedEffort());
    }

    @Step("Validate Min HR")
    protected void validateMinHR(BaseWorkout workout) {
        assertEquals(driver.findElement(MIN_HR).getAttribute("value"), String.valueOf(workout.getMinHR()));
    }

    @Step("Validate Avg HR")
    protected void validateAvgHR(BaseWorkout workout) {
        assertEquals(driver.findElement(AVG_HR).getAttribute("value"), String.valueOf(workout.getAvgHR()));
    }

    @Step("Validate Max HR")
    protected void validateMaxHR(BaseWorkout workout) {
        assertEquals(driver.findElement(MAX_HR).getAttribute("value"), String.valueOf(workout.getMaxHR()));
    }

    @Step("Validate Calories Burned")
    protected void validateCaloriesBurned(BaseWorkout workout) {
        assertEquals(driver.findElement(CALORIES_BURNED).getAttribute("value"), String.valueOf(workout.getCaloriesBurned()));
    }

    @Step("Validate Avg Power")
    protected void validateAvgPower(BaseWorkout workout) {
        assertEquals(driver.findElement(AVG_POWER).getAttribute("value"), String.valueOf(workout.getAvgPower()));
    }

    @Step("Validate Max Power")
    protected void validateMaxPower(BaseWorkout workout) {
        assertEquals(driver.findElement(MAX_POWER).getAttribute("value"), String.valueOf(workout.getMaxPower()));
    }

    @Step("Validate Avg Cadence")
    protected void validateAvgCadence(BaseWorkout workout) {
        assertEquals(driver.findElement(AVG_CADENCE).getAttribute("value"), String.valueOf(workout.getAvgCadence()));
    }

    @Step("Validate Max Cadence")
    protected void validateMaxCadence(BaseWorkout workout) {
        assertEquals(driver.findElement(MAX_CADENCE).getAttribute("value"), String.valueOf(workout.getMaxCadence()));
    }

    @Step("Validate Elevation Gain Type")
    protected void validateElevationGainType(BaseWorkout workout) {
        assertEquals(getSelectedOption("EGainDistType"), workout.getElevationGainType());
    }

    @Step("Validate Elevation Gain")
    protected void validateElevationGain(BaseWorkout workout) {
        String elevationGain = driver.findElement(ELEVATION_GAIN).getAttribute("value");
        assertEquals(elevationGain.substring(0, elevationGain.indexOf(".")), valueOf(workout.getElevationGain()));
    }

    @Step("Validate Elevation Loss Type")
    protected void validateElevationLossType(BaseWorkout workout) {
        assertEquals(getSelectedOption("ELossDistType"), workout.getElevationLossType());
    }

    @Step("Validate Elevation Loss")
    protected void validateElevationLoss(BaseWorkout workout) {
        String elevationLoss = driver.findElement(ELEVATION_LOSS).getAttribute("value");
        assertEquals(elevationLoss.substring(0, elevationLoss.indexOf(".")), valueOf(workout.getElevationLoss()));
    }

    @Step("Select SubType: (workout.)")
    protected void selectSubType(BaseWorkout workout) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(format(SUBTYPE, workout.getSubType()))));
        driver.findElement(By.xpath(format(SUBTYPE, workout.getSubType()))).click();

    }

    @Step("Fill AvgPower: (workout.avgPower)")
    protected void fillAvgPower(BaseWorkout workout) {
        driver.findElement(AVG_POWER).clear();
        driver.findElement(AVG_POWER).sendKeys(valueOf(workout.getAvgPower()));

    }

    @Step("Fill Max Power: (workout.maxPower)")
    protected void fillMaxPower(BaseWorkout workout) {
        driver.findElement(MAX_POWER).clear();
        driver.findElement(MAX_POWER).sendKeys(valueOf(workout.getMaxPower()));
    }

    @Step("Fill Avg Cadence: (workout.avgCadence)")
    protected void fillAvgCadence(BaseWorkout workout) {
        driver.findElement(AVG_CADENCE).clear();
        driver.findElement(AVG_CADENCE).sendKeys(valueOf(workout.getAvgCadence()));
    }

    @Step("Fill Defaults Fields)")
    protected void fillDefaults(BaseWorkout workout) {
        fillDate(workout);
        fillWorkoutName(workout);
        fillDescription(workout);
    }

    @Step("Fill Activity Type: {workout.activityType}")
    protected void fillActivityTypeByIndex(BaseWorkout workout) {
        Select select = new Select(driver.findElement(ACTIVITY_TYPE));
        select.selectByIndex(workout.getActivityType());

    }

    public void selectOption(WebElement element, String option) {
        Select select = new Select(element);
        select.selectByVisibleText(option);
    }

    @Step("Fill Max Cadence: {workout.maxCadence}")
    protected void fillMaxCadence(BaseWorkout workout) {
        driver.findElement(MAX_CADENCE).clear();
        driver.findElement(MAX_CADENCE).sendKeys(valueOf(workout.getMaxCadence()));
    }

    @Step("Fill Elevation Gain: {workout.elevationGain}")
    protected void fillElevationGain(BaseWorkout workout) {
        driver.findElement(ELEVATION_GAIN).clear();
        driver.findElement(ELEVATION_GAIN).sendKeys(valueOf(workout.getElevationGain()));
    }

    @Step("Fill Elevation Gain Type: {workout.elevationGainType}")
    protected void fillElevationGainType(BaseWorkout workout) {
        selectOption(driver.findElement(ELEVATION_GAIN_TYPE), workout.getElevationGainType());

    }

    @Step("Fill Elevation Loss: {workout.elevationLoss}")
    protected void fillElevationLoss(BaseWorkout workout) {
        driver.findElement(ELEVATION_LOSS).clear();
        driver.findElement(ELEVATION_LOSS).sendKeys(valueOf(workout.getElevationLoss()));
    }

    @Step("Fill Elevation Loss Type: {workout.elevationLossType}")
    protected void fillElevationLossType(BaseWorkout baseWorkout) {
        selectOption(driver.findElement(ELEVATION_LOSS_TYPE), baseWorkout.getElevationLossType());
    }

    @Step("Fill Date: {workout.date}")
    protected void fillDate(BaseWorkout workout) {
        driver.findElement(DATE).clear();
        driver.findElement(DATE).sendKeys(workout.getDate());

    }

    @Step("Fill Time Of Day:{workout.timeOfDay}")
    protected void fillTimeOfDay(BaseWorkout workout) {
        driver.findElement(TIME_OF_DAY).clear();
        driver.findElement(TIME_OF_DAY).sendKeys(workout.getTimeOfDay());
    }

    @Step("Fill Workout Name:{workout.workoutName}")
    protected void fillWorkoutName(BaseWorkout workout) {
        driver.findElement(WORKOUT_NAME).clear();
        driver.findElement(WORKOUT_NAME).sendKeys(workout.getWorkoutName());
    }

    @Step("Fill Description: {workout.description}")
    protected void fillDescription(BaseWorkout workout) {
        driver.findElement(DESCRIPTION).clear();
        driver.findElement(DESCRIPTION).sendKeys(workout.getDescription());
    }

    @Step("Fill Duration: {workout.duration}")
    protected void fillDuration(BaseWorkout workout) {
        driver.findElement(DURATION).clear();
        driver.findElement(DURATION).sendKeys(workout.getDuration());
    }

    @Step("Fill Distance: {workout.distance}")
    protected void fillDistance(BaseWorkout workout) {
        driver.findElement(DISTANCE).clear();
        driver.findElement(DISTANCE).sendKeys(workout.getDistance() + "");
    }

    @Step("Fill Distance Type: {workout.distanceType}")
    protected void fillDistanceType(BaseWorkout workout) {
        selectOption(driver.findElement(DISTANCE_TYPE), workout.getDistanceType());
    }

    @Step("Fill Pace Type: {workout.paceType}")
    protected void fillPaceType(BaseWorkout workout) {
        selectOption(driver.findElement(PACE_TYPE), workout.getPaceType());
    }

    @Step("Fill How I Felt: {workout.feel}")
    protected void fillHowIFelt(BaseWorkout workout) {
        selectOption(driver.findElement(HOW_I_FELT), workout.getFeel());
    }

    @Step("Fill Post Workout : {workout.postWorkout}")
    protected void fillPostWorkout(BaseWorkout workout) {
        driver.findElement(POST_WORKOUT).clear();
        driver.findElement(POST_WORKOUT).sendKeys(workout.getPostWorkout());
    }

    @Step("Fill Feel: {workout.feel}")
    protected void fillFeel(BaseWorkout workout) {
        driver.findElement(By.xpath(format(FEEL, workout.getFeel()))).click();
    }

    @Step("Fill Perceived Effort : {workout.perceivedEffort}")
    protected void fillPerceivedEffort(BaseWorkout workout) {
        selectOption(driver.findElement(PERCEIVED_EFFORT), workout.getPerceivedEffort());
    }

    @Step("Fill Min HR : {workout.minHR}")
    protected void fillMinHR(BaseWorkout workout) {
        driver.findElement(MIN_HR).clear();
        driver.findElement(MIN_HR).sendKeys(String.valueOf(workout.getMinHR()));
    }

    @Step("Fill Avg HR : {workout.avgHR}")
    protected void fillAvgHR(BaseWorkout workout) {
        driver.findElement(AVG_HR).clear();
        driver.findElement(AVG_HR).sendKeys(String.valueOf(workout.getAvgHR()));
    }

    @Step("Fill Max HR: {workout.maxHR} ")
    protected void fillMaxHR(BaseWorkout workout) {
        driver.findElement(MAX_HR).clear();
        driver.findElement(MAX_HR).sendKeys(String.valueOf(workout.getMaxHR()));
    }

    @Step("Fill Calories Burned: {workout.caloriesBurned}")
    protected void fillCaloriesBurned(BaseWorkout workout) {
        driver.findElement(CALORIES_BURNED).clear();
        driver.findElement(CALORIES_BURNED).sendKeys(String.valueOf(workout.getCaloriesBurned()));
    }


}

