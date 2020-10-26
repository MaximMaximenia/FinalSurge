package tests;

import models.workouts.BaseWorkout;
import org.testng.annotations.Test;

public class CalendarTest extends BaseTest {

    BaseWorkout swim = BaseWorkout.builder().date("7/26/2020").timeOfDay("06:00 AM").activityType(23).workoutName("SwimTraining").description("Swim training").distanceType("m").duration("00:22:22").distance(15).paceType("kph").feel("Good").perceivedEffort("5 (Moderate)").postWorkout("Just do it").build();
    BaseWorkout walk = BaseWorkout.builder().date("10/23/2020").timeOfDay("05:45 AM").workoutName("walk").description("walk").distanceType("m").distance(12).duration("25:00").paceType("kph").elevationGainType("ft").elevationGain(12).elevationLossType("m").elevationLoss(12).feel("Normal").perceivedEffort("5 (Moderate)").avgPower(12).maxPower(14).avgCadence(70).maxCadence(90).minHR(12).avgHR(15).maxHR(17).caloriesBurned(123).build();

    @Test
    public void fullAddFromCalendarTest() {
        loginSteps
                .login("masya@mail.ru", "1234321MAks__", false);
        calendarPage
                .openCalendarPage()
                .openCalendarMenuByDayAndSelectOptionInDropdown("20", "Full Add");
        workoutPage
                .fillWorkout("Walk", walk)
                .clickAddWorkout()
                .validateWorkout("Walk", walk);
    }
    @Test
    public void quickAddFromCalendarTest() {
        BaseWorkout walk = BaseWorkout.builder().date("10/23/2020").timeOfDay("05:45 AM").workoutName("walk").description("walk").distanceType("m").distance(12).duration("25:00").paceType("kph").elevationGainType("ft").elevationGain(12).elevationLossType("m").elevationLoss(12).feel("Normal").perceivedEffort("5 (Moderate)").avgPower(12).maxPower(14).avgCadence(70).maxCadence(90).minHR(12).avgHR(15).maxHR(17).caloriesBurned(123).build();
        loginSteps
                .login("masya@mail.ru", "1234321MAks__", false);
        calendarPage
                .openCalendarPage()
                .openCalendarMenuByDayAndSelectOptionInDropdown("20", "Quick Add");
        workoutPage.
                quickAddWorkout(swim);
    }
}