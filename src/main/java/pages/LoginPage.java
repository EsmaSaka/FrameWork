package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

// according to Pom design
// we have to ceate correspond ed page class
// for each page of application
// login page= login page class
//every page class will store web elements and methods..
// first create constructor to store initialize variables
public class LoginPage  extends BasePage{

    @FindBy(id="prependedInput")// this line will initialize webelement
    public WebElement userNameInput;

    @FindBy(id="prependedInput2")
    public WebElement passWordInput;
   /*
    @FindBy(id="_submit")
    public WebElement submit;   */
   @FindBy(xpath="//div[contains(text(),'Invalid user name or password.')]")
   public  WebElement WarningMessage;

    public LoginPage(){
        //it is mandatory use  constructor if you want to use @findBy annotation
        // this means login page class
        // Driver.get() return webdriver object
        PageFactory.initElements(Driver.get(),this);
    }

    public void login(String userName,String passWord){
        userNameInput.sendKeys(userName);
        passWordInput.sendKeys(passWord, Keys.ENTER);
    }

}
