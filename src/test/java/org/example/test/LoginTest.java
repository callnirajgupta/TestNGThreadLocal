package org.example.test;

import org.testng.Assert;

import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;

import static org.example.util.ExtentTestManager.startTest;

public class LoginTest extends BaseTest {

        @Test(description = "valid Login Scenario")
        public void loginTest(Method method) throws IOException {
            startTest(method.getName(), "valid Login Scenario");
            getDriver().get("http://automationpractice.com/");
            LoginPage login = new LoginPage(getDriver());

            //valid email and valid password
            String user = login.doLogin("test_viva@test.com", "123456");
            Assert.assertEquals(user, "viva test");

        }

    }

