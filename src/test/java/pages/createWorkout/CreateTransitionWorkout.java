package pages.createWorkout;

import models.workouts.BaseWorkout;
import org.openqa.selenium.WebDriver;

public class CreateTransitionWorkout extends CreateBaseWorkout{
    public CreateTransitionWorkout(WebDriver driver) {
        super(driver);
    }
    public void createTransitionWorkout(BaseWorkout workout){
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
