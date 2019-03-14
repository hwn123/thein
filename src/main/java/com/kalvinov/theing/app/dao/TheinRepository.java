package com.kalvinov.theing.app.dao;

import com.amazonaws.xray.spring.aop.XRayEnabled;
import com.kalvinov.theing.app.model.Record;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@XRayEnabled
public interface TheinRepository extends CrudRepository<Record, Integer> {
}
