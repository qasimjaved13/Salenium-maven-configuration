package Base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ExtentReportUtils extends BaseUtils {

    String filename = ReportLocation + "extentreport.html";


    public void Extentreport() {

        extents = new ExtentReports();
        ExtentSparkReporter htmlreporter = new ExtentSparkReporter(filename);
        htmlreporter.config().setTheme(Theme.DARK);
        htmlreporter.config().setDocumentTitle("Test Report for loginfeature");
        htmlreporter.config().setEncoding("utf-8");
        htmlreporter.config().setReportName("Neovare Test Report");

        extents.attachReporter(htmlreporter);
    }

    public void ExtentreportScreenshot() throws IOException {
        var src = ((TakesScreenshot) Driver).getScreenshotAs(OutputType.FILE);
        Files.copy(src.toPath(), new File(ReportLocation + "screenshot.png").toPath());
        ScenariosDef.fail("details").addScreenCaptureFromPath(ReportLocation + "screenshot.png");
    }

    public void flushReport() {
        extents.flush();
    }

}
