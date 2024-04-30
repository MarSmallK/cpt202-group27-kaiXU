package group27.xukai.cpt202b.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class send_notificationController {
    @GetMapping("/send_notification") // 处理根路径
    public String showAddTrainerPage() {
        return "NotificationDisplay";// 返回前端文件的路径
    }
}
