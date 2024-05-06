package group27.xukai.cpt202b.service.serviceImpl;

import group27.xukai.cpt202b.entity.Feedback;
import group27.xukai.cpt202b.mapper.FeedbackDao;
import group27.xukai.cpt202b.service.FeedbackService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("feedbackService")
public class FeedbackServiceImpl implements FeedbackService {
    @Resource
    private FeedbackDao feedbackDao;


    @Override
    public Feedback queryById(Integer courseid) {
        return this.feedbackDao.queryById(courseid);
    }

    @Override
    public Page<Feedback> queryByPage(Feedback feedback, PageRequest pageRequest) {
        long total = this.feedbackDao.count(feedback);
        return new PageImpl<>(this.feedbackDao.queryAllByLimit(feedback, pageRequest), pageRequest, total);
    }

    @Override
    public Feedback insert(Feedback feedback) {
        this.feedbackDao.insertFeedback(feedback);
        return feedback;
    }

    @Override
    public void delete(Integer id) {
        feedbackDao.deleteById(id);
    }

    @Autowired
    private FeedbackDao feedbackMapper;
    public List<Feedback> findAllFeedback() {
        return feedbackDao.selectAllFeedback();
    }


}
