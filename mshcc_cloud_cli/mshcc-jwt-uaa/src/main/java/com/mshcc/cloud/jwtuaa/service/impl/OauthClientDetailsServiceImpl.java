package com.mshcc.cloud.jwtuaa.service.impl;

import com.mshcc.cloud.jwtuaa.mapper.OauthClientDetailsMapper;
import com.mshcc.cloud.jwtuaa.model.OauthClientDetails;
import com.mshcc.cloud.jwtuaa.service.OauthClientDetailsService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * @author mshcc
 * @Date 2021/1/7 9:51
 * @Description TODO
 */
@Service
public class OauthClientDetailsServiceImpl implements OauthClientDetailsService {

    @Resource
    private OauthClientDetailsMapper oauthClientDetailsMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return oauthClientDetailsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(OauthClientDetails record) {
        return oauthClientDetailsMapper.insert(record);
    }

    @Override
    public int insertSelective(OauthClientDetails record) {
        return oauthClientDetailsMapper.insertSelective(record);
    }

    @Override
    public OauthClientDetails selectByPrimaryKey(Integer id) {
        return oauthClientDetailsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(OauthClientDetails record) {
        return oauthClientDetailsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(OauthClientDetails record) {
        return oauthClientDetailsMapper.updateByPrimaryKey(record);
    }

}
