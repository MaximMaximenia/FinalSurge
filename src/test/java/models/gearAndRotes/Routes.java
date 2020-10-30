package models.gearAndRotes;
import lombok.Data;
import lombok.Builder;

@Data
@Builder
public class Routes {
    String name;
    String activity;
    String distance;
    String distanceType;
    String routePersonalRecord;
    String personalRecordDate;
    String notes;
}
