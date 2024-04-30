package group27.xukai.cpt202b.service.serviceImpl;


import group27.xukai.cpt202b.entity.User;
import group27.xukai.cpt202b.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String getPasswordByEmail(String email) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            return user.getPassword();
        }
        return null; // 或者抛出异常，视情况而定
    }
}
