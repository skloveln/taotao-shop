package com.taotao.rest.dao;

public interface JedisClient {

	/**
	 * 获取String型数据
	 * @param key
	 * @return
	 */
	String get(String key);
	
	/**
	 * 存储String型数据
	 * @param key
	 * @param value
	 * @return
	 */
	String set(String key, String value);
	
	/**
	 * 键自增
	 * @param key
	 * @return
	 */
	long incr(String key);
	
	/**
	 * 存储hash型数据
	 * @param hkey
	 * @param key
	 * @param value
	 * @return
	 */
	Long hset(String hkey, String key, String value);
	
	/**
	 * 获取Hash型数据
	 * @param hkey
	 * @param key
	 * @return
	 */
	String hget(String hkey, String key);
	
	/**
	 * 删除String型数据
	 * @param key
	 * @return
	 */
	Long del(String key);
	
	/**
	 * 删除Hash型数据
	 * @param hkey
	 * @param key
	 * @return
	 */
	Long hdel(String hkey, String key);
	
	/**
	 * 设置存储数据的有效期
	 * @param key 键
	 * @param second 存储的有效时间（秒）
	 * @return
	 */
	Long expire(String key, int second);
}
