package com.mshcc.cloud.mail.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author mshcc
 * @Date 2021/1/19 9:22
 * @Description TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MailBean implements Serializable {
    private static final long serialVersionUID = -2116367492649751914L;
    /**邮件接收人*/
    private String recipient;
    /**邮件主题*/
    private String subject;
    /**邮件内容*/
    private String content;

}