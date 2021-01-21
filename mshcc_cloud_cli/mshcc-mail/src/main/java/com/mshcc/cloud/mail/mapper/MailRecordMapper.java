package com.mshcc.cloud.mail.mapper;

import com.mshcc.cloud.mail.model.MailRecord;

/**
 * @author mshcc
 * @Date 2021/1/19 11:22
 * @Description TODO
 */
public interface MailRecordMapper {
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
    int insert(MailRecord record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(MailRecord record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    MailRecord selectByPrimaryKey(Integer id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(MailRecord record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(MailRecord record);
}