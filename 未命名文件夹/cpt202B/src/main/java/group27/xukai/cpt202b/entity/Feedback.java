package group27.xukai.cpt202b.entity;

import java.io.Serializable;

public class Feedback implements Serializable {
    private static final long serialVersionUID = -83466038426029298L;

    private Integer id;
    private Integer coachid;

    private String studentName;

    private String courseName;

    private Integer rating;

    private String feedback;


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getCoachid() {
        return coachid;
    }

    public void setCoachid(Integer coachid) {
        this.coachid = coachid;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

}

