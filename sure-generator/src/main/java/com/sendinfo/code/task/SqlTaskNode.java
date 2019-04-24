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
 * @date 2014-1-7 下午3:52:17
 */
@Component
public class SqlTaskNode extends AbstractTaskNode {

	private String templateSql = "sql.ftl";

	@Override
	public List<CodeFile> execute(TableWapper table, Map<String, Object> config) throws Exception {
		String basepkg = (String) config.get("basepkg");
		Map<String, Object> map = this.buildContext(table, config);
		// sql
		String name = table.getJavaName() + "Sql.java";
		String content = codeService.executeTemplate(templateSql, map);
		CodeFile sqlFile = new JavaCodeFile(basepkg + ".sqlstatement", name, content);
		return Arrays.asList(sqlFile);
	}

}
