package com.mshcc.cloud.mail.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.mshcc.cloud.mail.mapper.MailTemplateMapper;
import com.mshcc.cloud.mail.model.MailTemplate;
import com.mshcc.cloud.mail.service.MailTemplateService;
/**
 * @author mshcc
 * @Date 2021/1/19 11:22
 * @Description TODO
 */
@Service
public class MailTemplateServiceImpl implements MailTemplateService{

    @Resource
    private MailTemplateMapper mailTemplateMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return mailTemplateMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(MailTemplate record) {
        return mailTemplateMapper.insert(record);
    }

    @Override
    public int insertSelective(MailTemplate record) {
        return mailTemplateMapper.insertSelective(record);
    }

    @Override
    public MailTemplate selectByPrimaryKey(Integer id) {
        return mailTemplateMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(MailTemplate record) {
        return mailTemplateMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(MailTemplate record) {
        return mailTemplateMapper.updateByPrimaryKey(record);
    }

}
