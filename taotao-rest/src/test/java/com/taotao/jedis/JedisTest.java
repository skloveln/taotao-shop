package com.taotao.jedis;

import java.util.HashSet;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.taotao.rest.dao.JedisClient;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

public class JedisTest {

//	@Test
	public void testJedis() throws Exception {
		Jedis jedis = new Jedis("192.168.31.200", 7001);
		jedis.set("hello", "1000");
		String string = jedis.get("hello");
		System.out.println(string);
		jedis.close();
	}
	
//	@Test
	public void testJedisPool() throws Exception {
		//创建jedis连接池
		JedisPool pool = new JedisPool("192.168.31.200", 7001);
		//从连接池中获得redis连接
		Jedis jedis = pool.getResource();
		String string = jedis.get("hello");
		System.out.println(string);
		//操作结束关闭连接
		jedis.close();
		//程序结束，关闭连接池
		pool.close();
		
	}
	
//	@Test
	public void testJedisCluster() throws Exception {
		//创建集群的节点
		HashSet<HostAndPort> nodes = new HashSet<>();
		nodes.add(new HostAndPort("192.168.31.200", 7001));
		nodes.add(new HostAndPort("192.168.31.200", 7002));
		nodes.add(new HostAndPort("192.168.31.200", 7003));
		nodes.add(new HostAndPort("192.168.31.200", 7004));
		nodes.add(new HostAndPort("192.168.31.200", 7005));
		nodes.add(new HostAndPort("192.168.31.200", 7006));
		//创建连接
		JedisCluster jedisCluster = new JedisCluster(nodes);
		jedisCluster.set("cid", "123456");
		String string = jedisCluster.get("cid");
		System.out.println(string);
		Long id = jedisCluster.incr("cid");
		System.out.println(id);
		
		//程序结束关闭连接
		jedisCluster.close();
	}
	
//	@Test
	public void testJedisClientSpring(){
		// 加载spring配置文件
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/*.xml");
		// 从容器中获取对象
		JedisClient jedisClient = applicationContext.getBean(JedisClient.class);
		jedisClient.set("you", "ok");
		String string = jedisClient.get("you");
		System.out.println(string);
	}
	
}
