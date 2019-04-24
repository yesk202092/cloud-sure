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
 * @date 2013-11-15 上午11:25:00
 */
@Component
public class FacadeGYTaskNode extends AbstractTaskNode {
	private String templateFacade = "FacadeGY.ftl";
	private String templateFacadeImpl = "FacadeGYImpl.ftl";

	@Override
	public List<CodeFile> execute(TableWapper table, Map<String, Object> config) throws Exception {
		String basepkg = (String) config.get("basepkg");
		Map<String, Object> map = this.buildContext(table, config);
		// facade
		String name = table.getJavaName() + "Facade.java";
		String content = codeService.executeTemplate(templateFacade, map);
		CodeFile serviceFile = new JavaCodeFile(basepkg + ".facade", name, content);
		// facadeimpl
		name = table.getJavaName() + "FacadeImpl.java";
		content = codeService.executeTemplate(templateFacadeImpl, map);
		CodeFile serviceImplFile = new JavaCodeFile(basepkg + ".facade.impl", name, content);
		return Arrays.asList(serviceFile, serviceImplFile);
	}
}
