package com.test.blaze.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/OrderProduct.feature", // ->from content route
        glue = "com/test/blaze/stepdefinitions", //-> from source route
        dryRun = false,
        tags = "@regression",
        plugin = {"pretty", "html:target/uiReport.html", "rerun:target/uiFailedTests.txt"}

)

public class Runner {




}
