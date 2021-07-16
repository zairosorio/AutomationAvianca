package com.avianca.automation.models;
import com.avianca.automation.utils.DataExcel;
import com.avianca.automation.utils.SpecialMetods;

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


        SpecialMetods.configProperties();

        this.filePath =   SpecialMetods.properties.getProperty("fileName");
        this.sheetName =  SpecialMetods.properties.getProperty("sheetName");
        this.dateIda = DataExcel.getCellValue(filePath, sheetName, 1, 2);
        this.dateIdaR = DataExcel.getCellValue(filePath, sheetName, 1, 2);


    }
}

