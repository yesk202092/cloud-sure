package sure.sys.entity;

import com.sure.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @类名: 系统信息表
 * @描述: 实体对象 系统信息表
 * @作者: yesk
 * @日期: 2019-04-24 11:00:13
 */
@Table(name = "SYS_BASE_INFO")
public class SysBaseInfo extends BaseEntity<Long> {

    private static final long serialVersionUID = 7972062763429828728L;

    // ~~~~实体属性
    //登录界面图片
    @Column(name = "LOGIN_IMG")
    private String loginImg;
    //logo图片
    @Column(name = "LOGO_IMG")
    private String logoImg;
    //系统名称
    @Column(name = "SYS_NAME")
    private String sysName;
    //系统版本号
    @Column(name = "SYS_VERSION")
    private String sysVersion;

    @Override
    public Long getId() {
        return super.getId();
    }

    @Override
    public void setId(Long id) {
        super.setId(id);
    }

    /**
     * 登录界面图片
     */
    public String getLoginImg() {
        return this.loginImg;
    }

    /**
     * 登录界面图片
     */
    public void setLoginImg(String loginImg) {
        this.loginImg = loginImg;
    }

    /**
     * logo图片
     */
    public String getLogoImg() {
        return this.logoImg;
    }

    /**
     * logo图片
     */
    public void setLogoImg(String logoImg) {
        this.logoImg = logoImg;
    }

    /**
     * 系统名称
     */
    public String getSysName() {
        return this.sysName;
    }

    /**
     * 系统名称
     */
    public void setSysName(String sysName) {
        this.sysName = sysName;
    }

    /**
     * 系统版本号
     */
    public String getSysVersion() {
        return this.sysVersion;
    }

    /**
     * 系统版本号
     */
    public void setSysVersion(String sysVersion) {
        this.sysVersion = sysVersion;
    }
}
