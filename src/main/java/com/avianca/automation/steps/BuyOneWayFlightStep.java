package com.avianca.automation.steps;

import com.avianca.automation.pageobjets.BuyOneWayFlightPage;
import com.avianca.automation.utils.Times;
import net.thucydides.core.annotations.Step;

import java.io.IOException;

public class BuyOneWayFlightStep {

    BuyOneWayFlightPage formPage = new BuyOneWayFlightPage();

    public BuyOneWayFlightStep() throws IOException {
    }

    @Step
    public void openTheBrowser() throws InterruptedException {
        formPage.open();
    }

    @Step
    public void clickReservaTuvuelo() throws IOException, InterruptedException {
        formPage.clickReserva();
        Times.waitFor(3000);
        formPage.clickIda();
        formPage.origen();
        Times.waitFor(3000);
        formPage.destino();
        Times.waitFor(3000);
        formPage.fechaIda();
    }

    @Step
    public void clickButtonSearch() throws InterruptedException, IOException {
        formPage.clickBuscar();
    }

    @Step
    public void Ticket() throws InterruptedException {
        formPage.selectTicket();
    }

    @Step
    public void sendInfoPerson() throws IOException, InterruptedException {
        formPage.datosPersona();
    }

    @Step
    public void validations() throws IOException, InterruptedException {
        formPage.dataValidations();
    }

    @Step
    public void print() {
        formPage.printInfoVuelo();
    }

    @Step
    public void generateLog() {
        formPage.fileLog();
    }

    @Step
    public void closeDetalle() throws InterruptedException {
        formPage.closeWindows();
    }

}
