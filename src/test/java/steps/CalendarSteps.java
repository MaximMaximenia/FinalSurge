package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class CalendarSteps extends BaseSteps {
    public CalendarSteps(WebDriver driver) {
        super(driver);
    }
    @Step("Check amount workouts(expected:{amount})")
    public CalendarSteps amountWorkoutsShouldBe(int day,int amount) {
        calendarPage
                .openCalendarPage()
                .amountWorkoutsInDayShouldBe(day,amount);
        return this;
    }
    @Step("Delete workouts from {from} to {to}")
    public CalendarSteps deleteFromTo(String from, String to) {
        calendarPage
                .openCalendarPage()
                .openCalendarMenuByDayAndSelectOptionInDropdown(1, "Copy/Move/Delete");
        copyMoveDeleteFrame.
                switchToFrame()
                .selectFunction("Delete")
                .selectStartingDate(from)
                .selectEndingDate(to)
                .clickContinue()
                .completeDeleteClick()
                .switchToDefault();
        return this;
    }
}
