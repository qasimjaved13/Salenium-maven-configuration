package Runner;

import Base.ExtentReportUtils;
import com.aventstack.extentreports.gherkin.model.Feature;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static Base.BaseUtils.features;

import java.io.IOException;


public class Listeners implements ITestListener {

    ExtentReportUtils extentreport = new ExtentReportUtils();

    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult result) {

        try {
            extentreport.ExtentreportScreenshot();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

        System.out.println("Start listeners");
        extentreport.Extentreport();

        //todo:Hardcoding the feature name
        features = extentreport.extents.createTest(Feature.class, "Login Feature of Neovare Application");
    }

    @Override
    public void onFinish(ITestContext context) {

        extentreport.flushReport();

    }
}
