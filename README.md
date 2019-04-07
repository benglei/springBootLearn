# springbootLearn
springBoot的学习仓库
使用redis作为缓存步骤：
一、jar引入：
    <!-- caching -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-cache</artifactId>
    </dependency>
    <!--操作redis数据库需要的依赖-->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-redis</artifactId>
    </dependency>
    <!-- 使用redis缓存需要的依赖 -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-redis</artifactId>
    </dependency>
二、在配置文件中做redis配置：
    #redis缓存
    spring.cache.type=redis
    #redis
    spring.redis.host=192.168.2.131
    spring.redis.port=6379
    #spring.redis.password=123456
    #spring.redis.database=0
    #spring.redis.pool.max-active=8
    #spring.redis.pool.max-idle=8
    #spring.redis.pool.max-wait=-1
    #spring.redis.pool.min-idle=0
    #spring.redis.timeout=0
三、在启动类上面加入:
    @EnableCaching //缓存的总开关
四、在需要的缓存的类中加入注解
    1、在类上面加上：
        //缓存配置，cacheNames缓存的名称
        @CacheConfig(cacheNames = "roncooCache")  
    2、在需要缓存的方法加上相应的注解：
        //应用到读取数据的方法上，即可缓存的方法，如查找方法：先从缓存中读取，如果没有再调
        //用方法获取数据，然后把数据添加到缓存中。 适用于查找
        @Cacheable  
        //主要针对方法配置，能够根据方法的请求参数对其结果进行缓存，和 @Cacheable 不同的
        // 是，它每次都会触发真实方法的调用。 适用于更新和插入
        @CachePut
        //主要针对方法配置，能够根据一定的条件对缓存进行清空。 适用于删除
        @CacheEvict
 redis 自定义缓存管理器:
    如该项目中RedisCacheConfigurationSelf类
    