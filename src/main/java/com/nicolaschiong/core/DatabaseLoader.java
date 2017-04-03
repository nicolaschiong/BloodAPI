package com.nicolaschiong.core;

import com.nicolaschiong.course.Course;
import com.nicolaschiong.course.CourseRepository;
import com.nicolaschiong.review.Review;
import com.nicolaschiong.user.User;
import com.nicolaschiong.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by Nick on 3/20/2017.
 */
@Component
public class DatabaseLoader implements ApplicationRunner {
    private final CourseRepository courses;
    private final UserRepository users;

    @Autowired
    public DatabaseLoader(CourseRepository courses, UserRepository users) {
        this.courses = courses;
        this.users = users;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //Populating for Test
        String[] templates = {
                "Up and Running with %s",
                "%s Basics",
                "%s for Beginners",
                "Under the hood: %s"
        };

        String[] buzzwords = {
                "Spring REST Data",
                "Java 9",
                "Scala",
                "Groovy",
                "Hibernate",
                "Spring HATEOAS"
        };

        List<User> students = Arrays.asList(
                users.save(new User("nicolaschiong", "Nick", "Chiong", "12345", new String[]{"ROLE_USER", "ROLE_ADMIN"}, "nick@usjr.edu.ph", "Tungkop", "Male", "01-19-1996", "#", "A+")),
                users.save(new User("sjimenez", "Shanyl", "Jimenez", "12345", new String[]{"ROLE_USER"}, "nick@usjr.edu.ph", "Lipata", "Female", "01-31-1996", "#", "A+"))

        );

        users.save(students);

        List<Course> bunchOfCourses = new ArrayList<>();
        IntStream.range(0, 100).forEach(i -> {
            String template = templates[i % templates.length];
            String buzzword = buzzwords[i % buzzwords.length];
            String title = String.format(template, buzzword);
            Course c = new Course(title, "http://www.example.com");
            Review review = new Review((i % 5) + 1, String.format("Moar %s please!!!", buzzword));
            review.setReviewer(students.get(i % students.size()));
            //c.addReview(new Review(i % 5, String.format("Moar %s please!", buzzword)));
            bunchOfCourses.add(c);
        });


        courses.save(bunchOfCourses);
    }
}

