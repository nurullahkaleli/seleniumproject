package com.myfirstproject;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Day16_WriteExcel {

    /*
        Store the path of the file as string and open the file
        Open the workbook
        Open the first worksheet
        Go to the first row
        Create a cell on the 3rd column (index 2) on the first row
        Write "FAMOUS FOR" on that cell
        Create a cell on the 2nd row 3rd cell(index 2), and write Liberty Statue
        Create a cell on the 3rd row 3rd cell(index 2), and write Eiffel Tower
        Create a cell on the 4th row 3rd cell(index 2), and write London Eye
        Write and save the workbook
        Close the file
        Close the workbook
    */

    @Test
    public void writeExcelTest() throws IOException {
//        Store the path of the file as string and open the file
        String path = "resources/Capitals.xlsx";

//        Open the workbook
        FileInputStream fileInputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fileInputStream);

//        Open the first worksheet
        Sheet sheet1 = workbook.getSheet("sheet1");

//        Go to the first row
        Row row1 = sheet1.getRow(0);

//        Create a cell on the 3rd column (index 2) on the first row
        Cell r1c3 = row1.createCell(2);

//        Write "FAMOUS FOR" on that cell
        r1c3.setCellValue("FAMOUS FOR");

//        Create a cell on the 2nd row 3rd cell(index 2), and write Liberty Statue
        sheet1.getRow(1).createCell(2).setCellValue("Liberty Statue");

//        Create a cell on the 3rd row 3rd cell(index 2), and write Eiffel Tower
        sheet1.getRow(2).createCell(2).setCellValue("Eiffel Tower");

//        Create a cell on the 4th row 3rd cell(index 2), and write London Eye
        sheet1.getRow(3).createCell(2).setCellValue("London Eye");

//        Write and save the workbook
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);

//        Close the file
        fileInputStream.close();
        fileOutputStream.close();

//        Close the workbook
        workbook.close();

    }

}
