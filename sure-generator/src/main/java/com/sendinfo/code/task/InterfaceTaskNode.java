package com.sendinfo.code.task;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.sendinfo.code.freemarker.CodeFile;
import com.sendinfo.code.freemarker.JavaCodeFile;
import com.sendinfo.code.wapper.TableWapper;

@Component
public class InterfaceTaskNode extends AbstractTaskNode {

	private String templateInterface = "Interface.ftl";
	private String templateInterfaceImpl = "InterfaceImpl.ftl";
	private String templateInterfaceHessian = "InterfaceHessian.ftl";

	@Override
	public List<CodeFile> execute(TableWapper table, Map<String, Object> config) throws Exception {
		String basepkg = (String) config.get("ifacepkg");
		Map<String, Object> map = this.buildContext(table, config);
		// interfaces
		String name = table.getJavaName() + "Interface.java";
		String content = codeService.executeTemplate(templateInterface, map);
		CodeFile interfaceFile = new JavaCodeFile(basepkg, name, content);
		// interfacesimpl
		name = table.getJavaName() + "InterfaceImpl.java";
		content = codeService.executeTemplate(templateInterfaceImpl, map);
		CodeFile interfaceImplFile = new JavaCodeFile(basepkg + ".impl", name, content);
		// interfacesHessian
		name = table.getJavaName() + "-hessian.xml";
		content = codeService.executeTemplate(templateInterfaceHessian, map);
		CodeFile hessianFile = new JavaCodeFile("", name, content);
		return Arrays.asList(interfaceFile, interfaceImplFile, hessianFile);
	}

}
