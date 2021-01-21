package com.mshcc.cloud.jwtuaa.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author mshcc
 * @Date 2021/1/12 16:03
 * @Description TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TRole {
    private Integer id;

    /**
    * 角色名
    */
    private String roleName;

    /**
    * 角色描述
    */
    private String description;

    /**
    * 创建时间
    */
    private Date createTime;

    /**
    * 最后更新日期
    */
    private Date updateTime;

    /**
    * 0:正常 1：异常
    */
    private Integer status;
}