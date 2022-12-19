package PagePackage;

import BasePackage.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {
    @FindBy(xpath = "//input[@id=\"username\"]")
    WebElement user;
    @FindBy(xpath = "//input[@id=\"password\"]")
    WebElement pass;
    @FindBy(xpath = "//button[@id=\"login\"]")
    WebElement submit;
    public  LoginPage(WebDriver driver){
        this.driver=driver;

        PageFactory.initElements(driver,this);

    }

public void loginmethod(String un,String pwd){
        user.sendKeys(un);
        pass.sendKeys(pwd);
}
    public LandingPage clicksubmmit(){
        submit.click();
        return new LandingPage(driver);
    }






}
