package com.practice.DS.strings;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class AnagramsTogether {

	public static void main(String[] args) {
		String[] ar = {"cat", "dog", "tac", "god", "act"};
		printAnagramsTogether(ar, ar.length);
	}
	
	private static void printAnagramsTogether(String ar[], int n){
		Map<Integer, String> map = new HashMap<>();
		for(int i=0;i<ar.length;i++){
			map.put(i,ar[i]);
		}
		
		for (Map.Entry<Integer, String> entry : map.entrySet()) {
			char[] ch = entry.getValue().toCharArray();
			Arrays.sort(ch);
			entry.setValue(String.valueOf(ch));
		}
		
		Map<Integer, String> sortedMap =
                map.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue())
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                                (e1, e2) -> e1, LinkedHashMap::new));
		
			
		sortedMap.forEach((k, v)-> System.out.println(ar[k]));
	}

}
