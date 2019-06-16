package sure.sys.biz;

import com.sure.BaseBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import sure.sys.dao.SysBaseInfoMapper;
import sure.sys.entity.SysBaseInfo;
import sure.utils.TimeUtil;

import java.util.*;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

/**
 * @类名: 系统信息表Biz
 * @描述: service 系统信息表
 * @作者: qianc
 * @日期: 2019-04-24 11:00:13
 */
@Service
public class SysBaseInfoBiz extends BaseBiz<SysBaseInfoMapper, SysBaseInfo, Long> {
    List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
    @Autowired
    SysFunctionsBiz sysFunctionsBiz;
    private ReentrantLock lock = new ReentrantLock();

    private void test() {
        lock.lock();
        lock.unlock();
        //原语法
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });
        //一，接口的默认方法
        //二，lombda语法
        Collections.sort(names, (a, b) -> b.compareTo(a));
        //三，函数式接口声明方式
        SysFunctionsBiz.Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
        Integer converted = converter.convert("123");
        System.out.println(converted);    // 123
        //四，使用双冒号：：关键字传递方法或者构造函数引用
        converter = Integer::valueOf;
        Integer intConverter = converter.convert("123");
        System.out.println(converted);    // 123
        //五、Lambda 作用域
        //六、访问局部变量 仅能访问不可变值，必须有final标志
        final int num = 1;
        intConverter = intConverter + num;
        //七、访问对象字段与静态变量 可忽略
        //八、访问接口的默认方法
        //九、Date API
        //十、多重注册，Annotation 注解

    }



    public static void main(String[] args) {

        int size = 20;
        List<SysBaseInfo> sysBaseInfoCollection = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            SysBaseInfo sysBaseInfo = new SysBaseInfo();
            UUID uuid = UUID.randomUUID();
            sysBaseInfo.setId(uuid.getMostSignificantBits());
            sysBaseInfoCollection.add(sysBaseInfo);
        }
        Collections.sort(sysBaseInfoCollection, (max, min) -> max.getId().compareTo(min.getId()));
        sysBaseInfoCollection = sysBaseInfoCollection.stream().sorted().filter((s) -> !Objects.equals(s, "")).collect(Collectors.toList());
        long startTime = TimeUtil.getTime();
        sysBaseInfoCollection.forEach(t -> System.out.println(t.getId()));
        long endTime = TimeUtil.getTime();
        TimeUtil.getReuslt(endTime, startTime, "普通listFor计算方法执行时间");




    }


}
