package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class CalendarPage extends BasePage {

    public static final String CALENDAR_SQUARE = "//td[@data-day='%s']";
    public static final String CALENDAR_PLUS = CALENDAR_SQUARE + "//div[@class='calendar-add dropdown']";
    public static final String QUICK_ADD = CALENDAR_SQUARE + "//a[@class='full-add']";
    public static final String FULL_ADD = CALENDAR_SQUARE + "//a[@class='full-add']";


    public CalendarPage(WebDriver driver) {
        super(driver);
    }


    public WorkoutPage clickFullAddWorkoutByDay(String day) {
        Actions actions = new Actions(driver);
        WebElement calendarPlus = driver.findElement(By.xpath(String.format(CALENDAR_PLUS, day)));
        actions.moveToElement(calendarPlus).perform();
        calendarPlus.click();
        driver.findElement(By.xpath(String.format(FULL_ADD, day))).click();
        return new WorkoutPage(driver);
    }

    public void clickQuickAddWorkoutByDay(String day) {
        Actions actions = new Actions(driver);
        WebElement calendarPlus = driver.findElement(By.xpath(String.format(CALENDAR_PLUS, day)));
        actions.moveToElement(calendarPlus).perform();
        calendarPlus.click();
        driver.findElement(By.xpath(String.format(QUICK_ADD, day))).click();
    }
}
