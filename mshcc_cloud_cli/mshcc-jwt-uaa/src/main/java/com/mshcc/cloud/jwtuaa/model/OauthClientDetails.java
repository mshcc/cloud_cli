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
public class OauthClientDetails {
    private Integer id;

    /**
    * 客户端id
    */
    private String clientId;

    /**
    * 客户可访问资源
    */
    private String resourceIds;

    /**
    * 客户端密钥
    */
    private String clientSecret;

    /**
    * 授权范围
    */
    private String scope;

    /**
    * 授权类型
    */
    private String authorizedGrantTypes;

    /**
    * 回调地址
    */
    private String webServerRedirectUri;

    /**
    * 权限
    */
    private String authorities;

    /**
    * 访问令牌有效性
    */
    private Integer accessTokenValidity;

    /**
    * 刷新令牌有效性
    */
    private Integer refreshTokenValidity;

    /**
    * 附加信息,必须为json格式
    */
    private String additionalInformation;

    /**
    * 创建日期
    */
    private Date createTime;

    /**
    * 封存
    */
    private Byte archived;

    /**
    * 可信赖
    */
    private Byte trusted;

    /**
    * 自动批准
    */
    private String autoapprove;
}