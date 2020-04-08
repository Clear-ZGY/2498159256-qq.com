package com.itrip.service.impl;

import com.itrip.service.RedisAPIService;
import com.itrip.utils.RedisAPI;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;

@Service("redisAPIService")
public class RedisAPIServiceImpl implements RedisAPIService {
    @Resource
    private RedisAPI redisAPI;

    /**
     * set key and value to redis
     *
     * @param key
     * @param value
     * @return
     */
    @Override
    public boolean set(String key, String value) {
        return redisAPI.set(key, value);
    }

    /**
     * set key and value to redis
     *
     * @param key
     * @param seconds 有效期
     * @param value
     * @return
     */
    @Override
    public boolean set(String key, int seconds, String value) {
        return redisAPI.set(key, seconds, value);
    }

    /**
     * 判断某个key是否存在
     *
     * @param key
     * @return
     */
    @Override
    public boolean exist(String key) {
        return redisAPI.exist(key);
    }

    /**
     * 获取数据
     *
     * @param key
     * @return
     */
    @Override
    public String get(String key) {
        return redisAPI.get(key);
    }

    /**
     * 查询key的有效期,当 key 不存在时，返回 -2 。 当 key 存在但没有设置剩余生存时间时，返回 -1 。 否则，以秒为单位，返回 key 的剩余生存时间。
     * 注意：在 Redis 2.8 以前，当 key 不存在，或者 key 没有设置剩余生存时间时，命令都返回 -1 。
     *
     * @param key
     * @return 剩余多少秒
     */
    @Override
    public Long ttl(String key) {
        return redisAPI.ttl(key);
    }

    /**
     * 删除
     *
     * @param key
     */
    @Override
    public void delete(String key) {
        redisAPI.delete(key);
    }
}
