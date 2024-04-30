package group27.xukai.cpt202b.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
    public class PageController {

    @GetMapping("/index")
    public String HomePage() {
        return "index";
    }


    }



