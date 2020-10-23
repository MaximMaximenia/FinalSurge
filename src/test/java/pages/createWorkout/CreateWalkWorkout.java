package pages.createWorkout;

import models.workouts.Swim;
import models.workouts.Walk;
import org.openqa.selenium.WebDriver;

public class CreateWalkWorkout extends CreateBaseWorkout{

    public CreateWalkWorkout(WebDriver driver) {
        super(driver);
    }

    public void createWalkWorkout(Walk workout){
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
}
