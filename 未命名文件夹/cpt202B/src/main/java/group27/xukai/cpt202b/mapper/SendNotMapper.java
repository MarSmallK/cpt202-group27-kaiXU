package group27.xukai.cpt202b.mapper;

import group27.xukai.cpt202b.entity.Notification;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface SendNotMapper {
    int insert(Notification notification);
    Notification selectByPrimaryKey(Integer notificationId);
}
