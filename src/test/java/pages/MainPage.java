package pages;

import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    public static final String URN = "default.cshtml";

    public String isPageOpened() {
        return driver.getCurrentUrl();
    }

}
