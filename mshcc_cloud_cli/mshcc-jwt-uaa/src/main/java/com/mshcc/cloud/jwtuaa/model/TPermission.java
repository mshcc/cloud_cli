package com.mshcc.cloud.jwtuaa.model;

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
public class TPermission {
    private Integer id;

    /**
    * 权限名
    */
    private String code;

    /**
    * 权限描述
    */
    private String description;

    /**
    * 权限可访问url
    */
    private String url;
}