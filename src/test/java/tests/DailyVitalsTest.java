package tests;

import io.qameta.allure.Description;
import models.DailyVitals;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DailyVitalsTest extends BaseTest {
    DailyVitals dailyVitals = DailyVitals.builder().date("11/3/2020").steps(13).caloriesConsumed(587).weight(78).weightType("kg").bodyFat(22).water(12).muscleMassType("kg").muscleMass(45).restingHr(90).hrVariability(123).sleepHours(12).totalTimeAwake(8).sleepAmount("Enough").sleepQuality("Good").stressAmount("Low").bloodPressureDiastolic(53).bloodPressureSystolic(12).healthNotes("TEST").build();
    DailyVitals dailyVitals2 = DailyVitals.builder().date("11/3/2020").steps(14).caloriesConsumed(582).weight(60).weightType("lbs").bodyFat(11).water(22).muscleMassType("lbs").muscleMass(45).restingHr(60).hrVariability(121).sleepHours(12).totalTimeAwake(8).sleepAmount("Hardly Any").sleepQuality("Poor").stressAmount("High").bloodPressureDiastolic(35).bloodPressureSystolic(21).healthNotes("TEST2").build();

    @DataProvider(name = "Sort")
    public Object[][] sort() {
        return new Object[][]{
                {"This Week", 7},
                {"Last Week", 7},
                {"This Month", 30},
                {"Last Month", 31},
                {"Past 7 Days", 7},
                {"Past 14 Days", 14},
                {"Past 30 Days", 30},
                {"Past 60 Days", 60},
                {"Past 180 Days", 180},
                {"Past 365 Days", 365},
                {"This Year", 366},
        };
    }
    @Description("Test daily vitals sort ")
    @Test(dataProvider = "Sort")
    public void sortTest(String sort, int expectedAmountDays) {
        loginSteps
                .login("masya@mail.ru", "1234321MAks__", false)
                .toDailyVitals();
        dailyVitalsPage
                .sortBy(sort)
                .amountDaysAfterSortShouldBe(expectedAmountDays);

    }
    @Description("Create and delete daily vitals")
    @Test
    public void createAndDeleteDailyVitals() {
        loginSteps
                .login("masya@mail.ru", "1234321MAks__", false)
                .toDailyVitals();
        dailyVitalsPage
                .clickAddVitals()
                .createDailyVitals(dailyVitals)
                .validateDailyVitals(dailyVitals)
                .deleteDailyVitalsByDate(dailyVitals.getDate())
                .confirmDelete()
                .validateDelete(dailyVitals.getDate());
    }
    @Description("Update and delete daily vitals")
    @Test
    public void UpdateAndDeleteDailyVitals() {
        loginSteps
                .login("masya@mail.ru", "1234321MAks__", false)
                .toDailyVitals();
        dailyVitalsPage
                .clickAddVitals()
                .createDailyVitals(dailyVitals)
                .validateDailyVitals(dailyVitals)
                .updateDailyVitalsByDate(dailyVitals.getDate(),dailyVitals2)
                .validateDailyVitals(dailyVitals2)
                .deleteDailyVitalsByDate(dailyVitals2.getDate())
                .confirmDelete()
                .validateDelete(dailyVitals.getDate());
    }
}
