package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.String.format;
import static org.testng.Assert.assertEquals;

public class WorkoutReportPage extends BasePage {

    private static final By START_DATE = By.cssSelector("#WorkoutDate");
    private static final By END_DATE = By.cssSelector("#WorkoutDateEnd");
    private static final By ACTIVITY_TYPE_SELECT = By.cssSelector("#ActivityType");
    private static final String REPORT_VIEW = "//label[@class='radio inline']//input[@value='%s']";
    private static final By VIEW_REPORT_BUTTON = By.cssSelector("[value='View Report']");
    private static final By ALL_WORKOUTS = By.cssSelector("[nowrap]");

    public WorkoutReportPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click view report button")
    public WorkoutReportPage clickViewReportButton() {
        driver.findElement(VIEW_REPORT_BUTTON).click();
        return this;
    }

    @Step("Fill workout report fields")
    public WorkoutReportPage fillDatesAndActivityType(String startDate, String endDate, String activityType) {
        driver.findElement(START_DATE).clear();
        driver.findElement(START_DATE).sendKeys(startDate);
        driver.findElement(END_DATE).clear();
        driver.findElement(END_DATE).sendKeys(endDate);
        Select select = new Select(driver.findElement(ACTIVITY_TYPE_SELECT));
        select.selectByVisibleText(activityType);
        return this;
    }

    @Step("Check amount workout(expected: {expectedAmount})")
    public void amountWorkoutsShouldBe(int expectedAmount) {
        List<WebElement> allWorkouts = driver.findElements(ALL_WORKOUTS);
        assertEquals(allWorkouts.size(), expectedAmount);
    }

    @Step("Select report view: {option}")
    public void selectReportView(String option) {
        Map<String, String> reportViewOption = new HashMap<>();
        reportViewOption.put("List View", "1");
        reportViewOption.put("Group by Week ", "2");
        reportViewOption.put("Group by Month", "3");
        reportViewOption.put("Group by Activity", "4");
        reportViewOption.put("Group by Activity Sub-type", "5");
        driver.findElement(By.xpath(format(REPORT_VIEW, reportViewOption.get(option)))).click();

    }

}
