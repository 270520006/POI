package com.zsp.service;

import com.zsp.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zsp.mapper.UserMapper;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zsp
 * @since 2021-04-08
 */
public interface UserService extends IService<User> {
    public String getExcel() throws Exception;
    public String getMysql(String fileName,UserService userService);
}
