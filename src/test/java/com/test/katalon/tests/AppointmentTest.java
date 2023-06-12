package com.test.katalon.tests;

import com.test.katalon.pages.AppointmentPage;
import com.test.katalon.pages.LoginPage;
import com.test.katalon.pages.MainPage;
import com.test.katalon.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AppointmentTest extends TestBase {

    @Parameters({"expectedHeader",
            "backGroundColor",
            "facility",
            "healthcare",
            "date",
            "comment",
            "confirmationHeader",
            "readmission"})

    @Test
    public void validateMakingAppointmentProcess(String expectedHeader,
                                                 String backGroundColor,
                                                 String facility,
                                                 String healthcare,
                                                 String date,
                                                 String comment,
                                                 String confirmationHeader,
                                                 String readmission) throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        AppointmentPage appointmentPage = new AppointmentPage(driver);
        mainPage.clickAppointmentButton();
        loginPage.login();

        Assert.assertEquals(appointmentPage.validateActualHeader(),expectedHeader);
        Assert.assertEquals(appointmentPage.actualBackgroundColor(),backGroundColor);

        appointmentPage.getAnAppointment(facility, healthcare, date, comment);

        appointmentPage.validateAllInformation(driver, ConfigReader.readProperty("QA_katalon_url"),
                confirmationHeader, facility, readmission, healthcare, date, comment);


        //1.  To be able to read parameters from XML File --> You need to create @Parameters annotation
        //2. You need to provide parameters in @Parameters
        //3. You must have same order of method parameters and @Parameters parameters
        //4. You must have same name in Parameters with same name in XML FILE Parameters.


    }
















}
