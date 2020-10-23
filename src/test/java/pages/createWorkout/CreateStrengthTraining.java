package pages.createWorkout;

import models.workouts.StrengthTraining;
import org.openqa.selenium.WebDriver;

public class CreateStrengthTraining extends CreateBaseWorkout {
    public CreateStrengthTraining(WebDriver driver) {
        super(driver);
    }

    public void createStrengthTraining(StrengthTraining workout) {
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
}
