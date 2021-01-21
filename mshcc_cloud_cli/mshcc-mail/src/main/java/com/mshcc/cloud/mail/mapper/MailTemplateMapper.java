package com.mshcc.cloud.mail.mapper;

import com.mshcc.cloud.mail.model.MailTemplate;

/**
 * @author mshcc
 * @Date 2021/1/19 11:22
 * @Description TODO
 */
public interface MailTemplateMapper {
    /**
     * delete by primary key
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(MailTemplate record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(MailTemplate record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    MailTemplate selectByPrimaryKey(Integer id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(MailTemplate record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(MailTemplate record);
}