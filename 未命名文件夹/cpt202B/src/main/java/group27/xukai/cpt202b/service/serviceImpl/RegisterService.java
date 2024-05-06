package group27.xukai.cpt202b.service.serviceImpl;

import group27.xukai.cpt202b.entity.User;
import group27.xukai.cpt202b.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    private final UserRepository userRepository;

    @Autowired
    public RegisterService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean userExists(String username) {
        return userRepository.existsByUsername(username);
    }
    public boolean emailExists(String email) {
        return userRepository.existsByEmail(email);
    }

    public void registerUser(String username, String password, String email) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        userRepository.save(user);
    }

    public boolean verifyCode(HttpSession session, String code) {
        Integer sessionCode = (Integer) session.getAttribute("code");
        if (sessionCode == null) {
            // 如果 session 中没有验证码，返回 false
            return false;
        }
        // 与请求中的验证码进行比较
        return sessionCode.toString().equals(code);
    }

    public boolean validateUsername(String username) {
        // 判断用户名长度是否在3到10个字符之间
        if (username.length() < 3 || username.length() > 10) {
            return false;
        }
        return true;
    }

    public boolean validatePassword(String password) {
        // 判断密码长度是否在6到15个字符之间
        if (password.length() < 6 || password.length() > 15) {
            return false;
        }
        // 判断密码是否包含数字和字母
        boolean hasDigit = false;
        boolean hasLetter = false;
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (Character.isLetter(c)) {
                hasLetter = true;
            }
            if (hasDigit && hasLetter) {
                return true;
            }
        }
        return false;
    }
}

