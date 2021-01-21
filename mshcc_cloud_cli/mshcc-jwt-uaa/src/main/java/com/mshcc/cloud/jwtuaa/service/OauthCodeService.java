package com.mshcc.cloud.jwtuaa.service;


import com.mshcc.cloud.jwtuaa.model.OauthCode;

/**
* @author mshcc
* @Date 2021/1/7 9:51
* @Description TODO
*/
public interface OauthCodeService{


int deleteByPrimaryKey(Integer id);

int insert(OauthCode record);

int insertSelective(OauthCode record);

OauthCode selectByPrimaryKey(Integer id);

int updateByPrimaryKeySelective(OauthCode record);

int updateByPrimaryKey(OauthCode record);

}
