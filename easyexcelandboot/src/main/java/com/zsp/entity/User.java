package com.zsp.entity;

import java.util.Date;

import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.Version;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author zsp
 * @since 2021-04-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @ExcelProperty("姓名")
    private String name;
    @ExcelProperty("密码")
    private Integer password;
    @ExcelProperty("日期")
    private Date date;


}
