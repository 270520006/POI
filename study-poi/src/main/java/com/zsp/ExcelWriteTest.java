package com.zsp;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class ExcelWriteTest {
    String PATH="D:\\java项目\\POI\\";
    @Test
    public void testWrite03() throws Exception {
//        1、创建一个工作簿
        Workbook workbook= new HSSFWorkbook();
//        2、创造一个工作表
        Sheet sheet = workbook.createSheet("首个Excel文件");
//       3、创造一行
        Row row1 = sheet.createRow(0);
//        4、在一行里创造一个单元格
        Cell cell00 = row1.createCell(0);
//        5、往格子里塞数据
        cell00.setCellValue("4月5号学习时间：");
        Cell cell01 = row1.createCell(1);
        cell01.setCellValue("2小时");

        Row row2 = sheet.createRow(1);
        Cell cell10 = row2.createCell(0);
        cell10.setCellValue("4月6号学习时间：");

        Cell cell11 = row2.createCell(1);
        cell11.setCellValue("2小时");
//        创建一个流用于创建Excel表
        FileOutputStream fileOutputStream = new FileOutputStream(PATH + "今日学习时间03.xls");
//        使用API将文件写入
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        System.out.println("表生成完毕了");

    }

    @Test
    public void testWrite07() throws Exception {
        Workbook workbook07 = new SXSSFWorkbook();
        Sheet sheet07 = workbook07.createSheet("今日学习时间07");
        Row row0 = sheet07.createRow(0);
        Cell cell00 = row0.createCell(0);
        cell00.setCellValue("07学习时间:");

        Cell cell01 = row0.createCell(1);
        cell01.setCellValue("1小时不到");

        FileOutputStream fileOutputStream = new FileOutputStream(PATH + "今日学习时间07.xlsx");
        workbook07.write(fileOutputStream);
        System.out.println("07创造完成");
        fileOutputStream.close();
    }

    @Test
    public void writeLots03() throws Exception {
        long start = System.currentTimeMillis();
        Workbook workbook =new HSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        for (int rowNum = 0; rowNum <65536 ; rowNum++) {
            Row row = sheet.createRow(rowNum);
            for (int cellNum = 0; cellNum <10 ; cellNum++) {
                Cell cell = row.createCell(cellNum);
                cell.setCellValue(cellNum);
            }
        }
        FileOutputStream fileOutputStream = new FileOutputStream(PATH + "03批量写入.xls");
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        long end = System.currentTimeMillis();
        System.out.println("花费时间为"+((double)(end-start)/1000)+"秒");
    }
    @Test
    public void writeLots07() throws Exception {
        long start = System.currentTimeMillis();
        Workbook workbook =new XSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        for (int rowNum = 0; rowNum <100000 ; rowNum++) {
            Row row = sheet.createRow(rowNum);
            for (int cellNum = 0; cellNum <10 ; cellNum++) {
                Cell cell = row.createCell(cellNum);
                cell.setCellValue(cellNum);
            }
        }
        FileOutputStream fileOutputStream = new FileOutputStream(PATH + "07批量写入.xls");
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        long end = System.currentTimeMillis();
        System.out.println("花费时间为"+((double)(end-start)/1000)+"秒");
    }
    @Test
    public void writeLots07S() throws Exception {
        long start = System.currentTimeMillis();
        Workbook workbook =new SXSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        for (int rowNum = 0; rowNum <100000 ; rowNum++) {
            Row row = sheet.createRow(rowNum);
            for (int cellNum = 0; cellNum <10 ; cellNum++) {
                Cell cell = row.createCell(cellNum);
                cell.setCellValue(cellNum);
            }
        }
        FileOutputStream fileOutputStream = new FileOutputStream(PATH + "07S批量写入.xls");
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        ((SXSSFWorkbook)workbook).dispose(); //关闭临时文件
        long end = System.currentTimeMillis();
        System.out.println("花费时间为"+((double)(end-start)/1000)+"秒");
    }

}
