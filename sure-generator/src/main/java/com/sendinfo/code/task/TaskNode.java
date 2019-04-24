package com.sendinfo.code.task;

import java.util.List;
import java.util.Map;

import com.sendinfo.code.freemarker.CodeFile;
import com.sendinfo.code.wapper.TableWapper;

public interface TaskNode {

	public List<CodeFile> execute(TableWapper table, Map<String, Object> config) throws Exception;

}
