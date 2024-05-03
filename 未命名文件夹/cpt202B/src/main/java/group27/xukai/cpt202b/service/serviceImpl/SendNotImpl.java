package group27.xukai.cpt202b.service.serviceImpl;

import group27.xukai.cpt202b.entity.Notification;
import group27.xukai.cpt202b.mapper.SendNotMapper;
import group27.xukai.cpt202b.service.SendNotInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendNotImpl implements SendNotInterface {

    @Autowired
    private SendNotMapper sendNotMapper;

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendNot(Notification notification) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("from@example.com");
        message.setTo(notification.getCustomerId()); // customerId is the email address
        message.setSubject(notification.getType());
        message.setText(notification.getContent());
        mailSender.send(message);

        sendNotMapper.insert(notification); // Optionally save the notification
    }

    @Override
    public void SendNot(Notification notification) {

    }
}
