package tests.day15_PropertiesFile;

import org.testng.annotations.Test;
import tests.TestBase;
import utils.BrowserUtils;
import utils.ConfigurationReader;
import utils.Driver;

public class Login extends  TestBase {

    @Test
    public  void  test1(){
        String url= ConfigurationReader.getProperty("url");
        // Driver.get()  ==> will return webdriver object
        // and then we can call webdriver methods like get(), find element
        // WebDriver driver= Driver.get(); de yazabiliriz ama uzatmiyoruz
        Driver.get().get(url);
        System.out.println(Driver.get().getTitle());
        BrowserUtils.wait(2);
        Driver.close();
    }

    @Test
    public  void test2(){
        System.out.println(Driver.get().getTitle());
        BrowserUtils.wait(2);
    }
}
