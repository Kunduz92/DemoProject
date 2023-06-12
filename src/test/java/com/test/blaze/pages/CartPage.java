package com.test.blaze.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.Arrays;
import java.util.List;

public class CartPage {
    public CartPage(WebDriver driver){
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(xpath = "//tr//td") // 4 elements
    List<WebElement> productInfo;

    @FindBy(xpath = "//button[.='Place Order']")
    WebElement placeOrderBtn;

    public void validateInfo(String titleOfProduct, String price){
        List<String> expectedInfo = Arrays.asList("", titleOfProduct, price, "");
        for (int i = 1; i < productInfo.size()-1; i++) {
            Assert.assertEquals(expectedInfo.get(i), productInfo.get(i).getText().trim() );

        }

    }
    public void clickPlaceOrderBtn(){
        placeOrderBtn.click();
    }




}
