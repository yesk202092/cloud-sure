package sure.sys.biz;

import com.sure.BaseBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sure.sys.dao.SysFunctionsMapper;
import sure.sys.entity.SysBaseInfo;
import sure.sys.entity.SysFunctions;

/**
* @类名: 系统功能模块Biz
* @描述: service 系统功能模块
* @作者: qianc
* @日期: 2019-04-24 11:00:13
*/
@Service
public class SysFunctionsBiz extends BaseBiz
        <SysFunctionsMapper, SysFunctions, Long> {


    //函数式声明接口方式
    @FunctionalInterface
    interface Converter<F, T> {
            T convert(F from);
    }

}
