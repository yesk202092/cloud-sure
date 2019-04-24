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
public class PageTaskNode extends AbstractTaskNode {

	private String templateList = "page.list.ftl";

	private String templateAdd = "page.add.ftl";

	private String templateEdit = "page.edit.ftl";
	
	private String templateJs = "js.ftl";

	@Override
	public List<CodeFile> execute(TableWapper table, Map<String, Object> config) throws Exception {
		String catalog = (String) config.get("catalog");
		Map<String, Object> map = this.buildContext(table, config);
		String name = table.getJavaName().toLowerCase();
		String listName = name + "-list.ftl";
		String content = codeService.executeTemplate(templateList, map);
		CodeFile listFile = new JavaCodeFile(catalog, listName, content);
		
		String listNamejs = name + "-list.js";
		content = codeService.executeTemplate(templateJs, map);
		CodeFile listFilejs = new ConfigCodeFile(catalog, listNamejs, content);

		String addName = name + "-add.ftl";
		content = codeService.executeTemplate(templateAdd, map);
		CodeFile addFile = new ConfigCodeFile(catalog, addName, content);
		
		String addNamejs = name + "-add.js";
		content = codeService.executeTemplate(templateJs, map);
		CodeFile addFilejs = new ConfigCodeFile(catalog, addNamejs, content);

		String editName = name + "-edit.ftl";
		content = codeService.executeTemplate(templateEdit, map);
		CodeFile editFile = new ConfigCodeFile(catalog, editName, content);
		
		String editNamejs = name + "-edit.js";
		content = codeService.executeTemplate(templateJs, map);
		CodeFile editFilejs = new ConfigCodeFile(catalog, editNamejs, content);

		return Arrays.asList(listFile,listFilejs, addFile,addFilejs, editFile,editFilejs);
	}

}
