package org.ParaBank;
import io.qameta.allure.Description;
import org.ParaBank.Utils.ConfigReader;
import org.ParaBank.Utils.TestUtils;
import org.testng.annotations.Test;

public class RegisterUser extends BaseTest{

    @Description("Positive Test- Register user with valid details")
    @Test
    public void testRegisterNewUser(){
        TestUtils.registerNewUser(ConfigReader.getProperty("userFirstName"),ConfigReader.getProperty("userLastName"),ConfigReader.getProperty("userAddress"),ConfigReader.getProperty("userCity"),ConfigReader.getProperty("userState"),ConfigReader.getProperty("userZipCode"),ConfigReader.getProperty("userPhoneNo"), ConfigReader.getProperty("userSsn"),ConfigReader.getProperty("userName"),ConfigReader.getProperty("userPassword"),ConfigReader.getProperty("userPassword"));
        TestUtils.verifyText("Your account was created successfully. You are now logged in.");
    }
}
