package com.example.specification.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

public class FilterDTO {
    String key;
    String value;
    String operator;

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getOperator() {
        return this.operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
