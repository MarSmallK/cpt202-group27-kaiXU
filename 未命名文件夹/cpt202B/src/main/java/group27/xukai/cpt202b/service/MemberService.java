package group27.xukai.cpt202b.service;

import group27.xukai.cpt202b.entity.FitnessPlan;
import group27.xukai.cpt202b.entity.Member;

import java.time.LocalDateTime;
import java.util.List;

// MemberService.java
public interface MemberService {
    int getMemberBalance(int Id);
    String getPlanLevel(int Id);
    void updateMemberWithFitnessPlan(String planLevel, String planDate, int Id);
    void updateMemberBalance(int balance, int Id);
    void updateMemberPurchasePlanId(Integer purchasePlanId, int Id);

    void updateTime(int Id, LocalDateTime startTime, LocalDateTime endTime);

    List<Member> getMemberData();

    void clearMemberData(int Id);
}