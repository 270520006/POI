package com.zsp.easyexcel;

import com.alibaba.excel.EasyExcel;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EasyExcelTest {
    String PATH="D:\\java项目\\POI\\";
    private List<DemoData> data() {
        List<DemoData> list = new ArrayList<DemoData>();
        for (int i = 0; i < 10; i++) {
            DemoData data = new DemoData();
            data.setStatement("月份：" + i);
            data.setDate(new Date());
            data.setMoney(0.56);
            list.add(data);
        }
        return list;
    }
    @Test
    public void testWrite(){
    String fileName=PATH+"年度报表.xls";
        EasyExcel.write(fileName,DemoData.class).sheet("年度报表").doWrite(data());
    }
}
