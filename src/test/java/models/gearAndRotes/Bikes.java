package models.gearAndRotes;

import lombok.Data;
import lombok.Builder;

@Data
@Builder
public class Bikes {
String name;
String brand;
String model;
String cost;
String datePurchased;
String distanceType;
String distance;
String notes;
}
