package group27.xukai.cpt202b.controller;

import group27.xukai.cpt202b.service.FitnessPlanService;
import group27.xukai.cpt202b.service.MemberService;
import group27.xukai.cpt202b.entity.FitnessPlan;
import group27.xukai.cpt202b.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public ResponseEntity<String> buyAndUpdate(@RequestBody Map<String, Object> requestBody) {
        String userName = (String) requestBody.get("userName");
        int planId = (int) requestBody.get("planId");
        if (userName == null || planId == 0) {
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
        int currentBalance = memberService.getMemberBalance(userName);

        // 检查余额是否足够支付计划价格
        if (currentBalance < planPrice) {
            return ResponseEntity.badRequest().body("Insufficient balance, purchase failed!");
        }

        // 更新会员的计划级别和计划日期
        memberService.updateMemberWithFitnessPlan(planLevel, planDate, userName);
        memberService.updateMemberPurchasePlanId(planId, userName);

        // 计算扣除计划价格后的新余额
        int newBalance = currentBalance - planPrice;

        // 更新数据库中会员的余额
        memberService.updateMemberBalance(newBalance, userName);

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
            memberService.updateTime(userName, startTime, endTime);
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
    public ResponseEntity<Integer> getBalance(@RequestBody Map<String, String> requestBody) {
        String userName = requestBody.get("userName");
        int balance = memberService.getMemberBalance(userName);

        return ResponseEntity.ok(balance);
    }

    @GetMapping("/getPlanLevel")
    public ResponseEntity<String> getPlanLevel(@RequestBody Map<String, String> requestBody) {
        String userName = requestBody.get("userName");
        // 根据用户ID从数据库中获取用户的余额
        String planLevel = memberService.getPlanLevel(userName);

        return ResponseEntity.ok(planLevel);
    }

    @PostMapping("/deleteAndUpdatePlan")
    public ResponseEntity<String> Update(@RequestBody Map<String, Object> requestBody) {
        int purchasePlanId = (int) requestBody.get("purchasePlanId");
        String userName = (String) requestBody.get("userName");

        if (userName == null || purchasePlanId == 0) {
            return ResponseEntity.badRequest().body("Invalid memberId");
        }

        FitnessPlan fitnessPlan = fitnessPlanService.getFitnessPlanById(purchasePlanId);
        if (fitnessPlan == null) {
            return ResponseEntity.badRequest().body("Invalid planId");
        }

        int planPrice = fitnessPlan.getPlanPrice();

        // 从数据库中获取会员当前余额
        int currentBalance = memberService.getMemberBalance(userName);

        // 计算加上计划价格后的新余额
        int newBalance = currentBalance + planPrice;

        // 更新数据库中会员的余额
        memberService.updateMemberBalance(newBalance, userName);
        // 调用服务层方法删除会员信息
        memberService.clearMemberData(userName);

        return ResponseEntity.ok("Member's fitness plan, balance, and time updated successfully!");
    }
}