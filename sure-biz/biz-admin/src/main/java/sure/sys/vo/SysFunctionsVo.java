//package sure.sys.vo;
//
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
//import java.io.Serializable;
//import org.springframework.format.annotation.DateTimeFormat;
//
///**
//* @类名: SysFunctions
//* @描述: 系统功能模块Vo
//* @作者: qianc
//* @日期: 2019-04-24 11:00:13
//*/
//@ApiModel(value = "SysFunctions")
//public class SysFunctionsVo implements Serializable{
//
//private static final long serialVersionUID = 2281969033273486497L;
//
//  //名称
//  @ApiModelProperty(value = "名称")
//  private String funName;
//  //碓一编码
//  @ApiModelProperty(value = "碓一编码")
//  private String funCode;
//  //功能图标
//  @ApiModelProperty(value = "功能图标")
//  private String funIco;
//  //URL
//  @ApiModelProperty(value = "URL")
//  private String funUrl;
//  //0:系统管理员 1:景区管理员 2:分销商 3:推广员
//  @ApiModelProperty(value = "0:系统管理员 1:景区管理员 2:分销商 3:推广员")
//  private String funType;
//  //名称:标识，名称:标识
//  @ApiModelProperty(value = "名称:标识，名称:标识")
//  private String optType;
//  //父ID
//  @ApiModelProperty(value = "父ID")
//  private Long parentId;
//  //排序
//  @ApiModelProperty(value = "排序")
//  private Long sortNo;
//  //层级深度
//  @ApiModelProperty(value = "层级深度")
//  private Long hierarchy;
//  //
//  @ApiModelProperty(value = "")
//  private String openType;
//  //功能类别  menu（菜单）、column（栏目）、button（按钮）
//  @ApiModelProperty(value = "功能类别  menu（菜单）、column（栏目）、button（按钮）")
//  private String functionType;
//
//
//  /**
//  * 名称
//  */
//  public String getFunName() {
//  return this.funName;
//  }
//
//  /**
//  * 名称
//  */
//  public void setFunName(String funName) {
//  this.funName = funName;
//  }
//
//  /**
//  * 碓一编码
//  */
//  public String getFunCode() {
//  return this.funCode;
//  }
//
//  /**
//  * 碓一编码
//  */
//  public void setFunCode(String funCode) {
//  this.funCode = funCode;
//  }
//
//  /**
//  * 功能图标
//  */
//  public String getFunIco() {
//  return this.funIco;
//  }
//
//  /**
//  * 功能图标
//  */
//  public void setFunIco(String funIco) {
//  this.funIco = funIco;
//  }
//
//  /**
//  * URL
//  */
//  public String getFunUrl() {
//  return this.funUrl;
//  }
//
//  /**
//  * URL
//  */
//  public void setFunUrl(String funUrl) {
//  this.funUrl = funUrl;
//  }
//
//  /**
//  * 0:系统管理员 1:景区管理员 2:分销商 3:推广员
//  */
//  public String getFunType() {
//  return this.funType;
//  }
//
//  /**
//  * 0:系统管理员 1:景区管理员 2:分销商 3:推广员
//  */
//  public void setFunType(String funType) {
//  this.funType = funType;
//  }
//
//  /**
//  * 名称:标识，名称:标识
//  */
//  public String getOptType() {
//  return this.optType;
//  }
//
//  /**
//  * 名称:标识，名称:标识
//  */
//  public void setOptType(String optType) {
//  this.optType = optType;
//  }
//
//  /**
//  * 父ID
//  */
//  public Long getParentId() {
//  return this.parentId;
//  }
//
//  /**
//  * 父ID
//  */
//  public void setParentId(Long parentId) {
//  this.parentId = parentId;
//  }
//
//  /**
//  * 排序
//  */
//  public Long getSortNo() {
//  return this.sortNo;
//  }
//
//  /**
//  * 排序
//  */
//  public void setSortNo(Long sortNo) {
//  this.sortNo = sortNo;
//  }
//
//  /**
//  * 层级深度
//  */
//  public Long getHierarchy() {
//  return this.hierarchy;
//  }
//
//  /**
//  * 层级深度
//  */
//  public void setHierarchy(Long hierarchy) {
//  this.hierarchy = hierarchy;
//  }
//
//  /**
//  *
//  */
//  public String getOpenType() {
//  return this.openType;
//  }
//
//  /**
//  *
//  */
//  public void setOpenType(String openType) {
//  this.openType = openType;
//  }
//
//  /**
//  * 功能类别  menu（菜单）、column（栏目）、button（按钮）
//  */
//  public String getFunctionType() {
//  return this.functionType;
//  }
//
//  /**
//  * 功能类别  menu（菜单）、column（栏目）、button（按钮）
//  */
//  public void setFunctionType(String functionType) {
//  this.functionType = functionType;
//  }
//}
