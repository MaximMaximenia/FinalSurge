package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static java.lang.String.format;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class CalendarPage extends BasePage {


    public static final String CALENDAR_SQUARE = "//td[@data-day='%s']";
    public static final String CALENDAR_PLUS = CALENDAR_SQUARE + "//div[@class='calendar-add dropdown']";
    public static final String SELECT_OPTION_INTO_DROPDOWN = "//td[@data-day='%s']//a[contains(text(),'%s')]";
    public static final String SORT = "//div[@class='fc-header-left']//span[contains(@class,'%s')]"; //weeks,week,month
    public static final String WEEK_SORT = "//ul[@class='dropdown-menu']//a[contains(text(),'%s')]";
    private static final By ALL_WORKOUTS = By.xpath("//td[contains(@class,'fc-widget-content')]//div[@class='fc-event-activity-title']");
    private static final By MONTH_AND_YEAR = By.cssSelector("#dpMonth");
    private static final By NEXT_MONTH_BUTTON = By.cssSelector(".icon-chevron-right");


    public CalendarPage(WebDriver driver) {
        super(driver);
    }

    public void monthShouldBe(String month) {
        assertTrue(driver.findElement(MONTH_AND_YEAR).getText().contains(month));
    }

    public void toNextMonth(int amountClick) {
        for (int i = 0; i < amountClick; i++) {
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(NEXT_MONTH_BUTTON)));
            driver.findElement(NEXT_MONTH_BUTTON).click();
        }

    }

    public void openCalendarMenuByDayAndSelectOptionInDropdown(int day, String option) {
        Actions actions = new Actions(driver);
        WebElement calendarPlus = driver.findElement(By.xpath(format(CALENDAR_PLUS, day)));
        actions.moveToElement(calendarPlus).perform();
        calendarPlus.click();
        driver.findElement(By.xpath(format(SELECT_OPTION_INTO_DROPDOWN, day, option))).click();
    }

    public void selectSortWeeksAmount(String weeksSort) {
        driver.findElement(By.xpath(format(SORT, "weeks"))).click();
        driver.findElement(By.xpath(format(WEEK_SORT, weeksSort)));
    }

    public void selectSortBy(String sortType) {
        if (sortType.contains("weeks")) {
            selectSortWeeksAmount(sortType);
        }

        driver.findElement(By.xpath(format(SORT, sortType))).click();

    }

    public void amountWorkoutsShouldBe(int expectedNumberOfWorkouts) {
        openCalendarPage();
        List<WebElement> allWorkout = driver.findElements(ALL_WORKOUTS);
        assertEquals(allWorkout.size(), expectedNumberOfWorkouts);

    }


}
