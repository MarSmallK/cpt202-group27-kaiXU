package group27.xukai.cpt202b.service.serviceImpl;

import group27.xukai.cpt202b.entity.idAppointment;
import group27.xukai.cpt202b.mapper.idMapper;
import group27.xukai.cpt202b.service.idService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class idServiceImpl implements idService {
    @Autowired
    private idMapper idMapper;
    @Transactional
    @Override
    public void cancel(idAppointment appointment) {
        idMapper.deleteAppointmentById(appointment.getAppointmentID());
    }



}
