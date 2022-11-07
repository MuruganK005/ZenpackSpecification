package com.example.specification.dao;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;

@Entity
@Table(name = "zen_pack")
public class Zenpack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "zen_pack_id")
    private Long zenPackId;

    @Column(name = "zenpack_name")
    private String zenpackName;

    @Column(name = "menu_name")
    private String menuName;

    @Column(name = "feature_name")
    private String featureName;

    @Column(name = "created_date")
    private Timestamp createdDate = Timestamp.from(Instant.now());

    @Column(name = "updated_time")
    private Timestamp updatedTime = Timestamp.from(Instant.now());

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
