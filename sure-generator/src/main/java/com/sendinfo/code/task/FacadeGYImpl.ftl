package ${config.basepkg}.facade.impl;

import javax.annotation.Resource;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sendinfo.base.model.DataGrid;
import com.sendinfo.base.model.Page;
import com.sendinfo.base.model.Params;
import com.sendinfo.base.util.ConstantUtils;
import ${config.basepkg}.entity.${table.javaName};
import ${config.basepkg}.facade.${table.javaName}Facade;
import ${config.basepkg}.service.${table.javaName}Service;

@Service("${table.javaNameL}Facade")
public class ${table.javaName}FacadeImpl implements ${table.javaName}Facade {

	@Resource
	private ${table.javaName}Service ${table.javaNameL}Service;
	
	@Override
	public Long addEntity(${table.javaName} entity) {
		return ${table.javaNameL}Service.insert(entity).getId();
	}

	@Override
	public void deleteEntity(List<Long> ids) {
		${table.javaNameL}Service.delete(ids);
	}

	@Override
	public void updateEntity(${table.javaName} entity) {
		${table.javaNameL}Service.update(entity);
	}

	@Override
	public List<${table.javaName}> findEntityByConditions(${table.javaName} entity) {
		return ${table.javaNameL}Service.find(entity);
	}

	
	@Override
	public DataGrid<${table.javaName}> findEntityByConditions(${table.javaName} entity, Page page) {
		Params params = Params.create();
		params.add(ConstantUtils.CONDITION_PREFIX,entity);
		return ${table.javaNameL}Service.page(params, page);
	}
	
	private ${table.javaName} validateIsOrNotExists(${table.javaName} entity){
		return null;
	}
}
