package hello.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.MapPropertySource;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zouyi on 11/8/2016.
 */
@Configuration
@EnableCaching
public class RedisCacheConfig extends CachingConfigurerSupport {
//    @Value("${spring.redis.cluster.nodes}")
//
//    private String clusterNodes;
//
//    @Value("${spring.redis.cluster.timeout}")
//
//    private Long timeout;
//
//    @Value("${spring.redis.cluster.max-redirects}")
//
//    private int redirects;
//
//    @Bean
//
//    public RedisClusterConfiguration getClusterConfiguration() {
//
//        Map<String, Object> source = new HashMap<String, Object>();
//
//        source.put("spring.redis.cluster.nodes", clusterNodes);
//
//        source.put("spring.redis.cluster.timeout", timeout);
//
//        source.put("spring.redis.cluster.max-redirects", redirects);
//
//        return new RedisClusterConfiguration(new MapPropertySource("RedisClusterConfiguration", source));
//
//    }
    @Bean
    public JedisConnectionFactory redisConnectionFactory() {
        JedisConnectionFactory jedisConFactory = new JedisConnectionFactory();
        jedisConFactory.setHostName("localhost");
        jedisConFactory.setPort(6379);
        return jedisConFactory;
    }

    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory cf) {
        RedisTemplate<String, String> redisTemplate = new RedisTemplate<String, String>();
        redisTemplate.setConnectionFactory(cf);
        return redisTemplate;
    }

    @Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate) {
        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);

        // Number of seconds before expiration. Defaults to unlimited (0)
        cacheManager.setDefaultExpiration(3000); // Sets the default expire time (in seconds)
        return cacheManager;
    }

}
