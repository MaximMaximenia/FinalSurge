package pages;

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
        } else if (workoutType.equals("Strength Training")) {
            createStrengthTraining(workout);
        } else {
            createCrossTraining(workout);
        }


        clickAddWorkout();

        return this;
    }

    public void validateWorkout(String workoutType, BaseWorkout workout) {
        clickUpdateWorkout();

        if (!workoutType.equals("Cross Training") & !workoutType.equals("Strength Training")) {
            validateDate(workout);
            validateWorkoutName(workout);
            validateWorkoutDescription(workout);

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
            }
            if (workout.getAvgHR() != 0) {
                validateAvgHR(workout);
            }
            if (workout.getMaxHR() != 0) {
                validateMaxHR(workout);
            }
            if (workout.getCaloriesBurned() != 0) {
                validateCaloriesBurned(workout);
            }
            if (workout.getAvgPower() != 0) {
                validateAvgPower(workout);
            }
            if (workout.getMaxPower() != 0) {
                validateMaxPower(workout);
            }
            if (workout.getMaxCadence() != 0) {
                validateMaxCadence(workout);
            }
            if (workout.getAvgCadence() != 0) {
                validateAvgCadence(workout);
            }
            if (workout.getElevationGainType() != null) {
                validateElevationGainType(workout);
            }
            if (workout.getElevationGain() != 0) {
                validateElevationGain(workout);
            }
            if (workout.getElevationLossType() != null) {
                validateElevationLossType(workout);
            }
            if (workout.getElevationLoss() != 0) {
                validateElevationLoss(workout);
            }
        } else if (workoutType.equals("Strength Training")) {
            validateStrengthTraining(workout);
        } else {
            validateCrossTraining(workout);
        }
    }


    public WorkoutPage clickUpdateWorkout() {
        driver.findElement(UPDATE_WORKOUT).click();
        return this;
    }

}

