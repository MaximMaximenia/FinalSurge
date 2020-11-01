package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.DailyVitals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static java.lang.String.format;
import static java.lang.String.valueOf;
import static org.testng.Assert.assertEquals;
@Log4j2
public class DailyVitalsPage extends BasePage {
    public DailyVitalsPage(WebDriver driver) {
        super(driver);
    }

    private static final By VITALS_DATE = By.cssSelector("#VitalsDate");
    private static final By STEPS = By.cssSelector("#Steps");
    private static final By SORT = By.cssSelector("#PastDays");
    private static final By CALORIES_BURNED = By.cssSelector("#Calories");
    private static final By WEIGHT = By.cssSelector("#Weight");
    private static final By WEIGHT_TYPE = By.cssSelector("#WeightType");
    private static final By BODY_FAT = By.cssSelector("#BodyFat");
    private static final By WATER = By.cssSelector("#WaterPercent");
    private static final By MUSCLE_MASS = By.cssSelector("#MuscleMass");
    private static final By MUSCLE_MASS_TYPE = By.cssSelector("#MuscleMassType");
    private static final By RESTING_HR = By.cssSelector("#RestHR");
    private static final By HEALTH_NOTES = By.cssSelector("#HealthNotes");
    private static final By HR_VARIABILITY = By.cssSelector("#HRVar");
    private static final By SLEEP_HOURS = By.cssSelector("#SleepHours");
    private static final By AWAKE_TIME = By.cssSelector("#AwakeTime");
    private static final By DELETE_BUTTON = By.cssSelector("#del-vitals");
    private static final By SLEEP_AMOUNT_SELECT = By.cssSelector("#SleepAmount");
    private static final By SLEEP_QUALITY_SELECT = By.cssSelector("#SleepQuality");
    private static final By STRESS_AMOUNT_SELECT = By.cssSelector("#Stress");
    private static final By BLOOD_PRESSURE_SYSTOLIC = By.cssSelector("[name='Systolic']");
    private static final By BLOOD_PRESSURE_DIASTOLIC = By.cssSelector("[name='Diastolic']");
    private static final By OPEN_ADD_VITALS_BUTTON = By.cssSelector("[title='Add Vitals']");
    private static final By ADD_VITALS_BUTTON = By.cssSelector("#saveButton");
    private static final By SWITCH_TO_MODAL = By.cssSelector(".bootbox.modal");
    private static final By ALL_DAYS = By.xpath("//a[contains(@href,'DailyVitals?vitalsdate')]");
    private static final By CONFIRM_DELETE = By.xpath("//a[contains(text(),'OK')]");
    private static final String DATE = "//a[text()='%s']";
    private static final String VALIDATE_SELECT = "//select[@id='%s']//option[@selected]";
    private static final String VALIDATE_DELETE = "//a[text()='%s']/ancestor::tr//td";

    private void selectOption(By element, String option) {
        Select select = new Select(driver.findElement(element));
        select.selectByVisibleText(option);
    }

    @Step("Select sort by: {sort}")
    public DailyVitalsPage sortBy(String sort) {
        log.info("Select sort by "+sort);
        selectOption(SORT, sort);
        return this;
    }

    @Step("Fill input: {input}")
    private void fillStringInput(By input, String str) {
        log.info("Fill input:"+input.toString()+"\nString: "+str);
        driver.findElement(input).clear();
        driver.findElement(input).sendKeys(str);
    }

    @Step("Fill input: {input}")
    private void fillIntInput(By input, int number) {
        log.info("Fill input:"+input.toString()+"\nString: "+number);
        driver.findElement(input).clear();
        driver.findElement(input).sendKeys(valueOf(number));
    }

    @Step("Check amount day after sort, expected: {amount}")
    public void amountDaysAfterSortShouldBe(int amount) {
        log.info("Check amount days, expected:"+amount);
        List<WebElement> allDays = driver.findElements(ALL_DAYS);
        assertEquals(allDays.size(), amount,"Failed check amount day after sort");
    }

    @Step("Add vitals ")
    public DailyVitalsPage clickAddVitals() {
        log.info("Click add vitals");
        driver.findElement(OPEN_ADD_VITALS_BUTTON).click();
        return this;
    }

    @Step("Click add vitals button")
    private DailyVitalsPage addVitals() {
        log.info("Open vitals form");
        driver.findElement(ADD_VITALS_BUTTON).click();
        return this;
    }

    @Step("Validate delete by date: {date}")
    public void validateDelete(String date) {
        log.info("Validate delete by date: "+date);
        List<WebElement> allTableFields = driver.findElements(By.xpath(format(VALIDATE_DELETE, date)));
        for (int i = 1; i < allTableFields.size(); i++) {
            assertEquals(allTableFields.get(i).getText(), "","Failed validate delete");

        }

    }

    @Step("Confirm Delete")
    public DailyVitalsPage confirmDelete() {
        log.info("Confirm delete");
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(CONFIRM_DELETE)));
        driver.findElement(CONFIRM_DELETE).click();
        return this;
    }

    @Step("Delete daily vitals by date: {date}")
    public DailyVitalsPage deleteDailyVitalsByDate(String date) {
        log.info("Delete daily vitals by date:"+date);
        driver.findElement(By.xpath(format(DATE, date))).click();
        driver.findElement(DELETE_BUTTON).click();
        return this;
    }

    @Step("Validate input: {input}")
    private void validateInput(By input, String expectedText) {
        log.info("");
        assertEquals(driver.findElement(input).getAttribute("value"), expectedText,"Failed validate input: "+input.toString());
    }
    @Step("Validate select by id: {selectID}")
    private void validateSelect(String selectID, String option) {
        assertEquals(driver.findElement(By.xpath(format(VALIDATE_SELECT, selectID))).getText(), option,"Failed validate option");
    }
    @Step("Create daily vitals")
    public DailyVitalsPage createDailyVitals(DailyVitals dailyVitals) {
        log.info("Create daily vitals:\n"+dailyVitals.toString());
        //fillInputs
        fillStringInput(VITALS_DATE, dailyVitals.getDate());
        fillIntInput(STEPS, dailyVitals.getSteps());
        fillIntInput(CALORIES_BURNED, dailyVitals.getCaloriesConsumed());
        fillIntInput(WEIGHT, dailyVitals.getWeight());
        fillIntInput(BODY_FAT, dailyVitals.getBodyFat());
        fillIntInput(WATER, dailyVitals.getWater());
        fillIntInput(MUSCLE_MASS, dailyVitals.getMuscleMass());
        fillIntInput(RESTING_HR, dailyVitals.getRestingHr());
        fillIntInput(HR_VARIABILITY, dailyVitals.getHrVariability());
        fillIntInput(SLEEP_HOURS, dailyVitals.getSleepHours());
        fillIntInput(AWAKE_TIME, dailyVitals.getTotalTimeAwake());
        fillIntInput(BLOOD_PRESSURE_DIASTOLIC, dailyVitals.getBloodPressureDiastolic());
        fillIntInput(BLOOD_PRESSURE_SYSTOLIC, dailyVitals.getBloodPressureSystolic());
        fillStringInput(HEALTH_NOTES, dailyVitals.getHealthNotes());
        //fillSelects
        selectOption(WEIGHT_TYPE, dailyVitals.getWeightType());
        selectOption(MUSCLE_MASS_TYPE, dailyVitals.getMuscleMassType());
        selectOption(SLEEP_AMOUNT_SELECT, dailyVitals.getSleepAmount());
        selectOption(SLEEP_QUALITY_SELECT, dailyVitals.getSleepQuality());
        selectOption(STRESS_AMOUNT_SELECT, dailyVitals.getStressAmount());
        addVitals();
        return this;
    }
    @Step("Update daily vitals")
    public DailyVitalsPage updateDailyVitalsByDate(String date, DailyVitals dailyVitals) {
        log.info("Update daily vitals by date:"+date+"to:\n"+dailyVitals.toString());
        driver.findElement(By.xpath(format(DATE, date))).click();
        createDailyVitals(dailyVitals);
        return this;
    }
    @Step("Validate daily vitals")
    public DailyVitalsPage validateDailyVitals(DailyVitals dailyVitals) {
        log.info("Validate daily vitals:\n"+dailyVitals.toString());
        driver.findElement(By.xpath(format(DATE, dailyVitals.getDate()))).click();
        //validateInputs
        validateInput(VITALS_DATE, dailyVitals.getDate());
        validateInput(STEPS, valueOf(dailyVitals.getSteps()));
        validateInput(CALORIES_BURNED, valueOf(dailyVitals.getCaloriesConsumed()));
        validateInput(WEIGHT, valueOf(dailyVitals.getWeight()));
        validateInput(BODY_FAT, valueOf(dailyVitals.getBodyFat()));
        validateInput(WATER, valueOf(dailyVitals.getWater()));
        validateInput(MUSCLE_MASS, valueOf(dailyVitals.getMuscleMass()));
        validateInput(RESTING_HR, valueOf(dailyVitals.getRestingHr()));
        validateInput(HR_VARIABILITY, valueOf(dailyVitals.getHrVariability()));
        validateInput(SLEEP_HOURS, valueOf(dailyVitals.getSleepHours()));
        validateInput(AWAKE_TIME, valueOf(dailyVitals.getTotalTimeAwake()));
        validateInput(BLOOD_PRESSURE_DIASTOLIC, valueOf(dailyVitals.getBloodPressureDiastolic()));
        validateInput(BLOOD_PRESSURE_SYSTOLIC, valueOf(dailyVitals.getBloodPressureSystolic()));
        validateInput(HEALTH_NOTES, dailyVitals.getHealthNotes());
        //validateSelects
        validateSelect("MuscleMassType", valueOf(dailyVitals.getMuscleMassType()));
        validateSelect("SleepAmount", dailyVitals.getSleepAmount());
        validateSelect("SleepQuality", dailyVitals.getSleepQuality());
        validateSelect("Stress", dailyVitals.getStressAmount());
        validateSelect("WeightType", valueOf(dailyVitals.getWeightType()));
        return this;

    }

}
