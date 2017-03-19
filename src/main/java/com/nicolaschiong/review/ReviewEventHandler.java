package com.nicolaschiong.review;

import com.nicolaschiong.user.User;
import com.nicolaschiong.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * Created by Nick on 3/20/2017.
 */
@Component
@RepositoryEventHandler(Review.class)
public class ReviewEventHandler {

    private final UserRepository users;

    @Autowired
    public ReviewEventHandler(UserRepository users){
        this.users = users;
    }

    @HandleBeforeCreate
    public void addReviewerBasedOnLoggedInUser(Review review){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = users.findByUsername(username);
        review.setReviewer(user);
    }
}
