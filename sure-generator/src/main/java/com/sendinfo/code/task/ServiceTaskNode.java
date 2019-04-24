package com.sendinfo.code.task;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.sendinfo.code.freemarker.CodeFile;
import com.sendinfo.code.freemarker.JavaCodeFile;
import com.sendinfo.code.wapper.TableWapper;

@Component
public class ServiceTaskNode extends AbstractTaskNode {

	private String templateService = "Service.ftl";
	private String templateServiceImpl = "ServiceImpl.ftl";

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
		return Arrays.asList(serviceFile, serviceImplFile);
	}

}
