package com.practice.DS.arrays;

import java.util.HashMap;
import java.util.Map;

public class PairWithProduct {

	public static void main(String[] args) {
		int[] ar = {10, 20, 9, 40};
		if(pairExist(ar, 400)){
			System.out.println("Exist!");
		}
		else{
			System.out.println("Does Not exist!");
		}
	}
	
	private static boolean pairExist(int[] ar, int sum){
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0;i<ar.length;i++){
			if(map.containsKey(sum/ar[i])){
				return true;
			}
			map.put(ar[i], ar[i]);
		}
		
		return false;
 	}

}
