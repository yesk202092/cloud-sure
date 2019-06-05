package sure.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import sure.order.OrderService;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


@Controller
@RequestMapping("manage")
public class Index {



    private ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20, 3, TimeUnit.SECONDS, new SynchronousQueue<>());

    //两种使hashmap变成线程安全的方式
    //synchronizedMap
    Map<String, String> synchronizedHashMap = Collections.synchronizedMap(new HashMap<String, String>());

    //ConcurrentHashMap
    Map<String, String> concurrentHashMap = new ConcurrentHashMap<>();

    @RequestMapping("index")
    public String index() {
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("1111");
            }
        });


        return "index";
    }

}
