package com.sure;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;

@JsonIgnoreProperties({"deleted", "modifyBy", "modifyTime"})
public abstract class BaseEntity<PK extends Serializable> extends Entity<PK> {
    private static final long serialVersionUID = -3011550426322591805L;
    public static final String PROP_DELETED = "deleted";
    public static final String PROP_CREATE_BY = "createBy";
    public static final String PROP_CREATE_TIME = "createTime";
    public static final String PROP_MODIFY_BY = "modifyBy";
    public static final String PROP_MODIFY_TIME = "modifyTime";
    public static final String PROP_CORP_CODE = "corpCode";
    public static final String PROP_CORP_GROUP_CODE = "corpGroupCode";
    private String createBy;
    private Date createTime;
    private String modifyBy;
    private Date modifyTime;

    public BaseEntity() {
    }

    public String getCreateBy() {
        return this.createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getModifyBy() {
        return this.modifyBy;
    }

    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
    }

    public Date getModifyTime() {
        return this.modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}
