package org.pjesus.ruletree.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CollectionUtils {
	
	public static boolean isEmpty(Collection<?> list) {
		return list == null || list.size() == 0;
	}
	
	public static <T> T getFirstOrDefault(Collection<T> list, T defaultItem) {
		if(isEmpty(list))
			return defaultItem;
		return list.iterator().next();
	}

	public static Collection<Object> map(Collection<?> list, MapCallback callback) {
		List<Object> mapList = new ArrayList<>();
		for(Object item : list)
			mapList.add(callback.map(item));
		return mapList;
	}

	public static Collection<Double> mapToDouble(Collection<?> list, MapCallback callback) {
		List<Double> mapList = new ArrayList<>();
		for(Object item : list)
			mapList.add((Double) callback.map(item));
		return mapList;
	}

	public static Double sum(Collection<Number> list) {
		Double sum = 0.0;
		for(Number number : list) {
			sum += number.doubleValue();
		}
		return sum;
	}

	public static <T> Collection<T> filter(Collection<T> list, FilterCallback callback) {
		List<T> filteredList = new ArrayList<>();
		for(T item : list)
			if(callback.filter(item))
				filteredList.add(item);
		return filteredList;
	}

	public static <T> boolean noneMatch(Collection<T> list, MatchCallback callback) {
		for(T item : list)
			if(callback.match(item))
				return false;
		return true;
	}

	public static <T> boolean anyMatch(Collection<T> list, MatchCallback callback) {
		for(T item : list)
			if(callback.match(item))
				return true;
		return false;
	}

	public static <T> boolean allMatch(Collection<T> list, MatchCallback callback) {
		for(T item : list)
			if(!callback.match(item))
				return false;
		return true;
	}
	
	public interface MapCallback {
		
		Object map(Object item);
	}
	
	public interface FilterCallback {
		
		boolean filter(Object item);
	}
	
	public interface MatchCallback {
		
		boolean match(Object item);
	}
}
