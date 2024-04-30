package group27.xukai.cpt202b.service;

import group27.xukai.cpt202b.entity.IndividualAppointment;


public interface AppService {


    // 添加个人预约
    void add(IndividualAppointment Appointment);
    //修改预约
    void change(IndividualAppointment Appointment);

    //查询教练
    //void search();

}