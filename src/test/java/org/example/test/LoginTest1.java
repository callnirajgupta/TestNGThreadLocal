package org.example.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest1 extends BaseTest {


        @Test
        public void loginWithInvalidEmailTest() throws IOException {

            getDriver().get("http://automationpractice.com/");
            LoginPage login = new LoginPage(getDriver());

            //invalid email and valid pass
            String lblInvalidEmail = login.loginWithInvalidPassword("viva@te.com", "123456");
            Assert.assertEquals(lblInvalidEmail, "Authentication failed.");
        }
    }

