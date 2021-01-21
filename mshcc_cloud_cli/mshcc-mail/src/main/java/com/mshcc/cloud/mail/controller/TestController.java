package com.mshcc.cloud.mail.controller;

import com.mshcc.cloud.mail.model.MailBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Date;

/**
 * @author mshcc
 * @Date 2021/1/19 11:24
 * @Description TODO
 */
@RestController
public class TestController {

    @Autowired
    private MailProperties mailProperties;


    //接收人
    private static final String RECIPINET = "1035805864@qq.com";

    @Autowired
    private JavaMailSender javaMailSender;

    //    @RequestMapping("sendHtml")
    public String sendHTMLMail(MailBean mailBean) throws MessagingException {
//        MailBean mailBean = new MailBean();
//        mailBean.setRecipient(RECIPINET);
//        mailBean.setSubject("SpringBootMail之这是一封html邮件");
//        mailBean.setContent("SpringBootMail发送一个html格式的邮件，时间为：" + new Date());
        MimeMessage mimeMailMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMailMessage, true);
        mimeMessageHelper.setFrom(mailProperties.getUsername());
        mimeMessageHelper.setTo(mailBean.getRecipient());
        mimeMessageHelper.setSubject(mailBean.getSubject());
//        mimeMessageHelper.setText(mailBean.getContent(),true);
        // text部分保存在数据库中
        mimeMessageHelper.setText("<h1>SpirngBoot测试邮件HTML</h1><p style='color:#F00'>你是真的太棒了！</p><p style='text-align:right'>右对齐</p>"
                , true);

        FileSystemResource file = new FileSystemResource(new
                File("D:\\code\\idea_workplace\\graduation-project\\data\\计本173.xls"));
        mimeMessageHelper.addAttachment("xxx.xls", file);
        new Thread(() -> javaMailSender.send(mimeMailMessage)).start();
        return "发送成功";
    }

    @RequestMapping("sendAttachmentMail")
    public String sendAttachmentMail() throws MessagingException {
        MailBean mailBean = new MailBean();
        mailBean.setRecipient(RECIPINET);
        mailBean.setSubject("SpringBootMail之这是一封html邮件");
        mailBean.setContent("SpringBootMail发送一个html格式的邮件，时间为：" + new Date());
        MimeMessage mimeMailMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMailMessage, true);
        mimeMessageHelper.setFrom("mshccm@163.com");
        mimeMessageHelper.setTo(mailBean.getRecipient());
        mimeMessageHelper.setSubject(mailBean.getSubject());
        mimeMessageHelper.setText(mailBean.getContent());
        //文件路径
        FileSystemResource file = new FileSystemResource(new
                File("D:\\code\\idea_workplace\\graduation-project\\data\\计本173.xls"));
        mimeMessageHelper.addAttachment("xxx.xls", file);

        new Thread(() -> javaMailSender.send(mimeMailMessage)).start();
        return "发送成功";
    }

    @Autowired
    private TemplateEngine templateEngine;

    @RequestMapping("sendTemplateMail")
    public String sendTemplateMail() throws MessagingException {
        //创建邮件正文
        Context context = new Context();
        context.setVariable("id", "006");
        String emailContent = templateEngine.process("emailTemplate", context);
        MailBean mailBean = new MailBean();
        mailBean.setRecipient(RECIPINET);
        mailBean.setSubject("SpringBootMail之这是一封html邮件");
        mailBean.setContent(emailContent);
        return sendHTMLMail(mailBean);
    }
}
