package com.mshcc.cloud.jwtuaa.service.impl;

import com.mshcc.cloud.jwtuaa.mapper.TUserMapper;
import com.mshcc.cloud.jwtuaa.model.TUser;
import com.mshcc.cloud.jwtuaa.service.TUserService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * @author mshcc
 * @Date 2021/1/6 11:25
 * @Description TODO
 */
@Service
public class TUserServiceImpl implements TUserService {

    @Resource
    private TUserMapper tUserMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return tUserMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TUser record) {
        return tUserMapper.insert(record);
    }

    @Override
    public int insertSelective(TUser record) {
        return tUserMapper.insertSelective(record);
    }

    @Override
    public TUser selectByPrimaryKey(Integer id) {
        return tUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TUser record) {
        return tUserMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public TUser findByName(String name) {
        return tUserMapper.findByName(name);
//        return null;
    }

    @Override
    public int updateByPrimaryKey(TUser record) {
        return tUserMapper.updateByPrimaryKey(record);
    }

}
