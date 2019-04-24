package com.sendinfo.sc.enums;

import com.sendinfo.model.IEnum;

/** ${desc}。 */
public enum ${name} implements IEnum<String> {
	<#list items as item>

	/** ${item.label}，值：${item.value} */
	${item.value}("${item.value}", "${item.label}")<#if item_has_next>,<#else>;</#if>
	</#list>

	public final String value;
	public final String label;

	private ${name}(String value, String label) {
		this.value = value;
		this.label = label;
	}

	public String value() {
		return this.value;
	}

	public String label() {
		return this.label;
	}
}