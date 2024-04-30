

package group27.xukai.cpt202b.mapper;
import group27.xukai.cpt202b.entity.IndividualAppointment;

/*
@Repository
public interface AppMapper extends JpaRepository<i_appointment, Long> {
    // JpaRepository提供了很多CRUD方法，包括保存一个实体的方法
}*/

import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface AppMapper {

    //检查预约是否重复
    @Select("SELECT COUNT(*) > 0 FROM i_appointment WHERE TrainerID = #{TrainerId} AND AppointedTime = #{AppointedTime}")
    boolean existsAppointment(@Param("trainerId") Integer trainerId, @Param("appointedTime") LocalDateTime appointedTime);
    //添加预约
    @Insert("INSERT INTO i_appointment(MemberID, MemberName, AppointedTrainerID,AppointedTime) " +
            "VALUES(#{MemberID}, #{MemberName}, #{AppointedTrainerID},#{AppointedTime})")
    @Options(useGeneratedKeys = true, keyProperty = "appointmentID")
    void insertAppointment(@Param("") IndividualAppointment Appointment);

    //修改预约
    @Update("UPDATE i_appointment SET MemberID = #{MemberID}, MemberName = #{MemberName}, " +
            "AppointedTrainerID = #{AppointedTrainerID}, AppointedTime = #{AppointedTime} WHERE AppointmentID = #{AppointmentID}")
    void updateAppointment(IndividualAppointment appointment);



   //查看所有预约
    @Select("SELECT * FROM i_appointment")
    List<IndividualAppointment> getAllAppointments();

    //查询某个预约
    @Select("SELECT * FROM i_appointment WHERE AppointmentID = #{id}")
    IndividualAppointment getAppointmentById(@Param("id") Integer id);



}