package sure.sys.biz;

import com.sure.BaseBiz;
import org.springframework.stereotype.Service;
import sure.sys.dao.SysRoleMapper;
import sure.sys.entity.SysRole;

/**
* @类名: 角色信息Biz
* @描述: service 角色信息
* @作者: qianc
* @日期: 2019-04-24 11:00:13
*/
@Service
public class SysRoleBiz extends BaseBiz
        <SysRoleMapper, SysRole, Long> {

}
