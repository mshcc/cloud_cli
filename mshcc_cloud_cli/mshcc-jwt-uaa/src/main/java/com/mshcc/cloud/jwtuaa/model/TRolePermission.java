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
public class TRolePermission {
    private Integer id;

    private Integer roleId;

    private Integer permissionId;

    private Date createTime;

    /**
    * 关联者
    */
    private String creator;
}