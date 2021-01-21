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
public class TUser {
    private Integer id;

    /**
    * 用户名
    */
    private String username;

    /**
    * 密码
    */
    private String password;

    /**
    * 全名
    */
    private String fullname;

    /**
    * 手机号
    */
    private String mobile;

    /**
    * 邮箱地址
    */
    private String mail;

    /**
    * 0:保密 1:男 2:女
    */
    private Integer gender;

    /**
    * 创建时间
    */
    private Date createTime;

    /**
    * 0:正常 1:锁定
    */
    private Integer status;

    /**
    * 最后登录时间
    */
    private Date lastLogin;
}