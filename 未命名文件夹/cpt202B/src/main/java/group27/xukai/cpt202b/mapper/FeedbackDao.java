package group27.xukai.cpt202b.mapper;

import group27.xukai.cpt202b.entity.Feedback;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

@Mapper
public interface FeedbackDao {

    Feedback queryById(Integer courseid);

    List<Feedback> queryAllByLimit(Feedback feedback, @Param("pageable") Pageable pageable);

    long count(Feedback feedback);

   @Insert("INSERT INTO feedback (coachid,studentname, coursename, rating, feedback) " +
           "VALUES (1,#{studentName}, #{courseName}, #{rating}, #{feedback})")
    void insertFeedback(Feedback feedback);

    int update(Feedback feedback);

    List<Feedback> selectAllFeedback();

    @Delete("DELETE FROM feedback WHERE id = #{id}")
    void deleteById(Integer id);
}

