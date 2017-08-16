package redis.dataDemo.impl;

import redis.dataDemo.client.RedisClient;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;
import redis.dataDemo.interfaces.RedisOperate;

import java.util.Set;

public class RedisKey implements RedisOperate {
    private Jedis jedis;//非切片额客户端连接
    private JedisPool jedisPool;//非切片连接池
    private ShardedJedis shardedJedis;//切片额客户端连接
    private ShardedJedisPool shardedJedisPool;//切片连接池

    public RedisKey(){

    }

    public RedisKey(RedisClient client){
        this.jedis = client.getJedis();
        this.jedisPool = client.getJedisPool();
        this.shardedJedis = client.getShardedJedis();
        this.shardedJedisPool = client.getShardedJedisPool();
    }

    public RedisKey(Jedis jedis,JedisPool jedisPool,ShardedJedis shardedJedis,ShardedJedisPool shardedJedisPool){
        this.jedis = jedis;
        this.jedisPool = jedisPool;
        this.shardedJedis = shardedJedis;
        this.shardedJedisPool = shardedJedisPool;
    }

    public void KeyOperate() {
        System.out.println("======================key==========================");
        // 清空数据
        System.out.println("清空库中所有数据："+jedis.flushDB());
        // 判断key否存在
        System.out.println("判断key999键是否存在："+shardedJedis.exists("key999"));
        System.out.println("新增key001,value001键值对："+shardedJedis.set("key001", "value001"));
        System.out.println("判断key001是否存在："+shardedJedis.exists("key001"));
        // 输出系统中所有的key
        System.out.println("新增key002,value002键值对："+shardedJedis.set("key002", "value002"));
        System.out.println("系统中所有键如下：");
        Set<String> keys = jedis.keys("*");
        for(String key:keys) {
            System.out.println(key);
        }
        // 删除某个key,若key不存在，则忽略该命令。
        System.out.println("系统中删除key002: "+jedis.del("key002"));
        System.out.println("判断key002是否存在："+shardedJedis.exists("key002"));
        // 设置 key001的过期时间
        System.out.println("设置 key001的过期时间为5秒:"+jedis.expire("key001", 5));
        try{
            Thread.sleep(2000);
        }catch(InterruptedException e){
            e.printStackTrace();;
        }
        // 查看某个key的剩余生存时间,单位【秒】.永久生存或者不存在的都返回-1
        System.out.println("查看key001的剩余生存时间："+jedis.ttl("key001"));
        // 移除某个key的生存时间
        System.out.println("移除key001的生存时间："+jedis.persist("key001"));
        System.out.println("查看key001的剩余生存时间："+jedis.ttl("key001"));
        // 查看key所储存的值的类型
        System.out.println("查看key所储存的值的类型："+jedis.type("key001"));
        /*
         * 一些其他方法：1、修改键名：jedis.rename("key6", "key0");
         *             2、将当前db的key移动到给定的db当中：jedis.move("foo", 1)
         */

    }

    public void operate( ) {
        this.KeyOperate();
        jedisPool.returnResource(jedis);
        shardedJedisPool.returnResource(shardedJedis);
    }
}
