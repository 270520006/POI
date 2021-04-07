package com.zsp.easyexcel;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DemoData {
   @ExcelProperty("月份报表")
    private String statement;
    @ExcelProperty("日期")
    private Date date;
    @ExcelProperty("花费钱财")
    private Double money;
//    需要忽略的字段
    @ExcelIgnore
    private String none;
}