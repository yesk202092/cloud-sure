package ${config.basepkg}.dao.impl;

import org.springframework.stereotype.Repository;

import com.sendinfo.qyyx.base.dao.impl.BaseDaoImpl;
import ${config.basepkg}.dao.${table.javaName}Dao;
import ${config.basepkg}.entity.${table.javaName};

@Repository
public class ${table.javaName}DaoImpl extends BaseDaoImpl<${table.javaName}, Long> implements ${table.javaName}Dao {

}
