package com.softserve.message_sender.service;

import com.softserve.message_sender.domain.UserReceipt;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@RequiredArgsConstructor
@Log4j2
public class MailServiceImpl implements MailService {

    private final JavaMailSender javaMailSender;

    public void sendReceiptMessage(UserReceipt userReceipt) {
        MimeMessage message = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(userReceipt.getMail());
            helper.setSubject(UserReceipt.TITLE);
            helper.setText(userReceipt.toString());

            javaMailSender.send(message);
            log.info("Mail was successfully sent");
        } catch (MessagingException e) {
            log.error("Mail wasn't sent, exception: {}", e.getMessage());
        }
    }
}