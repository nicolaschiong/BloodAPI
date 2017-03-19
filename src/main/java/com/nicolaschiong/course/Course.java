package com.nicolaschiong.course;

import com.nicolaschiong.core.BaseEntity;
import com.nicolaschiong.review.Review;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nick on 3/20/2017.
 */
@Entity
public class Course extends BaseEntity{

    @NotNull
    @Size(min = 2, max = 140)
    private String title;

    private String url;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Review> reviews;

    protected Course(){
        super();
        reviews = new ArrayList<>();
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void addReview(Review review){
        review.setCourse(this);
        reviews.add(review);
    }

    public Course(String title, String url) {
        this();
        this.title = title;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
