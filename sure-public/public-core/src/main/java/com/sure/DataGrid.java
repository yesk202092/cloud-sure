package com.sure;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DataGrid<T> implements Serializable {
    private static final long serialVersionUID = -4353059775338989141L;
    private Integer total;
    private List<T> rows;
    private Integer pages;
    private Integer recordsTotal;
    private Integer recordsFiltered;
    private String identified;

    public DataGrid() {
        this.identified = "id";
    }

    public DataGrid(List<T> items) {
        this(items, items.size());
    }

    public DataGrid(List<T> items, Integer numRows) {
        this.identified = "id";
        this.rows = items;
        this.total = numRows;
        this.recordsTotal = numRows;
        this.recordsFiltered = numRows;
    }

    public DataGrid(List<T> items, Integer numRows, Integer pages) {
        this.identified = "id";
        this.rows = items;
        this.total = numRows;
        this.recordsTotal = numRows;
        this.recordsFiltered = numRows;
        this.pages = pages;
    }

    public DataGrid(List<T> items, Integer numRows, String identified) {
        this(items, items.size());
        this.identified = identified;
    }

    public Integer getTotal() {
        return this.total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<T> getRows() {
        return this.rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public String getIdentified() {
        return this.identified;
    }

    public void setIdentified(String identified) {
        this.identified = identified;
    }

    public Integer getRecordsTotal() {
        return this.recordsTotal;
    }

    public void setRecordsTotal(Integer recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public Integer getRecordsFiltered() {
        return this.recordsFiltered;
    }

    public void setRecordsFiltered(Integer recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public Integer getPages() {
        return this.pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public static <T> DataGrid<T> empty() {
        List<T> items = new ArrayList();
        return new DataGrid(items);
    }
}
