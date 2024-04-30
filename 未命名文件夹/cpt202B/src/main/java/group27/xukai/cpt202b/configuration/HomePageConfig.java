package group27.xukai.cpt202b.configuration;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


    @Controller

    public class HomePageConfig {

        @GetMapping("/")
        public String HomePage() {
            return "homepage";
        }


}
