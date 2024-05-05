package group27.xukai.cpt202b.entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.LocalDateTime;

// Member.java
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EnableJpaRepositories
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int Id;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "plan_level")
    private String planLevel;
    @Column(name = "plan_date")
    private String planDate;
    @Column(name = "balance")
    private int balance;
    @Column(name = "start_time")
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private LocalDateTime startTime;
    @Column(name = "end_time")
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private LocalDateTime endTime;
    @Column(name = "purchase_plan_Id")
    private Integer purchasePlanId;


}
