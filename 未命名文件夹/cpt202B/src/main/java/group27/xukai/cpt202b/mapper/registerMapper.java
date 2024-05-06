package group27.xukai.cpt202b.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface registerMapper  {
    @Insert("INSERT INTO users (username, password, email) VALUES (#{username}, #{password}, #{email})")
    void insertUser(@Param("username") String username, @Param("password") String password, @Param("email") String email);
}



