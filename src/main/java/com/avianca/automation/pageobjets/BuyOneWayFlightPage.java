package com.avianca.automation.pageobjets;

import com.avianca.automation.models.DataInjection;
import com.avianca.automation.utils.DataExcel;
import com.avianca.automation.utils.Javascript;
import com.avianca.automation.utils.SpecialMetods;
import com.avianca.automation.utils.Times;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;


@DefaultUrl("https://www.avianca.com/co/es/")

public class BuyOneWayFlightPage extends PageObject {

    DataInjection dataInjection = new DataInjection();

    public By reserveClick = By.id("reservatuvuelo");
    public By oneWayClick = By.xpath("//a[contains(text(), 'Solo ida')]");
    public By selectOriginInput = By.xpath("//div[@class='form-group new-animate  new-focus']//input[@aria-required  and not(@aria-invalid)]");
    public By selectDestinationInput = By.xpath("(//div[@class='form-group new-animate ' or @class='form-group new-animate  new-focus']//input[@type='text'])[last()]");
    public By calendarClickIda = By.xpath("//div/input[@class='form-control solo-ida x-mvvm' or @class='form-control solo-ida x-mvvm valid']");
    public By selectDayIda = By.xpath("//div[contains(@id,'ida_regreso_1')]//div[@data-day='" + dataInjection.getDateIda()+"']");
    public By goButton = By.xpath("(//button[@class='btn primary btn-codepromo pull-btn rojo'])[last()]");
    public By selectFlightClick = By.xpath("(//button[@class='select-cabin-button'])[3]");
    public By selectPriceClick = By.xpath("(//button[@class='ff-price-container'])[3]");
    public By confirmPriceClick = By.id("continue-btn-footer");
    public By nameInput = By.xpath("(//input[@autocomplete='given-name'])[1]");
    public By lastNameInput = By.xpath("(//input[@autocomplete='family-name'])[1]");
    public By confirmTicketClick = By.xpath("//button[@class='btn-primary passenger-btn ng-star-inserted']");
    public By emailInput = By.xpath("//input[@autocomplete='email']");
    public By phoneInput = By.xpath("//input[@autocomplete='tel-national']");
    public By termsCheckBox = By.xpath("(//div[@class='mat-checkbox-inner-container'])[1]");
    public By saveClick = By.xpath("//button[@aria-label='Guardar y continuar']");
    public By buyClick = By.xpath("//button[@class='btn-primary continue-btn' and @id='continue-btn-footer-static']");
    public By detailValidation = By.xpath("(//button[@class='link-item'])[1]");
    public By nameValidation = By.xpath("(//div[@class='name ng-star-inserted'])[last()]");
    public By emailValidation = By.xpath("//div[contains (text(), '@')]");
    public By phoneValidation = By.xpath("//div[contains (text(), '+57 3')] ");
    public By dateOpen = By.xpath("//div[@class='bound-date']");
    public By buttonClose = By.xpath("//span[@class='close-section-name']");
    public By departure_date = By.xpath("//div[@class='location-subheader-time']");
    public By flighNumber = By.xpath("//div[@class='bound-info ng-star-inserted'][1]");
    public By totalValue = By.xpath("//div[@class='total-line price-for-all ng-star-inserted']/span[2]");

    public BuyOneWayFlightPage() throws IOException {
    }

    public void clickReserva() {
        if (getDriver().findElement(reserveClick).isDisplayed()) {
            getDriver().manage().deleteAllCookies();
            getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            getDriver().findElement(reserveClick).click();

        } else {
            System.out.println("page firth not Found");
            return;
        }

    }

    public void clickIda() throws InterruptedException {
        if (getDriver().findElement(oneWayClick).isDisplayed()) {
            getDriver().findElement(oneWayClick).click();
        } else {
            System.out.println("oneWayClick Not Found");
        }
    }

    public void origen() throws InterruptedException, IOException {
        getDriver().findElement(selectOriginInput).click();
        getDriver().findElement(selectOriginInput).sendKeys(DataExcel.getCellValue(dataInjection.getFilepath(), dataInjection.getSheetName(), 1, 0));
        getDriver().findElement(selectOriginInput).sendKeys(Keys.ARROW_DOWN);
        getDriver().findElement(selectOriginInput).sendKeys(Keys.ENTER);
    }

    public void destino() throws InterruptedException, IOException {
        getDriver().findElement(selectDestinationInput).sendKeys(DataExcel.getCellValue(dataInjection.getFilepath(), dataInjection.getSheetName(), 1, 1));
        getDriver().findElement(selectDestinationInput).sendKeys(Keys.ARROW_DOWN);
        getDriver().findElement(selectDestinationInput).sendKeys(Keys.ENTER);
        Times.waitFor(3000);
    }

    public void fechaIda() throws InterruptedException {
        getDriver().findElement(calendarClickIda).click();
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(calendarClickIda));
        Times.waitFor(5000);
        Javascript.clickJS(getDriver(), selectDayIda);
        Times.waitFor(5000);
        Javascript.clickJS(getDriver(), selectDayIda);
    }

    public void clickBuscar() throws InterruptedException {
        getDriver().findElement(goButton).click();
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void selectTicket() throws InterruptedException {
        getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        getDriver().findElement(selectFlightClick).click();
        Times.waitFor(3000);
        getDriver().findElement(selectPriceClick).click();
        Times.waitFor(3000);
        getDriver().findElement(confirmPriceClick).click();

    }

    public void datosPersona() throws InterruptedException, IOException {
        getDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        getDriver().findElement(nameInput).sendKeys(DataExcel.getCellValue(dataInjection.getFilepath(), dataInjection.getSheetName(), 1, 3));
        getDriver().findElement(lastNameInput).sendKeys(DataExcel.getCellValue(dataInjection.getFilepath(), dataInjection.getSheetName(), 1, 4));
        Times.waitFor(3000);
        Javascript.clickJS(getDriver(), confirmTicketClick);
        Times.waitFor(3000);
        getDriver().findElement(emailInput).sendKeys(DataExcel.getCellValue(dataInjection.getFilepath(), dataInjection.getSheetName(), 1, 5));
        Times.waitFor(3000);
        String cellPhone = DataExcel.getCellValue(dataInjection.getFilepath(), dataInjection.getSheetName(), 1, 6);
        getDriver().findElement(phoneInput).sendKeys(cellPhone);
        Times.waitFor(3000);
        Javascript.clickJS(getDriver(), termsCheckBox);
        Times.waitFor(3000);
        Javascript.clickJS(getDriver(), saveClick);
        Times.waitFor(5000);
        Javascript.clickJS(getDriver(), buyClick);
        Times.waitFor(5000);
        getDriver().findElement(detailValidation).click();
    }

    public void dataValidations() throws InterruptedException, IOException {

        getDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        assertEquals(getDriver().findElement(nameValidation).getText(), DataExcel.getCellValue(
                dataInjection.getFilepath(),
                dataInjection.getSheetName(), 1, 3) + " " + DataExcel.getCellValue(
                dataInjection.getFilepath(), dataInjection.getSheetName(), 1, 4));
        Times.waitFor(3000);

        assertEquals(getDriver().findElement(emailValidation).getText(), DataExcel.getCellValue(dataInjection.getFilepath(),
                dataInjection.getSheetName(), 1, 5));
        assertEquals(getDriver().findElement(phoneValidation).getText(), "+57 " + DataExcel.getCellValue(dataInjection.getFilepath(),
                dataInjection.getSheetName(), 1, 6).toLowerCase(Locale.ROOT));
        Times.waitFor(3000);


    }

    public void printInfoVuelo() {
        if (getDriver().findElement(nameValidation).isDisplayed()) {
            System.out.println("************Detalles Vuelo De Ida Seleccionado*****************\n" + "Nombres Apellidos:" + getDriver().findElement(nameValidation).getText() + "\n"
                    + "Numero de Vuelo: " + getDriver().findElement(flighNumber).getText() + "\n" +
                    "Correo Electronico: " + getDriver().findElement(emailValidation).getText() + "\n"
                    + "Fecha Y Hora de Salida: " + getDriver().findElement(dateOpen).getText() + "," + getDriver().findElement(departure_date).getText() + "\n" +
                    getDriver().findElement(totalValue).getText());
        }
    }

    public void closeWindows() throws InterruptedException {
        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        getDriver().findElement(buttonClose).click();

    }

    public void fileLog() {
        SpecialMetods.configProperties();

        FileWriter file;
        try {
            file = new FileWriter(SpecialMetods.properties.getProperty("filepathLogIda"));


            file.write("Nombre Apellido:" + getDriver().findElement(nameValidation).getText() + "\n" + "Correo: " + getDriver().findElement(emailValidation).getText() + "\n" + "Numero de Vuelo: " +
                    getDriver().findElement(flighNumber).getText() + "\n" + "Fecha y Hora De Salida: " + getDriver().findElement(dateOpen).getText() + "," + getDriver().findElement(departure_date).getText() + "\n"
                    + "Valor Total: " + getDriver().findElement(totalValue).getText());
            file.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}






