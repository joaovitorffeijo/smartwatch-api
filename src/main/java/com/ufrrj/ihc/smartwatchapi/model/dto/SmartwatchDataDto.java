package com.ufrrj.ihc.smartwatchapi.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ufrrj.ihc.smartwatchapi.model.SmartwatchData;

import java.util.List;

public class SmartwatchDataDto {
    private Long id;

    @JsonProperty("Data Source")
    private String dataSource;

    @JsonProperty("Data Points")
    private List<DataPointDto> dataPoints;

    public SmartwatchDataDto() {
    }

    public SmartwatchDataDto(SmartwatchData smartwatchData) {
        this.id = smartwatchData.getId();
        this.dataSource = smartwatchData.getDataSource();
        this.dataPoints = DataPointDto.convertToDtoList(smartwatchData.getDataPoints());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public List<DataPointDto> getDataPoints() {
        return dataPoints;
    }

    public void setDataPoints(List<DataPointDto> dataPoints) {
        this.dataPoints = dataPoints;
    }
}
