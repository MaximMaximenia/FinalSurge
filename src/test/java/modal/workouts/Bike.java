package modal.workouts;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

@Getter
public class  Bike extends BaseWorkout {
    private static final By PACE = By.cssSelector("#Pace");
    private static final By PACE_TYPE = By.cssSelector("#PaceType");
    private static final By PERCEIVED_EFFORT = By.cssSelector("#PerEffort");
    private static final By MIN_HR = By.cssSelector("#MinHR");
    private static final By AVG_HR = By.cssSelector("#AvgHR");
    private static final By MAX_HR = By.cssSelector("#MaxHR");
    private static final By CALORIES_BURNED = By.cssSelector("#kCal");
    private static final By BIKE_DROP_DOWN = By.cssSelector("[data-code='bike']");

    String pace;
    String paceType;
    String perceivedEffort;
    int minHR;
    int avgHR;
    int maxHR;
    int caloriesBurned;

    public Bike(WebDriver driver, String date, String timeOfDay,
                String workoutName, String description,
                String duration, String pace, String paceType, int distance,
                String distanceType,
                String feel, String perceivedEffort,
                int minHR, int avgHR, int maxHR, int caloriesBurned) {

        super(driver, date, timeOfDay, workoutName, description, duration, distance, distanceType, feel);
        this.pace = pace;
        this.minHR = minHR;
        this.avgHR = avgHR;
        this.maxHR = maxHR;
        this.caloriesBurned = caloriesBurned;
        this.perceivedEffort = perceivedEffort;
        this.paceType = paceType;

    }

    public void fillPaceType() {
        Select selectPaceType = new Select(driver.findElement(PACE_TYPE));
        selectPaceType.selectByIndex(1);
    }

    public void fillPace(Bike bike) {

        driver.findElement(PACE).clear();
        driver.findElement(PACE).sendKeys(bike.getPace());
    }

    public void fillPerceivedEffort(Bike bike) {
        Select select = new Select(driver.findElement(PERCEIVED_EFFORT));
        select.selectByVisibleText(bike.getPerceivedEffort());
    }

    public void fillMinHR(Bike bike) {
        String minHR = String.valueOf(bike.getMinHR());
        driver.findElement(MIN_HR).sendKeys(minHR);
    }

    public void fillAvgHR(Bike bike) {
        String avgHR = String.valueOf(bike.getAvgHR());
        driver.findElement(AVG_HR).sendKeys(avgHR);
    }

    public void fillMaxHR(Bike bike) {
        String maxHR = String.valueOf(bike.getMaxHR());
        driver.findElement(MAX_HR).sendKeys(maxHR);
    }

    public void fillCaloriesBurned(Bike bike) {
        String caloriesBurned = String.valueOf(bike.getCaloriesBurned());
        driver.findElement(CALORIES_BURNED).sendKeys(caloriesBurned);
    }


    public void fillThisClassFields(BaseWorkout bike) {
        fillPaceType();
        fillPace((Bike) bike);
        fillPerceivedEffort((Bike) bike);
        fillMinHR((Bike) bike);
        fillAvgHR((Bike) bike);
        fillMaxHR((Bike) bike);
        fillCaloriesBurned((Bike) bike);
    }


    @Override
    public Bike fillAllFields(BaseWorkout workout, String subtype) {
        selectSubType(subtype);
        fillDefaults(workout);
        fillThisClassFields(workout);
        return this;
    }

    @Override
    public Bike openDropDown() {
        driver.findElement(BIKE_DROP_DOWN).click();
        return this;
    }
}
