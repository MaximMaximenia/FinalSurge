package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static java.lang.String.format;
import static org.testng.Assert.assertEquals;

public class PrintFrame extends BasePage {
    public PrintFrame(WebDriver driver) {
        super(driver);
    }

    private static final By STARTING_DATE = By.cssSelector("#PrintStartDate");
    private static final By ENDING_DATE = By.cssSelector("#PrintEndDate");
    private static final By PRINT_WITH_COMMENTS = By.cssSelector("#printcomments");
    private static final By PRINT_BUTTON = By.cssSelector("#saveButtonPrint");
    private static final By PRINT_FRAME = By.cssSelector("#PrintWorkoutsiFrame");
    private static final By ONE_WORKOUT = By.cssSelector(".formSep");
    private static final By PRINT_ERROR = By.cssSelector(".alert-error");
    private static final String VALIDATE_PRINT_DATES = "//span[contains(text(),'Workouts: %s - %s')]";

    private void switchToFrame() {
        driver.switchTo().frame(driver.findElement(PRINT_FRAME));
    }

    public void printErrorShouldBe(String error) {
        assertEquals(driver.findElement(PRINT_ERROR).getText(), error);
    }

    public PrintFrame fillFrame(String startingDate, String endingDate, boolean printWithComments) {
        switchToFrame();
        driver.findElement(STARTING_DATE).sendKeys(startingDate);
        driver.findElement(ENDING_DATE).sendKeys(endingDate);
        if (printWithComments) {
            driver.findElement(PRINT_WITH_COMMENTS).click();
        }
        return this;
    }

    public PrintFrame clickPrintButton() {
        driver.findElement(PRINT_BUTTON).click();
        driver.switchTo().defaultContent();
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "2");
        return this;
    }

    public void amountWorkoutsShouldBe(int expectedAmount) {

        List<WebElement> allWorkouts = driver.findElements(ONE_WORKOUT);
        assertEquals(allWorkouts.size()-1,expectedAmount);
    }

    public PrintFrame switchToLastPage() {
        for (String handle1 : driver.getWindowHandles()) {
            driver.switchTo().window(handle1);
        }
        return this;
    }

    public void validatePrintDateAndURL(String startDate, String endDate, String expectedURL) {

        driver.findElement(By.xpath(format(VALIDATE_PRINT_DATES, startDate, endDate)));
        assertEquals(driver.getCurrentUrl(), expectedURL);

    }
}
