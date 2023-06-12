package com.test.blaze.pages;

import com.test.katalon.utils.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PlaceOrderPage {
    public PlaceOrderPage(WebDriver driver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(xpath = "//input[@id='name']")
    WebElement name;

    @FindBy(xpath = "//input[@id='country']")
    WebElement country;

    @FindBy(xpath = "//input[@id='city']")
    WebElement city;

    @FindBy(xpath = "//input[@id='card']")
    WebElement creditCard;

    @FindBy(xpath = "//input[@id='month']")
    WebElement month;

    @FindBy(xpath = "//input[@id='year']")
    WebElement year;

    @FindBy(xpath = "//button[.='Purchase']")
    WebElement purchaseBtn;

    @FindBy(xpath = "//h2[.='Thank you for your purchase!']")
    WebElement successfulMessage;

    @FindBy(xpath = "//button[.='OK']")
    WebElement okBtn;

    public void clickOk(){
        okBtn.click();
    }

    public void provideOrderInfo(String name, String country,
                                 String city, String creditCard,
                                 String month, String year) throws InterruptedException {

        Thread.sleep(5000);
        this.name.sendKeys(name);
        this.country.sendKeys(country);
        this.city.sendKeys(city);
        this.creditCard.sendKeys(creditCard);
        this.month.sendKeys(month);
        this.year.sendKeys(year);
        Thread.sleep(3000);

        purchaseBtn.click();

    }

    public void validateSuccessfulMessage(String message){
        Assert.assertEquals(BrowserUtils.getText(successfulMessage), message);


    }


}
