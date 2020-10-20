package steps;

import modal.workouts.BaseWorkout;
import org.openqa.selenium.WebDriver;

public class WorkoutSteps extends BaseSteps {

    public WorkoutSteps(WebDriver driver) {
        super(driver);
    }

    public void createWorkout(BaseWorkout baseWorkout) {
        baseWorkout
                .openDropDown()
                .fillAllFields(baseWorkout)
                .clickAddWorkout();

    }
}
