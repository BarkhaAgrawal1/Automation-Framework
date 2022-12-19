package PageTestPackage;

import BasePackage.BaseClass;
import PagePackage.HomePage;
import PagePackage.LandingPage;
import PagePackage.LoginPage;
import UtilityPackage.Readxl;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginPageDDT extends BaseClass {
    HomePage hp;
    LoginPage lp;
    LandingPage land;

    public LoginPageDDT() {
        super();

    }

    @BeforeMethod
    public void setup() {
        initialization();
        hp = new HomePage(driver);
        lp = new LoginPage(driver);
        land = new LandingPage(driver);
        hp.clickLogin();
    }

    @AfterMethod
    public void Teardown() {
        driver.close();

    }

    @Test(dataProvider = "logindata")
    public void loginddt(String user, String pwd) throws InterruptedException {
        lp.loginmethod(user, pwd);
        land = new LandingPage(driver);
        land=lp.clicksubmmit();


    }

    @DataProvider(name = "logindata")
    String[][] getdata() throws IOException {
        String path = "C:\\Users\\deepa\\Documents\\Barkha new intellij\\AutomationFramework\\src\\test\\resources\\testdata.xlsx";
        int rownum = Readxl.ReadXL.getRowCount(path, "Sheet1");
        int colcount = Readxl.ReadXL.getCellCount(path, "Sheet1", 1);
        String logindata[][] = new String[rownum][colcount];
        //0 is for header..column is 0
        for (int i = 1; i <= rownum; i++) { //
            for (int j = 0; j < colcount; j++) {
                logindata[i - 1][j] = Readxl.ReadXL.getCellData(path, "Sheet1", i, j);//1  0
            }
        }
        return logindata;
    }
}











