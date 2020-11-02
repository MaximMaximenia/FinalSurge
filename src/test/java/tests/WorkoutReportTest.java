package tests;

import io.qameta.allure.Description;
import models.workouts.BaseWorkout;
import org.testng.annotations.Test;

public class WorkoutReportTest extends BaseTest {

    BaseWorkout swim = BaseWorkout.builder().subType("Drills").date("11/23/2020").timeOfDay("05:45 AM").workoutName("SwimWorkout").description("went to the pools").distanceType("m").distance(15).duration("25:00").paceType("kph").feel("Poor").perceivedEffort("3 (Light)").caloriesBurned(1232).build();
    BaseWorkout bike = BaseWorkout.builder().subType("Intervals").date("11/23/2020").timeOfDay("05:45 AM").workoutName("BikeWorkout").description("Ride a bike to work").distanceType("m").distance(12).duration("25:00").paceType("kph").elevationGainType("ft").elevationGain(12).elevationLossType("m").elevationLoss(12).feel("Normal").perceivedEffort("5 (Moderate)").avgPower(12).maxPower(14).avgCadence(70).maxCadence(90).minHR(12).avgHR(15).maxHR(17).caloriesBurned(123).build();

    @Description("Workout report test ")
    @Test
    public void workoutReportTest() {
        loginSteps
                .login("masya@mail.ru", "1234321MAks__", false);

        workoutPage
                .toWorkoutPage()
                .fillWorkout("Swim", swim)
                .clickAddWorkout();
        workoutPage
                .toWorkoutPage()
                .fillWorkout("Bike", bike)
                .clickAddWorkout();
        workoutReportPage
                .toWorkoutReportPage()
                .fillDatesAndActivityType("11/23/2020", "11/23/2020", "Select...")
                .clickViewReportButton()
                .amountWorkoutsShouldBe(2);
        calendarSteps
                .deleteFromTo("11/23/2020", "11/23/2020");

    }

    @Description("Empty workout report test")
    @Test
    public void workoutReportsEmptyTest() {
        loginSteps
                .login("masya@mail.ru", "1234321MAks__", false);

        workoutReportPage
                .toWorkoutReportPage()
                .fillDatesAndActivityType("11/23/2020", "11/23/2020", "Select...")
                .clickViewReportButton()
                .amountWorkoutsShouldBe(0);


    }
    @Description("Check activity type select ")
    @Test
    public void workoutReportsWithActivityTypeTest() {
        loginSteps
                .login("masya@mail.ru", "1234321MAks__", false);
        workoutPage
                .toWorkoutPage()
                .fillWorkout("Swim", swim)
                .clickAddWorkout();
        workoutPage
                .toWorkoutPage()
                .fillWorkout("Bike", bike)
                .clickAddWorkout();
        workoutReportPage
                .toWorkoutReportPage()
                .fillDatesAndActivityType("11/23/2020", "11/23/2020", "Swim")
                .clickViewReportButton()
                .amountWorkoutsShouldBe(1);
        calendarSteps
                .deleteFromTo("11/23/2020", "11/23/2020");

    }
}
