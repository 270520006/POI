package com.zsp.service.impl;

import com.alibaba.excel.EasyExcel;
import com.zsp.entity.User;
import com.zsp.mapper.UserMapper;
import com.zsp.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zsp.utils.ExcelUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zsp
 * @since 2021-04-08
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    private String fileName="D:\\java项目\\POI\\学生信息表03.xls";
    public String getExcel() throws Exception {

        try {
            return ExcelUtils.getExcel(fileName,list());
        } catch (Exception e) {
            throw new Exception("导出失败Excel");
        }
    }


    public String getMysql(String fileName,UserService userService) {
        ExcelUtils.getMysql(fileName,userService);
        return "将"+fileName+"导入到数据库成功";
    }

}
