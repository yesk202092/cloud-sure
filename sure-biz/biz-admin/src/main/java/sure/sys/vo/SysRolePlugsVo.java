//package sure.sys.vo;
//
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
//import java.io.Serializable;
//import org.springframework.format.annotation.DateTimeFormat;
//
///**
//* @类名: SysRolePlugs
//* @描述: 角色的具体模块权限表Vo
//* @作者: qianc
//* @日期: 2019-04-24 11:00:13
//*/
//@ApiModel(value = "SysRolePlugs")
//public class SysRolePlugsVo implements Serializable{
//
//private static final long serialVersionUID = 2095525909014195192L;
//
//  //角色ID
//  @ApiModelProperty(value = "角色ID")
//  private Long sysRoleId;
//  //关联系统功能模块表中的ID
//  @ApiModelProperty(value = "关联系统功能模块表中的ID")
//  private Long sysFunctionsId;
//  //????Ȩ?? save,update,delete,view,list,grid
//  @ApiModelProperty(value = "????Ȩ?? save,update,delete,view,list,grid")
//  private String sysOpt;
//
//
//  /**
//  * 角色ID
//  */
//  public Long getSysRoleId() {
//  return this.sysRoleId;
//  }
//
//  /**
//  * 角色ID
//  */
//  public void setSysRoleId(Long sysRoleId) {
//  this.sysRoleId = sysRoleId;
//  }
//
//  /**
//  * 关联系统功能模块表中的ID
//  */
//  public Long getSysFunctionsId() {
//  return this.sysFunctionsId;
//  }
//
//  /**
//  * 关联系统功能模块表中的ID
//  */
//  public void setSysFunctionsId(Long sysFunctionsId) {
//  this.sysFunctionsId = sysFunctionsId;
//  }
//
//  /**
//  * ????Ȩ?? save,update,delete,view,list,grid
//  */
//  public String getSysOpt() {
//  return this.sysOpt;
//  }
//
//  /**
//  * ????Ȩ?? save,update,delete,view,list,grid
//  */
//  public void setSysOpt(String sysOpt) {
//  this.sysOpt = sysOpt;
//  }
//}
