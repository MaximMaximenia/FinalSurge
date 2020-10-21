package modal.workouts;

import org.openqa.selenium.WebDriver;

public class Run extends BaseWorkout{
    public Run(WebDriver driver, String date, String timeOfDay, String workoutName, String description, String duration, int distance,String distanceType, String feel) {
        super(driver, date, timeOfDay, workoutName, description, duration, distance,distanceType, feel);
    }

    @Override
    public BaseWorkout fillAllFields(BaseWorkout workout, String subtype) {
        return null;
    }

    @Override
    public BaseWorkout openDropDown() {
        return null;
    }
}
