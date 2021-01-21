package com.mshcc.cloud.mail.service;

import com.mshcc.cloud.mail.model.MailTemplate;
    /**
 * @author mshcc
 * @Date 2021/1/19 11:22
 * @Description TODO
 */
public interface MailTemplateService{


    int deleteByPrimaryKey(Integer id);

    int insert(MailTemplate record);

    int insertSelective(MailTemplate record);

    MailTemplate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MailTemplate record);

    int updateByPrimaryKey(MailTemplate record);

}
