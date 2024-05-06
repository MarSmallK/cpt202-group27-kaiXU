package group27.xukai.cpt202b.mapper;

import group27.xukai.cpt202b.entity.Manager;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface managerMapper {
        @Select("SELECT * FROM manager WHERE managerID = #{managerID} AND password = #{password}")
        Manager getManagerByNameAndPassword(@Param("managerID") String managerID, @Param("password") String password);


}
