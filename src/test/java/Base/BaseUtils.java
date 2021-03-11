package Base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;

public class BaseUtils {

    public static WebDriver Driver;

    public ExtentReports extents;
    public static ExtentTest ScenariosDef;
    public static ExtentTest features;
    public static String ReportLocation = "/D:/TestAutomation/Reports/";

}
