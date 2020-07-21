package hwg.controller;

import hwg.dao.generate.mapper.CountryMapper;
import hwg.model.Country;
import hwg.queue.QueueExecute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: hwg
 * @Date: Create in 2020/1/13
 */
@RestController
public class ProductController {
    private int a;
    @Autowired
    private CountryMapper countryMapper;
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;
    @Autowired
    JedisPool jedisPool;
    @Autowired
    QueueExecute queueExcute;
    @RequestMapping(value = "/consul", method = RequestMethod.GET)
    public Country consul() {
        Jedis jedis =  jedisPool.getResource();
        String string =jedis.setnx("syn", "syn").toString();
        jedis.expire("syn",20);
        if ("1".equals(string)) {
            System.out.println(jedis.incrBy("key:go:bbb",20));
        }else {
            System.out.println("aaaa");
        }
        jedis.set("key:go:aaa", "20");
        jedis.set("key:go:bbb", "20");

        String bigg = jedis.get("key:k1");
        jedis.persist("key");//设置key不过期
        Country country = countryMapper.selectByPrimaryKey(96925);
        String str = jedis.set("setNxTest","setNxTest","NX","EX",60);
        System.out.println("========="+str);

        return country;
    }

    @RequestMapping(value = "/put", method = RequestMethod.GET)
    public Country put(){
        Thread[] threads = new Thread[20];
        for (int i = 0; i < threads.length; i++) {
            int finalI = i;
            threads[i]=new Thread(){
                @Override
                public void run() {
                    super.run();
                    queueExcute.put("i = "+ finalI);
                }
            };
            threads[i].start();
        }
        Country country = countryMapper.selectByPrimaryKey(96925);
        return country;
    }

    /**
     * 想队列中添加一条数据
     */
    @RequestMapping(value = "/pu2", method = RequestMethod.GET)
    public void pu2(){
        a++;
        try {
            queueExcute.put("put第"+a+"次") ;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 向队列中取一条消息 如队列为空则会阻塞 直到超时 停止从队列中取消息的线程
     * @return
     */
    @RequestMapping(value = "/pool", method = RequestMethod.GET)
    public Country pool(){
        try {
            System.out.println(queueExcute.poll().toString()) ;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Country country = countryMapper.selectByPrimaryKey(96925);
        return country;
    }




}
