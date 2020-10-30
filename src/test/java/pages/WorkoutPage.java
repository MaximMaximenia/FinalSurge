package pages;

import io.qameta.allure.Step;
import models.workouts.BaseWorkout;
import models.workouts.CreateAndValidateBaseWorkout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class WorkoutPage extends CreateAndValidateBaseWorkout {
    public WorkoutPage(WebDriver driver) {
        super(driver);
    }

    private static final By TO_UPDATE_WORKOUT = By.cssSelector(".dropdown-toggle");
    private static final By ADD_WORKOUT_BUTTON = By.cssSelector("#saveButton");
    private static final By UPDATE_WORKOUT_BUTTON = By.cssSelector("[name='btnSubmit']");

    @Step("Fill workout({workoutType}) fields")
    public WorkoutPage fillWorkout(String workoutType, BaseWorkout workout) {
        Map<String, String> workoutsDropDown = new HashMap<>();
        workoutsDropDown.put("Run", "run");
        workoutsDropDown.put("Bike", "bike");
        workoutsDropDown.put("Swim", "swim");
        workoutsDropDown.put("Cross Training", "cross-trai");
        workoutsDropDown.put("Walk", "walk");
        workoutsDropDown.put("Rest Day", "rest");
        workoutsDropDown.put("Strength Training", "strength-t");
        workoutsDropDown.put("Recovery/Rehab", "recovery");
        workoutsDropDown.put("Other", "other");
        workoutsDropDown.put("Transition", "trans");
        openDropdown(workoutsDropDown.get(workoutType));

        if (!workoutType.equals("Cross Training") & !workoutType.equals("Strength Training")) {

            fillDefaults(workout);
            if (workout.getSubType() != null) {
                selectSubType(workout);
            }
            if (workout.getTimeOfDay() != null) {
                fillTimeOfDay(workout);
            }
            if (workout.getDistanceType() != null) {
                fillDistanceType(workout);
            }
            if (workout.getDistance() != 0) {
                fillDistance(workout);
            }
            if (workout.getPaceType() != null) {
                fillPaceType(workout);
            }
            if (workout.getDuration() != null) {
                fillDuration(workout);
            }
            if (workout.getElevationGainType() != null) {
                fillElevationGainType(workout);
                fillElevationGain(workout);
                fillElevationLossType(workout);
                fillElevationLoss(workout);
            }
            if (workout.getFeel() != null) {
                fillFeel(workout);
            }
            if (workout.getPerceivedEffort() != null) {
                fillPerceivedEffort(workout);
            }
            if (workout.getAvgPower() != 0) {
                fillAvgPower(workout);
                fillMaxPower(workout);
                fillAvgCadence(workout);
                fillMaxCadence(workout);
            }
            if (workout.getMinHR() != 0) {
                fillMinHR(workout);
                fillMaxHR(workout);
                fillAvgHR(workout);
                fillCaloriesBurned(workout);
            }
        } else if (workoutType.equals("Strength Training")) {
            createStrengthTraining(workout);
        } else {
            createCrossTraining(workout);
        }

        return this;
    }

    @Step("Validate workout({workoutType}) fields")
    public WorkoutPage validateWorkout(String workoutType, BaseWorkout workout) {
        toUpdateWorkout();

        if (!workoutType.equals("Cross Training") & !workoutType.equals("Strength Training")) {
            validateDefaults(workout);
            if (workout.getTimeOfDay() != null) {
                validateTimeOfDay(workout);
            }
            if (workout.getSubType() != null) {
                validateSubType(workout);
            }
            if (workout.getDistanceType() != null) {
                validateDistanceType(workout);
            }
            if (workout.getDistance() != 0) {
                validateDistance(workout);
            }
            if (workout.getDuration() != null) {
                validateDuration(workout);
            }
            if (workout.getPaceType() != null) {
                validatePaceType(workout);
            }
            if (workout.getPace() != null) {
                validatePace(workout);
            }
            if (workout.getFeel() != null) {
                validateFeel(workout);
            }
            if (workout.getPerceivedEffort() != null) {
                validatePerceivedEffort(workout);
            }
            if (workout.getMinHR() != 0) {
                validateMinHR(workout);
                validateAvgHR(workout);
                validateMaxHR(workout);
                validateCaloriesBurned(workout);
            }
            if (workout.getAvgPower() != 0) {
                validateAvgPower(workout);
                validateMaxPower(workout);
                validateMaxCadence(workout);
                validateAvgCadence(workout);
            }
            if (workout.getElevationGainType() != null) {
                validateElevationGainType(workout);
                validateElevationGain(workout);
                validateElevationLossType(workout);
                validateElevationLoss(workout);
            }
        } else if (workoutType.equals("Strength Training")) {
            validateStrengthTraining(workout);
        } else {
            validateCrossTraining(workout);
        }
        return this;
    }

    @Step("Open update workout page")
    public WorkoutPage toUpdateWorkout() {
        driver.findElement(TO_UPDATE_WORKOUT).click();
        return this;
    }
    @Step("Fill updated workout")
    public WorkoutPage updateWorkoutTo(String type, BaseWorkout workout) {
        fillWorkout(type, workout);
        return this;
    }
    @Step("Click update workout button")
    public WorkoutPage clickUpdateWorkout() {
        driver.findElement(UPDATE_WORKOUT_BUTTON).click();
        return this;
    }
    @Step("Click add workout")
    public WorkoutPage clickAddWorkout() {
        driver.findElement(ADD_WORKOUT_BUTTON).click();
        return this;
    }
    @Step("Quick add workout")
    public WorkoutPage quickAddWorkout(BaseWorkout workout) {
        fillDefaults(workout);
        fillTimeOfDay(workout);
        fillActivityTypeByIndex(workout);
        fillDistanceType(workout);
        fillDistance(workout);
        fillDuration(workout);
        fillPaceType(workout);
        fillHowIFelt(workout);
        fillPerceivedEffort(workout);
        fillPostWorkout(workout);
        clickAddWorkout();
        return this;
    }

}

