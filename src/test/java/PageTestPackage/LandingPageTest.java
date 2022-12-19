package PageTestPackage;

import BasePackage.BaseClass;
import PagePackage.HomePage;
import PagePackage.LandingPage;
import PagePackage.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LandingPageTest extends BaseClass {
HomePage hp;
LoginPage lp;
LandingPage land;

public LandingPageTest(){
    super();
}
@BeforeMethod
   public void setup(){
    initialization();
    hp = new HomePage(driver);
    lp = new LoginPage(driver);
    land = new LandingPage(driver);
       hp.clickLogin();
       lp.loginmethod(prop.getProperty("username"), prop.getProperty("password"));
       land = lp.clicksubmmit();
   }
   @AfterMethod
    public void teardown(){
    driver.close();
   }
   @Test
    public void Testwbl(){
    boolean wb=land.checkwbl();
       Assert.assertTrue(wb);

   }
   @Test
    public void Testmailid(){
    boolean mail=land.checkmailid();
    Assert.assertTrue(mail);

   }

}

