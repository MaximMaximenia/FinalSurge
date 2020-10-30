package tests;

import io.qameta.allure.Description;
import models.workouts.BaseWorkout;
import org.testng.annotations.Test;

public class PrintWorkoutsTest extends BaseTest {
    String startDate = "10/10/2020";
    String endDate = "10/12/2020";
    BaseWorkout swim = BaseWorkout.builder().subType("Drills").date("10/11/2020").timeOfDay("05:45 AM").workoutName("SwimWorkout").description("went to the pools").distanceType("m").distance(15).duration("25:00").paceType("kph").feel("Poor").perceivedEffort("3 (Light)").caloriesBurned(1232).build();
    BaseWorkout swim2 = BaseWorkout.builder().subType("Drills").date("10/11/2020").timeOfDay("06:45 AM").workoutName("SwimWorkout").description("went to the pools").distanceType("m").distance(15).duration("25:00").paceType("kph").feel("Poor").perceivedEffort("3 (Light)").caloriesBurned(1232).build();
    @Description("Print workout test")
    @Test
    public void printWorkoutTest() {
        loginSteps
                .login("masya@mail.ru", "1234321MAks__", false)
                .toWorkoutPage()
                .fillWorkout("Swim", swim)
                .clickAddWorkout();
        printFrame
                .openPrintFrame()
                .fillFrame(startDate, endDate, true)
                .clickPrintButton()
                .switchToLastPage()
                .validatePrintDateAndURL(startDate, endDate, "https://log.finalsurge.com/PrintWorkouts.cshtml");
        calendarSteps
                .deleteFromTo(startDate, endDate);

    }
    @Description("Print some workout test")
    @Test
    public void printSomeWorkoutTest() {
        loginSteps
                .login("masya@mail.ru", "1234321MAks__", false)
                .toWorkoutPage()
                .fillWorkout("Swim", swim)
                .clickAddWorkout()
                .toWorkoutPage()
                .fillWorkout("Swim", swim2)
                .clickAddWorkout();
        printFrame
                .openPrintFrame()
                .fillFrame(startDate, endDate, true)
                .clickPrintButton()
                .switchToLastPage()
                .amountWorkoutsShouldBe(2);


        calendarSteps
                .deleteFromTo(startDate, endDate);

    }
    @Description("Check print error")
    @Test
    public void checkPrintError() {
        loginSteps
                .login("masya@mail.ru", "1234321MAks__", false);
        printFrame
                .openPrintFrame()
                .fillFrame(startDate, endDate, true)
                .clickPrintButton()
                .switchToLastPage()
                .printErrorShouldBe("×\n" +
                        "Please fix the following errors:\n" +
                        "*The date range you have selected does not contain any workouts. Please close this browser window and adjust your date range.");


    }
}
