package com.mshcc.cloud.mail.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.mshcc.cloud.mail.mapper.MailRecordMapper;
import com.mshcc.cloud.mail.model.MailRecord;
import com.mshcc.cloud.mail.service.MailRecordService;
/**
 * @author mshcc
 * @Date 2021/1/19 11:22
 * @Description TODO
 */
@Service
public class MailRecordServiceImpl implements MailRecordService{

    @Resource
    private MailRecordMapper mailRecordMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return mailRecordMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(MailRecord record) {
        return mailRecordMapper.insert(record);
    }

    @Override
    public int insertSelective(MailRecord record) {
        return mailRecordMapper.insertSelective(record);
    }

    @Override
    public MailRecord selectByPrimaryKey(Integer id) {
        return mailRecordMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(MailRecord record) {
        return mailRecordMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(MailRecord record) {
        return mailRecordMapper.updateByPrimaryKey(record);
    }

}
