package Steps;


import Base.BaseUtils;
import Pages.LoginPage;
import com.aventstack.extentreports.GherkinKeyword;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class loginsteps extends BaseUtils {

    private BaseUtils base;
    LoginPage page = new LoginPage(base.Driver);

    public loginsteps(BaseUtils base) {
        this.base = base;
    }


    @Given("I navigate to login page")
    public void iNavigateToLoginPage() throws ClassNotFoundException {
        ScenariosDef.createNode(new GherkinKeyword("Then"), "i navigate to login page");
        System.out.println("I navigate to login page");
        base.Driver.navigate().to("http://test.neovare.com/en/login");
        base.Driver.manage().window().maximize();
    }

    @And("I enter the following details for login")
    public void iEnterTheFollowingDetailsForLogin(List<List<String>> table) throws ClassNotFoundException {
        ScenariosDef.createNode(new GherkinKeyword("Then"), "i insert the login details");
        Map<String, String> mapTable = CucumberUtils.TableDictionaryConverter(table);

        String usernamevalue = mapTable.get("username");
        String passwordvalue = mapTable.get("password");
        //LoginPage page = new LoginPage(base.Driver);
        page.Login(usernamevalue, passwordvalue);
    }

    @And("i click on login button")
    public void iClickOnLoginButton() throws ClassNotFoundException {
        ScenariosDef.createNode(new GherkinKeyword("And"), "i click on login button");
        //LoginPage page = new LoginPage(base.Driver);
        page.clickLoginButton();
    }

    @Then("i should see the dashboard page")
    public void iShouldSeeTheDashboardPage() throws ClassNotFoundException {

        ScenariosDef.createNode(new GherkinKeyword("Then"), "i should see dashboard page");
        Assert.assertEquals(base.Driver.getTitle(), "Test Questionnaire");
    }

    @And("I enter the following invalid details for login")
    public void iEnterTheFollowingInvalidDetailsForLogin(List<List<String>> table) throws ClassNotFoundException {
        ScenariosDef.createNode(new GherkinKeyword("Then"), "i insert the invalid login details");
        Map<String, String> mapTable = CucumberUtils.TableDictionaryConverter(table);

        String invalidusernamevalue = mapTable.get("username");        //admin
        String invalidpasswordvalue = mapTable.get("password");        //admin
        //LoginPage page = new LoginPage(base.Driver);
        page.Login(invalidusernamevalue, invalidpasswordvalue);

    }

    @Then("I should not see the dashboard page")
    public void iShouldNotSeeTheDashboardPage() throws ClassNotFoundException {
        ScenariosDef.createNode(new GherkinKeyword("Then"), "i should not see dashboard page");
        Assert.assertEquals(base.Driver.getTitle(), "Log in!");
    }

}
