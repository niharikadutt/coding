package com.practice.DS.arrays;

import java.util.HashMap;
import java.util.Map;

public class PairsWithGivenSum {

	public static void main(String[] args) {
		int[] ar = {1, 5, 7, -1};
		System.out.println(getPairsCount(ar, ar.length, 6));
	}

	private static int getPairsCount(int[] ar, int l, int sum) {
		int count=0;
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0;i<l;i++){
			if(map.get(ar[i])!=null)
			map.put(ar[i], map.get(ar[i])+1);
			else
				map.put(ar[i], 1);
		}

		for(int i=0;i<l;i++){
			if(map.get(sum-ar[i])!=null){
				count+=map.get(sum-ar[i]);
				map.put(ar[i], map.get(ar[i])-1);
				map.put(sum-ar[i], map.get(sum-ar[i])-1);			
			}
		}
		
		return count;
	}

}
