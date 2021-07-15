package com.avianca.automation.steps;

import com.avianca.automation.models.DataInjection;
import com.avianca.automation.pageobjets.RoundTripPage;
import com.avianca.automation.utils.Times;
import net.thucydides.core.annotations.Step;

import java.io.IOException;


public class RoundTripStep {

    RoundTripPage idaVuelta = new RoundTripPage();

    public RoundTripStep() throws IOException {
    }


    @Step
    public void openTheBrowser() throws InterruptedException {
        idaVuelta.open();
    }

    @Step
    public void clickReservaTuvuelo() throws IOException, InterruptedException {
        idaVuelta.clickReserva();
        Times.waitFor(3000);
        idaVuelta.clickIdaVuelta();
        idaVuelta.origen();
        Times.waitFor(3000);
        idaVuelta.destino();
        Times.waitFor(3000);
        idaVuelta.fechaIda();
    }

    @Step
    public void clickButtonSearch() throws InterruptedException, IOException {
        idaVuelta.clickBuscar();
    }

    @Step
    public void Ticket() throws InterruptedException {
        idaVuelta.selectTicket();
    }

    @Step
    public void sendInfoPerson() throws IOException, InterruptedException {
        idaVuelta.datosPersona();
    }

    @Step
    public void validations() throws IOException, InterruptedException {
        idaVuelta.dataValidations();
    }

    @Step
    public void print() {
        idaVuelta.printInfoVuelo();
    }

    @Step
    public void generateLog() {
        idaVuelta.fileLog();
    }

    @Step
    public void closeDetalle() throws InterruptedException, IOException {
        idaVuelta.closeWindows();

    }

}





