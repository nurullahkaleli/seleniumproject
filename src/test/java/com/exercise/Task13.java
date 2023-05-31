package com.exercise;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Task13 {

    //Task 13:

      /*
    Given
        Save EarningList.xlsx file into your project
    When
        In the row column, write the row numbers according to the earnings amount(Natural Order).
    Then
        Assert that row number of Wednesday is 1
     */


    //EarningList.xlsx file:
//    Days	   Earnings   Row
//    Monday	    $512
//    Tuesday	    $205
//    Wednesday	$632
//    Thursday	$344
//    Friday	    $480
//    Saturday	$0
//    Sunday	    $0

  @Test
    public void excelTest() throws IOException {
        String path = "resources/EarningsList.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet1 = workbook.getSheet("Sheet1");

        sheet1.getRow(0).createCell(0).setCellValue("Days");
        sheet1.getRow(0).createCell(1).setCellValue("Earnings");
        sheet1.getRow(0).createCell(2).setCellValue("Row");

        sheet1.getRow(1).createCell(0).setCellValue("Wednesday");
        sheet1.getRow(1).createCell(1).setCellValue("$632");

        sheet1.getRow(2).createCell(0).setCellValue(" Monday");
        sheet1.getRow(2).createCell(1).setCellValue(" $512");

        sheet1.getRow(3).createCell(0).setCellValue("Friday");
        sheet1.getRow(3).createCell(1).setCellValue("$480");

        sheet1.getRow(4).createCell(0).setCellValue("Thursday");
        sheet1.getRow(4).createCell(1).setCellValue("$344");

        sheet1.getRow(5).createCell(0).setCellValue("Tuesday");
        sheet1.getRow(5).createCell(1).setCellValue("$205");


        sheet1.getRow(6).createCell(0).setCellValue("Saturday");
        sheet1.getRow(6).createCell(1).setCellValue("$0");

        sheet1.getRow(7).createCell(0).setCellValue("Sunday");
        sheet1.getRow(7).createCell(1).setCellValue("$0");


        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);
        fileInputStream.close();
    }

}
