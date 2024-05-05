package group27.xukai.cpt202b.controller;

import group27.xukai.cpt202b.entity.Notification;
import group27.xukai.cpt202b.service.NotificationInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class SendNotController {

    @Autowired
    private NotificationInterface notificationInterface;

    @RequestMapping("/SendNot")
    public ModelAndView DisplaySendNot(){
        ModelAndView modelAndView = new ModelAndView();
        List<Notification> notificationList = notificationInterface.QueryAll();
        modelAndView.addObject("notifications",notificationList);
        modelAndView.setViewName("SendNot");
        return modelAndView;
    }

    @GetMapping("/sendNotification")
    public String sendNotification(@RequestParam("notificationId") Long notificationId, RedirectAttributes redirectAttributes) {
        try {
            Notification notification = notificationInterface.selectByPrimaryKey(Math.toIntExact(notificationId));
            if (notification != null) {
                notificationInterface.sendNot(notification);
                redirectAttributes.addFlashAttribute("message", "Notification sent successfully! The new record has been added below.");
                System.out.println("Notification sent and message added to flash attributes");
            } else {
                redirectAttributes.addFlashAttribute("error", "Error: Notification not found.");
                System.out.println("Notification not found and error added to flash attributes");
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error sending notification.");
            System.out.println("Exception occurred: " + e.getMessage());
        }
        return "redirect:/SendNot"; // Redirecting back to the main page
    }


    @PostMapping("/send")
    @ResponseBody
    public String sendNotification(@RequestBody Notification notification) {
        try {
            notificationInterface.sendNot(notification);
            return "Notification sent successfully!";
        } catch (Exception e) {
            return "Error sending notification: " + e.getMessage();
        }
    }
}
