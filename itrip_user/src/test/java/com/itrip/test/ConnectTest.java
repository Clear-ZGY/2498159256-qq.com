package com.itrip.test;

import org.springframework.util.DigestUtils;
import redis.clients.jedis.Jedis;

import java.lang.reflect.Field;
import java.util.Random;
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
        /*Integer a = 1;
        Integer b = 2;
        System.out.println("a="+a+",b="+b);
        ConnectTest.range(a,b);
        System.out.println("a="+a+",b="+b);*/


        for (int i = 0; i <100 ; i++) {
            System.out.println(String.format("%06d", new Random().nextInt(999999)));
        }
    }

    public static void range(Integer i1, Integer i2) {

        try {
            Field f = Integer.class.getDeclaredField("value");
            f.setAccessible(true);
            Integer temp= new Integer(i1.intValue());
            f.set(i1,i2.intValue());
            f.set(i2,temp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
