package org.example.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;

import static org.example.util.ExtentTestManager.startTest;

public class LoginTest1 extends BaseTest {


        @Test(description = "Invalid Login Scenario")
        public void loginWithInvalidEmailTest(Method method) throws IOException {
            startTest(method.getName(), "Invalid Login Scenario");
            getDriver().get("http://automationpractice.com/");
            LoginPage login = new LoginPage(getDriver());

            //invalid email and valid pass
            String lblInvalidEmail = login.loginWithInvalidPassword("viva@te.com", "123456");
            Assert.assertEquals(lblInvalidEmail, "Authentication failed.");
        }
    }

