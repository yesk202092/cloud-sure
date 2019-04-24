package sure.sys.biz;

import com.sure.BaseBiz;
import org.springframework.stereotype.Service;
import sure.sys.dao.SysLabelMapper;
import sure.sys.entity.SysLabel;

/**
* @类名: 产品标签表Biz
* @描述: service 产品标签表
* @作者: qianc
* @日期: 2019-04-24 11:00:13
*/
@Service
public class SysLabelBiz extends BaseBiz
        <SysLabelMapper, SysLabel, Long> {

}
