package com.mshcc.cloud.jwtuaa.service.impl;

import com.mshcc.cloud.jwtuaa.mapper.TRolePermissionMapper;
import com.mshcc.cloud.jwtuaa.model.TRolePermission;
import com.mshcc.cloud.jwtuaa.service.TRolePermissionService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import java.util.List;

/**
 * @author mshcc
 * @Date 2021/1/6 11:25
 * @Description TODO
 */
@Service
public class TRolePermissionServiceImpl implements TRolePermissionService {

    @Resource
    private TRolePermissionMapper tRolePermissionMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return tRolePermissionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TRolePermission record) {
        return tRolePermissionMapper.insert(record);
    }

    @Override
    public int insertSelective(TRolePermission record) {
        return tRolePermissionMapper.insertSelective(record);
    }

    @Override
    public TRolePermission selectByPrimaryKey(Integer id) {
        return tRolePermissionMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TRolePermission record) {
        return tRolePermissionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TRolePermission record) {
        return tRolePermissionMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Integer> getPermissionsByRole(List<Integer> roles) {
        return tRolePermissionMapper.getPermissionsByRole(roles);
    }

}
