package ${config.basepkg}.biz;

import org.springframework.stereotype.Service;

import com.sure.BaseBiz;
import ${config.basepkg}.entity.${table.javaName};
import ${config.basepkg}.dao.${table.javaName}Mapper;

/**
* @类名: ${table.comment}Biz
* @描述: service ${table.comment}
* @作者: qianc
* @日期: ${config.date}
*/
@Service
public class ${table.javaName}Biz extends BaseBiz
<${table.javaName}Mapper, ${table.javaName}, Long>{

}
