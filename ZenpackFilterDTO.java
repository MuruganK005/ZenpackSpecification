package com.example.specification.dto;

import java.sql.Timestamp;
import java.util.List;

public class ZenpackFilterDTO {
    private Timestamp startDate;
    private Timestamp endDate;
    private String field;
    private String sortType;
    private Integer page;
    private Integer size;
    private List<FilterDTO> filterDTOList;

    public Timestamp getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public String getFiled() {
        return this.field;
    }

    public void setFiled(String field) {
        this.field = field;
    }

    public String getSortType() {
        return this.sortType;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType;
    }

    public Integer getPage() {
        return this.page;
    }

    public void setPage(Integer page) { this.page = page; }

    public Integer getSize() {
        return this.size;
    }

    public void setSize(Integer size) { this.size = size; }

    public List<FilterDTO> getFilterDTOList() {
        return this.filterDTOList;
    }

    public void setFilterDTOList(List<FilterDTO> filterDTOList) {
        this.filterDTOList = filterDTOList;
    }
}
