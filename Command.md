String
•set [ket] [value] 赋值
•get [key] 取值
•incr [key] 该key自增1
•decr [key] 该key自减1
•incrby [key] [X] 该key增X
•decrby [key] [X] 该key减X
•append [key] [X] 该key后拼接X

Hash
•hset [hashname] [key] [value] 给hashname中存入单个key-value键值对
•hmset [hashname] [key0] [value0] [key1] [vaule1] [key2] [value2]... 给hashname中存入多个key-value键值对
•hget [hashname] [key] 获取hashname的key的值
•hmget [hashname] [key0] [key1] [key2]...获取hashname的多个key的值
•hgetall [hashname] 获取hashname的所有属性
•hdel [hashname] [key] 删除hashname的key的值
•del [hashname] 删除整个集合
•hincrby [hashname] [key] X 给hashname的key增加5
•hexists [hashname] [key] 判断hashname的key是否存在
•hlen [hashname] 获取hashname的属性的个数
•hkeys [hashname] 获取hashname所有的key
•hvals [hashname] 获取hashname所有的value

List
•lpush [listname] [value0] [value1] [value2]...给listname左侧添加value
•rpush [listname] [value0] [value1] [value2]...给listname右侧添加value
•lrange [listname] [start] [end] 查看listname从start到end,end为-1时表示最后一个元素,end为-2时表示倒数第2个元素
•lpop [listname] 左弹出listname第一个元素
•rpop [listname] 右弹出listname最后一个元素
•llen [listname] 获取listname元素个数
•lpushx [listname] [X] 将X插入listname的头部，不存在listname则不插入
•rpushx [listname] [X] 将X插入listname的尾部，不存在listname则不插入
•lren [listname] [count] [value] 删除listname中count个value,count为正数则从头部开始删,count为负数则从尾部开始删,count为0时则删除listname中所有的value
•lset [listname] [index] [value] 设置listname第index个的元素的值为value
•linsert [listname] [before/after] [value1] [value2] 在listname的第一个value1之前/之后插入一个value2
•rpoplpush [listname1] [listname2] 将listname1的尾部最后一个原始弹出放到listname2头部第一个元素

Set
•sadd [setname] [value0] [value1] [value2]...给setname中添加value,不能重复
•srem [setname] [value0] [value1] [value2]...删除set中的value
•smembers [setname] 查看setname中所有数据
•sismember [setname] [value] 判断setname是否存在value
•sdiff [setname1] [setname2] 差集运算setname1-setname2,属于setname1且不属于setname2的元素
•sinter [setname1] [setname2] 交集运算
•sunion [setname1] [setname2] 并集运算
•scard [setname] 获取setame元素个数
•srandmember [setname] 随机返回setname的一个元素
•sdiffstore [setname0] [setname1] [setname2] 将setname1与setname2差集运算的结果存放到setname0中
•sinterstore [setname0] [setname1] [setname2] 将setname1与setname2交集运算的结果存放到setname0中
•sunionstore [setname0] [setname1] [setname2] 将setname1与setname2并集运算的结果存放到setname0中

Sorted-Set
•zadd [sortedname] [score0 value0] [score1 value1] 给sortedset添加value,每个value都有一个分数score,如果value已经存在则只更新score
•zscore [sortedname] [value] 查看sortedname中value的score
•zcard [sortedname] 获取sortedname中元素个数
•zrange [sortedname] [start] [end] 按照分数从小到大查看sortedname的元素,从start到end,end为-1时表示最后一个元素,后面加上withscores则显示score
•zrevrange [sortedname] [start] [end] 按照分数从大到小查看sortedname的元素,从start到end,end为-1时表示最后一个元素,后面加上withscores则显示score
•zrangebyscore [sortedname] [score] [score] 分数范围查看sortedname的元素,后面加上withscores则显示score,后面加上limit[start] [end]选择显示个数
•zrem [sortedname] [value0] [value1] 删除sortedname中的value
•zremrangebyrank [sortedname] [start] [end] 删除sortedname从start到end的元素
•zremrangebyscore [sortedname] [score] [score] 按照score分数范围删除sortedname的元素
•zincrby [sortedname] [score] [value] 给指定元素增加分数
•zcount [sortedname] [score] [score] 查看sortedname在分数范围内的成员个数

keys通用操作、事务
•keys * 查看所有key
•del [key] 删除key
•exists [key] 判断key是否存在
•rename [key] [newkey] 改名
•expire [key] [S] 设置key在S秒后失效
•ttl [key] 查看key失效时间
•type [key] 获取key的指定类型
•select [0-15] 选择0-15个数据库
•move [key] [0-15] 将key移动动到另一个数据库中
•multi 开启事务
•exec 提交事务
•discard 回滚事务
