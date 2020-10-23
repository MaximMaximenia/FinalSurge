package tests;


import models.workouts.BaseWorkout;
import models.workouts.Bike;
import org.testng.annotations.Test;
import pages.createWorkout.CreateBaseWorkout;

public class WorkoutTest extends BaseTest {


    @Test
    public void addBikeWorkout() {
        BaseWorkout bike = BaseWorkout.builder()
                .subType("Intervals")
                .date("10/23/2020")
                .timeOfDay("05:45 AM")
                .workoutName("BikeWorkout")
                .description("Ride a bike to work")
                .distanceType("m")
                .distance(12)
                .duration("00:25:00")
                .paceType("min/km")
                .pace("2:21")
                .elevationGainType("ft")
                .elevationGain(12)
                .elevationLossType("m")
                .elevationLoss(12)
                .feel("Normal")
                .perceivedEffort("5 (Moderate)")
                .avgPower(12)
                .maxPower(14)
                .avgCadence(70)
                .maxCadence(90)
                .minHR(12)
                .avgHR(15)
                .maxHR(17)
                .caloriesBurned(123)
                .build();


        loginSteps
                .login("masya@mail.ru", "1234321MAks__", false)
                .toWorkoutPage();
        createBikeWorkout
                .createBikeWorkout(bike);

    }

    @Test
    public void addFullWorkoutIntoCalendar() {


        loginSteps
                .login("masya@mail.ru", "1234321MAks__", false);

        calendarPage
                .clickFullAddWorkoutByDay("6");

    }

    @Test
    public void addQuickWorkoutIntoCalendar() {
        Bike bike = (Bike) Bike.builder().date("s").build();
        new CreateBaseWorkout(driver).fillAvgHR(bike);
    }


}



