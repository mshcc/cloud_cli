package com.mshcc.cloud.jwtuaa.service;


import com.mshcc.cloud.jwtuaa.model.OauthClientDetails;

/**
* @author mshcc
* @Date 2021/1/7 9:51
* @Description TODO
*/
public interface OauthClientDetailsService{


int deleteByPrimaryKey(Integer id);

int insert(OauthClientDetails record);

int insertSelective(OauthClientDetails record);

OauthClientDetails selectByPrimaryKey(Integer id);

int updateByPrimaryKeySelective(OauthClientDetails record);

int updateByPrimaryKey(OauthClientDetails record);

}
