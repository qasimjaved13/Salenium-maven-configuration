package Steps;

import Base.BaseUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hook extends BaseUtils {

    private BaseUtils base;

    public Hook(BaseUtils baseutils) {
        this.base = baseutils;
    }

    @Before
    public void InitializeTest(Scenario scenario) {
        ScenariosDef = base.features.createNode(scenario.getName());
        System.out.println("Opening the browser: Chrome");
        //System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        base.Driver = new ChromeDriver();

    }

    @After
    public void TeardownTest() {

        System.out.println("teardown test");
        base.Driver.quit();
    }

}
