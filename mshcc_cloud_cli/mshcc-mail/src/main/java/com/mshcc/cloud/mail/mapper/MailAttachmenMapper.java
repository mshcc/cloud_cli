package com.mshcc.cloud.mail.mapper;

import com.mshcc.cloud.mail.model.MailAttachmen;

/**
 * @author mshcc
 * @Date 2021/1/19 11:22
 * @Description TODO
 */
public interface MailAttachmenMapper {
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
    int insert(MailAttachmen record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(MailAttachmen record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    MailAttachmen selectByPrimaryKey(Integer id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(MailAttachmen record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(MailAttachmen record);
}