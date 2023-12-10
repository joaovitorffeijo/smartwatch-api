package com.ufrrj.ihc.smartwatchapi.repository;

import com.ufrrj.ihc.smartwatchapi.model.FitValue;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FitValueRepository extends CrudRepository<FitValue, Long> {
}
