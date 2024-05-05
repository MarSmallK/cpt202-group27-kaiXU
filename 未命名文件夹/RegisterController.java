package org.example.a.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.example.a.model.UserRequest;
import org.example.a.service.RegisterService;
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
    public Boolean register(@RequestBody UserRequest userRequest, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (registerService.userExists(userRequest.getUsername())) {
            return false;
        }
        if (registerService.emailExists(userRequest.getEmail())) {
            return false;
        }
        if (!registerService.validatePassword(userRequest.getPassword())) {
            return false;
        }
        if (!registerService.verifyCode(session, userRequest.getCode())) {
            return false;
        }
        registerService.registerUser(userRequest.getUsername(), userRequest.getPassword(), userRequest.getEmail());
        return true;
    }
    @PostMapping("check_username")
    public Boolean checkusername(@RequestBody UserRequest userRequest, HttpServletRequest request) {
        if (registerService.userExists(userRequest.getUsername())) {
            return false;
        }
        return true;
    }
    @PostMapping("check_email")
    public Boolean checkemail(@RequestBody UserRequest userRequest, HttpServletRequest request) {
        if (registerService.emailExists(userRequest.getEmail())) {
            return false;
        }
        return true;
    }
}
