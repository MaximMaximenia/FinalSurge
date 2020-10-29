package steps;

import org.openqa.selenium.WebDriver;

public class CalendarSteps extends BaseSteps {
    public CalendarSteps(WebDriver driver) {
        super(driver);
    }

    public CalendarSteps amountWorkoutsShouldBe(int amount) {
        calendarPage
                .openCalendarPage()
                .amountWorkoutsShouldBe(amount);
        return this;
    }

    public void deleteFromTo(String from, String to) {
        calendarPage
                .openCalendarPage()
                .openCalendarMenuByDayAndSelectOptionInDropdown(1, "Copy/Move/Delete");
        copyMoveDeleteFrame.
                switchToFrame()
                .selectFunction("Delete")
                .selectStartingDate("9/1/2020")
                .selectEndingDate("12/31/2020")
                .clickContinue()
                .completeDeleteClick()
                .switchToDefault();
    }
}
