package com.test.blaze.pages;

import com.test.katalon.utils.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    public ProductPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(tagName = "h2")
    WebElement header;

    @FindBy (xpath = "//a[.='Add to cart']")
    WebElement addToCartButton;

    public String actualHeader() throws InterruptedException {
        Thread.sleep(3000);
        return BrowserUtils.getText(header);

    }
    public void validateAddingProduct(WebDriver driver, String expectedText) throws InterruptedException {
        addToCartButton.click();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(expectedText, alert.getText().trim()); //junit assert
        alert.accept();




    }







}
