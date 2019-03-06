package com.kalvinov.theing.app.dao;

import com.kalvinov.theing.app.model.Record;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface TheinRepository extends CrudRepository<Record, Integer> {
}
