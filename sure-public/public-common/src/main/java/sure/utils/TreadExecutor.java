package sure.utils;

import java.util.concurrent.*;

public class TreadExecutor {

    public static ThreadPoolExecutor threadPoolExecutor(int coreSize, int maxPoolSize, Long keepAliveTime) {
        return new ThreadPoolExecutor(coreSize, maxPoolSize, keepAliveTime, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
    }

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor=threadPoolExecutor(10,30,60L);
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("1111");
            }
        });
    }

}
