package group27.xukai.cpt202b.service;

import group27.xukai.cpt202b.entity.Notification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NotificationInterface {
    // 查询
    List<Notification> QueryAll();
    // 按Id查询
    Notification selectByPrimaryKey(Integer notificationId);
    // 新增
    boolean Add(Notification notification);
    // 删除
    boolean Del(int notificationId);
    // 修改
    boolean Update(Notification notification);
    // 发送通知
    void sendNot(Notification notification);
    // 发送通知（重载方法）
    void SendNot(Notification notification);
}
