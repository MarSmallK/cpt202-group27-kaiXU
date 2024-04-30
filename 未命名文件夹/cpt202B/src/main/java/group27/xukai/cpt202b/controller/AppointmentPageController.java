package group27.xukai.cpt202b.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

    @Controller
    public class AppointmentPageController {

        @GetMapping("/BookTrainer")
        public String page1(){

            return "BookTrainer";
        }

        @GetMapping("/ChangeAppointment")
        public String page2(){
            return "ChangeAppointment";
        }

        @GetMapping("/ViewAppointment")
        public String page3(){
            return "ViewAppointment";
        }


    }



