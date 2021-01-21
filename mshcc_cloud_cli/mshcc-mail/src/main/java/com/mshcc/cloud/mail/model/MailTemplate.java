package com.mshcc.cloud.mail.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author mshcc
 * @Date 2021/1/19 11:22
 * @Description TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MailTemplate {
    /**
    * 主键id
    */
    private Integer id;

    /**
    * 邮件模板名称
    */
    private String templateName;

    /**
    * 发送者
    */
    private String templateSender;

    /**
    * 模板标题
    */
    private String templateTitle;

    /**
    * 模板内容
    */
    private String templateText;

    /**
    * 创建日期
    */
    private Date createTime;

    /**
    * 创建者id
    */
    private Integer creator;

    /**
    * 状态   0:正常  1:异常
    */
    private Integer templateStatus;
}