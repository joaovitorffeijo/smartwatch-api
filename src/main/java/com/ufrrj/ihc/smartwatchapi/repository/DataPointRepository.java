package com.ufrrj.ihc.smartwatchapi.repository;

import com.ufrrj.ihc.smartwatchapi.model.DataPoint;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataPointRepository extends CrudRepository<DataPoint, Long> {
    List<DataPoint> findByDataTypeName(String dataTypeName);
}
