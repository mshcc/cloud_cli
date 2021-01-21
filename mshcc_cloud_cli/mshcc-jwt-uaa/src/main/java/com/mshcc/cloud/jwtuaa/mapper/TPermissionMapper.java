package com.mshcc.cloud.jwtuaa.mapper;

import com.mshcc.cloud.jwtuaa.model.TPermission;

import java.util.List;

/**
 * @author mshcc
 * @Date 2021/1/6 11:25
 * @Description TODO
 */
public interface TPermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TPermission record);

    int insertSelective(TPermission record);

    TPermission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TPermission record);

    int updateByPrimaryKey(TPermission record);
    List<TPermission> getPermissionsByIds(List<Integer> ids);

}