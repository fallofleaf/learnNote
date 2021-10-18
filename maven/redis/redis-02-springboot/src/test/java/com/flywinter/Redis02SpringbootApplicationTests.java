package com.flywinter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flywinter.entity.User;
import com.flywinter.utils.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class Redis02SpringbootApplicationTests {

    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
//        redisTemplate.opsForValue(); 操作字符串
//        redisTemplate.opsForList(); 操作list
//        redisTemplate.opsForSet(); 操作set
//        redisTemplate.opsForHash();
//        redisTemplate.opsForZSet();
//        redisTemplate.opsForHyperLogLog();
//        redisTemplate.opsForGeo();

//        处理基本的操作，我们常用方法也可以直接获取
//        redisTemplate.multi();
        //获取连接对象
//        RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
//        connection.flushDb();
//        connection.flushAll();
        redisTemplate.opsForValue().set("mykey","v1");
        Object mykey = redisTemplate.opsForValue().get("mykey");
        System.out.println(mykey);
    }

    @Test
    public void test() throws JsonProcessingException {
        //真实的开发一般都使用json来传递对象
        User user = new User("李四", 3);
        String value = new ObjectMapper().writeValueAsString(user);
        redisTemplate.opsForValue().set("user",user);
        Object user1 = redisTemplate.opsForValue().get("user");
        System.out.println(user1);
    }

    @Autowired
    private RedisUtil redisUtil;
    @Test
    public void test1()  {
        //真实的开发一般都使用json来传递对象

        redisUtil.set("1","1");
        Object o = redisUtil.get("1");
        System.out.println(o);
        redisUtil.del("1");
        Object o1 = redisUtil.get("1");
        System.out.println(o1);
    }

    @Test
    public void testt(){
//        Person jack = new Person("Jack");
//        Person jack2 = new Person("Jack");
//        System.out.println(jack.equals(jack2));  //fasle
//        System.out.println(jack == jack2);
//        String s1 = new String("s1");
//        String s2 = new String("s1");
//        System.out.println(s1.equals(s2));
//        String s1 = "通话";
//        String s2 = "重地";
//        System.out.println(String.format("s1:%d | s2 %d",s1.hashCode(),s2.hashCode())); //s1:1179395 | s2 1179395
//        System.out.println(s1.equals(s2)); //false

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("123456");
        System.out.println(stringBuffer.reverse()); //654321
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("123456");
        System.out.println(stringBuilder.reverse());//654321

    }


}
class Person{
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
