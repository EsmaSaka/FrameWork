package VYtrack;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CalenderEventsPage;
import pages.LoginPage;
import pages.TestBase;
import utils.ConfigurationReader;
import utils.Driver;

import java.util.concurrent.TimeUnit;


public class NewCalenderEventsTest extends TestBase {


    @Test(description = "Verify that page subtitle is equals to 'All Calendar Events'")
    public void test1() {
        LoginPage loginPage = new LoginPage(); //login page object
        CalenderEventsPage calenderEventPage= new CalenderEventsPage();

        loginPage.login(ConfigurationReader.getProperty("userName"), ConfigurationReader.getProperty("passWord"));
       // WebDriverWait wait= new WebDriverWait(Driver.get(),10);
       // wait.until(ExpectedConditions.invisibilityOf())
     //  loginPage.waitUntilLoaderMaskDisappear();

        loginPage.navigateTo("Activities", "Calendar Events");
      //  loginPage.waitUntilLoaderMaskDisappear();
       // calenderEventPage.clickToCreateCalendarEvent();
        String expectedSubtitle = "All Calendar Events";

        String actualSubTitle = loginPage.getPageSubTitle();

        Assert.assertEquals(actualSubTitle, expectedSubtitle);
    }
}

