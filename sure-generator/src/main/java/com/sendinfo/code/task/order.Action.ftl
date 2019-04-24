package ${config.basepkg}.web.action;

import java.util.Arrays;

import javax.annotation.Resource;

import com.sendinfo.base.async.Async;
import com.sendinfo.base.model.DataGrid;
import com.sendinfo.base.model.Params;
import com.sendinfo.base.model.Response;
import ${config.basepkg}.base.action.ManageBaseAction;
import ${config.basepkg}.entity.${table.javaName};
import ${config.basepkg}.service.${table.javaName}Service;

/**
 * ${table.comment}Action。
 * @author wangxf
 */
public class ${table.javaName}Action extends ManageBaseAction {

	private static final long serialVersionUID = ${helper.serialVersionUID};

	@Resource
	private ${table.javaName}Service ${table.javaNameL}Service;

	// 操作对象
	private ${table.javaName} ${table.javaNameL} = new ${table.javaName}();

	/**
	 * 进入页面
	 */
	public String list() {
		// 页面固定元素值
		return SUCCESS;
	}

	/**
	 * 表格数据
	 * @return
	 */
	@Async
	public String grid() {
		Params params = Params.create().add("entity", this.${table.javaNameL});
		DataGrid<${table.javaName}> datagrid = this.${table.javaNameL}Service.page(params, this.getPage());
		this.renderDataGrid(datagrid);
		return JSON;
	}

	/**
	 * 新增页面
	 */
	public String add() {
		return SUCCESS;
	}

	/**
	 * 新增保存
	 * @return
	 */
	@Async
	public String doAdd() {
		this.${table.javaNameL}Service.insert(${table.javaNameL});
		this.renderJson(Response.success("保存成功！"));
		return JSON;
	}

	/**
	 * 编辑页面
	 */
	public String edit() {
		this.${table.javaNameL} = this.${table.javaNameL}Service.get(id);
		return SUCCESS;
	}

	/**
	 * 编辑保存
	 * @return
	 */
	@Async
	public String doEdit() {
		this.${table.javaNameL}Service.update(${table.javaNameL});
		this.renderJson(Response.success("更新成功！"));
		return JSON;
	}

	/**
	 * 删除操作
	 * @return
	 */
	@Async
	public String doDel() {
		this.${table.javaNameL}Service.delete(Arrays.asList(ids));
		this.renderJson(Response.success("删除成功！"));
		return JSON;
	}

	public ${table.javaName} get${table.javaName}() {
		return ${table.javaNameL};
	}

	public void set${table.javaName}(${table.javaName} ${table.javaNameL}) {
		this.${table.javaNameL} = ${table.javaNameL};
	}
}
