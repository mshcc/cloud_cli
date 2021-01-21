package com.mshcc.cloud.jwtuaa.mapper;


import com.mshcc.cloud.jwtuaa.model.TRolePermission;

import java.util.List;

/**
 * @author mshcc
 * @Date 2021/1/6 11:25
 * @Description TODO
 */
public interface TRolePermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TRolePermission record);

    int insertSelective(TRolePermission record);

    TRolePermission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TRolePermission record);

    int updateByPrimaryKey(TRolePermission record);

    List<Integer> getPermissionsByRole(List<Integer> roles);
}