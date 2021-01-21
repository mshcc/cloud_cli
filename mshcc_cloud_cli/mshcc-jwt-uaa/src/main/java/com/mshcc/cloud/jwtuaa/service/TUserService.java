package com.mshcc.cloud.jwtuaa.service;


import com.mshcc.cloud.jwtuaa.model.TUser;

/**
 * @author mshcc
 * @Date 2021/1/6 11:25
 * @Description TODO
 */
public interface TUserService {


    int deleteByPrimaryKey(Integer id);

    int insert(TUser record);

    int insertSelective(TUser record);

    TUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TUser record);


    TUser findByName(String name);

    int updateByPrimaryKey(TUser record);

}
