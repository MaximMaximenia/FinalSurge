package pages;

import models.workouts.BaseWorkout;
import org.openqa.selenium.WebDriver;

public class WorkoutPage extends BasePage {
    public WorkoutPage(WebDriver driver) {
        super(driver);
    }

    public void addWorkout(BaseWorkout baseWorkout, String subType) {

        baseWorkout.openDropDown();
        baseWorkout.fillAllFields(baseWorkout, subType);
        baseWorkout.clickAddWorkout();
    }

}
