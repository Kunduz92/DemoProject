package com.test.katalon.tests;

import com.test.katalon.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainTest extends TestBase{ //we have @beforemethod and @aftermethod annotations

    @Test
    public void validateUrlAndHeader(){
        MainPage mainPage = new MainPage(driver);
        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/");
        Assert.assertEquals(mainPage.actualHeader(),"CURA Healthcare Service");

    }





}
