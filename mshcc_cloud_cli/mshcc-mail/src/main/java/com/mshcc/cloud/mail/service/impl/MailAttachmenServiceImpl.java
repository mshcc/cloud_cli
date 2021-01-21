package com.mshcc.cloud.mail.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.mshcc.cloud.mail.model.MailAttachmen;
import com.mshcc.cloud.mail.mapper.MailAttachmenMapper;
import com.mshcc.cloud.mail.service.MailAttachmenService;
/**
 * @author mshcc
 * @Date 2021/1/19 11:22
 * @Description TODO
 */
@Service
public class MailAttachmenServiceImpl implements MailAttachmenService{

    @Resource
    private MailAttachmenMapper mailAttachmenMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return mailAttachmenMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(MailAttachmen record) {
        return mailAttachmenMapper.insert(record);
    }

    @Override
    public int insertSelective(MailAttachmen record) {
        return mailAttachmenMapper.insertSelective(record);
    }

    @Override
    public MailAttachmen selectByPrimaryKey(Integer id) {
        return mailAttachmenMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(MailAttachmen record) {
        return mailAttachmenMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(MailAttachmen record) {
        return mailAttachmenMapper.updateByPrimaryKey(record);
    }

}
