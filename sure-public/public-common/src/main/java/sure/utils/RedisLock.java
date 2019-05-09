package sure.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;
import redis.clients.util.SafeEncoder;

import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.UUID;
import java.util.concurrent.locks.LockSupport;

@Component
@Slf4j
public class RedisLock {
    /*
    60秒默认锁过期时间
     */
    private static final int CAHCETIME = 300;
    private static final int WAIT_TIME = 30;
    private static final String LOCK_SUCCESS = "OK";

    private static final String SET_IF_NOT_EXIST = "NX";
    private static final String SET_WITH_EXPIRE_TIME = "EX";
    private static final ThreadLocal<String> threadRequestId = new ThreadLocal<>();


    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    private synchronized String getThreadRequestId(){
        String requestId = threadRequestId.get();
        if(requestId==null){
            requestId = UUID.randomUUID().toString();
            threadRequestId.set(requestId);
        }
        return requestId;
    }
    /**
     * description: request使用UUID生成,保存在threadRequestId中 ,不支持重入
     * @author: yingww
     * @date: 2019-02-12
     * @param lockKey
     * @return
     */
    public  boolean lock( String lockKey) {
        String requestId = getThreadRequestId();
        return tryGetDistributedLock(lockKey,requestId,CAHCETIME);
    }
    public  boolean lock(String lockKey, int cacheTime) {
        String requestId = getThreadRequestId();
        return tryGetDistributedLock(lockKey,requestId,CAHCETIME);
    }
    /**
     * description: 排他锁 无重试
     * @author yingww
     * @date 2018/08/10 0010
     * @param lockKey
     * @param requestId
     * @return
     */
    public  boolean lock(String lockKey, String requestId) {
        return tryGetDistributedLock(lockKey,requestId,CAHCETIME);
    }
    public  boolean lock(String lockKey, String requestId, int cacheTime ) {
        return tryGetDistributedLock(lockKey,requestId,cacheTime);
    }
    public  boolean tryLock( String lockKey){
        String requestId = getThreadRequestId();
        return tryLock(lockKey,requestId,CAHCETIME,WAIT_TIME);
    }

    public  boolean tryLock(String lockKey, int waitTime){
        String requestId = getThreadRequestId();
        return tryLock(lockKey,requestId,CAHCETIME,waitTime);
    }

    public  boolean tryLock(String lockKey, String requestId ){
        return tryLock(lockKey,requestId,CAHCETIME,WAIT_TIME);
    }

    public  boolean tryLock(String lockKey, String requestId, int waitTime){
        return tryLock(lockKey,requestId,CAHCETIME,waitTime);
    }
    /**
     * description: 带重试,等待expireTime
     * @author yingww
     * @date 2018/08/10 0010
     * @param lockKey
     * @param requestId
     * @param expireTime 锁过期 /s
     * @param waitTime 等待时长 /s
     * @return
     */
    public  boolean tryLock(String lockKey, String requestId, int expireTime, int waitTime) {
        if(expireTime<=0||waitTime<=0){
            return false;
        }
        if(tryGetDistributedLock(lockKey,requestId,expireTime)){
            return true;
        }
        //纳秒
        long nanosTimeout  =  waitTime*1000000000L;
        final long deadline = System.nanoTime() + nanosTimeout;
        try{
            for (;;) {
                nanosTimeout = deadline - System.nanoTime();
                if (nanosTimeout <= 0L){
                    return false;
                }
                //等待100ms
                LockSupport.parkNanos(100000000L);
                if(tryGetDistributedLock(lockKey,requestId,expireTime)){
                    return true;
                }
            }
        }catch (Exception e){
            log.error(e.getMessage(),e);
            return  false;
        }
    }



    /**
     * 尝试获取分布式锁
     * @param lockKey 锁
     * @param requestId 请求标识,客户端id ,谁加锁,谁解锁
     * @param aliveTime 超期时间,存活时长
     * @return 是否获取成功
     */
    private   boolean tryGetDistributedLock(String lockKey, String requestId, int aliveTime) {
        return this.redisTemplate.execute((RedisCallback<Boolean>) connection -> {
            RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
            Object returns =connection.execute("set",serializer.serialize(lockKey),
                    serializer.serialize(requestId),  serializer.serialize(SET_IF_NOT_EXIST),serializer.serialize(SET_WITH_EXPIRE_TIME), SafeEncoder.encode(String.valueOf(aliveTime))
            );
            if(returns==null){
                return false;
            }
            try {
                String returnStr = new String(((byte[]) returns),"UTF-8");
                if(LOCK_SUCCESS.equals(returnStr)){
                    return true;
                }
            } catch (UnsupportedEncodingException e) {
                log.error(e.getMessage(),e);
            }

            return false;
        });

    }
    /**
     * 释放分布式锁
     * @param lockKey 锁
     * @param requestId 请求标识
     * @return 是否释放成功
     */
    public boolean releaseLock(String lockKey, String requestId) {
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        return redisTemplate.execute(new DefaultRedisScript<>(script, Boolean.class), Collections.singletonList(lockKey),requestId);
    }

    public boolean releaseLock( String lockKey) {
        String requestId = threadRequestId.get();
        if(requestId!=null){
            String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
            return redisTemplate.execute(new DefaultRedisScript<>(script, Boolean.class),
                    Collections.singletonList(lockKey),requestId);
        }
        return  false;
    }



    @Deprecated
    public String deleteCache(String key){
        return this.redisTemplate.execute((RedisCallback<String>) connection -> {
            RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
            Object returns = connection.execute("del", serializer.serialize(key));
            return returns.toString();
        });
    }


    @Deprecated
    public String getCache(String key){
        return this.redisTemplate.execute((RedisCallback<String>) connection -> {
            RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
            Object returns = connection.execute("get", serializer.serialize(key));
            return returns.toString();
        });
    }

    @Deprecated
    public String setCache(String key, String value){
        return this.redisTemplate.execute((RedisCallback<String>) connection -> {
            RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
            Object returns = connection.execute("set", serializer.serialize(key),serializer.serialize(key));
            return returns.toString();
        });
    }



}
