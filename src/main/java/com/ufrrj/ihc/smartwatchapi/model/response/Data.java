package com.ufrrj.ihc.smartwatchapi.model.response;

public class Data {

    private Double value;
    private Long time;

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}
