package com.epi.pfa.component;
import com.epi.pfa.mail.Email;
import com.epi.pfa.mail.EmailService;
import com.epi.pfa.mail.EmailTemplate;
import com.epi.pfa.repository.CartRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
/**
 * @author Saber Ben Khalifa <dev.saberkhalifda@gmail.com>
 * @date 5/30/18
 * @time 11:51 PM
 * @utitlity com.epi.pfa.component.ScheduledTasks
 */
@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private EmailService emailService;
    @Scheduled(fixedRate = 300000)
    public void reportCurrentTime() {
        cartRepository.findAll().forEach(cart -> {
            String subject = "Complete Your Purchase";
            EmailTemplate template = new EmailTemplate("cart.html");
            Map<String, String> replacements = new HashMap<String, String>();
            replacements.put("store", cart.getShop().getName()!=null ? cart.getShop().getName() : "");
            replacements.put("city", cart.getShop().getStore().getCity() != null ? cart.getShop().getStore().getCity() : "");
            replacements.put("country", cart.getShop().getStore().getCountry().getName() !=null ? cart.getShop().getStore().getCountry().getName() : "" );
            replacements.put("tel", cart.getShop().getStore().getPhone() !=null ? cart.getShop().getStore().getPhone() : "");
            replacements.put("email", cart.getShop().getStore().getEmail() !=null ?  cart.getShop().getStore().getEmail() : "");
            String message = template.getTemplate(replacements);
            Email email = new Email(cart.getShop().getStore().getEmail(),
                cart.getCustomer().getEmail(), subject, message);
            email.setHtml(true);
            try {
                emailService.sendHtmlMail(email);
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        });
    }
}
