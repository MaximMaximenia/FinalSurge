package pages.gearAndRoutesPage;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.gearAndRotes.Shoes;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static java.lang.String.format;
import static org.testng.Assert.assertEquals;

@Log4j2
public class ShoesPage extends BaseGearAndRoutesPage {
    public ShoesPage(WebDriver driver) {
        super(driver);
    }

    private static final By SHOES_OPTION_IN_DROPDOWN = By.cssSelector("[href='EquipmentShoes.cshtml']");
    private static final By SHOES_SIZE_SELECT = By.cssSelector("#ShoeSize");
    private static final By SHOES_DISTANCE_ALERT_TYPE = By.cssSelector("#DistAlertType");
    private static final By SHOES_DISTANCE_ALERT = By.cssSelector("#DistAlert");
    private static final String CREATED_SHOES = "//a[contains(@href,'EquipmentShoes') and text()='%s']";

    @Step("Open Shoes Page")
    public void openShoesPage() {
        log.info("Open shoes page");
        Actions actions = new Actions(driver);
        WebElement gearAndRotesDropdown = driver.findElement(GEAR_ROTES_DROPDOWN);
        wait.until(ExpectedConditions.elementToBeClickable(gearAndRotesDropdown));
        actions.moveToElement(gearAndRotesDropdown).perform();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(SHOES_OPTION_IN_DROPDOWN)));
        driver.findElement(SHOES_OPTION_IN_DROPDOWN).click();
    }

    @Step("Fill shoes field and click add button")
    public void fillShoesAndClickAdd(Shoes shoes) {
        log.info("Fill shoe:\n" + shoes.toString());
        //fill Name
        fillInput(NAME, shoes.getName());
        //fill Brand
        driver.findElement(BRAND).click();
        driver.findElement(By.xpath(format(BRAND_SELECT, shoes.getBrand()))).click();
        //fill Model
        fillInput(MODEL, shoes.getModel());
        //fill Cost
        fillInput(COST, shoes.getCost());
        //fill Date Purchase
        fillInput(DATE_PURCHASED, shoes.getDate());
        //select Shoes Size
        selectOption(SHOES_SIZE_SELECT, shoes.getSize());
        //select Starting Distance Type
        selectOption(DISTANCE_TYPE, shoes.getStartingDistanceType());
        //select Distance Alert Type
        selectOption(SHOES_DISTANCE_ALERT_TYPE, shoes.getDistanceAlertType());
        //fill Starting Distance
        fillInput(DISTANCE, shoes.getStartingDistance());
        //fill Distance Alert
        fillInput(SHOES_DISTANCE_ALERT, shoes.getDistanceAlert());
        //fill Notes
        fillInput(NOTES, shoes.getNotes());
        clickAddButton();
    }

    @Step("Validate delete by name: {name}")
    public void validateDelete(String name) {
        log.info("Validate delete by name: " + name);
        List<WebElement> shoe = driver.findElements(By.xpath(format(CREATED_SHOES, name)));
        assertEquals(shoe.size(), 0);
    }

    @Step("Click on created shoe by name: {name}")
    public void clickOnCreatedShoesByName(String name) {
        log.info("Click on created shoe by name: " + name);
        driver.findElement(By.xpath(format(CREATED_SHOES, name))).click();

    }

    @Step("Update shoe")
    public void updateShoes(Shoes updateShoes, Shoes toShoes) {
        log.info("Update shoe to:\n"+toShoes.toString());
        clickOnCreatedShoesByName(updateShoes.getName());
        fillShoesAndClickAdd(toShoes);
    }

    @Step("Check shoes fields")
    public void validateShoes(Shoes shoes) {
        log.info("Validate shoe:\n"+shoes.toString());
        clickOnCreatedShoesByName(shoes.getName());
        validateInput(NAME, shoes.getName());
        validateInput(MODEL, shoes.getModel());
        validateInputWithComa(COST, shoes.getCost());
        validateInput(DATE_PURCHASED, shoes.getDate());
        validateInput(SHOES_DISTANCE_ALERT, shoes.getDistanceAlert());
        validateInput(DISTANCE, shoes.getStartingDistance());
        validateInput(NOTES, shoes.getNotes());
        assertEquals(driver.findElement(BRAND).getText(), shoes.getBrand());
        validateSelectedOption("DistType", shoes.getStartingDistanceType());
        validateSelectedOption("DistAlertType", shoes.getDistanceAlertType());
        validateSelectedOption("ShoeSize", shoes.getSize());
        openShoesPage();
    }

}
