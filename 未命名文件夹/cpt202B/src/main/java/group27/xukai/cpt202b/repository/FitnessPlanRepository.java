package group27.xukai.cpt202b.repository;


import group27.xukai.cpt202b.entity.FitnessPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FitnessPlanRepository extends JpaRepository<FitnessPlan, Integer> {

}
