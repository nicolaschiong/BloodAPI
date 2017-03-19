package com.nicolaschiong.review;

import com.nicolaschiong.core.BaseEntity;

import javax.persistence.Entity;

/**
 * Created by Nick on 3/20/2017.
 */
@Entity
public class Review extends BaseEntity{
    private int rating;
    private String description;

    protected Review(){

        super();
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
}
