package com.zsp.controller;


import com.zsp.entity.User;
import com.zsp.mapper.UserMapper;
import com.zsp.service.UserService;
import com.zsp.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zsp
 * @since 2021-04-08
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/list")
    public List getList() {
        List<User> list = userService.list();
        return list;
    }

    @GetMapping("/getExcel")
    public String getExcel() {
        try {
            return userService.getExcel();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "生成excel出现错误";
    }
    @GetMapping("/getMysql")
    public String getMysql() {
        String fileName="D:\\java项目\\POI\\学生信息表03.xls";
        try {
            return userService.getMysql(fileName,userService);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "生成excel出现错误";
    }

}

