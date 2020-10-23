package pages;

import models.workouts.BaseWorkout;
import models.workouts.CreateBaseWorkout;
import org.openqa.selenium.WebDriver;

public class WorkoutPage extends CreateBaseWorkout {
    public WorkoutPage(WebDriver driver) {
        super(driver);
    }


    public void addWorkout(BaseWorkout baseWorkout, String subType) {

    }

    public void createWalkWorkout(BaseWorkout workout) {
        openDropdown("walk");
        fillDate(workout);
        fillTimeOfDay(workout);
        fillWorkoutName(workout);
        fillDescription(workout);
        fillDistanceType(workout);
        fillDistance(workout);
        fillPaceType(workout);
        fillPace(workout);
        fillDuration(workout);
        fillElevationGainType(workout);
        fillElevationGain(workout);
        fillElevationLossType(workout);
        fillElevationLoss(workout);
        fillFeel(workout);
        fillPerceivedEffort(workout);
        fillAvgPower(workout);
        fillMaxPower(workout);
        fillAvgCadence(workout);
        fillMaxCadence(workout);
        fillMinHR(workout);
        fillMaxHR(workout);
        fillAvgHR(workout);
        fillCaloriesBurned(workout);
        clickAddWorkout();
    }

    public void createBikeWorkout(BaseWorkout workout) {
        openDropdown("bike");
        selectSubType(workout);
        fillDate(workout);
        fillTimeOfDay(workout);
        fillWorkoutName(workout);
        fillDescription(workout);
        fillDistanceType(workout);
        fillDistance(workout);
        fillPaceType(workout);
        fillPace(workout);
        fillDuration(workout);
        fillElevationGainType(workout);
        fillElevationGain(workout);
        fillElevationLossType(workout);
        fillElevationLoss(workout);
        fillFeel(workout);
        fillPerceivedEffort(workout);
        fillAvgPower(workout);
        fillMaxPower(workout);
        fillAvgCadence(workout);
        fillMaxCadence(workout);
        fillMinHR(workout);
        fillMaxHR(workout);
        fillAvgHR(workout);
        fillCaloriesBurned(workout);
        clickAddWorkout();

    }

    public void createCrossTraining(BaseWorkout workout) {
        openDropdown("cross-trai");
        fillDate(workout);
        fillTimeOfDay(workout);
        fillWorkoutName(workout);
        fillDescription(workout);
        fillDistanceType(workout);
        fillDistance(workout);
        fillPaceType(workout);
        fillPace(workout);
        fillDuration(workout);
        fillFeel(workout);
        fillPerceivedEffort(workout);
        fillMinHR(workout);
        fillMaxHR(workout);
        fillAvgHR(workout);
        fillCaloriesBurned(workout);
        clickAddWorkout();
    }

    public void createOtherWorkout(BaseWorkout workout) {
        openDropdown("other");
        selectSubType(workout);
        fillDate(workout);
        fillTimeOfDay(workout);
        fillDescription(workout);
        fillWorkoutName(workout);
        clickAddWorkout();
    }

    public void createRecoveryRehab(BaseWorkout workout) {
        openDropdown("recovery");
        selectSubType(workout);
        fillDate(workout);
        fillTimeOfDay(workout);
        fillDescription(workout);
        fillWorkoutName(workout);
        clickAddWorkout();
    }

    public void createRestRay(BaseWorkout workout) {
        openDropdown("rest");
        fillDate(workout);
        fillWorkoutName(workout);
        fillDescription(workout);
        clickAddWorkout();
    }

    public void createRunWorkout(BaseWorkout workout) {
        openDropdown("run");
        selectSubType(workout);
        fillDate(workout);
        fillTimeOfDay(workout);
        fillWorkoutName(workout);
        fillDescription(workout);
        fillDistanceType(workout);
        fillDistance(workout);
        fillPaceType(workout);
        fillPace(workout);
        fillDuration(workout);
        fillFeel(workout);
        fillPerceivedEffort(workout);
        fillMinHR(workout);
        fillMaxHR(workout);
        fillAvgHR(workout);
        fillCaloriesBurned(workout);
        clickAddWorkout();
    }

    public void createStrengthTraining(BaseWorkout workout) {
        openDropdown("strength-t");
        fillDate(workout);
        fillTimeOfDay(workout);
        fillWorkoutName(workout);
        fillDescription(workout);
        fillDuration(workout);
        fillFeel(workout);
        fillPerceivedEffort(workout);
        clickAddWorkout();
    }

    public void createSwimWorkout(BaseWorkout workout) {
        openDropdown("swim");
        selectSubType(workout);
        fillDate(workout);
        fillTimeOfDay(workout);
        fillWorkoutName(workout);
        fillDescription(workout);
        fillDistanceType(workout);
        fillDistance(workout);
        fillPaceType(workout);
        fillPace(workout);
        fillDuration(workout);
        fillFeel(workout);
        fillPerceivedEffort(workout);
        fillCaloriesBurned(workout);
        clickAddWorkout();
    }

    public void createTransitionWorkout(BaseWorkout workout) {
        openDropdown("trans");
        fillDate(workout);
        fillTimeOfDay(workout);
        fillWorkoutName(workout);
        fillDescription(workout);
        fillDistanceType(workout);
        fillDistance(workout);
        fillPaceType(workout);
        fillPace(workout);
        fillDuration(workout);
        fillElevationGainType(workout);
        fillElevationGain(workout);
        fillElevationLossType(workout);
        fillElevationLoss(workout);
        fillFeel(workout);
        fillPerceivedEffort(workout);
        fillAvgPower(workout);
        fillMaxPower(workout);
        fillAvgCadence(workout);
        fillMaxCadence(workout);
        fillMinHR(workout);
        fillMaxHR(workout);
        fillAvgHR(workout);
        fillCaloriesBurned(workout);
        clickAddWorkout();
    }
}

