package ${config.basepkg}.facade.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ${config.basepkg}.facade.${table.javaName}Facade;
import ${config.basepkg}.service.${table.javaName}Service;

@Service("${table.javaNameL}Facade")
public class ${table.javaName}FacadeImpl implements ${table.javaName}Facade {

	@Resource
	private ${table.javaName}Service ${table.javaNameL}Service;

}
