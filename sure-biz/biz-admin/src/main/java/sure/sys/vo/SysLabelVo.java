//package sure.sys.vo;
//
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
//import java.io.Serializable;
//import org.springframework.format.annotation.DateTimeFormat;
//
///**
//* @类名: SysLabel
//* @描述: 产品标签表Vo
//* @作者: qianc
//* @日期: 2019-04-24 11:00:13
//*/
//@ApiModel(value = "SysLabel")
//public class SysLabelVo implements Serializable{
//
//private static final long serialVersionUID = 5721023629056718641L;
//
//  //??ǩ??
//  @ApiModelProperty(value = "??ǩ??")
//  private String name;
//  //??ǩ????
//  @ApiModelProperty(value = "??ǩ????")
//  private String description;
//  //上级标签
//  @ApiModelProperty(value = "上级标签")
//  private Long parentId;
//  //????ҵ̬
//  @ApiModelProperty(value = "????ҵ̬")
//  private String businessType;
//
//
//  /**
//  * ??ǩ??
//  */
//  public String getName() {
//  return this.name;
//  }
//
//  /**
//  * ??ǩ??
//  */
//  public void setName(String name) {
//  this.name = name;
//  }
//
//  /**
//  * ??ǩ????
//  */
//  public String getDescription() {
//  return this.description;
//  }
//
//  /**
//  * ??ǩ????
//  */
//  public void setDescription(String description) {
//  this.description = description;
//  }
//
//  /**
//  * 上级标签
//  */
//  public Long getParentId() {
//  return this.parentId;
//  }
//
//  /**
//  * 上级标签
//  */
//  public void setParentId(Long parentId) {
//  this.parentId = parentId;
//  }
//
//  /**
//  * ????ҵ̬
//  */
//  public String getBusinessType() {
//  return this.businessType;
//  }
//
//  /**
//  * ????ҵ̬
//  */
//  public void setBusinessType(String businessType) {
//  this.businessType = businessType;
//  }
//}
