package com.yexj.yougo.common.entity;


import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * sql结果集转实体
 * @Author donglu
 * @Date 2016-12-26
 */
public class PageData extends HashMap implements Map,Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private transient Map map = null;

	public PageData() {
		map = new HashMap<String,Object>();
	}

	public String getString(Object key) {
		return (String)get(key);
	}
	
//	@SuppressWarnings("unchecked")
//	@Override
//	public Object put(Object key, Object value) {
//		String newKey= StringTools.replaceUnderlineAndfirstToUpper((String) key, "_", "");
//		map.put(newKey, value);
//		//map.put(key, value);
//		return map;
//	}
	
	@Override
	public Object remove(Object key) {
		return map.remove(key);
	}

	public void clear() {
		map.clear();
	}

	public boolean containsKey(Object key) {
		// TODO Auto-generated method stub
		return map.containsKey(key);
	}

	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return map.containsValue(value);
	}

	public Set entrySet() {
		// TODO Auto-generated method stub
		return map.entrySet();
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return map.isEmpty();
	}

	public Set keySet() {
		// TODO Auto-generated method stub
		return map.keySet();
	}

	@SuppressWarnings("unchecked")
	public void putAll(Map t) {
		// TODO Auto-generated method stub
		map.putAll(t);
	}

	public int size() {
		// TODO Auto-generated method stub
		return map.size();
	}

	public Collection values() {
		// TODO Auto-generated method stub
		return map.values();
	}
	
}
