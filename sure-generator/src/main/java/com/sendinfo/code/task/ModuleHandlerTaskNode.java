package com.sendinfo.code.task;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.sendinfo.code.freemarker.CodeFile;
import com.sendinfo.code.freemarker.JavaCodeFile;
import com.sendinfo.code.wapper.TableWapper;

/**
 * @author GY
 * @Description: TODO
 * @date 2013-11-15 上午11:09:49
 */
@Component
public class ModuleHandlerTaskNode extends AbstractTaskNode {
	
	private String templateMuduleHandler = "ModuleHandler.ftl";
	private String templateRequest = "Request.ftl";
	private String templateMuduleHandlerTest = "ModuleHandlerTest.ftl";

	@Override
	public List<CodeFile> execute(TableWapper table, Map<String, Object> config) throws Exception {
		String basepkg = (String) config.get("ifacepkg");
		Map<String, Object> map = this.buildContext(table, config);
		//moduleHandler
		String name = table.getJavaName() + "ModuleHandler.java";
		String content = codeService.executeTemplate(templateMuduleHandler, map);
		CodeFile moduleHandlerImplFile = new JavaCodeFile(basepkg+".impl", name, content);
		
		//request
		name = table.getJavaName() + "Request.java";
		content = codeService.executeTemplate(templateRequest, map);
		CodeFile requestFile = new JavaCodeFile(basepkg, name, content);
		
		//muduleHandlerTest
		name = table.getJavaName() + "ModuleHandlerTest.java";
		content = codeService.executeTemplate(templateMuduleHandlerTest, map);
		CodeFile muduleHandlerTestFile = new JavaCodeFile(basepkg+".impl", name, content);
		
		return Arrays.asList(moduleHandlerImplFile,requestFile,muduleHandlerTestFile);
	}
}
