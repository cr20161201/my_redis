package redis.dataDemo.impl;

import redis.dataDemo.client.RedisClient;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;
import redis.dataDemo.interfaces.RedisOperate;

public class RedisHash implements RedisOperate {
    private Jedis jedis;//非切片额客户端连接
    private JedisPool jedisPool;//非切片连接池
    private ShardedJedis shardedJedis;//切片额客户端连接
    private ShardedJedisPool shardedJedisPool;//切片连接池

    public RedisHash(){

    }

    public RedisHash(RedisClient client){
        this.jedis = client.getJedis();
        this.jedisPool = client.getJedisPool();
        this.shardedJedis = client.getShardedJedis();
        this.shardedJedisPool = client.getShardedJedisPool();
    }

    private void HashOperate() {
        System.out.println("======================hash==========================");
        //清空数据
        System.out.println(jedis.flushDB());

        System.out.println("=============增=============");
        System.out.println("hashs中添加key001和value001键值对："+shardedJedis.hset("hashs", "key001", "value001"));
        System.out.println("hashs中添加key002和value002键值对："+shardedJedis.hset("hashs", "key002", "value002"));
        System.out.println("hashs中添加key003和value003键值对："+shardedJedis.hset("hashs", "key003", "value003"));
        System.out.println("新增key004和4的整型键值对："+shardedJedis.hincrBy("hashs", "key004", 4l));
        System.out.println("hashs中的所有值："+shardedJedis.hvals("hashs"));
        System.out.println();

        System.out.println("=============删=============");
        System.out.println("hashs中删除key002键值对："+shardedJedis.hdel("hashs", "key002"));
        System.out.println("hashs中的所有值："+shardedJedis.hvals("hashs"));
        System.out.println();

        System.out.println("=============改=============");
        System.out.println("key004整型键值的值增加100："+shardedJedis.hincrBy("hashs", "key004", 100l));
        System.out.println("hashs中的所有值："+shardedJedis.hvals("hashs"));
        System.out.println();

        System.out.println("=============查=============");
        System.out.println("判断key003是否存在："+shardedJedis.hexists("hashs", "key003"));
        System.out.println("获取key004对应的值："+shardedJedis.hget("hashs", "key004"));
        System.out.println("批量获取key001和key003对应的值："+shardedJedis.hmget("hashs", "key001", "key003"));
        System.out.println("获取hashs中所有的key："+shardedJedis.hkeys("hashs"));
        System.out.println("获取hashs中所有的value："+shardedJedis.hvals("hashs"));
        System.out.println();

    }

    public void operate() {
        this.HashOperate();
        jedisPool.returnResource(jedis);
        shardedJedisPool.returnResource(shardedJedis);
    }
}
