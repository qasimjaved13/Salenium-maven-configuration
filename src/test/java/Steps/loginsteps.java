package Steps;


import Base.BaseUtils;
import Pages.LoginPage;
import com.aventstack.extentreports.GherkinKeyword;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class loginsteps extends BaseUtils {

    private BaseUtils base;

    public loginsteps(BaseUtils base) {
        this.base = base;
    }


    @Given("I navigate to login page")
    public void iNavigateToLoginPage() throws ClassNotFoundException {
        ScenariosDef.createNode(new GherkinKeyword("Then"), "i navigate to login page");
        System.out.println("I navigate to login page");
        base.Driver.navigate().to("http://neovare.sipisb.com/en/login");
        base.Driver.manage().window().maximize();
    }

    @And("I enter the following details for login")
    public void iEnterTheFollowingDetailsForLogin(List<List<String>> table) throws ClassNotFoundException {
        ScenariosDef.createNode(new GherkinKeyword("Then"), "i insert the login details");
        Map<String, String> mapTable = CucumberUtils.TableDictionaryConverter(table);

        String usernamevalue = mapTable.get("username");        //adminusername
        String passwordvalue = mapTable.get("password");        //adminpassword
        LoginPage page = new LoginPage(base.Driver);
        page.Login(usernamevalue, passwordvalue);
    }

    @And("i click on login button")
    public void iClickOnLoginButton() throws ClassNotFoundException {
        ScenariosDef.createNode(new GherkinKeyword("And"), "i click on login button");
        LoginPage page = new LoginPage(base.Driver);
        page.clickLoginButton();
    }

    @Then("i should see the dashboard page")
    public void iShouldSeeTheDashboardPage() throws ClassNotFoundException {

        ScenariosDef.createNode(new GherkinKeyword("Then"), "i should see dashboard page");
        Assert.assertEquals(base.Driver.getTitle(), "Test Questionnaire");
    }


    public class User {
        public String username = null;
        public String password = null;

        public User(String userName, String passWord) {
            this.username = userName;
            this.password = passWord;
        }
    }

}
