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
public class ActionTaskNode extends AbstractTaskNode {

	private String templateAction = "Action.ftl";

	private String templateConfig = "ActionConfig.ftl";

	@Override
	public List<CodeFile> execute(TableWapper table, Map<String, Object> config) throws Exception {
		String basepkg = (String) config.get("basepkg");
		Map<String, Object> map = this.buildContext(table, config);
		String actionName = table.getJavaName() + "Controller.java";
		String actionContent = codeService.executeTemplate(templateAction, map);
		CodeFile actionFile = new JavaCodeFile(basepkg + ".controller", actionName, actionContent);

//		String configName = table.getJavaName() + "Action.xml";
//		String configContent = codeService.executeTemplate(templateConfig, map);
//		CodeFile configFile = new ConfigCodeFile("struts", configName, configContent);
//
//		return Arrays.asList(actionFile, configFile);
		return Arrays.asList(actionFile);
	}
}
