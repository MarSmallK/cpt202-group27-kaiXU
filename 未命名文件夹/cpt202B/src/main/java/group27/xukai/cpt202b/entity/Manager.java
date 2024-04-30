package group27.xukai.cpt202b.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity   //表示这个类是一个实体类
@Table(name = "manager")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Manager {
    @GeneratedValue(strategy = GenerationType.IDENTITY)   //生成策略，这里配置为自增
    @Column(name = "ID")    //对应表中id这一列
    @Id     //此属性为主键
    int id;

    @Column(name = "managerID")   //对应表中username这一列
    private String managerID;

    @Column(name = "password")   //对应表中password这一列
    private String password;
}
