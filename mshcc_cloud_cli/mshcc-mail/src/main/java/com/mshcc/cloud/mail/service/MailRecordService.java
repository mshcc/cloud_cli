package com.mshcc.cloud.mail.service;

import com.mshcc.cloud.mail.model.MailRecord;
    /**
 * @author mshcc
 * @Date 2021/1/19 11:22
 * @Description TODO
 */
public interface MailRecordService{


    int deleteByPrimaryKey(Integer id);

    int insert(MailRecord record);

    int insertSelective(MailRecord record);

    MailRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MailRecord record);

    int updateByPrimaryKey(MailRecord record);

}
