package com.zsp.easyexcel;

import com.alibaba.excel.EasyExcel;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EasyExcelTest {
    String PATH="D:\\java项目\\POI\\";
    private List<DemoData> data() {
        List<DemoData> list =new ArrayList<>();
        for (int i = 1; i <10 ; i++) {
            DemoData demoData=new DemoData();
            demoData.setStatement("月份:"+i);
            demoData.setDate(new Date());
            demoData.setMoney( i/1.0);
            list.add(demoData);
        }
        return list;
    }
    @Test
    public void testWrite(){
    String fileName=PATH+"年度报表.xls";
        EasyExcel.write(fileName,DemoData.class).sheet("年度报表").doWrite(data());
    }
    @Test
    public void testRead(){
        String fileName=PATH+"年度报表.xls";
        EasyExcel.read(fileName,DemoData.class,new DemoDataListener()).sheet().doRead();
    }
}
