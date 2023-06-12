package com.test.katalon.pages;

import com.test.katalon.utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class AppointmentPage {

    public AppointmentPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//h2")
    WebElement header;

    @FindBy(xpath = "//select[@id='combo_facility']")
    WebElement facility;

    @FindBy(id = "chk_hospotal_readmission")
    WebElement readMission;

    @FindBy(xpath = "//input[@type='radio']") //3 radio buttons
    List<WebElement> allRadioButtons;

    @FindBy(name = "visit_date")
    WebElement date;

    @FindBy(id = "txt_comment")
    WebElement comment;

    @FindBy(xpath = "//button[contains(text(),'Book Appointment')]")
    WebElement bookAppointmentButton;

    @FindBy(xpath = "//section[@id='appointment']")
    WebElement section;

    @FindBy(tagName = "h2")
    WebElement confirmationHeader;

    @FindBy(xpath = "//div[@class='col-xs-8']//p") // 5 elements
    List<WebElement> allConfirmationInfo;

    @FindBy(linkText = "Go to Homepage") // linkText has a tag and text
    WebElement homePageButton;


    public String validateActualHeader(){
        return BrowserUtils.getText(header);
    }

    public String actualBackgroundColor(){
        return section.getCssValue("background-color");
    }

    public void getAnAppointment(String facilityText, String healthCareProgram, String date, String comment) throws InterruptedException {
        Select forFacility = new Select(facility);
        Thread.sleep(3000);
        forFacility.selectByVisibleText(facilityText);
        readMission.click();
        Thread.sleep(3000);
        Assert.assertTrue(readMission.isSelected());

        for(WebElement radioButton: allRadioButtons){
            if(radioButton.getAttribute("value").equals(healthCareProgram)) {
                radioButton.click();
                break;
            }
        }

        Thread.sleep(3000);
        this.date.sendKeys(date);
        Thread.sleep(3000);
        this.comment.sendKeys(comment);
        Thread.sleep(3000);
        bookAppointmentButton.click();
    }

    public void validateAllInformation(WebDriver driver, String expectedUrl, String expectedHeader, String facility, String readmission, String healthcare, String date, String comment){
        Assert.assertEquals(BrowserUtils.getText(confirmationHeader), expectedHeader);
        List<String> expectedInformation = Arrays.asList(facility, readmission, healthcare, date, comment);

        for(int i = 0; i < allConfirmationInfo.size(); i++){
            Assert.assertEquals(allConfirmationInfo.get(i).getText().trim(), expectedInformation.get(i));
        }

        homePageButton.click();
        Assert.assertEquals(driver.getCurrentUrl(),expectedUrl);



    }




}
