package ${config.basepkg}.entity;

import com.sure.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Table;

/**
* @类名: ${table.comment}
* @描述: 实体对象 ${table.comment}
* @作者: yesk
* @日期: ${config.date}
*/
@Table(name = "${table.name}")
public class ${table.javaName} extends BaseEntity
<Long> {

	private static final long serialVersionUID = ${helper.serialVersionUID};

	// ~~~~实体属性
<#list table.columns as column>
	<#if column.view>
		//${column.comment}
		<#if column.name == 'ID'>
			@ID
		<#else>
			@Column(name = "${column.name}")
		</#if>
		<#if column.javaType=='java.util.Date'>
			@DateTimeFormat(pattern = "yyyy-MM-dd")
		</#if>
		private ${column.javaType} ${column.javaName};
	</#if>
</#list>

	@Override
	public Long getId() {
	return super.getId();
	}

	@Override
	public void setId(Long id) {
	super.setId(id);
	}
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
