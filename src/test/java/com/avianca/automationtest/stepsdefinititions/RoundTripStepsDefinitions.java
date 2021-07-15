package com.avianca.automationtest.stepsdefinititions;
import com.avianca.automation.steps.RoundTripStep;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.io.IOException;

public class RoundTripStepsDefinitions {


    @Steps
    RoundTripStep roundtripstep;

    @Given("^user is on the page$")
    public void userIsOnThePage() throws InterruptedException, IOException {
        roundtripstep.openTheBrowser();

    }

    @When("^Enter the data$")
    public void enterTheData() throws IOException, InterruptedException {
        roundtripstep.clickReservaTuvuelo();


    }

    @When("^search flight$")
    public void searchFlight() throws IOException, InterruptedException {
        roundtripstep.clickButtonSearch();


    }

    @Then("^selected flight$")
    public void selectedFlight() throws InterruptedException, IOException {
        roundtripstep.Ticket();
        roundtripstep.sendInfoPerson();
        roundtripstep.validations();
        roundtripstep.print();
        roundtripstep.generateLog();
        roundtripstep.closeDetalle();


    }
}
