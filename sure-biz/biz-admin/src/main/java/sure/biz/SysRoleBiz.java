package sure.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sure.mapper.SysInfoMapper;
import sure.po.SysInfo;

@Service
public class SysRoleBiz {

    @Autowired
    SysInfoMapper sysInfoMapper;

    public String getName() {
        SysInfo sysInfo = sysInfoMapper.findSysInfo();
        return "I LOVE YOU MY BABY" + sysInfo.getSysName();
    }
}
