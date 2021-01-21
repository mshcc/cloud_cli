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
public class MailRecord {
    /**
    * 主键id
    */
    private Integer id;

    /**
    * 发送者邮箱
    */
    private String sender;

    /**
    * 收件人邮箱
    */
    private String recipient;

    /**
    * 邮件标题
    */
    private String title;

    /**
    * 邮件内容
    */
    private String text;

    /**
    * 邮件发送时间
    */
    private Date sendTime;

    /**
    * 是否发送成功  0:成功   1: 失败
    */
    private Integer success;
}