package com.ufrrj.ihc.smartwatchapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "value")
public class Value {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fp_val")
    @JsonProperty("fpVal")
    private Double fpVal;

    @Column(name = "int_val")
    @JsonProperty("intVal")
    private Long intVal;

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
}
