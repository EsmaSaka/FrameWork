package tests.day15_PropertiesFile;

 /*  public class cnfig {
    import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConfigurationReader;
    public class ConfigReaderTest {
        //    #BROWSER TYPE | it's a comment
//    #key=value, it's like a Map in java
//    browser=chrome
//
//#URL OF OUR WEB APPLICATION
//    url=https://qa1.vytrack.com/
//
//    #CREDENTIALS
//    user_name=storemanager85
//    password=UserUser123
        @Test
        public void test1(){
            String expectedBrowser = "chrome";
            //we write keys in "key" as a string
            //as return, you will get value
            //key=value
            //property name = value
            //we don't change property names, we change values
            //the idea is change in the one place, and affect entire framework
            //lets say every class will read browser type from properties file
            //and to perform cross-browsing testing, we can easily change value of browser property
            String actualBrowser = ConfigurationReader.getProperty("browser");
            Assert.assertEquals(actualBrowser, expectedBrowser);
            //read value of url property
            System.out.println("URL: "+ConfigurationReader.getProperty("url"));
            //read value of user_name property
            System.out.println("Username: "+ConfigurationReader.getProperty("user_name"));
            //read value of password property
            String password = ConfigurationReader.getProperty("password");
            System.out.println("Password: "+password);
        }
    }
    /////////////////////////////////
    import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
    //ConfigurationReader.configFile.getProperty("browser") direct access
//ConfigurationReader.getProperty("browser")
    public class ConfigurationReader {
        //this class will be responsible for loading properties file and will provide access
        //to values based on key names
        //we use Properties class to load custom .properties files
        private static Properties configFile;
        static {
            try {
                //provides access to file
                //try/catch block stands for handling exceptions
                //if exception occurs, code inside a catch block will be executed
                //any class that is related to InputOutput produce checked exceptions
                //without handling checked exception, you cannot run a code
                FileInputStream fileInputStream = new FileInputStream("configuration.properties");
                //initialize properties object
                configFile = new Properties();
                //load configuration.properties file
                configFile.load(fileInputStream);
            } catch (IOException e) {
                System.out.println("Failed to load properties file!");
                e.printStackTrace();
            }
        }
        public static String getProperty(String key) {
            return configFile.getProperty(key);
        }
    }






}    */
