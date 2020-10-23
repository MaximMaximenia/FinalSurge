package pages.createWorkout;

import models.workouts.BaseWorkout;
import org.openqa.selenium.WebDriver;

public class CreateOtherWorkout extends CreateBaseWorkout {
    public CreateOtherWorkout(WebDriver driver) {
        super(driver);
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
}
