package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DeviceUploadTest extends BaseTest {

    @DataProvider(name = "Text About Company")
    public Object[][] textAboutCompany() {
        return new Object[][]{
                {"GC", "The Garmin Connect Sync feature allows you to link your Garmin Connect and Final Surge accounts. Once you have linked your accounts, any workout that is uploaded to Garmin Connect will automatically be synced to your Final Surge account. If you choose to sync your accounts, you will no longer have to upload workouts to Final Surge as they will automatically appear in your training log once they have been sent to Garmin Connect."},
                {"Strava", "The Strava Sync feature allows you to link your Strava and Final Surge accounts. Once you have linked your accounts, any workout that is uploaded to Strava will automatically be synced to your Final Surge account and appear on your training calendar."},
                {"Polar", "The Polar Flow Sync feature allows you to link your Polar Flow and Final Surge accounts. Once you have linked your accounts, any workout that is uploaded to Polar Flow will automatically be synced to your Final Surge account and appear on your training calendar."},
                {"UACF", "The Under Armour Connected Fitness Sync feature allows you to link your Under Armour Connected Fitness (UA Record, Endomondo, MyFitnessPal, MapMyFitness) and Final Surge accounts. Once you have linked your accounts, any workout that is uploaded to Under Armour Connected Fitness will automatically be synced to your Final Surge account and appear on your training calendar."},
        };
    }

    @DataProvider(name = "Company Links")
    public Object[][] companyLinks() {
        return new Object[][]{
                {"GC", "https://connect.garmin.com/"},
                {"Strava", "https://www.strava.com/login"},
                {"Polar", "https://flow.polar.com/"},
                {"UACF", "https://www.mapmyfitness.com/"}
        };
    }

    @Test(dataProvider = "Text About Company")
    public void checkTextAboutCompany(String companyName, String textAboutCompany) {
        loginSteps
                .login("masya@mail.ru", "1234321MAks__", false);
        deviceUploadPage
                .toDeviceUploadPage()
                .clickButtonByCompanyName(companyName)
                .textAboutCompanyShouldBe(textAboutCompany);
    }

    @Test(dataProvider = "Company Links")
    public void checkCompanyLink(String companyName, String companyURL) {

        loginSteps
                .login("masya@mail.ru", "1234321MAks__", false);
        deviceUploadPage
                .toDeviceUploadPage()
                .clickButtonByCompanyName(companyName)
                .toCompanySiteAndValidateURL(companyURL);
    }

}
