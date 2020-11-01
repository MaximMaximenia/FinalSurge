package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static java.lang.String.format;
import static org.testng.Assert.assertEquals;

@Log4j2
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

    @Step("Switch to print frame")
    private void switchToFrame() {
        log.info("Switch to print frame");
        driver.switchTo().frame(driver.findElement(PRINT_FRAME));
    }

    @Step("Check print error")
    public void printErrorShouldBe(String error) {
        log.info("Check print error");
        assertEquals(driver.findElement(PRINT_ERROR).getText(), error,"Fail check password");
    }

    public PrintFrame fillFrame(String startingDate, String endingDate, boolean printWithComments) {
        log.info("Fill frame fields:\n"+"starting date: "+startingDate+"\nending date: "+endingDate);
        switchToFrame();
        driver.findElement(STARTING_DATE).sendKeys(startingDate);
        driver.findElement(ENDING_DATE).sendKeys(endingDate);
        if (printWithComments) {
            driver.findElement(PRINT_WITH_COMMENTS).click();
        }
        return this;
    }

    @Step("Click print button")
    public PrintFrame clickPrintButton() {
        log.info("Click print button ");
        driver.findElement(PRINT_BUTTON).click();
        driver.switchTo().defaultContent();
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "2");
        return this;
    }

    @Step("Check amount workouts expected:{expectedAmount}")
    public void amountWorkoutsShouldBe(int expectedAmount) {
        log.info("Check amount workouts on print tab");
        List<WebElement> allWorkouts = driver.findElements(ONE_WORKOUT);
        assertEquals(allWorkouts.size() - 1, expectedAmount,"Fail check amount workouts");
    }

    @Step("Switch to last tab")
    public PrintFrame switchToLastPage() {
        log.info("Switch to last tab");
        for (String handle1 : driver.getWindowHandles()) {
            driver.switchTo().window(handle1);
        }
        return this;
    }

    @Step("Check print date: {startDate}-{endDate},url: {expectedURL}")
    public void validatePrintDateAndURL(String startDate, String endDate, String expectedURL) {
        log.info("Validate print date("+startDate+"-"+endDate+") and URL");

        driver.findElement(By.xpath(format(VALIDATE_PRINT_DATES, startDate, endDate)));
        assertEquals(driver.getCurrentUrl(), expectedURL,"Fail check URL");

    }
}
