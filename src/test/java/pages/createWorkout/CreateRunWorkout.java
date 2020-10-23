package pages.createWorkout;

import models.workouts.Run;
import org.openqa.selenium.WebDriver;

public class CreateRunWorkout extends CreateBaseWorkout{
    public CreateRunWorkout(WebDriver driver) {
        super(driver);
    }

    public void createRunWorkout(Run workout){
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
}
