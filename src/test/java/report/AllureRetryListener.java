package report;
import io.qameta.allure.Allure;
import utilities.RetryAnalyzer;

import org.testng.ITestListener;
import org.testng.ITestResult;
public class AllureRetryListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        if (result.getMethod().getRetryAnalyzer(result) != null) {
            int retryCount = ((RetryAnalyzer) result.getMethod().getRetryAnalyzer(result)).retryCount;
            Allure.addAttachment("Retry Count", String.valueOf(retryCount));
        }
    }
}
