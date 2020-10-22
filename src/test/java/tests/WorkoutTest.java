package tests;


import models.workouts.Bike;
import org.testng.annotations.Test;

public class WorkoutTest extends BaseTest {


    @Test
    public void addWorkout() {
        Bike bike = new Bike(driver, "10/23/2020", "05:45 AM", "bitka"
                , "kachat' bitky", "01:00:22", "2:21", "min/mi",12,"km" ,"Poor",
                "3 (Light)", 60, 70, 90, 2000);
        loginSteps
                .login("masya@mail.ru", "1234321MAks__", false)
                .toWorkoutPage();

        workoutSteps
                .createWorkout(bike, "Long Ride");


    }

    @Test
    public void addFullWorkoutIntoCalendar() {
        Bike bike = new Bike(driver, "10/23/2020", "05:45 AM", "bitka"
                , "kachat' bitky", "01:00:22", "2:21", "min/mi",12,"km" ,"Poor",
                "3 (Light)", 60, 70, 90, 2000);

        loginSteps
                .login("masya@mail.ru", "1234321MAks__", false);

        calendarPage
                .clickFullAddWorkoutByDay("6")
                .addWorkout(bike,"Long Ride");


    }
    @Test
    public void addQuickWorkoutIntoCalendar() {
        Bike bike = new Bike(driver, "10/23/2020", "05:45 AM", "bitka"
                , "kachat' bitky", "01:00:22", "2:21", "min/mi",12,"km" ,"Poor",
                "3 (Light)", 60, 70, 90, 2000);

        loginSteps
                .login("masya@mail.ru", "1234321MAks__", false);

        calendarPage
                .clickFullAddWorkoutByDay("6")
                .addWorkout(bike,"Long Ride");


    }


}
