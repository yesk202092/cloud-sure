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
public class OrderPageTaskNode extends AbstractTaskNode {

	private String templateList = "order.page.list.ftl";

	private String templateListJs = "order.page.list.js.ftl";

	private String templateAdd = "order.page.add.ftl";
	
	private String templateAddJs = "order.page.add.js.ftl";

	private String templateEdit = "order.page.edit.ftl";
	
	private String templateEditJs = "order.page.edit.js.ftl";

	@Override
	public List<CodeFile> execute(TableWapper table, Map<String, Object> config) throws Exception {
		String catalog = (String) config.get("catalog");
		Map<String, Object> map = this.buildContext(table, config);
		String name = table.getJavaName().toLowerCase();
		String listName = name + "-list.ftl";
		String content = codeService.executeTemplate(templateList, map);
		CodeFile listFile = new JavaCodeFile(catalog, listName, content);

		String listNameJs = name + "-list.js";
		content = codeService.executeTemplate(templateListJs, map);
		CodeFile listJsFile = new ConfigCodeFile(catalog, listNameJs, content);

		String addName = name + "-add.ftl";
		content = codeService.executeTemplate(templateAdd, map);
		CodeFile addFile = new ConfigCodeFile(catalog, addName, content);

		String addNameJs = name + "-add.js";
		content = codeService.executeTemplate(templateAddJs, map);
		CodeFile addJsFile = new ConfigCodeFile(catalog, addNameJs, content);
		
		String editName = name + "-edit.ftl";
		content = codeService.executeTemplate(templateEdit, map);
		CodeFile editFile = new ConfigCodeFile(catalog, editName, content);

		String editNameJs = name + "-edit.js";
		content = codeService.executeTemplate(templateEditJs, map);
		CodeFile editJsFile = new ConfigCodeFile(catalog, editNameJs, content);
		
		return Arrays.asList(listFile, listJsFile, addFile, addJsFile, editFile, editJsFile);
	}

}
