package group27.xukai.cpt202b.service.serviceImpl;

import group27.xukai.cpt202b.entity.IndividualAppointment;
import group27.xukai.cpt202b.mapper.AppMapper;
import group27.xukai.cpt202b.mapper.idMapper;
import group27.xukai.cpt202b.service.AppService;
import io.micrometer.common.util.StringUtils;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AppServiceImpl implements AppService {

    @Autowired
    private AppMapper appMapper;
    @Autowired
    private idMapper idMapper;
    @Transactional
    @Override
    public void add(IndividualAppointment Appointment) {

        if (Appointment.getMemberID() == 0 || StringUtils.isEmpty(Appointment.getMemberName())) {
            throw new AppointmentValidationException("Please add your personal information");
        }
        if (Appointment.getAppointedTrainerID() == 0) {
            throw new AppointmentValidationException("Please select a particular trainer");
        }
        if (Appointment.getAppointedTime() == null) {
            throw new AppointmentValidationException("Please select appointment time");
        }
        if (appMapper.existsAppointment(Appointment.getAppointedTrainerID(), Appointment.getAppointedTime())) {
            throw new AppointmentValidationException("The current time period is fully booked, please select other suitable time or trainers");
        }
        appMapper.insertAppointment(Appointment);
    }

    @Override
    public void change(IndividualAppointment Appointment) {

        if (Appointment.getAppointedTime().equals(LocalDateTime.now())) {
            throw new AppointmentValidationException("Sorry, you cannot change this appointment.");
        }
        appMapper.updateAppointment(Appointment);
    }


}
/* if (i_appointment.getMemberID() == 0 || StringUtils.isEmpty(i_appointment.getMemberName())) {
                return "Please add your personal information";
            }
            if (i_appointment.getAppointedTrainerID() == 0) {
                return "Please select a particular trainer";
            }
            if (i_appointment.getAppointedTime() == null) {
                return "Please select appointment time";
            }

            if (appMapper.existsAppointment(i_appointment.getAppointedTrainerID(), i_appointment.getAppointedTime())) {
                return "The current time period is fully booked, please select other suitable time or trainers";
            }*/