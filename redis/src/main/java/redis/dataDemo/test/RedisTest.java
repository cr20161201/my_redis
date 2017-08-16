package redis.dataDemo.test;

import redis.dataDemo.client.RedisClient;
import redis.dataDemo.impl.*;
import redis.dataDemo.interfaces.RedisOperate;

public class RedisTest {

    public static void main(String[] args) {
        RedisClient client = new RedisClient();

        //测试Key
        RedisOperate operateKey = new RedisKey(client);
        operateKey.operate();
        //测试String
        RedisOperate operateString = new RedisString(client);
        operateString.operate();
        //测试Set
        RedisOperate operateSet = new RedisSet(client);
        operateSet.operate();
        //测试List
        RedisOperate operateList = new RedisList(client);
        operateList.operate();
        //测试Hash
        RedisOperate operateHash = new RedisHash(client);
        operateHash.operate();
        //测试SortSet
        RedisOperate operateSortSet = new RedisSortSet(client);
        operateSortSet.operate();


    }
}
