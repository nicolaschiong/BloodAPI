package com.nicolaschiong.review;

import com.nicolaschiong.core.BaseEntity;
import com.nicolaschiong.course.Course;
import com.nicolaschiong.user.User;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created by Nick on 3/20/2017.
 */
@Entity
public class Review extends BaseEntity{

    private int rating;
    private String description;

    @ManyToOne
    private Course course;

    @ManyToOne
    private User reviewer;

    protected Review(){
        super();
    }

    public Review(int rating, String description) {
        this.rating = rating;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public User getReviewer() {
        return reviewer;
    }

    public void setReviewer(User reviewer) {
        this.reviewer = reviewer;
    }
}
