package pages.createWorkout;

import models.workouts.RestDay;
import org.openqa.selenium.WebDriver;

public class CreateRestDay extends CreateBaseWorkout {

    public CreateRestDay(WebDriver driver) {
        super(driver);
    }

    public void createRestRay(RestDay workout) {
        openDropdown("rest");
        fillDate(workout);
        fillWorkoutName(workout);
        fillDescription(workout);
        clickAddWorkout();
    }
}
