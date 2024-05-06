package group27.xukai.cpt202b.service.serviceImpl;

import group27.xukai.cpt202b.entity.Notification;
import group27.xukai.cpt202b.mapper.NotificationMapper;
import group27.xukai.cpt202b.service.NotificationInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationImpl implements NotificationInterface {

    @Autowired
    private NotificationMapper notificationMapper;
    //查询
    public List<Notification> QueryAll() {

        List<Notification> notifications = notificationMapper.QueryAll();
        return notifications;
    }
    //查询
    public Notification selectByPrimaryKey(Integer notificationId){
        Notification notification = notificationMapper.selectByPrimaryKey(notificationId);
        return notification;
    }
    //新增
    public boolean Add(Notification notification) {
        int i = notificationMapper.insert(notification);
        if(i>0)
            return true;
        else
            return false;
    }

    //删除
    public boolean Del(int notificationId) {
        int i = notificationMapper.deleteByPrimaryKey(notificationId);
        if(i>0)
            return true;
        else
            return false;
    }

    //更新
    public boolean Update(Notification notification) {
        int i = notificationMapper.updateByPrimaryKey(notification);
        if(i>0)
            return true;
        else
            return false;
    }
}
