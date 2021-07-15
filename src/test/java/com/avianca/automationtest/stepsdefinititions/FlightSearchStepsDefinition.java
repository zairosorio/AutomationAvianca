package com.avianca.automationtest.stepsdefinititions;


import com.avianca.automation.steps.BuyOneWayFlightStep;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.io.IOException;

public class FlightSearchStepsDefinition {

    @Steps
    BuyOneWayFlightStep formPageStep;

    @Given("^The user is on the page$")
    public void theUserIsOnThePage() throws IOException, InterruptedException {
        formPageStep.openTheBrowser();
    }

    @When("^Enter the data in the search fields$")
    public void enterTheDataInTheSearchFields() throws IOException, InterruptedException {
        formPageStep.clickReservaTuvuelo();
    }

    @When("^Search$")
    public void search() throws InterruptedException, IOException {
        formPageStep.clickButtonSearch();
    }

    @Then("^show selected flight$")
    public void showSelectedFlight() throws InterruptedException, IOException {
        formPageStep.Ticket();
        formPageStep.sendInfoPerson();
        formPageStep.validations();
        formPageStep.print();
        formPageStep.generateLog();
        formPageStep.closeDetalle();
    }

}
