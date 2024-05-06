package group27.xukai.cpt202b.controller;

import group27.xukai.cpt202b.entity.Feedback;
import group27.xukai.cpt202b.service.FeedbackService;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("feedback")
public class FeedbackController {

    @Resource
    private FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<Page<Feedback>> queryByPage(Feedback feedback, PageRequest pageRequest) {
        return ResponseEntity.ok(this.feedbackService.queryByPage(feedback, pageRequest));
    }

    @GetMapping("{id}")
    @ResponseBody
    public ResponseEntity<Feedback> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.feedbackService.queryById(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        feedbackService.delete(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/feedback")
    public String showFeedback() {
        return "feedback";
    }

    @GetMapping("/showfeedback")
    public String getAllFeedbacks(Model model) {
        List<Feedback> feedbackList = feedbackService.findAllFeedback();
        model.addAttribute("feedbacks", feedbackList);
        return "showPage";
    }
    @PostMapping
    public ResponseEntity<Feedback> add(@RequestBody Feedback feedback) {
        Feedback savedFeedback = feedbackService.insert(feedback);
        if (savedFeedback != null) {
            return ResponseEntity.ok(savedFeedback);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}

