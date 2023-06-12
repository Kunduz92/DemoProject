package com.test.katalon.tests;

import com.test.katalon.utils.BrowserUtils;
import com.test.katalon.utils.ConfigReader;
import com.test.katalon.utils.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {

    public WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = DriverHelper.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(ConfigReader.readProperty("QA_katalon_url"));
    }

    @AfterMethod
    public void tearDown(){
        BrowserUtils.getScreenShot(driver,"katalon");
        driver.quit();
    }







}
