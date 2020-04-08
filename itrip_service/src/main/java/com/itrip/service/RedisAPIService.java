package com.itrip.service;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public interface RedisAPIService {
    /**
     * set key and value to redis
     * @param key
     * @param value
     * @return
     */
    public boolean set(String key,String value);

    /**
     * set key and value to redis
     * @param key
     * @param seconds 有效期
     * @param value
     * @return
     */
    public boolean set(String key,int seconds,String value);

    /**
     * 判断某个key是否存在
     * @param key
     * @return
     */
    public boolean exist(String key);

    /**
     * 获取数据
     * @param key
     * @return
     */
    public String get(String key);

    /**
     * 查询key的有效期,当 key 不存在时，返回 -2 。 当 key 存在但没有设置剩余生存时间时，返回 -1 。 否则，以秒为单位，返回 key 的剩余生存时间。
     * 注意：在 Redis 2.8 以前，当 key 不存在，或者 key 没有设置剩余生存时间时，命令都返回 -1 。
     * @param key
     * @return 剩余多少秒
     */
    public Long ttl(String key);

    /**
     * 删除
     * @param key
     */
    public void delete(String key);


}
