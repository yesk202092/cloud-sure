package ${config.ifacepkg};

import com.sendinfo.base.model.Page;
import com.sendinfo.internal.base.ModuleType;
import com.sendinfo.internal.base.OperationType;
import com.sendinfo.internal.base.Request;

/**
 * 实体对象：${table.comment}
 */
public class ${table.javaName}Request extends Request<${config.response}> {

	private static final long serialVersionUID = ${helper.serialVersionUID};

	// ~~~~实体属性
	<#list table.columns as column>
	<#if column.view>
	<#if column.javaName != "corpCode" && column.javaName != "corpGroupCode" 
		&& column.javaName != "code" && column.javaName != "name" 
		&& column.javaName != "enabled" && column.javaName != "description">
	// ${column.comment}
	private ${column.javaType} ${column.javaName};
	</#if>
	</#if>
	</#list>

	/**
	 * 分页数据
	 */
	private Page page;

	/**
	 * platform 区分前后台查询,后台查询时只需传入ConstantUtils.END即可
	 */
	private String platform;

	/**
	 * 操作类型
	 */
	private String operationType;

	/**
	 * 操作类型
	 */
	@Override
	public void setOperation(OperationType operationType) {
		this.operationType = operationType.value;
	}

	@Override
	public String getOperation() {
		return this.operationType;
	}

	@Override
	public String getModule() {
		return ModuleType.;
	}

	@Override
	public Class<${config.response}> getResposneType() {
		return ${config.response}.class;
	}

	/**
	 * @return the page
	 */
	public Page getPage() {
		return page;
	}

	/**
	 * @param page
	 *            the page to set
	 */
	public void setPage(Page page) {
		this.page = page;
	}

	/**
	 * @return the platform
	 */
	public String getPlatform() {
		return platform;
	}

	/**
	 * @param platform
	 *            the platform to set
	 */
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	
	<#list table.columns as column>
	<#if column.view>
	<#if column.javaName != "corpCode" && column.javaName != "corpGroupCode" 
		&& column.javaName != "code" && column.javaName != "name" 
		&& column.javaName != "enabled" && column.javaName != "description">
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
	</#if>
	</#list>
}
