package steps;

import io.qameta.allure.Step;
import models.gearAndRotes.Bikes;
import models.gearAndRotes.Routes;
import models.gearAndRotes.Shoes;
import org.openqa.selenium.WebDriver;

public class GearAndRoutesSteps extends BaseSteps{
    public GearAndRoutesSteps(WebDriver driver) {
        super(driver);
    }
    @Step("Create,Update,Delete bike")
    public void createUpdateDeleteBike(Bikes bike,Bikes updateToThis){
        bikesPages.openBikesPage();
        bikesPages.fillBikesAndClickAdd(bike);
        bikesPages.validateBikes(bike);
        bikesPages.updateBikes(bike,updateToThis);
        bikesPages.validateBikes(updateToThis);
        bikesPages.clickOnCreatedBikesByName(updateToThis.getName());
        bikesPages.clickDeleteAndConfirm();
        bikesPages.validateDelete(updateToThis.getName());
    }
    @Step("Create,Update,Delete shoe")
    public void createUpdateDeleteShoes(Shoes shoes, Shoes updateToThis){
        shoesPage.openShoesPage();
        shoesPage.fillShoesAndClickAdd(shoes);
        shoesPage.validateShoes(shoes);
        shoesPage.updateShoes(shoes,updateToThis);
        shoesPage.validateShoes(updateToThis);
        shoesPage.clickOnCreatedShoesByName(updateToThis.getName());
        shoesPage.clickDeleteAndConfirm();
        shoesPage.validateDelete(updateToThis.getName());
    }
    @Step("Create,Update,Delete route")
    public void createUpdateDeleteRoutes(Routes route, Routes updateToThis){
        routesPage.openRoutesPage();
        routesPage.fillRoutesAndClickAdd(route);
        routesPage.validateRoutes(route);
        routesPage.updateRoutes(route,updateToThis);
        routesPage.validateRoutes(updateToThis);
        routesPage.clickOnCreatedRoutesByName(updateToThis.getName());
        routesPage.clickDeleteAndConfirm();
        routesPage.validateDelete(updateToThis.getName());
    }
}
