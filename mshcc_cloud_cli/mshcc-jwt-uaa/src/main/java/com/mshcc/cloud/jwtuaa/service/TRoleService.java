package com.mshcc.cloud.jwtuaa.service;


import com.mshcc.cloud.jwtuaa.model.TRole;

/**
* @author mshcc
* @Date 2021/1/6 11:25
* @Description TODO
*/
public interface TRoleService{


int deleteByPrimaryKey(Integer id);

int insert(TRole record);

int insertSelective(TRole record);

TRole selectByPrimaryKey(Integer id);

int updateByPrimaryKeySelective(TRole record);

int updateByPrimaryKey(TRole record);

}
