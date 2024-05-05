package group27.xukai.cpt202b.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class MailConfig {

    @Bean
    public JavaMailSender mailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.qq.com"); // SMTP server of QQ
        mailSender.setPort(587); // SMTP port for TLS

        mailSender.setUsername("2667952546@qq.com"); // Your QQ email
        mailSender.setPassword("cwazkbsskuhvdhgg"); // Authorization code generated

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true"); // Enable debug to see more logs

        return mailSender;
    }
}
