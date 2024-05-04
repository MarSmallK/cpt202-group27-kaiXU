package group27.xukai.cpt202b.service.serviceImpl;

import group27.xukai.cpt202b.entity.Notification;
import group27.xukai.cpt202b.exception.ServiceException;
import group27.xukai.cpt202b.mapper.NotificationMapper;
import group27.xukai.cpt202b.service.NotificationInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class NotificationImpl implements NotificationInterface {

    @Autowired
    private NotificationMapper notificationMapper;


    @Autowired
    private JavaMailSender mailSender;

    private static final Logger logger = LoggerFactory.getLogger(NotificationImpl.class);



    // 查询
    public List<Notification> QueryAll() {
        List<Notification> notifications = notificationMapper.QueryAll();
        return notifications;
    }

    // 查询
    public Notification selectByPrimaryKey(Integer notificationId) {
        Notification notification = notificationMapper.selectByPrimaryKey(notificationId);
        return notification;
    }

    // 新增
    public boolean Add(Notification notification) {
        int i = notificationMapper.insert(notification);
        if (i > 0)
            return true;
        else
            return false;
    }

    // 删除
    public boolean Del(int notificationId) {
        int i = notificationMapper.deleteByPrimaryKey(notificationId);
        if (i > 0)
            return true;
        else
            return false;
    }

    // 更新
    public boolean Update(Notification notification) {
        int i = notificationMapper.updateByPrimaryKey(notification);
        if (i > 0)
            return true;
        else
            return false;
    }

    // 发送通知
    // Sending notification method updated
    public void sendNot(Notification notification) {
        try {
            // Attempt to send email first
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("2667952546@qq.com");
            message.setTo(notification.getCustomerId());
            message.setSubject(notification.getType());
            message.setText(notification.getContent());
            mailSender.send(message);

            // Only insert into database if email was successfully sent
            try {
                notificationMapper.insert(notification);
            } catch (DuplicateKeyException e) {
                logger.error("Failed to insert notification, duplicate ID: {}", notification.getNotificationId(), e);
                // Optionally, rethrow or handle this as needed
            }

        } catch (MailException e) {
            logger.error("Email sending failed", e);
            throw new ServiceException("Email sending failed", e);
        }
    }

    @Override
    public void SendNot(Notification notification) {
        sendNot(notification);
    }

}
