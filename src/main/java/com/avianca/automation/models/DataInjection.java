package com.avianca.automation.models;
import java.io.IOException;


public class DataInjection {

    String filePath;
    String sheetName;
    String dateIda;
    String dateIdaR;

    public String getDateIdaR() {
        return dateIdaR;
    }

    public String getDateIda() {
        return dateIda;
    }

    public String getSheetName() {
        return sheetName;
    }

    public String getFilepath() {
        return filePath;
    }

    public DataInjection() throws IOException {
        this.filePath = "resources/dataAvianca.xlsx";
        this.sheetName = "datos";
        this.dateIda = "2021.9.25";
        this.dateIdaR = "2021.9.30";


    }
}

