package group27.xukai.cpt202b.controller;

import group27.xukai.cpt202b.service.serviceImpl.RegisterService;
import group27.xukai.cpt202b.service.serviceImpl.UserRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

    private final RegisterService registerService;

    @Autowired
    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @PostMapping("/verifycode")
    public boolean verifycode(@RequestBody UserRequest userRequest, HttpServletRequest request) {
        HttpSession session = request.getSession();
        return registerService.verifyCode(session, userRequest.getCode());
    }

    @PostMapping("/register")
    public String register(@RequestBody UserRequest userRequest, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (!registerService.validateUsername(userRequest.getUsername())) {
            return "用户名长度应在3到10个字符之间";
        }
        if (registerService.userExists(userRequest.getUsername())) {
            return "用户已存在";
        }
        if (registerService.emailExists(userRequest.getEmail())) {
            return "邮箱已被注册";
        }
        if (!registerService.validatePassword(userRequest.getPassword())) {
            return "密码应包含数字和字母，并且长度应在6到15个字符之间";
        }
        if (!registerService.verifyCode(session, userRequest.getCode())) {
            return "验证码错误，请重新输入";
        }
        registerService.registerUser(userRequest.getUsername(), userRequest.getPassword(), userRequest.getEmail());
        return "注册成功";
    }
}
