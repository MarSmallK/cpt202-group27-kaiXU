package group27.xukai.cpt202b.service;

import group27.xukai.cpt202b.entity.Member;

import java.time.LocalDateTime;
import java.util.List;

// MemberService.java
public interface MemberService {
    int getMemberBalance(String userName);
    String getPlanLevel(String userName);
    void updateMemberWithFitnessPlan(String planLevel, String planDate, String userName);
    void updateMemberBalance(int balance, String userName);
    void updateMemberPurchasePlanId(Integer purchasePlanId, String userName);

    void updateTime(String userName, LocalDateTime startTime, LocalDateTime endTime);

    List<Member> getMemberData();

    void clearMemberData(String userName);
}