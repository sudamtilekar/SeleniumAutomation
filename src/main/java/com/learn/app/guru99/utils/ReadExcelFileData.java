package com.learn.app.guru99.utils;

import com.learn.app.guru99.BaseClass.TestBaseClass;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadExcelFileData extends TestBaseClass {

    public static String path = "/src/main/resources/ReadExcel_TestData.xlsx";
    public static XSSFWorkbook workbook;
    public static XSSFSheet sheet;
    public static FileInputStream fileInputStream;
    public String excelPath = System.getProperty("user.dir" + path);

    public ReadExcelFileData() {
        super();
    }


    public Map<String, Map<String, String>> setMapData(String sheetName, String excelFilePath) throws IOException {


        fileInputStream = new FileInputStream(excelFilePath);
        workbook = new XSSFWorkbook(fileInputStream);
        sheet = workbook.getSheet(sheetName);
        int totalRows = ReadExcelFileData.sheet.getLastRowNum();
        System.out.println("Total Rows Are :" + totalRows);
        int totalColumns = ReadExcelFileData.sheet.getRow(0).getLastCellNum();
        System.out.println("Total Columns are :" + totalColumns);

        String CellValue = "";
        String CellKey = "";


        Map<String, Map<String, String>> excelFileMap = new HashMap<>();
        Map<String, String> dataMap = new HashMap<>();
//        Looping over entire row
        for (int i = 0; i < totalRows; i++) {
            int j = 0;
//            for (int j = 0; j < totalColumns; j++) {
            CellKey = sheet.getRow(i + 1).getCell(j).getStringCellValue();
            CellValue = sheet.getRow(i + 1).getCell(j + 1).getStringCellValue();
            System.out.println("CELL Key is : " + CellKey);
            System.out.println("CELL Value is : " + CellValue);
//                Putting Key and Value in dataMap
            dataMap.put(CellKey, CellValue);
        }
//                Putting DataMap to excelFileMap
        return excelFileMap;
    }


    public Object[][] readExcelFileData(String sheetName, String excelFilePath) throws IOException {

        workbook = new XSSFWorkbook(excelFilePath);
        ReadExcelFileData.sheet = workbook.getSheet(sheetName);
        int totalRows = ReadExcelFileData.sheet.getLastRowNum();
        int totalColumn = ReadExcelFileData.sheet.getRow(0).getLastCellNum();

        Object data[][] = new Object[totalRows][totalColumn];
        for (int i = 0; i < totalRows; i++) {
            for (int j = 0; j < totalColumn; j++) {
                String CellValueIs = ReadExcelFileData.sheet.getRow(i + 1).getCell(j).getStringCellValue();
                System.out.println("Value Is : " + CellValueIs);
            }

        }
        return data;
    }

    @Test
    public void readDataFromExcel() throws IOException {

        String excelFilePath = System.getProperty("user.dir") + path;
        System.out.println("File Path: " + excelFilePath);
        readExcelFileData("SheetName", excelFilePath);

    }

    public static HashMap<String, String> mapData;

    public static HashMap<String, String> readExcelDataAndWriteToMAP(String sheetName, String excelFinalFilePath) {
        mapData = new HashMap<String, String>();
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(excelFinalFilePath);
            XSSFSheet sheet = workbook.getSheet(sheetName);

            int totalrows = sheet.getLastRowNum();
            for (int i = 0; i <= totalrows; i++) {
                String key = sheet.getRow(i).getCell(0).getStringCellValue();
                String value = sheet.getRow(i).getCell(1).getStringCellValue();
                mapData.put(key, value);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return mapData;
    }


}
