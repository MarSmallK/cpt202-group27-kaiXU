package org.example.a.Controller;


import jakarta.annotation.Resource;
import org.example.a.entity.Manager;
import org.example.a.mapper.managerMapper;
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
