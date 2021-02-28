package com.springdataone.relationships.repositories;

import com.springdataone.relationships.models.License;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LicenseRepository extends CrudRepository<License, Long> {
    License findTopByOrderByNumberDesc();
}
