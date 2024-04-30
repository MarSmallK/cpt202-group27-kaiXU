package group27.xukai.cpt202b.entity;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EnableJpaRepositories
@Table(name = "fitness_plan")
public class FitnessPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "plan_Id")
    private int planId;

    @Column(name = "plan_date")
    private String planDate;

    @Column(name = "plan_level")
    private String planLevel;

    @Column(name = "plan_price")
    private int planPrice;

}
