package com.nicolaschiong.review;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

/**
 * Created by Nick on 3/20/2017.
 */
@RepositoryRestResource(exported = false)
public interface ReviewRepository extends PagingAndSortingRepository<Review, Long> {
    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN') or @reviewRepository.findOne(#id)?.reviewer?.username == authentication.name")
    void delete(@Param("id") Long id);

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN') or @review.reviewer?.username == authentication.name")
    void delete(Review entity);
}
