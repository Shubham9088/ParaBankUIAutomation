package org.ParaBank.Utils;
import org.testng.Assert;
import org.ParaBank.Locators.Locator;
import org.ParaBank.Locators.LocatorsUtils;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestUtils {

    /**
     * Explicit wait -- Method to wait for the element
     *
     * @return webDriverWait
     * @autor shchak
     */
    public static WebDriverWait waitForElement() {
        return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(60));
    }

    /**
     * Method to click on hyper link
     *
     * @param Text hyper link text
     * @autor shchak
     */
    public static void clickOnHyperLink(String Text) {
        try {
            WebElement element = waitForElement().until(ExpectedConditions.elementToBeClickable(LocatorsUtils.getLocatorByHref(Text)));
            element.click();
        } catch (TimeoutException e) {
            System.err.println("Timeout: Unable to find the hyperlink" + Text);
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error: Unable to click the hyperlink:" + Text);
            e.printStackTrace();
        }
    }

    /**
     * Method to enter text in input box
     *
     * @param name @name of a locator
     * @param Text text to be entered in input box
     */
    public static void fillInputBox(String name, String Text) {
        try {
            WebElement element = waitForElement().until(ExpectedConditions.elementToBeClickable(LocatorsUtils.getLocatorByName(name)));
            element.sendKeys(Text);
        } catch (TimeoutException e) {
            System.err.println("Timeout: Unable to find the input Element" + Text);
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error: Unable to click the input Element:" + Text);
            e.printStackTrace();
        }
    }

    /**
     * Method to click on button
     *
     * @param type  type of button
     * @param value value of button
     */
    public static void clickButton(String type, String value) {
        try {
            WebElement element = waitForElement().until(ExpectedConditions.elementToBeClickable(LocatorsUtils.getLocatorByTypeAndValue(type, value)));
            element.click();
        } catch (TimeoutException e) {
            System.err.println("TimeOut: Unable to find the button:" + value);
        } catch (Exception e) {
            System.err.println("Element: Unable to click the button:" + value);
        }
    }

    /**
     * Method to register new user
     *
     * @param firstName   first name of new registered user
     * @param lastName    last name of new registered user
     * @param address     address of new registered user
     * @param city        city of new registered user
     * @param state       state of new registered user
     * @param zipCode     zip code of new registered user
     * @param phoneNumber phone number of new registered user
     * @param ssn         ssn of new registered user
     * @param username    username of new registered user
     * @param password    password of new registered user
     * @param cnfPassword conform password of new registered user
     */
    public static void registerNewUser(String firstName, String lastName, String address, String city, String state, String zipCode, String phoneNumber, String ssn, String username, String password, String cnfPassword) {
        clickOnHyperLink(Locator.Registration_HyperLink);
        fillInputBox(Locator.Registration_FirstName, firstName);
        fillInputBox(Locator.Registration_LastName, lastName);
        fillInputBox(Locator.Registration_Address, address);
        fillInputBox(Locator.Registration_City, city);
        fillInputBox(Locator.Registration_State, state);
        fillInputBox(Locator.Registration_Zipcode, zipCode);
        fillInputBox(Locator.Registration_PhoneNo, phoneNumber);
        fillInputBox(Locator.Registration_SSN, ssn);
        fillInputBox(Locator.Registration_Username, username);
        fillInputBox(Locator.Registration_Password, password);
        fillInputBox(Locator.Registration_ConformPassword, cnfPassword);
        clickButton(Locator.Button_Type, Locator.Registration_BtnName);
    }

    /**
     * Method to verify text
     * @param text text to be verified
     */
    public static void verifyText(String text) {
        WebElement element = waitForElement().until(ExpectedConditions.elementToBeClickable(LocatorsUtils.getLocatorByText(text)));
        Assert.assertEquals(element.getText(), text);
    }

    /**
     * Method to logout user from parabank
     */
    public static void logout() {
        WebElement element = waitForElement().until(ExpectedConditions.elementToBeClickable(LocatorsUtils.getLocatorByHref("Log Out")));
        try {
            element.click();
        } catch (TimeoutException e) {
            System.err.println("TimeOut: Unable to find the logout button");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error: Unable to click the logout button");
            e.printStackTrace();
        }
    }

    /**
     * login to para bank
     * @author shchak
     */
    public static void login(String username, String password) {
        WebElement usernameLoc = waitForElement().until(ExpectedConditions.elementToBeClickable(LocatorsUtils.getLocatorByName(Locator.Login_Username)));
        WebElement passwordLoc = waitForElement().until(ExpectedConditions.elementToBeClickable(LocatorsUtils.getLocatorByName(Locator.Login_Password)));
        try {
            usernameLoc.sendKeys(username);
            try {
                passwordLoc.sendKeys(password);
            } catch (Exception e) {
                System.err.println("Error: Unable to enter password");
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.err.println("Error: Unable to enter username");
            e.printStackTrace();
        }
        WebElement loginBtn = waitForElement().until(ExpectedConditions.elementToBeClickable(LocatorsUtils.getLocatorByTypeAndValue(Locator.Button_Type, Locator.Login_BtnName)));
        try {
            loginBtn.click();
        } catch (TimeoutException e) {
            System.err.println("TimeOut: Unable to find the login button");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error: Unable to click the login button");
            e.printStackTrace();
        }
    }
}