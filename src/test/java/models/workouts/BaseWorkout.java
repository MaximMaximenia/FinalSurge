package models.workouts;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BaseWorkout  {
    String subType;
    String date;
    String timeOfDay;
    String workoutName;
    String description;
    int distance;
    String distanceType;
    String duration;
    String pace;
    String paceType;
    String feel;
    String perceivedEffort;
    int elevationGain;
    String elevationGainType;
    int elevationLoss;
    String elevationLossType;
    int minHR;
    int avgHR;
    int maxHR;
    int caloriesBurned;
    int avgPower;
    int maxPower;
    int avgCadence;
    int maxCadence;




}


