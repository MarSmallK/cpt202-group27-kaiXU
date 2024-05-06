package group27.xukai.cpt202b.controller;

import group27.xukai.cpt202b.entity.idAppointment;
import group27.xukai.cpt202b.service.serviceImpl.AppointmentValidationException;
import group27.xukai.cpt202b.service.idService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import group27.xukai.cpt202b.entity.IndividualAppointment;
import group27.xukai.cpt202b.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class appointmentController {

    private final AppService appService;
    private static final Logger log = LoggerFactory.getLogger(appointmentController.class);

    @Autowired
    public appointmentController(AppService appService, idService idService) {
        this.appService = appService;
        this.idService = idService;
    }

    @PostMapping("/member/appointment/submitAppointment")
    public ResponseEntity<String> addAppointment(@RequestBody IndividualAppointment Appointment) {
         log.info("add new appointment:{}-------------------------------------", Appointment);
//        System.out.println(i_appointment);
        try {
            appService.add(Appointment);
            return ResponseEntity.ok("Successfully booked");
        } catch (AppointmentValidationException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

        @PostMapping("member/appointment/changeAppointment")
        public ResponseEntity<String> changeAppointment (@RequestBody IndividualAppointment IndividualAppointment){
            try {
                appService.change(IndividualAppointment);
                return ResponseEntity.ok("Appointment has been changed successfully");
            } catch (AppointmentValidationException e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }


    private final idService idService;
        @PostMapping("member/appointment/cancelAppointment")
        public ResponseEntity<String> cancelAppointment(@RequestBody idAppointment appointment){
            try {
                idService.cancel(appointment);
                return ResponseEntity.ok("Successfully booked");
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed");
            }
        }


    }