package org.example;

import org.apache.commons.io.input.MemoryMappedFileInputStream;
import org.apache.commons.io.input.RandomAccessFileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        FileInputStream file = null;
        Workbook workbook;
        try {
            file = new FileInputStream(new File("students.xlsx"));
            workbook = new XSSFWorkbook(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Sheet sheet = workbook.getSheetAt(0);
        for (Row row : sheet) {
            for (Cell cell : row) {
                switch (cell.getCellType()) {
                    case NUMERIC:
                        System.out.print(cell.getNumericCellValue()+" ");
                        break;
                    case STRING:
                        System.out.print(cell.getStringCellValue()+" ");
                        break;
                    default:
                        System.out.print(cell.getStringCellValue()+" ");
                        break;
                }
            }
            System.out.println();
        }
    }
}