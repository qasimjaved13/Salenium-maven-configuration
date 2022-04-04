package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy(how = How.ID,using = "txtUsername")
    public WebElement txtusername;

    @FindBy(how = How.ID,using = "txtPassword")
    public WebElement txtpassword;

    @FindBy(how = How.ID,using = "btnLogin")
    public WebElement btnlogin;

    public void Login(String userName, String passWord){
        txtusername.sendKeys(userName);
        txtpassword.sendKeys(passWord);
    }

    public void clickLoginButton(){
        btnlogin.submit();
    }

}
