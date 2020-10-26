package pages;

import models.workouts.BaseWorkout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static java.lang.String.format;


public class CalendarPage extends BasePage {


    public static final String CALENDAR_SQUARE = "//td[@data-day='%s']";
    public static final String CALENDAR_PLUS = CALENDAR_SQUARE + "//div[@class='calendar-add dropdown']";
    public static final String SELECT_OPTION_INTO_DROPDOWN = "//td[@data-day='%s']//a[contains(text(),'%s')]";
    public static final String SORT = "//div[@class='fc-header-left']//span[contains(@class,'%s')]"; //weeks,week,month
    public static final String WEEK_SORT = "//ul[@class='dropdown-menu']//a[contains(text(),'%s')]";
    public static final By WORKOUT_TIME = By.cssSelector("#WorkoutTime");


    public CalendarPage(WebDriver driver) {
        super(driver);
    }
public void quickAdd(BaseWorkout workout){


}
    public void openCalendarMenuByDayAndSelectOptionInDropdown(String day, String option) {
        Actions actions = new Actions(driver);
        WebElement calendarPlus = driver.findElement(By.xpath(format(CALENDAR_PLUS, day)));
        actions.moveToElement(calendarPlus).perform();
        calendarPlus.click();
        driver.findElement(By.xpath(format(SELECT_OPTION_INTO_DROPDOWN, day, option))).click();
    }


    public WorkoutPage clickFullAddWorkoutByDay(String day) {
        openCalendarMenuByDayAndSelectOptionInDropdown(day, "Full Add");
        return new WorkoutPage(driver);
    }

    public void clickQuickAddWorkoutByDay(String day) {
        openCalendarMenuByDayAndSelectOptionInDropdown(day, "Quick Add");
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

    public CopyMoveDeleteFrame clickCopyMoveDeleteWorkoutByDay(String day) {
        openCalendarMenuByDayAndSelectOptionInDropdown(day, "'Copy/Move/Delete");
        return new CopyMoveDeleteFrame(driver);
    }

    public void clearAllWorkoutByDates(String from, String to) {


    }
}
