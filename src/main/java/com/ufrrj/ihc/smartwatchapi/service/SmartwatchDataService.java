package com.ufrrj.ihc.smartwatchapi.service;

import com.ufrrj.ihc.smartwatchapi.model.dto.SmartwatchDataDto;
import com.ufrrj.ihc.smartwatchapi.model.response.*;

import java.util.List;

public interface SmartwatchDataService {

    List<SmartwatchDataDto> getSmartwatchData();

    HeartRate getHeartRate();

    CaloriesRate getCaloriesRate();

    StepCountRate getStepCountRate();

    SpeedRate getSpeedRate();

    DistanceRate getDistanceRate();

    Bioimpedance getBioimpedance();

    SmartwatchDataDto insertSmartwatchData(SmartwatchDataDto dto);
}
