package ${config.basepkg}.sqlstatement.oracle;
import com.sendinfo.datasync.sqlstatement.BaseSql;
/**
 * sql语句：${table.comment}
 */
public class ${table.javaName}Sql extends BaseSql {

	public String getInsertSql() {
		StringBuilder builder = new StringBuilder("INSERT INTO ");
		builder.append("${table.name} (");
		<#list table.columns as column>
			<#if column.name != 'ID'>
		builder.append("${column.name}<#if column_has_next>,</#if>");
		  	</#if>
		</#list>
		builder.append(") VALUES (");
		for(int i = 2 ; i < ${table.columns?size};i++) {
			builder.append("?,");
		}
		builder.append("?");
		builder.append(")");
		return builder.toString();
	}
	
	public String getFindSql() {
		StringBuilder builder = new StringBuilder("SELECT * FROM ");
		builder.append("${table.name}");
		return builder.toString();
	}
	
}		