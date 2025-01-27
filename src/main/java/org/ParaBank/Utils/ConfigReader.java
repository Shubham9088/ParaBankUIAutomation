package org.ParaBank.Utils;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class ConfigReader {

    private static Properties property;

    static{
        try {
            FileInputStream fs=new FileInputStream("src/main/java/org/ParaBank/TestData/ParaBank.properties");
            property =new Properties();
            property.load(fs);

        }catch(IOException e){
            e.printStackTrace();
        }
    }


    public static String getProperty(String key){
        String envValue=System.getenv(key);
        if(envValue!=null){
            return envValue;
        }
        return property.getProperty(key);
    }

}
