package com.scaffold.autoconfigures.redis;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Redis的操作封装接口
 * 
 * @author chababa
 *
 */
public interface RedisService {

	public abstract long del(String... keys);

	public abstract void set(byte[] key, byte[] value, long liveTime);

	public abstract void set(String key, String value, long liveTime);

	public abstract void set(String key, String value);

	public abstract void set(byte[] key, byte[] value);

	public abstract String get(String key);
	public String hget(String key, String hashKey);
	public void hset(String key, String hashKey, String value);
	public List<String> hmget(String key, Collection<String> hashKeys);
	public void hmset(String key, Map<String, String> m);

	public abstract Set<?> keys(String pattern);

	public abstract boolean exists(String key);

	public abstract String flushDB();

	public abstract long dbSize();

	public abstract String ping();
	
	Long lpush(String key, String... values);

	Long rpush(String key, String... values);

	Long lpush(String key, String value);

	Long rpush(String key, String value);

	Set<String> zrange(String key, int start, int end);

	Set<String> zrange(String key);

	Long sadd(String key, String... values);

	Set<String> smembers(String key);

	Boolean zadd(String key, String value, double score);

	void hdel(String key, Object... hashKeys);
}
