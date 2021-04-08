package com.zsp.utils;

import com.alibaba.excel.EasyExcel;
import com.zsp.entity.User;
import com.zsp.mapper.UserMapper;
import com.zsp.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ExcelUtils {

    public static String getExcel(String fileName,List<User> list) throws Exception {
        try {
            EasyExcel.write(fileName, User.class).sheet("学生信息表").doWrite(list);
            return "已经保存到:"+fileName;
        } catch (Exception e) {
           throw new Exception("导出失败");
        }
    }

    public static String getMysql(String fileName, UserService userService){

        EasyExcel.read(fileName,User.class,new DemoDataListener(userService)).sheet().doRead();
        return "Excel的表单内容存入数据库成功";
    }



}
