package com.epi.pfa.mail;
import com.epi.pfa.domain.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 * @author Saber Ben Khalifa <dev.saberkhalifda@gmail.com>
 * @date 5/31/18
 * @time 9:00 PM
 * @utitlity EmailServiceImpl
 */


@Component
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public  void sendHtmlMail(Email eParams) throws MessagingException {
        boolean isHtml = true;
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setTo(eParams.getTo().toArray(new String[eParams.getTo().size()]));
        helper.setFrom(eParams.getFrom());
        helper.setSubject(eParams.getSubject());
        helper.setText(eParams.getMessage(), isHtml);
        if (eParams.getCc().size() > 0) {
            helper.setCc(eParams.getCc().toArray(new String[eParams.getCc().size()]));
        }

        mailSender.send(message);
    }


}
