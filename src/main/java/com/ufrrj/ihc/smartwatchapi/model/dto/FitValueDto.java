package com.ufrrj.ihc.smartwatchapi.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ufrrj.ihc.smartwatchapi.model.FitValue;

import java.util.List;
import java.util.stream.Collectors;

public class FitValueDto {
    private Long id;

    @JsonProperty("value")
    private ValueDto value;

    public FitValueDto() {
    }

    public FitValueDto(FitValue fitValue) {
        this.id = fitValue.getId();
        this.value = ValueDto.convertToDtoList(fitValue.getValue());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ValueDto getValue() {
        return value;
    }

    public void setValue(ValueDto value) {
        this.value = value;
    }

    public static List<FitValueDto> convertToDtoList(List<FitValue> fitValues) {
        return fitValues.stream().map(FitValueDto::new).collect(Collectors.toList());
    }
}
