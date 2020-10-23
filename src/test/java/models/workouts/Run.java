package models.workouts;

import lombok.Data;
import org.openqa.selenium.WebDriver;

public class Run extends BaseWorkout {
    Run(String subType, String date, String timeOfDay, String workoutName, String description, int distance, String distanceType, String duration, String pace, String paceType, String feel, String perceivedEffort, int elevationGain, String elevationGainType, int elevationLoss, String elevationLossType, int minHR, int avgHR, int maxHR, int caloriesBurned, int avgPower, int maxPower, int avgCadence, int maxCadence) {
        super(subType, date, timeOfDay, workoutName, description, distance, distanceType, duration, pace, paceType, feel, perceivedEffort, elevationGain, elevationGainType, elevationLoss, elevationLossType, minHR, avgHR, maxHR, caloriesBurned, avgPower, maxPower, avgCadence, maxCadence);
    }
}

