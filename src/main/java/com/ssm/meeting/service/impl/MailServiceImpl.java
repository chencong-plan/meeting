package com.ssm.meeting.service.impl;

import com.ssm.meeting.service.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.StringWriter;
import java.util.Map;

/**
 * @author ccoder.cc
 * @since 2019/1/25 14:48
 */
@Service
public class MailServiceImpl implements MailService {

    private Logger log = LoggerFactory.getLogger(MailServiceImpl.class);

    @Autowired
    private JavaMailSender mailSender;


    @Value("${mail.username}")
    private String from;


    @Override
    public void sendSimpleMail(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        try {
            mailSender.send(message);
            log.info("简单邮件已发送,邮件收件人:{},邮件发送人:{},邮件内容:{}", to, from, content);
        } catch (Exception e) {
            log.info("简单邮件发送发生异常,邮件收件人:{},邮件发送人:{},邮件内容:{},异常信息:", to, from, content, e);
        }
    }

    @Override
    public void sendSimpleHtmlMail(String to, String subject, String content, boolean isHtml) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            //true表示需要创建一个multipart message
            MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
            messageHelper.setFrom(from);
            messageHelper.setTo(to);
            messageHelper.setSubject(subject);
            messageHelper.setText(content, isHtml);
            mailSender.send(message);
            log.info("简单邮件已发送,邮件收件人:{},邮件发送人:{},邮件内容:{}", to, from, content);
        } catch (Exception e) {
            log.info("简单邮件发送发生异常,邮件收件人:{},邮件发送人:{},邮件内容:{},异常信息:", to, from, content, e);

        }
    }

    @Override
    public void sendAttachmentsMail(String to, String subject, String content, String filePath) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
            messageHelper.setFrom(from);
            messageHelper.setTo(to);
            messageHelper.setSubject(subject);
            messageHelper.setText(content, true);

            FileSystemResource fileSystemResource = new FileSystemResource(new File(filePath));
            String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
            messageHelper.addAttachment(fileName, fileSystemResource);

            mailSender.send(message);
            log.info("简单邮件已发送,邮件收件人:{},邮件发送人:{},邮件内容:{}", to, from, content);
        } catch (Exception e) {
            log.info("简单邮件发送发生异常,邮件收件人:{},邮件发送人:{},邮件内容:{},异常信息:", to, from, content, e);
        }
    }

    @Override
    public void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
            messageHelper.setFrom(from);
            messageHelper.setTo(to);
            messageHelper.setSubject(subject);
            messageHelper.setText(content, true);

            FileSystemResource fileSystemResource = new FileSystemResource(new File(rscPath));
            messageHelper.addInline(rscId, fileSystemResource);

            mailSender.send(message);
            log.info("简单邮件已发送,邮件收件人:{},邮件发送人:{},邮件内容:{}", to, from, content);
        } catch (Exception e) {
            log.info("简单邮件发送发生异常,邮件收件人:{},邮件发送人:{},邮件内容:{},异常信息:", to, from, content, e);
        }
    }

    @Override
    public void sendTemplateMail(Map<String, Object> params) {
        log.info("jsp我也不晓得么样搞");
    }
}
