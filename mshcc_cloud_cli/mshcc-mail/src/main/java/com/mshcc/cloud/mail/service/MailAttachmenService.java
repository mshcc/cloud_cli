package com.mshcc.cloud.mail.service;

import com.mshcc.cloud.mail.model.MailAttachmen;
    /**
 * @author mshcc
 * @Date 2021/1/19 11:22
 * @Description TODO
 */
public interface MailAttachmenService{


    int deleteByPrimaryKey(Integer id);

    int insert(MailAttachmen record);

    int insertSelective(MailAttachmen record);

    MailAttachmen selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MailAttachmen record);

    int updateByPrimaryKey(MailAttachmen record);

}
