package ${config.basepkg}.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sendinfo.base.dao.BaseDao;
import com.sendinfo.base.service.BaseServiceImpl;
import ${config.basepkg}.dao.${table.javaName}Dao;
import ${config.basepkg}.entity.${table.javaName};
import ${config.basepkg}.service.${table.javaName}Service;

@Service("${table.javaNameL}Service")
public class ${table.javaName}ServiceImpl extends BaseServiceImpl<${table.javaName}, Long> implements ${table.javaName}Service {

	@Resource
	private ${table.javaName}Dao ${table.javaNameL}Dao;

	@Override
	protected BaseDao<${table.javaName}, Long> getBaseDao() {
		return this.${table.javaNameL}Dao;
	}
}
