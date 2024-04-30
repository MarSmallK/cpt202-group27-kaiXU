package group27.xukai.cpt202b.service.serviceImpl;

import group27.xukai.cpt202b.entity.Feedback;
import group27.xukai.cpt202b.mapper.FeedbackDao;
import group27.xukai.cpt202b.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
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
    @Autowired
    private FeedbackDao feedbackMapper;
    public List<Feedback> findAllFeedback() {
        return feedbackDao.selectAllFeedback();
    }


}
