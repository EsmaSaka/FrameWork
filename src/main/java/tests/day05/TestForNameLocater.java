package tests.day05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;

public class TestForNameLocater {
        public static void main(String[] args) {
            WebDriver driver= BrowserFactory.getDriver("chrome");
            driver.get("http://practice.cybertekschool.com/sign_up");
            driver.manage().window().maximize();
            driver.findElement(By.name("full_name")).sendKeys("Esma");
            driver.findElement(By.name("email")).sendKeys("1234@gmail.com");
            driver.findElement(By.name("wooden_spoon")).submit();
            //driver.close();
            String ActualText=driver.findElement(By.name("signup_message")).getText();
            String ExpectedText="Thank you for signing up. Click the button below to return to the home page.";
            if(ActualText.equals(ExpectedText)){
                System.out.println("Test Passed");
            }else{
                System.out.println("test failed");
            }



        }
}
