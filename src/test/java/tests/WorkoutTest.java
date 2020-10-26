package tests;


import models.workouts.BaseWorkout;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WorkoutTest extends BaseTest {
    BaseWorkout swim = BaseWorkout.builder().subType("Drills").date("10/23/2020").timeOfDay("05:45 AM").workoutName("SwimWorkout").description("went to the pools").distanceType("m").distance(15).duration("25:00").paceType("kph").feel("Poor").perceivedEffort("3 (Light)").caloriesBurned(1232).build();
    BaseWorkout bike = BaseWorkout.builder().subType("Intervals").date("10/23/2020").timeOfDay("05:45 AM").workoutName("BikeWorkout").description("Ride a bike to work").distanceType("m").distance(12).duration("25:00").paceType("kph").elevationGainType("ft").elevationGain(12).elevationLossType("m").elevationLoss(12).feel("Normal").perceivedEffort("5 (Moderate)").avgPower(12).maxPower(14).avgCadence(70).maxCadence(90).minHR(12).avgHR(15).maxHR(17).caloriesBurned(123).build();
    BaseWorkout run = BaseWorkout.builder().subType("Marathon Pace").date("10/23/2020").timeOfDay("05:45 AM").workoutName("run").description("run").distanceType("m").distance(12).duration("25:00").paceType("kph").feel("Good").perceivedEffort("5 (Moderate)").minHR(12).avgHR(15).maxHR(17).caloriesBurned(123).build();
    BaseWorkout crossTraining = BaseWorkout.builder().date("10/23/2020").timeOfDay("05:45 AM").workoutName("cross training").description("cross training").distanceType("m").distance(12).duration("25:00").paceType("kph").feel("Terrible").perceivedEffort("5 (Moderate)").minHR(12).avgHR(15).maxHR(17).caloriesBurned(123).build();
    BaseWorkout walk = BaseWorkout.builder().date("10/23/2020").timeOfDay("05:45 AM").workoutName("walk").description("walk").distanceType("m").distance(12).duration("25:00").paceType("kph").elevationGainType("ft").elevationGain(12).elevationLossType("m").elevationLoss(12).feel("Normal").perceivedEffort("5 (Moderate)").avgPower(12).maxPower(14).avgCadence(70).maxCadence(90).minHR(12).avgHR(15).maxHR(17).caloriesBurned(123).build();
    BaseWorkout restDay = BaseWorkout.builder().date("10/23/2020").workoutName("rest day").description("Rest day").build();
    BaseWorkout strengthTraining = BaseWorkout.builder().date("10/23/2020").timeOfDay("06:12 AM").workoutName("Strength training").description("Strength training").duration("25:00").feel("Normal").perceivedEffort("9 (Very Hard)").build();
    BaseWorkout recoveryRehab = BaseWorkout.builder().subType("Chiropractor").date("10/23/2020").timeOfDay("05:45 AM").workoutName("Recovery").description("Recovery").build();
    BaseWorkout other = BaseWorkout.builder().subType("Appointment").date("10/23/2020").timeOfDay("05:45 AM").workoutName("Other workout").description("Other workout").build();
    BaseWorkout transition = BaseWorkout.builder().date("10/23/2020").timeOfDay("05:45 AM").workoutName("transition").description("transition").distanceType("m").distance(12).duration("25:00").paceType("kph").elevationGainType("ft").elevationGain(12).elevationLossType("m").elevationLoss(12).feel("Normal").perceivedEffort("5 (Moderate)").avgPower(12).maxPower(14).avgCadence(70).maxCadence(90).minHR(12).avgHR(15).maxHR(17).caloriesBurned(123).build();

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

    @Test(dataProvider = "Workouts")
    public void addWorkoutAndValidateTest(String type, BaseWorkout workout) {
        loginSteps
                .login("masya@mail.ru", "1234321MAks__", false)
                .toWorkoutPage();
        workoutPage
                .fillWorkout(type, workout)
                .clickAddWorkout()
                .validateWorkout(type, workout);
    }


    @Test
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

    }
}



