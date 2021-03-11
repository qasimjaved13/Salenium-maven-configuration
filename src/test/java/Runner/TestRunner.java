package Runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;

//@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/Features", glue = "Steps",plugin = {"json:target/cucumber.json","html:target/surefire-reports/cucumber-pretty"})
public class TestRunner extends AbstractTestNGCucumberTests {


}
