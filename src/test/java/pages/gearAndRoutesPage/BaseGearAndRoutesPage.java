package pages.gearAndRoutesPage;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;

import static java.lang.String.format;
import static org.testng.Assert.assertEquals;
@Log4j2
public class BaseGearAndRoutesPage extends BasePage {
    public BaseGearAndRoutesPage(WebDriver driver) {
        super(driver);
    }

    public static final By ADD_BUTTON = By.cssSelector("#saveButton");
    public static final By GEAR_ROTES_DROPDOWN = By.cssSelector("[href='Equipment.cshtml']");
    public static final String VALIDATE_SELECT = "//select[@id='%s']//option[@selected]";
    public static final By BRAND = By.xpath("//a[contains(@class,'select2-choice')]//span");
    public static final By NAME = By.cssSelector("#ShoeName");
    public static final String BRAND_SELECT = "//ul[@class='select2-results']//li//div[contains(text(),'%s')]";
    public static final By MODEL = By.cssSelector("#ShoeModel");
    public static final By COST = By.cssSelector("#ShoeCost");
    public static final By DATE_PURCHASED = By.cssSelector("#ShoeDate");
    public static final By DISTANCE_TYPE = By.cssSelector("#DistType");
    public static final By DISTANCE = By.cssSelector("#StartDist");
    public static final By NOTES = By.cssSelector("#ShoeNotes");
    public static final By DELETE_BUTTON = By.cssSelector("[title=Delete]");
    private static final By CONFIRM_DELETE = By.xpath("//a[contains(text(),'OK')]");

    protected void fillInput(By input, String text) {
        driver.findElement(input).clear();
        driver.findElement(input).sendKeys(text);
    }

    @Step("Confirm Delete")
    protected void confirmDelete() {
        log.info("Click 'OK' to delete confirm");
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(CONFIRM_DELETE)));
        driver.findElement(CONFIRM_DELETE).click();
    }

    @Step("Click Delete Button")
    public void clickDeleteAndConfirm() {
        log.info("Click delete button");
        driver.findElement(DELETE_BUTTON).click();
        confirmDelete();
    }
    @Step("Check Input: ({input})")
    protected void validateInput(By input, String expectedText) {
        log.info("Check that input: ("+input.toString()+") contains: " + expectedText);
        assertEquals(driver.findElement(input).getAttribute("value"), expectedText);
    }
    @Step("Check Input: ({input})")
    protected void validateInputWithComa(By input, String expectedText) {
        log.info("Check that input: ("+input.toString()+") contains: " + expectedText);
        String str = driver.findElement(input).getAttribute("value");
        assertEquals(str.substring(0, str.indexOf(".")), expectedText);
    }
    @Step("Check Select By Id: {selectID}")
    protected void validateSelectedOption(String selectID, String optionShouldBe) {
        log.info("Check that select by id:("+selectID+ ") have selected option: "+optionShouldBe );
        assertEquals(driver.findElement(By.xpath(format(VALIDATE_SELECT, selectID))).getText(), optionShouldBe);
    }

    protected void selectOption(By element, String option) {
        log.info("Choose for select : ("+element.toString()+") option: "+option);
        Select select = new Select(driver.findElement(element));
        select.selectByVisibleText(option);
    }
    @Step("Click Add Button")
    public void clickAddButton() {
        log.info("Click add button");
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(ADD_BUTTON)));
        driver.findElement(ADD_BUTTON).click();
    }
}
