package ${config.basepkg}.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import org.springframework.format.annotation.DateTimeFormat;

/**
* @类名: ${table.javaName}
* @描述: ${table.comment}Vo
* @作者: qianc
* @日期: ${config.date}
*/
@ApiModel(value = "${table.javaName}")
public class ${table.javaName}Vo implements Serializable{

private static final long serialVersionUID = ${helper.serialVersionUID};

<#list table.columns as column>
  <#if column.view>
  //${column.comment}
  @ApiModelProperty(value = "${column.comment}")
    <#if column.javaType=='java.util.Date'>
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    </#if>
  private ${column.javaType} ${column.javaName};
  </#if>
</#list>

<#list table.columns as column>
  <#if column.view>

  /**
  * ${column.comment}
  */
  public ${column.javaType} get${(column.javaName)?cap_first!}() {
  return this.${column.javaName};
  }

  /**
  * ${column.comment}
  */
  public void set${(column.javaName)?cap_first!}(${column.javaType} ${column.javaName}) {
  this.${column.javaName} = ${column.javaName};
  }
  </#if>
</#list>
}
