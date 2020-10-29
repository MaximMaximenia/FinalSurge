package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CopyMoveDeleteFrame extends BasePage {

    private static final By START_DATE_INPUT = By.cssSelector("#WorkoutDateStart");
    private static final By END_DATE_INPUT = By.cssSelector("#WorkoutDateEnd");
    private static final By CONTINUE_BUTTON = By.cssSelector("#contButton");
    private static final By COMPLETE_DELETE_BUTTON = By.cssSelector("[value='Complete Delete']");
    private static final By COPY_MOVE_DELETE_FRAME = By.cssSelector("#CopyWeeksiFrame");
    private static final String FUNCTION = "//div[text()='Function: ']";


    public CopyMoveDeleteFrame(WebDriver driver) {
        super(driver);
    }

    public CopyMoveDeleteFrame selectFunction(String function) {
        switch (function) {
            case "Copy":
                driver.findElement(By.xpath(FUNCTION + "//strong")).click();
            case "Move/Shift":
                driver.findElement(By.xpath(FUNCTION + "//a[contains(@href,'WorkoutMoveShift')]")).click();
            case "Delete":
                driver.findElement(By.xpath(FUNCTION + "//a[contains(@href,'WorkoutDelete')]")).click();
        }
        return this;
    }

    public CopyMoveDeleteFrame switchToFrame() {
        driver.switchTo().frame(driver.findElement(COPY_MOVE_DELETE_FRAME));
        return this;

    }

    public CalendarPage switchToDefault() {
        driver.switchTo().defaultContent();
        return new CalendarPage(driver);
    }

    public CopyMoveDeleteFrame selectStartingDate(String startingDate) {
        driver.findElement(START_DATE_INPUT).clear();
        driver.findElement(START_DATE_INPUT).sendKeys(startingDate);
        return this;

    }

    public CopyMoveDeleteFrame selectEndingDate(String endingDate) {
        driver.findElement(END_DATE_INPUT).clear();
        driver.findElement(END_DATE_INPUT).sendKeys(endingDate);
        return this;

    }

    public CopyMoveDeleteFrame completeDeleteClick() {
        driver.findElement(COMPLETE_DELETE_BUTTON).click();
        return this;
    }

    public CopyMoveDeleteFrame clickContinue() {
        driver.findElement(CONTINUE_BUTTON).click();
        return this;
    }

}
