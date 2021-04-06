package com.zsp;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExcelReadTest {
    String PATH="D:\\java项目\\POI\\";
    @Test
    public void testRead03() throws Exception {
        FileInputStream fileInputStream = new FileInputStream(PATH + "今日学习时间03.xls");
        Workbook workbook=new HSSFWorkbook(fileInputStream);
        Sheet sheetAt = workbook.getSheetAt(0);
        Row row0 = sheetAt.getRow(0);
        Cell cell00 = row0.getCell(0);
        Cell cell01 = row0.getCell(1);
        System.out.println(cell00.getStringCellValue());
        System.out.println(cell01.getStringCellValue());
        fileInputStream.close();
    }
    @Test
    public void testRead07() throws Exception {
        FileInputStream fileInputStream = new FileInputStream(PATH + "今日学习时间07.xlsx");
        Workbook workbook=new XSSFWorkbook(fileInputStream);
        Sheet sheetAt = workbook.getSheetAt(0);
        Row row0 = sheetAt.getRow(0);
        Cell cell00 = row0.getCell(0);
        Cell cell01 = row0.getCell(1);
        System.out.println(cell00.getStringCellValue());
        System.out.println(cell01.getNumericCellValue()); //注意这里需要区分类型
        fileInputStream.close();
    }

}
