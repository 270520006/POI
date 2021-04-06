package com.zsp;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.binary.XSSFBUtils;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.helpers.XSSFFormulaUtils;
import org.joda.time.DateTime;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

import static org.apache.poi.ss.usermodel.CellType.STRING;

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
    @Test
    public void testReadAll03() throws Exception {
        FileInputStream fileInputStream = new FileInputStream(PATH + "今日学习时间03.xls");
        Workbook workbook=new HSSFWorkbook(fileInputStream);
        Sheet sheetAt = workbook.getSheetAt(0);
        int physicalNumberOfRows = sheetAt.getPhysicalNumberOfRows();
        for (int rowNum = 0; rowNum <physicalNumberOfRows; rowNum++) {
            Row row = sheetAt.getRow(rowNum);
            int physicalNumberOfCells = row.getPhysicalNumberOfCells();
            if (physicalNumberOfCells!=0)
            for (int cellNum = 0; cellNum < physicalNumberOfCells; cellNum++) {
                Cell cell = row.getCell(cellNum);
                System.out.println(cell.getStringCellValue());
            }
        }

        fileInputStream.close();
    }
    @Test
    public void testReadAll() throws Exception {
        FileInputStream fileInputStream =new FileInputStream(PATH+"花名册07.xlsx");
        Workbook workbook =new XSSFWorkbook(fileInputStream);
        Sheet sheetAt = workbook.getSheetAt(0);
        int physicalNumberOfRows = sheetAt.getPhysicalNumberOfRows();
        for (int rowNum = 0; rowNum <physicalNumberOfRows ; rowNum++) {
            Row row = sheetAt.getRow(rowNum);
            int physicalNumberOfCells = row.getPhysicalNumberOfCells();
            for (int cellNum = 0; cellNum < physicalNumberOfCells; cellNum++) {
                Cell cell = row.getCell(cellNum);
                if (cell!=null) {
                    CellType cellType = cell.getCellType();
                    String cellValue="";
                    switch (cellType) {
                        case NUMERIC:
                            if (DateUtil.isCellDateFormatted(cell)){
                                Date date=cell.getDateCellValue();
                                cellValue=new DateTime(date).toString("yyyy-MM-dd");
                            }else {
                                cellType=STRING;
                                cellValue=cell.toString();
                            }
                            System.out.print(cellValue+" ");
                            break;
                        case  STRING:
                            cellValue=cell.getStringCellValue();
                            System.out.print(cellValue+" ");
                            break;
                        case FORMULA:
                            break;
                        case BLANK:
                            System.out.print("输出为空~");
                            break;
                        case BOOLEAN:
                            cellValue=String.valueOf(cell.getBooleanCellValue());
                            System.out.print(cellValue+" ");
                            break;
                        case ERROR:
                            break;
                    }
                }
            }
            System.out.println();
        }
        fileInputStream.close();
    }
    @Test
    public void test() throws Exception {

        POIUtils.POIUtils(PATH+"花名册07.xlsx");
    }

    @Test
    public void testFormula() throws Exception {
        FileInputStream fileInputStream=new FileInputStream(PATH+"公式学习.xls");
        //确定要判断的单元格
        Workbook workbook =new HSSFWorkbook(fileInputStream);
        Sheet sheetAt = workbook.getSheetAt(0);
        Row row = sheetAt.getRow(0);
        Cell cell = row.getCell(4);
        //判断类型
        CellType cellType = cell.getCellType();
        //获取计算公式
        FormulaEvaluator formulaEvaluator = new HSSFFormulaEvaluator((HSSFWorkbook) workbook);
        switch (cellType){
            case FORMULA:
                String cellFormula = cell.getCellFormula();
                System.out.println(cellFormula);
                CellValue evaluate = formulaEvaluator.evaluate(cell);
                String value = evaluate.formatAsString();
                System.out.println(value);
                break;
        }
        fileInputStream.close();
    }
}
