package utils;

import lombok.extern.log4j.Log4j2;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

@Log4j2
public class Retry implements IRetryAnalyzer {
    private int attempt = 1;
    private static final int MAX_RETRY = 5;

    public Retry() {
    }

    public boolean retry(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()) {
            if (this.attempt < 5) {
                ++this.attempt;
                iTestResult.setStatus(2);
                log.info("Retrying once again");
                return true;
            }

            iTestResult.setStatus(2);
        } else {
            iTestResult.setStatus(1);
        }

        return false;
    }
}
