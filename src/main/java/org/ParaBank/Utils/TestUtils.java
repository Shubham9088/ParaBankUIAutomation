package org.ParaBank.Utils;

import org.ParaBank.Locators.Locator;
import org.ParaBank.Locators.LocatorsUtils;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class TestUtils {

    public static WebDriverWait waitForElement(){
        return  new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(60));
    }

    public static void clickOnHyperLink(String Text){
        try{
            WebElement element=waitForElement().until(ExpectedConditions.elementToBeClickable(LocatorsUtils.getLocatorByHref(Text)));
            element.click();
        }catch (TimeoutException e){
            System.err.println("Timeout: Unable to find the hyperlink"+ Text);
            e.printStackTrace();
        }
        catch(Exception e){
            System.err.println("Error: Unable to click the hyperlink:"+ Text);
            e.printStackTrace();
        }
    }

    public static void fillInputBox(String ID,String Text){
        try{
            WebElement element=waitForElement().until(ExpectedConditions.elementToBeClickable(LocatorsUtils.getLocatorById(ID)));
            element.sendKeys(Text);
        }catch (TimeoutException e){
            System.err.println("Timeout: Unable to find the input Element"+ Text);
            e.printStackTrace();
        }
        catch(Exception e){
            System.err.println("Error: Unable to click the input Element:"+ Text);
            e.printStackTrace();
        }
    }

    public static void clickButton(String type, String value){
        try{
            WebElement element=waitForElement().until(ExpectedConditions.elementToBeClickable(LocatorsUtils.getLocatorByTypeAndValue(type,value)));
            element.click();
        } catch (TimeoutException e) {
            System.err.println("TimeOut: Unable to find the button:"+value);
        }catch (Exception e){
            System.err.println("Element: Unable to click the button:"+value);
        }
    }

    public static void registerNewUser(String firstName, String lastName, String address, String city, String state, String zipCode, String phoneNumber, String ssn, String username, String password, String cnfPassword) {
        clickOnHyperLink(Locator.Registration_HyperLink);
        fillInputBox(Locator.Registration_FirstName, firstName);
        fillInputBox(Locator.Registration_LastName,lastName);
        fillInputBox(Locator.Registration_Address,address);
        fillInputBox(Locator.Registration_City,city);
        fillInputBox(Locator.Registration_State,state);
        fillInputBox(Locator.Registration_Zipcode,zipCode);
        fillInputBox(Locator.Registration_PhoneNo,phoneNumber);
        fillInputBox(Locator.Registration_SSN,ssn);
        fillInputBox(Locator.Registration_Username,username);
        fillInputBox(Locator.Registration_Password,password);
        fillInputBox(Locator.Registration_ConformPassword,cnfPassword);
        clickButton(Locator.Button_Type,Locator.Registration_BtnType);
    }

    public static void verifyText(String text){
        WebElement element=waitForElement().until(ExpectedConditions.elementToBeClickable(LocatorsUtils.LocatorByText(text)));
        Assert.assertEquals(element.getText(),text);
    }
}
