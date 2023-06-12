package com.test.katalon.pages;

import com.test.katalon.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(name = "username")
    WebElement userName;

    @FindBy(xpath = "//input[@id='txt-password']")
    WebElement password;

    @FindBy(xpath = "//button[@id='btn-login']") //if I put # it means id in css --- . means class in css
    WebElement loginButton;


    public void login(){
        userName.sendKeys(ConfigReader.readProperty("QA_username"));
        password.sendKeys(ConfigReader.readProperty("QA_password"));
        loginButton.click();



    }


}
