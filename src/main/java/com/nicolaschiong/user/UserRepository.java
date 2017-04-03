package com.nicolaschiong.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;

/**
 * Created by Nick on 3/20/2017.
 */

@RepositoryRestResource
public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
}
