package pages.createWorkout;

import models.workouts.BaseWorkout;
import org.openqa.selenium.WebDriver;

public class CreateRecoveryRehab extends CreateBaseWorkout {
    public CreateRecoveryRehab(WebDriver driver) {
        super(driver);
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
}
