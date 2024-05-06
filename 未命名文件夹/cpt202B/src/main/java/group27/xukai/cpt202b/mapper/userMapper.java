package group27.xukai.cpt202b.mapper;

import group27.xukai.cpt202b.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
@Mapper
public interface userMapper {
    @Select("SELECT * FROM users WHERE username = #{username} AND password = #{password}")
    User getUserByNameAndPassword(@Param("username") String username, @Param("password") String password);

    @Select("SELECT * FROM users WHERE email = #{email}")
    User getUserByEmail(@Param("email") String email);

    @Select("SELECT password FROM users WHERE email = #{email}")
    String getPasswordByEmail(@Param("email") String email);

    @Update("UPDATE users SET password = #{password} WHERE email = #{email}")
    void updatePasswordByEmail(@Param("email") String email, @Param("password") String password);

}
