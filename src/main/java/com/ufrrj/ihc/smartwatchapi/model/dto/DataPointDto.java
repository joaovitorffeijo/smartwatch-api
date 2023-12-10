package com.ufrrj.ihc.smartwatchapi.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ufrrj.ihc.smartwatchapi.model.DataPoint;

import java.util.ArrayList;
import java.util.List;

public class DataPointDto {
    private Long id;

    @JsonProperty("originDataSourceId")
    private String originDataSourceId;

    @JsonProperty("endTimeNanos")
    private Long endTimeNanos;

    @JsonProperty("startTimeNanos")
    private Long startTimeNanos;

    @JsonProperty("modifiedTimeMillis")
    private Long modifiedTimeMillis;

    @JsonProperty("rawTimestampNanos")
    private Long rawTimestampNanos;

    @JsonProperty("dataTypeName")
    private String dataTypeName;

    @JsonProperty("fitValue")
    private List<FitValueDto> fitValues;

    public DataPointDto() {
        this.fitValues = new ArrayList<>();
    }

    public DataPointDto(DataPoint dataPoint) {
        this.id = dataPoint.getId();
        this.originDataSourceId = dataPoint.getOriginDataSourceId();
        this.endTimeNanos = dataPoint.getEndTimeNanos();
        this.startTimeNanos = dataPoint.getStartTimeNanos();
        this.modifiedTimeMillis = dataPoint.getModifiedTimeMillis();
        this.rawTimestampNanos = dataPoint.getRawTimestampNanos();
        this.dataTypeName = dataPoint.getDataTypeName();
        this.fitValues = FitValueDto.convertToDtoList(dataPoint.getFitValues());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOriginDataSourceId() {
        return originDataSourceId;
    }

    public void setOriginDataSourceId(String originDataSourceId) {
        this.originDataSourceId = originDataSourceId;
    }

    public Long getEndTimeNanos() {
        return endTimeNanos;
    }

    public void setEndTimeNanos(Long endTimeNanos) {
        this.endTimeNanos = endTimeNanos;
    }

    public Long getStartTimeNanos() {
        return startTimeNanos;
    }

    public void setStartTimeNanos(Long startTimeNanos) {
        this.startTimeNanos = startTimeNanos;
    }

    public Long getModifiedTimeMillis() {
        return modifiedTimeMillis;
    }

    public void setModifiedTimeMillis(Long modifiedTimeMillis) {
        this.modifiedTimeMillis = modifiedTimeMillis;
    }

    public Long getRawTimestampNanos() {
        return rawTimestampNanos;
    }

    public void setRawTimestampNanos(Long rawTimestampNanos) {
        this.rawTimestampNanos = rawTimestampNanos;
    }

    public String getDataTypeName() {
        return dataTypeName;
    }

    public void setDataTypeName(String dataTypeName) {
        this.dataTypeName = dataTypeName;
    }

    public List<FitValueDto> getFitValues() {
        return fitValues;
    }

    public void setFitValues(List<FitValueDto> fitValues) {
        this.fitValues = fitValues;
    }

    public static List<DataPointDto> convertToDtoList(List<DataPoint> dataPoints) {
        return dataPoints.stream().map(DataPointDto::new).toList();
    }
}
