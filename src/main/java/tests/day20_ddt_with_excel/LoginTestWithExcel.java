package tests.day20_ddt_with_excel;


import VYtrack.TestBase;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.Driver;
import utils.ExcelUtil;

import java.util.Map;

public class LoginTestWithExcel extends TestBase {


    @Test(dataProvider = "Credentials", description="Login with different credentials")
    public  void  loginTest(String username,String password,String firstname,String lastname,String result){
      //  if(username.equals("username")){
      //      throw new SkipException("skipped 1st row");
     //   }  else {
            extentTest = extentReports.createTest("login as" + username);
            LoginPage loginPage = new LoginPage();
            loginPage.login(username, password);
            Assert.assertEquals(Driver.get().getTitle(), "Dashboard");
            extentTest.pass("login test passed for user" + username);
     //   }

    }


    @DataProvider(name = "Credentials")
    public  static  Object[][] credentials(){
        ExcelUtil qa2 = new ExcelUtil("vytrack_testusers.xlsx","QA2-short");
       return qa2.getDataArray();
    }



    public static void main(String[] args) {
        ExcelUtil qa2 = new ExcelUtil("vytrack_testusers.xlsx","QA2-short");
        System.out.println("Row count :"+ qa2.rowCount());
        System.out.println(qa2.getColumnsNames());
        System.out.println(qa2.getDataList());
        for(Map<String,String>map:qa2.getDataList()){
          //  System.out.println(map);
            System.out.println(map.get("username"));
        }
    }

}
