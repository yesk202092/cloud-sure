package sure.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import sure.po.SysInfo;
import sure.po.SysInfoExample;

import java.util.List;
@Repository
public interface SysInfoMapper {
   @Select("select ID as id,SYS_NAME sysName from SYS_INFO")
    SysInfo findSysInfo();
}