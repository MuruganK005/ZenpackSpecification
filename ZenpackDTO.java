package com.example.specification.dto;

import java.sql.Timestamp;
import java.time.Instant;

public class ZenpackDTO {
    String zenpackName;
    String menuName;
    String featureName;
    Timestamp createdDate = Timestamp.from(Instant.now());
    Timestamp updatedTime = Timestamp.from(Instant.now());

    public String getZenpackName() {
        return this.zenpackName;
    }

    public void setZenPackName(String zenpackName) {
        this.zenpackName = zenpackName;
    }

    public String getMenuName() {
        return this.menuName;
    }

    public void setMenuName(String zenpackName) {
        this.menuName = zenpackName;
    }

    public String getFeatureName() {
        return this.featureName;
    }

    public void setFeatureName(String zenpackName) {
        this.menuName = zenpackName;
    }
}
