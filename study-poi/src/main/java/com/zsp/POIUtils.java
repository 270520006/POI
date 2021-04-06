package com.zsp;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.joda.time.DateTime;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;

import static org.apache.poi.ss.usermodel.CellType.STRING;

public  class POIUtils {
    public static void POIUtils(String PATH) throws Exception {

        FileInputStream fileInputStream = new FileInputStream(PATH);
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheetAt = workbook.getSheetAt(0);
        int physicalNumberOfRows = sheetAt.getPhysicalNumberOfRows();
        for (int rowNum = 0; rowNum < physicalNumberOfRows; rowNum++) {
            Row row = sheetAt.getRow(rowNum);
            int physicalNumberOfCells = row.getPhysicalNumberOfCells();
            for (int cellNum = 0; cellNum < physicalNumberOfCells; cellNum++) {
                Cell cell = row.getCell(cellNum);
                if (cell != null) {
                    CellType cellType = cell.getCellType();
                    String cellValue = "";
                    switch (cellType) {
                        case NUMERIC:
                            if (DateUtil.isCellDateFormatted(cell)) {
                                Date date = cell.getDateCellValue();
                                cellValue = new DateTime(date).toString("yyyy-MM-dd");
                            } else {
                                cellType = STRING;
                                cellValue = cell.toString();
                            }
                            System.out.print(cellValue + " ");
                            break;
                        case STRING:
                            cellValue = cell.getStringCellValue();
                            System.out.print(cellValue + " ");
                            break;
                        case FORMULA:
                            break;
                        case BLANK:
                            System.out.print("输出为空~");
                            break;
                        case BOOLEAN:
                            cellValue = String.valueOf(cell.getBooleanCellValue());
                            System.out.print(cellValue + " ");
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
}


