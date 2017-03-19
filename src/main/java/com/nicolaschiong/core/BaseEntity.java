package com.nicolaschiong.core;

import javax.persistence.*;

/**
 * Created by Nick on 3/20/2017.
 */

@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final Long id;

    @Version
    private Long version;


    protected BaseEntity() {
        id = null;
    }
}
