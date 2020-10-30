package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static java.lang.String.format;
import static org.testng.Assert.assertEquals;

public class DeviceUploadPage extends BasePage {
    public DeviceUploadPage(WebDriver driver) {
        super(driver);
    }

    private static final String COMPANY_BUTTON = "//a[contains(@href,'%s') and contains(@class,'btn')]";
    private static final By ABOUT_COMPANY = By.xpath("//div[@class='w-box-content']//p");
    private static final By COMPANY_SITE = By.cssSelector("#saveButton");
    @Step("Click on company by name:{companyName}")
    public DeviceUploadPage clickButtonByCompanyName(String companyName) {
        driver.findElement(By.xpath(format(COMPANY_BUTTON, companyName))).click();
        return this;
    }
    @Step("Go to company site and check url:{ url}")
    public void toCompanySiteAndValidateURL(String url) {
        driver.findElement(COMPANY_SITE).click();
        Assert.assertTrue(driver.getCurrentUrl().contains(url));
    }
    @Step("Check text about company")
    public void textAboutCompanyShouldBe(String text) {
        assertEquals(driver.findElement(ABOUT_COMPANY).getText(), text);
    }

}