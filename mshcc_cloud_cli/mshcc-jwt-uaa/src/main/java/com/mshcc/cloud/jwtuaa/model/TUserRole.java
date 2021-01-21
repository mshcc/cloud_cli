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
public class TUserRole {
    private Integer id;

    private Integer userId;

    private Integer roleId;

    private Date createTime;

    /**
    * 关联者
    */
    private String creator;
}