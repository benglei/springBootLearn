# springbootLearn
springBoot的学习仓库
mybatis集成:
一、jar包引入
    <!--
        spring-boot mybatis依赖：
        请不要使用1.0.0版本，因为还不支持拦截器插件，
        1.1.1 是博主写帖子时候的版本，大家使用最新版本即可
     -->
    <dependency>
        <groupId>org.mybatis.spring.boot</groupId>
        <artifactId>mybatis-spring-boot-starter</artifactId>
        <version>1.1.1</version>
    </dependency>
二、在配置文件中配置mybatis:
    #数据库连接配置
    spring.datasource.url=jdbc:mysql://localhost/spring_boot_demo?useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT
    spring.datasource.username=root
    spring.datasource.password=1
    spring.datasource.driver-class-name=com.mysql.jdbc.Driver
    spring.datasource.max-active=20
    spring.datasource.max-idle=8
    spring.datasource.min-idle=8
    spring.datasource.initial-size=10
    #如果使用mybatis的xml文件模式还需如下配置
    #mybatis,这个是使用了xml的mybatis模式，就需要配置xml路径了
    mybatis.mapper-locations: classpath:mybatis/*.xml
    #mybatis.type-aliases-package: com.roncoo.example.bean
三:在启动类上面添加注解:
    //扫描：该包下相应的class,主要是MyBatis的持久化类.是包的路径,下面有两个包（一个是使用xml文件，一个是没有使用xml文件的）
    @MapperScan(basePackages = {"com.springboot.full.edition.fulledition.noMapperXML","com.springboot.full.edition.fulledition.haveMapperXML"})
四、定义mapper接口:
    1、没有使用的xml的接口定义如下(需要添加一些注解和sql):
        public interface RoncooUserMapper {
            @Insert(value = "insert into roncoo_user (name, create_time) values (#{name,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP})")
            public int insert(RoncooUser record);
        
            @Select(value = "select id, name, create_time from roncoo_user where id = #{id}")
            @Results(value = { @Result(column = "create_time", property = "createTime") })
            public RoncooUser selectByPrimaryKey(Integer id);
            @Update(value="update roncoo_user set name=#{name},create_time=#{createTime}")
            public int update(RoncooUser record);
            @Select("select * from roncoo_user where name like concat('%',#{name},'%')")
            public List<RoncooUser> likeName(String name);
            @Delete(value = "delete from roncoo_user where id=#{id}")
            public int delete(Integer id);
        }
        
    2、使用的xml的接口定义如下(就是普通接口，不用做啥处理):
        public interface RoncooUserDao {
            int countByExample(RoncooUserExample example);
            int deleteByExample(RoncooUserExample example);
            int deleteByPrimaryKey(Integer id);
            int insert(RoncooUser record);
            int insertSelective(RoncooUser record);
            List<RoncooUser> selectByExample(RoncooUserExample example);
            RoncooUser selectByPrimaryKey(Integer id);
            int updateByExampleSelective(@Param("record") RoncooUser record, @Param("example") RoncooUserExample example);
            int updateByExample(@Param("record") RoncooUser record, @Param("example") RoncooUserExample example);
            int updateByPrimaryKeySelective(RoncooUser record);
            int updateByPrimaryKey(RoncooUser record);
        }


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
        //缓存名称配置，cacheNames缓存的名称
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
    