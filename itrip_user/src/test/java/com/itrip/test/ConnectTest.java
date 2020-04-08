package com.itrip.test;

import org.springframework.util.DigestUtils;
import redis.clients.jedis.Jedis;

import java.util.zip.CRC32;

public class ConnectTest {
    public static void main(String[] args) {
        /*Jedis jedis = new Jedis("127.0.0.1");
        System.out.println("数据库连接成功");
        jedis.set("address","China");
        //查看服务是运行
        System.out.println("服务正在运行："+jedis.ping());
        System.out.println("数据插入成功");
        jedis.close();*/
        Integer a = new Integer(1);
        Integer b = new Integer(2);
        System.out.println("a="+a+",b="+b);
        ConnectTest.range(a,b);
        System.out.println("a="+a+",b="+b);
    }

    public static void range(Integer i1, Integer i2) {
        Integer temp = null;
        temp = i1;
        i1 = i2;
        i1 = temp;
    }
}
