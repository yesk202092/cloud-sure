package com.sendinfo.code.task;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import com.sendinfo.code.freemarker.CodeService;
import com.sendinfo.code.freemarker.Helper;
import com.sendinfo.code.wapper.TableWapper;

public abstract class AbstractTaskNode implements TaskNode {

	@Resource
	protected CodeService codeService;

	protected Helper helper = new Helper();

	protected Map<String, Object> buildContext(TableWapper table, Map<String, Object> config) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("table", table);
		map.put("config", config);
		map.put("helper", helper);
		return map;
	}
}
