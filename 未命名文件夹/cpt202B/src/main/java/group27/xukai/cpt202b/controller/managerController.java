package group27.xukai.cpt202b.controller;


import group27.xukai.cpt202b.entity.Manager;
import jakarta.annotation.Resource;
import group27.xukai.cpt202b.mapper.managerMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class managerController {
    @Resource
    private managerMapper managerMapper;
    @PostMapping("/managerlogin")
    public Manager managerlogin(@RequestBody Manager manager) {
        Manager dbManager = managerMapper.getManagerByNameAndPassword(manager.getManagerID(), manager.getPassword());
        return dbManager;

    }
}
