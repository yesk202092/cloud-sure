package sure.po;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;
@Table(name = "SYS_INFO")
public class SysInfo {
    @Column(name = "ID")
    private Integer id;
    @Column(name = "LOGIN_IMG")
    private String loginImg;
    @Column(name = "LOGO_IMG")
    private String logoImg;
    @Column(name = "SYS_NAME")
    private String sysName;
    @Column(name = "SYS_VERSION")
    private String sysVersion;
    @Column(name = "CREATE_BY")
    private String createBy;
    @Column(name = "CREATE_TIME")
    private Date createTime;
    @Column(name = "MODIFY_BY")
    private String modifyBy;
    @Column(name = "MODIFY_TIME")
    private Date modifyTime;
    @Column(name = "DELETED")
    private String deleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginImg() {
        return loginImg;
    }

    public void setLoginImg(String loginImg) {
        this.loginImg = loginImg == null ? null : loginImg.trim();
    }

    public String getLogoImg() {
        return logoImg;
    }

    public void setLogoImg(String logoImg) {
        this.logoImg = logoImg == null ? null : logoImg.trim();
    }

    public String getSysName() {
        return sysName;
    }

    public void setSysName(String sysName) {
        this.sysName = sysName == null ? null : sysName.trim();
    }

    public String getSysVersion() {
        return sysVersion;
    }

    public void setSysVersion(String sysVersion) {
        this.sysVersion = sysVersion == null ? null : sysVersion.trim();
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy == null ? null : modifyBy.trim();
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted == null ? null : deleted.trim();
    }
}