package org.ParaBank;
import io.qameta.allure.Description;
import org.ParaBank.Utils.ConfigReader;
import org.ParaBank.Utils.TestUtils;
import org.testng.annotations.Test;

public class RegisterUser extends BaseTest{

    @Description("Negative Test- Register user with different password and conform password")
    @Test(priority = 1)
    public void testRegisterUserWithIncorrectPassword() {
        TestUtils.registerNewUser(ConfigReader.getProperty("userFirstName"), ConfigReader.getProperty("userLastName"), ConfigReader.getProperty("userAddress"), ConfigReader.getProperty("userCity"), ConfigReader.getProperty("userState"), ConfigReader.getProperty("userZipCode"), ConfigReader.getProperty("userPhoneNo"), ConfigReader.getProperty("userSsn"), ConfigReader.getProperty("paraBankUserName"), ConfigReader.getProperty("userPassword"),"Abc@123");
        TestUtils.verifyText("Passwords did not match.");
    }

    @Description("Positive Test- Register user with valid details")
    @Test(priority = 2)
    public void testRegisterNewUser(){
        TestUtils.registerNewUser(ConfigReader.getProperty("userFirstName"),ConfigReader.getProperty("userLastName"),ConfigReader.getProperty("userAddress"),ConfigReader.getProperty("userCity"),ConfigReader.getProperty("userState"),ConfigReader.getProperty("userZipCode"),ConfigReader.getProperty("userPhoneNo"), ConfigReader.getProperty("userSsn"),ConfigReader.getProperty("paraBankUserName"),ConfigReader.getProperty("userPassword"),ConfigReader.getProperty("userPassword"));
        TestUtils.verifyText("Your account was created successfully. You are now logged in.");
    }

    @Description("Negative Test- Login user with invalid details")
    @Test
    public void Login() {
        TestUtils.login("abc","abc");
        TestUtils.verifyText("The username and password could not be verified.");
    }

}
