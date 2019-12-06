package VYtrack;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.BrowserUtils;
import utils.ConfigurationReader;
import utils.Driver;

public class LoginTests extends TestBase {
    @Test(description = "verify that page title='Dashboard'")
    public void  tes01(){
        //crate page object
        LoginPage loginPage= new LoginPage();
        // call login method
        // provide username and password


       String userName= ConfigurationReader.getProperty("userName");
       String passWord= ConfigurationReader.getProperty("passWord");
        loginPage.login(userName,passWord);
        // verification
        BrowserUtils.wait(10);
        WebDriverWait wait= new WebDriverWait(Driver.get(),10);
       wait.until( ExpectedConditions.titleIs("Dashboard"));
        Assert.assertEquals(Driver.get().getTitle(),"Dashboard");
    }

}
