package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    // this class will be responsible for loading properties file and will provide access
    // to values baased on key names

    private static Properties configFile;
    // this class stands for loading costom properties file and reading it

    static{
        try {
            // provide access to file
            // try / catch block stand for handling exceptions
            // if exception occurs, code inside a catch block  will be executed
            // any class that is related to IO  (inputOutput) produce checked exceptions
            // without handling checked exceptions, you can not run code
            FileInputStream  fileInputStream = new FileInputStream("configuration.properties");
            configFile= new Properties();
            // load your properties file
            configFile.load(fileInputStream);
            fileInputStream.close();

        } catch (IOException e) {
            System.out.println("file is not loaded");
            e.printStackTrace();
        }

    }

    public static  String getProperty(String key){
        return  configFile.getProperty(key);
    }






}
