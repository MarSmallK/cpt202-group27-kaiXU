package group27.xukai.cpt202b.controller;

import group27.xukai.cpt202b.service.TrainerInterface;
import group27.xukai.cpt202b.entity.Trainer;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TrainerController {

    @Autowired
    private TrainerInterface trainerInterface;
    //查询
    @RequestMapping("/TrainerDisplay")
    public ModelAndView Display(){
        ModelAndView modelAndView = new ModelAndView();
        List<Trainer>trainerList = trainerInterface.QueryAll();
        modelAndView.addObject("trainers",trainerList);
        modelAndView.setViewName("TrainerDisplay");
        return modelAndView;

    }
    //删除
    @RequestMapping("/del")
    public ModelAndView del(HttpServletRequest request){
        int trainer_ID = Integer.parseInt(request.getParameter("trainerId"));
        trainerInterface.Del(trainer_ID);
        return new ModelAndView("redirect:/TrainerDisplay");
    }
    //新增
    @GetMapping("/addPage")
    public ModelAndView addPage(Model model){
        model.addAttribute("trainer",new Trainer());
        return new ModelAndView("add","tranmodel",model);
    }
    @PostMapping("/add")
    public ModelAndView add(Trainer trainer){
        trainerInterface.Add(trainer);
        return new ModelAndView("redirect:/TrainerDisplay");
    }
    //更新
    @GetMapping("/sendtrainerId")
    public ModelAndView sendtrainerId(HttpServletRequest request, Model model){
        int trainer_ID = Integer.parseInt(request.getParameter("trainerId"));
        Trainer trainer = trainerInterface.selectByPrimaryKey(trainer_ID);
        model.addAttribute("trainer",trainer);
        return new ModelAndView("Edit","tranmodel",model);
    }
    @PostMapping("/update")
    public ModelAndView update(Trainer trainer){
        trainerInterface.Update(trainer);
        return new ModelAndView("redirect:/TrainerDisplay");
    }
}
