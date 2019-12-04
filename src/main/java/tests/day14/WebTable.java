package tests.day14;

import com.google.gson.internal.$Gson$Preconditions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTable {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup(){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/tables");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 15);
       // wait.until(ExpectedConditions.presenceOfElementLocated(By.id("table2")));
    }
    @Test(description = "Print table 2 data")
    public void test1(){
       // WebElement tableData= driver.findElement(By.xpath("//table[@id='table2']//tbody"));
       // System.out.println( tableData.getText());

        // asagidaki ile ayni sonuc cikti

        List<WebElement> table= driver.findElements(By.xpath("//table[@id='table2']//tbody//tr"));
        for(WebElement cell : table){
            System.out.println(cell.getText());
        }


    }
    @Test(description = "Verify that number of columns in the first table is equals to 6")
    public  void test2() {
        int expectedCol = 6;
        int actualCol = driver.findElements(By.xpath("//table[@id='table2']//th")).size();
        System.out.println(actualCol);
    }
    ////div[@class='dropdown open']//a[@class='dropdown-toggle'][contains(text(),'...')]



    @AfterMethod
    public void teardown(){
        driver.quit();
    }

}
