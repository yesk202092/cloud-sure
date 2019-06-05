package sure.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class TimeUtil {

    public static long getTime() {
        return System.nanoTime();
    }

    public static long getReuslt(long endTime, long startTime, String msg) {
        long millis = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
        log.info(String.format(msg + ": %d ms", millis));
        return millis;
    }


}
