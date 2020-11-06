package tests;

import io.qameta.allure.Description;
import models.workouts.BaseWorkout;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalendarTest extends BaseTest {

    BaseWorkout swim = BaseWorkout.builder().date("11/12/2020").timeOfDay("06:00 AM").activityType(23).workoutName("SwimTraining").description("Swim training").distanceType("m").duration("00:22:22").distance(15).paceType("kph").feel("Good").perceivedEffort("5 (Moderate)").postWorkout("Just do it").build();
    BaseWorkout run = BaseWorkout.builder().date("11/12/2020").timeOfDay("06:00 AM").activityType(3).workoutName("RunTraining").description("Run training").distanceType("m").duration("00:22:22").distance(15).paceType("kph").feel("Good").perceivedEffort("5 (Moderate)").postWorkout("Just do it").build();
    BaseWorkout walk = BaseWorkout.builder().date("11/12/2020").timeOfDay("05:45 AM").workoutName("walk").description("walk").distanceType("m").distance(12).duration("25:00").paceType("kph").elevationGainType("ft").elevationGain(12).elevationLossType("m").elevationLoss(12).feel("Normal").perceivedEffort("5 (Moderate)").avgPower(12).maxPower(14).avgCadence(70).maxCadence(90).minHR(12).avgHR(15).maxHR(17).caloriesBurned(123).build();

    @DataProvider(name = "Month")
    public Object[][] textAboutCompany() {
        return new Object[][]{
                {"January"}, {"February"}, {"March"}, {"April"}, {"May"}, {"June"}, {"July"}, {"August"}, {"September"}, {"October"}, {"November"}, {"December"},
        };
    }

    @Description("Full add workout from calendar test")
    @Test(priority = 1)
    public void fullAddFromCalendarTest() {
        loginSteps
                .login("masya@mail.ru", "1234321MAks__", false);
        calendarPage
                .openCalendarPage()
                .openCalendarMenuByDayAndSelectOptionInDropdown(20, "Full Add");
        workoutPage
                .fillWorkout("Walk", walk)
                .clickAddWorkout()
                .validateWorkout("Walk", walk);
        calendarPage
                .amountWorkoutsShouldBe(1);

        calendarSteps
                .deleteFromTo("11/10/2020", "11/15/2020");
    }

    @Description("Quick add workout from calendar test")
    @Test(priority = 1)
    public void quickAddFromCalendarTest() {
        loginSteps
                .login("masya@mail.ru", "1234321MAks__", false);
        calendarPage
                .openCalendarPage()
                .openCalendarMenuByDayAndSelectOptionInDropdown(20, "Quick Add");
        workoutPage.
                quickAddWorkout(swim);
        calendarPage
                .amountWorkoutsShouldBe(1);
        calendarSteps
                .deleteFromTo("10/26/2020", "10/26/2020");

    }

    @Description("Delete one workout")
    @Test(priority = 1)
    public void deleteOneWorkout() {
        loginSteps
                .login("masya@mail.ru", "1234321MAks__", false);
        calendarPage
                .openCalendarPage()
                .openCalendarMenuByDayAndSelectOptionInDropdown(26, "Quick Add");
        workoutPage
                .quickAddWorkout(swim);
        calendarPage
                .amountWorkoutsShouldBe(1);
        calendarSteps
                .deleteFromTo("10/26/2020", "10/26/2020");
        calendarPage
                .amountWorkoutsShouldBe(0);

    }

    @Description("Delete from date to date ")
    @Test(priority = 1)
    public void deleteFromToTest() {
        loginSteps
                .login("masya@mail.ru", "1234321MAks__", false);

        calendarPage
                .openCalendarPage()
                .openCalendarMenuByDayAndSelectOptionInDropdown(26, "Quick Add");
        workoutPage
                .quickAddWorkout(run);
        calendarPage
                .amountWorkoutsShouldBe(1);
        calendarPage
                .openCalendarPage()
                .openCalendarMenuByDayAndSelectOptionInDropdown(26, "Quick Add");
        workoutPage.
                quickAddWorkout(swim);
        calendarPage
                .amountWorkoutsShouldBe(2);
        calendarSteps
                .deleteFromTo("10/26/2020", "10/26/2020");
        calendarPage
                .amountWorkoutsShouldBe(0);
    }

    @Description("Check month")
    @Test(dataProvider = "Month")
    public void monthTest(String month) {
        loginSteps
                .login("masya@mail.ru", "1234321MAks__", false);

        calendarPage
                .openCalendarPage()
                .selectMonth(month);
    }
}
