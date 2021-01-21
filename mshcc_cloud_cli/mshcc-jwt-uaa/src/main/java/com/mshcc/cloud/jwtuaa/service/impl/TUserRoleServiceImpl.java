package com.mshcc.cloud.jwtuaa.service.impl;

import com.mshcc.cloud.jwtuaa.mapper.TUserRoleMapper;
import com.mshcc.cloud.jwtuaa.model.TUserRole;
import com.mshcc.cloud.jwtuaa.service.TUserRoleService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import java.util.List;

/**
 * @author mshcc
 * @Date 2021/1/6 11:25
 * @Description TODO
 */
@Service
public class TUserRoleServiceImpl implements TUserRoleService {

    @Resource
    private TUserRoleMapper tUserRoleMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return tUserRoleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TUserRole record) {
        return tUserRoleMapper.insert(record);
    }

    @Override
    public int insertSelective(TUserRole record) {
        return tUserRoleMapper.insertSelective(record);
    }

    @Override
    public TUserRole selectByPrimaryKey(Integer id) {
        return tUserRoleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TUserRole record) {
        return tUserRoleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TUserRole record) {
        return tUserRoleMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Integer> getRolesByUser(Integer id) {
        return tUserRoleMapper.getRolesByUser(id);
    }

}
