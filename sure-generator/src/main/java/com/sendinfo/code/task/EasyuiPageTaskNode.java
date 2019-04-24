package com.sendinfo.code.task;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.sendinfo.code.freemarker.CodeFile;
import com.sendinfo.code.freemarker.ConfigCodeFile;
import com.sendinfo.code.freemarker.JavaCodeFile;
import com.sendinfo.code.wapper.TableWapper;

@Component
public class EasyuiPageTaskNode extends AbstractTaskNode {

	private String templateList = "easyui.page.list.ftl";

	private String templateListJs = "easyui.page.listjs.ftl";

	private String templateAdd = "easyui.page.add.ftl";

	private String templateEdit = "easyui.page.edit.ftl";

	@Override
	public List<CodeFile> execute(TableWapper table, Map<String, Object> config) throws Exception {
		String catalog = (String) config.get("catalog");
		Map<String, Object> map = this.buildContext(table, config);
		String name = table.getJavaName().toLowerCase();
		String listName = name + "-list.ftl";
		String content = codeService.executeTemplate(templateList, map);
		CodeFile listFile = new JavaCodeFile(catalog, listName, content);

//		String listNameJs = name + "-list.js";
//		content = codeService.executeTemplate(templateListJs, map);
//		CodeFile listJsFile = new ConfigCodeFile(catalog, listNameJs, content);

		String addName = name + "-add.ftl";
		content = codeService.executeTemplate(templateAdd, map);
		CodeFile addFile = new ConfigCodeFile(catalog, addName, content);

		String editName = name + "-edit.ftl";
		content = codeService.executeTemplate(templateEdit, map);
		CodeFile editFile = new ConfigCodeFile(catalog, editName, content);

//		return Arrays.asList(listFile, listJsFile, addFile, editFile);
		return Arrays.asList(listFile, addFile, editFile);
	}

}
