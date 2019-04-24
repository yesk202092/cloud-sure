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
public class OrderServiceTaskNode extends AbstractTaskNode {

	private String templateService = "Service.ftl";
	private String templateServiceImpl = "order.ServiceImpl.ftl";
	private String templateAction = "order.Action.ftl";
	private String templateActionConfig = "ActionConfig.ftl";

	@Override
	public List<CodeFile> execute(TableWapper table, Map<String, Object> config) throws Exception {
		String basepkg = (String) config.get("basepkg");
		Map<String, Object> map = this.buildContext(table, config);
		// service
		String name = table.getJavaName() + "Service.java";
		String content = codeService.executeTemplate(templateService, map);
		CodeFile serviceFile = new JavaCodeFile(basepkg + ".service", name, content);
		// serviceimpl
		name = table.getJavaName() + "ServiceImpl.java";
		content = codeService.executeTemplate(templateServiceImpl, map);
		CodeFile serviceImplFile = new JavaCodeFile(basepkg + ".service.impl", name, content);
		// action
		String actionName = table.getJavaName() + "Action.java";
		String actionContent = codeService.executeTemplate(templateAction, map);
		CodeFile actionFile = new JavaCodeFile(basepkg + ".web.action", actionName, actionContent);
		// action config
		String configName = table.getJavaName() + "Action.xml";
		String configContent = codeService.executeTemplate(templateActionConfig, map);
		CodeFile actionConfigFile = new ConfigCodeFile("struts", configName, configContent);
		return Arrays.asList(serviceFile, serviceImplFile, actionFile, actionConfigFile);
	}

}
