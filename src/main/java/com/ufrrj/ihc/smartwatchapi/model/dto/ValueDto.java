package com.ufrrj.ihc.smartwatchapi.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ufrrj.ihc.smartwatchapi.model.Value;

public class ValueDto {
    private Long id;

    @JsonProperty("fpVal")
    private Double fpVal;

    @JsonProperty("intVal")
    private Long intVal;

    public ValueDto() {
    }

    public ValueDto(Value value) {
        this.id = value.getId();
        this.fpVal = value.getFpVal();
        this.intVal = value.getIntVal();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getFpVal() {
        return fpVal;
    }

    public void setFpVal(Double fpVal) {
        this.fpVal = fpVal;
    }

    public Long getIntVal() {
        return intVal;
    }

    public void setIntVal(Long intVal) {
        this.intVal = intVal;
    }

    public static ValueDto convertToDtoList(Value value) {
        return new ValueDto(value);
    }
}
