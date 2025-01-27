package org.ParaBank.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverManager {

    private static WebDriver driver;

    public static void init(){
        String browser=ConfigReader.getProperty("browser");
        browser=browser.toLowerCase();
        switch(browser){
            case "chrome":
                driver=new ChromeDriver();
                break;
            case "edge":
                driver=new EdgeDriver();
                break;
            case "firefox":
                driver=new FirefoxDriver();
                break;
            case "safari":
                driver=new SafariDriver();
                break;
        }
        driver.manage().window().maximize();
    }

    public static WebDriver getDriver(){
        return driver;
    }
}
