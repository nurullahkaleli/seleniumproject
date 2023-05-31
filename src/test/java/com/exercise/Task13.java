package com.exercise;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
    public void writeEarningList () throws IOException {

//        Save EarningList.xlsx file into your project
        String path = "resources/EarningList.xlsx";

//        Open the workbook
        FileInputStream fileInputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fileInputStream);

//        Open the first worksheet
        Sheet sheet1 = workbook.getSheet("sheet1");

        sheet1.getRow(0).getCell(1).setCellValue("Days");
        sheet1.getRow(0).getCell(1).setCellValue("Earnings");
        sheet1.getRow(0).getCell(1).setCellValue("Row");



    }

}
