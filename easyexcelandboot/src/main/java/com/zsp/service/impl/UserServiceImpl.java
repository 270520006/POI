package com.zsp.service.impl;

import com.zsp.entity.User;
import com.zsp.mapper.UserMapper;
import com.zsp.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zsp.utils.EasyExcelWrite;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String getExcel() throws Exception {
        String fileName="D:\\java项目\\POI\\学生信息表03.xls";
        try {
            return EasyExcelWrite.excelWrite(fileName,list());
        } catch (Exception e) {
            throw new Exception("导出失败Excel");
        }
    }

}
