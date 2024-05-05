package org.example.a.Controller;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;
@Controller

public class EmailsenderController {
    @Resource
    JavaMailSender sender;
    @PostMapping("/code")
    public ResponseEntity<String> getCode(@RequestParam String email,
                                          HttpSession session) {
        Random random = new Random();
        int code = random.nextInt(90000) + 10000;
        session.setAttribute("code", code);
        session.setAttribute("email", email);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("Email verification code");
        message.setText("Your verification code is " + code);
        message.setTo(email);
        message.setFrom("13585348990@163.com");
        sender.send(message);
        return ResponseEntity.status(HttpStatus.OK).body("发送成功");
    }
}
