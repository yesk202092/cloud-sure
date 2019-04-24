package ${config.ifacepkg}.impl;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sendinfo.base.model.DataGrid;
import com.sendinfo.base.util.BeanCopyUtil;
import com.sendinfo.internal.base.StatusType;
import com.sendinfo.internal.delegate.impl.ModuleHandler;

import ${config.ifacepkg}.${table.javaName}Request;
import ${config.ifacepkg}.${config.response};
import ${config.basepkg}.entity.${table.javaName};
import ${config.basepkg}.facade.${table.javaName}Facade;

@Service("${table.javaNameL}Handler")
public class ${table.javaName}ModuleHandler extends ModuleHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(${table.javaName}ModuleHandler.class);
	
	@Resource
	private ${table.javaName}Facade facade;
	
	public ${config.response} add(${table.javaName}Request request) throws Exception {
		try {
			${config.response} response = new ${config.response}();
			response.setId(facade.addEntity(BeanCopyUtil.copy(request, ${table.javaName}.class)));
			response.setStatus(StatusType.ACCESS_SUCCESSFUL);
			return response;
		} catch (Exception e) {
			logger.error("===== 新增失败 ===== {}", e.getMessage());
			throw new InvocationTargetException(e, "新增失败 ");
		}
	}
	
	public ${config.response} delete(${table.javaName}Request request) throws Exception {
		try {
			${config.response} response = new ${config.response}();
			if(null == request.getIds() || request.getIds().size() < 0){
				throw new RuntimeException("批量删除集合不能为空！");
			}
			facade.deleteEntity(request.getIds());	
			response.setStatus(StatusType.ACCESS_SUCCESSFUL);
			return response;
		} catch (Exception e) {
			logger.error("===== 删除失败 ===== {}", e.getMessage());
			throw new InvocationTargetException(e, "删除失败");
		}
	}

	public ${config.response} update(${table.javaName}Request request) throws Exception {
		try {
			if(null == request.getId()){
				throw new RuntimeException("主键id不能为空！");
			}
			facade.updateEntity(BeanCopyUtil.copy(request, ${table.javaName}.class));
			${config.response} response = new ${config.response}();
			response.setStatus(StatusType.ACCESS_SUCCESSFUL);
			return response;
		} catch (Exception e) {
			logger.error("===== 修改失败 ===== {}", e.getMessage());
			throw new InvocationTargetException(e, "修改失败");
		}
	}

	public ${config.response} find(${table.javaName}Request request) throws Exception {
		try {
			DataGrid<${config.response}> dgrr = null;
			List<${config.response}> list = null;
			${config.response} response = new ${config.response}();
			if(null == request.getPage()){
				list = BeanCopyUtil.copy(facade.findEntityByConditions(
						BeanCopyUtil.copy(request, ${table.javaName}.class)), ${config.response}.class);
			} else {
				dgrr = BeanCopyUtil.copy(facade.findEntityByConditions(
						BeanCopyUtil.copy(request, ${table.javaName}.class),request.getPage()), ${config.response}.class);
			}
			response.setResponse(dgrr);
			response.setList(list);
			response.setStatus(StatusType.ACCESS_SUCCESSFUL);
			return response;
		} catch (Exception e) {
			logger.error("===== 查找失败 ===== {}", e.getMessage());
			throw new InvocationTargetException(e,"查找失败");
		}
	}
	
}
