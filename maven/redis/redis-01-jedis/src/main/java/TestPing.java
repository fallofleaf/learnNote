import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 * User:Zhang Xingkun
 * Date:2021/8/4 23:12
 * Description:
 */
public class TestPing {
    public static void main(String[] args) {
        //1. new Jedis对象即可
        Jedis jedis = new Jedis("127.0.0.1",6379);
        //jedis所有的命令就是官方里的命令
        String ping = jedis.ping();
        System.out.println(ping);
        System.out.println(jedis.flushDB());
        Transaction multi = jedis.multi();
        multi.set("key1","value1");
        List<Object> exec = multi.exec();
        System.out.println(exec);

        jedis.close();
    }
}
