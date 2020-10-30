package pages.gearAndRoutesPage;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.gearAndRotes.Routes;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static java.lang.String.format;
import static org.testng.Assert.assertEquals;
@Log4j2
public class RoutesPage extends BaseGearAndRoutesPage {
    public RoutesPage(WebDriver driver) {
        super(driver);
    }

    private static final By NAME = By.cssSelector("#RouteName");
    private static final By ACTIVITY = By.cssSelector("#Activity");
    private static final By DISTANCE = By.cssSelector("#Distance");
    private static final By DISTANCE_TYPE = By.cssSelector("#DistType");
    private static final By PERSONAL_RECORD_DATE = By.cssSelector("#PRDate");
    private static final By ROUTE_PERSONAL_RECORD = By.cssSelector("#RoutePR");
    private static final By ROUTE_NOTES = By.cssSelector("#Notes");
    private static final String CREATED_ROUTES = "//a[contains(@href,'Routes') and text()='%s']";
    private static final By ROUTES_OPTION_IN_DROPDOWN = By.cssSelector("[href='Routes.cshtml']");

    @Step("Open Routes Page")
    public void openRoutesPage() {
        log.info("Open routes page");
        Actions actions = new Actions(driver);
        WebElement gearAndRotesDropdown = driver.findElement(GEAR_ROTES_DROPDOWN);
        wait.until(ExpectedConditions.elementToBeClickable(gearAndRotesDropdown));
        actions.moveToElement(gearAndRotesDropdown).perform();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(ROUTES_OPTION_IN_DROPDOWN)));
        driver.findElement(ROUTES_OPTION_IN_DROPDOWN).click();
    }

    @Step("Validate Delete By Name : {name}")
    public void validateDelete(String name) {
        log.info("Validate delete route by name :"+name);
        List<WebElement> route = driver.findElements(By.xpath(format(CREATED_ROUTES, name)));
        assertEquals(route.size(), 0);
    }

    @Step("Fill Routes Fields And Click Add Button")
    public void fillRoutesAndClickAdd(Routes routes) {
        log.info("Fill routes :\n"+routes.toString());
        //fill Name
        fillInput(NAME, routes.getName());
        //select Activity
        selectOption(ACTIVITY, routes.getActivity());
        //select Distance Type
        selectOption(DISTANCE_TYPE, routes.getDistanceType());
        //fill Distance
        fillInput(DISTANCE, routes.getDistance());
        //fill Route Personal Record
        if (!routes.getRoutePersonalRecord().equals("")) {
            fillInput(ROUTE_PERSONAL_RECORD, routes.getRoutePersonalRecord());
        }
        //fill Personal Record Date
        if (!routes.getPersonalRecordDate().equals("")) {
            fillInput(PERSONAL_RECORD_DATE, routes.getPersonalRecordDate());
        }
        //fill Notes
        fillInput(ROUTE_NOTES, routes.getNotes());
        clickAddButton();
    }

    @Step("Click on created route by name: {name}")
    public void clickOnCreatedRoutesByName(String name) {
        log.info("Click on created route by name: "+name);
        driver.findElement(By.xpath(format(CREATED_ROUTES, name))).click();

    }

    @Step("Update Routes")
    public void updateRoutes(Routes updateRoutes, Routes toRoutes) {
        log.info("Update route to:\n"+toRoutes.toString());
        clickOnCreatedRoutesByName(updateRoutes.getName());
        fillRoutesAndClickAdd(toRoutes);
    }

    @Step("Check Routes Fields")
    public void validateRoutes(Routes routes) {
        log.info("Validate route:\n"+routes.toString() );
        clickOnCreatedRoutesByName(routes.getName());
        validateInput(NAME, routes.getName());
        validateInputWithComa(DISTANCE, routes.getDistance());
        validateInput(ROUTE_NOTES, routes.getNotes());
        if (!routes.getRoutePersonalRecord().equals("")) {
            validateInput(ROUTE_PERSONAL_RECORD, routes.getRoutePersonalRecord());
        }
        if (!routes.getPersonalRecordDate().equals("")) {
            validateInput(PERSONAL_RECORD_DATE, routes.getPersonalRecordDate());
        }
        validateSelectedOption("DistType", routes.getDistanceType());
        validateSelectedOption("Activity", routes.getActivity());
        openRoutesPage();
    }
}
