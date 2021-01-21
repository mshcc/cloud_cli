package com.mshcc.cloud.mail.model;

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
public class MailAttachmen {
    /**
    * 主键id
    */
    private Integer id;

    /**
    * 邮件记录id
    */
    private Integer recordId;

    /**
    * 模板id(record、rtemplate二选一)
    */
    private Integer templateId;

    /**
    * 附件名
    */
    private String attachmenName;

    /**
    * 附件位置
    */
    private String attachmenUrl;
}