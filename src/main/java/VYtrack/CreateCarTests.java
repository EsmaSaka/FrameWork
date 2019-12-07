package VYtrack;

import org.testng.annotations.Test;
import pages.CreateCarPage;
import pages.LoginPage;
import pages.VehiclesPage;
import utils.ConfigurationReader;

public class CreateCarTests extends TestBase {

    @Test(description = "Create some random car")
    public void test1(){
        extentTest = extentReports.createTest("Create a new car");

        LoginPage loginPage = new LoginPage();
        VehiclesPage vehiclesPage = new VehiclesPage();
        CreateCarPage createCarPage = new CreateCarPage();

        loginPage.login(ConfigurationReader.getProperty("userName"), ConfigurationReader.getProperty("passWord"));
        loginPage.navigateTo("Fleet", "Vehicles");

        loginPage.waitUntilLoaderMaskDisappear();

        vehiclesPage.clickToCreateACar();

        loginPage.waitUntilLoaderMaskDisappear();

        createCarPage.licensePlateElement.sendKeys("Random");
        createCarPage.selectTags("Compact");
        createCarPage.selectFuelType("Diesel");

        loginPage.waitUntilLoaderMaskDisappear();
        createCarPage.saveAndCloseButtonElement.click();

        extentTest.pass("New car was created");
    }
}