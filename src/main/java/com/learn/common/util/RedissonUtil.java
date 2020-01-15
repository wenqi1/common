package com.learn.common.util;

import org.redisson.api.RBucket;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import java.util.concurrent.TimeUnit;

public class RedissonUtil {

    private static volatile RedissonClient redissonClient;

    static{
        if (redissonClient == null) {
            synchronized (RedissonUtil.class) {
                if (redissonClient == null) {
                    redissonClient = ApplicationContextUtil.getBean(RedissonClient.class);
                }
            }
        }
    }

    public void lock(String lockName){
        RLock lock = redissonClient.getLock(lockName);
        lock.lock();
    }

    public void lock(String lockName, long timeout){
        RLock lock = redissonClient.getLock(lockName);
        lock.lock(timeout, TimeUnit.SECONDS);
    }

    public boolean lock(String lockName, long wait, long timeout) throws Exception{
        RLock lock = redissonClient.getLock(lockName);
        boolean res = lock.tryLock(wait, timeout, TimeUnit.SECONDS);
        return res;
    }

    public void unLock(String lockName) {
        RLock lock = redissonClient.getLock(lockName);
        lock.unlock();
    }

    /**
     * 根据key获取数据，并封装为指定class实例
     * @param <T>
     * @param clazz
     * @param key
     * @return
     */
    public static <T> T get(Class<T> clazz, String key) {
        RBucket<byte[]> rBucket = redissonClient.getBucket(key);
        byte[] bytes = rBucket.get();
        if (bytes == null) {
            return null;
        }
        return SerializationUtil.deserialize(clazz, rBucket.get());
    }

    /**
     * 根据key删除数据
     * @param key
     */
    public static void remove(String key) {
        redissonClient.getBucket(key).delete();
    }

    /**
     * 缓存数据
     * @param key
     * @param value
     */
    public static void put(String key, Object value) {
        RBucket<byte[]> rBucket = redissonClient.getBucket(key);
        rBucket.set(SerializationUtil.serialize(value));
    }

    /**
     * 缓存数据,有过期时间
     * @param key
     * @param value
     * @param timeout
     * @param timeUnit
     */
    public static void put(String key, Object value, long timeout, TimeUnit timeUnit) {
        RBucket<byte[]> keyObject = redissonClient.getBucket(key);
        keyObject.set(SerializationUtil.serialize(value), timeout, timeUnit);
    }

}
