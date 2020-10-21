package utils;

import io.qameta.allure.Attachment;


import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.concurrent.TimeUnit;


public class TestListener implements ITestListener {

    public void onTestStart(ITestResult iTestResult) {


    }

    public void onTestSuccess(ITestResult iTestResult) {


    }

    public void onTestFailure(ITestResult iTestResult) {

        takeScreenshot(iTestResult);
    }

    public void onTestSkipped(ITestResult iTestResult) {

    }


    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] takeScreenshot(ITestResult iTestResult) {
        ITestContext context = iTestResult.getTestContext();

        try {
            return ((TakesScreenshot) context.getAttribute("driver")).getScreenshotAs(OutputType.BYTES);
        } catch (NoSuchSessionException | IllegalStateException ex) {
            return null;
        }
    }


    private long getExecutionTime(ITestResult iTestResult) {
        return TimeUnit.MILLISECONDS.toSeconds(iTestResult.getEndMillis() - iTestResult.getStartMillis());
    }
}
