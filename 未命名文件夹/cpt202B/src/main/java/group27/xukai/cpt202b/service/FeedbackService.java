package group27.xukai.cpt202b.service;

import group27.xukai.cpt202b.entity.Feedback;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;


public interface FeedbackService {

    Feedback queryById(Integer courseid);

    Page<Feedback> queryByPage(Feedback feedback, PageRequest pageRequest);

    Feedback insert(Feedback feedback);

    public List<Feedback> findAllFeedback();

}
