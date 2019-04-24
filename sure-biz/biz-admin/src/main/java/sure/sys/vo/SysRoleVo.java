//package sure.sys.vo;
//
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
//import java.io.Serializable;
//import org.springframework.format.annotation.DateTimeFormat;
//
///**
//* @类名: SysRole
//* @描述: 角色信息Vo
//* @作者: qianc
//* @日期: 2019-04-24 11:00:13
//*/
//@ApiModel(value = "SysRole")
//public class SysRoleVo implements Serializable{
//
//private static final long serialVersionUID = 3552714198822797926L;
//
//  //角色名称
//  @ApiModelProperty(value = "角色名称")
//  private String roleName;
//  //0:系统管理员 1:景区管理员 2:分销商 3:推广员
//  @ApiModelProperty(value = "0:系统管理员 1:景区管理员 2:分销商 3:推广员")
//  private String accType;
//  //状态 0:停用 1:启动
//
//  @ApiModelProperty(value = "状态 0:停用 1:启动")
//  private String useFlag;
//  //备注
//  @ApiModelProperty(value = "备注")
//  private String remark;
//
//
//  /**
//  * 角色名称
//  */
//  public String getRoleName() {
//  return this.roleName;
//  }
//
//  /**
//  * 角色名称
//  */
//  public void setRoleName(String roleName) {
//  this.roleName = roleName;
//  }
//
//  /**
//  * 0:系统管理员 1:景区管理员 2:分销商 3:推广员
//  */
//  public String getAccType() {
//  return this.accType;
//  }
//
//  /**
//  * 0:系统管理员 1:景区管理员 2:分销商 3:推广员
//  */
//  public void setAccType(String accType) {
//  this.accType = accType;
//  }
//
//  /**
//  * 状态 0:停用 1:启动
//
//  */
//  public String getUseFlag() {
//  return this.useFlag;
//  }
//
//  /**
//  * 状态 0:停用 1:启动
//
//  */
//  public void setUseFlag(String useFlag) {
//  this.useFlag = useFlag;
//  }
//
//  /**
//  * 备注
//  */
//  public String getRemark() {
//  return this.remark;
//  }
//
//  /**
//  * 备注
//  */
//  public void setRemark(String remark) {
//  this.remark = remark;
//  }
//}
