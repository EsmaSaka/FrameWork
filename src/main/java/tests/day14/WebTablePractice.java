package tests.day14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTablePractice {
    WebDriver driver;
    private WebDriverWait wait;
    @BeforeMethod
    public void setup(){
       driver= BrowserFactory.getDriver("chrome");
       driver.get("http://practice.cybertekschool.com/tables");
       driver.manage().window().maximize();
      // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
       wait=new WebDriverWait(driver,30);
       wait.until(ExpectedConditions.presenceOfElementLocated(By.id("table1")));


    }
    @Test(description = "get text of table1")
    public  void  test1(){
        WebElement table = driver.findElement(By.id("table1"));
        table.getText();
    }

    @Test(description = "verify that number of columns is 6 in the first table")
    public  void test2(){

        WebElement table = driver.findElement(By.id("table1"));
       int actualColNum= driver.findElements(By.xpath("//table[@id='table1']//th")).size();
       int expectedColNum=6;
        Assert.assertEquals(actualColNum,expectedColNum);

    }
    @Test(description = "Verify that row count is 5")
    public  void  test3(){
        int expected=5;
        int actual= driver.findElements((By.xpath("//table[@id='table1']//tr"))).size();
        Assert.assertEquals(actual,expected);
    }
    @Test(description = "print all values from 2nd row(excluding table header)")
    public void test4(){
      //  WebElement secRow= driver.findElement(By.xpath("//table[@id='table1']//tr[2]"));
     //   System.out.println( secRow.getText());
        int index=1; // bu da bi yolu  2. index 2. rowa isaret eder
        List<WebElement> row=driver.findElements(By.xpath("//table[@id='table']//tbody//tr[2]//td"));
                                                    // //table[@id='table1']//tbody//tr[" + index + "]//td"
        for(WebElement cell : row)
            System.out.println(cell.getText());


    }
    @Test(description = "Print all values from the 2nd row (excluding table header)")
    public void test5() {
        List<WebElement> row = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr[2]//td"));
        for (WebElement cell : row) {
            System.out.println(cell.getText());
        }
    }
    @Test(description = "Verify that email in the third row is equals to jdoe@hotmail.com")
    public void test6(){
        int row = 3; //represents row number
        int column = 3;//represents column number
        //combination of tr and td index will give us specific cell value
        WebElement cell = driver.findElement(By.xpath("//table[@id='table1']//tbody//tr["+row+"]//td["+column+"]"));
        String expectedEmail = "jdoe@hotmail.com";
        String actualEmail = cell.getText();
        Assert.assertEquals(actualEmail, expectedEmail);
    }
    @Test(description = "verify that all email addresses have  @ ")
    public void test7() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("table1")));
        List<WebElement> emails = driver.findElements(By.xpath("//table[@id='table1']//tr//td[3]"));
                                        // we can skip tr as we need  data from all rows
        int index=1;
        for(WebElement eachEmail:emails){
            Assert.assertTrue(eachEmail.getText().contains("@"),"Test 7: Failed (there is not @ in the email)");
            System.out.println(eachEmail.getText());
            System.out.println("Test 7: email "+index+ " Passed");
            System.out.println("===============");
            index++;
        }
    }


    @AfterMethod
    public void teardown(){
        driver.quit();
    }
/*
 public static void main(String[] args) {
        // if result is less then 0, sequence of words is correct or alphabetic
        //if result is 0 - words are equals
        //if result is positive, sequence of words is opposite to alphabetic
        String word = "a"; // 97 in ascii table
        String word2 = "d";// 100 in ascii table
        // a - d = -3, 97 - 100
        //it check character by character,
        //if 1st character is the same, it compares 2
        System.out.println(word.compareTo(word2));
        System.out.println(word.compareTo(word2) < 0);
    }
 */

}
