package com.xqr.admin;

import com.xqr.admin.bean.User;
import com.xqr.admin.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Slf4j
@SpringBootTest
class BootWebAdminApplicationTests {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;

    @Resource
    UserMapper userMapper;

    @Resource
    RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
        Long aLong = jdbcTemplate.queryForObject("select count(*) from user ", long.class);
        log.info("记录总数{}",aLong);
        log.info("数据源类型{}",dataSource.getClass());
    }
    @Test
    void testUserMapper(){
        User user = userMapper.selectById(1);
        log.info("用户信息：{}",user);
    }
    //redis测试
    @Test
    void testredis(){
        ValueOperations<String,String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set("hello","word");
        String hello = valueOperations.get("hello");
        System.out.println(hello);
    }

}
