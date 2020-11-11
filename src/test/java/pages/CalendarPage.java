package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static java.lang.String.format;
import static org.testng.Assert.assertEquals;

@Log4j2
public class CalendarPage extends BasePage {


    public static final String CALENDAR_SQUARE = "//td[@data-day='%s']";
    public static final String CALENDAR_PLUS = CALENDAR_SQUARE + "//div[@class='calendar-add dropdown']";
    public static final String SELECT_OPTION_INTO_DROPDOWN = "//td[@data-day='%s']//a[contains(text(),'%s')]";
    public static final String SORT = "//div[@class='fc-header-left']//span[contains(@class,'%s')]"; //weeks,week,month
    public static final String WEEK_SORT = "//ul[@class='dropdown-menu']//a[contains(text(),'%s')]";
    private static final String ALL_WORKOUTS = "//td[@data-day='%s']//div[@class='fc-event-activity-title']";
    private static final By MONTH_AND_YEAR = By.cssSelector("#dpMonth");
    private static final By NEXT_MONTH_BUTTON = By.cssSelector(".icon-chevron-right");


    public CalendarPage(WebDriver driver) {
        super(driver);
    }


    @Step("Select month: {month}")
    public CalendarPage selectMonth(String month) {
        log.info("Select month: " + month);
        while (!driver.findElement(MONTH_AND_YEAR).getText().contains(month)) {
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(NEXT_MONTH_BUTTON)));
            driver.findElement(NEXT_MONTH_BUTTON).click();
        }
        return this;
    }

    @Step("Open calendar menu by day:{day}, and select option {option}")
    public void openCalendarMenuByDayAndSelectOptionInDropdown(int day, String option) {
        log.info("Open calendar menu by day: " + day + ", and select option: " + option + "");
        Actions actions = new Actions(driver);
        WebElement calendarPlus = driver.findElement(By.xpath(format(CALENDAR_PLUS, day)));
        actions.moveToElement(calendarPlus).perform();
        calendarPlus.click();
        driver.findElement(By.xpath(format(SELECT_OPTION_INTO_DROPDOWN, day, option))).click();
//
    }

    public void selectSortWeeksAmount(String weeksSort) {

        driver.findElement(By.xpath(format(SORT, "weeks"))).click();
        driver.findElement(By.xpath(format(WEEK_SORT, weeksSort)));
    }

    @Step("Select sort by: {sortType}")
    public void selectSortBy(String sortType) {
        log.info("Select sort by: " + sortType);
        if (sortType.contains("weeks")) {
            selectSortWeeksAmount(sortType);
        }

        driver.findElement(By.xpath(format(SORT, sortType))).click();

    }

    @Step("Check amount created workouts. Expected: {expectedNumberOfWorkouts}")
    public void amountWorkoutsInDayShouldBe(int day, int expectedNumberOfWorkouts) {
        log.info("Check that amount workout in day:" + day + "\nexpected: " + expectedNumberOfWorkouts);
        List<WebElement> allWorkout = driver.findElements(By.xpath(format(ALL_WORKOUTS, day)));
        assertEquals(allWorkout.size(), expectedNumberOfWorkouts);

    }


}
