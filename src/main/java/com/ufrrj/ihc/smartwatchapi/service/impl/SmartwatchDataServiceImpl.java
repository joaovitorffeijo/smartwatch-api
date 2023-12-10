package com.ufrrj.ihc.smartwatchapi.service.impl;

import com.ufrrj.ihc.smartwatchapi.model.DataPoint;
import com.ufrrj.ihc.smartwatchapi.model.FitValue;
import com.ufrrj.ihc.smartwatchapi.model.SmartwatchData;
import com.ufrrj.ihc.smartwatchapi.model.Value;
import com.ufrrj.ihc.smartwatchapi.model.dto.DataPointDto;
import com.ufrrj.ihc.smartwatchapi.model.dto.FitValueDto;
import com.ufrrj.ihc.smartwatchapi.model.dto.SmartwatchDataDto;
import com.ufrrj.ihc.smartwatchapi.model.dto.ValueDto;
import com.ufrrj.ihc.smartwatchapi.model.response.*;
import com.ufrrj.ihc.smartwatchapi.repository.DataPointRepository;
import com.ufrrj.ihc.smartwatchapi.repository.FitValueRepository;
import com.ufrrj.ihc.smartwatchapi.repository.SmartwatchDataRepository;
import com.ufrrj.ihc.smartwatchapi.repository.ValueRepository;
import com.ufrrj.ihc.smartwatchapi.service.SmartwatchDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("SmartwatchApiService")
public class SmartwatchDataServiceImpl implements SmartwatchDataService {

    @Autowired
    SmartwatchDataRepository smartwatchDataRepository;

    @Autowired
    DataPointRepository dataPointRepository;

    @Autowired
    FitValueRepository fitValueRepository;

    @Autowired
    ValueRepository valueRepository;

    @Override
    public List<SmartwatchDataDto> getSmartwatchData() {
        List<SmartwatchData> smartwatchDataList = smartwatchDataRepository.findAll();

        List<SmartwatchDataDto> smartwatchDataDtoList = new ArrayList<>();

        for (SmartwatchData smartwatchData : smartwatchDataList) {
            SmartwatchDataDto smartwatchDataDto = new SmartwatchDataDto(smartwatchData);

            smartwatchDataDtoList.add(smartwatchDataDto);
        }

        return smartwatchDataDtoList;
    }

    public HeartRate getHeartRate() {
        List<DataPoint> dataPointList = dataPointRepository.findByDataTypeName("com.google.heart_rate.bpm");

        HeartRate heartRate = new HeartRate();
        List<Data> dataList = new ArrayList<>();

        for (DataPoint dataPoint : dataPointList) {
            Data data = new Data();

            data.setValue(dataPoint.getFitValues().get(0).getValue().getFpVal());
            data.setTime(dataPoint.getEndTimeNanos());

            dataList.add(data);
        }

        heartRate.setData(dataList);

        return heartRate;
    }

    public CaloriesRate getCaloriesRate() {
        List<DataPoint> dataPointList = dataPointRepository.findByDataTypeName("com.google.calories.expended");

        CaloriesRate caloriesRate = new CaloriesRate();
        List<Data> dataList = new ArrayList<>();

        for (DataPoint dataPoint : dataPointList) {
            Data data = new Data();

            data.setValue(dataPoint.getFitValues().get(0).getValue().getFpVal());
            data.setTime(dataPoint.getEndTimeNanos());

            dataList.add(data);
        }

        caloriesRate.setData(dataList);

        return caloriesRate;
    }

    public StepCountRate getStepCountRate() {
        List<DataPoint> dataPointList = dataPointRepository.findByDataTypeName("com.google.step_count.delta");

        StepCountRate stepCountRate = new StepCountRate();
        List<Data> dataList = new ArrayList<>();

        for (DataPoint dataPoint : dataPointList) {
            Data data = new Data();

            data.setValue(dataPoint.getFitValues().get(0).getValue().getIntVal().doubleValue());
            data.setTime(dataPoint.getEndTimeNanos());

            dataList.add(data);
        }

        stepCountRate.setData(dataList);

        return stepCountRate;
    }

    public SpeedRate getSpeedRate() {
        List<DataPoint> dataPointList = dataPointRepository.findByDataTypeName("com.google.speed");

        SpeedRate speedRate = new SpeedRate();
        List<Data> dataList = new ArrayList<>();

        for (DataPoint dataPoint : dataPointList) {
            Data data = new Data();

            data.setValue(dataPoint.getFitValues().get(0).getValue().getFpVal());
            data.setTime(dataPoint.getEndTimeNanos());

            dataList.add(data);
        }

        speedRate.setData(dataList);

        return speedRate;
    }

    public DistanceRate getDistanceRate() {
        List<DataPoint> dataPointList = dataPointRepository.findByDataTypeName("com.google.distance.delta");

        DistanceRate distanceRate = new DistanceRate();
        List<Data> dataList = new ArrayList<>();

        for (DataPoint dataPoint : dataPointList) {
            Data data = new Data();

            data.setValue(dataPoint.getFitValues().get(0).getValue().getFpVal());
            data.setTime(dataPoint.getEndTimeNanos());

            dataList.add(data);
        }

        distanceRate.setData(dataList);

        return distanceRate;
    }

    public Bioimpedance getBioimpedance() {
        List<DataPoint> weightPointList = dataPointRepository.findByDataTypeName("com.google.weight");
        DataPoint actualWeightDataPoint = weightPointList.get(weightPointList.size() - 1);

        List<DataPoint> heightPointList = dataPointRepository.findByDataTypeName("com.google.height");
        DataPoint actualHeightDataPoint = heightPointList.get(weightPointList.size() - 1);

        Bioimpedance bioimpedance = new Bioimpedance();

        Double weight = actualWeightDataPoint.getFitValues().get(0).getValue().getFpVal();
        Double height = actualHeightDataPoint.getFitValues().get(0).getValue().getFpVal();

        bioimpedance.setHeight(height);
        bioimpedance.setWeight(weight);
        bioimpedance.setImc(weight/(height*height));

        return bioimpedance;
    }

    @Override
    public SmartwatchDataDto insertSmartwatchData(SmartwatchDataDto dto) {
        SmartwatchData entity = validateAndSetSmartwachData(dto);

        return new SmartwatchDataDto(smartwatchDataRepository.save(entity));
    }

    private SmartwatchData validateAndSetSmartwachData(SmartwatchDataDto dto) {
        SmartwatchData smartwatchData = new SmartwatchData();

        smartwatchData.setDataSource(dto.getDataSource());

        List<DataPoint> dataPoints = new ArrayList<>();

        for (DataPointDto  dataPointDto : dto.getDataPoints()) {
            DataPoint dataPoint = validateAndSetDataPoint(dataPointDto);

            dataPoints.add(dataPoint);
        }

        smartwatchData.setDataPoints(dataPoints);

        return smartwatchData;
    }

    private DataPoint validateAndSetDataPoint(DataPointDto dto) {
        DataPoint dataPoint = new DataPoint();

        dataPoint.setOriginDataSourceId(dto.getOriginDataSourceId());
        dataPoint.setEndTimeNanos(dto.getEndTimeNanos());
        dataPoint.setStartTimeNanos(dto.getStartTimeNanos());
        dataPoint.setModifiedTimeMillis(dto.getModifiedTimeMillis());
        dataPoint.setRawTimestampNanos(dto.getRawTimestampNanos());
        dataPoint.setDataTypeName(dto.getDataTypeName());

        List<FitValue> fitValues = new ArrayList<>();

        for (FitValueDto fitValueDto : dto.getFitValues()) {
            FitValue fitValue = validateAndSetFitValue(fitValueDto);

            fitValues.add(fitValue);
        }

        dataPoint.setFitValues(fitValues);

        return dataPoint;
    }

    private FitValue validateAndSetFitValue(FitValueDto fitValueDto) {
        FitValue fitValue = new FitValue();

        fitValue.setValue(validateAndSetValue(fitValueDto.getValue()));

        return fitValue;
    }

    private Value validateAndSetValue(ValueDto valueDto) {
        Value value = new Value();

        if (valueDto.getFpVal() != null)
            value.setFpVal(valueDto.getFpVal());
        if (valueDto.getIntVal() != null)
            value.setIntVal(valueDto.getIntVal());

        return value;
    }
}