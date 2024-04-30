package org.example.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest extends BaseTest {

        @Test
        public void loginTest() throws IOException {
            getDriver().get("http://automationpractice.com/");
            LoginPage login = new LoginPage(getDriver());

            //valid email and valid password
            String user = login.doLogin("test_viva@test.com", "123456");
            Assert.assertEquals(user, "viva test");

        }

    }

