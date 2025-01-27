package org.ParaBank;

import org.ParaBank.Utils.ConfigReader;
import org.ParaBank.Utils.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.sql.Driver;

public class BaseTest{

    @BeforeMethod
    public void setUp(){
        DriverManager.init();
        DriverManager.getDriver().get(ConfigReader.getProperty("baseUrl"));
    }

    @AfterMethod
    public void tearDown(){
        DriverManager.getDriver().quit();
    }
}
