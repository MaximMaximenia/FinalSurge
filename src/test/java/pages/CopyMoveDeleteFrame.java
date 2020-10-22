package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CopyMoveDeleteFrame extends BasePage {

    private static final By START_DATE_INPUT = By.cssSelector("#WorkoutDateStart");
    private static final By END_DATE_INPUT = By.cssSelector("#WorkoutDateEnd");
    private static final By CONTINUE_BUTTON = By.cssSelector("#contButton");

    public CopyMoveDeleteFrame(WebDriver driver) {
        super(driver);
    }

    public void selectFunction(String function) {


    }

    public void selectStartingDate(String startingDate) {
        driver.findElement(START_DATE_INPUT).sendKeys(startingDate);

    }

    public void selectEndingDate(String endingDate) {
        driver.findElement(END_DATE_INPUT).sendKeys(endingDate);

    }

    public void clickContinue() {
        driver.findElement(CONTINUE_BUTTON).click();

    }
}
