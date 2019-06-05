package sure.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


@Controller
@RequestMapping("manage")
public class Index {

    private ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20, 3, TimeUnit.SECONDS, new SynchronousQueue<>());

    @RequestMapping("index")
    public String index(){
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("1111");
            }
        });
        return "index";
    }

}
