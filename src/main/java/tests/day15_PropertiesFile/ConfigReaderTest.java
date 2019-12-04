package tests.day15_PropertiesFile;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConfigurationReader;

public class ConfigReaderTest {

    @Test
    public void test01(){
        String expectedBrowser="chrome";
        String actualBrowser= ConfigurationReader.getProperty("browser");
        Assert.assertEquals(actualBrowser,expectedBrowser);
        System.out.println("Browser : "+ConfigurationReader.getProperty("browser"));
        System.out.println("Url : "+ConfigurationReader.getProperty("url"));
        System.out.println("UserName : "+ConfigurationReader.getProperty("userName"));
        System.out.println("PassWord : "+ConfigurationReader.getProperty("passWord"));
    }

}
