package steps;

import models.workouts.BaseWorkout;
import org.openqa.selenium.WebDriver;

public class WorkoutSteps extends BaseSteps {

    public WorkoutSteps(WebDriver driver) {
        super(driver);
    }

    public WorkoutSteps clickFullAddWorkoutByDay() {
        workoutPage
                .openCalendarPage()
                .clickFullAddWorkoutByDay("6");
        return this;
    }

    public void createWorkout(BaseWorkout baseWorkout, String subtype) {
        baseWorkout
                .openDropDown()
                .fillAllFields(baseWorkout, subtype)
                .clickAddWorkout();

    }
}
