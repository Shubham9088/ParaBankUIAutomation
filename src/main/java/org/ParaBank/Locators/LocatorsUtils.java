package org.ParaBank.Locators;

import org.openqa.selenium.By;

public class LocatorsUtils {

    public static By getLocatorByHref(String text){
        return By.xpath(String.format("//a[text()='%s']", text));
    }

    public static By getLocatorById(String ID){
        return By.xpath(String.format("//input[@id='%s']", ID));
    }

    public static By getLocatorByTypeAndValue(String type, String value){
        return By.xpath(String.format("//input[@type='%s' and @value='%s']",type,value));
    }

    public  static  By LocatorByText(String text){
        return By.xpath(String.format("//*[contains(text(),'%s')]",text));
    }
}
