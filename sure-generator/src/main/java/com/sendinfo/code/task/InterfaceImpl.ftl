package ${config.ifacepkg}.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ${config.ifacepkg}.${table.javaName}Interface;
import ${config.basepkg}.facade.${table.javaName}Facade;
import ${config.basepkg}.service.${table.javaName}Service;

@Service("${table.javaNameL}Interface")
public class ${table.javaName}InterfaceImpl implements ${table.javaName}Interface {

	@Resource
	private ${table.javaName}Service ${table.javaNameL}Service;
	@Resource
	private ${table.javaName}Facade ${table.javaNameL}Facade;

}
