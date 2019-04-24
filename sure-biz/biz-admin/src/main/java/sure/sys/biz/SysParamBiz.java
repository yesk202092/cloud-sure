package sure.sys.biz;

import com.sure.BaseBiz;
import org.springframework.stereotype.Service;
import sure.sys.dao.SysParamMapper;
import sure.sys.entity.SysParam;

/**
* @类名: 系统参数表Biz
* @描述: service 系统参数表
* @作者: qianc
* @日期: 2019-04-24 11:00:13
*/
@Service
public class SysParamBiz extends BaseBiz
        <SysParamMapper, SysParam, Long> {

}
