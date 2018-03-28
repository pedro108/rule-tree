package org.pjesus.ruletree.utils;

import java.util.HashMap;
import java.util.Map;

public class MapUtils {

	public static Map<String, Object> create(Object... items) throws RuntimeException {
		Map<String, Object> map = new HashMap<>();
		if(items == null || items.length == 0)
			return map;
		if(items.length % 2 != 0)
			throw new RuntimeException("Even number of items needed");
		
		for(int i=0; i<items.length; i+=2) {
			String key = (String) items[i];
			Object value = items[i+1];
			map.put(key, value);
		}
		
		return map;
	}
}
