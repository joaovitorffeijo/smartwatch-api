package com.ufrrj.ihc.smartwatchapi.repository;

import com.ufrrj.ihc.smartwatchapi.model.SmartwatchData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SmartwatchDataRepository extends CrudRepository<SmartwatchData, Long> {
    List<SmartwatchData> findAll();
}
