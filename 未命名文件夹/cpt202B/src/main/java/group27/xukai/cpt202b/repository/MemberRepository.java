package group27.xukai.cpt202b.repository;


import group27.xukai.cpt202b.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
    @Query(value = "SELECT balance FROM member WHERE Id = ?1", nativeQuery = true)
    int getBalanceByUserName(String userName);
    @Query(value = "SELECT plan_level FROM member WHERE Id = ?1", nativeQuery = true)
    String getPlanLevel(String userName);

    @Modifying
    @Query(value = "UPDATE member SET plan_level = null, plan_date = null, start_time = null, end_time = null, purchase_plan_Id = null WHERE Id = :Id", nativeQuery = true)
    void clearMemberData(@Param("userName") String userName);

    Member findByUserName(String userName); // 根据用户名查询用户信息


}

