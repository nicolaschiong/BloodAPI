package com.nicolaschiong.course;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * Created by Nick on 3/20/2017.
 */
@RepositoryRestResource(exported = false)
public interface CourseRepository extends PagingAndSortingRepository<Course, Long> {

    @RestResource(rel = "title-contains", path = "containsTitle")
    Page<Course> findByTitleContaining(@Param("title") String title, Pageable page);
}
