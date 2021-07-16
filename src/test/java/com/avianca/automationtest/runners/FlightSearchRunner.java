package com.avianca.automationtest.runners;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/flight_search.feature",
        snippets = SnippetType.CAMELCASE,
        glue = "",
        tags = "@One"
)

public class FlightSearchRunner {


}
