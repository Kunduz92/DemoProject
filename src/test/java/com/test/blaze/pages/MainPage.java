package com.test.blaze.pages;

import com.test.katalon.tests.MainTest;
import com.test.katalon.utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage {

    public MainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@id='itemc']")
    List<WebElement> allCategories;

    @FindBy(xpath = "//h4[@class='card-title']")
    List<WebElement> cardTitles;

    @FindBy(linkText = "Cart")
    WebElement cartBtn;

    public void clickCartBtn(){
        cartBtn.click();
    }




    public void chooseCategory(String categoryType) throws InterruptedException {
        Thread.sleep(2000);
        for(WebElement category:allCategories){
            if(BrowserUtils.getText(category).equals(categoryType)){
                category.click();
                break;
            }
        }
    }

    public void chooseItem(String item) throws InterruptedException {
        Thread.sleep(2000);
        for (WebElement title: cardTitles){
            if(BrowserUtils.getText(title).equals(item)){
                title.click();
                    break;
                }
            }
        }

    }



