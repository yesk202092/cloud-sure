package sure.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {
    public static final String CAHCENAME = "cache";
    public static final int CAHCETIME = 7200;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public RedisUtil() {

    }

    public <T> boolean putCache(String key, T obj) {
        final byte[] bkey = key.getBytes();
        deleteCache(key);
        final byte[] bvalue = ProtoStuffSerializerUtil.serialize(obj);
        boolean result = (Boolean) this.redisTemplate.execute(new RedisCallback<Boolean>() {
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.setNX(bkey, bvalue);
            }
        });
        return result;
    }

    public <T> void putCacheWithExpireTime(String key, Class<T> obj, final long expireTime) {
        final byte[] bkey = key.getBytes();
        deleteCache(key);
        final byte[] bvalue = ProtoStuffSerializerUtil.serialize(obj);
        this.redisTemplate.execute(new RedisCallback<Boolean>() {
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                connection.setEx(bkey, expireTime, bvalue);
                return true;
            }
        });
    }

    public <T> boolean putListCache(String key, List<T> objList) {
        final byte[] bkey = key.getBytes();
        deleteCache(key);
        final byte[] bvalue = ProtoStuffSerializerUtil.serializeList(objList);
        boolean result = (Boolean)this.redisTemplate.execute(new RedisCallback<Boolean>() {
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.setNX(bkey, bvalue);
            }
        });
        return result;
    }

    public <T> boolean putListCacheWithExpireTime(String key, List<T> objList, final long expireTime) {
        final byte[] bkey = key.getBytes();
        deleteCache(key);
        final byte[] bvalue = ProtoStuffSerializerUtil.serializeList(objList);
        boolean result = (Boolean)this.redisTemplate.execute(new RedisCallback<Boolean>() {
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                connection.setEx(bkey, expireTime, bvalue);
                return true;
            }
        });
        return result;
    }

    public  <T> T getCache(final String key, Class<T> targetClass) {
        byte[] bkey=key.getBytes();
        byte[] result = (byte[]) this.redisTemplate.execute(new RedisCallback<byte[]>() {
            public byte[] doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.get(bkey);
            }
        });
        return result != null && result.length != 0 ? ProtoStuffSerializerUtil.deserialize(result, targetClass) : null;
    }

    public <T> List<T> getListCache(final String key, Class<T> targetClass) {
        byte[] result = (byte[])this.redisTemplate.execute(new RedisCallback<byte[]>() {
            public byte[] doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.get(key.getBytes());
            }
        });
        return result != null && result.length != 0 ? ProtoStuffSerializerUtil.deserializeList(result, targetClass) : null;
    }

    public void deleteCache(String key) {
        this.redisTemplate.delete(key);
    }

    public void deleteCacheWithPattern(String pattern) {
        Set<String> keys = this.redisTemplate.keys(pattern);
        this.redisTemplate.delete(keys);
    }

    public void clearCache() {
        this.deleteCacheWithPattern("cache|*");
    }

    public Set<String> findKey(String pattern) {
        return this.redisTemplate.keys(pattern);
    }

    public void send(String channel, String json) {
        this.redisTemplate.convertAndSend(channel, json);
    }

    public void expire(String key, long expireTime, TimeUnit unit) {
        this.redisTemplate.expire(key, expireTime, unit);
    }
}
