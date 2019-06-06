package sure.utils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MapUtil {

    /**
     *     //两种使hashmap变成线程安全的方式
     *     //synchronizedMap
     *     Map<String, String> synchronizedHashMap = Collections.synchronizedMap(new HashMap<String, String>());
     *
     *     //ConcurrentHashMap
     *     Map<String, String> concurrentHashMap = new ConcurrentHashMap<>();
     * */
    public static Map syncHashMap() {
        return Collections.synchronizedMap(new HashMap<>());
    }

    public static Map concurrentHashMap() {
        return new ConcurrentHashMap<>();
    }
}
