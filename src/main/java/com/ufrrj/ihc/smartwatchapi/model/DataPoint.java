package com.ufrrj.ihc.smartwatchapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "data_point")
public class DataPoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "smartwatch_data_id")
    private SmartwatchData smartwatchData;

    @Column(name = "origin_data_source_id")
    @JsonProperty("originDataSourceId")
    private String originDataSourceId;

    @Column(name = "end_time_nanos")
    @JsonProperty("endTimeNanos")
    private Long endTimeNanos;

    @Column(name = "start_time_nanos")
    @JsonProperty("startTimeNanos")
    private Long startTimeNanos;

    @Column(name = "modified_time_millis")
    @JsonProperty("modifiedTimeMillis")
    private Long modifiedTimeMillis;

    @Column(name = "raw_timestamp_nanos")
    @JsonProperty("rawTimestampNanos")
    private Long rawTimestampNanos;

    @Column(name = "data_type_name")
    @JsonProperty("dataTypeName")
    private String dataTypeName;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "data_point_id")
    @JsonProperty("fitValue")
    private List<FitValue> fitValues;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SmartwatchData getSmartwatchData() {
        return smartwatchData;
    }

    public void setSmartwatchData(SmartwatchData smartwatchData) {
        this.smartwatchData = smartwatchData;
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

    public List<FitValue> getFitValues() {
        return fitValues;
    }

    public void setFitValues(List<FitValue> fitValues) {
        this.fitValues = fitValues;
    }
}