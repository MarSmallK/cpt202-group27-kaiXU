package group27.xukai.cpt202b.service.serviceImpl;

import group27.xukai.cpt202b.entity.Member;
import group27.xukai.cpt202b.repository.MemberRepository;
import group27.xukai.cpt202b.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public List<Member> getMemberData() {
        List<Member> members = memberRepository.findAll();
        if (members.isEmpty()){
            return Collections.emptyList();
        }
        return members;
    }

    @Transactional
    @Override
    public void clearMemberData(int Id) {
        memberRepository.clearMemberData(Id);
    }

    @Override
    public int getMemberBalance(int Id) {
        return memberRepository.getBalanceById(Id);
    }


    @Override
    public String getPlanLevel(int Id) {
        return memberRepository.getPlanLevel(Id);
    }

    @Override
    public void updateMemberWithFitnessPlan(String planLevel, String planDate, int Id) {
        Member member = memberRepository.findById(Id).orElse(null);
        if (member != null) {
            member.setPlanLevel(planLevel);
            member.setPlanDate(planDate);
            memberRepository.save(member);
        }
    }

    @Override
    public void updateMemberBalance(int balance, int Id) {
        Member member = memberRepository.findById(Id).orElse(null);
        if (member != null) {
            member.setBalance(balance);
            memberRepository.save(member);
        }
    }

    @Override
    public void updateMemberPurchasePlanId(Integer purchasePlanId, int Id) {
        Member member = memberRepository.findById(Id).orElse(null);
        if (member != null) {
            member.setPurchasePlanId(purchasePlanId);
            memberRepository.save(member);
        }
    }

    @Override
    public void updateTime(int Id, LocalDateTime startTime, LocalDateTime endTime) {
        Member member = memberRepository.findById(Id).orElse(null);
        if (member != null) {
            // 更新用户的开始时间和结束时间
            member.setStartTime(startTime);
            member.setEndTime(endTime);
            // 保存更新后的用户信息到数据库中
            memberRepository.save(member);

        }
    }



}