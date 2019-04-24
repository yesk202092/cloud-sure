package sure.sys.entity;

import com.sure.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @类名: 系统功能模块
 * @描述: 实体对象 系统功能模块
 * @作者: yesk
 * @日期: 2019-04-24 11:00:13
 */
@Table(name = "SYS_FUNCTIONS")
public class SysFunctions extends BaseEntity
        <Long> {

    private static final long serialVersionUID = 4164992298335586308L;

    // ~~~~实体属性
    //名称
    @Column(name = "FUN_NAME")
    private String funName;
    //碓一编码
    @Column(name = "FUN_CODE")
    private String funCode;
    //功能图标
    @Column(name = "FUN_ICO")
    private String funIco;
    //URL
    @Column(name = "FUN_URL")
    private String funUrl;
    //0:系统管理员 1:景区管理员 2:分销商 3:推广员
    @Column(name = "FUN_TYPE")
    private String funType;
    //名称:标识，名称:标识
    @Column(name = "OPT_TYPE")
    private String optType;
    //父ID
    @Column(name = "PARENT_ID")
    private Long parentId;
    //排序
    @Column(name = "SORT_NO")
    private Long sortNo;
    //层级深度
    @Column(name = "HIERARCHY")
    private Long hierarchy;
    //
    @Column(name = "OPEN_TYPE")
    private String openType;
    //功能类别  menu（菜单）、column（栏目）、button（按钮）
    @Column(name = "FUNCTION_TYPE")
    private String functionType;

    @Override
    public Long getId() {
        return super.getId();
    }

    @Override
    public void setId(Long id) {
        super.setId(id);
    }

    /**
     * 名称
     */
    public String getFunName() {
        return this.funName;
    }

    /**
     * 名称
     */
    public void setFunName(String funName) {
        this.funName = funName;
    }

    /**
     * 碓一编码
     */
    public String getFunCode() {
        return this.funCode;
    }

    /**
     * 碓一编码
     */
    public void setFunCode(String funCode) {
        this.funCode = funCode;
    }

    /**
     * 功能图标
     */
    public String getFunIco() {
        return this.funIco;
    }

    /**
     * 功能图标
     */
    public void setFunIco(String funIco) {
        this.funIco = funIco;
    }

    /**
     * URL
     */
    public String getFunUrl() {
        return this.funUrl;
    }

    /**
     * URL
     */
    public void setFunUrl(String funUrl) {
        this.funUrl = funUrl;
    }

    /**
     * 0:系统管理员 1:景区管理员 2:分销商 3:推广员
     */
    public String getFunType() {
        return this.funType;
    }

    /**
     * 0:系统管理员 1:景区管理员 2:分销商 3:推广员
     */
    public void setFunType(String funType) {
        this.funType = funType;
    }

    /**
     * 名称:标识，名称:标识
     */
    public String getOptType() {
        return this.optType;
    }

    /**
     * 名称:标识，名称:标识
     */
    public void setOptType(String optType) {
        this.optType = optType;
    }

    /**
     * 父ID
     */
    public Long getParentId() {
        return this.parentId;
    }

    /**
     * 父ID
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 排序
     */
    public Long getSortNo() {
        return this.sortNo;
    }

    /**
     * 排序
     */
    public void setSortNo(Long sortNo) {
        this.sortNo = sortNo;
    }

    /**
     * 层级深度
     */
    public Long getHierarchy() {
        return this.hierarchy;
    }

    /**
     * 层级深度
     */
    public void setHierarchy(Long hierarchy) {
        this.hierarchy = hierarchy;
    }

    /**
     *
     */
    public String getOpenType() {
        return this.openType;
    }

    /**
     *
     */
    public void setOpenType(String openType) {
        this.openType = openType;
    }

    /**
     * 功能类别  menu（菜单）、column（栏目）、button（按钮）
     */
    public String getFunctionType() {
        return this.functionType;
    }

    /**
     * 功能类别  menu（菜单）、column（栏目）、button（按钮）
     */
    public void setFunctionType(String functionType) {
        this.functionType = functionType;
    }
}
