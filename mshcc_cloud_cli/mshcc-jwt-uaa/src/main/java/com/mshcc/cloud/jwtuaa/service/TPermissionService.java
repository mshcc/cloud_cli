package com.mshcc.cloud.jwtuaa.service;

import com.mshcc.cloud.jwtuaa.model.TPermission;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

/**
 * @author mshcc
 * @Date 2021/1/6 11:25
 * @Description TODO
 */
public interface TPermissionService{


    int deleteByPrimaryKey(Integer id);

    int insert(TPermission record);

    int insertSelective(TPermission record);

    TPermission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TPermission record);

    int updateByPrimaryKey(TPermission record);

        Collection<? extends GrantedAuthority> getPermissions(List<Integer> permissionIds);
    }
