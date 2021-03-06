package com.taotao.sso.dao.impl;



import org.springframework.beans.factory.annotation.Autowired;

import com.taotao.sso.dao.JedisClient;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


//实现类没有加注解要在bean中配置
public class JedisClientSingle implements JedisClient {

	@Autowired
	private JedisPool jedisPool;
	
	public String get(String key) {
		Jedis jedis = jedisPool.getResource();
		String string = jedis.get(key);
		jedis.close();
		return string;
	}

	public String set(String key, String value) {
		Jedis jedis = jedisPool.getResource();
		String string = jedis.set(key, value);
		jedis.close();
		return string;
	}


	public long hset(String hkey, String key, String value) {
		Jedis jedis = jedisPool.getResource();
		Long string = jedis.hset(hkey, key, value);
		jedis.close();
		return string;
	}

	public String hget(String hkey, String key) {
		Jedis jedis = jedisPool.getResource();
		String string = jedis.hget(hkey, key);
		jedis.close();
		return string;
	}

	public long incr(String key) {
		Jedis jedis = jedisPool.getResource();
		long result = jedis.incr(key);
		jedis.close();
		return result;
	}


	public long expire(String key, int second) {
		
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.expire(key, second);
		jedis.close();
		return result;

	}


	public long ttl(String key) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.ttl(key);
		jedis.close();
		return result;

	}

	
	public long del(String key) {
		Jedis jedis = jedisPool.getResource();
		Long string = jedis.del(key);
		jedis.close();
		return string;
	}

	
	public long hdel(String hkey, String key) {
		Jedis jedis = jedisPool.getResource();
		Long string = jedis.hdel(hkey,key);
		jedis.close();
		return string;

	}

}
