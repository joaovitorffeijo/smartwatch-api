package com.ufrrj.ihc.smartwatchapi.controller;


import com.ufrrj.ihc.smartwatchapi.model.dto.SmartwatchDataDto;
import com.ufrrj.ihc.smartwatchapi.model.response.*;
import com.ufrrj.ihc.smartwatchapi.service.SmartwatchDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api")
public class SmartwatchApiController {

    @Autowired
    SmartwatchDataService service;

    @GetMapping(value = "/data")
    public ResponseEntity<List<SmartwatchDataDto>> getSmartwatchData() {
        return ResponseEntity.ok(service.getSmartwatchData());
    }

    @GetMapping(value = "/data/rate/heart")
    public ResponseEntity<HeartRate> getHeartRate() {
        return ResponseEntity.ok(service.getHeartRate());
    }

    @GetMapping(value = "/data/rate/calories")
    public ResponseEntity<CaloriesRate> getCaloriesRate() {
        return ResponseEntity.ok(service.getCaloriesRate());
    }

    @GetMapping(value = "/data/rate/step-count")
    public ResponseEntity<StepCountRate> getStepCountRate() {
        return ResponseEntity.ok(service.getStepCountRate());
    }

    @GetMapping(value = "/data/rate/speed")
    public ResponseEntity<SpeedRate> getSpeedRate() {
        return ResponseEntity.ok(service.getSpeedRate());
    }

    @GetMapping(value = "/data/rate/distance")
    public ResponseEntity<DistanceRate> getDistanceRate() {
        return ResponseEntity.ok(service.getDistanceRate());
    }

    @GetMapping(value = "/data/bioimpedance")
    public ResponseEntity<Bioimpedance> getBioimpedance() {
        return ResponseEntity.ok(service.getBioimpedance());
    }

    @PostMapping(value = "/data")
    public ResponseEntity<SmartwatchDataDto> insertSmartwatchData(@RequestBody SmartwatchDataDto dto) {
        return ResponseEntity.ok(service.insertSmartwatchData(dto));
    }

}
