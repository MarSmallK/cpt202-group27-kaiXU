package group27.xukai.cpt202b.controller;

import group27.xukai.cpt202b.entity.Profile;
import group27.xukai.cpt202b.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



    @Controller
    public class ProfileController {

        @GetMapping("/member/page")
        public String getMemberPage() {
            return "MemberPage"; // 返回 memberpage.html 页面
        }


        @Autowired
        private ProfileService profileService;

        @PostMapping("/save")
        public Profile saveProfile(@RequestBody Profile profile) {
            return profileService.insert(profile);
        }
    }
