package com.mshcc.cloud.jwtuaa.service.impl;

import com.mshcc.cloud.jwtuaa.mapper.TRoleMapper;
import com.mshcc.cloud.jwtuaa.model.TRole;
import com.mshcc.cloud.jwtuaa.service.TRoleService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * @author mshcc
 * @Date 2021/1/6 11:25
 * @Description TODO
 */
@Service
public class TRoleServiceImpl implements TRoleService {

    @Resource
    private TRoleMapper tRoleMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return tRoleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TRole record) {
        return tRoleMapper.insert(record);
    }

    @Override
    public int insertSelective(TRole record) {
        return tRoleMapper.insertSelective(record);
    }

    @Override
    public TRole selectByPrimaryKey(Integer id) {
        return tRoleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TRole record) {
        return tRoleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TRole record) {
        return tRoleMapper.updateByPrimaryKey(record);
    }

}
