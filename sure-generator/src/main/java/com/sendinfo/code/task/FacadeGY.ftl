package ${config.basepkg}.facade;

import java.util.List;

import com.sendinfo.base.model.DataGrid;
import com.sendinfo.base.model.Page;
import ${config.basepkg}.entity.${table.javaName};

/**
 * ${table.comment}Facade接口。
 */
public interface ${table.javaName}Facade {
	/**
	 * @description: 新增
	 * @param entity
	 * @return 
	 * Long
	 */
	public Long addEntity(${table.javaName} entity);

	/**
	 * @description: 删除
	 * @param ids 
	 * void
	 */
	public void deleteEntity(List<Long> ids);

	/**
	 * @description: 修改
	 * @param entity 
	 * void
	 */
	public void updateEntity(${table.javaName} entity);

	/**
	 * @description: 列表查询
	 * @param entity
	 * @return 
	 * List<${table.javaName}>
	 */
	public List<${table.javaName}> findEntityByConditions(${table.javaName} entity);

	/**
	 * @description: 分页查询
	 * @param entity
	 * @param page
	 * @return 
	 * DataGrid<${table.javaName}>
	 */
	public DataGrid<${table.javaName}> findEntityByConditions(${table.javaName} entity, Page page);
}
