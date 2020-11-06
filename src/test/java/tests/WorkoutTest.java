package tests;


import io.qameta.allure.Description;
import models.workouts.BaseWorkout;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.Retry;

public class WorkoutTest extends BaseTest {
    String date = "11/12/2020";
    BaseWorkout swim = BaseWorkout.builder().subType("Drills").date(date).timeOfDay("05:45 AM").workoutName("SwimWorkout").description("went to the pools").distanceType("m").distance(15).duration("25:00").paceType("kph").feel("Poor").perceivedEffort("3 (Light)").caloriesBurned(1232).build();
    BaseWorkout bike = BaseWorkout.builder().subType("Intervals").date(date).timeOfDay("05:45 AM").workoutName("BikeWorkout").description("Ride a bike to work").distanceType("m").distance(12).duration("25:00").paceType("kph").elevationGainType("ft").elevationGain(12).elevationLossType("m").elevationLoss(12).feel("Normal").perceivedEffort("5 (Moderate)").avgPower(12).maxPower(14).avgCadence(70).maxCadence(90).minHR(12).avgHR(15).maxHR(17).caloriesBurned(123).build();
    BaseWorkout run = BaseWorkout.builder().subType("Long Run").date(date).timeOfDay("05:45 AM").workoutName("run").description("run").distanceType("m").distance(12).duration("25:00").paceType("kph").feel("Good").perceivedEffort("5 (Moderate)").minHR(12).avgHR(15).maxHR(17).caloriesBurned(123).build();
    BaseWorkout crossTraining = BaseWorkout.builder().date(date).timeOfDay("05:45 AM").workoutName("cross training").description("cross training").distanceType("m").distance(12).duration("25:00").paceType("kph").feel("Terrible").perceivedEffort("5 (Moderate)").minHR(12).avgHR(15).maxHR(17).caloriesBurned(123).build();
    BaseWorkout walk = BaseWorkout.builder().date(date).timeOfDay("05:45 AM").workoutName("walk").description("walk").distanceType("m").distance(12).duration("25:00").paceType("kph").elevationGainType("ft").elevationGain(12).elevationLossType("m").elevationLoss(12).feel("Normal").perceivedEffort("5 (Moderate)").avgPower(12).maxPower(14).avgCadence(70).maxCadence(90).minHR(12).avgHR(15).maxHR(17).caloriesBurned(123).build();
    BaseWorkout restDay = BaseWorkout.builder().date(date).workoutName("rest day").description("Rest day").build();
    BaseWorkout strengthTraining = BaseWorkout.builder().date(date).timeOfDay("06:12 AM").workoutName("Strength training").description("Strength training").duration("25:00").feel("Normal").perceivedEffort("9 (Very Hard)").build();
    BaseWorkout recoveryRehab = BaseWorkout.builder().subType("Chiropractor").date(date).timeOfDay("05:45 AM").workoutName("Recovery").description("Recovery").build();
    BaseWorkout other = BaseWorkout.builder().subType("Appointment").date(date).timeOfDay("05:45 AM").workoutName("Other workout").description("Other workout").build();
    BaseWorkout transition = BaseWorkout.builder().date(date).timeOfDay("05:45 AM").workoutName("transition").description("transition").distanceType("m").distance(12).duration("25:00").paceType("kph").elevationGainType("ft").elevationGain(12).elevationLossType("m").elevationLoss(12).feel("Normal").perceivedEffort("5 (Moderate)").avgPower(12).maxPower(14).avgCadence(70).maxCadence(90).minHR(12).avgHR(15).maxHR(17).caloriesBurned(123).build();

    @DataProvider(name = "Workouts")
    public Object[][] workouts() {
        return new Object[][]{
                {"Swim", swim},
                {"Bike", bike},
                {"Run", run},
                {"Cross Training", crossTraining},
                {"Walk", walk},
                {"Rest Day", restDay},
                {"Strength Training", strengthTraining},
                {"Recovery/Rehab", recoveryRehab},
                {"Other", other},
                {"Transition", transition}
        };
    }
    @Description("Add workout and validate")
    @Test(dataProvider = "Workouts")
    public void addWorkoutAndValidateTest(String type, BaseWorkout workout) {
        loginSteps
                .login("masya@mail.ru", "1234321MAks__", false)
                .toWorkoutPage();
        workoutPage
                .fillWorkout(type, workout)
                .clickAddWorkout()
                .validateWorkout(type, workout);
        calendarSteps
                .amountWorkoutsShouldBe(12,1)
                .deleteFromTo(date,date);

    }

    @Description("Update workout test")
    @Test(retryAnalyzer = Retry.class)
    public void updateWorkoutTest() {


        loginSteps
                .login("masya@mail.ru", "1234321MAks__", false)
                .toWorkoutPage();
        workoutPage
                .fillWorkout("Swim", swim)
                .clickAddWorkout()
                .toUpdateWorkout()
                .updateWorkoutTo("Run", run)
                .clickUpdateWorkout()
                .validateWorkout("Run", run);
        calendarSteps
                .deleteFromTo(date,date);

    }
    @Description("Clear all workout")
    @Test(retryAnalyzer = Retry.class,priority = -1)
    public void clearAllWorkouts() {
        loginSteps
                .login("masya@mail.ru", "1234321MAks__", false)
                .toWorkoutPage();
        calendarSteps
                .deleteFromTo(date,date);

    }
}



