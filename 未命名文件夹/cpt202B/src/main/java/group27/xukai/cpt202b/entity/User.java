package group27.xukai.cpt202b.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity   //表示这个类是一个实体类
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
        @GeneratedValue(strategy = GenerationType.IDENTITY)   //生成策略，这里配置为自增
        @Column(name = "ID")    //对应表中id这一列
        @Id     //此属性为主键
        int id;

        @Column(name = "username")   //对应表中username这一列
        private String username;

        @Column(name = "password")   //对应表中password这一列
       private String password;

    @Column(name = "email")   //对应表中password这一列
    private String email;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

