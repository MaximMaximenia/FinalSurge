package pages.createWorkout;

import models.workouts.CrossTraining;
import models.workouts.Run;
import org.openqa.selenium.WebDriver;

public class CreateCrossTraining extends CreateBaseWorkout{
    public CreateCrossTraining(WebDriver driver) {
        super(driver);
    }

    public void createCrossTraining(CrossTraining workout){
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
}
