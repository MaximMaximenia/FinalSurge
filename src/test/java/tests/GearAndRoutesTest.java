package tests;

import io.qameta.allure.Description;
import models.gearAndRotes.Bikes;
import models.gearAndRotes.Routes;
import models.gearAndRotes.Shoes;
import org.testng.annotations.Test;

public class GearAndRoutesTest extends BaseTest {
    Bikes bike = Bikes.builder().name("StelsNavigator").brand("Cube").model("Navigator").cost("123").datePurchased("9/29/2020").distance("123").distanceType("km").notes("Gift").build();
    Bikes bikeForUpdate = Bikes.builder().name("BMC 212").brand("BMC").model("123").cost("123").datePurchased("1/19/2020").distance("23").distanceType("mi").notes("Test").build();
    Shoes shoes = Shoes.builder().name("Adidasiks").brand("ASICS").model("GEL-LYTE").cost("99").date("9/29/2020").size("10").startingDistance("50").startingDistanceType("km").distanceAlertType("km").distanceAlert("12").notes("Gift").build();
    Shoes shoesForUpdate = Shoes.builder().name("Asicsas").brand("Avia").model("123").cost("50").date("9/15/2020").size("5").startingDistance("30").startingDistanceType("mi").distanceAlertType("mi").distanceAlert("24").notes("Test").build();
    Routes routes = Routes.builder().name("village").activity("Bike").distance("213").distanceType("km").routePersonalRecord("2:12").personalRecordDate("10/30/2020").notes("Test").build();
    Routes routesForUpdate = Routes.builder().name("town").activity("Bike").distance("113").distanceType("mi").routePersonalRecord("").personalRecordDate("").notes("Test1221").build();

    @Description("Create,Update,Delete bike test")
    @Test
    public void createUpdateDeleteBike() {
        loginSteps
                .login("masya@mail.ru", "1234321MAks__", false);
        gearAndRoutesSteps
                .createUpdateDeleteBike(bike,bikeForUpdate);
    }
    @Description("Create,Update,Delete shoe test")
    @Test
    public void createUpdateDeleteShoe() {
        loginSteps
                .login("masya@mail.ru", "1234321MAks__", false);
        gearAndRoutesSteps
                .createUpdateDeleteShoes(shoes,shoesForUpdate);
    }
    @Description("Create,Update,Delete route test")
    @Test
    public void createUpdateDeleteRoute() {
        loginSteps
                .login("masya@mail.ru", "1234321MAks__", false);
        gearAndRoutesSteps
                .createUpdateDeleteRoutes(routes,routesForUpdate);
    }
}