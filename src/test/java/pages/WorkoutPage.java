package pages;

import models.workouts.BaseWorkout;
import org.openqa.selenium.WebDriver;
import pages.createWorkout.CreateBaseWorkout;
import pages.createWorkout.CreateWalkWorkout;

public class WorkoutPage extends CreateBaseWorkout {
    public WorkoutPage(WebDriver driver) {
        super(driver);
    }


    public void addWorkout(BaseWorkout baseWorkout, String subType) {

    }

}

