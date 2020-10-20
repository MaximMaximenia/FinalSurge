package modal.workouts;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BaseWorkout {

    String date;
    String timeOfDay;
    String workoutName;
    String description;
    String duration;
    int distance;

}
