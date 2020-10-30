package models.gearAndRotes;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Shoes {
    String name;
    String brand;
    String model;
    String cost;
    String date;
    String size;
    String startingDistanceType;
    String startingDistance;
    String distanceAlertType;
    String distanceAlert;
    String notes;
}
