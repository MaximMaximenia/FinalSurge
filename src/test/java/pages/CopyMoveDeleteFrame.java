package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
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

    @Step("Select function: {function}")
    public CopyMoveDeleteFrame selectFunction(String function) {
        log.info("Select function: " + function);
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

    @Step("Switch to appeared frame")
    public CopyMoveDeleteFrame switchToFrame() {
        log.info("Switch to frame");
        driver.switchTo().frame(driver.findElement(COPY_MOVE_DELETE_FRAME));
        return this;

    }

    @Step("Switch to default content")
    public CalendarPage switchToDefault() {
        log.info("Switch to default content");
        driver.switchTo().defaultContent();
        return new CalendarPage(driver);
    }

    @Step("Select starting date: {startingDate}")
    public CopyMoveDeleteFrame selectStartingDate(String startingDate) {
        log.info("Select starting date: " + startingDate);
        driver.findElement(START_DATE_INPUT).clear();
        driver.findElement(START_DATE_INPUT).sendKeys(startingDate);
        return this;

    }

    @Step("Select ending date: {endingDate}")
    public CopyMoveDeleteFrame selectEndingDate(String endingDate) {
        log.info("Select ending date: " + endingDate);
        driver.findElement(END_DATE_INPUT).clear();
        driver.findElement(END_DATE_INPUT).sendKeys(endingDate);
        return this;

    }

    @Step("Click complete delete button")
    public CopyMoveDeleteFrame completeDeleteClick() {
        log.info("Click complete delete");
        driver.findElement(COMPLETE_DELETE_BUTTON).click();
        return this;
    }

    @Step("Click continue ")
    public CopyMoveDeleteFrame clickContinue() {
        log.info("Click continue");
        driver.findElement(CONTINUE_BUTTON).click();
        return this;
    }

}
