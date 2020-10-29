package models;

import lombok.Builder;
import lombok.Data;
@Builder
@Data
public class DailyVitals {
    String date;
    int steps;
    int caloriesConsumed;
    int weight;
    String weightType;
    int bodyFat;
    int water;
    int muscleMass;
    String muscleMassType;
    int restingHr;
    int hrVariability;
    int sleepHours;
    int totalTimeAwake;
    String healthNotes;
    String sleepAmount;
    String sleepQuality;
    String stressAmount;
    int bloodPressureSystolic;
    int bloodPressureDiastolic;

}
