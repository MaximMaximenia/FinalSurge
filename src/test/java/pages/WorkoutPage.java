package pages;

import models.workouts.BaseWorkout;
import models.workouts.CreateBaseWorkout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class WorkoutPage extends CreateBaseWorkout {
    public WorkoutPage(WebDriver driver) {
        super(driver);
    }

    private static final By UPDATE_WORKOUT = By.cssSelector(".dropdown-toggle");


    public WorkoutPage createWorkout(String workoutType, BaseWorkout workout) {
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
        if (workout.getSubType() != null) {
            selectSubType(workout);
        }
        fillDate(workout);
        fillTimeOfDay(workout);
        fillWorkoutName(workout);
        fillDescription(workout);
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
        }
        if (workout.getElevationGain() != 0) {
            fillElevationGain(workout);
        }
        if (workout.getElevationLossType() != null) {
            fillElevationLossType(workout);
        }
        if (workout.getElevationLoss() != 0) {
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
        }
        if (workout.getMaxPower() != 0) {
            fillMaxPower(workout);
        }
        if (workout.getAvgCadence() != 0) {
            fillAvgCadence(workout);
        }
        if (workout.getMaxCadence() != 0) {
            fillMaxCadence(workout);
        }
        if (workout.getMinHR() != 0) {
            fillMinHR(workout);
        }
        if (workout.getMaxHR() != 0) {
            fillMaxHR(workout);
        }
        if (workout.getAvgHR() != 0) {
            fillAvgHR(workout);
        }
        if (workout.getCaloriesBurned() != 0) {
            fillCaloriesBurned(workout);
        }

        clickAddWorkout();

        return this;


    }


    public void validateWorkout(BaseWorkout workout) {

        clickUpdateWorkout();
        //validate Date
        validateDate(workout);
        //validate TimeOfDay
        validateTimeOfDay(workout);
        //validate Workout Name
        validateWorkoutName(workout);
        //validate Desc
        validateWorkoutDescription(workout);
        //validate SubType
        if (workout.getSubType() != null) {
            validateSubType(workout);
        }
        //validate DistanceType
        if (workout.getDistanceType() != null) {
            validateDistanceType(workout);
        }
        //validate Distance
        if (workout.getDistance() != 0) {
            validateDistance(workout);
        }
        //validate duration
        if (workout.getDuration() != null) {
            validateDuration(workout);
        }
        //validate PaceType
        if (workout.getPaceType() != null) {
            validatePaceType(workout);
        }
        //validate Pace
        if (workout.getPace() != null) {
            validatePace(workout);
        }
        //validate Feel
        if (workout.getFeel() != null) {
            validateFeel(workout);
        }
        //validate Perceived Effort
        if (workout.getPerceivedEffort() != null) {
            validatePerceivedEffort(workout);
        }
        //validate MinHR
        if (workout.getMinHR() != 0) {
            validateMinHR(workout);
        }
        //validate AvgHR
        if (workout.getAvgHR() != 0) {
            validateAvgHR(workout);
        }
        //validate MaxHR
        if (workout.getMaxHR() != 0) {
            validateMaxHR(workout);
        }
        //validate CaloriesBurned
        if (workout.getCaloriesBurned() != 0) {
            validateCaloriesBurned(workout);
        }
        //validate Avg Power
        if (workout.getAvgPower() != 0) {
            validateAvgPower(workout);
        }
        //validate Max Power
        if (workout.getMaxPower() != 0) {
            validateMaxPower(workout);
        }
        //validate Max Cadence
        if (workout.getMaxCadence() != 0) {
            validateMaxCadence(workout);
        }
        //validate Avg Cadence
        if (workout.getAvgCadence() != 0) {
            validateAvgCadence(workout);
        }
        //validate ElevationGainType
        if (workout.getElevationGainType() != null) {
            validateElevationGainType(workout);
        }
        //validate ElevationGain
        if (workout.getElevationGain() != 0) {
            validateElevationGain(workout);
        }
        //validate ElevationLossType
        if (workout.getElevationLossType() != null) {
            validateElevationLossType(workout);
        }
        //validate ElevationLoss
        if (workout.getElevationLoss() != 0) {
            validateElevationLoss(workout);
        }
    }

    public WorkoutPage clickUpdateWorkout() {
        driver.findElement(UPDATE_WORKOUT).click();
        return this;
    }

}

