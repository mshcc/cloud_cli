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
public class OauthCode {
    private Integer id;

    /**
    * 创建时间
    */
    private Date createTime;

    /**
    * 授权码
    */
    private String code;

    /**
    * 存储将AuthorizationRequestHolder.java对象序列化后的二进制数据
    */
    private byte[] authentication;
}