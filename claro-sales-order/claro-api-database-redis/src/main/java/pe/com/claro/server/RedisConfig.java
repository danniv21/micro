/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.claro.server;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import redis.clients.jedis.JedisPoolConfig;

/**
 *
 * @author user
 */
@Configuration
@EnableRedisRepositories(basePackages = {"pe.com.claro.server"})
public class RedisConfig {

    @Value("${spring.data.redis.hostname}")
    private String hostName;
    @Value("${spring.data.redis.port}")
    private int port;
    @Value("${spring.data.redis.use.pool}")
    private boolean usePool;
    @Value("${spring.data.redis.clientname}")
    private String clientName;
    @Value("${spring.data.redis.convertpipelineandtxresults:false}")
    private boolean convertPipelineAndTxResults;
    @Value("${spring.data.redis.database:0}")
    private int dataBase;
    @Value("${spring.data.redis.password}")
    private String password;
    @Value("${spring.data.redis.timeout:1000}")
    private int timeOut;
    @Value("${spring.data.redis.use.ssl:false}")
    private boolean useSsl;
    @Value("${spring.data.redis.maxidle:200}")
    private int maxIdle;
    @Value("${spring.data.redis.minidle:200}")
    private int minIdle;
    @Value("${spring.data.redis.testonborrow:false}")
    private boolean testOnBorrow;
    @Value("${spring.data.redis.blockwhenexhausted:false}")
    private boolean blockWhenExhausted;
//    @Value("${spring.data.redis.evictionpolicyclassname:org.apache.commons.pool2.impl.DefaultEvictionPolicy}")
//    private String evictionPolicyClassName;
    @Value("${spring.data.redis.fairness:false}")
    private boolean fairNess;
    @Value("${spring.data.redis.jmxenabled:false}")
    private boolean jmxEnabled;
    @Value("${spring.data.redis.jmxnamebase}")
    private String jmxNameBase;
    @Value("${spring.data.redis.jmxnameprefix}")
    private String jmxNamePrefix;
    @Value("${spring.data.redis.lifo:false}")
    private boolean lifo;
    @Value("${spring.data.redis.maxtotal:200}")
    private int maxTotal;
    @Value("${spring.data.redis.maxwaitmillis:200}")
    private int maxWaitMillis;
    @Value("${spring.data.redis.minevictableidletimemillis}")
    private long minEvictableIdleTimeMillis;
    @Value("${spring.data.redis.numtestsperevictionrun}")
    private int numTestsPerEvictionRun;
    @Value("${spring.data.redis.softMinevictableidletimemillis:200}")
    private long softMinEvictableIdleTimeMillis;
    @Value("${spring.data.redis.testoncreate:false}")
    private boolean testOnCreate;
    @Value("${spring.data.redis.testonreturn:false}")
    private boolean testOnReturn;
    @Value("${spring.data.redis.testwhileidle:false}")
    private boolean testWhileIdle;
    @Value("${spring.data.redis.timebetweenevictionrunsmillis}")
    private long timeBetweenEvictionRunsMillis;

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        JedisPoolConfig redisconf = new JedisPoolConfig();
        redisconf.setMaxIdle(maxIdle);
        redisconf.setMinIdle(minIdle);
        redisconf.setTestOnBorrow(testOnBorrow);
        redisconf.setBlockWhenExhausted(blockWhenExhausted);
//        redisconf.setEvictionPolicyClassName(evictionPolicyClassName);
        redisconf.setFairness(fairNess);
        redisconf.setJmxEnabled(jmxEnabled);
        redisconf.setJmxNameBase(jmxNameBase);
        redisconf.setJmxNamePrefix(jmxNamePrefix);
        redisconf.setLifo(lifo);
        redisconf.setMaxTotal(maxTotal);
        redisconf.setMaxWaitMillis(maxWaitMillis);
        redisconf.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        redisconf.setNumTestsPerEvictionRun(numTestsPerEvictionRun);
        redisconf.setSoftMinEvictableIdleTimeMillis(softMinEvictableIdleTimeMillis);
        redisconf.setTestOnCreate(testOnCreate);
        redisconf.setTestOnReturn(testOnReturn);
        redisconf.setTestWhileIdle(testWhileIdle);
        redisconf.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        JedisConnectionFactory factory = new JedisConnectionFactory(redisconf);
        factory.setHostName(hostName);
        factory.setPort(port);
        factory.setUsePool(usePool);
        factory.setClientName(clientName);
        factory.setConvertPipelineAndTxResults(convertPipelineAndTxResults);
        factory.setDatabase(dataBase);
        factory.setPassword(password);
        factory.setTimeout(timeOut);
        factory.setUseSsl(useSsl);
        return factory;
    }

    @Bean
    RedisTemplate<Object, Object> redisTemplate() {
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setEnableTransactionSupport(true);
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        return redisTemplate;
    }

    @Bean
    RedisCacheManager cacheManager() {
        RedisCacheManager redisCacheManager = new RedisCacheManager(redisTemplate());
        return redisCacheManager;
    }

//    @Bean
//    JedisConnectionFactory jedisConnectionFactory() {
////        JedisPoolConfig poolConfig = new JedisPoolConfig();
////        poolConfig.setMaxTotal(10);
////        poolConfig.setMaxIdle(5);
////        poolConfig.setMinIdle(1);
////        poolConfig.setTestOnBorrow(true);
////        poolConfig.setTestOnReturn(true);
////        poolConfig.setTestWhileIdle(true);
////        poolConfig.setMaxWaitMillis(10 * 1000);
//        //JedisConnectionFactory cf = new JedisConnectionFactory(poolConfig);
//        //cf.setHostName(redisService.getHostname());
//        JedisConnectionFactory jedisConFactory = new JedisConnectionFactory();
//        jedisConFactory.setHostName("192.168.99.101");
//        jedisConFactory.setPort(6379);
//        //jedisConFactory.setPoolConfig(poolConfig);
//       // jedisConFactory.setUsePool(true);
//
//        return jedisConFactory;
//    }
//
//    @Bean
//    public RedisTemplate<String, Object> redisTemplate() {
//        final RedisTemplate<String, Object> template = new RedisTemplate<>();
//        template.setConnectionFactory(jedisConnectionFactory());
//        template.setValueSerializer(new GenericToStringSerializer<>(Object.class));
//        return template;
//    }
}
