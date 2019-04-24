package ${config.basepkg}.web.action;

import java.util.Arrays;

import javax.annotation.Resource;

import com.sendinfo.base.action.BaseAction;
import com.sendinfo.base.async.Async;
import com.sendinfo.base.model.DataGrid;
import com.sendinfo.base.model.Params;
import com.sendinfo.base.model.Response;
import ${config.basepkg}.entity.${table.javaName};
import ${config.basepkg}.service.${table.javaName}Service;

/**
* ${table.comment}Action。
*
* @author qianc
*/
public class ${table.javaName}Action extends BaseAction {

private static final long serialVersionUID = ${helper.serialVersionUID};

@Resource
private ${table.javaName}Service ${table.javaNameL}Service;

// 操作对象
private ${table.javaName} ${table.javaNameL} = new ${table.javaName}();

/**
* datagrid数据
*
* @return
*/
@Async
public String grid() {
Params params = Params.create().add("entity", this.${table.javaNameL});
DataGrid<${table.javaName}> datagrid = this.${table.javaNameL}Service.page(params, this.getPage());
renderJson(datagrid);
return JSON;
}

/**
* 编辑页面
*
* @return
*/
public String edit() {
${table.javaNameL} = this.${table.javaNameL}Service.get(id);
return SUCCESS;
}

/**
* 新增保存
*
* @return
*/
@Async
public String save() {
${table.javaNameL}Service.insert(${table.javaNameL});
renderJson(Response.success());
return JSON;
}

/**
* 编辑保存
*
* @return
*/
@Async
public String update() {
${table.javaNameL}Service.update(${table.javaNameL});
renderJson(Response.success());
return JSON;
}

/**
* 删除操作
*
* @return
*/
@Async
public String del() {
${table.javaNameL}Service.delete(Arrays.asList(ids));
renderJson(Response.success());
return JSON;
}

public ${table.javaName} get${table.javaName}() {
return ${table.javaNameL};
}

public void set${table.javaName}(${table.javaName} ${table.javaNameL}) {
this.${table.javaNameL} = ${table.javaNameL};
}
}
