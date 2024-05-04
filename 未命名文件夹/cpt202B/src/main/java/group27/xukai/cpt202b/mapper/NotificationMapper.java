package group27.xukai.cpt202b.mapper;

import group27.xukai.cpt202b.entity.Notification;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface NotificationMapper {
    // 删除
    int deleteByPrimaryKey(Integer notificationId);

    // 新增
    int insert(Notification record);

    // 新增2
    int insertSelective(Notification record);

    // 查询
    Notification selectByPrimaryKey(Integer notificationId);

    // 更新
    int updateByPrimaryKeySelective(Notification record);

    // 更新
    int updateByPrimaryKey(Notification record);

    // 查询(所有）
    List<Notification> QueryAll();

    // 插入
    int insertSendNot(Notification notification);

    // 查询
    Notification selectSendNotByPrimaryKey(Integer notificationId);
}
