package pages.gearAndRoutesPage;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.gearAndRotes.Bikes;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static java.lang.String.format;
import static org.testng.Assert.assertEquals;
@Log4j2
public class BikesPage extends BaseGearAndRoutesPage {
    public BikesPage(WebDriver driver) {
        super(driver);
    }

    private static final By BIKES_OPTION_IN_DROPDOWN = By.cssSelector("[href='EquipmentBikes.cshtml']");
    private static final String CREATED_BIKES = "//a[contains(@href,'EquipmentBikes') and text()='%s']";
    @Step("Open Bikes Page")
    public void openBikesPage() {
        log.info("Open bikes page");
        Actions actions = new Actions(driver);
        WebElement gearAndRotesDropdown = driver.findElement(GEAR_ROTES_DROPDOWN);
        wait.until(ExpectedConditions.elementToBeClickable(gearAndRotesDropdown));
        actions.moveToElement(gearAndRotesDropdown).perform();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(BIKES_OPTION_IN_DROPDOWN)));
        driver.findElement(BIKES_OPTION_IN_DROPDOWN).click();
    }

    @Step("Fill Bike Fields And Click Add Button")
    public void fillBikesAndClickAdd(Bikes bike) {
        log.info("Fill bike: \n "+bike.toString());
        //fill Name
        fillInput(NAME, bike.getName());
        //fill Brand
        driver.findElement(BRAND).click();
        driver.findElement(By.xpath(format(BRAND_SELECT, bike.getBrand()))).click();
        //fill Model
        fillInput(MODEL, bike.getModel());
        //fill Cost
        fillInput(COST, bike.getCost());
        //fill Date Purchase
        fillInput(DATE_PURCHASED, bike.getDatePurchased());
        //select Starting Distance Type
        selectOption(DISTANCE_TYPE, bike.getDistanceType());
        //fill Starting Distance
        fillInput(DISTANCE, bike.getDistance());
        //fill Notes
        fillInput(NOTES, bike.getNotes());
        clickAddButton();
    }

    @Step("Click On Created Bike By Name: {name}")
    public void clickOnCreatedBikesByName(String name) {
        log.info("Click on created bike: "+name);
        driver.findElement(By.xpath(format(CREATED_BIKES, name))).click();

    }

    @Step("Update Bike ")
    public void updateBikes(Bikes updateBike, Bikes toBike) {
        log.info("Update bike to: \n"+toBike.toString());
        clickOnCreatedBikesByName(updateBike.getName());
        fillBikesAndClickAdd(toBike);
    }
    @Step("Validate Delete Bike By Name: {name}")
    public void validateDelete(String name) {
        log.info("Velidate delete bike: "+name);
        List<WebElement> bike = driver.findElements(By.xpath(format(CREATED_BIKES, name)));
        assertEquals(bike.size(), 0,"Bikes not deleted");
    }
    @Step("Check Bike Fields")
    public void validateBikes(Bikes bike) {
        log.info("Validate bike:\n"+bike.toString());
        clickOnCreatedBikesByName(bike.getName());
        validateInput(NAME, bike.getName());
        validateInput(MODEL, bike.getModel());
        validateInputWithComa(COST, bike.getCost());
        validateInput(DATE_PURCHASED, bike.getDatePurchased());
        validateInput(DISTANCE, bike.getDistance());
        validateInput(NOTES, bike.getNotes());
        assertEquals(driver.findElement(BRAND).getText(), bike.getBrand(),"Brand - failed validate");
        validateSelectedOption("DistType", bike.getDistanceType());
        openBikesPage();
    }
}
