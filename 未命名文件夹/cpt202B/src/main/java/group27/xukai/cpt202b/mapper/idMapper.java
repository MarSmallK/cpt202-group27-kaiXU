package group27.xukai.cpt202b.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface idMapper {

    //取消预约
    @Delete("DELETE FROM i_appointment WHERE AppointmentID = #{id}")
    void deleteAppointmentById(@Param("id") Integer id);
}
