package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BrowserUtils;
import utils.Driver;

public class CreateCarPage extends BasePage {
    @FindBy(css = "[id^='custom_entity_type_LicensePlate']")
    public WebElement licensePlateElement;

    @FindBy(name = "custom_entity_type[Driver]")
    public WebElement driverElement;

    @FindBy(name = "custom_entity_type[Location]")
    public WebElement locationElement;

    @FindBy(css = "[class='btn btn-success action-button']")
    public WebElement saveAndCloseButtonElement;

    @FindBy(css = "div[id*='FuelType']")
    public WebElement fuelTypeElement;

    //if this locator doesn't work, use [id^='uniform-custom_entity_type_Logo_file'] > span[class='action']
    @FindBy(name = "custom_entity_type[Logo][file]")
    public WebElement logoElement;

    @FindBy(name = "custom_entity_type[ChassisNumber]")
    public WebElement chassisElement;

    @FindBy(name = "custom_entity_type[ModelYear]")
    public WebElement modelYearElement;

    @FindBy(id = "select2-drop-mask")
    public WebElement transmissionElement;

    @FindBy(xpath = "//div[contains(text(),'Automatic')]")
    public  WebElement automatic;



    /**
     * This method stands for selecting tags
     * Provide tag name to select
     * If checkbox already selected, it will not do anything
     *
     * @param tagName - represents name of tag that has to be selected, like Junior, Senior or Purchased
     * @return webelement of checkbox that was selected
     * <p>
     * CreateCarPage createCarPage = new CreateCarPage();
     * <p>
     * createCarPage.selectTags("Senior"); // Senior tag will be selected
     */
    public WebElement selectTags(String tagName) {
        //locator for checkbox is based on label name
        //label and checkbox are siblings
        String locator = "//label[text()='" + tagName + "']/preceding-sibling::input[@type='checkbox']";
        WebElement checkBox = Driver.get().findElement(By.xpath(locator));
        BrowserUtils.waitForVisibility(checkBox, 15);
        BrowserUtils.waitForClickablility(checkBox, 15);
        if (!checkBox.isSelected()) {
            checkBox.click();
        }
        return checkBox;
    }

    /**
     * Select fuel type by visible text
     *
     * @param fuelType - Diesel, Electric, Hybrid
     *  <p>
     *  usage: CreateCarPage createCarPage = new CreateCarPage();
     *  <p>
     *  to select gasoline type
     *  createCarPage.selectFuelType("Diesel"); - if you want to select Diesel as fuel type
     */
    public void selectFuelType(String fuelType) {
        String locator = "//div[@class='select2-result-label' and text()='" + fuelType + "']";
        BrowserUtils.waitForClickablility(fuelTypeElement, 15);
        fuelTypeElement.click();
        WebElement fuelTypeSelectionElement = Driver.get().findElement(By.xpath(locator));
        BrowserUtils.waitForClickablility(fuelTypeSelectionElement, 15);
        fuelTypeSelectionElement.click();
    }

    /**
     * This method will upload a file
     * File from your computer!
     * @param pathToTheFile that you want to upload
     */
    public void uploadLogo(String pathToTheFile){
        BrowserUtils.waitForVisibility(logoElement, 15);
        logoElement.sendKeys(pathToTheFile);
    }
    public void setLocation(String location){
        BrowserUtils.waitForVisibility(locationElement,10);
        locationElement.sendKeys(location);

    }
    public void setChassis(String chassisNo){
        BrowserUtils.waitForVisibility(chassisElement,10);
        chassisElement.sendKeys(chassisNo);
    }
    public void setDriver(String setDriver){
        BrowserUtils.waitForVisibility(driverElement,10);
        driverElement.sendKeys(setDriver);
    }
    public void  setModelYear(String year){
        BrowserUtils.waitForVisibility(modelYearElement,10);
        modelYearElement.sendKeys(year);
    }
    public void selectTransmission(){
      //  act.moveByOffset(0,50);
       // BrowserUtils.clickWithJS(transmissionElement);
       // BrowserUtils.waitForVisibility(transmissionElement,10);
       // transmissionElement.click();
        //BrowserUtils.wait(2);
        //automatic.click();
       // BrowserUtils.clickWithJS(automatic);
    }

}
