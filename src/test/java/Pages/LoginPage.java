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

    @FindBy(how = How.XPATH,using = "//*[@id=\"inputEmail\"]")
    public WebElement txtusername;

    @FindBy(how = How.XPATH,using = "//*[@id=\"inputPassword\"]")
    public WebElement txtpassword;

    @FindBy(how = How.XPATH,using = "/html/body/main/div/div/div/div/div[2]/form/div[2]/button")
    public WebElement btnlogin;

    public void Login(String userName, String passWord){
        txtusername.sendKeys(userName);
        txtpassword.sendKeys(passWord);
    }

    public void clickLoginButton(){
        btnlogin.submit();
    }

}
