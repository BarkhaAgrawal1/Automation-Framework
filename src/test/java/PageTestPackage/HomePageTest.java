package PageTestPackage;

import BasePackage.BaseClass;
import PagePackage.HomePage;
import PagePackage.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends BaseClass{

    HomePage hp;
    LoginPage pl;

    public HomePageTest(){
        super();
            }
    @BeforeMethod
    public void setup(){
    initialization();
        hp = new HomePage(driver);
    }
    @AfterMethod
    public void Teardown(){
        //driver.close();
    }

    @Test
    public void Testlogo(){
        boolean logo = hp.checklogo();
        Assert.assertTrue(logo);

    }
    @Test
    public void Testfreestudent(){
        boolean student = hp.checkfreestudent();
        Assert.assertTrue(student);

    }
    @Test
    public void verifylogin(){
        hp.clickLogin();
    }












}



