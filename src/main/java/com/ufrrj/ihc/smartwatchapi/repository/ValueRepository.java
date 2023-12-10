package com.ufrrj.ihc.smartwatchapi.repository;

import com.ufrrj.ihc.smartwatchapi.model.Value;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  ValueRepository extends CrudRepository<Value, Long> {
}
