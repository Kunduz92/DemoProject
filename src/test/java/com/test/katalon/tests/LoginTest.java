package com.test.katalon.tests;

import com.test.katalon.pages.LoginPage;
import com.test.katalon.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{

    @Test
    public void validateSuccessfulLogin(){
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickAppointmentButton();
        loginPage.login(); //parameters come from configuration.properties

        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/#appointment");
        Assert.assertEquals(driver.getTitle(),"CURA Healthcare Service");






    }



}
