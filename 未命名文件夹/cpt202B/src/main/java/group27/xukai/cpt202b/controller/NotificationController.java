package group27.xukai.cpt202b.controller;

import group27.xukai.cpt202b.service.NotificationInterface;
import group27.xukai.cpt202b.entity.Notification;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class NotificationController {

    @Autowired
    private NotificationInterface notificationInterface;
    //查询
    @RequestMapping("/NotificationDisplay")
    public ModelAndView DisplayNot(){
        ModelAndView modelAndView = new ModelAndView();
        List<Notification>notificationList = notificationInterface.QueryAll();
        modelAndView.addObject("notifications",notificationList);
        modelAndView.setViewName("NotificationDisplay");
        return modelAndView;

    }
    //删除
    @RequestMapping("/delNot")
    public ModelAndView delNot(HttpServletRequest request){
        int notificationId = Integer.parseInt(request.getParameter("notificationId"));
        notificationInterface.Del(notificationId);
        return new ModelAndView("redirect:/NotificationDisplay");
    }
    //新增
    @GetMapping("/addPageNot")
    public ModelAndView addPageNot(Model model){
        model.addAttribute("notification",new Notification());
        return new ModelAndView("addNot","notmodel",model);
    }
    @PostMapping("/addNot")
    public ModelAndView addNot(Notification notification){
        notificationInterface.Add(notification);
        return new ModelAndView("redirect:/NotificationDisplay");
    }
    //更新
    @GetMapping("/sendnotificationId")
    public ModelAndView sendnotificationId(HttpServletRequest request, Model model){
        int notificationId = Integer.parseInt(request.getParameter("notificationId"));
        Notification notification = notificationInterface.selectByPrimaryKey(notificationId);
        model.addAttribute("notification",notification);
        return new ModelAndView("EditNot","notmodel",model);
    }
    @PostMapping("/updateNot")
    public ModelAndView updateNot(Notification notification){
        notificationInterface.Update(notification);
        return new ModelAndView("redirect:/NotificationDisplay");
    }

}
