package com.mshcc.cloud.jwtuaa.service.impl;

import com.mshcc.cloud.jwtuaa.mapper.OauthCodeMapper;
import com.mshcc.cloud.jwtuaa.model.OauthCode;
import com.mshcc.cloud.jwtuaa.service.OauthCodeService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * @author mshcc
 * @Date 2021/1/7 9:51
 * @Description TODO
 */
@Service
public class OauthCodeServiceImpl implements OauthCodeService {

    @Resource
    private OauthCodeMapper oauthCodeMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return oauthCodeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(OauthCode record) {
        return oauthCodeMapper.insert(record);
    }

    @Override
    public int insertSelective(OauthCode record) {
        return oauthCodeMapper.insertSelective(record);
    }

    @Override
    public OauthCode selectByPrimaryKey(Integer id) {
        return oauthCodeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(OauthCode record) {
        return oauthCodeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(OauthCode record) {
        return oauthCodeMapper.updateByPrimaryKey(record);
    }

}
