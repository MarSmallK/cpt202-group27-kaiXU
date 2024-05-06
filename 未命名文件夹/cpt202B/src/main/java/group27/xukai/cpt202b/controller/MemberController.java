package group27.xukai.cpt202b.controller;

import group27.xukai.cpt202b.entity.FitnessPlan;
import group27.xukai.cpt202b.entity.Member;
import group27.xukai.cpt202b.service.FitnessPlanService;
import group27.xukai.cpt202b.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Purchase a fitness plan before membership appointment
 */
@Controller
@RequestMapping("/member/fitnessplan")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private FitnessPlanService fitnessPlanService;

    @PostMapping("/buyAndUpdate")
    public ResponseEntity<String> buyAndUpdate(@RequestBody Map<String, Integer> requestBody) {
        Integer planId = requestBody.get("planId");
        //要改
        int Id = 1;

        if (Id == 0 || planId == null) {
            return ResponseEntity.badRequest().body("Invalid memberId or planId");
        }

        FitnessPlan fitnessPlan = fitnessPlanService.getFitnessPlanById(planId);
        if (fitnessPlan == null) {
            return ResponseEntity.badRequest().body("Invalid planId");
        }

        String planLevel = fitnessPlan.getPlanLevel();
        String planDate = fitnessPlan.getPlanDate();
        int planPrice = fitnessPlan.getPlanPrice();

        // 从数据库中获取会员当前余额
        int currentBalance = memberService.getMemberBalance(Id);

        // 检查余额是否足够支付计划价格
        if (currentBalance < planPrice) {
            return ResponseEntity.badRequest().body("Insufficient balance, purchase failed!");
        }

        // 更新会员的计划级别和计划日期
        memberService.updateMemberWithFitnessPlan(planLevel, planDate, Id);
        memberService.updateMemberPurchasePlanId(planId, Id);

        // 计算扣除计划价格后的新余额
        int newBalance = currentBalance - planPrice;

        // 更新数据库中会员的余额
        memberService.updateMemberBalance(newBalance, Id);

        // 更新会员的时间信息
        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime endTime = null; // 初始化 endTime

        if (Objects.equals(fitnessPlan.getPlanDate(), "6 months")) {
            endTime = startTime.plusMonths(6);
        }
        if (Objects.equals(fitnessPlan.getPlanDate(), "12 months")) {
            endTime = startTime.plusMonths(12);
        }

// 确保 endTime 在此处被赋值后才调用 updateTime 方法
        if (endTime != null) {
            memberService.updateTime(Id, startTime, endTime);
        }
        return ResponseEntity.ok("Member's fitness plan, balance, and time updated successfully!");
    }

    @GetMapping("/View")
    public String getMember(Model model) {
        List<Member> members = memberService.getMemberData();
        model.addAttribute("members", members);
        return "ViewMyFitnessPlan";
    }

    @GetMapping("/getBalance")
    public ResponseEntity<Integer> getBalance() {
        // 假设当前用户的ID已经在会话中存储，或者通过其他方式获取
        // int userId = getCurrentUserId();
        //要改
        int Id = 1;
        // 根据用户ID从数据库中获取用户的余额
        int balance = memberService.getMemberBalance(Id);

        return ResponseEntity.ok(balance);
    }

    @GetMapping("/getPlanLevel")
    public ResponseEntity<String> getPlanLevel() {
        // 假设当前用户的ID已经在会话中存储，或者通过其他方式获取
        // int userId = getCurrentUserId();
        //要改
        int Id = 1;
        // 根据用户ID从数据库中获取用户的余额
        String planLevel = memberService.getPlanLevel(Id);

        return ResponseEntity.ok(planLevel);
    }

    @PostMapping("/deleteAndUpdatePlan")
    public ResponseEntity<String> Update(@RequestBody Map<String, Integer> requestBody) {
        int purchasePlanId = requestBody.get("purchasePlanId");
        int Id = 1;

        if (Id == 0 || purchasePlanId == 0) {
            return ResponseEntity.badRequest().body("Invalid memberId");
        }

        FitnessPlan fitnessPlan = fitnessPlanService.getFitnessPlanById(purchasePlanId);
        if (fitnessPlan == null) {
            return ResponseEntity.badRequest().body("Invalid planId");
        }

        int planPrice = fitnessPlan.getPlanPrice();

        // 从数据库中获取会员当前余额
        int currentBalance = memberService.getMemberBalance(Id);

        // 计算加上计划价格后的新余额
        int newBalance = currentBalance + planPrice;

        // 更新数据库中会员的余额
        memberService.updateMemberBalance(newBalance, Id);
        // 调用服务层方法删除会员信息
        memberService.clearMemberData(Id);

        return ResponseEntity.ok("Member's fitness plan, balance, and time updated successfully!");
    }
}