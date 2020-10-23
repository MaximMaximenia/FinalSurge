package pages.createWorkout;

import models.workouts.Swim;
import org.openqa.selenium.WebDriver;

public class CreateSwimWorkout extends CreateBaseWorkout {
    public CreateSwimWorkout(WebDriver driver) {
        super(driver);
    }

    public void createSwimWorkout(Swim workout) {
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
}
