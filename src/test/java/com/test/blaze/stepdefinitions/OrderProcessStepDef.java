package com.test.blaze.stepdefinitions;

import com.test.blaze.pages.CartPage;
import com.test.blaze.pages.MainPage;
import com.test.blaze.pages.PlaceOrderPage;
import com.test.blaze.pages.ProductPage;
import com.test.katalon.utils.ConfigReader;
import com.test.katalon.utils.DriverHelper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class OrderProcessStepDef {

    WebDriver driver = DriverHelper.getDriver();
    MainPage mainPage = new MainPage(driver);
    ProductPage productPage = new ProductPage(driver);
    CartPage cartPage = new CartPage(driver);
    PlaceOrderPage placeOrderPage = new PlaceOrderPage(driver);

    @Given("User navigates to the Blaze website")
    public void user_navigates_to_the_blaze_website() {
    driver.get(ConfigReader.readProperty("QA_blaze_url"));

    }
    @When("User clicks the category {string} and choose the items {string}")
    public void user_clicks_the_category_and_choose_the_items(String category, String item) throws InterruptedException {
        mainPage.chooseCategory(category);
        mainPage.chooseItem(item);

    }
    @When("User validates the {string} and {string} from alert pop-up after clicking Add to cart button")
    public void user_validates_the_and_from_alert_pop_up_after_clicking_add_to_cart_button(String expectedHeader, String expectedMessage) throws InterruptedException {
        Assert.assertEquals(expectedHeader, productPage.actualHeader());
        productPage.validateAddingProduct(driver, expectedMessage);

    }
    @When("User clicks Cart button and validates the {string} and {string} then clicks Place Order button")
    public void user_clicks_cart_button_and_validates_the_and_then_clicks_place_order_button(String expectedTitle, String expectedPrice) {
        mainPage.clickCartBtn();
        cartPage.validateInfo(expectedTitle, expectedPrice);
        cartPage.clickPlaceOrderBtn();

    }
    @When("User provides the information {string},{string},{string},{string},{string},{string} and click Purchase Button")
    public void user_provides_the_information_and_click_purchase_button(String name, String country, String city, String creditCard, String month, String year) throws InterruptedException {
        placeOrderPage.provideOrderInfo(name, country, city, creditCard, month, year);


    }
    @Then("User validates the massage {string} and {string}")
    public void user_validates_the_massage_and(String expectedMessage, String expectedUrl) {
        placeOrderPage.validateSuccessfulMessage(expectedMessage);
        Assert.assertEquals(driver.getCurrentUrl(),expectedUrl);
        placeOrderPage.clickOk();


    }




    @When("User clicks the category and choose the items")
    public void user_clicks_the_category_and_choose_the_items(DataTable dataTable) throws InterruptedException {
        Map<String, String> product = dataTable.asMap(); //category=Laptops, item=Macbook air
        mainPage.chooseCategory(product.get("category"));
        mainPage.chooseItem(product.get("item"));

    }

    @Then("User validates the message  and url")
    public void user_validates_the_message_and_url(DataTable dataTable) {
        List<String> messageAndUrl = dataTable.asList(); //message,url
        placeOrderPage.validateSuccessfulMessage(messageAndUrl.get(0));
        Assert.assertEquals(messageAndUrl.get(1), driver.getCurrentUrl());


    }

}
