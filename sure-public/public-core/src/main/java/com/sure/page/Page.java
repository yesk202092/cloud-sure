package com.sure.page;

import java.io.Serializable;

public class Page implements Serializable {
    private static final long serialVersionUID = -5823482162101235168L;
    public static final String ORDER_ASC = "ASC";
    public static final String ORDER_DESC = "DESC";
    private int page;
    private int offset;
    private int limit;
    private String sort;
    private String order;

    public Page() {
        this(0, 2147483647);
    }

    public Page(int offset, int limit) {
        this.order = "ASC";
        this.offset = offset;
        this.limit = limit;
    }

    public Page(int offset, int limit, String sort, String order) {
        this.order = "ASC";
        this.offset = offset;
        this.limit = limit;
        this.sort = sort;
        this.order = order;
    }

    public int getOffset() {
        return (this.page - 1) * this.limit;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return this.limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getSort() {
        return this.underscoreName(this.sort);
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return this.order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public int getOffsetLimit() {
        return this.offset + this.limit;
    }

    public String toString() {
        return "[Page: " + this.offset + ", " + this.limit + ", " + this.sort + ", " + this.order + "]";
    }

    public int getPage() {
        return this.page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String underscoreName(String name) {
        StringBuilder result = new StringBuilder();
        if (name != null && name.length() > 0) {
            result.append(name.substring(0, 1).toUpperCase());

            for(int i = 1; i < name.length(); ++i) {
                String s = name.substring(i, i + 1);
                if (s.equals(s.toUpperCase()) && !Character.isDigit(s.charAt(0))) {
                    result.append("_");
                }

                result.append(s.toUpperCase());
            }
        }

        return result.toString();
    }

    public String camelName(String name) {
        StringBuilder result = new StringBuilder();
        if (name != null && !name.isEmpty()) {
            if (!name.contains("_")) {
                return name.substring(0, 1).toLowerCase() + name.substring(1);
            } else {
                String[] camels = name.split("_");
                String[] var4 = camels;
                int var5 = camels.length;

                for(int var6 = 0; var6 < var5; ++var6) {
                    String camel = var4[var6];
                    if (!camel.isEmpty()) {
                        if (result.length() == 0) {
                            result.append(camel.toLowerCase());
                        } else {
                            result.append(camel.substring(0, 1).toUpperCase());
                            result.append(camel.substring(1).toLowerCase());
                        }
                    }
                }

                return result.toString();
            }
        } else {
            return "";
        }
    }
}
