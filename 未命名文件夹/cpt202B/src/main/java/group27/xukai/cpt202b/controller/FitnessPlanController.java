package group27.xukai.cpt202b.controller;

import group27.xukai.cpt202b.entity.FitnessPlan;
import group27.xukai.cpt202b.service.FitnessPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@Controller
@RequestMapping("/member/fitnessplan")
public class FitnessPlanController {
    @Autowired
    private FitnessPlanService fitnessPlanService;

    @GetMapping("")
    public String getFitnessPlan(Model model){
        List<FitnessPlan> fitnessPlans = fitnessPlanService.getFitnessPlanData();
        model.addAttribute("fitnessPlans", fitnessPlans);
        return "FitnessPlan";
    }


}


