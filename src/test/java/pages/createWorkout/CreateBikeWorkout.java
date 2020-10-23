package pages.createWorkout;

import models.workouts.BaseWorkout;
import org.openqa.selenium.WebDriver;

public class CreateBikeWorkout extends CreateBaseWorkout {

    public CreateBikeWorkout(WebDriver driver) {
        super(driver);
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

}





/*

    @Override
    public BaseWorkout fillAllFields(BaseWorkout workout) {
        openDropDown();
        selectSubType(workout);
        fillDefaults(workout);
        fillThisClassFields(workout);
        return new BaseWorkout();

    }

    @Override
    public BaseWorkout openDropDown() {
        driver.findElement(BIKE_DROP_DOWN).click();
        return new BaseWorkout();
    }
}
*/
